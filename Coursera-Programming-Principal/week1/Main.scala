package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println("change =" + countChange(4,List(1,2)))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = if( r ==0 || c == 0 || r == c ) 1 else  pascal(c -1, r -1) + pascal(c, r -1)
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def countBalance(list:List[Char], count:Int):Boolean = list match{
        case Nil => if ( count == 0) true else false
        case x::xs if x == '(' => countBalance (xs , count +1 )
        case x ::xs if x == ')' => if ( count == 0) false  else countBalance(xs, count -1)
        case _ => countBalance(list.tail, count)
      }
      countBalance(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = if ( money == 0) 1 else if (coins.isEmpty || money < 0) 0 else
              countChange(money - coins.head, coins) + countChange(money , coins.tail)
  }
