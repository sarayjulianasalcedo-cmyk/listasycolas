


package pilas;
import javax.swing.JOptionPane;

public class AlgPilas {
    public static void main(String[] args) {
        Nodo tope = null; // referencia al tope de la pila
        byte op = 0;

        while (op != 4) {
            op = Byte.parseByte(JOptionPane.showInputDialog("""
                    Digite una opción:
                    1. Insertar (Push)
                    2. Eliminar (Pop)
                    3. Mostrar
                    4. Salir
                    """));

            switch (op) {
                case 1 -> {
                    String valor = JOptionPane.showInputDialog("Digite el valor (String):");
                    Nodo nuevo = new Nodo(valor);
                    nuevo.sig = tope; // el nuevo apunta al anterior tope
                    tope = nuevo; // el nuevo se convierte en el tope
                }

                case 2 -> {
                    if (tope != null) {
                        JOptionPane.showMessageDialog(null, "Se eliminó: " + tope.dato);
                        tope = tope.sig; // se mueve el tope al siguiente nodo
                    } else {
                        JOptionPane.showMessageDialog(null, "Underflow - pila vacía");
                    }
                }

                case 3 -> {
                    if (tope != null) {
                        Nodo aux = tope;
                        String salida = "Contenido de la pila:\n";
                        while (aux != null) {
                            salida += aux.dato + "\n";
                            aux = aux.sig;
                        }
                        JOptionPane.showMessageDialog(null, salida);
                    } else {
                        JOptionPane.showMessageDialog(null, "Pila vacía");
                    }
                }

                case 4 -> JOptionPane.showMessageDialog(null, "Gracias, programa finalizado");

                default -> JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }
}