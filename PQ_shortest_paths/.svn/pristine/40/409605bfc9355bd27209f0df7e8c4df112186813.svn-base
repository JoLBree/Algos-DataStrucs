//
// PRIORITYQUEUE.H
// A priority queue class supporting sundry operations needed for
// Dijkstra's algorithm.  This class is a template over some
// value type T.  To create a queue that works on objects of class
// Foo, declare, e.g., "PriorityQueue<Foo> x;".
//
// You should implement all the class methods in this header file,
// since the class definition must be visible at the point that the
// template is instantiated.
//
#ifndef __PRIORITYQUEUE_H
#define __PRIORITYQUEUE_H

#include <iostream>

#include "Handle.h"  // you'll need to define the Handle type

template <class T>
class PriorityQueue {
public:

  // constructor
  //
  PriorityQueue(void)
  {
  }
  
  // destructor
  ~PriorityQueue(void)
  {
  }
  
  // Return true iff the queue is empty.
  //
  bool isEmpty(void)
  {
    return true;
  }
    
  // Insert a pair (key, value) into the queue, and return
  // a Handle to this pair so that we can find it later in
  // constant time.
  //
  Handle *insert(int key, T value)
  {
    return 0;
  }
    
  // Return the smallest key in the queue.
  //
  int min(void)
  {
    return 0;
  }
  
  // Extract the (key, value) pair associated with the smallest
  // key in the queue and return its "value" object.
  //
  T extractMin(void)
  {
    return T(0);
  }
    
    
  // Look at the (key, value) pair referenced by Handle h.
  // If that pair is no longer in the queue, or its key
  // is <= newkey, do nothing and return false.  Otherwise,
  // replace "key" by "newkey", fixup the queue, and return
  // true.
  //
  bool decreaseKey(Handle *h, int newkey)
  {
    return false;
  }
  
    
  // Get the key of the (key, value) pair associated with a 
  // given Handle. (This result is undefined if the handle no longer
  // refers to a pair in the queue.)
  //
  int handleGetKey(Handle *h)
  {
    return 0;
  }

  // Get the value object of the (key, value) pair associated with a 
  // given Handle. (This result is undefined if the handle no longer
  // refers to a pair in the queue.)
  //
  T handleGetValue(Handle *h)
  {
    return T(0);
  }
  
  // Here's how you give your operator<< for PriorityQueues access to
  // the guts of the queue.
  //
  template <class U>
  friend std::ostream &operator<< (std::ostream &, PriorityQueue<U> &);
};

  
// Print every element of the queue in the order in which it appears
// in the implementation (i.e. the array representing the heap).
//
template <class T>
std::ostream &operator<<(std::ostream &os, PriorityQueue<T> &q)
{
  os << "not implemented yet\n";
  
  return os;
}

#endif
