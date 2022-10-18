import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val fra = Fraction(1, 3)
    val fra2 = Fraction(2, 6)
    println(fra.add(fra2))

}

class Point(private val x: Double, private val y:Double) {

    override fun toString(): String {
        return "x=$x, y=$y"
    }

    private val negX = -x
    private val negY = -y

    fun symmetric(): String {
        return "x=$negX, y=$negY"
    }

    override fun equals(other: Any?): Boolean {
        return this.toString() == other.toString()
    }

    fun length(obj: Point): Double {
        val l: Double = this.x - obj.x
        val h: Double = this.y - obj.y
        return sqrt(l.pow(2.0) + h.pow(2.0))
    }
}
class Fraction(private var numerator: Int, private var denominator: Int){
    fun cut():String{
        var num:Int = numerator
        var den:Int = denominator
        for (i in 2 .. num){
            while (num%i==0 && den%i==0){
                num /= i
                den /= i
            }
        }
        return "$num / $den"
    }

    fun mult(frc:Fraction):String{
        val a : Int = numerator*frc.numerator
        val b : Int = denominator*frc.denominator
        return  "$a / $b"
    }

    fun add(frc:Fraction):String{
        var a1:Int = numerator
        var b1:Int = denominator
        var a2:Int = frc.numerator
        var b2:Int = frc.denominator
        val tmp:Int = denominator
        if (denominator!=frc.denominator){
            a1*=b2
            b1*=b2
            a2*=tmp
            b2*=tmp
        }
        var sm :Int = a1+a2
        var ct = Fraction(sm, b2)
        return ct.cut()
    }
}







