package org.example;

import java.util.Scanner;

public class App {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.println();
      System.out.print("Digite o valor do produto:R$ ");
      double valorProduto = scanner.nextDouble();
      System.out.print("Digite o % do ICMS (somente numeros): ");
      double percentualIcms = scanner.nextDouble();

      double valorIcms = calcularIcms(valorProduto, percentualIcms);
      double baseSubstituicao = calcularBaseSubstituicao(valorProduto);
      double icmsSubstituicao = calcularIcmsSubstituicao(baseSubstituicao, percentualIcms);
      double valorSubstituicao = calcularValorSubstituicao(icmsSubstituicao, valorIcms);

      System.out.printf("\nValor do ICMS: R$ %.2f%n", valorIcms);
      System.out.printf("Base do ICMS de Substituicao: R$ %.2f%n", baseSubstituicao);
      System.out.printf("ICMS de Substituicao: R$ %.2f%n", icmsSubstituicao);
      System.out.printf("Valor de Substituicao: R$ %.2f%n", valorSubstituicao);
      /* 
      System.out.println();
      System.out.println();
      System.out.println();

      System.out.println("\nO calculo eh feito assim:");
      System.out.println("[Base Substituicao Tributaria] = valorProduto + 55%");
      System.out.println("[ICMS Substituicao]            = [Base Substituicao Tributaria] x percentualIcms");
      System.out.println("[Valor Substituicao Tributaria] = [ICMS Substituicao] - valorIcms");
      */
      scanner.close();
   }

   public static double calcularIcms(double valorProduto, double percentualIcms) {
      return valorProduto * percentualIcms / 100.0;
   }

   public static double calcularBaseSubstituicao(double valorProduto) {
      return valorProduto + valorProduto * 55.0 / 100.0;
   }

   public static double calcularIcmsSubstituicao(double baseSubstituicao, double percentualIcms) {
      return baseSubstituicao * percentualIcms / 100.0;
   }

   public static double calcularValorSubstituicao(double icmsSubstituicao, double valorIcms) {
      return icmsSubstituicao - valorIcms;
   }

   public static double calculadoraIcms2(double valorProduto, double percentualIcms) {
      return valorProduto * percentualIcms;
   }
}
