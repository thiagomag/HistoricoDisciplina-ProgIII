package src;

public abstract class Disciplina {

    private String nome;
    private String professor;
    private int codigo;
    private int periodo;
    private int ano;
    private int creditos;
    private int semestre;

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
}
