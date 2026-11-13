# EcoConnect - PoC (Segunda Entrega)

## 📌 Problema
O descarte inadequado de resíduos recicláveis e eletrônicos gera poluição e reduz a eficiência da reciclagem urbana. A falta de informações centralizadas dificulta a localização de pontos de coleta adequados pela população[cite: 15].

## 🎯 Alinhamento com a ODS
* **ODS 12 - Consumo e Produção Responsáveis:** Promove a gestão ecologicamente correta dos resíduos e estimula a reciclagem por meio da localização acessível de pontos de coleta[cite: 15].

## 🛠️ Tecnologias Utilizadas
* **Linguagem:** Java 17 (LTS)[cite: 15]
* **Framework:** Spring Boot 3.2.3[cite: 3, 15]
* **Banco de Dados:** MongoDB (NoSQL)[cite: 15]
* **Testes Unitários:** JUnit 5 e Mockito[cite: 15]
* **Cobertura de Código:** JaCoCo (Mínimo de 70% exigido)[cite: 3, 11, 12, 15]

## 🚀 Como Executar o Projeto

### Pré-requisitos
* JDK 17 instalado[cite: 15]
* Maven (ou use o `./mvnw` incluso no projeto)[cite: 15]
* Instância do MongoDB em execução (`mongodb://localhost:27017/ecoconnect`)[cite: 15]

### Executando a Aplicação
No terminal, na pasta raiz do projeto, execute: bash
./mvnw spring-boot:run

## 🧪 Execução de Testes e Cobertura (JaCoCo)
Para rodar todos os testes automatizados e gerar a evidência de cobertura exigida pelo professor ($\ge 70\%$)[cite: 11, 12]:bash
./mvnw clean test

Após a execução, o relatório detalhado em HTML estará disponível em:
> `target/site/jacoco/index.html`

---
Repositório oficial: https://github.com/roamorim2/ECOCONNECT-AEP-2026

