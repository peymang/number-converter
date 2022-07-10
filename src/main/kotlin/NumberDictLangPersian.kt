class NumberDictLangPersian() : NumberDictLang {
    override fun notValidNum(): String = notValidNum
    override fun zero(): String = zero
    override fun delimiter(): String = delimiter
    override fun negative(): String = negative
    override fun positive(): String = positive
    override fun point(): String = point
    override fun maxInt(): Int = 105
    override fun maxDec(): Int = 11
    override fun outOfBound(): String = " حداکثر طول عدد صیح : ${maxInt()} و حداکثر طول عدد اعشاری: ${maxDec()}"
    override fun words(): MutableMap<String, String> = dictionary

    companion object {
        private const val notValidNum = "notValidNum"
        private const val zero = "صفر"

        // must put one space after delimiter if you fill this property
        private const val delimiter = "و "
        private const val negative = "منفی"
        private const val positive = "مثبت"
        private const val point = "ممیز"

        private val dictionary = mutableMapOf(
            "0" to "", "00" to "", "000" to "",
            "1" to "یک", "2" to "دو", "3" to "سه", "4" to "چهار", "5" to "پنج",
            "6" to "شش", "7" to "هفت", "8" to "هشت", "9" to "نه", "10" to "ده",
            "11" to "یازده", "12" to "دوازده", "13" to "سیزده", "14" to "چهارده", "15" to "پانزده",
            "16" to "شانزده", "17" to "هفده", "18" to "هجده", "19" to "نوزده",
            "20" to "بیست", "30" to "سی", "40" to "چهل", "50" to "پنجاه",
            "60" to "شصت", "70" to "هفتاد", "80" to "هشتاد", "90" to "نود",
            "100" to "یکصد", "200" to "دویست", "300" to "سیصد", "400" to "چهارصد", "500" to "پانصد",
            "600" to "ششصد", "700" to "هفتصد", "800" to "هشتصد", "900" to "نهصد",
            "0_" to "", "1_" to "یکصد", "3_" to "هزار", "6_" to "میلیون", "9_" to "میلیارد", "12_" to "بیلیون",
            "15_" to "بیلیارد", "18_" to "تریلیون", "21_" to "تریلیارد", "24_" to "کوآدریلیون", "27_" to "کادریلیارد",
            "30_" to "کوینتیلیون", "33_" to "کوانتینیارد", "36_" to "سکستیلیون", "39_" to "سکستیلیارد", "42_" to "سپتیلیون",
            "45_" to "سپتیلیارد", "48_" to "اکتیلیون", "51_" to "اکتیلیارد", "54_" to "نانیلیون", "57_" to "نانیلیارد",
            "60_" to "دسیلیون", "63_" to "دسیلیارد", "66_" to "آندسیلیون", "69_" to "آندسیلیارد", "72_" to "دودسیلیون",
            "75_" to "دودسیلیارد", "78_" to "تریدسیلیون", "81_" to "تریدسیلیارد", "84_" to "کوادردسیلیون", "87_" to "کوادردسیلیارد",
            "90_" to "کویندسیلیون", "93_" to "کویندسیلیارد", "96_" to "سیدسیلیون", "99_" to "سیدسیلیارد", "102_" to "گوگول",
            "_1" to "دهم", "_2" to "صدم", "_3" to "هزارم", "_4" to "ده هزارم", "_5" to "صد هزارم", "_6" to "میلیونوم",
            "_7" to "ده میلیونوم", "_8" to "صدمیلیونوم", "_9" to "میلیاردم", "_10" to "ده میلیاردم", "_11" to "صد میلیاردم"
        )
    }
}