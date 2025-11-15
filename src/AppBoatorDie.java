import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import pkHumanos.vikingo_Observador;
import pkHumanos.Caperucita;
import pkAnimales.Lobo;
import pkFrutas.Uvas;

public class AppBoatorDie {

    public static final String VERDE = "\u001B[32m";
    public static final String ROJO = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String CELESTE = "\u001B[34m";
    public static final String MORADO = "\u001B[35m";
    public static final String AMARILLO = "\u001B[33m";


    private vikingo_Observador vikingo;
    private Caperucita caperucita;
    private Lobo lobo;
    private Uvas uvas;
    
    private List<Object> orillaInicial;
    private List<Object> orillaFinal;
    private List<Object> bote;
    private boolean vikingoEnOrillaInicial;
    private boolean juegoGanado;
    private boolean juegoPerdido;
    
    public AppBoatorDie() {
        vikingo = new vikingo_Observador("Vikingo", "Nórdico", 40, true, true);
        caperucita = new Caperucita("Caperucita", "Roja", 10, true);
        lobo = new Lobo(true);
        uvas = new Uvas(5);
        
    orillaInicial = new ArrayList<>();
    orillaFinal = new ArrayList<>();
        bote = new ArrayList<>();
        
    orillaInicial.add(vikingo);
    orillaInicial.add(caperucita);
    orillaInicial.add(lobo);
    orillaInicial.add(uvas);
        
        vikingoEnOrillaInicial = true;
        juegoGanado = false;
        juegoPerdido = false;
    }
    
    public void iniciar(){
    Scanner scanner = new Scanner(System.in);
    String opciones = "";
    boolean salirJuego = false;
    Integer opcion = 0;
        
        System.out.println(CELESTE + "\n==================================================================");
        System.out.println("========================= BOAT OR DIE =============================");
        System.out.println("==================================================================\n" + RESET);
        
        System.out.println("\nBienvenido al juego 'Boat or Die'! ¿Podrás ganar?\n");

        visualizarReglasJuego();
        
        do {
            if (juegoPerdido) {
                // Si ya se detectó perdida, salir del bucle
                break;
            }
            // Comprobar victoria antes de mostrar menú
            if (orillaFinal.size() == 4) {
                System.out.println(AMARILLO + "\n¡¡¡ FELICIDADES !!! ¡¡¡ HAS GANADO !!!" + RESET);
                juegoGanado = true;
                salirJuego = true;
            } else {
                System.out.println("\n¿Qué deseas hacer?");
                System.out.println("1. Mostrar estado");
                System.out.println("2. Subir objeto al bote");
                System.out.println("3. Bajar objeto del bote");
                System.out.println("4. Cruzar el río");
                System.out.println("5. Ver reglas");
                System.out.println("6. Vikingo cruza solo (sin objetos)");
                System.out.println("7. Salir del juego");
                System.out.print("Elige una opción (1-7): ");
                boolean entradaValida = false;
                do {
                    opciones = scanner.nextLine();
                    try {
                        opcion = Integer.parseInt(opciones);
                        if (opcion >= 1 && opcion <= 7) {
                            entradaValida = true;
                        } else {
                            System.out.println("Ingrese una opcion correcta (1-7)");
                        }
                    } catch (NumberFormatException e) {
                        imprimirErrorEntrada();
                    }
                } while (!entradaValida);
                
                
                switch(opcion) {
                    case 1:
                        mostrarEstado();
                        break;
                    case 2:
                        subirObjeto(scanner);
                        break;
                    case 3:
                        bajarObjeto(scanner);
                        break;
                    case 4:
                        cruzarRio();
                        break;
                    case 5:
                        visualizarReglasJuego();
                        break;
                    case 6:
                        cruzarSoloVikingo();
                        break;
                    case 7:
                        System.out.println("\n¡Gracias por jugar! Hasta luego.");
                        salirJuego = true;
                        break;
                    default:
                        imprimirErrorOpcionNoValida();
                    break;
                }
            }
        } while(!salirJuego);
        
        scanner.close();
    }

    private String getUbicacionIndividual(Object obj) {
        if (orillaInicial.contains(obj)) return "Orilla Inicial";
        if (orillaFinal.contains(obj)) return "Orilla Final";
        if (bote.contains(obj)) return "En el bote";
        return "Desconocido";
}

    private void imprimirErrorOpcionNoValida() {
        System.out.println(ROJO + "\n======================== ERROR ========================" + RESET );
        System.out.println("Opcion no valida. Intente nuevamente\n");
    }

    private void imprimirErrorEntrada() {
        System.out.println(ROJO + "\n======================== ERROR ========================" + RESET );
        System.out.println("Entrada no valida. Ingresa un numero (1-7)\n");
    }

    private void visualizarReglasJuego() {
        System.out.println(VERDE + "\n======================== REGLAS DEL JUEGO ========================\n" + RESET);
        System.out.println("\nObjetivo: Pasar a todos los objetos al otro lado del rio");
        System.out.println("\nRestricciones:");
        System.out.println("  * El bote solo puede llevar al Vikingo + 1 objeto");
        System.out.println("  * El Vikingo SIEMPRE debe pilotar el bote");
        System.out.println("  * Si quedan juntos el Lobo + Caperucita -> ¡Caperucita muere!");
        System.out.println("  * Si quedan juntas Caperucita + Uvas -> ¡Las Uvas son comidas!");
        System.out.println("\nVictoria: Todos los objetos en la otra orilla\n");
    }
    
    private void mostrarEstado() {
        System.out.println(VERDE + "\n======================== ESTADO ACTUAL DEL JUEGO ========================\n" + RESET);
    
        System.out.println("\nORILLA INICIAL (Izquierda):");
        if (orillaInicial.isEmpty()) {
             System.out.println("   [Vacia]");
        } else {
            for (Object obj : orillaInicial) {
                System.out.println("   * " + getNombreObjeto(obj));
            }
        }
    
        System.out.println("\nBOTE:");
        if (bote.isEmpty()) {
            System.out.println("   [Vacio]");
        } else {
            for (Object obj : bote) {
                System.out.println("   * " + getNombreObjeto(obj));
            }
        }
    
        System.out.println("\nORILLA FINAL (Derecha):");
        if (orillaFinal.isEmpty()) {
             System.out.println("   [Vacia]");
        } else {
            for (Object obj : orillaFinal) {
                System.out.println("   * " + getNombreObjeto(obj));
            }
        }

        System.out.println("\n-------------------- UBICACIÓN INDIVIDUAL --------------------");

        System.out.println("Vikingo:     " + getUbicacionIndividual(vikingo));
        System.out.println("Caperucita:  " + getUbicacionIndividual(caperucita));
        System.out.println("Lobo:        " + getUbicacionIndividual(lobo));
        System.out.println("Uvas:        " + getUbicacionIndividual(uvas));
        System.out.println("------------------------------------------------------------------");

}
    
    private void subirObjeto(Scanner scanner) {
        if (bote.size() >= 2) {
            System.out.println("\nERROR: El bote esta lleno. Maximo: Vikingo + 1 objeto\n");
            return;
        }
        
        // Si el vikingo no esta en el bote pero si en la orilla actual, sube automaticamente
            List<Object> listaActual;
            if (vikingoEnOrillaInicial) {
                listaActual = orillaInicial;
            } else {
                listaActual = orillaFinal;
            }
        if (!bote.contains(vikingo)) {
            if (listaActual.contains(vikingo)) {
                listaActual.remove(vikingo);
                bote.add(vikingo);
                System.out.println("\nOK: Vikingo subio al bote.\n");
            } else {
                System.out.println("\nERROR: El Vikingo debe estar en la orilla actual para subirse al bote.\n");
                return;
            }
        }
        
        // Mostrar opciones
        System.out.println("\nQue objeto deseas subir?");
        List<Object> objetosSinVikingo = new ArrayList<>();
        int indice = 1;
        
        for (Object obj : listaActual) {
            if (obj != vikingo) {
                System.out.println(indice + ". " + getNombreObjeto(obj));
                objetosSinVikingo.add(obj);
                indice++;
            }
        }
        
        if (objetosSinVikingo.isEmpty()) {
            System.out.println(ROJO + "\nNo hay objetos para subir.\n" + RESET);
            return;
        }
        
        System.out.print("Elige (1-" + objetosSinVikingo.size() + "): ");
        try {
            int opcion = Integer.parseInt(scanner.nextLine()) - 1;
            if (opcion >= 0 && opcion < objetosSinVikingo.size()) {
                Object objeto = objetosSinVikingo.get(opcion);
                listaActual.remove(objeto);
                bote.add(objeto);
                System.out.println("\nOK: " + getNombreObjeto(objeto) + " subio al bote.");
            } else {
                imprimirErrorOpcionNoValida();
            }
        } catch (NumberFormatException e) {
            imprimirErrorEntrada();
        }
    }
    
    private void bajarObjeto(Scanner scanner) {
        if (bote.size() <= 1) {
            System.out.println(ROJO + "\nERROR: Solo el Vikingo esta en el bote. No hay objetos para bajar." + RESET);
            return;
        }

        // El unico objeto en el bote que no es el vikingo
        Object objeto = null;
        for (Object o : bote) {
            if (o != vikingo) {
                objeto = o;
                break;
            }
        }

        if (objeto != null) {
            bote.remove(objeto);
            List<Object> listaActual;
            if (vikingoEnOrillaInicial) {
                listaActual = orillaInicial;
            } else {
                listaActual = orillaFinal;
            }
            listaActual.add(objeto);
            System.out.println("\nOK: " + getNombreObjeto(objeto) + " bajo del bote.\n");
        }
    }
    
    private void cruzarRio() {
        if (!bote.contains(vikingo)) {
            System.out.println("\nERROR: El Vikingo debe estar en el bote para cruzar.\n");
            return;
        }
        
        if (bote.size() < 2) {
            System.out.println("\nERROR: Debes subir al menos un objeto ademas del Vikingo.\n");
            return;
        }
        
        // Mover objetos del bote
        List<Object> destino;
        List<Object> origen;
        if (vikingoEnOrillaInicial) {
            destino = orillaFinal;
            origen = orillaInicial;
        } else {
            destino = orillaInicial;
            origen = orillaFinal;
        }
        
        for (Object obj : bote) {
            origen.remove(obj);
            destino.add(obj);
        }
        bote.clear();
        
        // Cambiar ubicacion del vikingo
    vikingoEnOrillaInicial = !vikingoEnOrillaInicial;
        
        System.out.println("\nOK: El Vikingo cruzo el rio!\n");
        
        // Verificar condiciones de perdida
        verificarCondicionesDerrota();
    }

    /**
     * Permite al vikingo cruzar solo (sin llevar ningun objeto).
     * Reglas:
     *  - No puede cruzar solo si en el bote hay otros objetos que no sean el vikingo.
     *  - Si el vikingo esta en la orilla actual se sube al bote y cruza.
     */
    private void cruzarSoloVikingo() {
        // Si el bote contiene algun objeto que no sea el vikingo, no permitir
        boolean hayOtroObjeto = false;
        for (Object o : bote) {
            if (o != vikingo) {
                hayOtroObjeto = true;
                break;
            }
        }
        if (hayOtroObjeto) {
            System.out.println("\nERROR: No puede cruzar solo mientras haya otros objetos en el bote.\n");
            return;
        }

        // Determinar lista de origen y destino según ubicación del vikingo
        List<Object> origen;
        List<Object> destino;
        if (vikingoEnOrillaInicial) {
            origen = orillaInicial;
            destino = orillaFinal;
        } else {
            origen = orillaFinal;
            destino = orillaInicial;
        }

        // Si el vikingo no esta en el bote, subirlo (si esta en la orilla actual)
        if (!bote.contains(vikingo)) {
            if (origen.contains(vikingo)) {
                origen.remove(vikingo);
                bote.add(vikingo);
                System.out.println("\nOK: Vikingo subio al bote.");
            } else {
                System.out.println("\nERROR: El Vikingo no esta en la orilla actual.\n");
                return;
            }
        }

        // Mover solo al vikingo
        bote.remove(vikingo);
        destino.add(vikingo);

        // Actualizar ubicacion
        if (vikingoEnOrillaInicial) {
            vikingoEnOrillaInicial = false;
        } else {
            vikingoEnOrillaInicial = true;
        }

        System.out.println("\nOK: Vikingo cruzo solo el rio.\n");

        // Verificar condiciones de perdida despues del movimiento
        verificarCondicionesDerrota();
    }
    
    private void verificarCondicionesDerrota() {
        List<Object> orillaInicialActual = orillaInicial;
        List<Object> orillaFinalActual = orillaFinal;

        // Verificar en orilla inicial
        String razon = verificarCondicionPeligrosa(orillaInicialActual);
        if (razon != null) {
            imprimirJuegoTerminado(razon);
            juegoPerdido = true;
            return;
        }

        // Verificar en orilla final
        razon = verificarCondicionPeligrosa(orillaFinalActual);
        if (razon != null) {
            imprimirJuegoTerminado(razon);
            juegoPerdido = true;
            return;
        }
    }
    
    private void imprimirJuegoTerminado(String razon) {
        System.out.println(ROJO + "\n¡GAME OVER! Condicion peligrosa en la orilla final.\n" + RESET);
        System.out.println("Razon: " + razon);
        System.out.println("El juego ha terminado. ¡Intenta de nuevo!");
    }

    /**
     * Verifica condiciones peligrosas en una orilla.
     * Retorna null si no hay problema, o una cadena con la razon de la perdida.
     */
    private String verificarCondicionPeligrosa(List<Object> orilla) {
        // Si en la orilla estan Lobo y Caperucita sin el Vikingo => Caperucita muere
        boolean hayLobo = false;
        boolean hayCaperucita = false;
        boolean hayUvas = false;
        boolean hayVikingo = false;

        for (Object obj : orilla) {
            if (obj == lobo) {
                hayLobo = true;
            }
            if (obj == caperucita) {
                hayCaperucita = true;
            }
            if (obj == uvas) {
                hayUvas = true;
            }
            if (obj == vikingo) {
                hayVikingo = true;
            }
        }

        // Lobo + Caperucita sin vikingo => perdida
        if (hayLobo && hayCaperucita && !hayVikingo) {
            return MORADO + "\nEl Lobo ataco a Caperucita (Caperucita murio).\n" + RESET;
        }

        // Caperucita + Uvas sin vikingo => uvas comidas
        if (hayCaperucita && hayUvas && !hayVikingo) {
            return MORADO + "\nCaperucita se comio las Uvas." + RESET;
        }

        return null;
    }
    
    private String getNombreObjeto(Object obj) {
        if (obj == vikingo) {
            return "Vikingo";
        } else if (obj == caperucita) {
            return "Caperucita";
        } else if (obj == lobo) {
            return "Lobo";
        } else if (obj == uvas) {
            return "Uvas";
        }
        return "Objeto desconocido";
    }
}
