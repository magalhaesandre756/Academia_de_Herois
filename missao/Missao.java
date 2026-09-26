package missao;

import academiadeherois.AcademiaDeHerois;
import herois.Heroi;

public class Missao {
    private String nome;
    private String dificuldade;
    private int recompensaOuro;
    private Heroi heroi;
    private boolean concluida;
    private AcademiaDeHerois academiaDeHerois;

    public String getDificuldade() {
        return dificuldade;
    }

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

    public Missao(String nome, String dificuldade, Heroi heroi, AcademiaDeHerois academiaDeHerois) {
        this.nome = nome;
        setDificuldade(dificuldade);
        this.heroi = heroi;
        this.academiaDeHerois= academiaDeHerois;
    }

    public void iniciarMissao(){
        System.out.println("\n ==== Missão ==== \n");
        System.out.println(" Nome da Missão: " + nome);
        System.out.println("Dificuldade da Missão: " + dificuldade);
        System.out.println("Nome do Herói: " + heroi.getNome());
    }
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
