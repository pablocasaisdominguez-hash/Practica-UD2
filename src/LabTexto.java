import java.util.Scanner;
public class LabTexto {
    static final int L_Minima =8;
    static final int letras_Alfabeto =26;
    static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String menu;
        int menuInt=0;
        do {
            boolean menucomprobador=false;
            do {
                System.out.println("===== LabTexto =====");
                System.out.println("1. Analizar frase");
                System.out.println("2. Cifrado cesar");
                System.out.println("3. Validar Contraseña");
                System.out.println("0. Salir");
                System.out.println("Elige una opción:");
                try {
                    menu = entrada.nextLine();
                    menuInt=Integer.parseInt(menu);
                    menucomprobador=true;
                }catch(NumberFormatException e){
                    System.out.println("\"Introduzca un numero\"");

                }
            }while (menucomprobador==false);
            switch (menuInt) {
                case 0:{
                    System.out.println("Saliendo....");
                    break;
                }
                case 1:{
                    System.out.print("Introduce tu frase: ");
                    String frase = entrada.nextLine();
                    int caracteres= frase.length();
                    System.out.println("Caracteres: "+caracteres);
                    int palabras=1;
                    String frasesin=frase.trim();
                    int longitud= frasesin.length();
                    for (int contador = 0; contador<longitud; contador++){
                        if (frasesin.charAt(contador) ==' '){
                            if (frasesin.charAt(contador-1)!=' '){
                                palabras++;
                            }

                        }
                    }
                    System.out.println("Palabras: "+palabras);
                    int vocales=0;
                    int mayusculas=0;
                    int digitos=0;
                    for (int contador = 0; contador<longitud; contador++){
                        String fraseMayusculas=frasesin.toUpperCase();
                        if (fraseMayusculas.charAt(contador)=='A'||fraseMayusculas.charAt(contador)=='E'||fraseMayusculas.charAt(contador)=='I'||fraseMayusculas.charAt(contador)=='O'||fraseMayusculas.charAt(contador)=='U'){
                            vocales++;
                        }
                        if (frasesin.charAt(contador)>='A'&&frasesin.charAt(contador)<='Z'){
                            mayusculas++;
                        }
                        if (frasesin.charAt(contador)>='0'&&frasesin.charAt(contador)<='9'){
                            digitos++;
                        }
                    }
                    System.out.println("Vocales: "+vocales+" | Mayúsculas: "+mayusculas+" | Dígitos: "+ digitos);
                    String fr_quitada =frasesin.toLowerCase().replace(" ","");
                    int longsin= fr_quitada.length();
                    String fr_quitada_reves="";
                    for (int contador = longsin-1; contador>=0; contador--){
                    fr_quitada_reves+=fr_quitada.charAt(contador);
                    }
                    if(fr_quitada.equals(fr_quitada_reves)){
                        System.out.println("Es un palindromo");
                    }else {
                        System.out.println("No es un palíndromo");
                    }

                }

            }

        } while (menuInt!=0);




    }
}