package implementaciones;

public class DiccionarioMultipleDinamico<K, V> implements DiccionarioMultiple<K, V> {
    private class NodoClave {
        K clave;
        Conjunto<V> valores;
        NodoClave sig;
    }
    
    private NodoClave origen;

    public DiccionarioMultipleDinamico() {
        origen = null;
    }

    @Override
    public void agregar(K clave, V valor) {
        NodoClave act = origen;
        while (act != null && !act.clave.equals(clave)) {
            act = act.sig;
        }
        if (act != null) {
            act.valores.agregar(valor);
        } else {
            NodoClave nuevo = new NodoClave();
            nuevo.clave = clave;
            nuevo.valores = new ConjuntoDinamico<>();
            nuevo.valores.agregar(valor);
            nuevo.sig = origen;
            origen = nuevo;
        }
    }

    @Override
    public void eliminar(K clave) {
        if (origen != null) {
            if (origen.clave.equals(clave)) {
                origen = origen.sig;
            } else {
                NodoClave act = origen;
                while (act.sig != null && !act.sig.clave.equals(clave)) {
                    act = act.sig;
                }
                if (act.sig != null) {
                    act.sig = act.sig.sig;
                }
            }
        }
    }

    @Override
    public void eliminarValor(K clave, V valor) {
        NodoClave act = origen;
        while (act != null && !act.clave.equals(clave)) {
            act = act.sig;
        }
        if (act != null) {
            act.valores.sacar(valor);
            if (act.valores.conjuntoVacio()) {
                eliminar(clave);
            }
        }
    }

    @Override
    public Conjunto<V> recuperar(K clave) {
        NodoClave act = origen;
        while (act != null && !act.clave.equals(clave)) {
            act = act.sig;
        }
        if (act != null) {
            return act.valores;
        }
        throw new RuntimeException("Error: la clave no existe en el diccionario múltiple");
    }

    @Override
    public Conjunto<K> claves() {
        Conjunto<K> c = new ConjuntoDinamico<>();
        NodoClave act = origen;
        while (act != null) {
            c.agregar(act.clave);
            act = act.sig;
        }
        return c;
    }
}
