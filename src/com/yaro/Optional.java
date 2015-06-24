    package com.yaro;

import java.util.NoSuchElementException;

/**
 * Created by yann on 23/06/15.
 */
public class Optional<T> {

    private T element;

    private Optional(T element) {
        this.element = element;
    }

    public Optional() {

    }

    public static <T> Optional<T> of(T element) {
        if(element==null) throw new NullPointerException();
        return new Optional<>(element);
    }

    public T get() {
        if (element == null) {
            throw new NoSuchElementException("No value present");
        }
        return element;
    }

    public boolean isPresent() {
        return element != null;
    }

    public T orElse(T other) {
        return isPresent() ? get() : other;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Optional)) return false;
        Optional cast = (Optional) obj;
        if(isPresent() && !cast.isPresent()) return false;
        if(cast.isPresent() && !isPresent()) return false;
        if(!isPresent() && !cast.isPresent()) return true;
        return get().equals(cast.get());
    }

    public String toString() {
        if(!isPresent())
            return "Optional<EMPTY>";
        return "Optional<" + element.getClass().getSimpleName() + ">(" + element.toString() + ")";
    }

    public static Optional<Integer> empty() {
        return new Optional<>();
    }
}
