package src.entities;

import java.util.Scanner;

import static src.entities.DisciplinaTipo1.makeDisciplinaTipo1;
import static src.entities.DisciplinaTipo2.makeDisciplinaTipo2;
import static src.entities.DisciplinaTipo3.makeDisciplinaTipo3;

public abstract class Disciplina {

    private final int codigo;
    private final String nome;
    private final String professor;
    private final int periodo;
    private final int ano;
    private final int creditos;
    private final int semestre;

    public Disciplina(String nome, String professor, int codigo, int periodo, int ano, int creditos, int semestre) {
        this.nome = nome;
        this.professor = professor;
        this.codigo = codigo;
        this.periodo = periodo;
        this.ano = ano;
        this.creditos = creditos;
        this.semestre = semestre;
    }

    public abstract void ler();
    public abstract double media();

    public String getNome() {
        return nome;
    }

    public String getProfessor() {
        return professor;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getPeriodo() {
        return periodo;
    }

    public int getAno() {
        return ano;
    }

    public int getCreditos() {
        return creditos;
    }

    public int getSemestre() {
        return semestre;
    }

    public static Disciplina disciplinaAdapt(Scanner input, int codigo) {
        input.nextLine();
        System.out.println("Informe o nome da disciplina");
        String nome = input.nextLine();
        System.out.println("Informe o nome do professor");
        String professor = input.nextLine();
        System.out.println("Informe o periodo da disciplina");
        int periodo = input.nextInt();
        System.out.println("Informe o ano da disciplina");
        int ano = input.nextInt();
        System.out.println("Informe o semestre da disciplina");
        int semestre = input.nextInt();
        System.out.println("Informe a quantidade de créditos");
        int creditos = input.nextInt();
        System.out.println("Informe o Tipo de Disciplina (1, 2 ou 3)");
        int tipo = input.nextInt();
        return getDisciplina(input, codigo, nome, professor, periodo, ano, semestre, creditos, tipo);
    }

    private static Disciplina getDisciplina(Scanner input, int codigo, String nome, String professor, int periodo,
                                            int ano, int semestre, int creditos, int tipo) {
        return switch (tipo) {
            case 1 -> makeDisciplinaTipo1(input, codigo, nome, professor, periodo, ano, semestre, creditos);
            case 2 -> makeDisciplinaTipo2(input, codigo, nome, professor, periodo, ano, semestre, creditos);
            case 3 -> makeDisciplinaTipo3(input, codigo, nome, professor, periodo, ano, semestre, creditos);
            default -> null;
        };
    }
}
