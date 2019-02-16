package api;


import api.Services.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class studentController {


    @Autowired
    studentService service;


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<studentEntity> findAll(){
        return (List<studentEntity>) service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  studentEntity findById(@PathVariable("id") int ID)
        {
            return service.findById(ID);
        }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public studentEntity create(@RequestBody studentEntity student){
        return service.create(student);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public studentEntity update(@PathVariable("id") int ID, @RequestBody studentEntity student){
        return service.update(ID, student);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteById(@PathVariable("id") int ID)
    {
        service.deleteById(ID);
    }

}
