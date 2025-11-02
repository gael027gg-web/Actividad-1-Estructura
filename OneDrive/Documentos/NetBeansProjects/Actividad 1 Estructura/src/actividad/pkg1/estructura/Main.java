package actividad.pkg1.estructura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // ============================
    // Clase genérica Node (simple)
    // ============================
    static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() { return data; }
        public Node<T> getNext() { return next; }
        public void setNext(Node<T> next) { this.next = next; }
    }

    // ==========================================
    // Clase genérica NodeD para lista doble
    // ==========================================
    static class NodeD<T> {
        private T data;
        private NodeD<T> next;
        private NodeD<T> prev;

        public NodeD(T data) { this.data = data; }

        public T getData() { return data; }
        public NodeD<T> getNext() { return next; }
        public NodeD<T> getPrev() { return prev; }
        public void setNext(NodeD<T> next) { this.next = next; }
        public void setPrev(NodeD<T> prev) { this.prev = prev; }
    }

    // ============================
    // Lista simplemente enlazada
    // ============================
    static class LinkedList<T> {
        private Node<T> head;

        public void insertar(T data) {
            Node<T> nuevo = new Node<>(data);
            if (head == null) head = nuevo;
            else {
                Node<T> temp = head;
                while (temp.getNext() != null) temp = temp.getNext();
                temp.setNext(nuevo);
            }
        }

        public boolean eliminar(T data) {
            if (head == null) return false;
            if (head.getData().equals(data)) {
                head = head.getNext();
                return true;
            }
            Node<T> temp = head;
            while (temp.getNext() != null && !temp.getNext().getData().equals(data)) {
                temp = temp.getNext();
            }
            if (temp.getNext() == null) return false;
            temp.setNext(temp.getNext().getNext());
            return true;
        }

        public boolean buscar(T data) {
            Node<T> temp = head;
            while (temp != null) {
                if (temp.getData().equals(data)) return true;
                temp = temp.getNext();
            }
            return false;
        }

        public void mostrar() {
            if (head == null) System.out.println("La lista está vacía.");
            else {
                Node<T> temp = head;
                while (temp != null) {
                    System.out.print(temp.getData() + " -> ");
                    temp = temp.getNext();
                }
                System.out.println("NULL");
            }
        }
    }

    // ============================
    // Lista doblemente enlazada
    // ============================
    static class DoublyLinkedList<T> {
        private NodeD<T> head, tail;

        public void insertar(T data) {
            NodeD<T> nuevo = new NodeD<>(data);
            if (head == null) head = tail = nuevo;
            else {
                tail.setNext(nuevo);
                nuevo.setPrev(tail);
                tail = nuevo;
            }
        }

        public void mostrar() {
            if (head == null) System.out.println("La lista está vacía.");
            else {
                NodeD<T> temp = head;
                while (temp != null) {
                    System.out.print(temp.getData() + " <-> ");
                    temp = temp.getNext();
                }
                System.out.println("NULL");
            }
        }
    }

    // ============================
    // Clase Contacto
    // ============================
    static class Contacto {
        private String nombre, direccion, telefono;

        public Contacto(String n, String d, String t) {
            nombre = n; direccion = d; telefono = t;
        }

        public String toString() {
            return "[" + nombre + ", " + direccion + ", " + telefono + "]";
        }
    }

    // ============================
    // Clase Pila (Stack)
    // ============================
    static class Pila<T> {
        private Node<T> tope;

        public boolean isEmpty() { return tope == null; }

        public void push(T data) {
            Node<T> nuevo = new Node<>(data);
            nuevo.setNext(tope);
            tope = nuevo;
            System.out.println("Elemento agregado a la pila.");
        }

        public T pop() {
            if (isEmpty()) {
                System.out.println("Pila vacía.");
                return null;
            }
            T dato = tope.getData();
            tope = tope.getNext();
            System.out.println("Elemento eliminado: " + dato);
            return dato;
        }

        public T peek() {
            if (isEmpty()) {
                System.out.println("Pila vacía.");
                return null;
            }
            System.out.println("Cima: " + tope.getData());
            return tope.getData();
        }

        public void mostrar() {
            if (isEmpty()) System.out.println("Pila vacía.");
            else {
                System.out.println("--- Pila ---");
                Node<T> temp = tope;
                while (temp != null) {
                    System.out.print(temp.getData() + " -> ");
                    temp = temp.getNext();
                }
                System.out.println("NULL");
            }
        }
    }

    // ============================
    // Clase Cola (Queue)
    // ============================
    static class Cola<T> {
        private Node<T> frente, fin;

        public boolean isEmpty() { return frente == null; }

        public void enqueue(T data) {
            Node<T> nuevo = new Node<>(data);
            if (fin == null) frente = fin = nuevo;
            else {
                fin.setNext(nuevo);
                fin = nuevo;
            }
            System.out.println("Elemento agregado.");
        }

        public T dequeue() {
            if (isEmpty()) {
                System.out.println("Cola vacía.");
                return null;
            }
            T dato = frente.getData();
            frente = frente.getNext();
            if (frente == null) fin = null;
            System.out.println("Eliminado: " + dato);
            return dato;
        }

        public T peek() {
            if (isEmpty()) {
                System.out.println("Cola vacía.");
                return null;
            }
            System.out.println("Frente: " + frente.getData());
            return frente.getData();
        }

        public void mostrar() {
            if (isEmpty()) System.out.println("Cola vacía.");
            else {
                System.out.println("--- Cola ---");
                Node<T> temp = frente;
                while (temp != null) {
                    System.out.print(temp.getData() + " -> ");
                    temp = temp.getNext();
                }
                System.out.println("NULL");
            }
        }
    }

    // ============================
    // Métodos de menú entrada
    // ============================
    public static int leerInt() {
        try { return Integer.parseInt(br.readLine()); }
        catch (Exception e) { return -1; }
    }

    public static String leerTexto() throws IOException {
        return br.readLine();
    }

    // ============================
    // Módulo de pruebas del sistema
    // ============================
    public static void pruebasSistema() throws IOException {
        int opcion;
        Pila<Object> pila = new Pila<>();
        Cola<Object> cola = new Cola<>();

        do {
            System.out.println("\n===== Gestión de Procesos =====");
            System.out.println("1. Probar Pila");
            System.out.println("2. Probar Cola");
            System.out.println("3. Regresar");
            System.out.print("Opción: ");
            opcion = leerInt();

            switch (opcion) {
                case 1:
                    pila.push("Proceso A");
                    pila.push("Proceso B");
                    pila.mostrar();
                    pila.pop();
                    pila.peek();
                    pila.mostrar();
                    break;
                case 2:
                    cola.enqueue("Proceso 1");
                    cola.enqueue("Proceso 2");
                    cola.mostrar();
                    cola.dequeue();
                    cola.peek();
                    cola.mostrar();
                    break;
            }
        } while (opcion != 3);
    }
    
    // ============================
    // Menú de Lista Simple
    // ============================
    public static void menuListaSimple(LinkedList<Object> lista) throws IOException {
        int opcion;
        do {
            System.out.println("\n--- Lista Simple ---");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Mostrar");
            System.out.println("5. Agregar Contacto");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = leerInt();

            switch (opcion) {
                case 1:
                    System.out.print("Dato: ");
                    lista.insertar(leerTexto());
                    break;
                case 2:
                    System.out.print("Eliminar: ");
                    System.out.println(lista.eliminar(leerTexto())
                            ? "Eliminado" : "No encontrado");
                    break;
                case 3:
                    System.out.print("Buscar: ");
                    System.out.println(lista.buscar(leerTexto())
                            ? "Encontrado" : "No encontrado");
                    break;
                case 4:
                    lista.mostrar();
                    break;
                case 5:
                    System.out.print("Nombre: ");
                    String n = leerTexto();
                    System.out.print("Dirección: ");
                    String d = leerTexto();
                    System.out.print("Teléfono: ");
                    String t = leerTexto();
                    lista.insertar(new Contacto(n, d, t));
                    System.out.println("Contacto agregado.");
                    break;
            }
        } while (opcion != 6);
    }

    public static void menuListaDoble(DoublyLinkedList<Object> lista) throws IOException {
        int opcion;
        do {
            System.out.println("\n--- Lista Doble ---");
            System.out.println("1. Insertar");
            System.out.println("2. Mostrar");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            opcion = leerInt();

            switch (opcion) {
                case 1:
                    System.out.print("Dato: ");
                    lista.insertar(leerTexto());
                    break;
                case 2:
                    lista.mostrar();
                    break;
            }
        } while (opcion != 3);
    }

    // ============================
    // Main y Menú Principal
    // ============================
    public static void main(String[] args) throws IOException {

        int opcion;

        System.out.println("======================================");
        System.out.println(" Nombre: Gael Giovanni Gaytán García");
        System.out.println(" Matrícula: 07099843");
        System.out.println("======================================");

        do {
            System.out.println("\n=== Sistema de Estructuras ===");
            System.out.println("1. Lista Simple");
            System.out.println("2. Lista Doble");
            System.out.println("3. Probar Pila y Cola");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            opcion = leerInt();

            switch (opcion) {
                case 1 -> menuListaSimple(new LinkedList<>());
                case 2 -> menuListaDoble(new DoublyLinkedList<>());
                case 3 -> pruebasSistema();
                case 4 -> System.out.println("Fin del programa.");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 4);
    }
}
