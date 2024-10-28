package Metodos;
import java.io.File;
import java.util.Scanner;

public class MenuTreball {

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        String opcionesMenu = MostrarMenu.menuString();
        System.out.println(opcionesMenu);
        String menuSelection = "";
        
    do
    {
        String readResult = scanner.nextLine();
        if(readResult != null){
            menuSelection = readResult.toLowerCase();
        }
        
        switch (menuSelection) {
            case "1":
                cambiarTresLetras();
                System.out.println(opcionesMenu);
                break;

            case "2":
                buscarDirectorio();
                System.out.println(opcionesMenu);
                break;

            case "3":
                buscarArchivo();
                System.out.println(opcionesMenu);
                break;

            case "4":
                mostrarPadres();
                System.out.println(opcionesMenu);
                break;
                
            case "5":
                listaDirectorio();
                System.out.println(opcionesMenu);
                break;

                case "exit":
                System.out.println("Saliendo del programa...");
                break;

            default:
                System.out.println("Por favor, ingrese una opción válida.");  // Mensaje para opción no válida
                System.out.println(opcionesMenu);
                break;
            
        }
        
    }while(!menuSelection.equals("exit"));
    }
        
    private static void cambiarTresLetras() {
        System.out.println("Canvia extensió d'un fitxer");
        Scanner scanner2 = new Scanner(System.in);
        boolean maxLletres = false;
        System.out.println("Indica DUES cadenes de TRES lletres per canviarles entre si: ");
        String cadenaDeText1;
        String cadenaDeText2;
        do {
            System.out.println("Extensió que vols eliminar: ");
            cadenaDeText1 = scanner2.nextLine();
            System.out.println("Nova extensió: ");
            cadenaDeText2 = scanner2.nextLine();
            if (cadenaDeText1.length() == 3 && cadenaDeText2.length() == 3) {
                maxLletres = true;
            }

            else {
                System.out.println("Han de ser 3 LLETRES!");
            }

        } while (!maxLletres);
        TreballFile.CambiarLetras(cadenaDeText1, cadenaDeText2);
    }

    private static void buscarDirectorio() {
        System.out.println("Buscar directori a partir de la ruta");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriu una ruta a una carpeta:");
        String pathDirectori = scanner.nextLine();
        File carpeta = new File(pathDirectori);
        TreballFile.buscarRutaCarpeta(carpeta);
    }

    
    private static void buscarArchivo() {
        System.out.println("Buscar un fitxer per nom");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriu una ruta a un fitxer:");
        String pathFitxer = scanner.nextLine();
        File file = new File(pathFitxer);
        TreballFile.buscarFitxer(file);
    }
    
    private static void mostrarPadres() {
        System.out.println("Mostrar directoris pares");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriu una ruta a una carpeta:");
        String pathDirectori = scanner.nextLine();
        File carpeta = new File(pathDirectori);
        TreballFile.mostrarPares(carpeta); 
    }

    private static void listaDirectorio() {
        System.out.println("Llista de elements dins un directori");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriu una ruta a una carpeta:");
        String pathDirectori = scanner.nextLine();
        File carpeta = new File(pathDirectori);
        TreballFile.llistaArxius(carpeta);
    }

  
}