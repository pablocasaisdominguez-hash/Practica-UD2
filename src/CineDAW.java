import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programa de menu de cine para ver la sala comprar las entradas y ver las estadísticas
 * @author pablo
 */
public class CineDAW {
    static final int nfilas = 6;
    static final int BUTACAS_POR_FILA = 8;
    static final char libre='-';
    static final char ocupada = 'X';
    public static void main(String[] args) {
        String sala = "";
        for (int fila = 1; fila <= nfilas; fila++) {
            for (int columna = 1; columna <= BUTACAS_POR_FILA; columna++) {
              if((columna == 1 && fila == 1) || (columna == 5 && fila == 3) || (columna == 8 && fila == 6)){
                  sala = sala + ocupada;}else{
                  sala = sala + libre;
              }

            }

        }
        Scanner entrada = new Scanner(System.in);
        int menu = 0;
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
                    for (char filap = '@'; filap <= 'F'; filap++) {
                        for (int columnap = 0; columnap <= BUTACAS_POR_FILA; columnap++) {
                            if (filap == '@' && columnap == 0) {
                                System.out.print("  ");
                            } else {
                                if (columnap != 4) {
                                    if (filap == '@') {
                                        System.out.print(columnap + "  ");
                                    } else {
                                        if (columnap == 0) {
                                            System.out.print(filap);
                                        } else {
                                            if (columnap == 1 && filap == 'A' || columnap == 5 && filap == 'C' || columnap == 8 && filap == 'F') {
                                                System.out.print(" X ");
                                            } else {
                                                System.out.print(" - ");
                                            }
                                        }
                                    }
                                } else {
                                    if (filap == '@') {
                                        System.out.print(columnap + "         ");
                                    } else {
                                        if (columnap == 0) {
                                            System.out.print(filap + "           ");
                                        } else {
                                            if (columnap == 1 && filap == 'A' || columnap == 5 && filap == 'C' || columnap == 8 && filap == 'F') {
                                                System.out.print("X     ");
                                            } else {
                                                System.out.print(" -        ");
                                            }
                                        }
                                    }
                                }

                            }
                        }
                        System.out.println("");
                    }
                    System.out.println("(- libre, X ocupada)");
                }
                case 2:{
                   int espacio = sala.indexOf(libre);
                   if (espacio==-1){
                       System.out.println("La sala esta llena");

                    }else {
                       String lfila="";
                       char charfila='0';
                       do {
                           System.out.println("Introduce la fila. Entre la A y la F");
                           lfila= entrada.nextLine();
                           lfila.trim().toUpperCase();
                           charfila=lfila.charAt(0);
                           if ((lfila.length() != 1) || ((lfila.charAt(0) > 'F') || (lfila.charAt(0) > 'A'))){
                               System.out.println("El valor introducido es invalido, introducelo de nuevo");
                           }

                       }while ((lfila.length() != 1) || (lfila.charAt(0) > 'F')|| (lfila.charAt(0) > 'A'));
                       int lcolumna=0;
                       do {
                         try {
                             System.out.println("Introduce la columna(1-8)");
                             lcolumna=entrada.nextInt();
                         }catch (InputMismatchException e){
                             System.out.println("Debes introducir un número entero (1-8)");
                             entrada.nextLine();
                         }
                         if(lcolumna<1||lcolumna> BUTACAS_POR_FILA){
                             System.out.println("El numero debe ser entre 1 y 8");
                         }
                       }while (lcolumna<1||lcolumna> BUTACAS_POR_FILA);
                       int posicion = (charfila - 'A') * BUTACAS_POR_FILA + (lcolumna - 1);
                       boolean ocupada = sala.charAt(posicion) == 'X';
                       if (ocupada==false){
                           System.out.println("La butaca" + posicion+ "esta libre");
                           System.out.println("Se procedera a la compra");



                       }else {
                           System.out.println("Tu butaca esta ocupada");
                       }

                   }




                }

                }





            }
            while (menu != 0) ;
        }
    }
