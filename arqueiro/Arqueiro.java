package arqueiro;

import herois.Heroi;

public class Arqueiro extends Heroi {
    /*
Essa é uma das classes de heróis, essa classe é uma SubClasse de Heroi, ela herda os atributos e métodos da SuperClasse.
Porém tem um diferencial, como cada classe de herói possui os seus atributos próprios, a Classe Arqueiro possui
os atributos precisao, agilidade e concentracao.
    */
    private int precisao, agilidade, concentracao;
    /*
Este é o construtor da Classe Arqueiro, ele chama o construtor da SuperClasse através do super, e passa dentro dele, de forma já definida, a classe e a mana
daquele personagem, deixando para o usuário digitar apenas o nome, já que o usuário irá selecionar a sua classe por um menu de seleção.
Foram utilizados dentro desse construtor os sets dos atributos da Classe Arqueiro, deixando esses atributos com um valor já pré-definido.
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
Aqui está o método exibirStats sendo sobrescrito, adicionando para imprimir os atributos de precisão, agilidade e concentração e os pontos de combate daquele herói.
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
Este é o método calcularPontosCombate que existe na Classe Heroi, aqui ele faz a soma dos atributos individuais da classe, e será assim em todas as SubClasses de heróis.
Ele consiste em: o atributo mais predominante daquela classe é multiplicado por 10 e somado com o restante dos atributos individuais e a vida.
No Arqueiro o atributo predominante é a precisão.
   */
    @Override
    public int calcularPontosCombate() {
        return (precisao *10) + agilidade + concentracao + getVida();
    }

    /*
Aqui está sobrescrevendo o método evoluir, para que os atributos individuais das SubClasses sejam aumentados também através do método evoluir.
Primeiro ele chama o evoluir da SuperClasse com o super, que aumenta nível, vida e mana, e depois aumenta os atributos próprios do Arqueiro.
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
    /*
   Esses dois métodos evoluir apenas chamam o evoluir da SuperClasse. Como eles acabam chamando o evoluir com dois parâmetros,
   o Java usa a versão sobrescrita aqui no Arqueiro, e assim os atributos próprios também aumentam.
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
