package stackoverflow

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext.*
import org.apache.spark.rdd.RDD
import java.io.File
import scala.io.{Codec, Source}
import scala.util.Properties.isWin

object StackOverflowSuite:
  val conf: SparkConf =
    new SparkConf().setMaster("local[2]").setAppName("StackOverflow")
  val sc: SparkContext = new SparkContext(conf)

class StackOverflowSuite extends munit.FunSuite:
  import StackOverflowSuite.*

  val fileLocation = "stackoverflow.csv"

  lazy val testObject = new StackOverflow {
    override val langs =
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
    override def langSpread = 50000
    override def kmeansKernels = 45
    override def kmeansEta: Double = 20.0d
    override def kmeansMaxIterations = 120
  }

  test("testObject can be instantiated") {
    val instantiatable =
      try {
        testObject
        true
      } catch {
        case _: Throwable => false
      }
    assert(instantiatable, "Can't instantiate a StackOverflow object")
  }

  test("Data can be loaded from the file"){
   val lines =  testObject.linesAsStream(sc, fileLocation)
    assert(lines != null)
    assert(!lines.isEmpty())
  }

  test("Posts can be loaded from file"){
    val lines =  testObject.linesAsStream(sc, fileLocation)
    val posts = testObject.rawPostings(lines)
    assert(posts != null)
    assert(!posts.isEmpty())
  }
  
  test("Can group questions and answers together"){
    val lines = testObject.linesAsStream(sc, fileLocation)
    val posts = testObject.rawPostings(lines)
    val groupedPosts = testObject.groupedPostings(posts)
    assert(groupedPosts != null)
    assert(!groupedPosts.isEmpty())
  }
  
  test("Can compute max score for each post"){
    val lines = testObject.linesAsStream(sc, fileLocation)
    val posts = testObject.rawPostings(lines)
    val groupedPosts = testObject.groupedPostings(posts)
    val maxScores = testObject.scoredPostings(groupedPosts)
    assert(maxScores != null)
    assert(!maxScores.isEmpty())
  }
  
  test("Can computes vectors for kmeans"){
    val lines = testObject.linesAsStream(sc, fileLocation)
    val posts = testObject.rawPostings(lines)
    val groupedPosts = testObject.groupedPostings(posts)
    val maxScores = testObject.scoredPostings(groupedPosts)
    val vectors = testObject.vectorPostings(maxScores)
    assert(vectors != null)
    assert(!vectors.isEmpty())
  }

  import scala.concurrent.duration.given
  override val munitTimeout = 300.seconds
