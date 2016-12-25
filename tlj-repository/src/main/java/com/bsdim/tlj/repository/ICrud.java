package com.bsdim.tlj.repository;

public interface ICrud<K,E> {
    void create(E entity);
    E read(K key);
    void update(E entity);
    void delete(K key);
}
