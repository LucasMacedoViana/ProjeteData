package dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return LocalDate.now().getYear() - dataNascimento.getYear();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataNascimento.format(formatter);
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataFormatada +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pessoa pessoa = (Pessoa) obj;
        return nome.equals(pessoa.nome) && dataNascimento.equals(pessoa.dataNascimento);
    }

    @Override
    public int hashCode() {
        return nome.hashCode() + dataNascimento.hashCode();
    }
}
