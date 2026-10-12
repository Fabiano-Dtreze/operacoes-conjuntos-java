// ============================================================
// IMPORTAÇÕES
// Em Java, é preciso importar explicitamente as classes que usamos.
// Em Python, "list" e "input" já vêm prontos.
// ============================================================
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// ============================================================
// CLASSE PRINCIPAL
// Em Java, TODO código precisa estar dentro de uma classe.
// O nome da classe deve ser igual ao nome do arquivo (Conjuntos.java).
// ============================================================
public class Conjuntos {

    // ==========================================================
    // FUNÇÃO AUXILIAR: pertence(x, A)
    // Substitui o operador "in" do Python.
    // 
    // DIFERENÇA CRÍTICA: em Java, comparar Strings com "=="
    // compara REFERÊNCIAS de memória, não CONTEÚDO.
    // Por isso usamos .equals().
    // ==========================================================
    static boolean pertence(String x, List<String> A) {
        for (String elemento : A) {
            if (elemento.equals(x)) {   // ⚠️ .equals() e não ==
                return true;
            }
        }
        return false;
    }

    // ==========================================================
    // UNIÃO: A ∪ B
    // Junta todos os elementos de A e B, sem repetição.
    // ==========================================================
    static List<String> uniao(List<String> A, List<String> B) {
        List<String> resultado = new ArrayList<>();
        for (String x : A) {
            if (!pertence(x, resultado)) {
                resultado.add(x);
            }
        }
        for (String x : B) {
            if (!pertence(x, resultado)) {
                resultado.add(x);
            }
        }
        return resultado;
    }

    // ==========================================================
    // INTERSEÇÃO: A ∩ B
    // Elementos que estão em A E em B.
    // ==========================================================
    static List<String> interseccao(List<String> A, List<String> B) {
        List<String> resultado = new ArrayList<>();
        for (String x : A) {
            if (pertence(x, B) && !pertence(x, resultado)) {
                resultado.add(x);
            }
        }
        return resultado;
    }

    // ==========================================================
    // DIFERENÇA: A - B
    // Elementos de A que NÃO estão em B.
    // ==========================================================
    static List<String> diferenca(List<String> A, List<String> B) {
        List<String> resultado = new ArrayList<>();
        for (String x : A) {
            if (!pertence(x, B) && !pertence(x, resultado)) {
                resultado.add(x);
            }
        }
        return resultado;
    }

    // ==========================================================
    // DIFERENÇA SIMÉTRICA: A △ B
    // (A - B) ∪ (B - A)
    // ==========================================================
    static List<String> diferencaSimetrica(List<String> A, List<String> B) {
        List<String> ab = diferenca(A, B);
        List<String> ba = diferenca(B, A);
        return uniao(ab, ba);
    }

    // ==========================================================
    // A CONTÉM B?
    // Todo elemento de B está em A?
    // ==========================================================
    static boolean contem(List<String> A, List<String> B) {
        for (String x : B) {
            if (!pertence(x, A)) {
                return false;
            }
        }
        return true;
    }

    // ==========================================================
    // A ESTÁ CONTIDO EM B?
    // ==========================================================
    static boolean estaContido(List<String> A, List<String> B) {
        return contem(B, A);
    }

    // ==========================================================
    // CARDINALIDADE
    // Conta elementos únicos, sem usar Set do Java.
    // ==========================================================
    static int cardinalidade(List<String> A) {
        int contador = 0;
        List<String> vistos = new ArrayList<>();
        for (String x : A) {
            if (!pertence(x, vistos)) {
                vistos.add(x);
                contador++;
            }
        }
        return contador;
    }

    // ==========================================================
    // COMPLEMENTO DE A EM U
    // U - A
    // ==========================================================
    static List<String> complemento(List<String> A, List<String> U) {
        return diferenca(U, A);
    }

    // ==========================================================
    // LER CONJUNTO DO USUÁRIO
    // Em Python: entrada.split()
    // Em Java: precisamos do Scanner
    // ==========================================================
    static List<String> lerConjunto(Scanner scanner, String nome) {
        System.out.print("Digite os elementos de " + nome 
                         + " separados por espaço (Enter para vazio): ");
        String entrada = scanner.nextLine().trim();
        
        if (entrada.isEmpty()) {
            return new ArrayList<>();   // conjunto vazio
        }
        
        // split retorna String[]; convertemos para List
        String[] partes = entrada.split("\\s+");   // \\s+ = um ou mais espaços
        return new ArrayList<>(Arrays.asList(partes));
    }

    // ==========================================================
    // MOSTRAR RESULTADO (manual vs nativo)
    // Compara duas listas ignorando ordem.
    // ==========================================================
    static void mostrarResultado(String titulo, 
                                  List<String> manual, 
                                  List<String> nativo) {
        System.out.println("\n--- " + titulo + " ---");
        System.out.println("  Implementação manual: " + manual);
        System.out.println("  Solução nativa:       " + nativo);
        
        // Comparação: mesma cardinalidade e todos os elementos presentes
        boolean iguais = manual.size() == nativo.size()
                      && contem(manual, nativo) 
                      && contem(nativo, manual);
        
        System.out.println("  Iguais? " + (iguais ? "✅ SIM" : "❌ NÃO"));
    }

    // ==========================================================
    // MÉTODO MAIN — ponto de entrada do programa
    // Em Python, o código simplesmente roda.
    // Em Java, TUDO começa por aqui.
    // ==========================================================
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ler os dois conjuntos
        List<String> A = lerConjunto(scanner, "A");
        List<String> B = lerConjunto(scanner, "B");

        while (true) {
            System.out.println("\n================ MENU ================");
            System.out.println("1 - União (A ∪ B)");
            System.out.println("2 - Interseção (A ∩ B)");
            System.out.println("3 - Diferença (A - B)");
            System.out.println("4 - Diferença (B - A)");
            System.out.println("5 - Diferença Simétrica (A △ B)");
            System.out.println("6 - Pertinência (x ∈ A?)");
            System.out.println("7 - Inclusão (A contém B? / A ⊂ B?)");
            System.out.println("8 - Cardinalidade de A e B");
            System.out.println("9 - Complemento de A em relação a U");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1":
                    mostrarResultado("União", 
                        uniao(A, B), 
                        uniaoNativo(A, B));
                    break;

                case "2":
                    mostrarResultado("Interseção", 
                        interseccao(A, B), 
                        interseccaoNativo(A, B));
                    break;

                case "3":
                    mostrarResultado("A - B", 
                        diferenca(A, B), 
                        diferencaNativo(A, B));
                    break;

                case "4":
                    mostrarResultado("B - A", 
                        diferenca(B, A), 
                        diferencaNativo(B, A));
                    break;

                case "5":
                    mostrarResultado("Diferença Simétrica", 
                        diferencaSimetrica(A, B), 
                        diferencaSimetricaNativo(A, B));
                    break;

                case "6":
                    System.out.print("Elemento a verificar: ");
                    String x = scanner.nextLine().trim();
                    boolean manual = pertence(x, A);
                    boolean nativo = A.contains(x);
                    System.out.println("  Manual: " + manual 
                                     + " | Nativo: " + nativo
                                     + " | " + (manual == nativo ? "✅" : "❌"));
                    break;

                case "7":
                    boolean m1 = contem(A, B);
                    boolean n1 = A.containsAll(B);
                    boolean m2 = estaContido(A, B);
                    boolean n2 = B.containsAll(A);
                    System.out.println("  A contém B?  Manual: " + m1 
                                     + " | Nativo: " + n1
                                     + " | " + (m1 == n1 ? "✅" : "❌"));
                    System.out.println("  A ⊂ B?       Manual: " + m2 
                                     + " | Nativo: " + n2
                                     + " | " + (m2 == n2 ? "✅" : "❌"));
                    break;

                case "8":
                    int cm = cardinalidade(A);
                    int cn = (int) A.stream().distinct().count();
                    int dm = cardinalidade(B);
                    int dn = (int) B.stream().distinct().count();
                    System.out.println("  |A| Manual: " + cm + " | Nativo: " + cn
                                     + " | " + (cm == cn ? "✅" : "❌"));
                    System.out.println("  |B| Manual: " + dm + " | Nativo: " + dn
                                     + " | " + (dm == dn ? "✅" : "❌"));
                    break;

                case "9":
                    List<String> U = lerConjunto(scanner, "Universo U");
                    mostrarResultado("Complemento de A em U", 
                        complemento(A, U), 
                        diferencaNativo(U, A));
                    break;

                case "0":
                    System.out.println("Encerrando...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    // ==========================================================
    // SOLUÇÕES NATIVAS (usando recursos prontos do Java)
    // Servem para VALIDAR nossa implementação manual.
    // ==========================================================

    static List<String> uniaoNativo(List<String> A, List<String> B) {
        List<String> resultado = new ArrayList<>(A);
        for (String x : B) {
            if (!resultado.contains(x)) {
                resultado.add(x);
            }
        }
        return resultado;
    }

    static List<String> interseccaoNativo(List<String> A, List<String> B) {
        List<String> resultado = new ArrayList<>();
        for (String x : A) {
            if (B.contains(x) && !resultado.contains(x)) {
                resultado.add(x);
            }
        }
        return resultado;
    }

    static List<String> diferencaNativo(List<String> A, List<String> B) {
        List<String> resultado = new ArrayList<>();
        for (String x : A) {
            if (!B.contains(x) && !resultado.contains(x)) {
                resultado.add(x);
            }
        }
        return resultado;
    }

    static List<String> diferencaSimetricaNativo(List<String> A, List<String> B) {
        List<String> ab = diferencaNativo(A, B);
        List<String> ba = diferencaNativo(B, A);
        return uniaoNativo(ab, ba);
    }
}