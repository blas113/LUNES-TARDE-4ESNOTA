package C8Desafios;

import java.util.*;

public class desafio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los elementos del conjunto A separados por espacios:");
        Set<Integer> A = parseSet(scanner.nextLine());
        System.out.println("Ingrese los elementos del conjunto B separados por espacios:");
        Set<Integer> B = parseSet(scanner.nextLine());
        scanner.close();

        Set<Integer> res = new desafio4().simetrica(A, B);
        System.out.println("Diferencia simétrica:");
        System.out.println(res);
    }

    private static Set<Integer> parseSet(String line) {
        Set<Integer> set = new HashSet<>();
        for (String token : line.trim().split("\\s+")) {
            if (!token.isEmpty()) set.add(Integer.parseInt(token));
        }
        return set;
    }

    Set<Integer> simetrica(Set<Integer> A, Set<Integer> B) {
        Set<Integer> res = new HashSet<>();

        for (int x : A) if (!B.contains(x)) res.add(x);
        for (int x : B) if (!A.contains(x)) res.add(x);

        return res;
    }
}
