#
# CSE 241/502 Lab Makefile
#

##############################################################
# Compiler and flags to use.  Note that these settings
# will be overridden by the autograder.
##############################################################

CXX       = g++
CXXFLAGS  = -g -O2 -Wall -std=c++11

##############################################################
# List of source files.  If you add .cc files to your lab
# that contain any non-template code, add them to the list
# below to ensure that they will be compiled.
##############################################################

LAB_SRC  = ShortestPaths.cc Input.cc Main.cc \
             PQTest.cc PrettyTime.cc \
	     Query.cc QueryReader.cc Tokenizer.cc


##############################################################
# You shouldn't have to change anything below this line.
##############################################################

LAB = Main

LAB_EXE = $(LAB)
LAB_OBJ = $(patsubst %.cc,%.o,$(LAB_SRC))

###

$(LAB_EXE): $(LAB_OBJ)
	$(CXX) -o $(LAB_EXE) $(LAB_OBJ) -lm

all: $(LAB)

clean:
	rm -f $(LAB_EXE) $(LAB_OBJ) .depend

.PHONY: clean

###

.cc.o:
	$(CXX) $(CXXFLAGS) -c $<


###

.depend:
	$(CXX) $(CXXFLAGS) -MM *.cc > .depend

-include .depend
