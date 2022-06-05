package src;

import src.entities.Disciplina;
import src.service.Historico;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Historico historico = new Historico();
        menu(historico);
    }

    private static void menu(Historico historico) throws InterruptedException {
        int n;
        do {
            System.out.println(
                    """
                    1 - Adicionar uma disciplina
                    2 - Mostrar histórico
                    3 - Mostrar CR
                    4 - Listar Disciplinas de uma ano/semestre
                    5 - Apagar uma disciplina
                    6 - Alterar disciplina
                    0 - Sair""");
            Scanner input = new Scanner(System.in);
            n = input.nextInt();
            switch (n) {
                case 1 -> {
                    input.nextLine();
                    System.out.println("Informe o código da disciplina");
                    int codigo = input.nextInt();
                    if (historico.existeCodigo(codigo)) {
                        System.out.println("Disciplina já cadastrada");
                    } else {
                        historico.inserir(Disciplina.disciplinaAdapt(input, codigo));
                    }
                    Thread.sleep(2000);
                }
                case 2 -> {
                    historico.mostrar();
                    Thread.sleep(2000);
                }
                case 3 -> {
                    System.out.printf("Cr: %.2f\n", historico.cr());
                    Thread.sleep(2000);
                }
                case 4 -> {
                    System.out.println("Informe o ano da disciplina");
                    int ano = input.nextInt();
                    System.out.println("Informe o semestre da disciplina");
                    int semestre = input.nextInt();
                    historico.listar(ano, semestre);
                    Thread.sleep(2000);
                }
                case 5 -> {
                    System.out.println("Informe o código da disciplina");
                    int codigo = input.nextInt();
                    if (historico.existeCodigo(codigo)) {
                        historico.remover(codigo);
                    } else {
                        System.out.println("Disciplina não cadastrada");
                    }
                    Thread.sleep(2000);
                }
                case 6 -> {
                    System.out.println("Informe o código da disciplina que será alterada");
                    int codigo = input.nextInt();
                    if (historico.existeCodigo(codigo)) {
                        System.out.println("Informe os novos dados:");
                        Disciplina disciplina = Disciplina.disciplinaAdapt(input, codigo);
                        historico.alterar(codigo, disciplina);
                    } else {
                        System.out.println("Disciplina não cadastrada");
                    }
                    Thread.sleep(2000);
                }
                default -> System.out.println("Informe uma opção valida");
            }
        } while (n != 0);
    }
}