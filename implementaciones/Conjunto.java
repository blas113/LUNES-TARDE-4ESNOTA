package implementaciones;

public interface Conjunto<T> {
    void agregar(T x);
    void sacar(T x);
    boolean pertenece(T x);
    boolean conjuntoVacio();
}
