package implementaciones;

public class ColaDinamica<T> implements Cola<T> {
    private class Nodo {
        T info;
        Nodo sig;
    }
    
    private Nodo primero;
    private Nodo ultimo;

    public ColaDinamica() {
        primero = null;
        ultimo = null;
    }

    @Override
    public void acolar(T x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        nuevo.sig = null;
        if (colaVacia()) {
            primero = nuevo;
        } else {
            ultimo.sig = nuevo;
        }
        ultimo = nuevo;
    }

    @Override
    public T desacolar() {
        if (colaVacia()) {
            throw new RuntimeException("Error: la cola está vacía");
        }
        T x = primero.info;
        primero = primero.sig;
        if (primero == null) {
            ultimo = null;
        }
        return x;
    }

    @Override
    public T primero() {
        if (colaVacia()) {
            throw new RuntimeException("Error: la cola está vacía");
        }
        return primero.info;
    }

    @Override
    public boolean colaVacia() {
        return primero == null;
    }
}
