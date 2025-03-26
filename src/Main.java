import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        int saldo = 100;
        int aposta;
        int lucro;
        String[] simbolosSorteados = {};
        String jogarNovamente;

        Scanner scanner = new Scanner(System.in);

        System.out.println("*************************");
        System.out.println("Bem vindo ao Caça-níquel ");
        System.out.println("Simbolos: 🍒 🍉 🍋 🔔 ⭐ ");
        System.out.println("*************************");

        while(saldo > 0){
            System.out.println("Valor atual do saldo: R$" + saldo);
            System.out.print("Digite um valor de aposta: ");
            aposta = scanner.nextInt();
            scanner.nextLine();

            if(aposta > saldo){
                System.out.println("Saldo insuficiente");
                continue;
            } else if(aposta <= 0){
                System.out.println("Aposta deve ser maior que 0");
                continue;
            } else {
                saldo -= aposta;
            }

            System.out.println("Rodando...");
            simbolosSorteados = rodando();
            printRodada(simbolosSorteados);
            lucro = getLucro(simbolosSorteados, aposta);

            if(lucro > 0){
                System.out.println("Voce ganhou $" + lucro);
                saldo += lucro;
            } else {
                System.out.println("Voce perdeu essa rodada");
            }

            System.out.print("Voce quer jogar novamente? (s/n): ");
            jogarNovamente = scanner.nextLine().toLowerCase();

            if(!jogarNovamente.equals("s")) {
                break;
            }
        }

        System.out.println("GAME OVER! Seu saldo final é R$" + saldo);

        scanner.close();
    }

    static String[] rodando(){
        String[] simbolos = {"🍒", "🍉", "🍋", "🔔", "⭐"};
        String[] rodada = new String[3];
        Random random = new Random();

        for(int i = 0; i < 3; i++){
            rodada[i] = simbolos[random.nextInt(simbolos.length)];
        }

        return rodada;
    }

    static void printRodada(String[] simbolosSorteados){
        System.out.println("**************");
        System.out.println(" " + String.join(" | ", simbolosSorteados));
        System.out.println("**************");
    }

    static int getLucro(String[] simbolosSorteados, int aposta){

        if(simbolosSorteados[0].equals(simbolosSorteados[1]) && simbolosSorteados[1].equals(simbolosSorteados[2])){
            return switch(simbolosSorteados[0]){
                case "🍒" -> aposta * 3;
                case "🍉" -> aposta * 4;
                case "🍋" -> aposta * 5;
                case "🔔" -> aposta * 10;
                case "⭐" -> aposta * 20;
                default -> 0;
            };
        } else if(simbolosSorteados[0].equals(simbolosSorteados[1])){
            return switch(simbolosSorteados[0]){
                case "🍒" -> aposta * 2;
                case "🍉" -> aposta * 3;
                case "🍋" -> aposta * 4;
                case "🔔" -> aposta * 5;
                case "⭐" -> aposta * 10;
                default -> 0;
            };
        } else if(simbolosSorteados[1].equals(simbolosSorteados[2])){
            return switch(simbolosSorteados[1]){
                case "🍒" -> aposta * 2;
                case "🍉" -> aposta * 3;
                case "🍋" -> aposta * 4;
                case "🔔" -> aposta * 5;
                case "⭐" -> aposta * 10;
                default -> 0;
            };
        } else if(simbolosSorteados[0].equals(simbolosSorteados[2])) {
            return switch (simbolosSorteados[0]) {
                case "🍒" -> aposta * 2;
                case "🍉" -> aposta * 3;
                case "🍋" -> aposta * 4;
                case "🔔" -> aposta * 5;
                case "⭐" -> aposta * 10;
                default -> 0;
            };
        }
        return 0;
    }
}
