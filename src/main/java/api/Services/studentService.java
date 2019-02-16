package api.Services;

import api.studentEntity;
import api.studentException;
import api.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class studentService implements studentServiceInterface{

    @Autowired
    studentRepository repository;


    //find all the student records
    @Transactional(readOnly = true)
    public List<studentEntity> findAll(){

        return (List<studentEntity>) repository.findAll();
    }


    //find student record by ID
    @Transactional(readOnly = true)
    public studentEntity findById(int id){
        return repository.findById(id).orElseThrow(() -> new studentException("not found"));
    }


    //create new student record
    @Transactional
    public studentEntity create(studentEntity student){
        Optional<studentEntity> existing = repository.findById(student.getId());
        if (existing.isPresent()) {
            throw new studentException("student exists");
        }
        return repository.save(student);

    }



    //update student record by ID
    @Transactional
    public studentEntity update(int id, studentEntity s){
        Optional<studentEntity> existing = repository.findById(id);
        if (!existing.isPresent()) {
            throw new studentException("not found");
        }
        else
            return repository.save(s);
    }


    //delete student record by ID
    @Transactional
    public void deleteById(int id){
        Optional<studentEntity> existing = repository.findById(id);
        if (!existing.isPresent()) {
            throw new studentException("not found");
        }
        else
            repository.delete(existing.get());
    }
}
