abstract class Element {

  def contents :Array[String]
  def height = contents.length
  def width  = if (contents.length == 0)  0 else contents(0).length
  def  above (that :Element ) :Element = new ArrayElement(this.contents ++ that.contents )
  def beside (that :Element) = {
    new ArrayElement(for ( (elem1, elem2) <- contents zip that.contents) yield elem1 + elem2)
  }

  override def toString: String = contents mkString "\n"
}
class ArrayElement (val contents :Array[String]) extends  Element


class LineElement (s:String) extends  ArrayElement(Array(s)){
  override val height = 1
  override val width = s.length
}

class UniformElement(val chr :Char, override val width :Int,  override val height :Int) extends  Element {
 private val line = chr.toString * width
  override def contents = Array.fill(height)(line)

}

object  Element {
 def apply(contents :Array[String ]) = new ArrayElement(contents)
 def apply(s:String) = new LineElement(s)
 def apply(chr :Char, width :Int) = new UniformElement(chr, width, 1)

}


