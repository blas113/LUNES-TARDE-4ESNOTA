package implementaciones;

public interface Pila<T> {
    void apilar(T x);
    T desapilar();
    T tope();
    boolean pilaVacia();
}
