import com.github.peymang.numberconverter.NumberConverter
import com.github.peymang.numberconverter.NumberConverter.Companion.isNumber
import com.github.peymang.numberconverter.NumberLangDictEnglishTraditional
import com.github.peymang.numberconverter.NumberLangDictPersian
import org.junit.Test
import kotlin.test.assertEquals

class NumberConverterTest {
    @Test
    fun isNumber() {
        assertEquals(true, "1".isNumber())
        assertEquals(true, "12".isNumber())
        assertEquals(true, "123".isNumber())
        assertEquals(true, "0123".isNumber())
        assertEquals(true, "01230".isNumber())
        assertEquals(true, "123.0".isNumber())
        assertEquals(true, ".1".isNumber())
        assertEquals(true, "1.".isNumber())
        assertEquals(true, "1.1".isNumber())
        assertEquals(true, "100".isNumber())
        assertEquals(true, "101".isNumber())
        assertEquals(true, "+99".isNumber())
        assertEquals(true, "-99".isNumber())
        assertEquals(true, "+99.99".isNumber())
        assertEquals(true, "-99.99".isNumber())
        assertEquals(true, "+.99".isNumber())
        assertEquals(true, "-99.".isNumber())

        assertEquals(false, "-+99.".isNumber())
        assertEquals(false, "+-99.".isNumber())
        assertEquals(false, "..1.".isNumber())
        assertEquals(false, "1..".isNumber())
        assertEquals(false, ".".isNumber())
        assertEquals(false, "".isNumber())
    }

    @Test
    fun toWordPersian() {
        val numDict = NumberLangDictPersian()
        fun String.toWord(): String = NumberConverter.toWord(this, numDict)

        assertEquals("یک", "1".toWord())
        assertEquals("دوازده", "12".toWord())
        assertEquals("یکصد و بیست و سه", "123".toWord())
        assertEquals("یکصد و بیست و سه", "0123".toWord())
        assertEquals("یک هزار و دویست و سی", "01230".toWord())
        assertEquals("یکصد و بیست و سه", "123.0".toWord())
        assertEquals("یک دهم", ".1".toWord())
        assertEquals("یک", "1.".toWord())
        assertEquals("یک ممیز یک دهم", "1.1".toWord())
        assertEquals("یکصد", "100".toWord())
        assertEquals("یکصد و یک", "101".toWord())
        assertEquals("مثبت نود و نه", "+99".toWord())
        assertEquals("منفی نود و نه", "-99".toWord())
        assertEquals("مثبت نود و نه ممیز نود و نه صدم", "+99.99".toWord())
        assertEquals("منفی نود و نه ممیز نود و نه صدم", "-99.99".toWord())
        assertEquals("مثبت نود و نه صدم", "+.99".toWord())
        assertEquals("منفی نود و نه", "-99.".toWord())

        assertEquals(numDict.notValidNum(), "-+99".toWord())
        assertEquals(numDict.notValidNum(), "+-99.".toWord())
        assertEquals(numDict.notValidNum(), "..1.".toWord())
        assertEquals(numDict.notValidNum(), "1..".toWord())
        assertEquals(numDict.notValidNum(), ".".toWord())
        assertEquals(numDict.notValidNum(), "".toWord())
    }

    @Test
    fun toWordEnglishTraditional() {
        val numDict = NumberLangDictEnglishTraditional()
        fun String.toWord(): String = NumberConverter.toWord(this, numDict)

        assertEquals("one", "1".toWord())
        assertEquals("twelve", "12".toWord())
        assertEquals("one hundred twenty three", "123".toWord())
        assertEquals("one hundred twenty three", "0123".toWord())
        assertEquals("one thousand two hundred thirty", "01230".toWord())
        assertEquals("one hundred twenty three", "123.0".toWord())
        assertEquals("one tenth", ".1".toWord())
        assertEquals("one", "1.".toWord())
        assertEquals("one point one tenth", "1.1".toWord())
        assertEquals("one hundred", "100".toWord())
        assertEquals("one hundred one", "101".toWord())
        assertEquals("positive ninety nine", "+99".toWord())
        assertEquals("negative ninety nine", "-99".toWord())
        assertEquals("positive ninety nine point ninety nine hundredth", "+99.99".toWord())
        assertEquals("negative ninety nine point ninety nine hundredth", "-99.99".toWord())
        assertEquals("positive ninety nine hundredth", "+.99".toWord())
        assertEquals("negative ninety nine", "-99.".toWord())

        assertEquals(numDict.notValidNum(), "-+99".toWord())
        assertEquals(numDict.notValidNum(), "+-99.".toWord())
        assertEquals(numDict.notValidNum(), "..1.".toWord())
        assertEquals(numDict.notValidNum(), "1..".toWord())
        assertEquals(numDict.notValidNum(), ".".toWord())
        assertEquals(numDict.notValidNum(), "".toWord())
    }
}