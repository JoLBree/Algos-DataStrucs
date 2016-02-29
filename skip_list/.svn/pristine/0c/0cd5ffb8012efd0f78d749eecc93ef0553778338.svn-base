//
// EVENT.H
//
// Describes a historical event via two public fields:
//  year        -- the year of the event (an integer)
//  description -- the text for the event (a string)
//

#ifndef __EVENT_H
#define __EVENT_H

#include <iostream>
#include <vector>
#include <string>

class Event {
public:
  
  int year;                          // the year of the event
  std::string description;           // the event description
  
  // constructor
  Event(int iyear, std::string idescription)
    : year{iyear}, description{idescription}
  {}
};

// print method  
inline std::ostream &operator<<(std::ostream &os, const Event &e)
{
  os << e.year << ' ' << e.description;
  return os;
}

#endif
