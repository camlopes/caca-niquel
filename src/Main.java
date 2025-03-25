import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        int saldo = 100;
        int aposta;
        int lucro;
        String[] simbolos = {};

        Scanner scanner = new Scanner(System.in);

        System.out.println("*************************");
        System.out.println("Bem vindo ao Caça-níquel ");
        System.out.println("Simbolos: 🍒 🍉 🍋 🔔 ⭐ ");
        System.out.println("*************************");

        while(saldo > 0){
            System.out.println("Valor atual do saldo: R$" + saldo);
            System.out.print("Digite um valor de aposta: ");
            aposta = scanner.nextInt();

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
            rodando();
        }

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
}
