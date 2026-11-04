# Arena dos Campeões

Jogo de RPG em turnos desenvolvido em Java para execução no terminal. O jogador escolhe um nome e uma classe, enfrenta inimigos gerados aleatoriamente e decide, a cada turno, se deseja atacar, defender ou utilizar uma poção de cura.

## Índice

- [Visão geral](#visão-geral)
- [Requisitos](#requisitos)
- [Estrutura do projeto](#estrutura-do-projeto)
- [Como compilar e executar](#como-compilar-e-executar)
- [Como jogar](#como-jogar)
- [Classes de personagens](#classes-de-personagens)
- [Inimigos](#inimigos)
- [Regras do combate](#regras-do-combate)
- [Inventário e poções](#inventário-e-poções)
- [Organização e conceitos de POO](#organização-e-conceitos-de-poo)
- [Validação de entradas](#validação-de-entradas)
- [Limitações e melhorias possíveis](#limitações-e-melhorias-possíveis)

## Visão geral

**Este jogo de RPG simples foi desenvolvido como desafio final do Módulo 4 - Backend (Java e Orientação a Objeto) do curso 3035 Teach 2026.**

A Arena dos Campeões é um jogo de combate por turnos. O jogador cria seu personagem escolhendo um nome e uma das três classes disponíveis:

- **Guerreiro:** maior quantidade de vida e cura proporcional à vida atual.
- **Mago:** atributos equilibrados e cura aleatória.
- **Arqueiro:** maior ataque e cura fixa.

Depois da seleção, o personagem enfrenta uma sequência de inimigos. Cada inimigo recebe um nome aleatório e atributos sorteados dentro de intervalos definidos. O jogador pode continuar enfrentando adversários depois de cada vitória ou encerrar sua jornada.

O jogo termina quando o personagem do jogador perde toda a vida, quando o jogador decide parar depois de vencer uma batalha ou quando o jogador derrota três inimigos.

## Requisitos

- Java JDK instalado (JDK 8 ou superior).
- Terminal ou prompt de comando.
- Não são necessárias bibliotecas externas: o projeto utiliza recursos padrão do Java.

Para verificar se o Java está instalado:

```bash
java -version
javac -version
```

## Estrutura do projeto

```text
Final-Challenge---Champions-Arena/
├── src/
│   ├── Main.java
│   ├── Character.java
│   ├── Warrior.java
│   ├── Mage.java
│   ├── Archer.java
│   └── Enemy.java
├── Instructions Final-Challenge.pdf
└── README.md
```

| Arquivo | Responsabilidade |
|---|---|
| `Main.java` | Inicialização, fluxo principal, turnos, interface de terminal, geração de inimigos e validação das opções. |
| `Character.java` | Classe-base com atributos e comportamentos compartilhados pelos personagens. |
| `Warrior.java` | Implementação específica do Guerreiro e de sua cura. |
| `Mage.java` | Implementação específica do Mago e de sua cura aleatória. |
| `Archer.java` | Implementação específica do Arqueiro e de sua cura fixa. |
| `Enemy.java` | Especialização de `Character` que gera atributos aleatórios para os inimigos. |

Os arquivos não declaram `package`; portanto, as classes estão no pacote padrão do Java.

## Como compilar e executar

Compile com:

```bash
cd src/
javac *.java
```

O comando compila os arquivos `.java`.

Para iniciar o jogo:

```bash
java Main
```

Sempre que o código-fonte for alterado, compile novamente antes de executar.

## Como jogar

### 1. Início e identificação

Ao iniciar, o jogo apresenta a mensagem de boas-vindas e solicita o nome do jogador. Em seguida, apresenta as três classes disponíveis.

### 2. Escolha da classe

Digite o número correspondente à classe desejada:

```text
1 - Guerreiro
2 - Mago
3 - Arqueiro
```

A escolha determina os atributos iniciais e a habilidade de cura do personagem.

### 3. Preparação para a batalha

Antes de cada batalha, o jogo concede duas poções gratuitas ao inventário e utiliza duas poções automaticamente para tentar recuperar a vida do personagem.

A cura respeita o limite máximo de vida de cada classe. Mesmo quando o personagem já está com a vida cheia, a utilização da poção consome uma unidade do inventário.

### 4. Encontro com um inimigo

Um inimigo é gerado com nome e atributos aleatórios. O jogo informa seu nome e inicia o combate.

### 5. Turnos

No começo de cada turno, o jogo exibe os atributos do jogador e do inimigo. O jogador escolhe uma ação:

```text
1 - Atacar
2 - Defender
3 - Usar Poção de Cura
```

O inimigo também toma uma decisão automaticamente, entre atacar e defender-se (75% / 25% de chance). O combate continua até que um dos personagens fique sem vida.

### 6. Resultado da batalha

Se o inimigo for derrotado, o jogo registra uma vitória e mostra o total de batalhas vencidas. O jogador pode escolher enfrentar outro inimigo ou encerrar a jornada. Caso tenha derrotado seu terceiro inimigo, a partida acaba com o jogador campeão.

Se o jogador perder toda a vida, a partida termina automaticamente.

### 7. Encerramento

Ao final, o jogo apresenta uma mensagem de vitória ou derrota e informa o número total de batalhas vencidas.

## Classes de personagens

Cada classe herda os atributos e comportamentos comuns de `Character`, mas possui atributos iniciais e uma implementação própria do método `heal()`.

### Guerreiro (`Warrior`)

O Guerreiro possui a maior quantidade de vida inicial e recupera vida proporcionalmente à quantidade que possui no momento da cura.

| Propriedade | Valor inicial |
|---|---:|
| Vida | 240 |
| Ataque | 80 |
| Defesa | 70 |
| Inventário | 3 poções |

**Habilidade — cura proporcional:** ao utilizar uma poção, sua vida é multiplicada por 1,5, ou seja, recebe um aumento de 50% sobre a vida atual. A vida final não pode ultrapassar 240.

Exemplo: com 100 pontos de vida, a cura leva o personagem a 150. Com 180 pontos, a cura seria suficiente para ultrapassar o limite, então o resultado é 240.

### Mago (`Mage`)

O Mago possui atributos intermediários e uma habilidade de cura imprevisível.

| Propriedade | Valor inicial |
|---|---:|
| Vida | 200 |
| Ataque | 100 |
| Defesa | 80 |
| Inventário | 3 poções |

**Habilidade — cura aleatória:** cada poção sorteia um dos nove valores da lista de cura:

```text
0, 10, 10, 60, 60, 60, 80, 80, 1000
```

Cada posição possui a mesma probabilidade de ser sorteada. Assim, os resultados possíveis e suas probabilidades são:

| Cura sorteada | Probabilidade |
|---:|---:|
| 0 | 1/9 |
| 10 | 2/9 |
| 60 | 3/9 |
| 80 | 2/9 |
| 1000 | 1/9 |

A vida final é limitada a 200. Portanto, o resultado de 1000 funciona, na prática, como uma cura completa.

### Arqueiro (`Archer`)

O Arqueiro possui o maior ataque e a menor quantidade de vida inicial entre as três classes.

| Propriedade | Valor inicial |
|---|---:|
| Vida | 100 |
| Ataque | 120 |
| Defesa | 60 |
| Inventário | 3 poções |

**Habilidade — cura fixa:** cada poção recupera 50 pontos de vida, sem ultrapassar o limite máximo de 100.

Exemplo: com 80 pontos de vida, o Arqueiro recupera 20 pontos efetivos e chega a 100.

### Comparação das classes

| Atributo | Guerreiro | Mago | Arqueiro |
|---|---:|---:|---:|
| Vida | 240 | 200 | 100 |
| Ataque | 80 | 100 | 120 |
| Defesa | 70 | 80 | 60 |
| Cura | +50% da vida atual | Aleatória | +50 pontos |

Os valores de cura representam o comportamento implementado no código, não necessariamente a quantidade efetivamente recuperada: o limite máximo de vida pode reduzir a recuperação.

## Inimigos

Os inimigos são instâncias da classe `Enemy`, que herda de `Character`. Seus atributos são sorteados individualmente quando um novo inimigo é criado.

| Propriedade | Intervalo |
|---|---:|
| Vida | 100 a 200 |
| Ataque | 80 a 120 |
| Defesa | 30 a 60 |


Os nomes são escolhidos aleatoriamente entre:

- Zargor
- Ork
- Nyla
- Mildrogdon
- Embolop
- Cycloneo
- Zombiog

Como os atributos são sorteados independentemente, dois inimigos com o mesmo nome podem apresentar características diferentes.

## Regras do combate

### Ataque

Quando um personagem ataca um alvo que não está defendendo, o dano corresponde ao ataque do atacante, limitado à vida restante do alvo.

Quando o alvo está defendendo, sua defesa é subtraída do ataque:

```text
Dano = máximo(ataque do atacante - defesa do alvo, 0)
```

O dano também é limitado à vida restante do alvo. Assim, um personagem não recebe mais dano do que possui de vida e o dano nunca é negativo.

**Exemplo:** um personagem com 100 de ataque atinge um inimigo com 40 de defesa enquanto ele está defendendo. O dano causado é 60.

### Defesa

A ação de defesa ativa o estado defensivo do personagem. Enquanto esse estado estiver ativo, os ataques recebidos são reduzidos pelo valor de defesa.

A defesa é redefinida no início do próximo turno do próprio personagem.

### Poção de cura

A ação de cura chama o método `heal()` do personagem. Como cada classe sobrescreve esse método, o efeito depende da classe escolhida.

Se não houver poções disponíveis, o jogo informa que o inventário está vazio.

### Inteligência artificial do inimigo

A IA utiliza um sorteio aleatório para decidir a ação do inimigo:

| Ação | Probabilidade |
|---|---:|
| Atacar | 75% |
| Defender | 25% |

Essa decisão é realizada a cada turno. O inimigo não utiliza poções.

### Condições de vitória e derrota

- **Vitória na batalha:** a vida do inimigo chega a zero.
- **Derrota:** a vida do jogador chega a zero.
- **Encerramento voluntário:** depois de vencer uma batalha, o jogador pode escolher não enfrentar outro inimigo.
- **Vitória:** o jogador vence três batalhas.

O contador de batalhas é incrementado a cada inimigo derrotado.

## Inventário e poções

Todo personagem começa com três poções.

Além disso, antes de cada batalha, o jogo adiciona duas poções ao inventário e utiliza duas automaticamente para tentar recuperar a vida do personagem.

As três poções iniciais são para toda a partida, isto é, não são repostas.

## Organização e conceitos de POO

O projeto utiliza uma classe-base e quatro subclasses:

```text
                    Character   
                /    |     |    \
               /     |     |     \
          Warrior  Mage  Archer  Enemy
```

De forma mais precisa, `Warrior`, `Mage`, `Archer` e `Enemy` são subclasses independentes de `Character`.

### Herança

As subclasses reutilizam os atributos e métodos comuns definidos em `Character`, evitando duplicação de código.

### Encapsulamento

A classe `Character` concentra os atributos e oferece métodos de acesso (`getters` e `setters`), já que os atributos são `private`.

### Polimorfismo

O método `heal()` é chamado por meio de uma referência do tipo `Character`. A implementação executada depende da classe concreta do objeto: Guerreiro, Mago ou Arqueiro.

### Sobrescrita

As classes jogáveis utilizam `@Override` para fornecer suas próprias implementações de `heal()`.

### Modularização

A classe `Main` separa o fluxo do jogo em métodos com responsabilidades específicas, como:

- `startGame()`: coleta o nome e cria o personagem.
- `generateEnemy()`: cria um inimigo aleatório.
- `battle()`: controla o ciclo de combate.
- `showStatus()`: apresenta os atributos dos personagens.
- `playersTurn()`: recebe e processa a escolha do jogador.
- `enemysTurn()`: determina a ação do inimigo.
- `gameOver()`: apresenta o resultado final.
- `readValid()`: valida opções numéricas.
- `askToContinue()`: pergunta se o jogador deseja continuar.

## Validação de entradas

O método `readValid(min, max)` trata dois tipos de entrada inválida:

1. **Entrada não numérica:** captura `InputMismatchException`, informa o erro e solicita uma nova entrada.
2. **Número fora do intervalo:** informa que a opção está fora do intervalo permitido e solicita novamente.

Isso evita que opções inválidas interrompam o fluxo normal do jogo.

<br>
<br>

Desenvolvido em Java como desafio final do Módulo 4 - Backend (Java e Orientação a Objeto) do curso 3035 Teach 2026.

**Arena dos Campeões — Batalha em Turnos**.
