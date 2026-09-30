package herois;

public abstract class   Heroi {
    /*
   Herói tem a função de superclasse desse projeto, nela foram armazenados os atributos gerais para as classes de heróis (Guerreiro, Mago, Arqueiro).
   Esses atributos são definidos dentro da superclasse, pois a ideia que tive foi deles já serem pré-determinados, assim como em jogos de RPG (Black Desert, Neverwinter).
   A classe é abstract, pois não faz sentido existir um herói sem classe, todo herói criado tem que ser um Guerreiro, um Mago ou um Arqueiro.
   Todos os atributos têm getters, e alguns atributos como (Nível, Vida, Mana) possuem setters com requisitos a serem cumpridos, exemplos: não poder ser negativo, entre outros.
   Os setters que possuem essas validações são private, para que somente a própria classe Heroi consiga alterar esses valores, e ninguém de fora
   consiga mudar o nível ou a vida de um herói sem ser pelas missões. O atributo classe não possui setter, pois ele é definido uma única vez pela subclasse no construtor.
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
    Aqui é o setter do atributo nível, nele realizei um if para não ser possível aceitar níveis abaixo de 0, caso a pessoa queira um desafio maior,
    a pessoa pode alterar para 0 o nível. Mas terá de mudar no construtor o nível, pois ele já vem determinado em 10.
    Optei por usar o IllegalArgumentException sem tratamento na Main, com a intenção de forçar a quebra do programa em caso de algo errado,
    pois queria ver onde quebra e quais erros são aceitos ou não.
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
    Aqui é o setter do atributo vida, nele realizei um if para não ser possível aceitar vida abaixo de 0. Acredito que como atualização futura seja legal adicionar
    um mecanismo de morte do herói, em caso da vida chegar a 0 o herói morre, mas atualmente como não temos um sistema de combate (para reduzir a vida) ou inimigos reais
    para poder reduzir a vida, não faz sentido colocá-lo agora.
    Optei por usar o IllegalArgumentException sem tratamento na Main, com a intenção de forçar a quebra do programa em caso de algo errado,
    pois queria ver onde quebra e quais erros são aceitos ou não.
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
    Aqui é o setter do atributo mana, nele realizei um if para não ser possível aceitar mana abaixo de 150. Em jogos de RPG é comum que todos os personagens tenham mana,
    independente se as suas habilidades usam mana ou não. A mana fica definida em cada classe de herói (Guerreiro recebe 150 de mana, Mago recebe 350 de mana, Arqueiro recebe 225).
    Optei por usar o IllegalArgumentException sem tratamento na Main, com a intenção de forçar a quebra do programa em caso de algo errado,
    pois queria ver onde quebra e quais erros são aceitos ou não.
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
   Este é o construtor da superclasse. Os únicos atributos que recebem valor por parâmetro no construtor são: nome, classe e mana, pois eles precisam ser definidos
   para cada subclasse, já que nome, classe e mana são diferentes para cada personagem. O nome e a classe são guardados direto com o this, e a mana, o nível e a vida
   são chamados através do set, para que o valor inserido passe pela validação de cada set.
   O nível e a vida são definidos dentro do construtor (nível 10 e vida 50), sem que o usuário possa colocar valor neles, pois senão alguém poderia criar um personagem
   com um milhão de vida e um milhão de nível.
    */
    public Heroi(String nome, String classe,int mana) {
        setMana(mana);
        this.nome = nome;
        this.classe=classe;
        setNivel(10);
        setVida(50);
    }

    /*
    O método exibirStats imprime na tela o nome, nível, classe, vida e mana daquele personagem.
    Esse método é sobrescrito em cada classe de herói, pois cada classe específica possui os seus atributos próprios.
    Essa é apenas a base universal do exibirStats.
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
       Esta é a base do método evoluir, ele tem como função aumentar os status do herói a cada missão que ele faz. Depois dele temos outros métodos evoluir
       com o mesmo nome e parâmetros diferentes, criando uma sobrecarga: temos o método evoluir(), que é chamado para missões de nível fácil, onde o herói sobe 1 nível e 5 pontos de cada atributo.
       Temos também o evoluir(int multiplicador), onde ele utiliza o evoluir geral e multiplica o aumento básico de nível e atributo. Ele é usado em missões
       de nível médio (multiplicando por 5 o aumento de nível e atributos) e nível difícil (multiplicando por 10 o aumento de nível e atributos).
       Este evoluir com dois parâmetros é protected, pois só as subclasses precisam usar e sobrescrever ele, para aumentar os seus atributos próprios.
       Já o evoluir() e o evoluir(int multiplicador) são public, pois a ideia inicial era deixar tudo protected para que ninguém pudesse evoluir o herói sem fazer
       a missão, porém com protected eu teria que colocar a classe Missao no mesmo pacote da superclasse, o que iria bagunçar a estrutura do projeto.
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
       O método calcularPontosCombate foi criado para somar os atributos dos personagens e distinguir qual personagem é o mais forte.
       Ele é abstract, ou seja, aqui na superclasse ele não tem corpo, pois cada classe de herói calcula de um jeito diferente,
       então ele é obrigatoriamente sobrescrito em cada classe de personagem.
    */
    public abstract int calcularPontosCombate();

}
