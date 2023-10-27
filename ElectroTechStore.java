// ElectroTechStore.java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class ElectroTechStore {
    private List<DispositivoElectronico> stand = new ArrayList<>();
    private String archivoCSV;
    private boolean isLoaded = false;

    public ElectroTechStore(String archivoCSV) {
        this.archivoCSV = archivoCSV;
        cargarDesdeCSV();
    }

    public void agregarDispositivo(DispositivoElectronico dispositivo) {
        stand.add(dispositivo);
    }

    public void mostrarInformacion() {
        for (DispositivoElectronico dispositivo : stand) {
            System.out.println(dispositivo);
        }
    }

    public void validarEncendidos() {
        for (DispositivoElectronico dispositivo : stand) {
            if (dispositivo.estaEncendido()) {
                System.out.println("Encendido: " + dispositivo);
            } else {
                System.out.println("Apagado: " + dispositivo);
            }
        }
    }

    public void guardarEnCSV() {
        try (PrintWriter writer = new PrintWriter(new File(archivoCSV))) {
            writer.println("Tipo,Modelo/Marca,Encendido");
            
            for (DispositivoElectronico dispositivo : stand) {
                String tipo = dispositivo instanceof Telefono ? "Telefono" : "Computadora";
                String modeloMarca = dispositivo instanceof Telefono ? ((Telefono) dispositivo).getModelo() : ((ComputadoraPortatil) dispositivo).getMarca();
                String encendido = String.valueOf(dispositivo.estaEncendido());
                writer.println(tipo + "," + modeloMarca + "," + encendido);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void cargarDesdeCSV() {
        stand.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCSV))) {
            String line;
            boolean header = true;
            while ((line = reader.readLine()) != null) {
                if (header) {
                    header = false;
                    continue;  // Skip the header line
                }
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String tipo = parts[0];
                    String modeloMarca = parts[1];
                    boolean encendido = Boolean.parseBoolean(parts[2]);
                    if (tipo.equals("Telefono")) {
                        Telefono telefono = new Telefono(modeloMarca);
                        if (encendido) {
                            telefono.encender();
                        }
                        stand.add(telefono);
                    } else if (tipo.equals("Computadora")) {
                        ComputadoraPortatil computadora = new ComputadoraPortatil(modeloMarca);
                        if (encendido) {
                            computadora.encender();
                        }
                        stand.add(computadora);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}