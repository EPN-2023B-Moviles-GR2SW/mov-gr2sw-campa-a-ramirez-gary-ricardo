import sun.font.TrueTypeFont

fun main() {
    println("Hello World!")
    // INMUTABLES (NO se reasignan "=")
    val inmutable:string ="Adrian";
    // Inmutable ="Vicente";

    // Mutable (Re asignar)
    var mutable:String ="Vicente";
    mutable ="Adrian";

    // val > var
    // Duck Typing
    var ejemploVariable ="Gary Campaña"
    val edadEjejmplo: Int = 12
    ejemploVariable.trim()
    // ejemploVariable =edadEjemplo

    //variable primitiva
    val nombreProfesor:String ="Adrian Eguez"
    val sueldo:Double = 1.2
    val estadoCivil: Char = 'C'
    val mayorEdad: Boolean = True
    //Clases Java
    val fechaNacimiento: Date = Date()
}