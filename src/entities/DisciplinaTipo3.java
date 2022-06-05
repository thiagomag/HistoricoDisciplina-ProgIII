package src.entities;

import java.util.Scanner;

public class DisciplinaTipo3 extends Disciplina {

    private final double notaApresentacao;
    private final double notaConteudo;
    private final double notaMonografia;
    private final double notaPratica;

    public DisciplinaTipo3(String nome, String professor, int codigo, int periodo, int ano, int creditos, int semestre,
                           double notaApresentacao, double notaConteudo, double notaMonografia, double notaPratica) {
        super(nome, professor, codigo, periodo, ano, creditos, semestre);
        this.notaApresentacao = notaApresentacao;
        this.notaConteudo = notaConteudo;
        this.notaMonografia = notaMonografia;
        this.notaPratica = notaPratica;
    }

    @Override
    public void ler() {

    }

    @Override
    public double media() {
        return (5*notaApresentacao + 2*notaConteudo + 2*notaMonografia + 6*notaPratica)/15;
    }

    static Disciplina makeDisciplinaTipo3(Scanner input, int codigo, String nome, String professor, int periodo,
                                          int ano, int semestre, int creditos) {
        System.out.println("Informe a nota de apresentaćão");
        double notaApresentacao = input.nextDouble();
        System.out.println("Informe a nota de conteudo");
        double notaConteudo = input.nextDouble();
        System.out.println("Informe a nota da monografia");
        double notaMonografia = input.nextDouble();
        System.out.println("informe a nota pratica");
        double notaPratica = input.nextDouble();
        return new DisciplinaTipo3(nome, professor, codigo, periodo, ano, semestre, creditos, notaApresentacao,
                notaConteudo, notaMonografia, notaPratica);
    }
}
