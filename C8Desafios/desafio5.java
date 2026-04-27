package C8Desafios;

import java.util.*;

public class desafio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese números separados por espacios para ordenar por prioridad:");
        String line = scanner.nextLine();
        scanner.close();

        Queue<Integer> cola = new ArrayDeque<>();
        for (String token : line.trim().split("\\s+")) {
            if (!token.isEmpty()) cola.add(Integer.parseInt(token));
        }

        PriorityQueue<int[]> ordenada = new desafio5().ordenar(cola);
        System.out.println("Cola ordenada por prioridad (valor, prioridad):");
        while (!ordenada.isEmpty()) {
            int[] item = ordenada.poll();
            System.out.println(Arrays.toString(item));
        }
    }

    PriorityQueue<int[]> ordenar(Queue<Integer> cola) {
        PriorityQueue<int[]> prio = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        while (!cola.isEmpty()) {
            int x = cola.poll();
            int p = (x > 0) ? 2 : (x == 0 ? 1 : 0);
            prio.add(new int[]{x, p});
        }
        return prio;
    }
}
