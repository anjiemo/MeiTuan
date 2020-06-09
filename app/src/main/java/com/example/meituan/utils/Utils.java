package com.example.meituan.utils;

import java.util.Collection;

public class Utils {

    public static <T> boolean isEmpty(T tClazz) {
        return tClazz == null;
    }

    public static <T> boolean isNotEmpty(T tClazz) {
        return !isEmpty(tClazz);
    }

    public static<E> boolean isEmpty(Collection<E> collection) {
        return collection == null || collection.size() == 0;
    }

    public static <E> boolean isNotEmpty(Collection<E> collection) {
        return !isEmpty(collection);
    }
}
