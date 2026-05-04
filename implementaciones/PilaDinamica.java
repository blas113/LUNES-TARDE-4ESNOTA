package implementaciones;

public class PilaDinamica<T> implements Pila<T> {
    private class Nodo {
        T info;
        Nodo sig;
    }
    
    private Nodo tope;

    public PilaDinamica() {
        this.tope = null;
    }

    @Override
    public void apilar(T x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        nuevo.sig = tope;
        tope = nuevo;
    }

    @Override
    public T desapilar() {
        if (pilaVacia()) {
            throw new RuntimeException("Error: la pila está vacía");
        }
        T x = tope.info;
        tope = tope.sig;
        return x;
    }

    @Override
    public T tope() {
        if (pilaVacia()) {
            throw new RuntimeException("Error: la pila está vacía");
        }
        return tope.info;
    }

    @Override
    public boolean pilaVacia() {
        return tope == null;
    }
}
