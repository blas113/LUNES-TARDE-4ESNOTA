
package C8Desafios;

import java.util.*;

public class desafio1 {
boolean esPalindromo(String s) {
    Deque<Character> p = new ArrayDeque<>();
    Queue<Character> c = new ArrayDeque<>();

    for (char ch : s.toCharArray()) {
        p.push(ch);
        c.add(ch);
    }

    while (!p.isEmpty()) {
        if (!p.pop().equals(c.remove())) return false;
    }
    return true;
}
}
