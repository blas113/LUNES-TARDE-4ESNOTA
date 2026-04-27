package C8Desafios;

import java.util.*;

public class desafio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese números separados por espacios para la pila:");
        String line = scanner.nextLine();
        scanner.close();

        Stack<Integer> pila = new Stack<>();
        String[] tokens = line.trim().split("\\s+");
        for (String token : tokens) {
            if (!token.isEmpty()) pila.push(Integer.parseInt(token));
        }

        new desafio3().eliminarDup(pila);
        System.out.println("Pila sin duplicados (desde el fondo hasta la cima):");
        System.out.println(pila);
    }

    void eliminarDup(Stack<Integer> p) {
        Set<Integer> set = new HashSet<>();
        Stack<Integer> aux = new Stack<>();

        while (!p.isEmpty()) {
            int x = p.pop();
            if (!set.contains(x)) {
                set.add(x);
                aux.push(x);
            }
        }
        while (!aux.isEmpty()) p.push(aux.pop());
    }
}
