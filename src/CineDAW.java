import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CineDAW {
    public static void main(String[] args) {
        String sala = "";
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                sala = sala + "-";
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
                case 1:
                    System.out.println("            P A N T A L L A");
                    for (char filap = '@'; filap <= 'F'; filap++) {
                        if (filap == '@') {
                            System.out.print("  ");
                        } else {
                            System.out.print(filap);
                        }
                        for (int columnap = 1; columnap <= 8; columnap++) {
                            if (filap == '@') {
                                if (columnap == 4) {
                                    System.out.print(columnap + "    ");
                                } else {
                                    System.out.print(columnap);
                                }
                            }else {
                                if (columnap == 4) {
                                    System.out.print("-" + "    ");
                                } else {
                                    if (filap == 'A' && columnap == 1 || filap == 'c'&& columnap==5){
                                        System.out.print("X");
                                    }else{
                                    System.out.print("-");}
                                }
                            }
                        }
                    }

            }


        } while (menu != 0);
    }
}
