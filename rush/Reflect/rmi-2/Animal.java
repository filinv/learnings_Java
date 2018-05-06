import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Animal extends Remote {
    void say() throws RemoteException;

    void printName() throws RemoteException;
}
