package entity

import java.time.LocalDate

class Empleado(
    private val idEmployee: Int,
    private val name: String,
    private val position: String,
    private var salary: Double,
    private val dateHire: LocalDate,
    private var isActive: Boolean
) {
    //El constructor se genera de forma implicita, pero se puede añadir un constructor secundario si es necesario
    //Los getters y setters se  generan automáticamente de forma implícita
    //Unicamente se pueden acceder a ellos si el atributo es publico, caso contrario, debemos de crear el getter manualmente

    // Getter para idEmployee
    fun getIdEmployee(): Int {
        return idEmployee
    }


}
