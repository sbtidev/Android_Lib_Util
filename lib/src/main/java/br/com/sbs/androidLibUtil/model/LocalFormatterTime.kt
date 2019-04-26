package br.com.sbs.androidLibUtil.model

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

/**
 * Created by Valmir Júnior on 12/19/17.
 */

object LocalFormatterTime {

    private val timeZone = TimeZone.getTimeZone("GMT")

    /***
     * Formatter for Dates and Times
     */
    val formatterDateHour = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val formatterDate = SimpleDateFormat("yyyy-MM-dd")
    val formatterDateMothAndDay = SimpleDateFormat("dd/MM")
    /**
     * This formater recover date from string to correct usage
     */
    val formatterHour = SimpleDateFormat("HH:mm:ss")

    /**
     * This formarter convert the date to the Format in correct way
     */
    val formatterDateHourDeffault = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val formatterHourDeffaut = SimpleDateFormat("HH:mm:ss")

    /**
     * Regex to matches the Formatter Times
     */
    private val regexMinutes = "[0-9]{2}:[0-9]{2}"
    private val regexHour = "[0-9]{2}:$regexMinutes"
    private val regexDAte = "[0-9]{4}-[0-9]{2}-[0-9]{2}"
    private val regexDateHour = "$regexDAte $regexHour"

    /**
     * Set The formatter to use TimeZone Local
     */

    init {
        formatterDateHour.timeZone = timeZone
        formatterHour.timeZone = timeZone
    }

    /**
     * Converter a Formatter Date Pattern String to a Date
     * @param patternTime
     * @return
     */
    fun parse(patternTime: String?): Date? {
        if (patternTime == null)
            return null
        try {
            when (findPattern(patternTime)) {
                PatternDate.DATE_HOUR -> return formatterDateHour.parse(patternTime)
                PatternDate.DATE -> return formatterDate.parse(patternTime)
                PatternDate.HOURS -> return formatterHour.parse(patternTime)
            }
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return null
    }


    /**
     * <h2>This Method Find and returns the PatternDate for the pattern passed by argument</h2>
     * @param pattern the String that contains the pattern to be find the Regex
     * @return the type of PatternDate that the pattern attends
     */
    private fun findPattern(pattern: String): PatternDate {
        return when {
            pattern.matches(regexDateHour.toRegex()) -> PatternDate.DATE_HOUR
            pattern.matches(regexDAte.toRegex()) -> PatternDate.DATE
            pattern.matches(regexHour.toRegex()) -> PatternDate.HOURS
            else -> PatternDate.UNKNOWN
        }
    }

    fun getActualTimeFormatted(date: Date): String {
        return LocalFormatterTime.formatterDateHourDeffault.format(date)
    }


}
