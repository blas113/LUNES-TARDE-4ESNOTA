package C8Desafios;

import java.util.*;

public class desafio4 {
    Set<Integer> simetrica(Set<Integer> A, Set<Integer> B) {
    Set<Integer> res = new HashSet<>();

    for (int x : A) if (!B.contains(x)) res.add(x);
    for (int x : B) if (!A.contains(x)) res.add(x);

    return res;
}
}
