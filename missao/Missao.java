package missao;

import academiadeherois.AcademiaDeHerois;
import herois.Heroi;

public class Missao {
    /*
   Esta é a classe Missao, ela é responsável pelas missões que os heróis podem fazer. Ela não é uma SubClasse de Heroi nem da AcademiaDeHerois,
   pois uma missão não é um herói, ela apenas tem um herói participando dela. Por isso ela possui um atributo do tipo Heroi e um atributo do tipo AcademiaDeHerois,
   para conseguir evoluir o herói e avisar a academia quando a missão for concluída.
   Os atributos são: nome da missão, dificuldade, recompensa em ouro, o herói que vai fazer a missão, se a missão já foi concluída (boolean) e a academia.
    */

    private String nome;
    private String dificuldade;
    private int recompensaOuro;
    private Heroi heroi;
    private boolean concluida;
    private AcademiaDeHerois academiaDeHerois;

    public String getDificuldade() {
        return dificuldade;
    }
    /*
        Aqui é o setter da dificuldade, nele realizei um if e else if para aceitar somente as dificuldades Fácil, Médio e Difícil, utilizando o equalsIgnoreCase
        para não diferenciar letras maiúsculas e minúsculas. Além disso ele padroniza o texto, então se o usuário digitar "FÁCIL" fica salvo como "Fácil".
        Caso seja digitada uma dificuldade que não existe, ele lança um IllegalArgumentException. Na Main a dificuldade é escolhida por um menu numérico,
        então o usuário nunca digita o texto, e esse erro não acontece durante o uso do programa.
         */

    public void setDificuldade(String dificuldade) {
        if (dificuldade.equalsIgnoreCase("Difícil")){
            this.dificuldade = "Difícil";
        } else if (dificuldade.equalsIgnoreCase("Médio")) {
            this.dificuldade = "Médio";
        }else if (dificuldade.equalsIgnoreCase("Fácil")){
            this.dificuldade = "Fácil";
        }else {
            throw new IllegalArgumentException("As dificuldades disponíveis são: Fácil, Médio e Difícil.");
        }
    }
    /*
        Este é o construtor da classe Missao, nele é passado o nome da missão, a dificuldade, o herói que vai fazer a missão e a academia.
        A dificuldade passa pelo setDificuldade para ser validada. A recompensa em ouro não entra no construtor, pois ela é definida
        de acordo com a dificuldade quando a missão é concluída.
         */
    public Missao(String nome, String dificuldade, Heroi heroi, AcademiaDeHerois academiaDeHerois) {
        this.nome = nome;
        setDificuldade(dificuldade);
        this.heroi = heroi;
        this.academiaDeHerois= academiaDeHerois;
    }
    /*
       O método iniciarMissao apenas imprime na tela as informações da missão: o nome da missão, a dificuldade e o nome do herói que vai participar.
        */
    public void iniciarMissao(){
        System.out.println("\n ==== Missão ==== \n");
        System.out.println(" Nome da Missão: " + nome);
        System.out.println("Dificuldade da Missão: " + dificuldade);
        System.out.println("Nome do Herói: " + heroi.getNome());
    }

    /*
   O método concluirMissao primeiro verifica se a missão já foi concluída, caso já tenha sido, ele avisa o usuário e usa o return para encerrar o método,
   assim o herói não evolui duas vezes com a mesma missão.
   Depois é utilizado um if e else if pela dificuldade, onde cada dificuldade chama um evoluir diferente e define a recompensa em ouro:
   Fácil chama o evoluir() e recebe 50 de ouro, Médio chama o evoluir(5) e recebe 250 de ouro, e Difícil chama o evoluir(10) e recebe 500 de ouro.
   Em todas elas a missão é registrada na academia pelo registrarMissaoConcluida() e marcada como concluída.
    */
    public void concluirMissao(){
        if(concluida){
            System.out.println("Essa missão já foi concluída. ");
            return;
        }

        if (dificuldade.equalsIgnoreCase("Fácil")){
            heroi.evoluir();
            recompensaOuro = 50;
            System.out.println("você recebeu de recompensa: " + recompensaOuro + " de ouro");
            academiaDeHerois.registrarMissaoConcluida();
            concluida = true;
        } else if (dificuldade.equalsIgnoreCase("Médio")) {
            heroi.evoluir(5);
            recompensaOuro = 250;
            System.out.println("você recebeu de recompensa: " + recompensaOuro + " de ouro");
            academiaDeHerois.registrarMissaoConcluida();
            concluida = true;
        }else if (dificuldade.equalsIgnoreCase("Difícil")){
            heroi.evoluir(10);
            recompensaOuro = 500;
            System.out.println("você recebeu de recompensa: " + recompensaOuro + " de ouro");
            academiaDeHerois.registrarMissaoConcluida();
            concluida = true;
        }else {
            System.out.println("As dificuldades disponíveis são: Fácil, Médio e Difícil. ");
        }
    }
}
