package circulo;

public class Circulo implements Comparable<Circulo>{
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    public double calcularArea() {
        return getRadio() * getRadio() * Math.PI;
    }
    
    public double calcularPerimetro() {
        return getRadio() * Math.PI * 2;
    }

    @Override
    public String toString() {
        return String.format("%s: %f | %s: %f | %s: %f", "Círculo de radio",
                getRadio(), "Area", calcularArea(), "Perímetro", calcularPerimetro());
    }

    @Override
    public int compareTo(Circulo c) {
        if (c.getRadio() > radio) {
            return -1;
        } else {
            return 1;
        }
    }
}
