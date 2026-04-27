package C8Desafios;

import java.util.*;

public class desafio3 {
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
