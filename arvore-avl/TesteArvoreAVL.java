public class TesteArvoreAVL {
    
    public static void main(String[] args) {
        System.out.println("===== TESTE DA ÁRVORE AVL =====");
        
        // Teste de criação e inserção básica
        testeInsercaoBasica();
        
        // Teste de rotação simples à direita
        testeRotacaoDireita();
        
        // Teste de rotação simples à esquerda
        testeRotacaoEsquerda();
        
        // Teste de rotação dupla à direita
        testeDuplaRotacaoDireita();
        
        // Teste de rotação dupla à esquerda
        testeDuplaRotacaoEsquerda();
        
        // Teste complexo com várias inserções e rotações
        testeInsercaoCompleta();
    }
    
    // Método para imprimir uma árvore em pré-ordem com indentação
    private static void imprimirArvore(No no, String prefixo) {
        if (no != null) {
            System.out.println(prefixo + no + " (B:" + no.getB() + ")");
            imprimirArvore(no.getEsq(), prefixo + "  |-- ");
            imprimirArvore(no.getDir(), prefixo + "  |-- ");
        }
    }
    
    // Método para verificar se o balanceamento está correto para todos os nós
    private static boolean verificarBalanceamento(No no) {
        if (no == null) {
            return true;
        }
        
        long alturaEsq = altura(no.getEsq());
        long alturaDir = altura(no.getDir());
        long balanceamento = alturaDir - alturaEsq;
        
        // Verificar se o balanceamento calculado corresponde ao armazenado no nó
        if (balanceamento != no.getB()) {
            System.out.println("ERRO: Nó " + no + " tem balanceamento calculado " + 
                               balanceamento + " mas armazenado " + no.getB());
            return false;
        }
        
        // Verificar se o balanceamento está dentro dos limites permitidos (-1, 0, 1)
        if (balanceamento < -1 || balanceamento > 1) {
            System.out.println("ERRO: Nó " + no + " tem balanceamento inválido: " + balanceamento);
            return false;
        }
        
        // Verificar recursivamente os filhos
        return verificarBalanceamento(no.getEsq()) && verificarBalanceamento(no.getDir());
    }
    
    // Método auxiliar para calcular a altura de um nó (similar ao da classe ArvoreAVL)
    private static long altura(No atual) {
        if (atual == null) {
            return -1;
        }
        
        if ((atual.getEsq() == null) && (atual.getDir() == null)) {
            return 0;
        } else if (atual.getEsq() == null) {
            return 1 + altura(atual.getDir());
        } else if (atual.getDir() == null) {
            return 1 + altura(atual.getEsq());
        } else {
            return 1 + Math.max(altura(atual.getEsq()), altura(atual.getDir()));
        }
    }
    
    // Teste 1: Inserção básica sem necessidade de rotações
    private static void testeInsercaoBasica() {
        System.out.println("\n----- Teste de Inserção Básica -----");
        
        ArvoreAVL arvore = new ArvoreAVL();
        
        // Inserindo elementos que não requerem rotações
        arvore.insereAVL(50, "Raiz");
        arvore.insereAVL(30, "Filho Esquerdo");
        arvore.insereAVL(70, "Filho Direito");
        
        System.out.println("Árvore após inserção básica:");
        No raiz = getNo(arvore);
        imprimirArvore(raiz, "");
        
        // Verificar balanceamento
        boolean balanceado = verificarBalanceamento(raiz);
        System.out.println("Árvore está balanceada? " + balanceado);
    }
    
    // Teste 2: Rotação simples à direita
    private static void testeRotacaoDireita() {
        System.out.println("\n----- Teste de Rotação Simples à Direita -----");
        
        ArvoreAVL arvore = new ArvoreAVL();
        
        // Criando um caso que força uma rotação à direita
        arvore.insereAVL(50, "Raiz");
        arvore.insereAVL(30, "Nível 1 Esquerda");
        arvore.insereAVL(20, "Nível 2 Esquerda"); // Deve causar rotação à direita
        
        System.out.println("Árvore após rotação simples à direita:");
        No raiz = getNo(arvore);
        imprimirArvore(raiz, "");
        
        // Verificar balanceamento
        boolean balanceado = verificarBalanceamento(raiz);
        System.out.println("Árvore está balanceada? " + balanceado);
        
        // Verificar se a rotação ocorreu (agora 30 deve ser a raiz)
        System.out.println("Nova raiz: " + raiz);
        System.out.println("Rotação à direita funcionou corretamente? " + (raiz.getId() == 30));
    }
    
    // Teste 3: Rotação simples à esquerda
    private static void testeRotacaoEsquerda() {
        System.out.println("\n----- Teste de Rotação Simples à Esquerda -----");
        
        ArvoreAVL arvore = new ArvoreAVL();
        
        // Criando um caso que força uma rotação à esquerda
        arvore.insereAVL(50, "Raiz");
        arvore.insereAVL(70, "Nível 1 Direita");
        arvore.insereAVL(80, "Nível 2 Direita"); // Deve causar rotação à esquerda
        
        System.out.println("Árvore após rotação simples à esquerda:");
        No raiz = getNo(arvore);
        imprimirArvore(raiz, "");
        
        // Verificar balanceamento
        boolean balanceado = verificarBalanceamento(raiz);
        System.out.println("Árvore está balanceada? " + balanceado);
        
        // Verificar se a rotação ocorreu (agora 70 deve ser a raiz)
        System.out.println("Nova raiz: " + raiz);
        System.out.println("Rotação à esquerda funcionou corretamente? " + (raiz.getId() == 70));
    }
    
    // Teste 4: Rotação dupla à direita (esquerda-direita)
    private static void testeDuplaRotacaoDireita() {
        System.out.println("\n----- Teste de Rotação Dupla à Direita -----");
        
        ArvoreAVL arvore = new ArvoreAVL();
        
        // Criando um caso que força uma dupla rotação à direita
        arvore.insereAVL(50, "Raiz");
        arvore.insereAVL(20, "Nível 1 Esquerda");
        arvore.insereAVL(30, "Nível 2 Direita do Esquerdo"); // Deve causar dupla rotação
        
        System.out.println("Árvore após dupla rotação à direita:");
        No raiz = getNo(arvore);
        imprimirArvore(raiz, "");
        
        // Verificar balanceamento
        boolean balanceado = verificarBalanceamento(raiz);
        System.out.println("Árvore está balanceada? " + balanceado);
        
        // Verificar se a rotação ocorreu (agora 30 deve ser a raiz)
        System.out.println("Nova raiz: " + raiz);
        System.out.println("Dupla rotação à direita funcionou corretamente? " + (raiz.getId() == 30));
    }
    
    // Teste 5: Rotação dupla à esquerda (direita-esquerda)
    private static void testeDuplaRotacaoEsquerda() {
        System.out.println("\n----- Teste de Rotação Dupla à Esquerda -----");
        
        ArvoreAVL arvore = new ArvoreAVL();
        
        // Criando um caso que força uma dupla rotação à esquerda
        arvore.insereAVL(50, "Raiz");
        arvore.insereAVL(80, "Nível 1 Direita");
        arvore.insereAVL(70, "Nível 2 Esquerda do Direito"); // Deve causar dupla rotação
        
        System.out.println("Árvore após dupla rotação à esquerda:");
        No raiz = getNo(arvore);
        imprimirArvore(raiz, "");
        
        // Verificar balanceamento
        boolean balanceado = verificarBalanceamento(raiz);
        System.out.println("Árvore está balanceada? " + balanceado);
        
        // Verificar se a rotação ocorreu (agora 70 deve ser a raiz)
        System.out.println("Nova raiz: " + raiz);
        System.out.println("Dupla rotação à esquerda funcionou corretamente? " + (raiz.getId() == 70));
    }
    
    // Teste 6: Inserção completa com vários elementos
    private static void testeInsercaoCompleta() {
        System.out.println("\n----- Teste de Inserção Completa -----");
        
        ArvoreAVL arvore = new ArvoreAVL();
        
        // Inserindo uma sequência maior de elementos
        int[] valores = {50, 25, 75, 12, 37, 62, 87, 6, 18, 31, 43, 56, 68, 81, 93};
        
        for (int valor : valores) {
            System.out.println("Inserindo: " + valor);
            arvore.insereAVL(valor, "Elemento " + valor);
        }
        
        System.out.println("Árvore final após todas as inserções:");
        No raiz = getNo(arvore);
        imprimirArvore(raiz, "");
        
        // Verificar balanceamento final
        boolean balanceado = verificarBalanceamento(raiz);
        System.out.println("Árvore final está balanceada? " + balanceado);
        
        // Verificar altura da árvore
        long alturaArvore = altura(raiz);
        System.out.println("Altura da árvore final: " + alturaArvore);
        
        // Para uma árvore AVL, a altura máxima deveria ser aproximadamente 1.44 * log2(n)
        double alturaMaximaEsperada = 1.44 * (Math.log(valores.length) / Math.log(2));
        System.out.println("Altura máxima esperada para " + valores.length + 
                          " elementos: ~" + String.format("%.2f", alturaMaximaEsperada));
        System.out.println("A altura da árvore está dentro do esperado? " + 
                          (alturaArvore <= Math.ceil(alturaMaximaEsperada)));
    }
    
    // Método auxiliar para obter o nó raiz da árvore
    // Note: Como o atributo raiz na classe ArvoreAVL é privado e não há um método para
    // acessá-lo diretamente, usamos Java Reflection para fins de teste.
    private static No getNo(ArvoreAVL arvore) {
        try {
            java.lang.reflect.Field raizField = ArvoreAVL.class.getDeclaredField("raiz");
            raizField.setAccessible(true);
            return (No) raizField.get(arvore);
        } catch (Exception e) {
            System.err.println("Erro ao acessar o nó raiz: " + e.getMessage());
            return null;
        }
    }
}
