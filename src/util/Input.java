package util;

import java.util.List;
import java.util.Scanner;

public class Input {

    public static int getInt(String promptMessage, Scanner scanner) {
        Integer value = null;

        while (value == null) {
            try {
                System.out.println(promptMessage);
                System.out.print(">> Input: ");
                value = Integer.parseInt(scanner.nextLine());
                System.out.println();
            } catch (NumberFormatException ex) {
                System.err.println("Input Invalid! Por favor digite um numero inteiro");
                System.out.println("Aperte enter pra continuar");
                scanner.nextLine();
            }
            Screen.clear();
        }

        return value;
    }
    public static int getInt(String promptMessage, Scanner scanner, List<Integer> numbers) {

        Integer value = null;

        while (value == null || !numbers.contains(value)) {
            try {
                System.out.println(promptMessage);
                System.out.print(">> Input: ");
                value = Integer.parseInt(scanner.nextLine());
                System.out.println();
            } catch (NumberFormatException ex) {
                System.err.println("Input Invalid! Por favor digite um numero inteiro apresentado");
                System.out.println("Aperte enter pra continuar");
                scanner.nextLine();
            }
            Screen.clear();
        }

        return value;
    }


    public static double getDouble(String promptMessage, Scanner scanner) {
        Double value = null;
        System.out.println(promptMessage);

        while (value == null) {
            try {
                System.out.print(">> Input: ");
                value = Double.parseDouble(scanner.nextLine());
                System.out.println();
            } catch (NumberFormatException ex) {
                System.err.println("Input Invalid! Por favor digite um numero real");
                System.out.println("Aperte enter pra continuar");
                scanner.nextLine();
            }
            Screen.clear();
        }

        return value;
    }

    public static boolean getBoolen(String promptMessage, Scanner scanner) {
        String input = null;
        Boolean value = null;
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
                System.out.println("Aperte enter pra continuar");
                scanner.nextLine();
            }
            Screen.clear();
        }

        return value;
    }

    public static String getString(String promptMessage, Scanner scanner) {
        String value = null;
        System.out.println(promptMessage);

        while (value == null || value.isEmpty()) {
            try {
                System.out.print(">> Input: ");
                value = scanner.nextLine();
                System.out.println();
                if (value.isEmpty()) {
                    throw new RuntimeException("Valor Esta vazio");
                }
            } catch (RuntimeException ex) {
                System.err.println("Input Invalid! " + ex.getMessage());
                System.out.println("Aperte enter pra continuar");
                scanner.nextLine();
            } catch (Exception ex) {
                System.err.println("Input Invalid! Por favor digite um valido");
                System.out.println("Aperte enter pra continuar");
                scanner.nextLine();
            }
            Screen.clear();
        }

        return value;
    }
}
