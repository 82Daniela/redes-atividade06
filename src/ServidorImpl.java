
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServidorImpl implements CalculadoraVotos {

    private static List<String> nomesCandidatos = new ArrayList<String>();
    private static List<Integer> votosCandidatos = new ArrayList<Integer>();

    public ServidorImpl() {

    }

    @Override
    public boolean validarCPF(String CPF) throws RemoteException {
        if (CPF.length() == 11) {
            return true;
        }

        return false;
    }

    @Override
    public String maiorMenorZero(int valor) throws RemoteException {

        if (valor > 0) {
            return "Maior que zero!";
        } else {
            return "Menor que zero!";
        }

    }

    @Override
    public void contarVotos(ArrayList votosCandidatosCLiente, ArrayList nomesCandidatosCliente) throws RemoteException, InterruptedException {
        int num;
        for (int i = 0; i < votosCandidatos.size(); i++) {

            if (nomesCandidatos.get(i).equals(nomesCandidatosCliente.get(i))) {
                num = (int) votosCandidatosCLiente.get(i);


                if (votosCandidatos.get(i) == -1) {

                    votosCandidatos.set(i, num);

                } else {
                    votosCandidatos.set(i, votosCandidatos.get(i) + num);

                }

            }

        }

        while (true) {


            Thread.sleep(5000);
            mostrarVotos();

        }

    }

    public static void mostrarVotos() {

        System.out.println("==============Apuração==============");
        for (int i = 0; i < votosCandidatos.size(); i++) {

            System.out.println("...:Candidato...: " + nomesCandidatos.get(i) + "...:Votos...: " + votosCandidatos.get(i));
        }
    }

    public static void main(String[] args) {
        try {

            ServidorImpl s = new ServidorImpl();

            CalculadoraVotos stub
                    = (CalculadoraVotos) UnicastRemoteObject.exportObject(s, 0);

            Registry registro
                    = LocateRegistry.createRegistry(1099);

            registro.bind("metodosValidadores", stub);

            System.out.println("wServidor RMI está pronto!");

            nomesCandidatos.add("A");
            votosCandidatos.add(0);
            votosCandidatos.set(0, -1);

            nomesCandidatos.add("B");
            votosCandidatos.add(1);
            votosCandidatos.set(1, -1);

            nomesCandidatos.add("C");
            votosCandidatos.add(2);
            votosCandidatos.set(2, -1);

            nomesCandidatos.add("D");
            votosCandidatos.add(3);
            votosCandidatos.set(3, -1);


        } catch (Exception e) {

        }
    }

}
