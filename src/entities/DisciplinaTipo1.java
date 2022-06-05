package src.entities;

import java.util.Scanner;

public class DisciplinaTipo1 extends Disciplina{

    private final double pp;
    private final double pf;

    public DisciplinaTipo1(String nome, String professor, int codigo, int periodo, int ano, int creditos, int semestre,
                           double pp, double pf) {
        super(nome, professor, codigo, periodo, ano, creditos, semestre);
        this.pp = pp;
        this.pf = pf;
    }

    @Override
    public void ler() {

    }

    @Override
    public double media() {
        return (pp + 2*pf)/3;
    }

    public double getPp() {
        return pp;
    }

    public double getPf() {
        return pf;
    }

    static Disciplina makeDisciplinaTipo1(Scanner input, int codigo, String nome, String professor, int periodo,
                                                  int ano, int semestre, int creditos) {
        System.out.println("Informe o valor da PP");
        double pp = input.nextDouble();
        System.out.println("Informe o valor da PF");
        double pf = input.nextDouble();
        return new DisciplinaTipo1(nome, professor, codigo, periodo, ano, creditos, semestre, pp, pf);
    }
}
