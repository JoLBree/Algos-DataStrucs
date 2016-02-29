//
// PRNG.H
// A simple linear-congruential PRNG, included here so that the
// Java and C++ codes produce the same random numbers.
//
// Note that we must do all our work in unsigned arithmetic to
// match Java's wrapping semantics for integer overflow.

#ifndef __PRNG_H
#define __PRNG_H

typedef unsigned long long uint64;

class PRNG {
public:
  
  PRNG(uint64 seed) 
  {
    state = ((seed ^ A) & (M - 1));
    for (int j = 0; j < 100; j++)
      next();
  }
  
  // return a floating-point value in the range [0, 1)
  double nextDouble()
  {
    uint64 v = next();
    return (double) v / (double) (1LL << 32);
  }
  
  ///////////////////////////////////////////////////
  
private:
  
  static const uint64 M = (1ULL << 48);
  static const uint64 A = 25214903917ULL;
  static const uint64 C = 11ULL;
			   
  uint64 state;
  
  // return an integer in the range [0, 2^32)
  uint64 next()
  {
    state = (A * state + C) & (M - 1);
    return  (state >> 16);
  }
};

#endif
