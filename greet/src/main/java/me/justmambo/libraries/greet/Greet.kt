package me.justmambo.libraries.greet

/**
 * @project Karibu
 * @author mambobryan
 * @email mambobryan@gmail.com
 * Thu Feb 2023
 */
object Greet {

    init {
        System.loadLibrary("greet")
    }

    fun sayWelcome() = getGreeting()

    private external fun getGreeting() : String

}