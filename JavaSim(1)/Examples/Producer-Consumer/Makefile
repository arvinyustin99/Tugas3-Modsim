MAKE = make

JAVA  = javac

JAVA_FLAGS = -classpath '/home/judhi/cource/MODEL-SIMULASI/JavaSim/classes:.' 

SOURCES	= Job.java Consumer.java Producer.java \
	  Controller.java Queue.java Main.java

all: Job.class Consumer.class Producer.class \
     Controller.class Queue.class Main.class

Job.class: Job.java
	$(JAVA) $(JAVA_FLAGS) Job.java

Consumer.class: Consumer.java
	$(JAVA) $(JAVA_FLAGS) Consumer.java

Producer.class: Producer.java
	$(JAVA) $(JAVA_FLAGS) Producer.java

Controller.class: Controller.java
	$(JAVA) $(JAVA_FLAGS) Controller.java

Queue.class: Queue.java
	$(JAVA) $(JAVA_FLAGS) Queue.java

Main.class: Main.java
	$(JAVA) $(JAVA_FLAGS) Main.java

clean:
	rm -rf *.class *~*

purge: clean
