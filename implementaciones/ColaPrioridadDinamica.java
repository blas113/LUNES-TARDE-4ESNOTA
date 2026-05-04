package implementaciones;

public class ColaPrioridadDinamica<T> implements ColaPrioridad<T> {
    private class NodoPrioridad {
        T info;
        int prioridad;
        NodoPrioridad sig;
    }
    
    private NodoPrioridad primero;

    public ColaPrioridadDinamica() {
        primero = null;
    }

    @Override
    public void acolarPrioridad(T x, int prioridad) {
        NodoPrioridad nuevo = new NodoPrioridad();
        nuevo.info = x;
        nuevo.prioridad = prioridad;

        // Mayor valor de prioridad = mayor prioridad
        if (colaVacia() || prioridad > primero.prioridad) {
            nuevo.sig = primero;
            primero = nuevo;
        } else {
            NodoPrioridad act = primero;
            while (act.sig != null && act.sig.prioridad >= prioridad) {
                act = act.sig;
            }
            nuevo.sig = act.sig;
            act.sig = nuevo;
        }
    }

    @Override
    public T desacolar() {
        if (colaVacia()) {
            throw new RuntimeException("Error: la cola de prioridad está vacía");
        }
        T x = primero.info;
        primero = primero.sig;
        return x;
    }

    @Override
    public T primero() {
        if (colaVacia()) {
            throw new RuntimeException("Error: la cola de prioridad está vacía");
        }
        return primero.info;
    }

    @Override
    public boolean colaVacia() {
        return primero == null;
    }

    @Override
    public int prioridad() {
        if (colaVacia()) {
            throw new RuntimeException("Error: la cola de prioridad está vacía");
        }
        return primero.prioridad;
    }
}
