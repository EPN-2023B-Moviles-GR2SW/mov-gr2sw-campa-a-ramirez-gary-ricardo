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

    calcularSueldo(10.00)
    calcularSueldo(10.00,15.00,20.00)
    calcularSueldo(10.00, bonoEspecial = 20.00) //Named Parameters
    calcularSueldo(bonoEspecial = 20.00, sueldo = 10.00,tasa=14.00)

    val sumaUno = Suma(1,1)
    val sumaDos = Suma (null,1)
    val sumaTres = Suma(1, null)
}
abstract class NumerosJava{
    protected val numeroUno: Int
    private val numeroDos: Int
    constructor(
        uno:Int,
        dos: Int
    ){ //Bloque de código del constructor
        this.numeroUno = uno
        this.numeroDos = dos
        println("Inicializando")
    }
}

abstract class Numeros(
    //Ejemplo:
    // uno: Int, (Parametro (Sin modificador de acceso))
    // private var uno: Int, //Propiedad publica Clase numero uno
    // var uno: Int //Propiedad de la clase (por defecto es PUBLIC)
    //public var uno: Int,
    protected val numeroUno: Int, //Propiedad de la clase protected numeros.numeroUno
    protected val numeroDos: Int, //Propiedad de la clase protected numeros.numeroDos
){
    //var cedula:string ="" (Public es por defecto)
    //private valorCalculado: Int = 0 (private)

    init{ //Bloque constructor primario
        this.numeroUno; this.numeroDos //this es opcional
        numeroUno; numeroDos //Sin el this, es lo mismo
        println("Inicializando")
    }
}


class Suma( //Constructor Primario Suma
    unoParametro:Int, //Parametro
    dosParametro: Int, //Parametro
): Numeros(unoParametro, dosParametro){ //Extendido y mandando los parametros (suoer)
    init{ //Bloque codigo constructor primario
        this.numeroUno
        this.numeroDos
    }

    constructor( //Segundo Constructor
        uno: Int?, //Parametros
        dos:Int//Parametros
    ):this(
        if(uno==null)0 else uno, dos
    )

    constructor( //Tercer Constructor
        uno: Int, //Parametros
        dos:Int? //Parametros
    ):this(
        uno,
        if(dos==null)0 else dos
    )
}

//Void -> Unit
fun imprimirNombre(nombre:String):Unit{
    //"Nombre: " + nombre
    println ("Nombre: ${nombre}")
}

fun calcularSueldo(
    sueldo: Double, // Requerido
    tasa:Double=12.00,// Opcional (defecto)
    bonoEspecial:Double?=null,//Nullable
    ):Double{
    // Int -> Int? (nulleable)
    // String -> String? (nulleable)
    // Date -> Date? (nulleable)
    if(bonoEspecial ==null){
        return sueldo*(100/tasa)
    }else{
        return sueldo * (100/tasa)+ bonoEspecial
    }
}
