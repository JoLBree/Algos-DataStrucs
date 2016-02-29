//
// POINT.H
// A 2D Point class
//

#ifndef __POINT_H
#define __POINT_H

#include <iostream>

class Point {
public:
  Point(void);
  Point(int x, int y);
  
  int x;
  int y;
  
  // distance from this point to another
  double dist(const Point *other) const;
  
  // return true iff this point is to the left of "other"
  bool isLeftOf(const Point *other) const
  { return (x < other->x || (x == other->x && num < other->num)); }
  
  // return true iff this point is below "other".
  bool isBelow(const Point *other) const
  { return (y < other->y || (y == other->y && num < other->num)); }
  
private:
  
  // unique point id, useful in debugging
  int num;
};

// functions to print points
std::ostream& operator <<(std::ostream&, const Point &); // given a point
std::ostream& operator <<(std::ostream&, const Point *); // given a ref to a point

#endif
