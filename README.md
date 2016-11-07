# Class-Templates-Generator
Java Application which quickly generates Java projects with blank-class-files, that will be ready to be filled with Your code

# Manual Contents
* [Command line arguments](#command-line-arguments)

* [Syntax in file](#syntax-in-file)

* [Example of full command-file](#example-of-full-command-file)

## Command line arguments :arrow_right:

You should specify exactly 2 arguments at command line

* 1st is: [path to file, which contains commands]

* 2nd is: [desired name of output directory for generated code-files] IN OTHER WORDS [desired relative path of root of the created project]

For example:

> classnames.txt output_project

## Syntax in file :pencil2:

### First String is in format PACKAGE_NAME.CLASS_NAME
Examples:

* pl.sadowski.Mario

* pl.mycompany.ClassB
  
### Further Strings are in format COMMAND=VALUE 
(I distinguish 2 types):

* Field Commands 

* Controlling commands (they will switch off some code segments in generated class)

#### Field Commands (There will be also Setters & Getters generated alongside)

* byte=FIELD_NAME

* short=FIELD_NAME 

* int=FIELD_NAME

* long=FIELD_NAME 

* float=FIELD_NAME 

* double=FIELD_NAME   

* char=FIELD_NAME

* boolean=FIELD_NAME

* String=FIELD_NAME

For example: 


> int=something 

will generate field "int something;", and Setter & Getter for it

#### Controlling commands
They are self-describing:

* class_javadoc=false 

* constructor_javadoc=false

* main_javadoc=false 

* main=false

## Example of full command-file :memo:

```
pl.sadowski.Mario int=something byte=bajcik main_javadoc=false
pl.mycompany.ClassB main=false constructor_javadoc=false
org.perpetua.xul String=lux class_javadoc=false
```
