/**
 * Clase para utilizar funciones de apoyo de tipo estático para que podamos reutilizar
 */
class FuncionesApoyo {

    companion object{
        /**
         * Función que nos cambia un Int por un Boolean siempre que sea >0 (TRUE)
         * Motivo de esta función: SQLite no tiene tipo de dato boolean
         */
        fun integerToBoolean(valor: Int): Boolean{
            return valor>0;
        }

        /**
         * Función que nos cambia un Boolean por Int
         * Motivo de esta función: SQLite no tiene tipo de dato boolean
         */
        fun booleanToInteger(valor: Boolean): Int{
            if(valor)
                return 1;
            else
                return 0;
        }

        /**
         * Función que nos cambia un Boolean por un String
         * Motivo de esta función: mostrar en una cadena según el Boolean SI o NO
         */
        fun booleanToString(valor: Boolean): String{
            if(valor)
                return "SI"
            else
                return "NO"
        }

    }

}