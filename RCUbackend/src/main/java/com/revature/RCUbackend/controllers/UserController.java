
package com.revature.RCUbackend.controllers;

import com.revature.RCUbackend.models.ChangePasswordObject;
import com.revature.RCUbackend.models.ChangeUserInfo;
import com.revature.RCUbackend.models.User;
import com.revature.RCUbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping(path="/users")
public class UserController {

    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
//Create
    @PostMapping(path ="/addUser", consumes = "application/json", produces = "application/json")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    //READ

    @GetMapping(path ="/find")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping(path ="/find/{user_id}")
    public User getUser(@PathVariable Integer user_id){
        return userService.getUser(user_id);
    }


    //UPDATE

    @PutMapping(path ="/update/{user_id}")//, consumes = "application/json", produces = "application/json")
    public void updateUser (@PathVariable Integer user_id, @RequestBody User user){
//        Users u = userService.getUser(user_id);

        if (Objects.equals(user_id, user.getUserID())){ // compare the 2 user IDs
            userService.updateUser(user);
        }

    }

    //DELETE - deleteUser. This path will help to delete a user.
    @DeleteMapping(path ="/delete/{user_id}")
    public void deleteUser (@PathVariable Integer user_id){
        User u = userService.getUser(user_id);
        userService.deleteUser(u);
    }



    @PutMapping(path = "/changePassword", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean changePassword(@RequestBody ChangePasswordObject changePasswordObject)
    {
    	boolean success = false;

    	User changeUser = this.userService.findByUsername(changePasswordObject.getUsername()).get();
    	if (passwordEncoder.matches(changePasswordObject.getCurrentPassword(), changeUser.getPassword()) &&
    	changePasswordObject.getNewPassword().equals(changePasswordObject.getConfirmNewPassword()) )
    	{
    		changeUser.setPassword(passwordEncoder.encode(changePasswordObject.getNewPassword()));
    		this.userService.updateUser(changeUser);
    		success = true;
    	}
    	System.out.println(changeUser);

    	return success;

    }

    @PutMapping(path = "/changeUsername", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean changeUsername(@RequestBody ChangePasswordObject changeUsername)
    {
        boolean success = false;

        User changeUser = this.userService.findByUsername(changeUsername.getUsername()).get();
        if (passwordEncoder.matches(changeUsername.getUsername(), changeUser.getUsername()))
        {
            changeUser.setUsername(passwordEncoder.encode(changeUsername.getUsername()));
            this.userService.updateUser(changeUser);
            success = true;
        }
        System.out.println(changeUser);

        return success;

    }
    @PutMapping(path ="/changeProfileSettings", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateUserInfo (@RequestBody ChangeUserInfo user){

        boolean success = false;
        User changeUser = this.userService.findByUsername(user.getUsername()).get();
//        if(passwordEncoder.matches(user.getPassword(), changeUser.getUsername())){}

        System.out.println(changeUser);
        System.out.println(user);
//        if (Objects.equals(user_id, user.getUserID())){ // compare the 2 user IDs
//            userService.updateUser(user);
//            success = true;
//        }
    return success;
    }

//    @PostMapping(path = "/resetPassword", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public boolean resetPassword(@RequestBody User resetUser) {
//
//        resetUser = this.userService.findByEmail(resetUser.getEmail()).get();
//        Random r = new Random();
//        String tempPassword = "";
//
//        for (int count = 0; count < 16; count++)
//        {
//            tempPassword = tempPassword + (char)(r.nextInt(26) + 'a');
//        }
//
//        resetUser.setPassword(tempPassword);
//        this.userService.updateUser(resetUser);
//
//        SimpleMailMessage temporaryPasswordMessage = new SimpleMailMessage();
//        temporaryPasswordMessage.setFrom("RCU_test@hotmail.com");
//        temporaryPasswordMessage.setTo(resetUser.getEmail());
//
//        String mailSubject ="Password Reset";
//        String mailContent = "You requested a new password: " + resetUser.getPassword()+ "\nPlease change this password upon login.";
//        temporaryPasswordMessage.setSubject(mailSubject);
//        temporaryPasswordMessage.setText(mailContent);
//
//        javaMailSender.send(temporaryPasswordMessage);
//
//        return true;
//    }





}


