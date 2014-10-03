Machine Problem 2: Music Catalogue 2.10
===


### Background

In this machine problem, you will build a system to catalogue music that you - or someone else - may own. This MP will help you understand how you work with simple classes and how you can exploit inheritance in Java to simplify your work. You will also gain an understanding of trees as a data structure.

To get started with this machine problem, you should make sure you understand the following:
+ [Using Java packages](http://docs.oracle.com/javase/tutorial/java/package/)
+ [The basics of inheritance and how it is implemented in Java](https://dl.dropboxusercontent.com/u/567187/EECE 210/Java/3-Inheritance-and-Interfaces.pdf)
+ The distinction between `public`, `private` and `protected` methods in Java
+ The value of the `final` keyword in Java
+ [Creating and managing simple trees](https://dl.dropboxusercontent.com/u/567187/EECE 210/Java/BinaryTrees.pdf)
+ [Simple file handling in Java](https://dl.dropboxusercontent.com/u/567187/EECE 210/Java/FileProcessing.pdf)
+ [Basic JUnit Testing](http://www.vogella.com/articles/JUnit/article.html)

### The Structure of Music Catalogue 2.10

The music catalogue you are building allows a user to store a list of albums they own. An album has a title, the name(s) of the performer(s) and a list of songs in the album. Each album belongs to a musical genre (or sub-genre). An album can belong to only one music genre (or sub-genre). For a music genre, it should be possible to retrieve all albums that belong to that genre or its sub-genres.

### The Basic Classes

#### `Album`

Our albums will only contain the following information: the title of the album, the name(s) of the performer(s),  and a list of song titles.

The `Album` class will support four main operations: `addToGenre()`, `removeFromGenre()`, `getStringRepresentation()` and a constructor to create an album from a `String` representation.

An album also contains a reference to the genre that it is part of. An album can be part of only one genre. (New forms of music may not have a well-established genre yet, and in that case the genre reference may point to a genre named Unclassified.) An album can save itself as a String, and this String can then be saved/written to a file. The file format can be of your own choosing.

#### `Genre`

The `Genre` class represents a single musical genre. It contains a name of the genre in the form of a String. It also has a list of references to every album of that genre. Genres can be nested. If an album is contained in a `Genre`, then it cannot be contained in any of the sub-genres. As an example, if _Canadian Blues_ is a genre and the album _My Kind of Evil_ is part of this genre, and _Canadian Blues_ is a sub-genre of the _Blues_ genre then _My Kind of Evil_ cannot also be part of the _Blues_ genre). The reason for this that an album is part of all the parent genres (the containment property is transitive).

Genres can save their state into a string representation. This, as is the case with `Album`s, allow `Genre`s to be saved to a file. This is done via the two methods presented below:

```java
	static Genre restoreGenre(String stringRepresentation);
	String getStringRepresentation();
```

A `Genre` can have only one parent.

#### `Element`

The `Element` class is the parent class to both `Album` and `Genre`. It allows the `Genre` to contain both other `Genre`s as well as `Album`s. Its three methods are:

```java
	protected void addChild(Element b); // adds a child (Album or Genre) to this Element.
	public List<Element> getChildren(); // returns all the children.
	boolean hasChildren(); // returns true if the particular type can contain children.
```

#### `Catalogue`

The `Catalogue` object is just a container for all the albums and genres. For now its only functionality is provided by the methods:

```java
	saveLibraryToFile(String fileName); //saves all the albums in the given file
	recreateLibraryFromFile(String fileName); // rebuilds the library information from a file
```

#### Example Catalogue

### Test Cases

You will have to write test cases using JUnit for the following scenarios.

1. Add an `Album` to a `Genre`
2. Remove an `Album` from a `Genre`
3. Save an `Album` to the `String` form
4. Recreate an `Album` from the `String` form
5. Save a `Genre` to the `String` from
6. Recreate the `Genre` from the `String` form
7. Save the whole catalogue to a file
8. Recreate the catalogue from a file
9. Write a test to verify the `Genre` inclusion rules

> A good strategy for writing tests is to first write black-box tests that are based only on the specification. In fact, if you are really following extreme programming (XP) then you will have written these tests earlier. Then look at the code and use the white-box testing techniques to write some more tests. Probably the black-box tests are already testing most of the code, so you will not have to write many white-box tests, but this is a good way to make good tests.

### Submitting Your Work

You will submit your work by pushing all your code to a BitBucket private repository called `mp3`. Remember to preserve the subdirectory structure so that the package references are preserved.
