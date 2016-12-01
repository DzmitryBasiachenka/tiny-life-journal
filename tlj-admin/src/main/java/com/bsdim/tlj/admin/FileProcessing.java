package com.bsdim.tlj.admin;

import com.bsdim.tlj.domain.user.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class FileProcessing {
    private String nameFile = "person.dat";

    public void writeFile(List<User> collection) {
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(nameFile))) {
            write.writeObject(collection);
            System.out.println("File save");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<User> readFile(){
        try(ObjectInputStream read = new ObjectInputStream(new FileInputStream(nameFile))) {
            return (List<User>)read.readObject();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return new ArrayList<>();
    }
}
