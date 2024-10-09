package org.example.versao02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;


public class App {

    public static void main(String[] args) {
        // Criação da janela principal
        JFrame frame = new JFrame("Calculo de ICMS - v1.0");
        frame.setSize(500, 390); // Largura e altura da tela (aumentei para caber as informações do autor e
        // versão)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Para usar coordenadas absolutas

        // Centralizar a janela
        frame.setLocationRelativeTo(null);

        // Campo para valor do produto
        JLabel lblProduto = new JLabel("Valor do Produto: R$");
        lblProduto.setBounds(20, 20, 250, 25);
        frame.add(lblProduto);

        JTextField txtProduto = new JTextField();
        txtProduto.setBounds(170, 20, 250, 25);
        frame.add(txtProduto);

        // Campo para percentual do ICMS
        JLabel lblIcms = new JLabel("Perc(%) do ICMS:");
        lblIcms.setBounds(20, 60, 250, 25);
        frame.add(lblIcms);

        JTextField txtIcms = new JTextField();
        txtIcms.setBounds(170, 60, 250, 25);
        frame.add(txtIcms);

        // Botão de calcular
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(170, 100, 100, 25);
        frame.add(btnCalcular);

        // Campo de resultado
        JTextArea txtResultado = new JTextArea();
        txtResultado.setBounds(20, 140, 400, 100);
        txtResultado.setEditable(false);
        frame.add(txtResultado);

        // Botão de limpar
        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(320, 100, 100, 25);
        frame.add(btnLimpar);

        // Exibir autor e versão
        JLabel lblAutor = new JLabel("Autor: Ari Junior | Versao: 1.0");
        lblAutor.setBounds(20, 300, 300, 25); // Posicionado na parte inferior da janela
        frame.add(lblAutor);

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
                            String.format("Base do ICMS de Substituição: %s%n", nf.format(baseSubstituicao)) +
                            String.format("ICMS de Substituição: %s%n", nf.format(icmsSubstituicao)) +
                            String.format("Valor de Substituição: %s%n", nf.format(valorSubstituicao));

                    txtResultado.setText(resultado);

                } catch (NumberFormatException ex) {
                    txtResultado.setText("Por favor, insira valores válidos.");
                }
            }
        });

        // Ação ao clicar no botão limpar
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpar todos os campos de texto
                txtProduto.setText("");
                txtIcms.setText("");
                txtResultado.setText("");
            }
        });

        // Tornar a janela visível
        frame.setVisible(true);
    }

    // Métodos para cálculos
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