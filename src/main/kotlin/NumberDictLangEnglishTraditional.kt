class NumberDictLangEnglishTraditional() : NumberDictLang {
    override fun notValidNum(): String = notValidNum
    override fun zero(): String = zero
    override fun delimiter(): String = delimiter
    override fun negative(): String = negative
    override fun positive(): String = positive
    override fun point(): String = point
    override fun maxInt(): Int = 105
    override fun maxDec(): Int = 11
    override fun outOfBound(): String = " max integer part is: ${maxInt()} and max decimal part is: ${maxDec()}"
    override fun words(): MutableMap<String, String> = dictionary

    companion object {
        private const val notValidNum = "notValidNum"
        private const val zero = "zero"

        // must put one space after delimiter if you fill this property
        private const val delimiter = ""
        private const val negative = "negative"
        private const val positive = "positive"
        private const val point = "point"

        private val dictionary = mutableMapOf(
            "0" to "",
            "00" to "",
            "000" to "",
            "1" to "one",
            "2" to "two",
            "3" to "three",
            "4" to "four",
            "5" to "five",
            "6" to "six",
            "7" to "seven",
            "8" to "eight",
            "9" to "nine",
            "10" to "ten",
            "11" to "eleven",
            "12" to "twelve",
            "13" to "thirteen",
            "14" to "fourteen",
            "15" to "fifteen",
            "16" to "sixteen",
            "17" to "seventeen",
            "18" to "eighteen",
            "19" to "nineteen",
            "20" to "twenty",
            "30" to "thirty",
            "40" to "forty",
            "50" to "fifty",
            "60" to "sixty",
            "70" to "seventy",
            "80" to "eighty",
            "90" to "ninety",
            "100" to "one hundred",
            "200" to "two hundred",
            "300" to "three hundred",
            "400" to "four hundred",
            "500" to "five hundred",
            "600" to "six hundred",
            "700" to "seven hundred",
            "800" to "eight hundred",
            "900" to "nine hundred",
            "0_" to "",
            "1_" to "hundred",
            "3_" to "thousand",
            "6_" to "million",
            "9_" to "Thousand million",
            "12_" to "Billion",
            "15_" to "Thousand billion",
            "18_" to "Trillion",
            "21_" to "Thousand trillion",
            "24_" to "Quadrillion",
            "27_" to "Thousand quadrilli",
            "30_" to "Quintillion",
            "33_" to "Thousand quintillion",
            "36_" to "Sextillion",
            "39_" to "Thousand sextillion",
            "42_" to "Septillion",
            "45_" to "Thousand septillion",
            "48_" to "Octillion",
            "51_" to "Thousand octillion",
            "54_" to "Nonillion",
            "57_" to "Thousand nonillion",
            "60_" to "Decillion",
            "63_" to "Thousand decillion",
            "66_" to "Undecillion",
            "69_" to "Thousand undecillion",
            "72_" to "Duodecillion",
            "75_" to "Thousand duodecillion",
            "78_" to "Tredecillion",
            "81_" to "Thousand tredecillion",
            "84_" to "Quattuordecillion",
            "87_" to "Thousand quattuordecillion",
            "90_" to "Quindecillion",
            "93_" to "Thousand quindecillion",
            "96_" to "Sedecillion",
            "99_" to "Thousand sedecillion",
            "102_" to "Septendecillion",
            "105_" to "Thousand septendecillion",
            "_1" to "tenth",
            "_2" to "hundredth",
            "_3" to "thousandth",
            "_4" to "ten-thousandth",
            "_5" to "hundred-thousandth",
            "_6" to "millionth",
            "_7" to "ten-millionth",
            "_8" to "hundred-millionth",
            "_9" to "billionth",
            "_10" to "ten-billionth",
            "_11" to "hundred-billionth"
        )
    }
}