/**
 * Josephine Lee
 * leejosephines@wustl.edu
 * CSE241 lab 1
 * ClosestPairNaive.java
 */

public class ClosestPairNaive {
    
    public final static double INF = java.lang.Double.POSITIVE_INFINITY;
    
    //
    // findClosestPair()
    //
    // Given a collection of nPoints points, find and ***print***
    //  * the closest pair of points
    //  * the distance between them
    // in the form "NAIVE (x1, y1) (x2, y2) distance"
    //
    
    // INPUTS:
    //  - points sorted in nondecreasing order by X coordinate
    //  - points sorted in nondecreasing order by Y coordinate
    //
    
    public static void findClosestPair(XYPoint points[], boolean print)
    {
    	int nPoints = points.length;   	
    	double minDist = Double.POSITIVE_INFINITY;
    	int pointOneIndex = 0;
    	int pointTwoIndex = 0;
    	
    	if (nPoints == 1) {} // base cases
    	else if (nPoints == 2) {
    		pointTwoIndex = 1;
    		minDist = points[0].dist(points[1]);
    	} 
    	else{	// search all pairs of points
    		for(int i = 0; i < nPoints-1; i++){
        		for(int j = i+1; j < nPoints;j++){
        			double dist = points[i].dist(points[j]);
        			if (dist < minDist) {
        				minDist = dist;
        				pointOneIndex = i;
        				pointTwoIndex = j;
        			}
        		}
        	}
    	}	   	
    	if (print) System.out.println("NAIVE " + points[pointOneIndex].toString() + " " + points[pointTwoIndex].toString() + " " + minDist);
    }
    }
