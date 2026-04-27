package C8Desafios;

import java.util.*;

public class desafio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una cadena: ");
        String texto = scanner.nextLine().trim();
        scanner.close();

        if (esPalindromo(texto)) {
            System.out.println("Es palíndromo");
        } else {
            System.out.println("No es palíndromo");
        }
    }

    private static boolean esPalindromo(String s) {
        Deque<Character> p = new ArrayDeque<>();
        Queue<Character> c = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (!Character.isWhitespace(ch)) {
                p.push(ch);
                c.add(ch);
            }
        }

        while (!p.isEmpty()) {
            if (!p.pop().equals(c.remove())) return false;
        }
        return true;
    }
}
