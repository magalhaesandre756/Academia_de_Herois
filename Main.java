import academiadeherois.AcademiaDeHerois;
import arqueiro.Arqueiro;
import guerreiro.Guerreiro;
import herois.Heroi;
import mago.Mago;
import missao.Missao;
import java.util.Scanner;

public class Main {
    /*
   Esta é a classe principal do projeto, é aqui que o programa começa. Ela é responsável pela interação com o usuário, mostrando o menu,
   lendo as escolhas pelo Scanner e chamando os métodos da AcademiaDeHerois e da Missao.
    */

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       AcademiaDeHerois academia= new AcademiaDeHerois();

       /*
       A variável opcao começa com -1 para conseguir entrar no while, pois se começasse com 0 o laço nem iria rodar.
        */

       int opcao = -1;
        System.out.println("Academia de Heróis do Reino de Arcádia");
        System.out.println("Prepare-se para salvar o mundo");

        /*
        Aqui é o laço de repetição do menu, ele fica repetindo até o usuário digitar 0 para sair.
        Depois de cada nextInt() é utilizado um sc.nextLine() para consumir o Enter que sobra, senão o próximo nextLine() seria pulado.
         */

       while (opcao != 0 ){
           System.out.println("\n===== MENU =====");
           System.out.println("1. Cadastrar Herói");
           System.out.println("2. Listar Heróis");
           System.out.println("3. Buscar Herói pelo nome");
           System.out.println("4. Exibir estatísticas gerais");
           System.out.println("5. Iniciar Missão");
           System.out.println("0. Sair");
           System.out.print("Escolha: ");
           opcao = sc.nextInt();
           sc.nextLine();

           switch (opcao){
               /*
               No cadastro o usuário digita apenas o nome, e depois escolhe a classe por um menu de seleção.
               Dependendo do número escolhido, é criado um objeto da SubClasse correspondente (Guerreiro, Mago ou Arqueiro),
               e esse herói é enviado para a academia pelo método cadastrarHerois.
                */

               case 1:
                   System.out.println("Digite o nome do personagem");
                   String nome = sc.nextLine();

                   System.out.println("Selecione a classe do herói");
                   System.out.println("1. Guerreiro");
                   System.out.println("2. Mago");
                   System.out.println("3. Arqueiro");
                   System.out.println("Escolha: ");
                   int classe = sc.nextInt();
                   sc.nextLine();

                   switch (classe){
                       case 1:
                           academia.cadastrarHerois(new Guerreiro(nome));
                           System.out.println(nome + " foi cadastrado como Guerreiro.");
                           break;
                       case 2:
                           academia.cadastrarHerois(new Mago(nome));
                           System.out.println(nome + " foi cadastrado como Mago.");
                           break;
                       case 3:
                           academia.cadastrarHerois(new Arqueiro(nome));
                           System.out.println(nome + " foi cadastrado como Arqueiro");
                           break;
                       default:
                           System.out.println("Classe inválida. Herói não cadastrado.");
                   }
                   break;
               // Aqui é chamado o método da academia que lista todos os heróis cadastrados.
               case 2:
                   academia.listarHerois();
                   break;
               // Aqui o usuário digita o nome e a academia busca o herói, mostrando os seus status caso seja encontrado
               case 3:
                   System.out.print("Digite o nome do herói a ser procurado: ");
                   String nomeBusca = sc.nextLine();
                   academia.buscarHeroiPeloNome(nomeBusca);
                   break;
               /*
               Aqui é exibido o relatório com as estatísticas gerais. Antes é verificado se existe algum herói cadastrado,
               pois sem nenhum herói o relatório iria quebrar ao tentar pegar o herói mais forte e ao dividir a média por 0.
                */
               case 4:
                   if (academia.getTotalHerois() == 0){
                       System.out.println("Não há herói antes cadastrado para gerar o relatorio.");
                   } else {
                       academia.relatorio();
                   }
                   break;
                /*
               Aqui é feita a missão. Primeiro é verificado se existe algum herói cadastrado, depois o usuário digita o nome do herói,
               e caso a busca retorne null (herói não encontrado) a missão não é criada.
               A dificuldade é escolhida por um menu numérico, assim o usuário não precisa digitar o texto, e não tem como chegar
               uma dificuldade inválida na classe Missao. Depois a missão é criada, iniciada e concluída.
                */
               case 5:
                   if (academia.getTotalHerois() == 0){
                       System.out.println("Cadastre um heroi antes de iniciar uma missão.");
                       break;
                   }
                   System.out.println("Digite o nome do herói que fará a missão: ");
                   String nomeHeroi = sc.nextLine();
                   Heroi heroiEscolhido = academia.buscarHeroiPeloNome(nomeHeroi);

                   if (heroiEscolhido == null){
                       break;
                   }

                   System.out.println("Digite o nome da missão: ");
                   String nomeMissão = sc.nextLine();

                   System.out.println("Selecione a dificuldade: ");
                   System.out.println("1. Fácil");
                   System.out.println("2. Médio");
                   System.out.println("3. Difícil");
                   System.out.print("Escolha: ");
                   int nivelDificuldade = sc.nextInt();
                   sc.nextLine();

                   String dificuldade;
                   if (nivelDificuldade == 1){
                       dificuldade = "Fácil";
                   } else if (nivelDificuldade == 2) {
                       dificuldade = "Médio";
                   } else if (nivelDificuldade == 3) {
                       dificuldade = "Difícil";
                   }else {
                       System.out.println("Dificuldade inválida. Missão cancelada.");
                       break;
                   }

                   Missao missao = new Missao(nomeMissão, dificuldade, heroiEscolhido, academia);
                   missao.iniciarMissao();
                   missao.concluirMissao();
                   break;
               case 0:
                   System.out.println("Encerrando a Academia");
                   break;
               // O default é chamado quando o usuário digita um número que não existe no menu.
               default:
                   System.out.println("Opção invélida.");


           }
       }
        /*
        Quando o usuário sai do menu, é exibido o relatório final, como pede o enunciado. Também é verificado se existe herói cadastrado antes.
         */
        if (academia.getTotalHerois() == 0){
            System.out.println("Não há herói antes cadastrado para gerar o relatorio.");
        } else {
            academia.relatorio();
        }
        sc.close();


    }
}
