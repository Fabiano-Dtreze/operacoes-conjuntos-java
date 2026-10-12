# ☕ Operações com Conjuntos em Java

Versão em **Java** do programa de operações com conjuntos, desenvolvida como aprofundamento do trabalho original em Python.

## 📌 Objetivo

Implementar as operações de conjuntos **sem usar os métodos nativos** das coleções Java (`Set`), aplicando laços e condicionais, e comparar cada resultado com a solução nativa.

## ⚙️ Operações Implementadas

| Operação | Notação | Implementação manual | Solução nativa |
|---|---|---|---|
| Pertinência | x ∈ A | `pertence(x, A)` | `A.contains(x)` |
| União | A ∪ B | `uniao(A, B)` | `uniaoNativo(A, B)` |
| Interseção | A ∩ B | `interseccao(A, B)` | `interseccaoNativo(A, B)` |
| Diferença | A − B | `diferenca(A, B)` | `diferencaNativo(A, B)` |
| Diferença Simétrica | A △ B | `diferencaSimetrica(A, B)` | `diferencaSimetricaNativo(A, B)` |
| Inclusão | A ⊆ B | `estaContido(A, B)` | `B.containsAll(A)` |
| Cardinalidade | \|A\| | `cardinalidade(A)` | `A.stream().distinct().count()` |

## 🧠 Diferenças em relação ao Python

- **Tipagem estática:** declaração de tipos em todas as variáveis
- **Comparação de Strings:** uso de `.equals()` em vez de `==`
- **Orientação a objetos:** todo código dentro de uma classe
- **Scanner:** leitura de entrada mais verbosa que `input()`

## 🚀 Como Executar

### Pré-requisitos
- **JDK 17** ou superior ([download aqui](https://adoptium.net/))

### Passos

```bash
# Compilar
javac Conjuntos.java

# Rodar
java Conjuntos