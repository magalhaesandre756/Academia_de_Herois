package mago;

import herois.Heroi;

public class Mago extends Heroi {
    /*
Essa é uma das classes de heróis, essa classe é uma SubClasse de Heroi, ela herda os atributos e métodos da SuperClasse.
Porém tem um diferencial, como cada classe de herói possui os seus atributos próprios, a Classe Mago possui
os atributos poderMagico, inteligencia e fe.
Não estava previsto o atributo fé, porém ele foi implementado para que todas as classes de heróis tivessem
a mesma quantidade de pontos de combate. Pois no mago um dos atributos principais era a mana, e por ser mago ele deve ter
mais mana que os demais, e se a mana fosse contabilizada no cálculo de pontos de combate, os personagens magos sempre teriam
vantagem em ser o herói mais forte.
    */
   private  int poderMagico, inteligencia, fe;
    /*
Este é o construtor da Classe Mago, ele chama o construtor da SuperClasse através do super, e passa dentro dele, de forma já definida, a classe e a mana
daquele personagem, deixando para o usuário digitar apenas o nome, já que o usuário irá selecionar a sua classe por um menu de seleção.
Foram utilizados dentro desse construtor os sets dos atributos da Classe Mago, deixando esses atributos com um valor já pré-definido.
    */
    public Mago(String nome) {
        super(nome,"Mago", 350);
        setInteligencia(10);
        setPoderMagico(20);
        setFe(10);
    }


    public void setFe(int fe) {
        this.fe = fe;
    }


    public void setPoderMagico(int poderMagico) {
        this.poderMagico = poderMagico;
    }


    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    /*
Aqui está o método exibirStats sendo sobrescrito, adicionando para imprimir os atributos de poder mágico, inteligência e fé e os pontos de combate daquele herói.
    */
    @Override
    public void exibirStats() {
        super.exibirStats();
        System.out.println("Poder Magico: " + poderMagico);
        System.out.println("Inteligência: " + inteligencia);
        System.out.println("Fé: " + fe);
        System.out.println("Pontos de Combate: " + calcularPontosCombate());
    }

    /*
Aqui está sobrescrevendo o método evoluir, para que os atributos individuais das SubClasses sejam aumentados também através do método evoluir.
Primeiro ele chama o evoluir da SuperClasse com o super, que aumenta nível, vida e mana, e depois aumenta os atributos próprios do Mago.
   */
    @Override
    protected void evoluir(int aumentoNivel, int aumentoAtributo) {
        super.evoluir(aumentoNivel, aumentoAtributo);
        poderMagico += aumentoAtributo;
        inteligencia += aumentoAtributo;
        fe += aumentoAtributo;
        System.out.println("Poder Magico: " + poderMagico);
        System.out.println("Inteligencia: " + inteligencia);
        System.out.println("Fé: " + fe);
    }
    /*
   Esses dois métodos evoluir apenas chamam o evoluir da SuperClasse. Como eles acabam chamando o evoluir com dois parâmetros,
   o Java usa a versão sobrescrita aqui no Mago, e assim os atributos próprios também aumentam.
       */
    @Override
    public void evoluir() {
        super.evoluir();
    }

    @Override
    public void evoluir(int multiplicador) {
        super.evoluir(multiplicador);
    }

    /*
Este é o método calcularPontosCombate que existe na Classe Heroi, aqui ele faz a soma dos atributos individuais da classe, e será assim em todas as SubClasses de heróis.
Ele consiste em: o atributo mais predominante daquela classe é multiplicado por 10 e somado com o restante dos atributos individuais e a vida.
No Mago o atributo predominante é o poder mágico.
   */
    @Override
    public int calcularPontosCombate() {
        return (poderMagico * 10) + inteligencia + fe + getVida() ;
    }
}
