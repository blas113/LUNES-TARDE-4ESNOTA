package implementaciones;

public interface Cola<T> {
    void acolar(T x);
    T desacolar();
    T primero();
    boolean colaVacia();
}
