package mago;

import herois.Heroi;

public class Mago extends Heroi {
    /*
Essa é uma das classes de herois, essa Classe é uma SubClasse de Heroi, ela herda todos os metodos da SuperClasse.
Porem tem um diferencial, como cada classe de heroi possui os seus atributos proprios, a Classe Mago possuem
os atributos poderMagico, inteligencia e fe.
nao estava previsto o atributo fe, porem foi implementado para que todas as classes de herois tivessem
a mesma quantidade de pontos de combate. pois em mago um dos atributos principais era mana, e por ser mago ele deve ter
mais mana que os demais, e se fosse contabilizado mana no calculo de pontos de combate, os personagens magos sempre teriam
vantagens em ser o heroi mais forte.
    */
   private  int poderMagico, inteligencia, fe;

    /*
Este é o construtor da Classe Mago, ela herda da SuperClasse o seu construtor, e adiciona dentro desse construtor, de forma já definida a classe a mana
daquele personagem deixando para o usuário digitar apenas o nome, já que o usuário ira selecionar a sua classe por um menu de seleção.
Foi utilizado dentro desse construtor os set dos atributos da Classe Mago, deixando esses atributos com um valor já pre definido.
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
Aqui está o metodo exibirStats sendo sobreescrito, adicionando para imprimir os atributos de poderMagico, inteligencia e fe e ponto de combate daquele heroi.
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
Aqui está sobreescrevendo o metodo evoluir, para que os atributos individuais das SubClasses sejam aumentados tambem atraves do metodo evoluir.
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

    @Override
    public void evoluir() {
        super.evoluir();
    }

    @Override
    public void evoluir(int multiplicador) {
        super.evoluir(multiplicador);
    }

    /*
Este é o metodo calcularPontosCombate que possui na Classe Heroi, aqui ele faz a soma dos atributos individuais da Classe sera assim em todas as SubClasses de herois.
Ela consiste em, o atributo mais predominante daquela classe é multiplicado por 10 e soma com o restante dos atributos individuais e a vida.
    */
    @Override
    public int calcularPontosCombate() {
        return (poderMagico * 10) + inteligencia + fe + getVida() ;
    }
}
