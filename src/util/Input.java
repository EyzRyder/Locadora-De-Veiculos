package util;

import java.util.Scanner;

public class Input {

    public static int getInt(String promptMessage, Scanner scanner) {
        Integer value = null;
        System.out.println(promptMessage);

        while (value == null) {
            try {
                System.out.print(">> Input: ");
                value = Integer.parseInt(scanner.nextLine());
                System.out.println();
            } catch (NumberFormatException ex) {
                System.err.println("Input Invalid! Por favor digite um numero inteiro");
                scanner.nextLine();
            }
        }

        return value;
    }


    public static double getDouble(String promptMessage, Scanner scanner) {
        Double value = null;
        System.out.println();
        System.out.println(promptMessage);

        while (value == null) {
            try {
                System.out.print(">> Input: ");
                value = Double.parseDouble(scanner.nextLine());
                System.out.println();
            } catch (NumberFormatException ex) {
                System.err.println("Input Invalid! Por favor digite um numero real");
                scanner.nextLine();
            }
        }

        return value;
    }

    public static boolean getBoolen(String promptMessage, Scanner scanner) {
        String input = null;
        Boolean value = null;
        System.out.println();
        System.out.println(promptMessage);

        while (value == null) {
            try {
                System.out.print(">> Input(S/N): ");
                input = scanner.nextLine();

                if(input.equalsIgnoreCase("S")){ value=true; }
                else if(input.equalsIgnoreCase("N")){value=false;}
                else { throw new RuntimeException("Por favor digite S pra sim ou N pra não.");}
                System.out.println();
            } catch (RuntimeException ex) {
                System.err.println("Input Invalid! "+ex);
                scanner.nextLine();
            }
        }

        return value;
    }

    public static String getString(String promptMessage, Scanner scanner) {
        String value = null;
        System.out.println();
        System.out.println(promptMessage);

        while (value == null || value.isEmpty()) {
            try {
                value = scanner.nextLine();
                System.out.println();
                if (value.isEmpty()) {
                    throw new RuntimeException("Valor Esta vazio");
                }
            } catch (RuntimeException ex) {
                System.err.println("Input Invalid! " + ex.getMessage());
                scanner.nextLine();
            } catch (Exception ex) {
                System.err.println("Input Invalid! Por favor digite um valido");
                scanner.nextLine();
            }
        }

        return value;
    }
}
