
public class ComplexNumbers {

    public int real;
    public int imaginario;

    public ComplexNumbers(int _real, int _imaginario) {
        this.real = _real;
        this.imaginario = _imaginario;
    }

    public ComplexNumbers sumar(ComplexNumbers numero) {
        return new ComplexNumbers(this.real + numero.real, this.imaginario + numero.imaginario);
    }

    public ComplexNumbers restar(ComplexNumbers numero) {
        return new ComplexNumbers(this.real - numero.real, this.imaginario - numero.imaginario);
    }

    public ComplexNumbers multiplicar(ComplexNumbers numero) {
        return new ComplexNumbers((this.real * numero.real - this.imaginario * numero.imaginario),
                (this.real * numero.imaginario + this.imaginario * numero.real));
    }

    public ComplexNumbers dividir(ComplexNumbers numero) {
        int denominador = numero.real * numero.real + numero.imaginario * numero.imaginario;
        int nuevoReal = (this.real * numero.real + this.imaginario * numero.imaginario) / denominador;
        int nuevoImaginario = (this.imaginario * numero.real - this.real * numero.imaginario) / denominador;
        return new ComplexNumbers(nuevoReal, nuevoImaginario);
    }

    public ComplexNumbers conjugado() {
        return new ComplexNumbers(real, -imaginario);
    }

    public double modulo() {
        return Math.sqrt(real * real + imaginario * imaginario);
    }

    public double fase() {
        return Math.atan2(imaginario, real);
    }

    public ComplexNumbers potencia(int n) {
        int nuevoReal = (int) Math.round(Math.pow(modulo(), n) * Math.cos(fase() * n));
        int nuevoImaginario = (int) Math.round(Math.pow(modulo(), n) * Math.sin(fase() * n));
        return new ComplexNumbers(nuevoReal, nuevoImaginario);
    }

    public ComplexNumbers raizCuadrada() {
        int nuevoReal = (int) Math.round(Math.sqrt(modulo()) * Math.cos(fase() / 2));
        int nuevoImaginario = (int) Math.round(Math.sqrt(modulo()) * Math.sin(fase() / 2));
        return new ComplexNumbers(nuevoReal, nuevoImaginario);
    }

    public ComplexNumbers logaritmo() {
        double r = Math.sqrt(this.real * this.real + this.imaginario * this.imaginario);
        double theta = Math.atan2(this.imaginario, this.real);
        int nuevoReal = (int) Math.round(Math.log(r));
        int nuevoImaginario = (int) Math.round(theta);

        return new ComplexNumbers(nuevoReal, nuevoImaginario);
    }

    public String imprimir() {
        if (this.imaginario > 0)
            return Integer.toString(this.real) + " + " + Integer.toString(this.imaginario) + "i";
        else
            return Integer.toString(this.real) + "  " + Integer.toString(this.imaginario) + 'i';
    }

    public static void main(String[] args) {

        ComplexNumbers c1 = new ComplexNumbers(1, 2);
        ComplexNumbers c2 = new ComplexNumbers(5, 6);

        ComplexNumbers suma = c1.sumar(c2);
        ComplexNumbers resta = c1.restar(c2);
        ComplexNumbers multiplicacion = c1.multiplicar(c2);
        ComplexNumbers division = c1.dividir(c2);
        ComplexNumbers conjugado = c1.conjugado();

        double modulo = c1.modulo();
        double fase = c1.fase();

        ComplexNumbers potencia = c1.potencia(2);
        ComplexNumbers raizCuadrada = c1.raizCuadrada();
        ComplexNumbers logaritmo = c1.logaritmo();

        System.out.println("Numeros Complejos en Java\n");
        System.out.println("suma  =  " + suma.imprimir());
        System.out.println("resta   =   " + resta.imprimir());
        System.out.println("multiplicacion   =   " + multiplicacion.imprimir());
        System.out.println("division  =  " + division.imprimir());
        System.out.println("conjugado   =   " + conjugado.imprimir());
        System.out.println("modulo   =   " + modulo);
        System.out.println("fase  =  " + fase);
        System.out.println("potencia   =   " + potencia.imprimir());
        System.out.println("raizCuadrada   =   " + raizCuadrada.imprimir());
        System.out.println("logaritmo   =   " + logaritmo.imprimir());

    }
}