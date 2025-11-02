package actividad.pkg1.estructura;

import java.util.Scanner;

public class Main {

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
        public void setData(T data) { this.data = data; }
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

        public NodeD(T data) {
            this.data = data;
        }

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
            if (head == null) {
                head = nuevo;
            } else {
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
            if (head == null) {
                System.out.println("La lista está vacía.");
                return;
            }
            Node<T> temp = head;
            while (temp != null) {
                System.out.print(temp.getData() + " -> ");
                temp = temp.getNext();
            }
            System.out.println("NULL");
        }
    }

    // ============================
    // Lista doblemente enlazada
    // ============================
    static class DoublyLinkedList<T> {
        private NodeD<T> head;
        private NodeD<T> tail;

        public void insertar(T data) {
            NodeD<T> nuevo = new NodeD<>(data);
            if (head == null) {
                head = tail = nuevo;
            } else {
                tail.setNext(nuevo);
                nuevo.setPrev(tail);
                tail = nuevo;
            }
        }

        public void mostrar() {
            if (head == null) {
                System.out.println("La lista está vacía.");
                return;
            }
            NodeD<T> temp = head;
            while (temp != null) {
                System.out.print(temp.getData() + " <-> ");
                temp = temp.getNext();
            }
            System.out.println("NULL");
        }
    }
 
    // ============================
    // Clase Contacto (dato complejo)
    // ============================
    static class Contacto {
        private String nombre;
        private String direccion;
        private String telefono;

        public Contacto(String nombre, String direccion, String telefono) {
            this.nombre = nombre;
            this.direccion = direccion;
            this.telefono = telefono;
        }

        @Override
        public String toString() {
            return "[" + nombre + ", " + direccion + ", " + telefono + "]";
        }
    }

    // ============================
    // Clase Pila (Stack)
    // ============================
    static class Pila<T> {
        private Node<T> tope;

        public boolean isEmpty() {
            return tope == null;
        }

        public void push(T data) {
            Node<T> nuevo = new Node<>(data);
            nuevo.setNext(tope);
            tope = nuevo;
            System.out.println("Elemento agregado a la pila.");
        }

        public T pop() {
            if (isEmpty()) {
                System.out.println("La pila está vacía.");
                return null;
            }
            T dato = tope.getData();
            tope = tope.getNext();
            System.out.println("Elemento eliminado de la pila: " + dato);
            return dato;
        }

        public T peek() {
            if (isEmpty()) {
                System.out.println("La pila está vacía.");
                return null;
            }
            System.out.println("Cima de la pila: " + tope.getData());
            return tope.getData();
        }

        public void mostrar() {
            if (isEmpty()) {
                System.out.println("Pila vacía.");
                return;
            }
            System.out.println("\n--- Pila ---");
            Node<T> temp = tope;
            while (temp != null) {
                System.out.print(temp.getData() + " -> ");
                temp = temp.getNext();
            }
            System.out.println("NULL");
        }
    }

    // ============================
    // Clase Cola (Queue)
    // ============================
    static class Cola<T> {
        private Node<T> frente;
        private Node<T> fin;

        public boolean isEmpty() {
            return frente == null;
        }

        public void enqueue(T data) {
            Node<T> nuevo = new Node<>(data);
            if (fin == null) {
                frente = fin = nuevo;
            } else {
                fin.setNext(nuevo);
                fin = nuevo;
            }
            System.out.println("Elemento agregado a la cola.");
        }

        public T dequeue() {
            if (isEmpty()) {
                System.out.println("La cola está vacía.");
                return null;
            }
            T dato = frente.getData();
            frente = frente.getNext();
            if (frente == null) fin = null;
            System.out.println("Elemento eliminado de la cola: " + dato);
            return dato;
        }

        public T peek() {
            if (isEmpty()) {
                System.out.println("La cola está vacía.");
                return null;
            }
            System.out.println("Frente de la cola: " + frente.getData());
            return frente.getData();
        }

        public void mostrar() {
            if (isEmpty()) {
                System.out.println("Cola vacía.");
                return;
            }
            System.out.println("\n--- Cola ---");
            Node<T> temp = frente;
            while (temp != null) {
                System.out.print(temp.getData() + " -> ");
                temp = temp.getNext();
            }
            System.out.println("NULL");
        }
    }

    // ============================
    // Módulo de pruebas del sistema
    // ============================
    public static void pruebasSistema() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        Pila<Object> pila = new Pila<>();
        Cola<Object> cola = new Cola<>();

        do {
            System.out.println("\n===== Gestión del Sistema (Simulado) =====");
            System.out.println("1. Usar Pila");
            System.out.println("2. Usar Cola");
            System.out.println("3. Regresar");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();
            sc.nextLine();

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

                case 3:
                    System.out.println("Regresando...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    // ============================
    // Main y Menú Principal
    // ============================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("======================================");
        System.out.println(" Screenshot del alumno");
        System.out.println(" Nombre: Gael Giovanni Gaytán García");
        System.out.println(" Matrícula: 07099843");
        System.out.println("======================================");

        do {
            System.out.println("\n=== Sistema de Estructuras ===");
            System.out.println("1. Lista Simple");
            System.out.println("2. Lista Doble");
            System.out.println("3. Probar Pila y Cola");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:
                    LinkedList<Object> listaS = new LinkedList<>();
                    menuListaSimple(listaS, sc);
                    break;
                case 2:
                    DoublyLinkedList<Object> listaD = new DoublyLinkedList<>();
                    menuListaDoble(listaD, sc);
                    break;
                case 3:
                    pruebasSistema();
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while(opcion != 4);
        sc.close();
    }

    // Menú lista simple
    public static void menuListaSimple(LinkedList<Object> lista, Scanner sc) {
        int opcion;
        do {
            System.out.println("\n--- Menú Lista Simple ---");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar elemento");
            System.out.println("3. Buscar elemento");
            System.out.println("4. Mostrar lista");
            System.out.println("5. Agregar contacto");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un dato: ");
                    Object dato = sc.nextLine();
                    lista.insertar(dato);
                    break;
                case 2:
                    System.out.print("Dato a eliminar: ");
                    Object elim = sc.nextLine();
                    if (lista.eliminar(elim))
                        System.out.println("Eliminado correctamente.");
                    else
                        System.out.println("No encontrado.");
                    break;
                case 3:
                    System.out.print("Dato a buscar: ");
                    Object bus = sc.nextLine();
                    if (lista.buscar(bus))
                        System.out.println("Dato encontrado.");
                    else
                        System.out.println("Dato no encontrado.");
                    break;
                case 4:
                    lista.mostrar();
                    break;
                case 5:
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();
                    System.out.print("Dirección: ");
                    String d = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String t = sc.nextLine();
                    Contacto c = new Contacto(n, d, t);
                    lista.insertar(c);
                    System.out.println("Contacto agregado.");
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    // Menú lista doble
    public static void menuListaDoble(DoublyLinkedList<Object> lista, Scanner sc) {
        int opcion;
        do {
            System.out.println("\n--- Menú Lista Doble ---");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un dato: ");
                    Object dato = sc.nextLine();
                    lista.insertar(dato);
                    break;
                case 2:
                    lista.mostrar();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
    }
}
