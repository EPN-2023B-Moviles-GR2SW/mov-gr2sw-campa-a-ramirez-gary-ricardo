package dao.imp

import dao.EmpleadoDAO
import entity.Empleado
import java.time.LocalDate

class EmpleadoDAOImpl: EmpleadoDAO{

    //Usamos var porque se va añadiendo a la lista
    private var empleados: MutableList<Empleado>? = null
    val date = LocalDate.now()
    override fun getById(id: Int): Empleado? {
        val empleados = this.empleados
        if (empleados != null) {
            for (empleado in empleados) {
                if (empleado.getIdEmployee() == id) {
                    return empleado
                }
            }
        }
        return null
    }

    override fun getAll(): MutableList<Empleado> {
        if(empleados == null){
            empleados = ArrayList()
            // Agregar elementos a la lista
            empleados?.add(Empleado(1, "Juan", "Product manager", 2000.00, date, true))
            empleados?.add(Empleado(2, "Pepe", "Produc owner", 2000.00,date, true))
            empleados?.add(Empleado(3, "Rocio", "Ui", 1500.00,date, true))
            empleados?.add(Empleado(4, "Lucho", "DevOps", 1700.00,date, true))
            empleados?.add(Empleado(5, "David", "Developer", 1500.00,date, true))
            empleados?.add(Empleado(6, "Maria", "Product owner", 2200.00, date, true))
            empleados?.add(Empleado(7, "Carlos", "UX Designer", 1800.00, date, true))
            empleados?.add(Empleado(8, "Laura", "DevOps Engineer", 1900.00, date, true))
            empleados?.add(Empleado(9, "Pedro", "Frontend Developer", 1600.00, date, true))
            empleados?.add(Empleado(10, "Sofía", "Backend Developer", 1700.00, date, true))
            empleados?.add(Empleado(11, "Miguel", "Scrum Master", 2100.00, date, true))
            empleados?.add(Empleado(12, "Elena", "Mobile Developer", 1750.00, date, true))
            empleados?.add(Empleado(13, "Javier", "Data Scientist", 2000.00, date, true))
            empleados?.add(Empleado(14, "Isabel", "QA Engineer", 1800.00, date, true))
            empleados?.add(Empleado(15, "Alejandro", "Full Stack Developer", 1900.00, date, true))

        }
        return empleados as MutableList<Empleado>
    }

    override fun create(e: Empleado) {
        this.getAll().add(e)
    }

    //Se usa el operador "?" dado que es nulleable
    //Se añade los parentesis () dado que se espera un "Int" y no un "Int?"
    override fun update(e: Empleado) {
        for (i in 0 until (empleados?.size ?: 0)) {
            if (empleados?.get(i)?.getIdEmployee() == e.getIdEmployee()) {
                empleados?.set(i, e)
            }
        }
    }

    override fun delete(id: Int) {
        for(i in 0 until (empleados?.size?:0)){
            if(empleados?.get(i)?.getIdEmployee() == id){
                empleados?.removeAt(i)
            }
        }
    }

    override fun save(e: List<Empleado>) {
        TODO("Not yet implemented")
    }

}