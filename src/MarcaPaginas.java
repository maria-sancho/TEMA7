public class MarcaPaginas {
    private int paginaActual;
    private int totalPaginas;

    public MarcaPaginas(int totalPaginas) {
        this.paginaActual = 0;
        this.totalPaginas = totalPaginas;
    }

    public void incrementarPagina() {
        if (paginaActual < totalPaginas) {
            paginaActual++;
        } else {
            System.out.println("Ya has llegado a la última página");
        }
    }

    public int obtenerUltimaPaginaLeida() {
        return paginaActual;
    }

    public void comenzarDesdeElPrincipio() {
        paginaActual = 0;
    }
}