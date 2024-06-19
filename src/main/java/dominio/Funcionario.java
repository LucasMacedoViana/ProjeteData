package dominio;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String cargo;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String cargo) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = getDataNascimento().format(formatter);

        // Formatando o salário com separador de milhar (ponto) e decimal (vírgula)
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
        String salarioFormatado = df.format(salario);

        return
                "nome:'" + getNome() + '\'' +
                        ", dataNascimento:" + dataFormatada +
                        ", salario: R$ " + salarioFormatado +
                        ", cargo: '" + cargo + '\'';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Funcionario that = (Funcionario) obj;
        return salario.equals(that.salario) && cargo.equals(that.cargo);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + salario.hashCode() + cargo.hashCode();
    }

    // Método para aplicar aumento de 10% no salário
    public void aplicarAumento(BigDecimal percentual) {
        BigDecimal aumento = salario.multiply(percentual.divide(BigDecimal.valueOf(100)));
        salario = salario.add(aumento);
    }

    // Método para verificar se o funcionário faz aniversário em um mês específico
    public boolean fazAniversarioNoMes(int mes) {
        return getDataNascimento().getMonthValue() == mes;
    }
}
