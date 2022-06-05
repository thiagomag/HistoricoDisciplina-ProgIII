package src.entities;

import java.util.Scanner;

public class DisciplinaTipo2 extends DisciplinaTipo1 {

    public DisciplinaTipo2(String nome, String professor, int codigo, int periodo, int ano, int creditos, int semestre,
                           double pp, double pf) {
        super(nome, professor, codigo, periodo, ano, creditos, semestre, pp, pf);
    }

    @Override
    public double media() {
        return (getPp() + getPf())/2;
    }

    static Disciplina makeDisciplinaTipo2(Scanner input, int codigo, String nome, String professor, int periodo,
                                          int ano, int semestre, int creditos) {
        System.out.println("Informe o valor da PP");
        double pp2 = input.nextDouble();
        System.out.println("Informe o valor da PF");
        double pf2 = input.nextDouble();
        return new DisciplinaTipo2(nome, professor, codigo, periodo, ano, creditos, semestre, pp2, pf2);
    }
}
