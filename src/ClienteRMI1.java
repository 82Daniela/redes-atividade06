
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class ClienteRMI1 {

    private static ArrayList<String> nomesCandidatos = new ArrayList<String>();
    private static ArrayList<Integer> votosCandidatos = new ArrayList<Integer>();

    public static void main(String[] args) {

        try {

            Registry registro = LocateRegistry.getRegistry("localhost", 1099);

            CalculadoraVotos stub
                    = (CalculadoraVotos) registro.lookup("metodosValidadores");

            nomesCandidatos.add("A");
            votosCandidatos.add(0);
            votosCandidatos.set(0, 10);

            nomesCandidatos.add("B");
            votosCandidatos.add(1);
            votosCandidatos.set(1, 5);

            nomesCandidatos.add("C");
            votosCandidatos.add(2);
            votosCandidatos.set(2, 10);

            nomesCandidatos.add("D");
            votosCandidatos.add(3);
            votosCandidatos.set(3, 35);

            stub.contarVotos(votosCandidatos, nomesCandidatos);

        } catch (Exception e) {

        }

    }

}
