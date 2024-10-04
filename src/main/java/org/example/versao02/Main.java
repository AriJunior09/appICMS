package org.example.versao02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
/**
 * Main.java
 * Esta classe é responsável por calcular o ICMS e a base de substituição
 * para produtos, considerando o valor do produto e o percentual do ICMS.
 *
 * @author Ari Junior
 * @version 2.0
 * @since 2024-10-03
 */
public class Main {



    public static void main(String[] args) {
        // Criação da janela principal
        JFrame frame = new JFrame("Calculo de ICMS");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);  // Para usar coordenadas absolutas

        // Campo para valor do produto
        JLabel lblProduto = new JLabel("Valor do Produto: R$");
        lblProduto.setBounds(20, 20, 150, 25);
        frame.add(lblProduto);

        JTextField txtProduto = new JTextField();
        txtProduto.setBounds(170, 20, 150, 25);
        frame.add(txtProduto);

        // Campo para percentual do ICMS
        JLabel lblIcms = new JLabel("% do ICMS:");
        lblIcms.setBounds(20, 60, 150, 25);
        frame.add(lblIcms);

        JTextField txtIcms = new JTextField();
        txtIcms.setBounds(170, 60, 150, 25);
        frame.add(txtIcms);

        // Botão de calcular
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 100, 100, 25);
        frame.add(btnCalcular);

        // Campo de resultado
        JTextArea txtResultado = new JTextArea();
        txtResultado.setBounds(20, 140, 350, 100);
        txtResultado.setEditable(false);
        frame.add(txtResultado);

        // Ação ao clicar no botão calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Substituir vírgula por ponto antes da conversão
                    double valorProduto = Double.parseDouble(txtProduto.getText().replace(',', '.'));
                    double percentualIcms = Double.parseDouble(txtIcms.getText().replace(',', '.'));

                    double valorIcms = calcularIcms(valorProduto, percentualIcms);
                    double baseSubstituicao = calcularBaseSubstituicao(valorProduto);
                    double icmsSubstituicao = calcularIcmsSubstituicao(baseSubstituicao, percentualIcms);
                    double valorSubstituicao = calcularValorSubstituicao(icmsSubstituicao, valorIcms);

                    // Formatando o valor em reais
                    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

                    String resultado = String.format("Valor do ICMS: %s%n", nf.format(valorIcms)) +
                            String.format("Base do ICMS de Substituicao: %s%n", nf.format(baseSubstituicao)) +
                            String.format("ICMS de Substituicao: %s%n", nf.format(icmsSubstituicao)) +
                            String.format("Valor de Substituicao: %s%n", nf.format(valorSubstituicao));

                    txtResultado.setText(resultado);

                } catch (NumberFormatException ex) {
                    txtResultado.setText("Por favor, insira valores validos.");
                }
            }
        });

        // Tornar a janela visível
        frame.setVisible(true);
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
}