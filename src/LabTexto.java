import java.util.Locale;
import java.util.Scanner;

public class LabTexto {
    static final int L_Minima = 8;
    static final int letras_Alfabeto = 26;
    static final int maxreglas = 4;

    static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String menu;
        int menuInt = 0;
        do {
            boolean menucomprobador = false;
            do {
                System.out.println("===== LabTexto =====");
                System.out.println("1. Analizar frase");
                System.out.println("2. Cifrado cesar");
                System.out.println("3. Validar Contraseña");
                System.out.println("0. Salir");
                System.out.println("Elige una opción:");
                try {
                    menu = entrada.nextLine();
                    menuInt = Integer.parseInt(menu);
                    menucomprobador = true;
                } catch (NumberFormatException e) {
                    System.out.println("\"Introduzca un numero\"");

                }
            } while (menucomprobador == false);
            String frase;
            switch (menuInt) {
                case 0: {
                    System.out.println("Saliendo....");
                    break;
                }
                case 1: {
                    System.out.print("Introduce tu frase: ");
                    frase = entrada.nextLine();
                    int caracteres = frase.length();
                    System.out.println("Caracteres: " + caracteres);
                    int palabras = 1;
                    String frasesin = frase.trim();
                    int longitud = frasesin.length();
                    for (int contador = 0; contador < longitud; contador++) {
                        if (frasesin.charAt(contador) == ' ') {
                            if (frasesin.charAt(contador - 1) != ' ') {
                                palabras++;
                            }

                        }
                    }
                    System.out.println("Palabras: " + palabras);
                    int vocales = 0;
                    int mayusculas = 0;
                    int digitos = 0;
                    for (int contador = 0; contador < longitud; contador++) {
                        String fraseMayusculas = frasesin.toUpperCase();
                        if (fraseMayusculas.charAt(contador) == 'A' || fraseMayusculas.charAt(contador) == 'E' || fraseMayusculas.charAt(contador) == 'I' || fraseMayusculas.charAt(contador) == 'O' || fraseMayusculas.charAt(contador) == 'U') {
                            vocales++;
                        }
                        if (frasesin.charAt(contador) >= 'A' && frasesin.charAt(contador) <= 'Z') {
                            mayusculas++;
                        }
                        if (frasesin.charAt(contador) >= '0' && frasesin.charAt(contador) <= '9') {
                            digitos++;
                        }
                    }
                    System.out.println("Vocales: " + vocales + " | Mayúsculas: " + mayusculas + " | Dígitos: " + digitos);
                    String fr_quitada = frasesin.toLowerCase().replace(" ", "");
                    int longsin = fr_quitada.length();
                    String fr_quitada_reves = "";
                    for (int contador = longsin - 1; contador >= 0; contador--) {
                        fr_quitada_reves += fr_quitada.charAt(contador);
                    }
                    if (fr_quitada.equals(fr_quitada_reves)) {
                        System.out.println("Es un palindromo");
                    } else {
                        System.out.println("No es un palíndromo");
                    }
                    break;

                }
                case 2: {
                    System.out.print("Introduce la frase a cifrar: ");
                    frase = entrada.nextLine();
                    System.out.println();
                    System.out.println("Cuanto quieres desplazar el texto: ");
                    boolean entero = false;
                    int desplazamientoin = 0;
                    do {
                        try {
                            String desplazamiento = entrada.nextLine();
                            desplazamientoin = Integer.parseInt(desplazamiento);
                            entero = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Introduce un número entero");
                        }
                    } while (entero == false);
                    int desplazamientoReal = (desplazamientoin % letras_Alfabeto + letras_Alfabeto) % letras_Alfabeto;
                    String textoCifrado = "";
                    for (int i = 0; i < frase.length(); i++) {
                        char letra = frase.charAt(i);
                        if (letra >= 'A' && letra <= 'Z') {
                            char cifrada = (char) ('A' + (letra - 'A' + desplazamientoReal) % letras_Alfabeto);
                            textoCifrado += cifrada;
                        } else if (letra >= 'a' && letra <= 'z') {
                            char cifrada = (char) ('a' + (letra - 'a' + desplazamientoReal) % letras_Alfabeto);
                            textoCifrado += cifrada;
                        } else {
                            textoCifrado += letra;
                        }
                    }
                    System.out.println("Cifrado:" + textoCifrado);
                    break;
                }
                case 3: {
                    System.out.print("Usuario: ");
                    String usuario = entrada.nextLine();
                    System.out.println();
                    System.out.print("introduce la tu contraseña:");
                    String contraseña = entrada.nextLine();
                    System.out.println();
                    boolean caracteres = contraseña.length() >= L_Minima;
                    boolean mayuscula = false;
                    for (int i = 0; i < contraseña.length(); i++) {
                        if (contraseña.charAt(i) >= 'A' && contraseña.charAt(i) <= 'Z') {
                            mayuscula = true;
                        }
                    }
                    boolean digito = false;
                    for (int i = 0; i < contraseña.length(); i++) {
                        if (contraseña.charAt(i) >= '0' && contraseña.charAt(i) <= '9') {
                            digito = true;
                        }
                    }
                    boolean nousuario = contraseña.toLowerCase().indexOf(usuario.toLowerCase()) == -1;
                    int reglasCumplidas = 0;
                    if (caracteres == true) {
                        System.out.println("[OK] Al menos 8 caracteres");
                        reglasCumplidas++;
                    } else {
                        System.out.println("[--] Al menos 8 caracteres");

                    }
                    if (mayuscula == true) {
                        System.out.println("[OK] Una Mayúscula");
                        reglasCumplidas++;
                    } else {
                        System.out.println("[--] Una Mayúscula");
                    }
                    if (digito == true) {
                        System.out.println("[OK] Un dígito");
                        reglasCumplidas++;
                    } else {
                        System.out.println("[--] Un dígito");

                    }
                    if (nousuario == true) {
                        System.out.println("[OK] No contiene el usuario");
                        reglasCumplidas++;
                    } else {
                        System.out.println("[--] No contiene el usuario");

                    }
                    String nivel = (reglasCumplidas == maxreglas) ? "FUERTE" : (reglasCumplidas >= 2) ? "MEDIA" : "DÉBIL";

                    System.out.println("Nivel de la contraseña: (" + nivel + "/" + maxreglas + ")");
                    break;
                }
                default: {
                    System.out.println("Introduce un número válido");
                    break;
                }

            }

        } while (menuInt != 0);


    }
}