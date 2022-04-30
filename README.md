# Distributed [K-means](https://en.wikipedia.org/wiki/K-means_clustering) algorithm for clustering question-answers on [StackOverFlow](https://stackoverflow.com/)

The aim is to compare distribution of the question-answers on StackOverFlow for following list of programming languages with help of K-means algorithm with [Scala](https://www.scala-lang.org/) 3 and [Apache Spark](https://spark.apache.org/) distributed computing.

```scala
val langs =
    List(
      "JavaScript",
      "Java",
      "PHP",
      "Python",
      "C#",
      "C++",
      "Ruby",
      "CSS",
      "Objective-C",
      "Perl",
      "Scala",
      "Haskell",
      "MATLAB",
      "Clojure",
      "Groovy"
    )
```

## prerequisites
You need to have [JDK](https://openjdk.java.net/install/) 12 or higher and [SBT](https://www.scala-sbt.org/index.html) build tool installed on your machine

You can check for Java like follow:

```bash
java -version
```

You might see something like below:

```bash
java version "12.0.2" 2019-07-16
Java(TM) SE Runtime Environment (build 12.0.2+10)
Java HotSpot(TM) 64-Bit Server VM (build 12.0.2+10, mixed mode, sharing)
```

for installing sbt visit [sbt reference manual](https://www.scala-sbt.org/1.x/docs/Setup.html)


## How to run

At the root of the project run `sbt`

```bash
sbt
```
then you will have sbt conosle like below where you can run the project:

```bash
sbt:bigdata-stackoverflow> run
```

after a couple of seconds the result of the iterations and also the final clustering will be printed to console.