package src;

public class DisciplinaTipo2 extends DisciplinaTipo1 {


    public DisciplinaTipo2(String nome, String professor, int codigo, int periodo, int ano, int creditos, int semestre,
                           double pp, double pf) {
        super(nome, professor, codigo, periodo, ano, creditos, semestre, pp, pf);
    }

    @Override
    public double media() {
        return (getPp() + getPf())/2;
    }
}
