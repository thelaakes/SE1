package org.hbrs.se1.ws23.uebung4.persistence;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    // URL of file, in which the objects are stored
    private String location = "C:\\Users\\lukas\\OneDrive\\Desktop\\test.csv";
    private FileOutputStream fos = null;
    private ObjectOutputStream oos = null;

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save.
     */
    public void openConnection() throws PersistenceException {
        try {
            fos = new FileOutputStream(location);
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, e.getMessage());
        }
    }

    @Override
    /*
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {
        try {
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, e.getMessage());
        }
    }

    @Override
    /*
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<E> member) throws PersistenceException {

        //Method for saving a list of Member-objects to a disk (HDD)
        openConnection();
        try {
            oos.writeObject(member);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        closeConnection();
    }

    @Override
    /*
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException {
        List<E> newList = null;
        ObjectInputStream ois = null;
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(location);
            ois = new ObjectInputStream(fis);

            Object obj = ois.readObject();

            if (obj instanceof List<?>) {
                newList = (List<E>) obj;
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.LoadFailure, e.getMessage());
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
            if (fis != null) {

                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        return newList;
    }
}