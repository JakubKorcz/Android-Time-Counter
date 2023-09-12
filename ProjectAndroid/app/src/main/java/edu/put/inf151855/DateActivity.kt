package edu.put.inf151855

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import java.util.*

class DateActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        val initialDate = Calendar.getInstance() // pobierz aktualną datę z systemu
        val datePicker1 : DatePicker =findViewById(R.id.datePicker1)
        datePicker1.init(
            initialDate.get(Calendar.YEAR),
            initialDate.get(Calendar.MONTH),
            initialDate.get(Calendar.DAY_OF_MONTH)
        ) { view1, year1, monthOfYear1, dayOfMonth1 ->
            val month1 = monthOfYear1
        }

        val datePicker2 : DatePicker =findViewById(R.id.datePicker2)
        datePicker2.init(
            initialDate.get(Calendar.YEAR),
            initialDate.get(Calendar.MONTH),
            initialDate.get(Calendar.DAY_OF_MONTH)
        ) { view2, year2, monthOfYear2, dayOfMonth2 ->
            val month2 = monthOfYear2
        }

        datePicker1.setOnDateChangedListener(){
                view1,year1,monthofyear1,day1 -> val month1=monthofyear1
            val day2 = datePicker2.dayOfMonth
            val month2 = datePicker2.month
            val year2 = datePicker2.year
                daysCounting(year1,year2,month1,month2,day1,day2)
        }

        datePicker2.setOnDateChangedListener(){
                view2,year2,monthofyear2,day2 -> val month2=monthofyear2
                val day1 = datePicker1.dayOfMonth
                val month1 = datePicker1.month
                val year1 = datePicker1.year
                daysCounting(year1,year2,month1,month2,day1,day2)
        }

        val dateButton = findViewById<Button>(R.id.sumDateButton)
        dateButton.setOnClickListener {
            val day1 = datePicker1.dayOfMonth
            val month1 = datePicker1.month
            val year1 = datePicker1.year
           sumDate(year1,month1,day1)
        }
        }

    private fun sumDate(year1: Int,month1: Int,day1: Int) {
        val myEditText = findViewById<EditText>(R.id.editTextNumber)
        val text = myEditText.text.toString()
        val intValue = text.toIntOrNull() ?: 0
        println(intValue)
        val calendar3 = Calendar.getInstance()
        calendar3.set(year1, month1, day1)
        calendar3.add(Calendar.DAY_OF_MONTH, intValue)
        val year2 = calendar3.get(Calendar.YEAR)
        val month2 = calendar3.get(Calendar.MONTH)
        val day2 = calendar3.get(Calendar.DAY_OF_MONTH)
        daysCounting(year1,year2,month1,month2,day1,day2)
        val datePicker1 : DatePicker =findViewById(R.id.datePicker2)
        datePicker1.updateDate(year2,month2,day2)
    }


    fun daysCounting(year1: Int, year2: Int, month1: Int, month2: Int, day1: Int, day2: Int) {
    val startDate = Calendar.getInstance()
    startDate.set(year1, month1, day1)
    val endDate = Calendar.getInstance()
    endDate.set(year2, month2, day2)


        var workdays = 0
        var daysCount = 0

        while (startDate.before(endDate)) {
            if (!isfreeday(startDate.get(Calendar.YEAR),startDate.get(Calendar.MONTH),startDate.get(Calendar.DAY_OF_MONTH))) {
                workdays++
            }
            daysCount++
            startDate.add(Calendar.DATE, 1)
        }

        val myEditText = findViewById<EditText>(R.id.editTextNumber)
        myEditText.setText(daysCount.toString())

        val textView1 = findViewById<TextView>(R.id.TextViewWorkDays)
        textView1.text = "W tym dni roboczych $workdays"
    }

    fun isfreeday(year: Int, month: Int, day: Int): Boolean {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        println(calendar.get(Calendar.DAY_OF_WEEK))

        val additionalDays=listOf(
            Pair(Calendar.JANUARY, 1),
            Pair(Calendar.JANUARY, 6),
            Pair(Calendar.MAY, 1),
            Pair(Calendar.MAY, 3),
            Pair(Calendar.AUGUST, 15),
            Pair(Calendar.NOVEMBER, 1),
            Pair(Calendar.NOVEMBER, 11),
            Pair(Calendar.DECEMBER, 25),
            Pair(Calendar.DECEMBER, 26)
        )

        val freeDays = mutableListOf<Pair<Int, Int>>()

            val a = year % 19
            val b = year / 100
            val c = year % 100
            val d = b / 4
            val e = b % 4
            val f = (b + 8) / 25
            val g = (b - f + 1) / 3
            val h = (19 * a + b - d - g + 15) % 30
            val i = c / 4
            val k = c % 4
            val l = (32 + 2 * e + 2 * i - h - k) % 7
            val m = (a + 11 * h + 22 * l) / 451
            val p = (h + l - 7 * m + 114) % 31
            val day1 = p + 2
            val month1 = (h + l - 7 * m + 114) / 31
            val year1=year
            val calendar1 = Calendar.getInstance()
            calendar1.set(year1, month1-1, day1)

        freeDays.add(Pair(calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH)))
        calendar1.add(Calendar.DATE,59)
        freeDays.add(Pair(calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH)))
        freeDays.addAll(additionalDays)

        for(additional in freeDays)
            if((calendar.get(Calendar.MONTH) == additional.first )&& (calendar.get(Calendar.DAY_OF_MONTH) == additional.second )) {
                return true }

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
            calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            return true
        }

        return false
    }
}