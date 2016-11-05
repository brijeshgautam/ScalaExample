import java.io.PrintWriter

import scala.collection.mutable
import  scala.util.Random

/**
  * This program generates random graph and write adjacency list to a file. Entry in the output file are like :
  * 23,7,24,6,2
  * 41,19,8,30,26
  * Where first entry in a line gives source vertex and remaining entry on that line are  destination vertex.
  */

object GenerateGraph {

  def main(args:Array[String]): Unit ={
    val total = 50
    val graph = new mutable.HashMap[Int,Set[Int]]()
    val r = Random
    for ( count <- 1 to total * 5){
      val source = r.nextInt(total +1 )
      val dest = r.nextInt(total +1)
      graph(source) = graph.getOrElse(source, Set()) + dest
    }


    val str =graph.mapValues(_.mkString(",")).map((key) => key._1.toString + "," + key._2).mkString("\n")
      //.mkString("\n")
    println(str)
    new PrintWriter("fileout"){write(str); close()}
  }
}
