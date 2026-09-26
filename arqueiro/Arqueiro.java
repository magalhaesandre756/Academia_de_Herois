package arqueiro;

import herois.Heroi;

public class Arqueiro extends Heroi {
    /*
Essa é uma das classes de herois, essa Classe é uma SubClasse de Heroi, ela herda todos os metodos da SuperClasse.
Porem tem um diferencial, como cada classe de heroi possui os seus atributos proprios, a Classe Arqueiro possuem
os atributos precisao, agilidade, concentracao.
    */
    private int precisao, agilidade, concentracao;
    /*
Este é o construtor da Classe Guerreiro, ela herda da SuperClasse o seu construtor, e adiciona dentro desse construtor, de forma já definida a classe a mana
daquele personagem deixando para o usuário digitar apenas o nome, já que o usuário ira selecionar a sua classe por um menu de seleção.
Foi utilizado dentro desse construtor os set dos atributos da Classe Guerreiro, deixando esses atributos com um valor já pre definido.
    */
    public Arqueiro(String nome) {
        super(nome, "Arqueiro", 225);
        setAgilidade(10);
        setConcentracao(10);
        setPrecisao(20);
    }

    public int getPrecisao() {
        return precisao;
    }

    public void setPrecisao(int precisao) {
        this.precisao = precisao;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(int concentracao) {
        this.concentracao = concentracao;
    }

    /*
Aqui está o metodo exibirStats sendo sobreescrito, adicionando para imprimir os atributos de precisao, agilidade e concentracao e ponto de combate daquele heroi.
    */
    @Override
    public void exibirStats() {
        super.exibirStats();
        System.out.println("Precisão: " + precisao);
        System.out.println("Agilidade: " + agilidade);
        System.out.println("Concentração: " + concentracao);
        System.out.println("Pontos de Combate: " + calcularPontosCombate());
    }

    /*
Este é o metodo calcularPontosCombate que possui na Classe Heroi, aqui ele faz a soma dos atributos individuais da Classe sera assim em todas as SubClasses de herois.
Ela consiste em, o atributo mais predominante daquela classe é multiplicado por 10 e soma com o restante dos atributos individuais e a vida.
    */
    @Override
    public int calcularPontosCombate() {
        return (precisao *10) + agilidade + concentracao + getVida();
    }

    /*
Aqui está sobreescrevendo o metodo evoluir, para que os atributos individuais das SubClasses sejam aumentados tambem atraves do metodo evoluir.
    */
    @Override
    protected void evoluir(int aumentoNivel, int aumentoAtributo) {
        super.evoluir(aumentoNivel, aumentoAtributo);
        precisao += aumentoAtributo;
        agilidade += aumentoAtributo;
        concentracao += aumentoAtributo;
        System.out.println("Precisão: " + precisao);
        System.out.println("Agilidade: " + agilidade);
        System.out.println("Concentração: " + concentracao);
    }

    @Override
    public void evoluir() {
        super.evoluir();
    }

    @Override
    public void evoluir(int multiplicador) {
        super.evoluir(multiplicador);
    }
}
