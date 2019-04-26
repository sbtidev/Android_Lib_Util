package br.com.sbs.androidLibUtil.model

/**
 * Created by mvdkpj02r on 12/19/17.
 */

enum class PatternDate constructor(private val value: Int) {

    UNKNOWN(-1), HOURS(1), DATE(3), DATE_HOUR(4);
}
