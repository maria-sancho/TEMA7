public class Calendario {

    private int año;
    private int mes;
    private int dia;

    public Calendario(int año, int mes, int dia) {
        if (fechaValida(año, mes, dia)) {
            this.año = año;
            this.mes = mes;
            this.dia = dia;
        } else {
            throw new IllegalArgumentException("Fecha no válida");
        }
    }

    public void incrementarDia() {
        int ultimoDia = obtenerUltimoDiaMes(this.mes, this.año);
        if (this.dia < ultimoDia) {
            this.dia++;
        } else {
            this.dia = 1;
            incrementarMes();
        }
    }

    public void incrementarMes() {
        if (this.mes < 12) {
            this.mes++;
        } else {
            this.mes = 1;
            incrementarAño(1);
        }
    }

    public void incrementarAño(int cantidad) {
        if (this.año + cantidad <= 0) {
            throw new IllegalArgumentException("El año 0 no existe");
        }
        this.año += cantidad;
    }

    public void mostrar() {
        System.out.println(this.dia + "/" + this.mes + "/" + this.año);
    }

    public boolean iguales(Calendario otraFecha) {
        return (this.año == otraFecha.año && this.mes == otraFecha.mes && this.dia == otraFecha.dia);
    }

    private boolean fechaValida(int anio, int mes, int dia) {
        if (anio <= 0 || mes <= 0 || mes > 12) {
            return false;
        }
        int ultimoDiaMes = obtenerUltimoDiaMes(mes, año);
        return (dia > 0 && dia <= ultimoDiaMes);
    }

    private int obtenerUltimoDiaMes(int mes, int año) {
        int[] diasMeses = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (mes == 2 && esBisiesto(año)) {
            return 29;
        } else {
            return diasMeses[mes-1];
        }
    }

    private boolean esBisiesto(int año) {
        return (año % 4 == 0 && (año % 100 != 0 || año % 400 == 0));
    }
}
