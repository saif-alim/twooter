package dp.zonbi.twooter.utils

fun String.titleCase() : String
    = split(" ").joinToString(" ") { it.replaceFirstChar { it.uppercase() } }