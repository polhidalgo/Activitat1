package Metodos;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TreballFile {
    private Scanner scanner = new Scanner(System.in);

    /*
     * public static void Inici() {
     * Scanner scanner = new Scanner(System.in);
     * boolean maxLletres = false;
     * System.out.println("Quin és el nom del fitxer a cercar?");
     * String nomDelFitxer = scanner.nextLine();
     * System.out.println("Escriu una ruta a una carpeta:");
     * String pathDirectori = scanner.nextLine();
     * System.out.println("Indica dues cadenes de 3 lletres:");
     * String cadenaDeText1;
     * String cadenaDeText2;
     * do {
     * cadenaDeText1 = scanner.nextLine();
     * cadenaDeText2 = scanner.nextLine();
     * if (cadenaDeText1.length() == 3 && cadenaDeText2.length() == 3) {
     * maxLletres = true;
     * }
     * 
     * else {
     * System.out.println("Han de ser 3 LLETRES!");
     * }
     * 
     * } while (!maxLletres);
     * 
     * File arxiu = new File(nomDelFitxer);
     * File carpeta = new File(pathDirectori);
     * 
     * Treball(arxiu);
     * Treball(carpeta);
     * 
     * }
     * 
     * private static void Treball(File f) {
     * boolean esPare = false;
     * if (f.exists()) {
     * System.out.println(f + " existeix");
     * if (f.isFile()) {
     * System.out.println("El nom del arxiu es: " + f.getName());
     * System.out.println("La ruta es: " + f.getAbsolutePath());
     * } else {
     * System.out.println("Es un directori");
     * File[] arrayElements = f.listFiles();
     * System.out.println("El contingut de " + f.getAbsolutePath() + " és:");
     * for (int i = 0; i < arrayElements.length; i++) {
     * File h = arrayElements[i];
     * if (h.isDirectory()) {
     * System.out.print("[DIR] ");
     * } else {
     * System.out.print("[FIT] ");
     * }
     * System.out.println(h.getName());
     * }
     * 
     * String pareDirectorio = f.getParent();
     * 
     * do {
     * File directoriPare = new File(pareDirectorio);
     * System.out.println("El seu pare és " + pareDirectorio);
     * pareDirectorio = directoriPare.getParent();
     * if (pareDirectorio == "C:\\") {
     * esPare = true;
     * }
     * } while (!esPare);
     * 
     * }
     * }
     * 
     * else {
     * System.out.println("El path " + f + " no sha trobat");
     * }
     * }
     */
    public static void buscarRutaCarpeta(File f) {
        Scanner scanner = new Scanner(System.in);

        if (f.exists()) {
            System.out.println(f.getName() + " existeix");
            if (f.isDirectory()) {
                System.out.println(f.getName() + " és un directori");
                System.out.println("El seu path absolut és: " + f.getAbsolutePath());
                System.out.println("///////// Presiona ENTER per continuar... /////////");
                scanner.nextLine();
            }
        } else {
            System.out.println("El path " + f + " no sha trobat");
            System.out.println("///////// Presiona ENTER per continuar... /////////");
            scanner.nextLine();
        }
    }

    public static void CambiarLetras(String cadena1, String cadena2) {
        Scanner scanner = new Scanner(System.in);
        Path currentDirectory = Paths.get("").toAbsolutePath();
        String nomFitxer;
        String ultimesLletres;
        File d = new File(currentDirectory.toString());
        System.out.println("El teu Directori es: " + d);
        File[] arrayElements = d.listFiles();
        boolean resultat;
        for (int i = 0; i < arrayElements.length; i++) {
            File h = arrayElements[i];
            if (h.isFile()) {

                nomFitxer = h.getName();
                File origenDocument = new File(d + "/" + nomFitxer);
                ultimesLletres = nomFitxer.substring(nomFitxer.length() - 3);
                if (ultimesLletres.equals(cadena1)) {
                    String nouNom = nomFitxer.substring(0, nomFitxer.length() - 3) + cadena2;
                    // nomFitxer = nouNom;
                    File destiDocument = new File(d + "/" + nouNom);
                    resultat = origenDocument.renameTo(destiDocument);
                    System.out.println("S'ha renombrat? " + resultat);
                }
            }
        }
        System.out.println("///////// Presiona ENTER per continuar... /////////");
        scanner.nextLine();
    }

    public static void buscarFitxer(File f) {
        Scanner scanner = new Scanner(System.in);
        if (f.exists()) {
            System.out.println(f + " existeix");
            if (f.isFile()) {
                System.out.println("El nom del arxiu es: " + f.getName());
                System.out.println("La ruta es: " + f.getAbsolutePath());
                System.out.println("///////// Presiona ENTER per continuar... /////////");
                scanner.nextLine();
            }
        } else {
            System.out.println("El path " + f + " no sha trobat");
            System.out.println("///////// Presiona ENTER per continuar... /////////");
            scanner.nextLine();
        }
    }

    public static void mostrarPares(File f) {
        Scanner scanner = new Scanner(System.in);
        boolean esPare = false;
        if (f.exists()) {
            System.out.println(f.getName() + " existeix");
            if (f.isDirectory()) {
                String pareDirectorio = f.getParent();
                do {
                    File directoriPare = new File(pareDirectorio);
                    System.out.println("El seu pare és " + pareDirectorio);
                    pareDirectorio = directoriPare.getParent();
                    if (pareDirectorio.equals("C:\\")) {
                        esPare = true;
                    }
                } while (!esPare);
                System.out.println("///////// Presiona ENTER per continuar... /////////");
                scanner.nextLine();
            }
        } else {
            System.out.println("El path " + f + " no sha trobat");
            System.out.println("///////// Presiona ENTER per continuar... /////////");
            scanner.nextLine();
        }
    }

    public static void llistaArxius(File f) {
        Scanner scanner = new Scanner(System.in);
        if (f.exists()) {
            System.out.println(f.getName() + " existeix");
            if (f.isDirectory()) {
                File[] arrayElements = f.listFiles();
                System.out.println("El contingut de " + f.getAbsolutePath() + " és:");
                for (int i = 0; i < arrayElements.length; i++) {
                    File h = arrayElements[i];
                    if (h.isDirectory()) {
                        System.out.print("[DIR] ");
                    } else {
                        System.out.print("[FIT] ");
                    }
                    System.out.println(h.getName());
                }
                System.out.println("///////// Presiona ENTER per continuar... /////////");
                scanner.nextLine();
            }
        } else {
            System.out.println("El path " + f + " no sha trobat");
            System.out.println("///////// Presiona ENTER per continuar... /////////");
            scanner.nextLine();
        }
    }

}
