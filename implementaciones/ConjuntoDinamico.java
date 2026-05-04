package implementaciones;

public class ConjuntoDinamico<T> implements Conjunto<T> {
    private class Nodo {
        T info;
        Nodo sig;
    }
    
    private Nodo c;

    public ConjuntoDinamico() {
        c = null;
    }

    @Override
    public void agregar(T x) {
        if (!pertenece(x)) {
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            nuevo.sig = c;
            c = nuevo;
        }
    }

    @Override
    public void sacar(T x) {
        if (c != null) {
            if (c.info.equals(x)) {
                c = c.sig;
            } else {
                Nodo act = c;
                while (act.sig != null && !act.sig.info.equals(x)) {
                    act = act.sig;
                }
                if (act.sig != null) {
                    act.sig = act.sig.sig;
                }
            }
        }
    }

    @Override
    public boolean pertenece(T x) {
        Nodo act = c;
        while (act != null) {
            if (act.info.equals(x)) {
                return true;
            }
            act = act.sig;
        }
        return false;
    }

    @Override
    public boolean conjuntoVacio() {
        return c == null;
    }
}
