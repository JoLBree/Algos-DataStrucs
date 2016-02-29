//
// EVENTLIST.CC
// Skeleton code for your EventList collection type.
//

#include <iostream>
#include <cstdlib>

#include "EventList.h"

using namespace std;

////////////////////////////////////////////////////////////////////
// Here's a suitable geometric random number generator for choosing
// pillar heights.  We treat the middle bit of each random number
// generated as a random coin flip.
////////////////////////////////////////////////////////////////////

int EventList::randomHeight()
{
  int v = 1;
  while ((rand() >> 16) & 0x01) { v++; }
  return v;
}

////////////////////////////////////////////////////////////////////
// Methods for the Lab
////////////////////////////////////////////////////////////////////

//
// Constructor
//
EventList::EventList()
{
  srand(5910113); // you may seed the PRNG however you like.
}


//
// Destructor
//
EventList::~EventList()
{
}


//
// Add an Event to the list.
//
void EventList::insert(Event *e)
{
}


//
// Remove all Events in the list with the specified year.
//
void EventList::remove(int year)
{
}


//
// Find all events with greatest year <= input year.
//
vector<Event *> *EventList::findMostRecent(int year)
{
  return nullptr;
}


//
// Find all Events within the specific range of years (inclusive).
//
vector<Event *> *EventList::findRange(int first, int last)
{
  return nullptr;
}
