package com.ats.qukmartapp.presentation.models

import java.util.Locale

data class DisplayableNumber(val value:Double,val formatted:String)


fun Double.toDisplayableNumber() :DisplayableNumber
{
    val formatter = android.icu.text.NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return DisplayableNumber(this, formatted =formatter.format(this))
}
