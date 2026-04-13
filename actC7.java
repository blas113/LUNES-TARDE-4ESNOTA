import java.util.*;

public class actC7 {
    public static void main(String[] args) {

        Stack<Integer> pilaEstatica = new Stack<>();
        pilaEstatica.push(1);
        pilaEstatica.push(2);
        pilaEstatica.push(3); 

        Queue<Integer> cola = new LinkedList<>();
        Stack<Integer> pilaDinamica = new Stack<>();

        
        while (!pilaEstatica.isEmpty()) {
            cola.add(pilaEstatica.pop());
        }

    
        while (!cola.isEmpty()) {
            pilaDinamica.push(cola.poll());
        }

        System.out.println(pilaDinamica); 
    }
}