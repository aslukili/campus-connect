package org.loukili.javac.service;

public interface IFilterService<T> {
    public T getAllAndCount();
    public long getCount();

}
