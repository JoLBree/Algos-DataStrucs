#ifndef __STRINGTABLE_H
#define __STRINGTABLE_H

#include "Record.h"

class StringTable {
public:
  StringTable(int maxSize, int matchLength);
  
  bool insert(Record *r);
  
  void remove(Record *r);
  
  Record *find(const char *key);
  
private:
  int matchLength;
  
  int toHashKey(const char *s) const;
  int baseHash(int hashKey) const;
  int stepHash(int hashKey) const;
};

#endif
