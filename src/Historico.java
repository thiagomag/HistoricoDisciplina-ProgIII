package src;

import java.util.Objects;

public class Historico {

    private Disciplina[] listaDisciplina;
    private int qtd;

    public Historico(Disciplina[] listaDisciplina, Integer qtd) {
        this.listaDisciplina = listaDisciplina;
        this.qtd = qtd;
    }

    public void inserir(Disciplina disciplina) {
        this.listaDisciplina[qtd] = disciplina;
        qtd++;
    }

    public void remover(int codigo) {
        int pos = buscarIndice(codigo);
        if (pos >= 0) {
            listaDisciplina[pos] = listaDisciplina[qtd - 1];
            listaDisciplina[qtd - 1] = null;
            qtd--;
        }
    }

    public void alterar(int codigo, Disciplina disciplina) {
        int pos = buscarIndice(codigo);
        listaDisciplina[pos] = disciplina;
    }

    public int buscarIndice(int codigo) {
        int i = 0;
        boolean achou = false;
        while (!achou && i < qtd) {
            if (Objects.equals(listaDisciplina[i].getCodigo(), codigo)) {
                achou = true;
            } else {
                i++;
            }
        }
        return achou ? i : -1;
    }

    public double cr() {
        return 0.0;
    }

    public void mostrar() {
        for (Disciplina disciplina : listaDisciplina) {
            System.out.println("Código: " + disciplina.getCodigo() + ", nome: " + disciplina.getNome() +
                    ", periodo " + disciplina.getPeriodo() + ", créditos: " + disciplina.getCreditos() +
                    ", média final: " + disciplina.media());
        }
        System.out.println("CR: " + cr());
    }

    public void listar(int ano, int semestre) {
        for (Disciplina disciplina : listaDisciplina) {
            if ((ano == disciplina.getAno()) && (semestre == disciplina.getSemestre())) {
                System.out.println("Código: " + disciplina.getCodigo() + ", nome: " + disciplina.getNome() +
                        ", periodo " + disciplina.getPeriodo() + ", créditos: " + disciplina.getCreditos() +
                        ", média final: " + disciplina.media());
            }
        }
    }
}
