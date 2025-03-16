# Estruturas de Dados em Java

Este repositório contém implementações de diversas estruturas de dados em Java, baseadas no livro "Estruturas de Dados" de Valter Castelhano de Oliveira. O projeto serve como um recurso educacional para estudantes e desenvolvedores interessados em aprender sobre estruturas de dados fundamentais.

## 📚 Estruturas Implementadas

O repositório inclui as seguintes implementações:

### Lista Ligada (`/lista-ligada`)
- Implementação de lista encadeada simples
- Classes principais:
  - `No.java`: Implementação do nó da lista
  - `Lista.java`: Operações básicas da lista ligada
  - `Cliente.java`: Classe modelo para exemplo prático
  - `CadastroCliente.java`: Exemplo de aplicação com cadastro de clientes

### Árvore Binária (`/arvore-binaria`)
- Implementação básica de árvore binária
- Classes principais:
  - `No.java`: Implementação do nó da árvore
  - `ArvoreBinaria.java`: Operações básicas da árvore
  - `ExemploArvoreBinaria.java`: Demonstração de uso

### Árvore Binária de Busca (`/arvore-binaria-busca`)
- Implementação de BST com operações completas
- Classes principais:
  - `No.java`: Implementação do nó da árvore
  - `ArvoreBinariaBusca.java`: Implementação das operações de BST
  - `ExemploABB.java`: Exemplo de uso com operações de inserção, busca e remoção

### Árvore AVL (`/arvore-avl`)
- Implementação de árvore AVL com balanceamento automático
- Classes principais:
  - `No.java`: Implementação do nó AVL com fator de balanceamento
  - `ArvoreAVL.java`: Implementação completa com rotações e balanceamento
  - `TesteArvoreAVL.java`: Suite de testes e exemplos de uso
- Documentação adicional:
  - `readme-visualizacao-arvore.md`: Guia para visualização da estrutura da árvore

### Árvores Experimentais
- `/teste-arvore-gpt`: Implementações experimentais e testes adicionais
- `/arvore-pti`: Variações e implementações alternativas

### Pilha (`/pilha`)
- Implementação de pilha com duas abordagens diferentes
- Classes principais:
  - `PilhaInterface.java`: Interface com operações básicas da pilha
  - `PilhaArray.java`: Implementação usando array
  - `PilhaEncadeada.java`: Implementação usando lista encadeada
  - `ExemploPilha.java`: Demonstração de uso das implementações

### Fila (`/fila`)
- Implementação de fila com duas abordagens diferentes
- Classes principais:
  - `FilaInterface.java`: Interface com operações básicas da fila
  - `FilaArray.java`: Implementação usando array circular
  - `FilaEncadeada.java`: Implementação usando lista encadeada
  - `ExemploFila.java`: Demonstração de uso das implementações

## 🔧 Pré-requisitos

- Java Development Kit (JDK) 8 ou superior
- IDE Java de sua preferência (opcional)
- Terminal/Prompt de comando

## 🚀 Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/estruturas-dados-java.git
   cd estruturas-dados-java
   ```

2. Escolha a estrutura de dados que deseja testar e navegue até seu diretório:
   ```bash
   cd nome-da-estrutura/
   ```

3. Compile o arquivo Java desejado:
   ```bash
   javac NomeDoArquivo.java
   ```

4. Execute o programa:
   ```bash
   java NomeDoArquivo
   ```

## 📖 Exemplos de Uso

### Lista Ligada
```bash
cd lista-ligada
javac CadastroCliente.java
java CadastroCliente
```

### Árvore AVL
```bash
cd arvore-avl
javac TesteArvoreAVL.java
java TesteArvoreAVL
```

### Árvore Binária de Busca
```bash
cd arvore-binaria-busca
javac ExemploABB.java
java ExemploABB
```

### Pilha
```bash
cd pilha
javac ExemploPilha.java
java ExemploPilha
```

### Fila
```bash
cd fila
javac ExemploFila.java
java ExemploFila
```

## 📝 Estrutura do Projeto

```
.
├── lista-ligada/            # Lista encadeada simples
│   ├── Lista.java          # Implementação da lista
│   ├── No.java            # Implementação do nó
│   └── CadastroCliente.java # Exemplo prático
├── arvore-binaria/         # Árvore binária básica
│   ├── ArvoreBinaria.java  # Implementação da árvore
│   └── ExemploArvoreBinaria.java # Demonstração
├── arvore-binaria-busca/   # Árvore binária de busca
│   ├── ArvoreBinariaBusca.java # Implementação BST
│   └── ExemploABB.java    # Exemplo de uso
├── arvore-avl/            # Árvore AVL
│   ├── ArvoreAVL.java     # Implementação com balanceamento
│   └── TesteArvoreAVL.java # Testes e exemplos
├── pilha/                  # Implementações de Pilha
│   ├── PilhaInterface.java # Interface da pilha
│   ├── PilhaArray.java    # Implementação com array
│   ├── PilhaEncadeada.java # Implementação encadeada
│   └── ExemploPilha.java  # Demonstração
├── fila/                  # Implementações de Fila
│   ├── FilaInterface.java # Interface da fila
│   ├── FilaArray.java    # Implementação com array
│   ├── FilaEncadeada.java # Implementação encadeada
│   └── ExemploFila.java  # Demonstração
└── README.md              # Este arquivo
```

## 🔍 Funcionalidades Principais

### Lista Ligada
- Inserção no início e fim
- Remoção por posição
- Busca por elemento
- Exemplo prático com cadastro de clientes

### Árvore Binária de Busca
- Inserção ordenada
- Remoção com reorganização
- Busca eficiente
- Percursos em ordem, pré-ordem e pós-ordem

### Árvore AVL
- Balanceamento automático
- Rotações simples e duplas
- Fator de balanceamento
- Visualização da estrutura da árvore

### Pilha
- Duas implementações: array e lista encadeada
- Operações básicas:
  - push (empilhar)
  - pop (desempilhar)
  - peek (consultar topo)
  - isEmpty (verificar se está vazia)
  - isFull (verificar se está cheia - versão array)
- Tratamento de exceções para operações inválidas

### Fila
- Duas implementações: array circular e lista encadeada
- Operações básicas:
  - enqueue (enfileirar)
  - dequeue (desenfileirar)
  - peek (consultar primeiro)
  - isEmpty (verificar se está vazia)
  - isFull (verificar se está cheia - versão array)
- Array circular para melhor eficiência de espaço
- Tratamento de exceções para operações inválidas

## 🤝 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para:
- Abrir issues reportando bugs
- Sugerir melhorias
- Enviar pull requests com novas implementações
- Adicionar mais exemplos e documentação

## 📚 Referências

- Livro: "Estruturas de Dados" - Valter Castelhano de Oliveira
- Documentação Java
- Recursos adicionais sobre AVL: `arvore-avl/readme-visualizacao-arvore.md`
- Este README foi gerado por IA