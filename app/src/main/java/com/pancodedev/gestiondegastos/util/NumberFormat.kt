package com.pancodedev.gestiondegastos.util

import java.text.DecimalFormat

class NumberFormat {
    companion object {
        fun formatFloat(number: Float): String {
            return DecimalFormat("¤#.##").format(number)
        }
    }
}