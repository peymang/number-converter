[![](https://jitpack.io/v/peymang/number-converter.svg)](https://jitpack.io/#peymang/number-converter)

# number-converter
convert number to word

language
* english traditional
* english modern
* persian
* custom(your can get one dictionary and change it as you wish, send me your dictionary if you love add it to this repo)

## usage
pass number in string and return the word equivalent to that number in Persian

```kotlin
// usage format
NumberConverter.toWord("number in string" , "number dictionary")

// return "one point one"
NumberConverter.toWord("1.1", NumberLangDictEnglishTraditional())
```
## setup
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
		repositories {
            ...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency
```gradle
dependencies {
	        implementation 'com.github.peymang:number-converter:4.0'
	}
```



## feature
Convert integers with a maximum length of 105 and decimal numbers with a maximum length of 11 into words
If you use a number longer than return [NumberLangDict.outOfBound] and if number is not valid return [NumberLangDict.notValidNum]

## feature in persian(ویژگی ها به پارسی)
تبدیل اعداد صحیح با طول حداکثر 105 و اعداد اعشاری با طول حداکثر 11  به کلمه تبدیل می کند

اگر عدد تعریف شده بیشتر از مقدار تعیین شده در دیکشنری باشد 
[NumberConverter.outOfBound]
را بر می گرداند

اگر عدد تعریف شده معتبر نباشد مقدار
[NumberConverter.notValidNum]
را بر می گرداند

## test :)
A real programmer uses `in-production` test method, which causes more excitement and adrenaline release, resulting in physical health and mental damage.


## for those who not 
```kotlin
// to english word
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

// to persian word
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

// is number function
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
```