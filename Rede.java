package UD03.rede;

/**
 *
 * @author ioubidios
 */
public class Rede {

    public static void main(String[] args) {
        String[] ips = {"192.168.0.9", "192.168.100.0", "255.255.255.255",
            "0.0.0.0"};
        String ip = "192.168.0.9";
        System.out.println(validarIP(ip));
        System.out.println(buscarIP(ip, ips));
    }

    public static boolean validarIP(String ip) {
        boolean IPValida = true;
        if (ip.isEmpty() || ip.startsWith(".") || ip.endsWith(".")) { //Si empieza o termina con un punto, no es válido
            IPValida = false;
        } else {
            String[] numerosIP = ip.split("\\.");
            if (numerosIP.length != 4) {
                //Si el resultado no es un array de longitud 4, 
                //indicando que hay 3 puntos y 4 números, no es válido
                IPValida = false;
            } else {
                int[] numeros = new int[4];
                for (int i = 0; i < numeros.length; i++) {
                    if (validarNumero(numerosIP[i])) {
                        numeros[i] = Integer.parseInt(numerosIP[i]);
                    } else {
                        IPValida = false;
                        break;
                    }
                }
                
                for (int i = 0; i < numeros.length; i++) {
                    if (numeros[i] < 0 || numeros[i] > 255) {
                        // Si el entero no está entre 0 y 255, no es válido
                        IPValida = false;
                    }
                }
            }
        }

        return IPValida;
    }

    public static boolean validarNumero(String numero) {
        boolean numeroValido = true;
        if (numero.isEmpty() || numero.length() > 1 && (numero.startsWith("0") || numero.startsWith("00"))) {
            //Si la posición del array está vacío o tiene algún cero a la izquierda, no es válido
            numeroValido = false;
        } else {
            char[] digitos = numero.toCharArray();
            for (int j = 0; j < numero.length(); j++) {
                if (!Character.isDigit(digitos[j])) { //Si hay algún caracter que no sea un dígito, no es válido
                    numeroValido = false;
                    break;
                }
            }
        }
        return numeroValido;
    }

    public static int buscarIP(String ip, String[] ips) {
        int Busqueda = -1;
        if (validarIP(ip)) {
            for (int i = 0; i < ips.length; i++) {
                if (ip.equals(ips[i])) {
                    Busqueda = i;
                    break;
                }
            }
        }
        return Busqueda;
    }

}
