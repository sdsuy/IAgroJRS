package com.interfaz;

import java.util.List;

public interface IBean<T> {
	
	boolean create(T o);
	T read(Long id);
	List<T> readAll();
	boolean update(T o);
	boolean delete(Long id);

}
