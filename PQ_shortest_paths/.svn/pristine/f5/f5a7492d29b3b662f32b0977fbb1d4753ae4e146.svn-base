//
// SHORTESTPATHS.H
// Compute shortest paths in a graph.
//

#ifndef __SHORTESTPATHS_H
#define __SHORTESTPATHS_H

#include <vector>

#include "Input.h"
#include "Multigraph.h"

class ShortestPaths {
public:
  ShortestPaths(const Multigraph *G, int startId,
		const Input *input, int startTime);
  
  ~ShortestPaths();
  
  std::vector<int> returnPath(int endId) const;
};

#endif
