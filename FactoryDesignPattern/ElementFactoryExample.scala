object ElementFactoryExample {

  def  main (args :Array[String]): Unit = {

  val obj1 = Element("INDIA") //  Will create  object of LineElement 
    println(obj1)
    val obj2 = Element('d', 10) // Will create object of UniformElement
    println(obj2)
    val  obj3 = Element(Array("ram","shm")) // Will create object of ArrayElement
    println(obj3)
  }
}

