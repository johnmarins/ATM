import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        String nombreCliente = "Pedrito Peréz";
        String tipoCuenta = "Corriente";
        double saldoDisponible = 0;

        System.out.println("*********************************\n");
        System.out.format("Nombre del cliente: %s \n", nombreCliente);
        System.out.format("Tipo de cuenta: %s \n", tipoCuenta);
        System.out.format("Saldo disponible: %s \n", formatearMoneda(saldoDisponible));
        System.out.println("*********************************\n");

        String opciones = """
                ********************************************
                ** Escriba el número de la opción deseada **
                1 - Consultar saldo
                2 - Retirar
                3 - Depositar
                9 - Salir
                ********************************************
                """;

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 9) {
            System.out.println(opciones);
            opcion = sc.nextInt();

            if (opcion > 3 && opcion < 9) {
                System.out.println("Esta opción no se encuentra disponible");
            }
            switch (opcion) {
                case 1:
                    if (saldoDisponible == 0) {
                        System.out.println("Tu cuenta se encuentra sin fondos");
                    }
                    System.out.format("Saldo disponible: %s \n", formatearMoneda(saldoDisponible));
                    sleep();
                    break;

                case 2:
                    System.out.println("¿Cuál es el valor que deseas retirar?");
                    double valorSolicitado = sc.nextDouble();

                    if (valorSolicitado > saldoDisponible) {
                        System.out.println("Lo sentimos, saldo insuficiente para esta transacción");
                        System.out.format("Saldo disponible: %s \n", formatearMoneda(saldoDisponible));
                    } else {
                        saldoDisponible -= valorSolicitado;
                        System.out.format("Valor solicitado: %s \n", formatearMoneda(valorSolicitado));
                        System.out.format("Nuevo saldo disponible: %s \n", formatearMoneda(saldoDisponible));
                    }

                    sleep();
                    break;

                case 3:
                    System.out.println("¿Cuál es el valor que deseas depositar?");
                    double valorDeposito = sc.nextDouble();
                    saldoDisponible += valorDeposito;
                    System.out.format("Valor del deposito: %s \n", formatearMoneda(valorDeposito));
                    System.out.format("Nuevo saldo disponible: %s \n", formatearMoneda(saldoDisponible));
                    sleep();
                    break;

                case 9:
                    System.out.println("Gracias por utilizar nuestro servicio");
                    sleep();
                   break;
            }
        }

    }

    public static String formatearMoneda(double valor) {
        Locale CO = new Locale("es", "CO");
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(CO);
        String valorFormateado = formatoMoneda.format(valor);
        return valorFormateado;
    }

    public static void sleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
