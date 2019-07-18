JAVAC = javac
JAVA = java
CLASSPATH = . 

init:
	$(JAVAC) JLex/*.java
	$(JAVAC) java_cup/runtime/*.java
	$(JAVAC) java_cup/*.java

parse: L-0.cup
	$(JAVA) -classpath $(CLASSPATH) java_cup.Main L-0.cup

lex: L-0.jlex
	$(JAVA) JLex.Main L-0.jlex
	mv L-0.jlex.java Yylex.java

build: sym.java parser.java Yylex.java
	$(JAVAC) sym.java parser.java Yylex.java

all:
	$(JAVA) -classpath $(CLASSPATH) java_cup.Main L-0.cup
	$(JAVA) JLex.Main L-0.jlex
	mv L-0.jlex.java Yylex.java
	$(JAVAC) sym.java parser.java Yylex.java

run:
	$(JAVA) -classpath $(CLASSPATH) parser

test:
	$(JAVA) -classpath $(CLASSPATH) parser < test.pl

clean:
	-rm *.class
	-rm Yylex.java
	-rm parser.java
	-rm sym.java

vclean:
	-rm *.class
	-rm Yylex.java
	-rm parser.java
	-rm sym.java
	-rm java_cup/*.class
	-rm java_cup/runtime/*.class
	-rm JLex/*.class
