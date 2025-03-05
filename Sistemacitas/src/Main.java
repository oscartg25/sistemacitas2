/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author GEINDEL
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada
        SistemaCitas sistema = new SistemaCitas();

        // Menú principal
        while (true) {
            System.out.println("\n--- Sistema de Gestión de Citas Médicas ---");
            System.out.println("1. Agregar Paciente");
            System.out.println("2. Agregar Médico");
            System.out.println("3. Solicitar Cita");
            System.out.println("4. Cancelar Cita");
            System.out.println("5. Mostrar Citas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Agregar Paciente
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombrePaciente = scanner.nextLine();
                    System.out.print("Ingrese el ID del paciente: ");
                    String idPaciente = scanner.nextLine();
                    Paciente paciente = new Paciente(nombrePaciente, idPaciente);
                    sistema.agregarPaciente(paciente);
                    break;

                case 2:
                    // Agregar Médico
                    System.out.print("Ingrese el nombre del médico: ");
                    String nombreMedico = scanner.nextLine();
                    System.out.print("Ingrese la especialidad del médico: ");
                    String especialidadMedico = scanner.nextLine();
                    Medico medico = new Medico(nombreMedico, especialidadMedico);
                    sistema.agregarMedico(medico);
                    break;

                case 3:
                    // Solicitar Cita
                    System.out.print("Ingrese el ID del paciente: ");
                    String idPacienteCita = scanner.nextLine();
                    Paciente pacienteCita = sistema.buscarPacientePorId(idPacienteCita);

                    System.out.print("Ingrese el nombre del médico: ");
                    String nombreMedicoCita = scanner.nextLine();
                    Medico medicoCita = sistema.buscarMedicoPorNombre(nombreMedicoCita);

                    if (pacienteCita != null && medicoCita != null) {
                        System.out.print("Ingrese la fecha de la cita (YYYY-MM-DD): ");
                        String fechaCita = scanner.nextLine();
                        System.out.print("Ingrese la hora de la cita (HH:MM): ");
                        String horaCita = scanner.nextLine();
                        sistema.solicitarCita(pacienteCita, medicoCita, fechaCita, horaCita);
                    } else {
                        System.out.println("Paciente o médico no encontrado.");
                    }
                    break;

                case 4:
                    // Cancelar Cita
                    System.out.print("Ingrese el ID del paciente: ");
                    String idPacienteCancelar = scanner.nextLine();
                    Paciente pacienteCancelar = sistema.buscarPacientePorId(idPacienteCancelar);

                    if (pacienteCancelar != null) {
                        System.out.print("Ingrese la fecha de la cita a cancelar (YYYY-MM-DD): ");
                        String fechaCancelar = scanner.nextLine();
                        System.out.print("Ingrese la hora de la cita a cancelar (HH:MM): ");
                        String horaCancelar = scanner.nextLine();
                        sistema.cancelarCita(pacienteCancelar, fechaCancelar, horaCancelar);
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;

                case 5:
                    // Mostrar Citas
                    sistema.mostrarCitas();
                    break;

                case 6:
                    // Salir
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
