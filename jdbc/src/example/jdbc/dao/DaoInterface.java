package example.jdbc.dao;

import java.util.Collection;

import example.jdbc.been.Restaurant;

public interface DaoInterface<T,K> {
//	A method to retrieve all records
    Collection<T> retrieveAll(); 
    // A method to retrieve single record
    // based upon its identity
    T retrieveOne(K key);
	
//    A method to insert a new record
    void create(Restaurant newRestaurant);
    
//    A method to update an existing record
    void update(T t);
//    A method to delete an existing record
    void delete(K key);
    }
  

