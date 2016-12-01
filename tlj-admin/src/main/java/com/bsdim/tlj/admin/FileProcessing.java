package com.bsdim.tlj.admin;

import com.bsdim.tlj.domain.user.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileProcessing {
    private String file = "person.dat";

    public void writeFile(List<User> collection) {
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(file))) {
            write.writeObject(collection);
            System.out.println("File save");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<User> readFile(){
        if ((new File(file).exists())) {
            try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(file))) {
                return (List<User>) read.readObject();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return new ArrayList<>();
    }
}
