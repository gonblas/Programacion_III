package Practicas.Practica5.Practica5_B.Ejercicio3;

public class TestTRIE {
    public static void main(String[] args) {
        TRIE t = new TRIE();
        t.getArbol().ImprimirPorNiveles();
        System.out.println("\n");
        t.agregarPalabra("perro");
        t.getArbol().ImprimirPorNiveles();
        System.out.println("\n");
        t.agregarPalabra("persona");
        System.out.println("\n");
        t.getArbol().ImprimirPorNiveles();
        t.agregarPalabra("perito");
        System.out.println("\n");
        t.getArbol().ImprimirPorNiveles();
        t.agregarPalabra("nazi");
        System.out.println("\n");
        t.getArbol().ImprimirPorNiveles();
        System.out.println("\n");
        System.out.println(t.palabrasQueEmpiezanCon("per").toString());
    }
}
