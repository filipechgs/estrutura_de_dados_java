public class ArvoreAVL {

    private No raiz;

    public ArvoreAVL() {
        raiz = null;
    }

    // Inserção na AVL
    public void insereAVL(long id, Object elemento) {
        No novoNo = new No(id, elemento, null, null);
        insere(raiz, novoNo);
    }

    // Inserção ordenada
    private void insere(No atual, No novo) {
        if (atual == null) { 
            // Árvore vazia, insere na raiz
            this.raiz = novo;
            return;
        }
        
        if (novo.getId() < atual.getId()) { 
            // Vai inserir à esquerda
            if (atual.getEsq() == null) { 
                // Achou a posição, basta inserir
                atual.setEsq(novo);
                novo.setPai(atual);
                avaliaBalanceamento(atual);
            } else { 
                // Continua buscando recursivamente à esquerda
                insere(atual.getEsq(), novo);
            }
        } else if (novo.getId() > atual.getId()) { 
            // Vai inserir à direita
            if (atual.getDir() == null) { 
                // Achou a posição, basta inserir
                atual.setDir(novo);
                novo.setPai(atual);
                avaliaBalanceamento(atual);
            } else { 
                // Continua buscando recursivamente à direita
                insere(atual.getDir(), novo);
            }
        } else {
            // Achou o elemento igual, nada inserido
            return;
        }
    }

    // Avaliar o balanceamento da árvore AVL
    private void avaliaBalanceamento(No atual) {
        // Calcula o indicador B do nó atual
        calcBalanceamento(atual);
        long b = atual.getB();
        
        if (b == -2) { 
            // b=-2 indica que a subárvore esquerda ficou maior
            if (altura(atual.getEsq().getEsq()) >= altura(atual.getEsq().getDir())) {
                // Testa netos esq
                // Subárvore esquerda do neto é maior, rotação simples
                atual = rotacaoDir(atual);
            } else {
                // Rotação dupla
                atual = duplaRotacaoDir(atual);
            }
        } else if (b == 2) { 
            // b=2 indica que a subárvore direita ficou maior
            if (altura(atual.getDir().getDir()) >= altura(atual.getDir().getEsq())) {
                // Testa netos dir
                // Subárvore direita do neto é maior, rotação simples
                atual = rotacaoEsq(atual);
            } else {
                // Rotação dupla
                atual = duplaRotacaoEsq(atual);
            }
        }
        
        if (atual.getPai() != null) {
            // Sempre vai testar o balanceamento do pai
            avaliaBalanceamento(atual.getPai());
        } else {
            // Senão atual passa a ser a raiz
            this.raiz = atual;
        }
    }

    // Calcular o indicador B de um nó
    private void calcBalanceamento(No no) {
        no.setB(altura(no.getDir()) - altura(no.getEsq()));
    }

    // Calcula a altura da árvore
    private long altura(No atual) {
        if (atual == null) {
            // Se o nó está vazio sempre retorna -1
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

    // Realizar rotação à esquerda
    private No rotacaoEsq(No inicial) {
        // Salva apontamento do novo pai após rotação
        No dir = inicial.getDir();
        dir.setPai(inicial.getPai());
        
        // Neto esquerdo do filho direito passa a ser filho direito
        inicial.setDir(dir.getEsq());
        if (inicial.getDir() != null) {
            inicial.getDir().setPai(inicial);
        }
        
        // Filho esquerdo passa a ser pai
        dir.setEsq(inicial);
        inicial.setPai(dir);
        
        // Acerta os apontamentos do novo pai
        if (dir.getPai() != null) {
            if (dir.getPai().getDir() == inicial) {
                dir.getPai().setDir(dir);
            } else if (dir.getPai().getEsq() == inicial) {
                dir.getPai().setEsq(dir);
            }
        }
        
        // Calcula os novos indicadores de balanceamento
        calcBalanceamento(inicial);
        calcBalanceamento(dir);
        
        return dir;
    }

    // Realizar rotação à direita
    private No rotacaoDir(No inicial) {
        // Salva apontamento do novo pai após rotação
        No esq = inicial.getEsq();
        esq.setPai(inicial.getPai());
        
        // Neto direito do filho esquerdo passa a ser filho esquerdo
        inicial.setEsq(esq.getDir());
        if (inicial.getEsq() != null) {
            inicial.getEsq().setPai(inicial);
        }
        
        // Filho esquerdo passa a ser pai
        esq.setDir(inicial);
        inicial.setPai(esq);
        
        // Acerta os apontamentos do novo pai
        if (esq.getPai() != null) {
            if (esq.getPai().getDir() == inicial) {
                esq.getPai().setDir(esq);
            } else if (esq.getPai().getEsq() == inicial) {
                esq.getPai().setEsq(esq);
            }
        }
        
        // Calcula os novos indicadores de balanceamento
        calcBalanceamento(inicial);
        calcBalanceamento(esq);
        
        return esq;
    }

    // Realizar dupla rotação à direita
    private No duplaRotacaoDir(No inicial) {
        // Rotaciona o filho esquerdo para a esquerda
        inicial.setEsq(rotacaoEsq(inicial.getEsq()));
        // E depois rotaciona a árvore à direita
        return rotacaoDir(inicial);
    }

    // Realizar dupla rotação à esquerda
    private No duplaRotacaoEsq(No inicial) {
        // Rotaciona o filho direito para a direita
        inicial.setDir(rotacaoDir(inicial.getDir()));
        // E depois rotaciona a árvore à esquerda
        return rotacaoEsq(inicial);
    }
}