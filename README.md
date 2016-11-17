# Class-Templates-Generator
Java Application which quickly generates Java projects with blank-class-files, that will be ready to be filled with Your code

# Manual Contents
* [Command line arguments](#command-line-arguments-arrow_right)

* [Syntax in file](#syntax-in-file-pencil2)

* [Example of full command-file](#example-of-full-command-file-memo)

## Command line arguments :arrow_right:

You should specify exactly 2 arguments at command line

* 1st is: [path to file, which contains commands]

* 2nd is: [desired name of output directory for generated code-files] IN OTHER WORDS [desired relative path of root of the created project]

For example:

> classnames.txt output_project

## Syntax in file :pencil2:

### First String is in format PACKAGE_NAME.CLASS_NAME
Examples:

* pl.example.Mario

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

#### Method Commands (with parameters)

Syntax for this command is: [TYPE]([PARAMETER_TYPE]:[PARAMETER_NAME],[PARAMETER_TYPE]:[PARAMETER_NAME],...)=[METHOD_NAME]

Watch out! There should be no whitespaces between parentheses!

Examples of correct Method Commands:

```
pl.example.Generator boolean(double:amplitude,String:shape)=generate  String()=getShape void(String:shape)=setShape
pl.example.Turtle boolean(double:strength)=jump  void(String:word)=say
```

#### Controlling commands
They are self-describing:

* class_javadoc=false 

* constructor_javadoc=false

* main_javadoc=false 

* main=false

## Example of full command-file :memo:

```
pl.example.Mario int=something byte=rawData main_javadoc=false constructor_javadoc=false
pl.example.Generator String=shape double=amplitude boolean(double:amplitude,String:shape)=generate  String()=getShape void(String:shape)=setShape
pl.example.Turtle  String=name  boolean(double:strength)=jump  void(String:word)=say  main=false
```
