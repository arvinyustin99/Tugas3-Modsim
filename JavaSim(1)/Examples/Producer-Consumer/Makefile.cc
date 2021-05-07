# Makefile generated by imake - do not edit!
# $TOG: imake.c /main/102 1998/02/06 11:02:33 kaleb $

#
# Make generated for LINUX 2 - "i386"
#

SHELL = /bin/sh
TOPDIR = /home/C++SIM

CURDIR = .

MAKE = make
IMAKE = imake

MAKEDEPEND = $(TOPDIR)/bin/makedepend

CPLUSPLUS = "g++"
CPLUSPLUS_CROSS = "g++"

AR = ar
SED = sed
RANLIB = ranlib
PURIFY = "exec"
YACC = YACC_PROGRAM
LEX = LEX_PROGRAM

MV = mv
CP = cp
RM = rm -f
CAT = cat
MKDIR = mkdir
CHMOD = chmod

ARFLAGS = rv
xMAKEFLAGS = -j 1 -l 1 --no-print-directory
IMAKEFLAGS = -TConfig/Arjuna.tmpl -I""$(TOPDIR)/Include $(CPPFLAGS) $(THREAD_CPPFLAGS)
STUBFLAGS = +w +V
MAKEDEPENDFLAGS = -I""$(CPLUSPLUSINCLUDE) -I""$(TOPDIR)/Include

YACCFLAGS = -v -d
LEXFLAGS =
IV_CPPFLAGS = IV_CPPFLAGS_DEFAULT
IV_LDFLAGS = IV_LDFLAGS_DEFAULT
X11_LDFLAGS = X11_LDFLAGS_DEFAULT

CPLUSPLUSINCLUDE = /usr/include/g++-3

INSTALL_TOPDIR = /usr/local/C++SIM

LIBCOMMON = $(TOPDIR)/lib/libCommon.a

LIBCPPSIM = $(TOPDIR)/lib/libC++SIM.a

LIBEVENT = $(TOPDIR)/lib/libEvent.a

LIBSIMSET = $(TOPDIR)/lib/libSimSet.a

LIBSTAT = $(TOPDIR)/lib/libStat.a

LIBCONTRIB =

ARJUNA_INCLUDES = $(TOPDIR)/Include

all :: Makefile

#
# Copyright (C) 1994
#
# Department of Computing Science,
# The University,
# Newcastle upon Tyne,
# UK.
#
# $Id: Imakefile,v 1.2 1996/12/20 15:29:49 nmcl Exp $
#

SOURCES  = Producer.cc 	   Consumer.cc 	   Controller.cc 	   Queue.cc 	   Job.cc 	   Main.cc

OBJECTS  = Producer.o 	   Consumer.o 	   Controller.o 	   Queue.o 	   Job.o 	   Main.o

LIBRARIES = $(LIBEVENT) $(LIBCONTRIB) $(LIBCPPSIM) $(LIBCONTRIB) $(LIBCPPSIM) $(LIBCOMMON)

LOCAL_CPPFLAGS = -I$(ARJUNA_INCLUDES)

all :: all.local
all.local : Main
	@echo Made $? [in $(CURDIR) ] as $@

Main : $(OBJECTS) $(LIBRARIES)
	@echo Linking $@
	@eval $(PURIFY) $(CPLUSPLUS) $(LOCAL_LDFLAGS) $(LDFLAGS) -o Main $(OBJECTS) $(LIBRARIES)  $(LOCAL_LIBRARIES) $(xLIBRARIES)

Producer.o : Producer.cc
	@echo Compiling $@
	@exec $(CPLUSPLUS) -c  $(LOCAL_CPPFLAGS) $(CPPFLAGS) $(LOCAL_CPLUSPLUSFLAGS) $(CPLUSPLUSFLAGS) Producer.cc

Consumer.o : Consumer.cc
	@echo Compiling $@
	@exec $(CPLUSPLUS) -c  $(LOCAL_CPPFLAGS) $(CPPFLAGS) $(LOCAL_CPLUSPLUSFLAGS) $(CPLUSPLUSFLAGS) Consumer.cc

Controller.o : Controller.cc
	@echo Compiling $@
	@exec $(CPLUSPLUS) -c  $(LOCAL_CPPFLAGS) $(CPPFLAGS) $(LOCAL_CPLUSPLUSFLAGS) $(CPLUSPLUSFLAGS) Controller.cc

Queue.o : Queue.cc
	@echo Compiling $@
	@exec $(CPLUSPLUS) -c  $(LOCAL_CPPFLAGS) $(CPPFLAGS) $(LOCAL_CPLUSPLUSFLAGS) $(CPLUSPLUSFLAGS) Queue.cc

Job.o : Job.cc
	@echo Compiling $@
	@exec $(CPLUSPLUS) -c  $(LOCAL_CPPFLAGS) $(CPPFLAGS) $(LOCAL_CPLUSPLUSFLAGS) $(CPLUSPLUSFLAGS) Job.cc

Main.o : Main.cc
	@echo Compiling $@
	@exec $(CPLUSPLUS) -c  $(LOCAL_CPPFLAGS) $(CPPFLAGS) $(LOCAL_CPLUSPLUSFLAGS) $(CPLUSPLUSFLAGS) Main.cc

tidy :: tidy.local

tidy.local ::
	@$(RM) core *~ \#*\# *.bak *.BAK *\%

clean :: clean.local

clean.local :: tidy.local
	@$(RM) -f .dummy $(OBJECTS)

purge :: purge.local

purge.local :: clean.local
	@$(RM) -f Makefile Main *.stamp

CPPFLAGS =  -DPTHREAD_DRAFT_6 -DPOSIX_THREAD -DHAVE_BOOLEAN_TYPE -DHAVE_WCHAR_TYPE -DHAVE_LONG_LONG -DGCC_STATIC_INIT_BUG -DMEMFNS_IN_STRING_H -DNEED_MALLOC_T -DHAVE_MSGCONTROL -D__LINUX__ -DSYSV -D__CONSTVALUE="" -D__CONSTVALUE2="" -D__NORETURN="" -D__NORETURN2="" -DLITTLE_ENDIAN_MC  -DProcessList_Queue
CPLUSPLUSFLAGS =
LDFLAGS =
xLIBRARIES = -lm -lpthread

CPPFLAGS_CROSS =  -DHAVE_BOOLEAN_TYPE -DHAVE_WCHAR_TYPE -DHAVE_LONG_LONG -DGCC_STATIC_INIT_BUG -DMEMFNS_IN_STRING_H -DNEED_MALLOC_T -DHAVE_MSGCONTROL -D__LINUX__ -DSYSV -D__CONSTVALUE="" -D__CONSTVALUE2="" -D__NORETURN="" -D__NORETURN2="" -DLITTLE_ENDIAN_MC
CPLUSPLUSFLAGS_CROSS =
LDFLAGS_CROSS =
xLIBRARIES_CROSS = -lm

Makefile :: Imakefile
	@echo
	@echo "***"
	@echo "*** WARNING : "$(CURDIR)"/Makefile may be out of date,"
	@echo "***         : older than "$(CURDIR)"/Imakefile"
	@echo "***"

Makefile :: $(TOPDIR)/Include/Config/m_i386.cf
	@echo
	@echo ***
	@echo *** WARNING : $(CURDIR)/Makefile may be out of date,
	@echo ***         : older than $(TOPDIR)/Include/Config/m_i386.cf
	@echo ***

Makefile :: $(TOPDIR)/Include/Config/s_linux_2_0.cf
	@echo
	@echo ***
	@echo *** WARNING : $(CURDIR)/Makefile may be out of date,
	@echo ***         : older than $(TOPDIR)/Include/Config/s_linux_2_0.cf
	@echo ***

Makefile :: $(TOPDIR)/Include/Config/c_gcc_2_7.cf
	@echo
	@echo ***
	@echo *** WARNING : $(CURDIR)/Makefile may be out of date,
	@echo ***         : older than $(TOPDIR)/Include/Config/c_gcc_2_7.cf
	@echo ***

Makefile :: $(TOPDIR)/Include/Config/Arjuna.tmpl
	@echo
	@echo "***"
	@echo "*** WARNING : "$(CURDIR)"/Makefile may be out of date,"
	@echo "***         : older than "$(TOPDIR)"/Include/Config/Arjuna.tmpl"
	@echo "***"

Makefile :: $(TOPDIR)/Include/Config/Flag.def
	@echo
	@echo "***"
	@echo "*** WARNING : "$(CURDIR)"/Makefile may be out of date,"
	@echo "***         : older than "$(TOPDIR)"/Include/Config/Flag.def"
	@echo "***"

Makefile :: $(TOPDIR)/Include/Config/Configure.h
	@echo
	@echo "***"
	@echo "*** WARNING : "$(CURDIR)"/Makefile may be out of date,"
	@echo "***         : older than "$(TOPDIR)"/Include/Config/Configure.h"
	@echo "***"

Makefile :: $(TOPDIR)/Include/Config/Macro.def
	@echo
	@echo "***"
	@echo "*** WARNING : "$(CURDIR)"/Makefile may be out of date,"
	@echo "***         : older than "$(TOPDIR)"/Include/Config/Macro.def"
	@echo "***"

Makefile :: $(TOPDIR)/Include/Config/Make.def
	@echo
	@echo "***"
	@echo "*** WARNING : "$(CURDIR)"/Makefile may be out of date,"
	@echo "***         : older than "$(TOPDIR)"/Include/Config/Make.def"
	@echo "***"

Makefile :: $(TOPDIR)/Include/Config/Lib.def
	@echo
	@echo "***"
	@echo "*** WARNING : "$(CURDIR)"/Makefile may be out of date,"
	@echo "***         : older than "$(TOPDIR)"/Include/Config/Lib.def"
	@echo "***"

Makefile :: $(TOPDIR)/Include/Config/Prog.def
	@echo
	@echo "***"
	@echo "*** WARNING : "$(CURDIR)"/Makefile may be out of date,"
	@echo "***         : older than "$(TOPDIR)"/Include/Config/Prog.def"
	@echo "***"

Makefile :: $(TOPDIR)/Include/Config/Rule.def
	@echo
	@echo "***"
	@echo "*** WARNING : "$(CURDIR)"/Makefile may be out of date,"
	@echo "***         : older than "$(TOPDIR)"/Include/Config/Rule.def"
	@echo "***"

Makefile :: $(TOPDIR)/Include/Config/StdParam.def
	@echo
	@echo "***"
	@echo "*** WARNING : "$(CURDIR)"/Makefile may be out of date,"
	@echo "***         : older than "$(TOPDIR)"/Include/Config/StdParam.def"
	@echo "***"

Makefiles ::

all :: all.local

all.local :

depend :: depend.local

depend.local :: $(SOURCES)
	@CC=$(CPLUSPLUS) $(MAKEDEPEND) $(LOCAL_CPPFLAGS) $(CPPFLAGS) $(LOCAL_MAKEDEPENDFLAGS) $(MAKEDEPENDFLAGS) $(SOURCES)

tidy :: tidy.local

tidy.local ::
	@$(RM) core *~ \#*\# *.bak *.BAK *\%

clean :: clean.local

clean.local :: tidy.local
	@$(RM) -f .dummy $(OBJECTS)

purge :: purge.local

purge.local :: clean.local
	@$(RM) -f Makefile $(OBJECTS) *.stamp

Makefile_ ::
	@echo Making $@ [in $(CURDIR) ]
	@$(IMAKE) $(IMAKEFLAGS);$(MV) Makefile Makefile.sed;$(SED) -e '/^COMMENT$$/s//#/' -e '/^COMMENT /s//# /' -e 's/\%\%/\\"/g' < Makefile.sed > Makefile;$(RM) Makefile.sed

install :: install.local

install :: all.local

install.local ::

