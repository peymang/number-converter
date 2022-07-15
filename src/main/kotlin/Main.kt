import com.github.peymang.numberconverter.NumberConverter
import com.github.peymang.numberconverter.NumberLangDictPersian

fun main(args: Array<String>) {
    println(NumberConverter.toWord(".1", NumberLangDictPersian()))
}