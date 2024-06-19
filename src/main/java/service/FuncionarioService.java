package service;

import dominio.Funcionario;
import dominio.Pessoa;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class FuncionarioService {
    // Variável estática para armazenar a lista de funcionários
    public static List<Pessoa> funcionarios = new ArrayList<>();

    // Método para remover o funcionário da lista pelo nome
    public static void removerFuncionario(String nome) {
        // Itera sobre a lista de funcionários e remove o funcionário com o nome especificado
        funcionarios.removeIf(pessoa -> pessoa instanceof Funcionario && pessoa.getNome().equals(nome));

        funcionarios.forEach(System.out::println);
    }

    // Método para aplicar aumento de 10% nos salários
    public static void aplicarAumentoSalarios(BigDecimal percentual) {
        for (Pessoa pessoa : funcionarios) {
            if (pessoa instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) pessoa;
                funcionario.aplicarAumento(percentual);
            }
        }

        funcionarios.forEach(System.out::println);
    }

    // Método para agrupar funcionários por função e retornar um Map
    public static Map<String, List<Funcionario>> agruparPorFuncao() {
        Map<String, List<Funcionario>> mapaFuncionariosPorFuncao = new HashMap<>();

        for (Pessoa pessoa : funcionarios) {
            if (pessoa instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) pessoa;
                String cargo = funcionario.getCargo();

                if (!mapaFuncionariosPorFuncao.containsKey(cargo)) {
                    mapaFuncionariosPorFuncao.put(cargo, new ArrayList<>());
                }

                mapaFuncionariosPorFuncao.get(cargo).add(funcionario);
            }
        }

        return mapaFuncionariosPorFuncao;
    }

    // Método para imprimir funcionários que fazem aniversário em determinados meses
    public static void imprimirAniversariantes(int... meses) {
        for (int mes : meses) {
            System.out.println("Funcionários que fazem aniversário no mês " + mes + ":");
            for (Pessoa pessoa : funcionarios) {
                if (pessoa instanceof Funcionario) {
                    Funcionario funcionario = (Funcionario) pessoa;
                    if (funcionario.fazAniversarioNoMes(mes)) {
                        System.out.println(funcionario);
                    }
                }
            }
            System.out.println();
        }
    }

    // Método para encontrar o funcionário com maior idade e imprimir nome e idade
    public static void imprimirFuncionarioMaisVelho() {
        Funcionario maisVelho = null;
        int idadeMaisVelho = Integer.MIN_VALUE;

        for (Pessoa pessoa : funcionarios) {
            if (pessoa instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) pessoa;
                int idade = funcionario.getIdade();

                if (idade > idadeMaisVelho) {
                    idadeMaisVelho = idade;
                    maisVelho = funcionario;
                }
            }
        }

        if (maisVelho != null) {
            System.out.println("Nome: " + maisVelho.getNome());
            System.out.println("Idade: " + idadeMaisVelho);
        } else {
            System.out.println("Não há funcionários na lista.");
        }
    }

    // Método para imprimir a lista de funcionários por ordem alfabética
    public static void imprimirFuncionariosOrdemAlfabetica() {
        List<Pessoa> funcionariosOrdenados = new ArrayList<>(funcionarios);
        funcionariosOrdenados.sort(Comparator.comparing(Pessoa::getNome));

        funcionariosOrdenados.forEach(System.out::println);
    }

    // Método para imprimir total dos salários dos funcionários
    public static void imprimirTotalSalarios() {
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Pessoa pessoa : funcionarios) {
            if (pessoa instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) pessoa;
                totalSalarios = totalSalarios.add(funcionario.getSalario());
            }
        }
        // Formatando o salário com separador de milhar (ponto) e decimal (vírgula)
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
        String totalSalariosFormatado = df.format(totalSalarios);
        System.out.println("Total dos salários: " + totalSalariosFormatado);
    }

    // Metodo para imprimir quantos salários mínimos ganha cada funcionário (valor base 1212.00)
    public static void imprimirSalariosMinimos() {
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        for (Pessoa pessoa : funcionarios) {
            if (pessoa instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) pessoa;
                BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
                System.out.println(funcionario.getNome() + " ganha " + salariosMinimos + " salários mínimos.");
            }
        }
    }
}
