public class Candidato {
    private String nombre;
    private int votosInternet;
    private int votosRadio;
    private int votosTv;

    public Candidato() {
        // Constructor vacío
    }

    public Candidato(String nombre) {
        this.nombre = nombre;
        this.votosInternet = 0;
        this.votosRadio = 0;
        this.votosTv = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalVotos() {
        return votosInternet + votosRadio + votosTv;
    }

    public int getVotosInternet() {
        return votosInternet;
    }

    public int getVotosRadio() {
        return votosRadio;
    }

    public int getVotosTv() {
        return votosTv;
    }

    public void agregarVoto(String medio) {
        switch (medio.toLowerCase()) {
            case "internet" -> votosInternet++;
            case "radio" -> votosRadio++;
            case "tv" -> votosTv++;
        }
    }

    public int calcularCostoCampaña() {
        return votosInternet * 700000 + votosRadio * 200000 + votosTv * 600000;
    }

    public void resetearVotos() {
        votosInternet = 0;
        votosRadio = 0;
        votosTv = 0;
    }
}
