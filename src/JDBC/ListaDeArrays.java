package JDBC;

import java.util.ArrayList;

public class ListaDeArrays {
    public static void main(String[] args) {

        ArrayList<String> cores = new ArrayList<>();
        cores.add("Branco");
        cores.add("Azul");
        cores.add("Preto");
        cores.add("Verde");
        cores.add("Vermelho");
        //cores.add("Amarelo");

        System.out.println("todos os elementos: " + cores.toString()); //exibe todos os elementos
        System.out.println("tamanho do array: " + cores.size()); //exibe o tamanho do array
        System.out.println("posição 0 do array: " + cores.get(2)); //posição do array
        System.out.println("Índice da cor Branco: " + cores.indexOf("Branco")); //índice do array

        cores.remove ("Vermelho"); //remove cor
        System.out.println("todos os elementos: " + cores.toString()); //exibe todos os elementos
        System.out.println("Tem azul? " + cores.contains("Azul")); //verifica se tem azul
        System.out.println("Tem Vermelho? " + cores.contains("Vermelho")); //verifica se tem a cor
    }

}
