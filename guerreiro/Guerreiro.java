package guerreiro;

import herois.Heroi;

public class Guerreiro  extends Heroi {
    /*
Essa é uma das classes de herois, essa Classe é uma SubClasse de Heroi, ela herda todos os metodos da SuperClasse.
Porem tem um diferencial, como cada classe de heroi possui os seus atributos proprios, a Classe Guerreiro possuem
os atributos forca, resistencia, energia.
    */

    private int forca;
    private int resistencia;
    private int energia;

    /*
       Este é o construtor da Classe Guerreiro, ela herda da SuperClasse o seu construtor, e adiciona dentro desse construtor, de forma já definida a classe a mana
       daquele personagem deixando para o usuário digitar apenas o nome, já que o usuário ira selecionar a sua classe por um menu de seleção.
       Foi utilizado dentro desse construtor os set dos atributos da Classe Guerreiro, deixando esses atributos com um valor já pre definido.
    */
    public Guerreiro(String nome) {
        super(nome, "Guerreiro", 150);
        setEnergia(10);
        setForca(20);
        setResistencia(10);
    }


    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

/*
Aqui está o metodo exibirStats sendo sobreescrito, adicionando para imprimir os atributos de forca, resistencia e energia e ponto de combate daquele heroi.
*/

    @Override
    public void exibirStats() {
        super.exibirStats();
        System.out.println("Força: " + forca);
        System.out.println("Resistencia: " + resistencia);
        System.out.println("Energia: " + energia);
        System.out.println("Pontos de Combate: " + calcularPontosCombate());
    }

/*
Este é o metodo calcularPontosCombate que possui na Classe Heroi, aqui ele faz a soma dos atributos individuais da Classe sera assim em todas as SubClasses de herois.
Ela consiste em, o atributo mais predominante daquela classe é multiplicado por 10 e soma com o restante dos atributos individuais e a vida.
*/
    @Override
    public int calcularPontosCombate() {
        return (forca*10) + energia + resistencia + getVida();
    }
    /*
       Aqui está sobreescrevendo o metodo evoluir, para que os atributos individuais das SubClasses sejam aumentados tambem atraves do metodo evoluir.
    */
    @Override
    protected void evoluir(int aumentoNivel, int aumentoAtributo) {
        super.evoluir(aumentoNivel, aumentoAtributo);
        resistencia += aumentoAtributo;
        forca += aumentoAtributo;
        energia += aumentoAtributo;
        System.out.println("Força: " + forca);
        System.out.println("Resistencia: " + resistencia);
        System.out.println("Energia: " + energia);
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
