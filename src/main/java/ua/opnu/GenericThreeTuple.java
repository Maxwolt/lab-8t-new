package ua.opnu;

public class GenericThreeTuple<T, V, S> {

    private final GenericTwoTuple<T, V> tuple;
    public final S three;

    public GenericThreeTuple(T first, V second, S three) {
        this.tuple = new GenericTwoTuple<>(first, second);
        this.three = three;
    }

    public T getFirst() {
        return tuple.first;
    }

    public V getSecond() {
        return tuple.second;
    }

    public S getThree() {
        return three;
    }

    @Override
    public String toString() {
        return "(" + tuple.first + "," + tuple.second + "," + three + ')';
    }
}
