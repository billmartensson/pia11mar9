package se.magictechnology.pia11mar9

class CalcHelper {

    var allnumbers = mutableListOf<String>()

    fun loadNumbers() {
        allnumbers.add("zero")
        allnumbers.add("one")
        allnumbers.add("two")
        allnumbers.add("three")
        allnumbers.add("four")
        allnumbers.add("five")
        allnumbers.add("six")
        allnumbers.add("seven")
        allnumbers.add("eight")
        allnumbers.add("nine")
        allnumbers.add("ten")
    }

    fun textToNumber(number : String) : Int? {
        val idx = allnumbers.indexOf(number)
        if(idx == -1) {
            return null
        }
        return idx
    }

    fun numberToText(number : Int) : String? {
        if(number > allnumbers.size) {
           return null
        }
        if(number < 0) {
            return null
        }
        return allnumbers[number]
    }

    fun calcStrings(n1 : String, n2 : String) : String {
        val num1 = textToNumber(n1)
        val num2 = textToNumber(n2)
        if(num1 == null || num2 == null) {
            return ""
        }
        val result = num1 + num2

        val resultstring = numberToText(result)

        if(resultstring == null) {
            return ""
        }
        return resultstring
    }

    fun dummything() {

    }

    fun personnummerChecker(persnr : String) : Boolean {

        // 530221-6972

        var pnr = persnr.replace("-", "")
        pnr = pnr.replace("+", "")

        // 5302216972

        if(pnr.length == 12) {
            if(pnr.substring(0, 2) == "19" || pnr.substring(0, 2) == "20") {
                pnr = pnr.substring(2)
            }
        }

        if(pnr.length != 10) {
            return false
        }
        if(pnr.toLongOrNull() == null) {
            return false
        }

        var checksum = 0
        for(i in 0 until pnr.length) {

            var pnumb = pnr[i].toString().toInt()
            if(i % 2 == 0) {
                pnumb = pnumb * 2
            } else {
                pnumb = pnumb * 1
            }
            if(pnumb > 9) {
                checksum = checksum + 1
                pnumb = pnumb - 10
            }

            checksum = checksum + pnumb
        }

        if(checksum % 10 == 0) {
            return true
        }

        return false
    }

}