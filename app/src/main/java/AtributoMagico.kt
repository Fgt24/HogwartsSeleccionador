/**
 *  Clase para representar un atributo mágico
 */
data class AtributoMagico(var nombre: String, var valor: Int) {

    companion object{
        // Constantes para los atributos
        val HABILIDAD: String = "Habilidad"
        val INTELIGENCIA: String = "Inteligencia"
        val CREATIVIDAD: String = "Creatividad"
        val ETICA: String = "Etica"
        val CORAJE: String = "Coraje"
        val LEALTAD: String = "Lealtad"
    }

    override fun toString(): String {
        return "$nombre = $valor"
    }

}