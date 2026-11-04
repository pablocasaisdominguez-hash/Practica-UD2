import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programa de menu de cine para ver la sala comprar las entradas y ver las estadísticas
 * mediante un do while y una string que conforma la documentacion de asientos libres
 *
 * @author pablo
 */
public class CineDAW {
    static final int nfilas = 6;
    static final int BUTACAS_POR_FILA = 8;
    static final char libre = '-';
    static final char ocupada = 'X';
    static final int precio_infantil = 120;
    static final int precio_senior = 600;
    static final int precio_general = 850;
    static final int suplemento = 150;
    static final double miercoles = 0.70;
    static final int capacidad_cine=48;

    public static void main(String[] args) {
        String sala = "";
        for (int fila = 1; fila <= nfilas; fila++) {
            for (int columna = 1; columna <= BUTACAS_POR_FILA; columna++) {
                sala=sala+"-";
            }
        }
        Scanner entrada = new Scanner(System.in);
        int menu = 0;
        int vendidas = 0;
        double recaudacion=0;
        do {
            System.out.println("====CineDaw====");
            System.out.println("1. ver sala");
            System.out.println("2. Comprar entrada");
            System.out.println("3. Estadísticas");
            System.out.println("0. Salir");
            try {
                System.out.println("Introduce a donde quieres ir:");
                menu = entrada.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Introduce un valor válido");
                entrada.nextLine();

            }
            switch (menu) {
                case 1: {
                    System.out.println("            P A N T A L L A");
                    int contador=0;
                    for (char filap = '@'; filap <= 'F'; filap++) {
                        for (int columnap = 0; columnap <= BUTACAS_POR_FILA; columnap++) {
                            if (filap == '@' && columnap == 0) {
                                System.out.print("  ");
                            } else {
                                if (columnap != 4) {
                                    if (filap == '@') {
                                        System.out.print(columnap + "   ");
                                    } else {
                                        if (columnap == 0) {
                                            System.out.print(filap+" ");
                                        } else {
                                            if (sala.charAt(contador)=='X'){
                                                System.out.print("X   ");

                                            } else if (sala.charAt(contador)=='-') {
                                                System.out.print("-   ");
                                            }
                                            contador++;
                                        }
                                    }
                                } else {
                                    if (filap == '@') {
                                        System.out.print(columnap + "         ");
                                    } else {
                                        if (columnap == 0) {
                                            System.out.print(filap + "           ");
                                        } else {
                                            if (sala.charAt(contador)=='X'){
                                                System.out.print("X         ");

                                            } else if (sala.charAt(contador)=='-') {
                                                System.out.print("-         ");
                                            }
                                            contador++;
                                        }

                                    }
                                }

                            }
                        }
                        System.out.println("");
                    }
                    System.out.println("(- libre, X ocupada)");
                    break;
                }
                case 2: {
                    int espacio = sala.indexOf(libre);
                    if (espacio == -1) {
                        System.out.println("La sala esta llena");

                    } else {
                        String lfila = "";

                        do {
                            System.out.println("Introduce la fila. Entre la A y la F");
                            lfila = entrada.nextLine().trim().toUpperCase();
                            if ((lfila.length() != 1) || ((lfila.charAt(0) > 'F') || (lfila.charAt(0) < 'A'))) {
                                System.out.println("El valor introducido es no es valido, introducelo de nuevo");
                            }
                        } while ((lfila.length() != 1) || (lfila.charAt(0) > 'F') || (lfila.charAt(0) < 'A'));
                        char charfila = lfila.charAt(0);
                        int lcolumna = 0;
                        do {
                            try {
                                System.out.println("Introduce la columna(1-8)");
                                lcolumna = entrada.nextInt();
                                if (lcolumna < 1 || lcolumna > BUTACAS_POR_FILA) {
                                    System.out.println("El numero debe ser entre 1 y 8");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Debes introducir un número entero (1-8)");
                                entrada.nextLine();
                            }

                        } while (lcolumna < 1 || lcolumna > BUTACAS_POR_FILA);
                        int posicion = (charfila - 'A') * BUTACAS_POR_FILA + (lcolumna - 1);
                        boolean ocupada = sala.charAt(posicion) == 'X';
                        if (ocupada == false) {
                            System.out.println("La butaca " + charfila+lcolumna + " esta libre");
                            System.out.println("Se procedera a la compra");
                            System.out.print("Introduce la edad del expectador: ");
                            int precio;
                            int edad;
                            do {
                                 edad = entrada.nextInt();
                                 if (edad>=120||edad<0){
                                     System.out.println("Introduce una edad válida (1-120)");
                                 }
                            }while (edad>=120||edad<0);

                            String tarifa;
                            if (edad < 12) {
                                precio = precio_infantil;
                                tarifa = "Infantil";
                            } else if (edad > 65) {
                                precio = precio_senior;
                                tarifa = "Senior";
                            } else {
                                precio = precio_general;
                                tarifa = "General";
                            }
                            System.out.println("Día de la semana (1=lunes ... 7=domingo)");
                            int dia_semana = entrada.nextInt();
                            switch (dia_semana) {
                                case 1:
                                case 2:
                                case 4:
                                case 5:
                                    tarifa=tarifa+"sin dia con precio diferente";
                                    break;
                                case 3: {
                                    precio = (int) Math.round(precio * miercoles);
                                    tarifa = tarifa + " + " + "día del espectador";
                                    break;
                                }
                                case 6:
                                case 7: {
                                    precio = precio + suplemento;
                                    tarifa = tarifa + " + " + "fin de semana";
                                    break;
                                }
                            }
                            System.out.println("tu tarifa es: " + tarifa);
                            int euros = precio / 100;
                            int centimos = precio % 100;
                            String ternario = centimos < 10 ? "0" + centimos : "" + centimos;
                            System.out.println("Debes pagar: " + euros + "," + ternario+"€");
                            System.out.println("Entrada vendida: fila " + charfila + ", butaca " + lcolumna);
                            sala = sala.substring(0, posicion) + 'X' + sala.substring(posicion + 1);
                            vendidas++;
                            recaudacion+=precio;
                        } else {
                            System.out.println("Tu butaca esta ocupada");
                        }
                    }
                    break;
                }
                case 3: {
                    String textoEntradas=vendidas==1?"1 entrada": vendidas + " entradas";
                    System.out.println("Entradas vendidas:  "+ textoEntradas);
                    recaudacion/=100;
                    System.out.println("Recaudación: " +recaudacion + " €");
                   int ocupadas=0;
                   int libres=0;
                    for (int posicionf=0;posicionf<capacidad_cine;posicionf++){
                        char lectura= sala.charAt(posicionf);
                        if (lectura=='-'){
                            continue;
                        } else if (lectura=='X') {
                            ocupadas++;
                        }
                    }
                    libres=capacidad_cine-ocupadas;
                    System.out.println("Butacas ocupadas: "+ocupadas+" | libres: "+libres);
                    double ocupacion = Math.round((double) ocupadas / capacidad_cine * 10000) / 100.0;
                    System.out.println("Ocupación: "+ocupacion+"%");
                    break;


                }
                default:
                    System.out.println("Introduce un numero valido");
                    break;


            }
        }
        while (menu != 0);
        entrada.close();
    }
}
