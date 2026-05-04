package implementaciones;

public interface Diccionario<K, V> {
    void agregar(K clave, V valor);
    void eliminar(K clave);
    V recuperar(K clave);
    Conjunto<K> claves();
}
