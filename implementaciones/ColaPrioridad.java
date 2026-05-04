package implementaciones;

public interface ColaPrioridad<T> {
    void acolarPrioridad(T x, int prioridad);
    T desacolar();
    T primero();
    boolean colaVacia();
    int prioridad();
}
