package C8Desafios;

import java.util.*;

public class desafio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos y luego pares x p separados por espacios:");
        int n = scanner.nextInt();
        PriorityQueue<int[]> cola = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int p = scanner.nextInt();
            cola.add(new int[]{x, p});
        }
        scanner.close();

        int resultado = new desafio2().contarP1(cola);
        System.out.println("Cantidad de elementos con prioridad 1: " + resultado);
    }

    int contarP1(PriorityQueue<int[]> cola) {
        PriorityQueue<int[]> aux = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int count = 0;

        while (!cola.isEmpty()) {
            int[] e = cola.poll();
            if (e[1] == 1) count++;
            aux.add(e);
        }
        while (!aux.isEmpty()) cola.add(aux.poll());

        return count;
    }
}
