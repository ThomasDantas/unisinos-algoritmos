public class Cronometro {
    public static void main(String args[]) {
        int min = Teclado.leInt("Minutos: ");
        int segundos = 0;
        int minutos = 0;
        int total = min * 60;

        while (segundos <= total) {
            try {
                Thread.sleep(1000);
                segundos++;

                if (segundos == 60) {
                    minutos++;
                    segundos = 0;

                    if (minutos == min) {
                        System.out.println("00:" + minutos + ":" + segundos);
                        break;
                    }
                }
                System.out.println("00:" + minutos + ":" + segundos);
            } catch (Exception e) {
                System.out.println("O cronometro Falhou!");
            }
        }

    }

}