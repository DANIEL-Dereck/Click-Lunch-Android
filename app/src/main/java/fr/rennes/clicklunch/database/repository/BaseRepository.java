package fr.rennes.clicklunch.database.repository;


import java.util.List;

import fr.rennes.clicklunch.entities.EntityBase;

public abstract class BaseRepository<T extends EntityBase> {
    public abstract String createTable();
    public abstract String dropTable();

    public abstract int insert(T entity);

    public abstract int delete(T entity);
    public abstract int delete(int id);

    public abstract T getById(int id);
    public abstract List<T> getAll();
}
