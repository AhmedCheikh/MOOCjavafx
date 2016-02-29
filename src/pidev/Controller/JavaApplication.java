/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;


import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Armin
 */
public class JavaApplication {
        static String id,age,gender,location,fname,lname,name,email,img,birth;
        public void exit(){
            MyBrowser.popup.close();
        }
        public void getGender(String gender){
            System.out.println("gender ="+gender);
            this.gender = gender;
        }
        public void getLocation(String location){
            System.out.println("location ="+location);
            this.location = location;
        }
        public void getFname(String fname){
            System.out.println("fname ="+fname);
            this.fname = fname;
        }
        public void getLname(String lname){
            System.out.println("lname ="+lname);
            this.lname = lname;
        }
        public void getAge(String age){
            System.out.println("age ="+age);
            this.age = age;
        }
        public  void getId(String id){
            this.id = id;
            System.out.println("id ="+id);
        }
        public void getName(String name){
            this.name = name;
            System.out.println("name = "+name);
        }
        public void getEmail(String email){
            this.email = email;
            System.out.println("email = "+email);
        }
        public void getImg(String img){
            this.img = img;
            System.out.println("img = "+img);
        }
        public void getBirth(String birth){
            this.birth = birth;
                System.out.println("birthday = "+birth);
        }
        public void start() throws IOException{
            //Stage stage =new Stage();
          
            
           int i = Integer.valueOf(id.substring(10));
            System.out.println(i);
            getAge(age);
            Parent p = FXMLLoader.load(getClass().getResource("ProfilApprenant.fxml"));
            Scene scene = new Scene(p);
           ControllerAthentification.c.browserStage.setScene(scene);
         
            
        }
}
