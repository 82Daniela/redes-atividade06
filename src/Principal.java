
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Daniela
 */
public class Principal {

    private static List<Integer> votosCandidatos = new ArrayList<Integer>();

    public static void main(String[] args) {
        votosCandidatos.add(0);
        votosCandidatos.set(0, 30);
        System.out.println(votosCandidatos.get(0));
        //votosCandidatos.get(0);
    }

}
