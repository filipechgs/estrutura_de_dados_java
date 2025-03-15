# Visualização de Árvore AVL

## Introdução

Este documento explica o formato de visualização de árvores AVL utilizado no programa de teste `TesteArvoreAVL.java`. A visualização baseada em texto permite examinar a estrutura da árvore, relacionamentos entre nós e fatores de balanceamento de forma clara e intuitiva.

## Formato de Visualização

### Exemplo de Saída

```
50 (B:0)
  |-- 25 (B:0)
  |--   |-- 12 (B:0)
  |--   |--   |-- 6 (B:0)
  |--   |--   |-- 18 (B:0)
  |--   |-- 37 (B:0)
  |--   |--   |-- 31 (B:0)
  |--   |--   |-- 43 (B:0)
  |-- 75 (B:0)
  |--   |-- 62 (B:0)
  |--   |--   |-- 56 (B:0)
  |--   |--   |-- 68 (B:0)
  |--   |-- 87 (B:0)
  |--   |--   |-- 81 (B:0)
  |--   |--   |-- 93 (B:0)
```

### Elementos da Visualização

1. **Nós**: Cada linha representa um nó da árvore
   - O valor do nó é mostrado primeiro (ex: `50`)
   - O fator de balanceamento é mostrado em seguida entre parênteses (ex: `(B:0)`)

2. **Relações Hierárquicas**: 
   - A indentação e o padrão `|--` indicam relações pai-filho
   - A profundidade na árvore é representada pelo nível de indentação
   - Cada `|--` representa um ramo da árvore

3. **Interpretação dos Níveis**:
   - O nó menos indentado é a raiz da árvore
   - Cada nível de indentação representa um nível adicional na árvore
   - Nós que compartilham o mesmo padrão de indentação estão no mesmo nível

## Como Interpretar o Fator de Balanceamento

O fator de balanceamento (B) para cada nó é calculado como:
* B = altura(subárvore direita) - altura(subárvore esquerda)

Em uma árvore AVL válida:
* B deve estar entre -1 e 1 para todos os nós
* B = -1: A subárvore esquerda é uma unidade mais alta
* B = 0: As subárvores têm a mesma altura
* B = 1: A subárvore direita é uma unidade mais alta

## Exemplo Detalhado

Na visualização exemplo:

```
50 (B:0)              # Raiz da árvore, perfeitamente balanceada
  |-- 25 (B:0)        # Filho esquerdo da raiz
  |--   |-- 12 (B:0)  # Filho esquerdo de 25
  |--   |-- 37 (B:0)  # Filho direito de 25
  |-- 75 (B:0)        # Filho direito da raiz
```

Podemos observar:
* 50 é a raiz com dois filhos: 25 e 75
* 25 tem dois filhos: 12 e 37
* 75 é um nó no segundo nível
* Todos os nós têm fator de balanceamento 0, indicando árvore perfeitamente balanceada

## Utilidade da Visualização

Esta representação permite:

1. **Verificação Visual**: Rápida inspeção da estrutura da árvore
2. **Diagnóstico de Problemas**: Identificação de desequilíbrios
3. **Validação de Algoritmos**: Confirmação de que as rotações AVL funcionam corretamente
4. **Rastreamento de Operações**: Observação das mudanças na árvore após inserções ou remoções

## Implementação

Esta visualização é implementada no método `imprimirArvore()` do arquivo `TesteArvoreAVL.java` utilizando uma abordagem recursiva de percurso em pré-ordem com indentação progressiva.
