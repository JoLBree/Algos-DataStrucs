#ifndef __COMPAREPOINTS_H
#define __COMPAREPOINTS_H

#include "Point.h"

// Point Comparator functions for sort()

// compares p1 and p2 based on the x-coord
struct _lessThanX {
  bool operator() (const Point *p1, const Point *p2)
  { 
    return (p1->isLeftOf(p2));
  }
} lessThanX;

// compares p1 and p2 based on the y-coord
struct _lessThanY {
  bool operator()(const Point *p1, const Point *p2)
  { 
    return (p1->isBelow(p2));
  }
} lessThanY;

#endif
