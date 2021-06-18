
// Declaramos los valores de nuestras Respuestas.

const val  RESPUESTA_AFIRMATIVA = "✅"
const val RESPUESTA_NEGATIVA = "❌"
const val RESPUESTA_DUDOSA = "?"

// Unimos las Respuestas con sus Resectivos Valores

val respuestas = mapOf(
    "Si" to RESPUESTA_AFIRMATIVA,
    "Es cierto" to RESPUESTA_AFIRMATIVA,
    "Totalmente" to RESPUESTA_AFIRMATIVA,
    "Sin Duda" to RESPUESTA_AFIRMATIVA,
    "Pregunta en otro Momento" to RESPUESTA_DUDOSA,
    "No puedo decirte en este Momento" to RESPUESTA_DUDOSA,
    "Puede que si o puede que no " to RESPUESTA_DUDOSA,
    "No va a Suceder " to RESPUESTA_NEGATIVA,
    " No Cuentes con ello" to RESPUESTA_NEGATIVA,
    "Definitivamente no" to RESPUESTA_NEGATIVA,
    "No lo Creo " to RESPUESTA_NEGATIVA,
)

fun main(args:Array<String>) {
    do {
        println("Bienvenido a Bola 8. Creada En Kotlin. Cual de estas Opciones Deseas Realizar ?")
        println("1.Realizar una Pregunta \n " +
                "2.Revisar Todas las Respuestas \n" +
                "3. Salir".trimIndent()) // trimIndent() nos ayuda a escibir de forma natural sin Utilizar muchos saltos de linea

        val valorIngresado = readLine()
        //while (valorIngresado != "3"){
        when(valorIngresado){
            "1" -> realizarPregunta()
            "2" -> mostrarRespuestas()
            "3" -> salir()
            else -> mostrarError()
        }
    }while (valorIngresado != "3")

    //}


}

val imprimirRespuesta : (Map<String,String>) -> Unit ={
        respuestas -> respuestas.keys.forEach { respuesta -> println(respuesta) }
}



fun mostrarError() {
    println("Vaya has elegido una Opcion no valida ")
}


fun salir() {
    println("Hasta Luego")
}

fun mostrarRespuestas() {
    println("Selecciona una Opcio \n" +
            "1.Revisar Todas las respuestas \n" +
            "2. Revisar solo las respuestas afirmativas \n" +
            "3. Revisar solo las respuestas dudodas \n" +
            "4. Revisar solo las respuestas negativas \n".trimIndent())

    val opcionSeleccionada = readLine()

    when(opcionSeleccionada){
        "1" -> mostrarRespuestaporTipo()
        "2" -> mostrarRespuestaporTipo(tipoRespuesta = RESPUESTA_AFIRMATIVA) // Enviamos diferente parametros
        "3" -> mostrarRespuestaporTipo(tipoRespuesta = RESPUESTA_DUDOSA)
        "4" -> mostrarRespuestaporTipo(tipoRespuesta = RESPUESTA_NEGATIVA)
        else -> println("Respuesta no valida. Cerrando Progrma")
    }
}

fun mostrarRespuestaporTipo(tipoRespuesta : String = "TODOS") {
    when (tipoRespuesta) {
        "TODOS" -> respuestas.keys.forEach { respuesta -> println(respuesta) }

        RESPUESTA_AFIRMATIVA -> respuestas.filterValues { values -> values == RESPUESTA_AFIRMATIVA }
            .also(imprimirRespuesta)

        RESPUESTA_DUDOSA -> respuestas.filterValues { values -> values == RESPUESTA_DUDOSA }
            .also(imprimirRespuesta)

        RESPUESTA_NEGATIVA -> respuestas.filterValues { valor -> valor == RESPUESTA_NEGATIVA }
            .also(imprimirRespuesta)

    }
}

    fun realizarPregunta(){
        println("¿Que preguntas deseas realizar?")
        readLine()
        println("Asi que esa es tu pregunta... La respuesta a eso es:")
        val respuestaGenerada = respuestas.keys.random()
        println(respuestaGenerada)
    }


