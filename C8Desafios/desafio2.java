package C8Desafios;

import java.util.PriorityQueue;


public class desafio2 {
    int contarP1(PriorityQueue<int[]> cola) {
    PriorityQueue<int[]> aux = new PriorityQueue<>((a,b)->b[1]-a[1]);
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
