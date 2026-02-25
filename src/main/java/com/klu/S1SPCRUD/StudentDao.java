package com.klu.S1SPCRUD;

public interface StudentDao {
	void insert(Student s);
    Student get();
    void update(Student s);
    void delete();
}
