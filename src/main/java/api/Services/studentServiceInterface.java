package api.Services;

import api.studentEntity;

import java.util.List;

public interface studentServiceInterface {
    List<studentEntity> findAll();

    studentEntity findById(int id);

    studentEntity create(studentEntity student);

    studentEntity update(int id, studentEntity student);

    void deleteById(int id);
}
