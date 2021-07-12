package PatternMatching;
/**
 * Clase que hace referencia a pattern matching con el cual se podra
 * hacer uso de los metodos que corresponden a los algoritmo: brute-force,
 * Boyer Moore y Knuth Morrus Pratt.
 * @author Jhon Franklin Panocca Merma
 */
public class PatternMatching {

    /**
     * Recibe como parametros dos cadenas de texto, realiza una 
     * comparación con cada carácter. Al encontrar coincidencia devuelve 
     * la pocision.
     * @param text Cadena de carácteres. El texto donde se hara la busqueda.
     * @param pattern Cadena e carácteres. El patron a buscar.
     * @return Retorna la posición donde encontro el patron, de lo contrario -1.
     */
    public static int bruteForce(String text, String pattern){
        int length = text.length();
        int plength = pattern.length();

        for (int i = 0; i < length-plength; i++) {
            int j = 0;
            while((j<plength)&&(text.charAt(i+j)==pattern.charAt(j)))
                j++;
            if (j==plength)
                return i;
        }
        return -1;
    }

    /**
     * 
     * @param text
     * @param pattern
     * @return
     */
    public static int boyerMoore(String text, String pattern){
        return -1;
    }

    /**
     * 
     * @param text
     * @param pattern
     * @return
     */
    public static int knuthMorrisPratt(String text, String pattern){
        return -1;
    }
}
