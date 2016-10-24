/**
  * This program illustrate usage of ConcurrentHashMap in Scala for multithreading.
  * Each of the two created threads tried to insert/update value in map .
  * The entry  in the map are in the form of "fruitname" -> count.
  */
import scala.collection.immutable.HashMap.HashMap1
import scala.collection.mutable.{Map}
import java.util.concurrent.ConcurrentHashMap
import scala.collection.convert.decorateAsScala._

class SynchronizedMapExample(val tname:String, val map:Map[String,Int]) extends  Thread{
  private [this] val arrStr = Array("orange", "apple", "grape","banana","kiwi","pineapple")

  override def start(): Unit = {
    println("starting " + tname)
    new Thread(this).start()
  }

  override def run(): Unit = {
   arrStr.foreach((fruit:String) => {map(fruit) =map.getOrElse(fruit, 0) + 1} )
  }
}

object SynchronizedMapExample{
  val map = new ConcurrentHashMap[String,Int]().asScala
  def main (args :Array[String]): Unit ={

    val  obj1 =  new SynchronizedMapExample("Thread1", map)
    obj1.start

    val obj2 = new SynchronizedMapExample("Thread2", map)
    obj2.start
    Thread.sleep(100)

    map.foreach(println)

  }
}
