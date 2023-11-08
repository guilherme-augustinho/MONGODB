package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.UserModel;
import service.UserService;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;
    
    @PostMapping("")
    public UserModel save(UserModel userModel)
    {
        return this.userService.save(userModel);
    }

    @PutMapping("")
    public void save(String id, String name, short age)
    {
        this.userService.save(new UserModel(id, name, age));
    }

    @GetMapping("")
    public List<UserModel> findAll()
    {
        return (List<UserModel>) this.userService.findAll();
    }

    @GetMapping("/{name}")
    public List<UserModel> findByName(@PathVariable String name) {
        return (List<UserModel>) this.userService.findByName(name);
    }

    @GetMapping("/{age}/{name}")
    public List<UserModel> findByAgeAndName(@PathVariable short age, @PathVariable String name) {
        return (List<UserModel>) this.userService.findByAgeName(age, name);
    }

    @DeleteMapping("/{id}")
    public void delete(String id) {
        this.userService.delete(id);
    }
}