package academiadeherois;

import herois.Heroi;

public class AcademiaDeHerois {
    /*
Esta classe é como um armazém, aqui ela importa a Classe Heroi para que seja possível fazer o cadastro dos heróis a partir daqui, listar os heróis que existem e
buscar os heróis pelo nome. Além disso, ela utiliza um array do tipo Heroi para guardar os heróis, onde é possível cadastrar no máximo 20 heróis.
Como o array é do tipo Heroi, ele consegue guardar Guerreiros, Magos e Arqueiros ao mesmo tempo (polimorfismo).
Também temos atributos específicos para esta classe, que são totalHerois e totalMissoesConcluidas, para controlar quantos heróis foram cadastrados
e para que no método relatorio seja possível mostrar a quantidade de heróis e de missões concluídas.
    */
    private Heroi[] herois = new Heroi[20];
    private int totalHerois, totalMissoesConcluidas;


    public int getTotalHerois() {
        return totalHerois;
    }


    public int getTotalMissoesConcluidas() {
        return totalMissoesConcluidas;
    }

    public void setTotalMissoesConcluidas(int totalMissoesConcluidas) {
        this.totalMissoesConcluidas = totalMissoesConcluidas;
    }

    /*
     Este método é onde o herói criado pelo usuário é cadastrado. Nele foi utilizado herois.length para buscar o tamanho máximo do array, e caso chegue nesse limite ele imprime na tela
     que foi atingido o limite. Caso contrário, é encaminhado para um else onde vai ser realizado o cadastro do herói na próxima posição livre do array, e esse herói será contabilizado no totalHerois.
         */
    public void cadastrarHerois(Heroi heroi) {
        if (totalHerois == herois.length) {
            System.out.println("Foi atingido o limite de 20 herois");
        } else {
            herois[totalHerois] = heroi;
            totalHerois++;
        }

    }
    /*
  Esse método é utilizado para listar todos os personagens imprimindo seus status. Foi utilizado um if para, caso não tenha nenhum herói cadastrado, avisar o usuário,
  e caso já tenha pelo menos um herói cadastrado, ele inicia um laço de repetição (for) para percorrer esses heróis cadastrados e imprimir os seus status utilizando o método
  exibirStats().
       */
    public void listarHerois() {
        if (totalHerois == 0) {
            System.out.println("Não há nenhum heroi cadastrado");
        } else {
            System.out.println("Os herois cadastardos sao: " );
            for (int i = 0; i < totalHerois; i++) {
                herois[i].exibirStats();
            }
        }
    }
    /*
        Esse método é utilizado para buscar informações de um herói específico quando for necessário. Ele utiliza um for para percorrer todos os heróis e o equalsIgnoreCase
        para validar se o que foi digitado pelo usuário corresponde a algum herói (sem diferenciar letras maiúsculas e minúsculas), e caso seja encontrado ele imprime o status do herói e retorna esse herói.
        Caso não seja encontrado nenhum herói, ele imprime que não foi encontrado e retorna null.
             */
    public Heroi buscarHeroiPeloNome(String nome){
        for (int i = 0 ; i < totalHerois; i++){
            if (herois[i].getNome().equalsIgnoreCase(nome)){
                System.out.println("\n Heroi encontrado: \n" );
                herois[i].exibirStats();
                return herois[i];
            }
        }
        System.out.println("Heroi não encontrado.");
        return null;
    }
    /*
      Esse método é utilizado para gerar um relatório completo da "partida", tendo nele as variáveis: totalGuerreiro para contabilizar quantos Guerreiros foram cadastrados
      na partida, totalMago e totalArqueiro que exercem a mesma função de contabilizar quantos heróis de sua respectiva classe possui. Além do somaNiveis, para mais embaixo realizar
      a média de todos os níveis presentes na "partida". Foi utilizado um for com if e else if para percorrer as classes cadastradas, utilizando o equals para comparar as Strings.
      Além disso, dentro desse for ocorre a soma dos níveis de cada herói utilizando o getNivel(), e temos outro if para descobrir quem é o herói mais forte,
      que faz uma comparação entre os pontos de combate dos heróis, através do método calcularPontosCombate(), para definir qual herói tem mais pontos de combate.
      Aquele com mais fica salvo na variável maisForte. Depois é feita a média dos níveis encontrados, e temos o relatório sendo impresso na tela do usuário.
      Esse método só deve ser chamado quando tiver pelo menos um herói cadastrado, por isso na Main é feita essa verificação antes de chamar o relatório.
           */
    public void relatorio() {
        int totalGuerreiro = 0;
        int totalMago = 0;
        int totalArqueiro = 0;
        int somaNiveis = 0;
        Heroi maisForte = herois[0];
        for (int i =0 ; i < totalHerois; i++){
            if (herois[i].getClasse().equals("Guerreiro")){
                totalGuerreiro++;
            } else if (herois[i].getClasse().equals("Mago")){
                totalMago++;
            } else if (herois[i].getClasse().equals("Arqueiro")) {
                totalArqueiro++;
            }
            somaNiveis += herois[i].getNivel();
            if (herois[i].calcularPontosCombate() > maisForte.calcularPontosCombate()) {
                maisForte = herois[i];
            }
        }
        double media = (double) somaNiveis /totalHerois;
        System.out.println("\n========= RELATÓRIO =========\n");
        System.out.println("Total de Heróis: " + totalHerois);
        System.out.println("Quantidade de Guerreiros: " + totalGuerreiro);
        System.out.println("Quantidade de Magos: " + totalMago);
        System.out.println("Quantidade de Arqueiros: " + totalArqueiro);
        System.out.println("Média de Nível: " + media);
        System.out.println("Herói mais forte: " + maisForte.getNome() + " Pontos De Combate: " + maisForte.calcularPontosCombate());
        System.out.println("Missões concluídas: " +totalMissoesConcluidas);
    }
    /*
  Esse método é utilizado apenas para registrar uma missão como concluída, somando essa missão no atributo totalMissoesConcluidas.
  Ele é chamado pela classe Missao quando o herói conclui uma missão.
       */
    public void registrarMissaoConcluida(){
        totalMissoesConcluidas++;
    }
}