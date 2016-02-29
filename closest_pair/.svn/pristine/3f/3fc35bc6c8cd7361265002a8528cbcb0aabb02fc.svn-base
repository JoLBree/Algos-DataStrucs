//
// MAIN.CC
// Main driver code for CSE 241 Closest Pair lab.
//
// WARNING: ANY CHANGES YOU MAKE TO THIS FILE WILL BE DISCARDED BY THE
// AUTO-GRADER!  Make sure your code works with the unmodified
// original driver before you turn it in.  (You may wish to modify
// your local copy to do the timing experiments requested by the lab.)

#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>
#include <limits>

#include <cstdlib>
#include <cmath>
#include <ctime>

#include "ClosestPairDC.h"
#include "ClosestPairNaive.h"

#include "Point.h"
#include "ComparePoints.h"
#include "Timer.h"
#include "Prng.h"

using namespace std;

// Random seed, used when generating points at random.
static int seed = 87654321;

// local prototypes
static Point **genPointsAtRandom(int, PRNG *);
static Point **readXYPoints(const char *, int *);


int main(int argc, char *argv[])
{
  PRNG prng(seed);  // seed the random number generator
  Point ** points;
  int nPoints;
  string fileName;
  
  // only argument is the input spec
  if (argc > 1)
    {
      fileName = argv[1];
    }
  else
    {
      cerr << "Syntax: Main [ <filename> | @<nPoints> ]\n";
      exit(1);
    }
  
  // A filename argument of the form '@x', where x is a non-negative
  // integer, allocates x random points.  Any other argument is
  // assumed to be a file from which points are read.
  
  if (fileName[0] != '@')
    {
      points = readXYPoints(argv[1], &nPoints);
    }
  else
    {
      nPoints = strtoul(fileName.substr(1).c_str(), nullptr, 10);
      
      points = nullptr;
    }
  
  if (nPoints < 2)
    {
      cerr << "ERROR: input must contain at least two points\n";
      exit(1);
    }
  
  // Generate a set of points if one was not read.
  // When timing, call genPointsAtRandom() as shown
  // each time you want a new set of points, but
  // be sure to delete both the points and the array
  // after using them and before generating the next
  // set of points.
  
  if (!points)
    points = genPointsAtRandom(nPoints, &prng);
  
  // run DC algorithm
  {
    Timer timer;  
    
    timer.start();
    
    //////////////////////////////////////////////////////////////////////////
    // DC CLOSEST-PAIR ALGORITHM STARTS HERE

    // Ensure sorting precondition for divide-and-conquer CP
    // algorithm.  NB: you should *not* have to call sort() in
    // your own code!
    
    Point **pointsByX = new Point * [nPoints];
    Point **pointsByY = new Point * [nPoints];
    
    // The algorithm expects two arrays containing the same points.
    std::copy(points, points + nPoints, pointsByX);
    std::copy(points, points + nPoints, pointsByY);
    
    sort(pointsByX, pointsByX + nPoints, lessThanX); // sort by x-coord
    sort(pointsByY, pointsByY + nPoints, lessThanY); // sort by y-coord
    
    findClosestPairDC(pointsByX, pointsByY, nPoints, true);
    
    delete [] pointsByX;   // free storage from array ptsByX of pt refs 
    delete [] pointsByY;   // free storage from array ptsByY of pt refs
    
    // DC CLOSEST-PAIR ALGORITHM ENDS HERE
    //////////////////////////////////////////////////////////////////////////
    
    timer.stop();
    
    cout << "For n = " << nPoints << ", the elapsed time is ";
    cout << timer.elapsedTime() << " milliseconds\n\n";
  }
  
  // run naive algorithm
  {
    Timer timer;
    
    timer.start();
    
    findClosestPairNaive(points, nPoints, true);
    
    timer.stop();
    
    cout << "For n = " << nPoints << ", the naive elapsed time is ";
    cout << timer.elapsedTime() << " milliseconds\n\n";
  }
  
  for (int j = 0; j < nPoints; j++)
    delete points[j];  // free storage from points themselves
  delete [] points;
  
  return 0;
}


//
// genPointsAtRandom()
// Generate a new array of nPoints points uniformly at random.
//
static Point ** genPointsAtRandom(int nPoints, PRNG *prng)
{
  double x = 0.0;
  double y = 0.0;
  
  Point **points = new Point * [nPoints];

  double step = sqrt(nPoints);
  
  for (int j = 0; j < nPoints; j++)
    {
      // bump next point's X coordinate
      x += 10000.0 * (prng->nextDouble() - 0.5);
      
      // move the Y coordinate a random amount up,
      // while keeping it within limits [0 .. nPoints)
      y = (y + step * prng->nextDouble());
      while (y > nPoints)
	y -= nPoints;
	   
      Point *p = new Point;
      p->x = (int) rint(x); // set x and y coords of point
      p->y = (int) rint(y);
      
      points[j] = p;
    }
  
  return points;
}


//
// readXYPoints()
// Read a collection of points from an input file.
// The first line of the file should give the number of points
// to read.  Each subsequent line should give the coordinates of
// one point in the form "x y".
//
// RETURNS: array of pointers to Point structures
// SETS: *inPoints to length of array
//
static Point **readXYPoints(const char *pointFileName, int *inPoints)
{
  ifstream pointFile(pointFileName);
  int nPoints;
  
  if (!pointFile)
    {
      cerr << "Error: could not open point file '"
	   << pointFileName << "'" << endl;
      exit(1);
    }
  
  pointFile >> nPoints;
  
  if (nPoints < 2)
    {
      cerr << "Error: need at least two points!" << endl;
      exit(1);
    }
  
  Point **points = new Point * [nPoints];
  
  for (int j = 0; j < nPoints; j++)
    {
      int x, y;
      
      pointFile >> x;
      pointFile >> y;
      
      if (!pointFile)
	{
	  cerr << "Error: could not read point #" << j << endl;
	  exit(1);
	}
      
      Point *p = new Point(x,y);
      
      points[j] = p;
    }
  
  *inPoints = nPoints;
  
  return points;
}
