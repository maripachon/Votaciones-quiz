import java.util.ArrayList;
import java.util.List;

public class Eleccion {
    private List<Candidato> candidatos;

    public Eleccion() {
        this.candidatos = new ArrayList<>();
    }

    public Eleccion(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public void votar(int indiceCandidato, String medio) {
        if (indiceCandidato >= 0 && indiceCandidato < candidatos.size()) {
            candidatos.get(indiceCandidato).agregarVoto(medio);
        }
    }

    public void vaciarUrnas() {
        for (Candidato c : candidatos) {
            c.resetearVotos();
        }
    }

    public int totalVotos() {
        int total = 0;
        for (Candidato c : candidatos) {
            total += c.getTotalVotos();
        }
        return total;
    }

    public double porcentajeVotos(Candidato candidato) {
        int total = totalVotos();
        return total == 0 ? 0 : (candidato.getTotalVotos() * 100.0) / total;
    }

    public double costoPromedioCampaña() {
        if (candidatos.isEmpty()) return 0;
        double totalCosto = 0;
        for (Candidato c : candidatos) {
            totalCosto += c.calcularCostoCampaña();
        }
        return totalCosto / candidatos.size();
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }
}

