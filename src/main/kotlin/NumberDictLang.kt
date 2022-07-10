interface NumberDictLang {
    fun notValidNum(): String
    fun zero(): String
    fun delimiter(): String
    fun negative(): String
    fun positive(): String
    fun point(): String
    fun maxInt(): Int
    fun maxDec(): Int
    fun outOfBound(): String
    fun words(): MutableMap<String, String>
}