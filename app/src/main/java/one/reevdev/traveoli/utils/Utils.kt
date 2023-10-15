package one.reevdev.traveoli.utils

fun Any?.isNull(): Boolean = this == null
fun Any?.isNotNull(): Boolean = this != null
fun String?.or(s: String) = this ?: s