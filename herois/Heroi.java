package herois;

public abstract class   Heroi {
    /*
    Herói tem a função de superclasse desse projeto, nela foram armazenadas atributos gerais para as classes de herois(guerreiro,mago,arqueiro.
    Esses atributos são definidos dentro da superclasses, pois a ideia que tive foi deles já serem pre determinados, assim como em jogos de RPG(Black Desert, Neverwinter).
    Todos os atributos tem getters e setters, alguns atributos como(Nivel,Vida,Mana) possuem requisitos a serem cumpridos exemplos: nao poder ser negativo, entre outros.
    Os setter que possuem
     */
   private String nome;
   private int nivel;
   private int vida;
   private int mana;
   private String classe;

    public String getNome() {
        return nome;
    }


    public int getNivel() {
        return nivel;
    }
/*
Aqui é o setter do atributo nivel, nele realizei um if para não ser possível aceitar niveis abaixo de 0, caso a pessoa queira um desafio maior,
a pessoa pode alterar para 0 o nivel. Mas tera de mudar no construtor o nivel, pois ele ja vem determinado em 10.
Optei por usar o IllegalArgumentException sem tratamento na main, com a intenção de forçar a quebra do programa em caso de algo errado,
pois queria ver onde que quebra quais erros são aceitos ou nao.
 */
    private void setNivel(int nivel) {
        if (nivel < 0){
            throw new IllegalArgumentException("Valor não pode ser negativo.");
        }else {
            this.nivel = nivel;
        }
    }

    public int getVida() {
        return vida;
    }
    /*
    Aqui é o setter do atributo vida, nele realizei um if para não ser possível aceitar vida abaixo de 0, acredito que como atualização futura seja legal adicionar
    um mecanismo de morte do heroi, em caso da vida chegar a 0 o heroi morre, mas atualmente como nao temos um for(para reduzir vida) ou inimigos reais
    para poder reduzir a vida, não faz sentido colocá-lo agora.
    Optei por usar o IllegalArgumentException sem tratamento na main, com a intenção de forçar a quebra do programa em caso de algo errado,
    pois queria ver onde que quebra quais erros são aceites ou não.
     */
    private void setVida(int vida) {
        if(vida < 0 ){
            throw new IllegalArgumentException("Valor não pode ser negativo.");
        }else {
            this.vida = vida;
        }
    }

    public int getMana() {
        return mana;
    }

    /*
    Aqui é o setter do atributo mana, nele realizei um if para não ser possível aceitar mana abaixo de 150, em Jogos de RPG é comum que todos os personagens tenham mana,
    independente se a suas habilidades usem mana ou não, a mana fica definida em cada classe de heroi(Guerreiro recebe 150 de mana, mago recebe 350 de mana, arqueiro recebe 225).
    Optei por usar o IllegalArgumentException sem tratamento na main, com a intenção de forçar a quebra do programa em caso de algo errado,
    pois queria ver onde que quebra quais erros são aceitos ou não.
     */
    private void setMana(int mana) {
        if (mana < 150 ){
            throw new IllegalArgumentException("Valor não pode ser menor que 150.");
        }else {
            this.mana = mana;
        }

    }

    public String getClasse() {
        return classe;
    }
    /*
    Este é o construtor da superclasse, nele possui o this.nome e classe, os atributos mana, nivel e vida, são chamados atraves do set, para que o valor inserido
    passe pela validação de cada set. Os unicos atributos que possuem definição de valor no construtor são: Nome, Classe e mana, pois eles precisão ser definidos
    para cada subclasse, pois nome, classes e mana são diferentes para cada personagem.
    O set nivel e vida são definidos dentro do construtor, sem que o usuario possa colocar valor nele, pois se nao alguem pode criar um personagem com um milhao de vida
    e um milhao de nivel.
     */
    public Heroi(String nome, String classe,int mana) {
        setMana(mana);
        this.nome = nome;
        this.classe=classe;
        setNivel(10);
        setVida(50);
    }

    /*
   O metodo exibirStats, imprime na tela o nome, nivel, classe, vida e mana daquele personagem,
   esse metodo se sobreescreve em cada classe de heroi, pois cada classe específica possuem os seus atributos próprios.
   Essa é apenas a base universal do exibirStats
     */
    public void exibirStats(){
        System.out.println("\n===Status Heroi===\n");
        System.out.println("Nome: " + nome);
        System.out.println("Nivel: " + nivel);
        System.out.println("Classe: " + classe);
        System.out.println("Vida: " + vida);
        System.out.println("Mana: " + mana);
    }

    /*
       Esta é a base do metodo evoluir, ele tem como função aumentar os status do heroi a cada missão que ele faz, depois de tem outros metodos tambem evoluir
       criando um polimorfismo, temos o metodo evoluir(), onde é chamado para missoes de nivel facil onde os sobe 1 nivel e 5 pontos de cada atributo.
       temos tambem o evoluir(int multiplicador) onde nele utiliza do evoluir geral e multiplica o aumento basico de nivel e atributo, eles são usados em missoes
       de nivel medio(multiplicando por 5, o aumento de nivel e atributos), nivel dificil(multiplicando por 10, o aumento de nivel e atributos).
    */
    protected void evoluir(int aumentoNivel, int aumentoAtributo){
        vida+= aumentoAtributo;
        mana+= aumentoAtributo;
        nivel+=aumentoNivel;
        System.out.println("\n===Evoluiu===\n");
        System.out.println("Vida: " + vida);
        System.out.println("Mana: " + mana);
        System.out.println("Nivel: " + nivel);

    }

    public void evoluir(){
        evoluir(1,5);
    }
    public void evoluir(int multiplicador){
        evoluir(1 * multiplicador ,5 * multiplicador);
    }

    /*
       O metodo calcularPontosCombate, foi criado para somar cada atributo dos personagens para distinguir qual personagem é mais forte.
       Esse metodo é sobreescrito em cada classe de personagem.
    */
    public abstract int calcularPontosCombate();

}
