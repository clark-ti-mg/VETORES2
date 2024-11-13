import java.util.Random;

public class App {

    public static void imprimeVetor(Integer[] v) {
        System.out.print("[");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i]);
            if (i != v.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static Integer[] vetorAleatorio(Integer v[]) throws Exception {
        Integer numeroSorteado, posicaoAnterior = 0, uPos = -1;

        for (int i = 0; i < v.length; i++) {
            numeroSorteado = new Random().nextInt(3) + 1;

            switch (numeroSorteado) {
                case 1:

                    if (uPos == v.length - 1) {
                        throw new Exception("Sem posições disponíveis. Vetor totalmente ocupado.");
                    }

                    for (int j = uPos + 1; j > 0; --j) {
                        v[j] = v[j - 1];
                    }
                    v[0] = numeroSorteado;

                    // System.out.println("Número 1 inserido na " + 0 + "ª posição. ");

                    ++uPos;
                    posicaoAnterior = 0;

                    break;

                case 2:
                    if (uPos == v.length - 1) {
                        throw new Exception("Sem posições disponíveis. Vetor totalmente ocupado.");
                    }

                    v[++uPos] = numeroSorteado;

                    // System.out.println("Número 2 inserido na " + uPos + "ª posição.");

                    posicaoAnterior = uPos;
                    break;

                case 3:
                    if (uPos == v.length - 1) {
                        throw new Exception("Sem posições disponíveis. Vetor totalmente ocupado.");
                    }

                    if (posicaoAnterior != uPos) {
                        for (int j = uPos + 1; j > posicaoAnterior; --j) {
                            v[j] = v[j - 1];
                        }
                        v[posicaoAnterior] = numeroSorteado;

                        // System.out.println("Número 3 inserido na " + posicaoAnterior + "ª posição.");

                        ++uPos;
                    } else {
                        v[uPos + 1] = v[uPos];
                        v[uPos] = numeroSorteado;

                        // System.out.println("Número 3 inserido na " + uPos + "ª posição. ");

                        posicaoAnterior = uPos;
                        ++uPos;
                    }

                    break;
            }
        }

        return v;
    }

    public static void main(String[] args) {
        Integer[] v = new Integer[10];

        try {

            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Vetor aleatorizado com as seguintes regras: ");
            System.out.println("\nSe opção for 1, o número deverá ser inserido no início do " + //
                    "vetor. \nSe opção for 2, o número deverá ser inserido na primeira " + //
                    "posição livre (última posição). \nSe opção for 3, o número deverá " + //
                    "ser inserido imediatamente antes do valor inserido na iteração anterior.\n");
            imprimeVetor(vetorAleatorio(v));
        } catch (Exception e) {
            System.out.println("Exceção ao preencher o vetor com números aleatórios: " + e.getMessage());
        }
    }
}
