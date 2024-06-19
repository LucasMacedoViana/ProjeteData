package org.example;
import dominio.Funcionario;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import static service.FuncionarioService.*;

public class Main {
    public static void main(String[] args) {
        // Adicionando os funcionários à lista
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 10), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995,1,5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999,11,19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993,3,31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994,7,8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003,5,24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996,9,2), new BigDecimal("2799.93"), "Gerente"));

        System.out.println("Lista de funcionários Original:");
        funcionarios.forEach(System.out::println);

        // Removendo o funcionário "João" da lista
        System.out.println("\nLista de funcionários após a remoção:");
        removerFuncionario("João");

        // Aplicando aumento de 10% nos salários
        System.out.println("\nLista de funcionários após o aumento de salários:");
        aplicarAumentoSalarios(new BigDecimal("10"));


        // Agrupando os funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = agruparPorFuncao();
        System.out.println("\nFuncionários agrupados por função:");
        funcionariosPorFuncao.forEach((cargo, lista) -> {
            System.out.println("Funcionários do cargo de " + cargo + ":");
            lista.forEach(System.out::println);
            System.out.println();
        });

        // Imprimindo funcionários que fazem aniversário em determinados meses
        System.out.println("\nFuncionários que fazem aniversário em Outubro e Dezembro:");
        imprimirAniversariantes(10, 12);

        // Imprimindo o funcionário mais velho
        System.out.println("\nFuncionário mais velho:");
        imprimirFuncionarioMaisVelho();

        // Imprimindo a lista de funcionários em ordem alfabética
        System.out.println("\nLista de funcionários em ordem alfabética:");
        imprimirFuncionariosOrdemAlfabetica();

        // Imprimindo o total dos salários dos funcionários
        System.out.println("\nTotal dos salários dos funcionários:");
        imprimirTotalSalarios();

        // Imprimindo quantos salários mínimos ganha cada funcionário
        System.out.println("\nQuantos salários mínimos ganha cada funcionário:");
        imprimirSalariosMinimos();
    }
}
