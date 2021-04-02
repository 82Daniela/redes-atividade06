
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface CalculadoraVotos extends Remote {

    boolean validarCPF(String CPF) throws RemoteException;

    String maiorMenorZero(int valor) throws RemoteException;

    void contarVotos(ArrayList numVotos, ArrayList nomeCandidato) throws RemoteException, InterruptedException;

}
