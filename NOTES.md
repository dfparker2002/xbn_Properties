### Properties NOTES:

In case you find some of the notes in [the Camel Properties Component online documentation] a bit cryptic, running these tests and seeing the code behind them might get you along your way a bit faster.

There are still some opportunities for confusion, even after being demonstrated by using a running example project:

 * Multiple ways to specify the properties file (only 2 shown here)
 * All the normal system properties and environment variables, and over-rides of same that any program could access.
 * Some additional opportunities for bringing in properties - see Exclusions section below
 
### Duplicate Tests

There are two sets of identical tests - excepting each points to a different context.xml

The idea was to prove that the same tests could be run no matter which of the two ways to specify the properties input file.

###  Exclusions:

This project does not even attempt to demonstrate the following ways of specifying and/or consuming properties. This is not because they are not important, rather that the project was already too much detail, for a single x__project.

 * Specifying a properties file with the java DSL and CamelTestSupport
 * XML DSLs
 * All things OSGi and Blueprint
 * All things Spring and spring bridge
 
### To Run

Run each of BeanScopeTest and CamelContextScopeTest