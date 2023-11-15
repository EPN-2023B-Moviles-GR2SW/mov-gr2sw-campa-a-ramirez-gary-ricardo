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

    // SWITCH
    val estadoCivilWhen ="C"
    when (estadoCivilWhen){
        ("C") -> {
            println("Casado")
        }
        "S" ->{
            println("Soltero")
        }
        else ->{
            println("No sabemos")
        }
    }

    val esSoltero = (estadoCivilWhen =="S")
    val coqueto = if (esSoltero) "Si" else "No"
}

//Void -> Unit
fun imprimirNombre(nombre:String):Unit{
    //"Nombre: " + nombre
    println ("Nombre: ${nombre}")
}

fun calcularSueldo(
    sueldo: Double,
    tasa:Double=12.00,
    bonoEspecial:Double?=null,):Double{
    // Int -> Int? (nulleable)
    // String -> String? (nulleable)
    // Date -> Date? (nulleable)
    if(bonoEspecial ==null){
        return sueldo*(100/tasa)
    }else{
        return sueldo * (100/tasa)+ bonoEspecial
    }
}