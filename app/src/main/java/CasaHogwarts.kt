/**
 * Clase para las casas de Hogwarts
 */
data class CasaHogwarts(private var nombreCasa: String) {
    /**
     * Forma similar para utilizar los métodos static de Java
     * OJO: usa el patrón Singlseton
     */
    companion object {
        //Constantes para los nombres de las casas
        val CASA_SLYTHERIN: String = "Slytherin"
        val CASA_GRIFFINDORF: String = "Griffindorf"
        val CASA_HUFFLEPLUFF: String = "Hufflepluff"
        val CASA_RAVENCLAW: String = "Ravenclaw"

        // Listados de apellidos según casas de Hogwarts
        private val slytherinApellidos: List<String> = listOf(
            "Riddle",
            "Malfoy",
            "Snape",
            "Lestrange",
            "Black",
            "Parkinson",
            "Zabini",
            "Sliughorn",
            "Nott",
            "Bulstrode"
        )
        private val griffindorfApellidos: List<String> = listOf(
            "Potter",
            "Granger",
            "Weasley",
            "Longbottom",
            "Finnigan",
            "Thomas",
            "Patil",
            "Brown",
            "McGonagall"
        )
        private val hufflepuffApellidos: List<String> = listOf(
            "Diggory",
            "Tonks",
            "Sprout",
            "Lestrange",
            "Abbott",
            "Macmillan",
            "Finch-Fletchley",
            "Bones",
            "Scamander",
            "Midgen"
        )
        private val ravenclawApellidos: List<String> = listOf(
            "Lovegood",
            "Chang",
            "Flitwick",
            "Patil",
            "Lockhart",
            "Myrtle",
            "Corner",
            "Boot",
            "Goldstein"
        )

        fun getApellido(casa: String): String {
            val listaApellidos: List<String>?
            // Elegimos el listado de apellidos correcto
            if (casa == CASA_SLYTHERIN) listaApellidos = slytherinApellidos;
            else if (casa == CASA_GRIFFINDORF) listaApellidos = griffindorfApellidos
            else if (casa == CASA_HUFFLEPLUFF) listaApellidos = hufflepuffApellidos
            else listaApellidos = ravenclawApellidos

            //Devolvemos un apellido al azar del listado de apellidos seleccionado
            val totalApellidos: Int = listaApellidos.size
            val posicion: Int = (0..totalApellidos).random()

            return listaApellidos[posicion]
        }

        /**
         * Obtenemos un listados de atributos mágicos en función de cada casa
         */
        fun getAtributos(casa: String): MutableList<AtributoMagico> {
            val listaAtributosCasa: Map<String, Int>

            // Creamos las habilidades para cada casa => Mapa string -> valor
            val habilidadesSlytherin = mapOf<String, Int>(
                AtributoMagico.HABILIDAD to (15..20).random(),
                AtributoMagico.INTELIGENCIA to (20..25).random(),
                AtributoMagico.CREATIVIDAD to (10..25).random(),
                AtributoMagico.ETICA to (0..10).random(),
                AtributoMagico.CORAJE to (5..10).random(),
                AtributoMagico.LEALTAD to (10..20).random()
            )
            val habilidadesGriffindorf = mapOf<String, Int>(
                AtributoMagico.HABILIDAD to (10..15).random(),
                AtributoMagico.INTELIGENCIA to (15..20).random(),
                AtributoMagico.CREATIVIDAD to (10..15).random(),
                AtributoMagico.ETICA to (10..15).random(),
                AtributoMagico.CORAJE to (15..30).random(),
                AtributoMagico.LEALTAD to (15..20).random()
            )
            val habilidadesHufflepuff = mapOf<String, Int>(
                AtributoMagico.HABILIDAD to (10..15).random(),
                AtributoMagico.INTELIGENCIA to (10..15).random(),
                AtributoMagico.CREATIVIDAD to (10..15).random(),
                AtributoMagico.ETICA to (15..20).random(),
                AtributoMagico.CORAJE to (10..15).random(),
                AtributoMagico.LEALTAD to (15..20).random()
            )
            val habilidadesRavenclaw = mapOf<String, Int>(
                AtributoMagico.HABILIDAD to (10..15).random(),
                AtributoMagico.INTELIGENCIA to (20..25).random(),
                AtributoMagico.CREATIVIDAD to (20..25).random(),
                AtributoMagico.ETICA to (10..15).random(),
                AtributoMagico.CORAJE to (5..10).random(),
                AtributoMagico.LEALTAD to (15..25).random()
            )

            if (casa == CASA_SLYTHERIN) listaAtributosCasa = habilidadesSlytherin
            else if (casa == CASA_GRIFFINDORF) listaAtributosCasa = habilidadesGriffindorf
            else if (casa == CASA_RAVENCLAW) listaAtributosCasa = habilidadesRavenclaw
            else listaAtributosCasa = habilidadesHufflepuff

            // Inicializamos una lista vacía para añadir los atributos
            val listaAtributoMagico: MutableList<AtributoMagico> = mutableListOf()
            for ((clave, valor) in listaAtributosCasa) {
                listaAtributoMagico.add(AtributoMagico(clave, valor))
            }

            return listaAtributoMagico
        }

        /**
         * Función para asignar los atributos a una lista de Atributos Mágicos
         */
        fun setAtributos(
            habilidad: Int, inteligencia: Int, creatividad: Int, etica: Int,
            coraje: Int, lealtad: Int
        ): MutableList<AtributoMagico> {

            val listaAtributosMagico: MutableList<AtributoMagico> = mutableListOf()

            listaAtributosMagico.add(AtributoMagico(AtributoMagico.HABILIDAD, habilidad))
            listaAtributosMagico.add(AtributoMagico(AtributoMagico.INTELIGENCIA, inteligencia))
            listaAtributosMagico.add(AtributoMagico(AtributoMagico.CREATIVIDAD, creatividad))
            listaAtributosMagico.add(AtributoMagico(AtributoMagico.ETICA, etica))
            listaAtributosMagico.add(AtributoMagico(AtributoMagico.CORAJE, coraje))
            listaAtributosMagico.add(AtributoMagico(AtributoMagico.LEALTAD, lealtad))

            return listaAtributosMagico
        }
    }
}