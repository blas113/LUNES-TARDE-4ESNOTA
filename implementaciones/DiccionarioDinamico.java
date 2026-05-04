package implementaciones;

public class DiccionarioDinamico<K, V> implements Diccionario<K, V> {
    private class NodoClave {
        K clave;
        V valor;
        NodoClave sig;
    }
    
    private NodoClave origen;

    public DiccionarioDinamico() {
        origen = null;
    }

    @Override
    public void agregar(K clave, V valor) {
        NodoClave act = origen;
        while (act != null && !act.clave.equals(clave)) {
            act = act.sig;
        }
        if (act != null) {
            act.valor = valor; // Actualizar valor si la clave ya existe
        } else {
            NodoClave nuevo = new NodoClave();
            nuevo.clave = clave;
            nuevo.valor = valor;
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
    public V recuperar(K clave) {
        NodoClave act = origen;
        while (act != null && !act.clave.equals(clave)) {
            act = act.sig;
        }
        if (act != null) {
            return act.valor;
        }
        throw new RuntimeException("Error: la clave no existe en el diccionario");
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
