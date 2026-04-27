package C8Desafios;

import java.util.*;

public class desafio5 {
    PriorityQueue<int[]> ordenar(Queue<Integer> cola) {
    PriorityQueue<int[]> prio = new PriorityQueue<>((a,b)->b[1]-a[1]);

    while (!cola.isEmpty()) {
        int x = cola.poll();
        int p = (x > 0) ? 2 : (x == 0 ? 1 : 0);
        prio.add(new int[]{x, p});
    }
    return prio;
}
}
