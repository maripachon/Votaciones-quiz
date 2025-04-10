import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creamos los candidatos con el constructor vacío y les asignamos nombre
        Candidato c1 = new Candidato();
        c1.setNombre("Carlos");

        Candidato c2 = new Candidato();
        c2.setNombre("María");

        Candidato c3 = new Candidato();
        c3.setNombre("Luis");

        List<Candidato> candidatos = new ArrayList<>();
        candidatos.add(c1);
        candidatos.add(c2);
        candidatos.add(c3);

        Eleccion eleccion = new Eleccion();
        eleccion.setCandidatos(candidatos);

        int opcion;
        int elegido;
        int totalVotos;
        int costoTotal;
        double promedio;

        do {
            System.out.println("\n--- ELECCIONES MUNICIPIO PREMIER ---");
            System.out.println("1. Votar");
            System.out.println("2. Calcular costo campaña de un candidato");
            System.out.println("3. Vaciar urnas");
            System.out.println("4. Total de votos");
            System.out.println("5. Porcentaje de votos por candidato");
            System.out.println("6. Costo promedio de campaña");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Seleccione un candidato:");
                    for (int i = 0; i < candidatos.size(); i++) {
                        System.out.println((i + 1) + ". " + candidatos.get(i).getNombre());
                    }
                    elegido = scanner.nextInt() - 1;

                    if (elegido >= 0 && elegido < candidatos.size()) {
                        System.out.println("¿Qué medio influyó en su voto? (Internet / Radio / TV):");
                        scanner.nextLine(); // limpiar buffer
                        String medio = scanner.nextLine();

                        eleccion.votar(elegido, medio);
                        System.out.println("¡Voto registrado!");
                    } else {
                        System.out.println("Candidato inválido.");
                    }
                }
                case 2 -> {
                    for (int i = 0; i < candidatos.size(); i++) {
                        System.out.println((i + 1) + ". " + candidatos.get(i).getNombre());
                    }
                    System.out.print("Seleccione el candidato: ");
                    int index = scanner.nextInt() - 1;

                    if (index >= 0 && index < candidatos.size()) {
                        System.out.println("Costo de campaña: $" + candidatos.get(index).calcularCostoCampaña());
                    } else {
                        System.out.println("Candidato inválido.");
                    }
                }
                case 3 -> {
                    eleccion.vaciarUrnas();
                    System.out.println("Urnas vaciadas.");
                }
                case 4 -> {
                    System.out.println("Total de votos: " + eleccion.totalVotos());
                    for (Candidato c : candidatos) {
                        System.out.println(c.getNombre() + ": " + c.getTotalVotos() + " votos");
                    }
                }
                case 5 -> {
                    for (Candidato c : candidatos) {
                        System.out.printf("%s: %.2f%%\n", c.getNombre(), eleccion.porcentajeVotos(c));
                    }
                }
                case 6 -> {
                    System.out.println("Costo promedio por candidato:");
                    for (Candidato c : candidatos) {
                        totalVotos = c.getTotalVotos();
                        costoTotal = c.calcularCostoCampaña();
                        if (totalVotos == 0) {
                            promedio = 0;
                        } else {
                            promedio = (double) costoTotal / totalVotos;
                        }
                        System.out.println(
                                c.getNombre() + ": " +
                                        totalVotos + " votos, Costo total: $" +
                                        String.format("%,d", costoTotal) + ", Promedio por voto:" +
                                        String.format("%,.2f", promedio)
                        );
                    }
                }



                case 7 -> System.out.println("Saliendo...");
                default -> {
                    if (opcion < 1 || opcion > 7)
                        System.out.println("Opción inválida.");
                }
            }
        } while (opcion != 7);

        scanner.close();
    }
}

