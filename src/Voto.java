public class Voto {
    private Candidato candidato;
    private String medio;

    public Voto() {
        // Constructor vacío
    }

    public Voto(Candidato candidato, String medio) {
        this.candidato = candidato;
        this.medio = medio;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }
}

