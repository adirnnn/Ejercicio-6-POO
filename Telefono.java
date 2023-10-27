public class Telefono extends DispositivoElectronico {
    private String modelo;

    public Telefono(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }
}