package fileManager
import model.dao.DepartamentoDAO
import model.dao.EmpleadoDAO
import model.entity.Departamento
import model.entity.Empleado
import java.time.LocalDate
import java.util.*
import kotlin.system.exitProcess

@Suppress("UNREACHABLE_CODE")
class teclado {

    private val departamentoDAO: DepartamentoDAO = DepartamentoDAO(manager("src/main/kotlin/archivos/departamentos.txt"))
    private val empleadoDAO: EmpleadoDAO = EmpleadoDAO(manager("src/main/kotlin/archivos/empleados.txt"))
    private val scanner: Scanner = Scanner(System.`in`)

    fun start() {
        var exit = false
        while (!exit) {
            println("======= Bienvenido a la Gestión de Empleados y Departamentos =======")
            println("1. Opciones Departamento")
            println("2. Opciones Empleado")
            println("3. Salir")
            println("==========================================")

            when (readMenuOption()) {
                1 -> startDepartamento()
                2 -> startEmpleado()
                3 -> exit = true
                else -> println("Opción inválida. Ingrese nuevamente")
            }
            println()
        }
    }

    private fun startDepartamento() {
        var exit = false
        while (!exit) {
            println("======= Menú Departamento =======")
            println("1. Crear Departamento")
            println("2. Mostrar todos los Departamentos")
            println("3. Actualizar Departamento")
            println("4. Eliminar Departamento")
            println("5. Salir")
            println("================================")

            when (readMenuOption()) {
                1 -> createDepartamento()
                2 -> showAllDepartamentos()
                3 -> updateDepartamento()
                4 -> deleteDepartamento()
                5 -> exit = true
                else -> println("Opción inválida. Ingrese nuevamente")
            }
            println()
        }
    }

    private fun startEmpleado() {
        var exit = false
        while (!exit) {
            println("======= Menú Empleado =======")
            println("1. Crear Empleado")
            println("2. Mostrar todos los Empleados")
            println("3. Actualizar Empleado")
            println("4. Eliminar Empleado")
            println("5. Salir")
            println("================================")

            when (readMenuOption()) {
                1 -> createEmpleado()
                2 -> showAllEmpleados()
                3 -> updateEmpleado()
                4 -> deleteEmpleado()
                5 -> exit = true
                else -> println("Opción inválida. Ingrese nuevamente")
            }
            println()
        }
    }

    private fun readMenuOption(): Int {
        print("Ingresa una opción: ")
        val input = scanner.nextLine()
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            println("Opción inválida. Cerrando la aplicación...")
            exitProcess(0)
            -1 // Valor de retorno para indicar un error
        }
    }

    private fun createDepartamento() {
        println("==== Crear Departamento ====")
        print("Ingresa el nombre del Departamento: ")
        val nombre = scanner.nextLine()

        print("Ingresa la ubicación del Departamento: ")
        val ubicacion = scanner.nextLine()

        print("Ingresa el número de empleados en el Departamento: ")
        val nEmpleados = scanner.nextInt()

        scanner.nextLine() // Limpiar el buffer del scanner

        print("Ingresa el equipo remoto (true/false): ")
        val equipoRemoto = scanner.nextBoolean()

        // Fecha establecida automáticamente por el sistema
        val fechaCreacion = LocalDate.now()

        // Crear un objeto Departamento con todas las propiedades
        val departamento = Departamento(16,nombre, ubicacion, nEmpleados, fechaCreacion, equipoRemoto, mutableListOf())
        departamentoDAO.create(departamento)
        println("\n\nNuevo Departamento Añadido")
    }

    private fun showAllDepartamentos() {
        println("==== Mostrar todos los Departamentos ====")
        val departamentos = departamentoDAO.getAll()

        if (departamentos.isEmpty() || departamentos.equals(null)) {
            println("No hay Departamentos disponibles")
        } else {
            for (departamento in departamentos) {
                println(departamento)
            }
        }
    }

    private fun updateDepartamento() {
        println("==== Actualizar Departamento ====")
        print("Ingresa el nombre del Departamento a actualizar: ")
        val nombre = scanner.nextLine()

        print("Ingresa la nueva ubicación del Departamento: ")
        val nuevaUbicacion = scanner.nextLine()

        print("Ingresa el nuevo número de empleados en el Departamento: ")
        val nuevoNEmpleados = scanner.nextInt()

        scanner.nextLine() // Limpiar el buffer del scanner

        print("Ingresa el nuevo equipo remoto (true/false): ")
        val nuevoEquipoRemoto = scanner.nextBoolean()

        // Fecha establecida automáticamente por el sistema
        val nuevaFechaCreacion = LocalDate.now()

        // Crear un objeto Departamento con las propiedades actualizadas
        val departamento = Departamento(nombre, nuevaUbicacion, nuevoNEmpleados, nuevaFechaCreacion, nuevoEquipoRemoto, mutableListOf())
        departamentoDAO.updateDepartamento(departamento)
        println("\n\nDepartamento actualizado exitosamente")
    }

    private fun deleteDepartamento() {
        println("==== Eliminar Departamento ====")
        print("Ingresa el nombre del Departamento a eliminar: ")
        val nombre = scanner.nextLine()

        // Crear un objeto Departamento solo con el nombre para eliminarlo
        val departamento = Departamento(nombre, "", 0, LocalDate.now(), false, mutableListOf())
        departamentoDAO.deleteDepartamento(departamento)
        println("\nDepartamento eliminado exitosamente")
    }

    private fun createEmpleado() {
        println("==== Crear Empleado ====")
        print("Ingresa el nombre del Empleado: ")
        val nombre = scanner.nextLine()

        print("Ingresa el cargo del Empleado: ")
        val cargo = scanner.nextLine()

        print("Ingresa el salario del Empleado: ")
        val salario = scanner.nextDouble()

        scanner.nextLine() // Limpiar el buffer del scanner

        // Fecha establecida automáticamente por el sistema
        val fechaContratacion = LocalDate.now()

        print("Ingresa si el Empleado está activo (true/false): ")
        val isActive = scanner.nextBoolean()

        // Crear un objeto Empleado con todas las propiedades
        val empleado = Empleado(nombre, cargo, salario, fechaContratacion, isActive)
        empleadoDAO.createEmpleado(empleado)
        println("\n\nEmpleado creado exitosamente")
    }

    private fun showAllEmpleados() {
        println("==== Mostrar todos los Empleados ====")
        val empleados = empleadoDAO.getAllEmpleados()

        if (empleados.isEmpty()) {
            println("No hay Empleados disponibles")
        } else {
            for (empleado in empleados) {
                println(empleado)
            }
        }
    }

    private fun updateEmpleado() {
        println("==== Actualizar Empleado ====")
        print("Ingresa el nombre del Empleado a actualizar: ")
        val nombre = scanner.nextLine()

        print("Ingresa el nuevo cargo del Empleado: ")
        val nuevoCargo = scanner.nextLine()

        print("Ingresa el nuevo salario del Empleado: ")
        val nuevoSalario = scanner.nextDouble()

        scanner.nextLine() // Limpiar el buffer del scanner

        // Fecha establecida automáticamente por el sistema
        val nuevaFechaContratacion = LocalDate.now()

        print("Ingresa si el Empleado está activo (true/false): ")
        val nuevoIsActive = scanner.nextBoolean()

        // Crear un objeto Empleado con las propiedades actualizadas
        val empleado = Empleado(nombre, nuevoCargo, nuevoSalario, nuevaFechaContratacion, nuevoIsActive)
        empleadoDAO.updateEmpleado(empleado)
        println("\n\nEmpleado actualizado exitosamente")
    }

    private fun deleteEmpleado() {
        println("==== Eliminar Empleado ====")
        print("Ingresa el nombre del Empleado a eliminar: ")
        val nombre = scanner.nextLine()

        // Crear un objeto Empleado solo con el nombre para eliminarlo
        val empleado = Empleado(nombre, "", 0.0, LocalDate.now(), false)
        empleadoDAO.deleteEmpleado(empleado)
        println("\nEmpleado eliminado exitosamente")
    }
}
