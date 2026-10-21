# 🏰 Academia de Heróis do Reino de Arcádia

Sistema em Java, executado no console, para gerenciar os heróis de uma academia fictícia.

O Reino de Arcádia está enfrentando diversas ameaças mágicas, e a Academia de Heróis é responsável por treinar guerreiros, magos e arqueiros. Pelo menu é possível cadastrar heróis, consultar os seus status, enviá-los em missões para evoluírem e, ao final, ver o Relatório do Reino.

---

## ⚔️ Funcionalidades

- Cadastro de até **20 heróis** em um vetor, escolhendo a classe por um menu (Guerreiro, Mago ou Arqueiro)
- Listagem de todos os heróis com os seus status
- Busca de herói pelo nome (sem diferenciar maiúsculas e minúsculas)
- Missões com três dificuldades, em que o herói evolui e recebe ouro
- Estatísticas gerais e Relatório do Reino ao sair do sistema

## 🧙 Classes de heróis

Todo herói começa com **nível 10** e **50 de vida**.

| Classe | Mana inicial | Atributos próprios | Atributo principal |
|---|---|---|---|
| Guerreiro | 150 | Força, Resistência, Energia | Força |
| Mago | 350 | Poder Mágico, Inteligência, Fé | Poder Mágico |
| Arqueiro | 225 | Precisão, Agilidade, Concentração | Precisão |

O herói mais forte é definido pelos **Pontos de Combate**: o atributo principal × 10 + os outros atributos da classe + a vida. Com os valores iniciais, as três classes começam empatadas com 270 pontos.

## 📜 Missões

| Dificuldade | Nível | Vida, mana e atributos | Recompensa |
|---|---|---|---|
| Fácil | +1 | +5 | 50 de ouro |
| Médio | +5 | +25 | 250 de ouro |
| Difícil | +10 | +50 | 500 de ouro |

Uma mesma missão não pode ser concluída duas vezes.

---

## 📁 Estrutura do projeto

```
src/
├── Main.java                          → menu de interação com o usuário
├── herois/Heroi.java                  → superclasse abstrata
├── guerreiro/Guerreiro.java           → subclasse
├── mago/Mago.java                     → subclasse
├── arqueiro/Arqueiro.java             → subclasse
├── academiadeherois/AcademiaDeHerois.java → vetor de heróis, cadastro, busca e relatório
└── missao/Missao.java                 → missões, evolução e recompensa
```

## ▶️ Como executar

**Pela IDE (IntelliJ, Eclipse, VS Code):** abra o projeto e execute a classe `Main`.

**Pelo terminal**, dentro da pasta `src`:

```bash
javac -encoding UTF-8 Main.java herois/*.java guerreiro/*.java mago/*.java arqueiro/*.java academiadeherois/*.java missao/*.java
java Main
```

## 🧩 Conceitos de Orientação a Objetos aplicados

| Conceito | Onde aparece |
|---|---|
| Encapsulamento | Atributos `private`, setters privados com validação na `Heroi` e sem `setClasse()` |
| Abstração | `Heroi` é `abstract` e `calcularPontosCombate()` é abstrato |
| Herança | `Guerreiro`, `Mago` e `Arqueiro` estendem `Heroi` usando `super(...)` |
| Polimorfismo | O vetor `Heroi[]` guarda as três classes, e cada uma calcula e exibe os status do seu jeito |
| Sobrecarga | `evoluir()`, `evoluir(int)` e `evoluir(int, int)` |
| Sobrescrita | `@Override` em `exibirStats()`, `evoluir()` e `calcularPontosCombate()` |
| Vetores | `Heroi[] herois = new Heroi[20]` |
| Condicionais e repetição | `switch` nos menus, `if/else if` na dificuldade, `while` no menu e `for` no vetor |

---

## 🧠 Desafios e aprendizados

Os pontos que mais exigiram raciocínio durante o desenvolvimento:

### 1. Herança x composição
No começo eu queria que o cadastro de heróis e a missão fossem subclasses de `Heroi`. Aprendi a usar o teste do **"é um"**: um Guerreiro **é um** Herói, então faz sentido usar `extends`. Já a Missão **não é** um Herói, ela **tem** um herói participando. Com isso, a herança ficou restrita às três classes de personagem, e a `AcademiaDeHerois` e a `Missao` passaram a se relacionar com os heróis por composição.

### 2. A superclasse como tipo de atributo
Eu não sabia que era possível usar uma classe abstrata como tipo de um atributo ou de um vetor. Isso foi o que permitiu que a `Missao` tivesse um `private Heroi heroi` e que a academia guardasse tudo em um `Heroi[]`, sem precisar saber se o herói é Guerreiro, Mago ou Arqueiro. Foi aqui que o polimorfismo fez sentido na prática: a missão chama `heroi.evoluir()`, e cada classe evolui os seus próprios atributos.

### 3. `protected` e organização em pacotes
Deixei os métodos `evoluir` como `protected` para que só as missões conseguissem evoluir os heróis. Porém, como cada classe ficou em um pacote próprio, a `Missao` não tinha acesso a eles, já que `protected` só libera para subclasses e para classes do mesmo pacote. Tive que escolher entre juntar tudo em um pacote ou tornar os métodos `public`. Mantive os pacotes separados, deixei `public` as versões que a missão usa e `protected` apenas a versão que só as subclasses sobrescrevem.

### 4. Menu e criação do herói escolhido
Tive dificuldade para entender como o menu iria cadastrar um herói da classe certa. A solução foi ler o nome digitado em uma variável local e passar essa variável direto para o construtor da subclasse escolhida em um `switch`, por exemplo `new Guerreiro(nome)`. O usuário nunca digita a classe: a própria subclasse informa `"Guerreiro"` para a superclasse através do `super(...)`, o que impede que um Guerreiro seja cadastrado como Mago.

### 5. Busca pelo nome
No `buscarHeroiPeloNome` precisei entender a diferença entre **imprimir** e **retornar**. O método precisava mostrar os status para o usuário e, ao mesmo tempo, devolver o objeto encontrado, para que o menu pudesse enviar esse herói para uma missão. Também tive que tratar o caso de não encontrar ninguém, retornando `null` e verificando isso antes de criar a missão.

### 6. Relatório e herói mais forte
Montar o relatório exigiu fazer várias coisas em um único laço: contar os heróis por classe, somar os níveis e descobrir o mais forte. Para o herói mais forte usei a lógica do "campeão atual", em que cada herói é comparado com o melhor encontrado até então. Precisei entender por que começar essa variável em `null` gerava `NullPointerException` e garantir que o relatório só seja gerado quando existe pelo menos um herói, o que também evita a divisão por zero no cálculo da média.

## 🚧 Limitações e melhorias futuras

- Digitar uma letra no lugar de um número no menu encerra o programa, pois não foi usado tratamento de exceções (`try/catch`).
- A vida ainda não diminui, porque o sistema não tem combate nem inimigos. Uma ideia futura é um sistema de batalhas em que o herói pode ser derrotado.
- Os heróis ficam guardados apenas enquanto o programa está aberto. Uma melhoria seria salvar os dados em arquivo ou banco de dados.

---

Desenvolvido por **André Magalhães**, Engenharia de Software, CEUB.
