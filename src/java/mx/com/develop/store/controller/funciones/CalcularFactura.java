package mx.com.develop.store.controller.funciones;

public class CalcularFactura {

    public static double subTotal(double total) {
        return total / 1.16;
    }

    public static double iva(double total) {
        return total - subTotal(total);
    }
}
