package com.bsdim.tlj.repository.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * The abstract file repository.
 *
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 *
 * @param <T>
 */
public abstract class AbstractFileRepository<T> {
    private static final String FILE_SAVED = "File save";
    private static Logger sLogger = Logger.getLogger(AbstractFileRepository.class.getName());
    private String file;

    /**
     * Parametrized constructor.
     *
     * @param newFile the new file.
     */
    public AbstractFileRepository(String newFile) {
        this.file = newFile;
    }

    /**
     * Writes data to the file.
     *
     * @param users the list of data.
     */
    public void writeData(List<T> users) {
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(file))) {
            write.writeObject(users);
            sLogger.info(FILE_SAVED);
        } catch (Exception ex) {
            sLogger.info(ex.getMessage());
        }
    }

    /**
     * Reads data from the file.
     *
     * @return the list of data.
     */
    public List<T> readData() {
        if (new File(file).exists()) {
            try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(file))) {
                return (List<T>) read.readObject();
            } catch (Exception ex) {
                sLogger.info(ex.getMessage());
            }
        }
        return new ArrayList<>();
    }
}
