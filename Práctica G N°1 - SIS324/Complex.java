import java.util.Scanner;

class Complex {
    private double real;
    private double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex sumar(Complex num) {
        return new Complex(this.real + num.real, this.imag + num.imag);
    }

    public Complex restar(Complex num) {
        return new Complex(this.real - num.real, this.imag - num.imag);
    }

    public Complex multiplicar(Complex num) {
        return new Complex(this.real * num.real - this.imag * num.imag, this.real * num.imag + this.imag * num.real);
    }

    public Complex dividir(Complex num) {
        double denom = num.real * num.real + num.imag * num.imag;
        return new Complex((this.real * num.real + this.imag * num.imag) / denom,
                           (this.imag * num.real - this.real * num.imag) / denom);
    }

    public Complex conjugado() {
        return new Complex(this.real, -this.imag);
    }

    public double modulo() {
        return Math.sqrt(this.real * this.real + this.imag * this.imag);
    }

    public double fase() {
        return Math.atan2(this.imag, this.real);
    }

    public Complex potencia(int n) {
        double mod = Math.pow(modulo(), n);
        double ang = fase() * n;
        return new Complex(mod * Math.cos(ang), mod * Math.sin(ang));
    }

    public Complex raizCuadrada() {
        double mod = Math.sqrt(modulo());
        double ang = fase() / 2;
        return new Complex(mod * Math.cos(ang), mod * Math.sin(ang));
    }

    public Complex logaritmo() {
        return new Complex(Math.log(modulo()), fase());
    }

    @Override
    public String toString() {
        if (imag >= 0)
            return real + " + " + imag + "i";
        else
            return real + " - " + Math.abs(imag) + "i";
    }

    public static Complex toComplex(String s) {
        s = s.replaceAll("\\s+", ""); 
        double real = 0;
        double imag = 0;
        String[] parts = s.split("(?=[+-])"); 
        for (String part : parts) {
            if (part.contains("i")) { 
                imag += Double.parseDouble(part.replace("i", ""));
            } else { 
                real += Double.parseDouble(part);
            }
        }
        return new Complex(real, imag);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Complex resultado = null;
        System.out.println("**************************************************************");
        System.out.println("********** Bienvenido al programa de números Complejos *******");
        System.out.println("**************************************************************");
        do {
            System.out.println("Elija la operación a realizar:");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Conjugado");
            System.out.println("6. Módulo");
            System.out.println("7. Fase");
            System.out.println("8. Potencia");
            System.out.println("9. Raíz cuadrada");
            System.out.println("10. Logaritmo");
            System.out.println("11. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = sc.nextInt();
            if (opcion == 11) {
                System.out.println("Gracias por usar el programa.");
                break;
            }
            sc.nextLine();
            System.out.print("Ingrese el primer número complejo (± a ± bi): ");
            String num1Str = sc.nextLine();
            System.out.print("Ingrese el segundo número complejo (± a ± bi): ");
            String num2Str = sc.nextLine();
            Complex num1 = toComplex(num1Str);
            Complex num2 = toComplex(num2Str);
            switch (opcion) {
                case 1:
                    resultado = num1.sumar(num2);
                    break;
                case 2:
                    resultado = num1.restar(num2);
                    break;
                case 3:
                    resultado = num1.multiplicar(num2);
                    break;
                case 4:
                    resultado = num1.dividir(num2);
                    break;
                case 5:
                    resultado = num1.conjugado();
                    break;
                case 6:
                    System.out.println("El módulo del primer número complejo es: " + num1.modulo());
                    continue;
                case 7:
                    System.out.println("La fase del primer número complejo es: " + num1.fase());
                    continue;
                case 8:
                    System.out.print("Ingrese el exponente: ");
                    int exponente = sc.nextInt();
                    resultado = num1.potencia(exponente);
                    break;
                case 9:
                    resultado = num1.raizCuadrada();
                    break;
                case 10:
                    resultado = num1.logaritmo();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    continue;
            }
            System.out.println("El resultado es: " + resultado.toString());
        } while (true);
    }
}