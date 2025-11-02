/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Colas;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

public class ControlColasLista {

    public static void main(String[] args) {
        // Usamos la interfaz Queue, implementada por LinkedList
        // La cola almacenará números enteros (Integer)
        Queue<Integer> cola = new LinkedList<>(); 
        
        byte op = 0;

        while (op != 4) {
            try {
                // Se lee la opción del menú
                String input = JOptionPane.showInputDialog("Digite un numero\n"
                        + "1. Insertar\n"
                        + "2. Eliminar\n"
                        + "3. Mostrar\n"
                        + "4. Salir");
                
                if (input == null) {
                    // Manejar el caso de que el usuario presione "Cancelar" o cierre la ventana
                    op = 4;
                    continue; 
                }
                
                op = Byte.parseByte(input);

                switch (op) {
                    case 1:
                        // 1. Insertar (Enqueue)
                        try {
                            String valorStr = JOptionPane.showInputDialog("Digite el valor entero a insertar");
                            if (valorStr != null) {
                                int valor = Integer.parseInt(valorStr);
                                // El método add() de Queue inserta al final.
                                // Si no se puede, lanza una excepción (en LinkedList siempre puede).
                                cola.add(valor); 
                                JOptionPane.showMessageDialog(null, "Elemento insertado: " + valor);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error: Ingrese un número entero válido.");
                        } catch (IllegalStateException e) {
                            // Este catch es más relevante para implementaciones con límite de capacidad, 
                            // pero se mantiene por si se cambia la implementación de Queue.
                            JOptionPane.showMessageDialog(null, "Overflow (Cola llena).");
                        }
                        break;
                        
                    case 2:
                        // 2. Eliminar (Dequeue)
                        // El método poll() remueve y devuelve el elemento al frente (head) de la cola.
                        // Devuelve 'null' si la cola está vacía (evitando Underflow).
                        Integer elementoEliminado = cola.poll();
                        
                        if (elementoEliminado != null) {
                            JOptionPane.showMessageDialog(null, "Elemento eliminado: " + elementoEliminado);
                        } else {
                            // Comprobación de si la cola está vacía
                            JOptionPane.showMessageDialog(null, "Underflow (Cola vacia): No hay más datos.");
                        }
                        break;
                        
                    case 3:
                        // 3. Mostrar
                        if (!cola.isEmpty()) { 
                            StringBuilder sb = new StringBuilder("Elementos de la Cola:\n");
                            // Se recorre la lista sin modificarla (no elimina elementos)
                            for (Integer elemento : cola) { 
                                sb.append(elemento).append("\n");
                            }
                            JOptionPane.showMessageDialog(null, sb.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "Cola vacia");
                        }
                        break;
                        
                    case 4:
                        JOptionPane.showMessageDialog(null, "Gracias");
                        break;
                        
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida.");
                        break;
                }
            } catch (NumberFormatException e) {
                // Manejar la excepción si el usuario ingresa algo que no es un número para la opción del menú
                JOptionPane.showMessageDialog(null, "Error: Digite una opción válida (1-4).");
                op = 0; // Reiniciar la opción para que el bucle continúe
            }
        }
    }
}
