package net.javaguides.springboot.service;
import java.util.List;





public interface ICrudService<T,ID> {
	

		List<T> getAll();
		void add(T entity);
		void update(T entity);
		void delete(int id);
		void saveAll(Iterable<T> iterable);


	


}
