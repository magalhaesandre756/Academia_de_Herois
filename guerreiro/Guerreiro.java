package guerreiro;

import herois.Heroi;

public class Guerreiro  extends Heroi {
     /*
Essa é uma das classes de heróis, essa classe é uma SubClasse de Heroi, ela herda os atributos e métodos da SuperClasse.
Porém tem um diferencial, como cada classe de herói possui os seus atributos próprios, a Classe Guerreiro possui
os atributos forca, resistencia e energia.
    */

    private int forca;
    private int resistencia;
    private int energia;

    /*
       Este é o construtor da Classe Guerreiro, ele chama o construtor da SuperClasse através do super, e passa dentro dele, de forma já definida, a classe e a mana
       daquele personagem, deixando para o usuário digitar apenas o nome, já que o usuário irá selecionar a sua classe por um menu de seleção.
       Foram utilizados dentro desse construtor os sets dos atributos da Classe Guerreiro, deixando esses atributos com um valor já pré-definido.
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
Aqui está o método exibirStats sendo sobrescrito, adicionando para imprimir os atributos de força, resistência e energia e os pontos de combate daquele herói.
*/

    @Override
    public void exibirStats() {
        super.exibirStats();
        System.out.println("Força: " + forca);
        System.out.println("Resistência: " + resistencia);
        System.out.println("Energia: " + energia);
        System.out.println("Pontos de Combate: " + calcularPontosCombate());
    }

    /*
    Este é o método calcularPontosCombate que existe na Classe Heroi, aqui ele faz a soma dos atributos individuais da classe, e será assim em todas as SubClasses de heróis.
    Ele consiste em: o atributo mais predominante daquela classe é multiplicado por 10 e somado com o restante dos atributos individuais e a vida.
    No Guerreiro o atributo predominante é a força.
    */
    @Override
    public int calcularPontosCombate() {
        return (forca*10) + energia + resistencia + getVida();
    }
    /*
      Aqui está sobrescrevendo o método evoluir, para que os atributos individuais das SubClasses sejam aumentados também através do método evoluir.
      Primeiro ele chama o evoluir da SuperClasse com o super, que aumenta nível, vida e mana, e depois aumenta os atributos próprios do Guerreiro.
   */
    @Override
    protected void evoluir(int aumentoNivel, int aumentoAtributo) {
        super.evoluir(aumentoNivel, aumentoAtributo);
        resistencia += aumentoAtributo;
        forca += aumentoAtributo;
        energia += aumentoAtributo;
        System.out.println("Força: " + forca);
        System.out.println("Resistência: " + resistencia);
        System.out.println("Energia: " + energia);
    }
    /*
     Esses dois métodos evoluir apenas chamam o evoluir da SuperClasse. Como eles acabam chamando o evoluir com dois parâmetros,
     o Java usa a versão sobrescrita aqui no Guerreiro, e assim os atributos próprios também aumentam.
    */
    @Override
    public void evoluir() {
        super.evoluir();
    }

    @Override
    public void evoluir(int multiplicador) {
        super.evoluir(multiplicador);
    }
}
