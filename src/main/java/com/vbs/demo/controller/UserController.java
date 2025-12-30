package com.vbs.demo.controller;

import com.vbs.demo.dto.DisplayDto;
import com.vbs.demo.dto.LoginDto;
import com.vbs.demo.dto.UpdateDto;
import com.vbs.demo.models.History;
import com.vbs.demo.models.User;
import com.vbs.demo.repositories.HistoryRepo;
import com.vbs.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    HistoryRepo historyRepo;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        userRepo.save(user);

        History h1 = new History();
        h1.setDescription("user self Created : "+ user.getUsername());
        historyRepo.save(h1);

        return "Signup Successful";

    }
    @PostMapping("/login")
    public String login(@RequestBody LoginDto u)
    {
        User user = userRepo.findByusername(u.getUsername());
        if(user == null)
        {
            return "User Not found";
        }
        if(!u.getPassword().equals(user.getPassword()))
        {
            return "Password incorrect";
        }
        if(!u.getRole().equals(user.getRole()))
        {
            return "Role incorrect";
        }
        return String.valueOf(user.getId());


    }
    @GetMapping("/get-details/{id}")
    public DisplayDto display(@PathVariable int id)
    {
        User user = userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));

        DisplayDto displaydto = new DisplayDto();
        displaydto.setUsername(user.getUsername());
        displaydto.setBalance((user.getBalance()));
        return displaydto;



    }
    @PostMapping("/update")
    public String update(@RequestBody UpdateDto obj)
    {
        User user = userRepo.findById(obj.getId())
                .orElseThrow(()-> new RuntimeException("Not Found"));

        History h1 = new History();

        if(obj.getKey().equalsIgnoreCase("name"))
        {
            if(user.getName().equalsIgnoreCase(obj.getValue())) return "cannot be same";
            h1.setDescription("user changed Name from :"+ user.getName()+" to "+obj.getValue());
            user.setName(obj.getValue());
        } else if (obj.getKey().equalsIgnoreCase("password"))
        {
            if(user.getPassword().equalsIgnoreCase(obj.getValue())) return "cannot be same";
            h1.setDescription("user changed password :"+ user.getUsername());
            user.setPassword(obj.getValue());
        } else if (obj.getKey().equalsIgnoreCase("email"))
        {
            if(user.getEmail().equalsIgnoreCase(obj.getValue())) return "cannot be same";
            User user2 = userRepo.findByEmail(obj.getValue());
            if(user2 != null) return "Email already exist";
            h1.setDescription("user changed Email from "+ user.getEmail()+" to "+obj.getValue());
            user.setEmail(obj.getValue());
        }else {
            return "invalid key";
        }
        historyRepo.save(h1);
        userRepo.save(user);
        return "Update done successfully";


    }
    @PostMapping("/add/{adminId}")
    public String add(@RequestBody User user,@PathVariable int adminId)
    {
        History h1 = new History();
        h1.setDescription("User "+user.getUsername()+ " Created By Admin "+ adminId);
        historyRepo.save(h1);
        userRepo.save(user);

        return "Successfully added";
    }

    @GetMapping("/users")
    public List<User> getAllUsers(@RequestParam String sortBy , @RequestParam String order)
    {
        Sort sort ;
        if(order.equalsIgnoreCase("desc"))
        {
            sort = Sort.by(sortBy).descending();
        }
        else
        {
            sort = Sort.by(sortBy).ascending();
        }
        return  userRepo.findAllByRole("customer",sort);
    }

    @GetMapping("/users/{keyword}")
    public List<User> getUsers(@PathVariable String keyword)
    {
        return userRepo.findByUsernameContainingIgnoreCaseAndRole(keyword,"customer");
    }

    @DeleteMapping("/delete-user/{userId}/admin/{adminId}")
    public String deleteUser(@PathVariable int userId, @PathVariable int adminId)
    {
        User user  = userRepo.findById(userId).orElseThrow(()->new RuntimeException("Not Found "));
        if(user.getBalance()>0)
        {
            return "Balance Should Be Zero";
        }
        History h1 = new History();
        h1.setDescription("user"+user.getUsername()+" Deleted by Admin :" +adminId);
        historyRepo.save(h1);
        userRepo.delete(user);
        return "User Deleted Successfully";
    }



}