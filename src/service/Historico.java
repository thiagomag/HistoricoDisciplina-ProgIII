package src.service;

import src.entities.Disciplina;

import java.util.Objects;

public class Historico {

    private Disciplina[] listaDisciplina;
    private int qtd;

    public Historico() {
        this.listaDisciplina = new Disciplina[100];
        this.qtd = 0;
    }

    public void inserir(Disciplina disciplina) {
        this.listaDisciplina[qtd] = disciplina;
        qtd++;
    }

    public boolean existeCodigo(int codigo) {
        for (int i = 0; i < this.qtd; i++) {
            if (codigo == listaDisciplina[i].getCodigo()) {
                return true;
            }
        }
        return false;
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
        double cr = 0.0;
        int creditos = 0;
        for (int i = 0; i < qtd; i++) {
            creditos += listaDisciplina[i].getCreditos();
            cr += (listaDisciplina[i].getCreditos() * listaDisciplina[i].media());
        }
        return cr/creditos;
    }

    public void mostrar() {
        for (int i = 0; i < qtd; i++) {
            System.out.println("Código: " + listaDisciplina[i].getCodigo() + ", nome: " + listaDisciplina[i].getNome() +
                    ", professor: " + listaDisciplina[i].getProfessor() + ", periodo " + listaDisciplina[i].getPeriodo() +
                    ", créditos: " + listaDisciplina[i].getCreditos() +
                    ", média final: " + String.format("%.2f", listaDisciplina[i].media()));
        }
        System.out.println("CR: " + String.format("%.2f", cr()));
    }

    public void listar(int ano, int semestre) {
        for (int i = 0; i < qtd; i++) {
            if ((ano == listaDisciplina[i].getAno()) && (semestre == listaDisciplina[i].getSemestre())) {
                System.out.println("Código: " + listaDisciplina[i].getCodigo() + ", nome: " + listaDisciplina[i].getNome() +
                        ", periodo " + listaDisciplina[i].getPeriodo() + ", créditos: " + listaDisciplina[i].getCreditos() +
                        ", média final: " + String.format("%.2f", listaDisciplina[i].media()));
            }
        }
    }
}