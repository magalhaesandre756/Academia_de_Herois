import academiadeherois.AcademiaDeHerois;
import arqueiro.Arqueiro;
import guerreiro.Guerreiro;
import herois.Heroi;
import mago.Mago;
import missao.Missao;

public class Main {
    public static void main(String[] args) {

       AcademiaDeHerois heroi= new AcademiaDeHerois();
       heroi.cadastrarHerois(new Guerreiro("G"));
       heroi.cadastrarHerois(new Arqueiro("Legolas"));
       heroi.cadastrarHerois(new Mago("Destroyer"));
       heroi.cadastrarHerois(new Guerreiro("brutus"));
       heroi.buscarHeroiPeloNome("Legolas");
       heroi.buscarHeroiPeloNome("destroyer");

       Missao teste = new Missao("Cave", "Fácil", heroi.buscarHeroiPeloNome("G"), heroi );
       teste.iniciarMissao();
       teste.concluirMissao();

       Missao teste1 = new Missao("Macaraca", "Difícil", heroi.buscarHeroiPeloNome("Legolas"), heroi);

       heroi.relatorio();
       teste1.iniciarMissao();
       teste1.concluirMissao();
       heroi.buscarHeroiPeloNome("G");
       heroi.relatorio();
       heroi.buscarHeroiPeloNome("Legolas");



    }
}
