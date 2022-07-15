package com.github.peymang.numberconverter

/**
 * @author peyman ghafari pour(https://github.com/peymang)
 * version 1.0
 */
class NumberConverter {
    companion object {
        /**
         * @param number must a valid otherwise return [NumberLangDict.zero]
         * @param number with [NumberLangDict.maxInt] for integer part and [NumberLangDict.maxDec] for decimal part
         * @exception number integer part if is bigger than [NumberLangDict.maxInt] return [NumberLangDict.outOfBound] string
         * @exception number integer part if is bigger than [NumberLangDict.maxDec] return [NumberLangDict.outOfBound] string
         * @exception number if is not valid return [NumberLangDict.zero]
         */
        fun toWord(number: String, dict: NumberLangDict): String {
            if (!number.isNumber()
            ) return dict.notValidNum()

            val numberSignWord = getSignWord(number, dict)
            val numWithoutSign = if (numberSignWord.isEmpty()) number else number.substring(1, number.length)

            val intAndDecNumber = splitIntAndDec(numWithoutSign)
            if (intAndDecNumber[0].length > dict.maxInt()) return dict.outOfBound()
            if (intAndDecNumber[1].length > dict.maxDec()) return dict.outOfBound()
            val intPart = separate3By3(intAndDecNumber[0])
            val decPart = separate3By3(intAndDecNumber[1])
            val intWordPart = arrayListOf<String>()
            val decWordPart = arrayListOf<String>()

            intPart.reversed().forEachIndexed { index, s ->
                val intWord = getIntWord(s, index, dict)
                if (intWord.isNotEmpty()) intWordPart.add(intWord)
            }
            decPart.reversed().forEachIndexed { index, s ->
                val decWord = getIntWord(s, index, dict)
                if (decWord.isNotEmpty()) decWordPart.add(decWord)
            }

            val intNumber = if (intWordPart.isNotEmpty()) intWordPart.reversed().joinToString(" ${dict.delimiter()}") else ""

            var pointNumber = ""
            if (decWordPart.isNotEmpty()) pointNumber = " ${dict.point()} "
            if (intWordPart.isEmpty()) pointNumber = ""

            val decNumber = if (decWordPart.isNotEmpty())
                decWordPart.reversed().joinToString(" ${dict.delimiter()}") +
                        " " + dict.words().getValue("_${intAndDecNumber[1].length}") else ""

            return numberSignWord + intNumber + pointNumber + decNumber
        }

        /**
         * split integer part and decimal part also trim zero from start of integer and end of decimal number
         */
        private fun splitIntAndDec(number: String): List<String> =
            if (number.contains('.')) number.trim('0').split('.')
            else listOf(number.trimStart('0'), "")

        /**
         * convert number into group of every 3 digit
         */
        private fun separate3By3(number: String): List<String> =
            number.reversed().chunked(3)
                .joinToString(",").reversed().split(",")

        /**
         * get number sign if you use "+" it's return positive and come in final output
         */
        private fun getSignWord(number: String, dict: NumberLangDict): String =
            when (number.substring(0, 1)) {
                "+" -> "${dict.positive()} "
                "-" -> "${dict.negative()} "
                else -> ""
            }

        /**
         * @param zeroFactor The count of zeros that a number can have depending on its position
         * @param dict dictionary to convert numbers to letters
         */
        private fun getIntWord(number: String, zeroFactor: Int, dict: NumberLangDict): String {
            var n100 = ""
            var n10 = ""
            var n1 = ""
            var suffix = ""
            var result = ""
            // because we group number in 3 digit and send array index must multiply by 3
            val zeroCount = zeroFactor * 3

            when (number.length) {
                3 -> {
                    n100 = dict.words().getValue(number[0] + "00")
                    n10 = dict.words().getValue(if (number[1] == '1') number[1].toString() + number[2] else number[1] + "0")
                    n1 = dict.words().getValue(if (number[1] == '1') "0" else number[2].toString())
                }
                2 -> {
                    n10 = dict.words().getValue(if (number[0] == '1') number[0].toString() + number[1] else number[0] + "0")
                    n1 = dict.words().getValue(if (number[0] == '1') "0" else number[1].toString())
                }
                1 -> n1 = dict.words().getValue(number[0].toString())
            }

            if (n100.isNotEmpty()) {
                result = n100
                if (n10.isNotEmpty() || n1.isNotEmpty()) result += " ${dict.delimiter()}"
            }

            if (n10.isNotEmpty()) {
                result += n10
                if (n1.isNotEmpty()) result += " ${dict.delimiter()}"
            }

            if (n1.isNotEmpty()) result += n1
            if (n1.isNotEmpty() || n10.isNotEmpty() || n100.isNotEmpty()) suffix = dict.words().getValue("${zeroCount}_")

            return "$result $suffix".trim()
        }

        fun String.isNumber(): Boolean {
            return this.isNotEmpty()
                    && this.trim('0').isNotEmpty()
                    && this.trim('0') != "."
                    && this.matches("[-+]?([0-9]+)?(\\.)?([0-9]+)?".toRegex())
        }
    }
}