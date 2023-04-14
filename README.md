# Distributed [K-means](https://en.wikipedia.org/wiki/K-means_clustering) algorithm for clustering question-answers on [StackOverFlow](https://stackoverflow.com/)

The aim is to compare distribution of the question-answers on [StackOverFlow data](src/main/resources/stackoverflow.csv) for following list of programming languages with help of K-means algorithm with [Scala](https://www.scala-lang.org/) 3 and [Apache Spark](https://spark.apache.org/) distributed computing.

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
You need to have [JDK](https://openjdk.java.net/install/) 11 or higher and [SBT](https://www.scala-sbt.org/index.html) build tool installed on your machine

You can check for Java like follow:

```bash
java --version
```

You might see something like below:

```bash
openjdk 11.0.12 2021-07-20
OpenJDK Runtime Environment 18.9 (build 11.0.12+7)
OpenJDK 64-Bit Server VM 18.9 (build 11.0.12+7, mixed mode)
```

for installing sbt visit [sbt reference manual](https://www.scala-sbt.org/1.x/docs/Setup.html)


## How to run

At the root of the project run `sbt`

```bash
sbt run
```

after a couple of seconds or more the result of the iterations and also the final clustering will be printed to console.
```text
[info] Resulting clusters:
[info]   Score  Dominant language (%percent)  Questions
[info] ================================================
[info]       1  PHP               (100.0%)       155254
[info]       1  C#                (100.0%)       177686
[info]       1  Ruby              (100.0%)        26769
[info]       1  CSS               (100.0%)        55438
[info]       1  Java              (100.0%)       188364
[info]       1  JavaScript        (100.0%)       179390
[info]       1  MATLAB            (100.0%)         6213
[info]       1  Groovy            (100.0%)         1310
[info]       1  Objective-C       (100.0%)        46504
[info]       2  Perl              (100.0%)        11532
[info]       2  Python            (100.0%)        85751
[info]       2  Clojure           (100.0%)         1789
[info]       2  C++               (100.0%)        88910
[info]       3  Scala             (100.0%)         6312
[info]       4  Haskell           (100.0%)         4903
[info]       7  MATLAB            (100.0%)          888
[info]       9  Groovy            (100.0%)          190
[info]      18  Clojure           (100.0%)          180
[info]      32  Perl              (100.0%)          179
[info]      35  Haskell           (100.0%)          175
[info]      46  Groovy            (100.0%)           10
[info]      47  MATLAB            (100.0%)           27
[info]      60  Scala             (100.0%)          104
[info]      71  PHP               (100.0%)          606
[info]      72  Clojure           (100.0%)           26
[info]      81  C#                (100.0%)         1228
[info]      97  Objective-C       (100.0%)          408
[info]     120  Ruby              (100.0%)          199
[info]     122  C++               (100.0%)          272
[info]     141  CSS               (100.0%)          226
[info]     153  Python            (100.0%)          326
[info]     180  Java              (100.0%)          395
[info]     182  Haskell           (100.0%)            7
[info]     266  Scala             (100.0%)            3
[info]     279  JavaScript        (100.0%)          300
[info]     289  Perl              (100.0%)            1
[info]     465  PHP               (100.0%)           34
[info]     485  C#                (100.0%)           63
[info]     491  CSS               (100.0%)           28
[info]     548  Objective-C       (100.0%)           30
[info]     574  Ruby              (100.0%)           14
[info]     586  C++               (100.0%)           19
[info]     722  Python            (100.0%)           34
[info]    1432  JavaScript        (100.0%)           27
[info]    1546  Java              (100.0%)            8
```
