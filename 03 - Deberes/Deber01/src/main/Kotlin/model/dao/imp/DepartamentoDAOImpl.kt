package dao.imp

import dao.DepartamentoDAO
import entity.Departamento
import entity.Empleado
import java.time.LocalDate

class DepartamentoDAOImpl:DepartamentoDAO {

    //Usamos var porque se va añadiendo a la lista
    private var departamentos: MutableList<Departamento>? = null
    val date = LocalDate.now()
    override fun getById(id: Int): Departamento? {
        val departamentos = this.departamentos
        if (departamentos != null) {
            for (departamentos in departamentos) {
                if (departamentos.getidDepto() == id) {
                    return departamentos
                }
            }
        }
        return null
    }

    override fun getAll(): MutableList<Departamento> {
        if(departamentos == null){
            departamentos = ArrayList()
            // Agregar elementos a la lista
            departamentos?.add(Departamento(1, "Desarrollo","Carcelen",2,date, false,
                mutableListOf(
                    Empleado(1, "Juan", "Product manager", 2000.00, date, true),
                    Empleado(2, "Pepe", "Produc owner", 2000.00,date, true)
                )))
            departamentos?.add(Departamento(2,"Ventas","Villaflora",2,date,true,
                mutableListOf(
                    Empleado(3, "Rocio", "Ui", 1500.00,date, true),
                    Empleado(4, "Lucho", "DevOps", 1700.00,date, true)
                )))
            departamentos?.add(Departamento(3, "Soporte Técnico", "Centro", 5, date, false,
                mutableListOf(
                    Empleado(5, "David", "Developer", 1500.00,date, true),
                    Empleado(6, "Maria", "Product owner", 2200.00, date, true),
                    Empleado(7, "Carlos", "UX Designer", 1800.00, date, true),
                    Empleado(8, "Laura", "DevOps Engineer", 1900.00, date, true),
                    Empleado(9, "Pedro", "Frontend Developer", 1600.00, date, true)
                )))
            departamentos?.add(Departamento(4, "Recursos Humanos", "La Mariscal", 3, date, true,
                mutableListOf(
                    Empleado(10, "Sofía", "Backend Developer", 1700.00, date, true),
                    Empleado(11, "Miguel", "Scrum Master", 2100.00, date, true),
                    Empleado(12, "Elena", "Mobile Developer", 1750.00, date, true)
                )))
            departamentos?.add(Departamento(5, "Finanzas", "Quito Norte", 3, date, true,
                mutableListOf(
                    Empleado(13, "Javier", "Data Scientist", 2000.00, date, true),
                    Empleado(14, "Isabel", "QA Engineer", 1800.00, date, true),
                    Empleado(15, "Alejandro", "Full Stack Developer", 1900.00, date, true)
                )))
        }
        return departamentos as MutableList<Departamento>
    }

    override fun create(d: Departamento) {
        this.getAll().add(d)
    }

    override fun update(d: Departamento) {
        for (i in 0 until (departamentos?.size ?: 0)) {
            if (departamentos?.get(i)?.getidDepto() == d.getidDepto()) {
                departamentos?.set(i, d)
            }
        }
    }

    override fun delete(id: Int) {
        for(i in 0 until (departamentos?.size?:0)){
            if(departamentos?.get(i)?.getidDepto() == id){
                departamentos?.removeAt(i)
            }
        }
    }

    override fun save(d: List<Departamento>) {
        TODO("Not yet implemented")
    }
}