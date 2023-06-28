package Chap08;

public class NewExceptionTest {
    public static void main(String[] args) {
        try {
            startInstall();
            copyFiles();
        } catch (SpaceException e) {
            System.out.println("Error message: " + e.getMessage());
            e.printStackTrace();
            System.out.println("Please reinstall again after making space.");
        } catch (MemoryException me) {
            System.out.println("Error message: " + me.getMessage());
            me.printStackTrace();
            System.gc();
            System.out.println("Please reinstall.");
        } finally {
            deleteTempFiles();
        }
    }

    static void startInstall() throws SpaceException, MemoryException {
        if(!enoughSpace())
            throw new SpaceException("Not enough the space to install.");
        if(!enoughMemory())
            throw new MemoryException("Not enough memory.");
    }

    static void copyFiles() {}

    static void deleteTempFiles() {}

    static boolean enoughSpace() {
        return false;
    }
    
    static boolean enoughMemory() {
        return true;
    }

}

class SpaceException extends Exception {
    SpaceException(String msg) {
        super(msg);
    }
}

class MemoryException extends Exception {
    MemoryException(String msg) {
        super(msg);
    }
}