//
// EVENTLIST.H
// Interface for your EventList collection type.
//

#ifndef __EVENTLIST_H
#define __EVENTLIST_H

#include <vector>
#include <string>

#include "Event.h"

class EventList {
public:
  EventList();
  ~EventList();
  
  //
  // Add an Event to the list.
  //
  void insert(Event *e);
  
  //
  // Remove all Events in the list with the specified year.
  //
  void remove(int year);
  
  //
  // Find all events with greatest year <= input year
  //
  std::vector<Event *> *findMostRecent(int year);
  
  //
  // Find all Events within the specific range of years (inclusive).
  //
  std::vector<Event *> *findRange(int first, int last);
  
private:
  
  int randomHeight();
};

#endif
