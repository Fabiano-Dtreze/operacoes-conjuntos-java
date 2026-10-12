# Operações com Conjuntos em Java

Versão em **Java** do programa de operações com conjuntos, desenvolvida como aprofundamento do trabalho original em Python.

## Objetivo

Implementar as operações de conjuntos **sem usar os métodos nativos** das coleções Java (`Set`), aplicando laços e condicionais, e comparar cada resultado com a solução nativa.

## Operações Implementadas

| Operação | Notação | Implementação manual | Solução nativa |
|---|---|---|---|
| Pertinência | x ∈ A | `pertence(x, A)` | `A.contains(x)` |
| União | A ∪ B | `uniao(A, B)` | `uniaoNativo(A, B)` |
| Interseção | A ∩ B | `interseccao(A, B)` | `interseccaoNativo(A, B)` |
| Diferença | A − B | `diferenca(A, B)` | `diferencaNativo(A, B)` |
| Diferença Simétrica | A △ B | `diferencaSimetrica(A, B)` | `diferencaSimetricaNativo(A, B)` |
| Inclusão | A ⊆ B | `estaContido(A, B)` | `B.containsAll(A)` |
| Cardinalidade | \|A\| | `cardinalidade(A)` | `A.stream().distinct().count()` |

## Diferenças em relação ao Python

- **Tipagem estática:** declaração de tipos em todas as variáveis
- **Comparação de Strings:** uso de `.equals()` em vez de `==`
- **Orientação a objetos:** todo código dentro de uma classe
- **Scanner:** leitura de entrada mais verbosa que `input()`

## Como Executar

### Pré-requisitos
- **JDK 17** ou superior ([download aqui](https://adoptium.net/))

### Passos

```bash
# Compilar
javac Conjuntos.java

# Rodar
java Conjuntos

## Autor
   Fabiano Barbir

## Referências          ← ADICIONE AQUI (antes da licença)
   - fonte 1
   - fonte 2
   - fonte 3

## Licença
   Este projeto está sob a licença MIT...

## Referências

- ORACLE. **Java Platform, Standard Edition Documentation — Collections Framework**. Disponível em: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/package-summary.html. Acesso em: 12 out. 2026.
- ORACLE. **The Java Tutorials — Trail: Collections**. Disponível em: https://docs.oracle.com/javase/tutorial/collections/. Acesso em: 12 out. 2026.
- LIPSCHUTZ, Seymour; LIPSON, Marc. **Matemática Discreta**. 3. ed. Porto Alegre: Bookman, 2013.
- ROSEN, Kenneth H. **Matemática Discreta e suas Aplicações**. 6. ed. São Paulo: McGraw-Hill, 2009.
- GITHUB. **GitHub Docs — Getting Started**. Disponível em: https://docs.github.com. Acesso em: 12 out. 2026.