package com.bsdim.tlj.admin;

import com.bsdim.tlj.domain.user.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class FileProcessing {
    private ArrayList<User> collection = new ArrayList();
    private String nameFile = "person.dat";

    public void writeFile(User object) {
        collection.add(object);
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(nameFile))) {
            write.writeObject(collection);
            System.out.println("File save");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void readFile(){
        ArrayList<User> newCollection = null;
        try(ObjectInputStream read = new ObjectInputStream(new FileInputStream(nameFile)))
        {
            newCollection=(ArrayList<User>)read.readObject();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        for(User info : newCollection){
            System.out.println(info);
        }
    }
}
