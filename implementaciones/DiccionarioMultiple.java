package implementaciones;

public interface DiccionarioMultiple<K, V> {
    void agregar(K clave, V valor);
    void eliminar(K clave);
    void eliminarValor(K clave, V valor);
    Conjunto<V> recuperar(K clave);
    Conjunto<K> claves();
}
