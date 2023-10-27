public abstract class DispositivoElectronico {
    private boolean encendido;

    public DispositivoElectronico() {
        this.encendido = false;
    }

    public void encender() {
        encendido = true;
    }

    public void apagar() {
        encendido = false;
    }

    public boolean estaEncendido() {
        return encendido;
    }
}