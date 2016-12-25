package com.bsdim.tlj.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class FileRepository<T> {
    private String file;

    public FileRepository(String newFile) {
        this.file = newFile;
    }

    public void writeData(List<T> users) {
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(file))) {
            write.writeObject(users);
            System.out.println("File save");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<T> readData() {
        if ((new File(file).exists())) {
            try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(file))) {
                return (List<T>) read.readObject();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return new ArrayList<>();
    }
}
