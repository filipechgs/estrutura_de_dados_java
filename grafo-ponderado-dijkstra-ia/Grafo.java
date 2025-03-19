class Grafo {
    // Constantes
    private final int MAX_VERTICES = 20;      // Número máximo de vértices suportados
    private final int INFINITO = Integer.MAX_VALUE;  // Representa distância infinita
    private final int MIN_CELL_WIDTH = 30;    // Largura mínima para células da tabela

    // Estruturas principais do grafo
    private Vertice listaVertice[];           // Array para armazenar os vértices
    private int matriz[][];                   // Matriz de adjacência (pesos das arestas)
    private int numVertices;                  // Contador de vértices atual
    
    // Estruturas para o algoritmo de Dijkstra
    private DistanciaEstimada menor[];        // Array para armazenar menor distância conhecida para cada vértice
    private int numFechados;                  // Contador de vértices processados
    private int verticeAtual;                 // Vértice sendo processado atualmente
    private int distParaAtual;                // Distância do vértice inicial até o vértice atual
    
    /**
     * Construtor - Inicializa o grafo vazio
     */
    public Grafo() {
        // Inicializar arrays e matriz
        listaVertice = new Vertice[MAX_VERTICES];
        matriz = new int[MAX_VERTICES][MAX_VERTICES];
        menor = new DistanciaEstimada[MAX_VERTICES];
        
        // Inicializar cada vértice e distância estimada
        for (int i = 0; i < MAX_VERTICES; i++) {
            listaVertice[i] = new Vertice();
            menor[i] = new DistanciaEstimada();
        }
        
        // Inicializar todas as arestas com distância infinita
        for (int y = 0; y < MAX_VERTICES; y++) {
            for (int x = 0; x < MAX_VERTICES; x++) {
                matriz[x][y] = INFINITO;
            }
        }
        
        // Inicializar contadores
        numVertices = 0;
        numFechados = 0;
    }
    
    /**
     * Adiciona um novo vértice ao grafo
     * @param rotulo Nome/identificador do vértice
     */
    public void adicionaVertice(String rotulo) {
        if (numVertices < MAX_VERTICES) {
            listaVertice[numVertices].setRotulo(rotulo);
            numVertices++;
        } else {
            System.out.println("Erro: grafo cheio!");
        }
    }
    
    /**
     * Adiciona uma aresta direcionada com peso entre dois vértices
     * @param inicio Índice do vértice de origem
     * @param fim Índice do vértice de destino
     * @param peso Peso/distância da aresta
     */
    public void adicionaAresta(int inicio, int fim, int peso) {
        if (peso < 0) {
            // System.out.println("Erro: Arestas com peso negativo não são permitidas.");
            return;
        }
        if (inicio == fim) {
            // System.out.println("Erro: Loop detectado! Não é possível adicionar arestas que ligam um vértice a si mesmo.");
            return;
        }
        matriz[inicio][fim] = peso;
    }
    
    /**
     * Exibe o rótulo de um vértice específico
     * @param v Índice do vértice
     */
    public void mostraVertice(int v) {
        System.out.print(listaVertice[v].getRotulo());
    }
    
    /**
     * Busca um vértice pelo seu rótulo
     * @param rotulo Rótulo do vértice a ser encontrado
     * @return Índice do vértice ou -1 se não encontrado
     */
    public int encontraVertice(String rotulo) {
        for (int i = 0; i < numVertices; i++) {
            if (listaVertice[i].getRotulo().equals(rotulo)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Encontra o vértice não visitado com a menor distância estimada
     * Parte essencial do algoritmo de Dijkstra
     * @return Índice do vértice com menor distância
     */
    private int pegaMinimo() {
        int minimo = INFINITO;
        int indice = -1; // Valor inicial para indicar que nenhum vértice foi encontrado
        
        // Busca em todos os vértices
        for (int j = 0; j < numVertices; j++) {
            // Seleciona apenas vértices não visitados com distância menor que a mínima atual
            if (!listaVertice[j].getVisitado() && menor[j].getDistancia() < minimo) {
                minimo = menor[j].getDistancia();
                indice = j;
            }
        }
        return indice;
    }
    
    /**
     * Atualiza as distâncias estimadas para vértices adjacentes ao vértice atual
     * Implementa a operação de relaxamento de arestas do algoritmo de Dijkstra
     */
    private void ajustaMenor() {
        int coluna = 0;
        
        // Para cada vértice do grafo
        while (coluna < numVertices) {
            // Ignora vértices já visitados
            if (listaVertice[coluna].getVisitado()) {
                coluna++;
                continue;
            }
            
            // Verifica se há aresta entre o vértice atual e este vértice
            int atualParaMargem = matriz[verticeAtual][coluna];
            
            // Calcula nova distância possível
            int inicioParaMargem = distParaAtual + atualParaMargem;
            int menorDistancia = menor[coluna].getDistancia();
            
            // Se a nova distância for menor que a conhecida, atualiza
            if (inicioParaMargem < menorDistancia) {
                menor[coluna].setPaiVertice(verticeAtual);  // Atualiza o pai para reconstruir o caminho
                menor[coluna].setDistancia(inicioParaMargem);  // Atualiza a menor distância
            }
            coluna++;
        }
    }
    
    /**
     * Exibe o estado atual das distâncias mínimas encontradas
     * Útil para visualizar o progresso do algoritmo
     */
    private void mostraMenor() {
        StringBuilder divisor = new StringBuilder("+");
        divisor.append("-".repeat(MIN_CELL_WIDTH)).append("+");
        divisor.append("-".repeat(MIN_CELL_WIDTH)).append("+");
        divisor.append("-".repeat(MIN_CELL_WIDTH)).append("+");
        
        System.out.println(divisor.toString());
        
        System.out.printf("| %-" + (MIN_CELL_WIDTH - 2) + "s | %-" + (MIN_CELL_WIDTH - 2) + "s | %-" + (MIN_CELL_WIDTH - 2) + "s |\n", 
                         "Vértice", "Distância", "Pai");
        
        System.out.println(divisor.toString());
        
        for (int j = 0; j < numVertices; j++) {
            String distStr;
            if (menor[j].getDistancia() == INFINITO) {
                distStr = "∞";
            } else {
                distStr = String.valueOf(menor[j].getDistancia());
            }
            
            String paiStr = listaVertice[menor[j].getPaiVertice()].getRotulo();
            System.out.printf("| %-" + (MIN_CELL_WIDTH - 2) + "s | %-" + (MIN_CELL_WIDTH - 2) + "s | %-" + (MIN_CELL_WIDTH - 2) + "s |\n", 
                             listaVertice[j].getRotulo(), 
                             distStr, 
                             paiStr);
        }
        
        System.out.println(divisor.toString());
    }
    
    /**
     * Implementação do algoritmo de Dijkstra para encontrar todos os caminhos
     * mais curtos a partir de um vértice inicial
     * @param inicioVertice Índice do vértice de origem
     */
    public void caminhoMaisCurto(int inicioVertice) {
        // Inicializa estruturas para o algoritmo
        for (int i = 0; i < numVertices; i++) {
            listaVertice[i].setVisitado(false);  // Nenhum vértice visitado inicialmente
            menor[i].setDistancia(INFINITO);     // Todas distâncias iniciam como infinito
            menor[i].setPaiVertice(0);           // Pai inicial é 0 (será corrigido)
        }
        
        // Marca o vértice inicial como visitado
        listaVertice[inicioVertice].setVisitado(true);
        numFechados = 1;  // Um vértice fechado (visitado)
        
        // Inicializa as distâncias diretas do vértice inicial para seus vizinhos
        for (int j = 0; j < numVertices; j++) {
            int tempDist = matriz[inicioVertice][j];
            menor[j].setDistancia(tempDist);
            menor[j].setPaiVertice(inicioVertice);
        }
        
        // A distância do vértice inicial para ele mesmo é 0
        menor[inicioVertice].setDistancia(0);
        
        // Mostra o estado inicial das distâncias
        System.out.println("\n=== Inicialização ===");
        mostraMenor();
        
        // Inicia o processo principal do algoritmo de Dijkstra
        while (numFechados < numVertices) {
            // Encontra o próximo vértice não visitado com menor distância
            int indexMin = pegaMinimo();
            if (indexMin == -1) {
                // Não há mais vértices acessíveis
                break;
            }
            
            // Marca o vértice encontrado como atual e visitado
            verticeAtual = indexMin;
            distParaAtual = menor[verticeAtual].getDistancia();
            listaVertice[verticeAtual].setVisitado(true);
            numFechados++;
            
            // Atualiza as distâncias para os vértices adjacentes ao vértice atual
            ajustaMenor();
            
            // Mostra o estado atual das distâncias após esta iteração
            System.out.println("\n=== Iteração " + numFechados + " ===");
            System.out.println("Vértice atual: " + listaVertice[verticeAtual].getRotulo());
            mostraMenor();
        }
        
        // Exibe os caminhos mais curtos encontrados
        System.out.println("\n=== Caminhos mais curtos ===");
        for (int i = 0; i < numVertices; i++) {
            if (i != inicioVertice) {
                mostrarCaminho(inicioVertice, i);
            }
        }
    }
    
    /**
     * Exibe o caminho mais curto entre dois vértices
     * @param inicio Índice do vértice de origem
     * @param fim Índice do vértice de destino
     */
    public void mostrarCaminho(int inicio, int fim) {
        // Verifica se existe caminho
        if (menor[fim].getDistancia() == INFINITO) {
            System.out.printf("[ %-6s → %-6s ] Não há caminho disponível\n",
                             listaVertice[inicio].getRotulo(), 
                             listaVertice[fim].getRotulo());
            return;
        }
        
        // Array para armazenar o caminho (de trás para frente)
        int[] caminho = new int[numVertices];
        int contagem = 0;
        int atual = fim;
        
        // Reconstrói o caminho usando os "pais" de cada vértice
        while (atual != inicio) {
            caminho[contagem++] = atual;
            atual = menor[atual].getPaiVertice();
        }
        caminho[contagem] = inicio;
        
        // Exibe o caminho na ordem correta (do início ao fim)
        System.out.printf("[ %-6s → %-6s ] Distância: %-4d | Caminho: ",
                         listaVertice[inicio].getRotulo(), 
                         listaVertice[fim].getRotulo(),
                         menor[fim].getDistancia());
                         
        for (int i = contagem; i >= 0; i--) {
            System.out.print(listaVertice[caminho[i]].getRotulo());
            if (i > 0) {
                System.out.print(" → ");
            }
        }
        System.out.println();
    }
    
    /**
     * Reinicia o estado de todos os vértices para não visitados
     */
    public void limpaFlags() {
        for (int i = 0; i < numVertices; i++) {
            listaVertice[i].setVisitado(false);
        }
    }
    
    /**
     * Exibe a matriz de adjacência do grafo
     * Útil para visualizar a estrutura completa do grafo
     */
    public void mostraMatriz() {
        System.out.println("\n=== Matriz de adjacência ===");
        
        // Determinar tamanho fixo para cada coluna (garantindo mínimo de 30 caracteres)
        int[] larguraColunas = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            // Usa a largura mínima estabelecida
            larguraColunas[i] = MIN_CELL_WIDTH;
        }
        
        // Largura fixa para coluna de rótulos de linha
        int colunaRotuloLargura = MIN_CELL_WIDTH;
        
        // Imprime cabeçalho da tabela
        System.out.print("+");
        for (int j = 0; j < colunaRotuloLargura; j++) {
            System.out.print("-");
        }
        System.out.print("+");
        
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < larguraColunas[i]; j++) {
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
        
        // Cabeçalho com rótulos dos vértices
        System.out.print("| Vértice");
        for (int j = 0; j < colunaRotuloLargura - 8; j++) { // 8 é o tamanho de "Vértice"
            System.out.print(" ");
        }
        System.out.print("|");
        
        for (int i = 0; i < numVertices; i++) {
            String rotulo = listaVertice[i].getRotulo();
            int espacosAntes = (larguraColunas[i] - rotulo.length()) / 2;
            int espacosDepois = larguraColunas[i] - rotulo.length() - espacosAntes;
            
            for (int j = 0; j < espacosAntes; j++) {
                System.out.print(" ");
            }
            System.out.print(rotulo);
            for (int j = 0; j < espacosDepois; j++) {
                System.out.print(" ");
            }
            System.out.print("|");
        }
        System.out.println();
        
        // Separador
        System.out.print("+");
        for (int j = 0; j < colunaRotuloLargura; j++) {
            System.out.print("-");
        }
        System.out.print("+");
        
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < larguraColunas[i]; j++) {
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
        
        // Conteúdo da matriz (pesos das arestas)
        for (int i = 0; i < numVertices; i++) {
            System.out.print("| " + listaVertice[i].getRotulo());
            for (int j = 0; j < colunaRotuloLargura - listaVertice[i].getRotulo().length() - 2; j++) {
                System.out.print(" ");
            }
            System.out.print("|");
            
            for (int j = 0; j < numVertices; j++) {
                String valor;
                if (matriz[i][j] == INFINITO) {
                    valor = "∞";
                } else {
                    valor = String.valueOf(matriz[i][j]);
                }
                
                int espacosAntes = (larguraColunas[j] - valor.length()) / 2;
                int espacosDepois = larguraColunas[j] - valor.length() - espacosAntes;
                
                for (int k = 0; k < espacosAntes; k++) {
                    System.out.print(" ");
                }
                System.out.print(valor);
                for (int k = 0; k < espacosDepois; k++) {
                    System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
        
        // Linha final da tabela
        System.out.print("+");
        for (int j = 0; j < colunaRotuloLargura; j++) {
            System.out.print("-");
        }
        System.out.print("+");
        
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < larguraColunas[i]; j++) {
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
    }
}