
---

# Calculadora de ICMS e Substituição Tributária - Versão 1.0

Este é um aplicativo Java simples que realiza o cálculo do ICMS (Imposto sobre Circulação de Mercadorias e Serviços) e a Substituição Tributária (ST). O programa permite que o usuário insira o valor de um produto e o percentual do ICMS, calculando automaticamente o valor do ICMS, a base de substituição, o ICMS de substituição e o valor total da substituição.

## Funcionalidades

- Cálculo do ICMS com base no valor do produto e percentual fornecido.
- Cálculo da base de substituição tributária (com uma margem de 55% sobre o valor do produto).
- Cálculo do ICMS de substituição.
- Cálculo do valor final de substituição tributária.

## Como funciona

O programa solicita ao usuário que insira:
1. O valor do produto (em reais).
2. O percentual de ICMS (apenas números).

Com base nessas entradas, o programa realiza os seguintes cálculos:
- Valor do ICMS: `valorProduto * percentualIcms / 100`
- Base de Substituição Tributária: `valorProduto + 55%`
- ICMS de Substituição: `BaseSubstituicao * percentualIcms / 100`
- Valor de Substituição Tributária: `ICMS de Substituição - Valor ICMS`

## Exemplo de Execução

```bash
Digite o valor do produto: R$ 100.00
Digite o % do ICMS (somente números): 18

Valor do ICMS: R$ 18.00
Base do ICMS de Substituição: R$ 155.00
ICMS de Substituição: R$ 27.90
Valor de Substituição: R$ 9.90
```

## Requisitos

- Java 17 ou superior

## Como Executar

1. Clone ou faça o download deste repositório.
2. Compile o código usando um IDE ou a linha de comando:
   ```bash
   javac App.java
   ```
3. Execute o programa:
   ```bash
   java App
   ```

## Estrutura do Código

O código principal está contido na classe `App` e utiliza métodos auxiliares para calcular o ICMS e a Substituição Tributária:
- `calcularIcms`: Calcula o valor do ICMS.
- `calcularBaseSubstituicao`: Calcula a base de substituição tributária (adicionando 55% ao valor do produto).
- `calcularIcmsSubstituicao`: Calcula o valor do ICMS de substituição com base na nova base de substituição.
- `calcularValorSubstituicao`: Calcula o valor final da substituição tributária.

## Melhorias Futuras

- Adicionar uma interface gráfica para facilitar o uso.
- Permitir a entrada de outros impostos ou margens diferentes.
- Implementar testes unitários para garantir a confiabilidade dos cálculos.

## Contribuição

Sinta-se à vontade para fazer um fork deste projeto, abrir issues ou pull requests para melhorias e correções.

## Licença

Este projeto está sob a licença MIT. Consulte o arquivo LICENSE para mais detalhes.


## Autor
Este projeto foi desenvolvido por **Ari Junior**

- **LinkedIn:** https://www.linkedin.com/in/arijunior09/
- **GitHub:** https://github.com/AriJunior09

---