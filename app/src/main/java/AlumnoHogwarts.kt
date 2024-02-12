import kotlin.random.Random

/**
 * Clase Alumno Hogwarts, en su constructor base vamos a inicializar dos atributos
 * @param nombre nombre del alumno o alumna
 * @param familiaMaggle indica si tiene familia Maggle o no
 */
data class AlumnoHogwarts(var nombre: String, var familiaMaggle: Boolean) {
    // Resto de atributos del alumno
    var casa: String
    var apellido: String
    // Lista de los atributos del alumno / de la alumna
    var listaAtributos: List<AtributoMagico>

    // Constructor secundario para poder insertar los datos del alumno cuando los leemos de la BBDD
    constructor(
        nombre: String, familiaMaggle: Boolean, casa: String, apellido: String,
        habilidad: Int, inteligencia: Int, creatividad: Int, etica: Int, coraje: Int, lealtad: Int
    ) : this(nombre, familiaMaggle) {

        this.casa = casa;
        this.apellido = apellido;
        this.listaAtributos =
            CasaHogwarts.setAtributos(habilidad, inteligencia, creatividad, etica, coraje, lealtad)
    }

    init {
        var casas: MutableList<String> = mutableListOf()
        // Si tiene familia Maggle no puede pertenecer a la casa Slytherinaa
        casas.add(CasaHogwarts.CASA_GRIFFINDORF)
        casas.add(CasaHogwarts.CASA_HUFFLEPLUFF)
        casas.add(CasaHogwarts.CASA_RAVENCLAW)
        if (!familiaMaggle) casas.add(CasaHogwarts.CASA_SLYTHERIN)
        // Obtenemos una casa aleatoria de las que tenemos cargadas
        // Esta forma nos introduce la misma probabilidad a las 4 casas
        this.casa = casas[Random.nextInt(0, casas.size)]
        // Generamos un apellido en base a la casa ya escogida
        this.apellido = CasaHogwarts.getApellido(this.casa)
        // Generamos los atributos en base a la casa escogida
        this.listaAtributos = CasaHogwarts.getAtributos(this.casa)
    }
}