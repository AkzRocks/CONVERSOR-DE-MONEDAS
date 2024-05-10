
import com.conversordefinitivo.modelos.Busqueda;
import com.conversordefinitivo.modelos.Conversion;
import com.conversordefinitivo.modelos.Datos;

import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args)  {
        Scanner leer = new Scanner(System.in);
        int continuar = 0;
        Map<String, Double> divisas;
        while (continuar == 0) {
            Datos datos = new Datos();
            datos.Fachada();
            if (datos.isDatosErrados()) {
                continue;
            } else if (!datos.isExit()) {
                // Consultamos exchangerate-api.com y regresamos Map de tasas de cambio
                Busqueda consulta = new Busqueda();
                consulta.BusquedaConversiones(datos.getMonedaInicial());
                divisas = consulta.getDivisas();
                if (!(divisas == null)) {
                    // Encontramos la tasa de cambio y calculamos el monto de cotisación
                    Conversion conversion = new Conversion();
                    conversion.Proceso(datos.getMonedaInicial(), datos.getMontoBase(),
                            datos.getMonedaDeseada(), divisas);
                } else{
                    continue;
                }
                if (continuar == 0){
                    System.out.println("Si desea realizar una nueva operacion precione 0");
                    System.out.println("Si desea salir cualquier otro numero");
                    continuar = leer.nextInt();
                }
            }
        }
        System.out.println("GRACIAS POR USAR EL CONVERSOR DE MONEDAS");
    }
}