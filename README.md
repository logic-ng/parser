![build](https://github.com/logic-ng/parser/workflows/build/badge.svg) ![License](https://img.shields.io/badge/license-Apache%202-ff69b4.svg) [![Maven Central](https://img.shields.io/maven-central/v/org.logicng/logicng-parser-j8.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22org.logicng%22%20AND%20a:%22logicng-parser-j8%22)


<a href="https://www.logicng.org"><img src="https://github.com/logic-ng/LogicNG/blob/master/doc/logo/logo_big.png" alt="logo" width="300"></a>

## Introduction

<a href="https://www.logicng.org">LogicNG</a> is a Java Library for creating, manipulating and solving Boolean and Pseudo-Boolean formulas. It includes 100% Java implementations of popular tools like [MiniSAT](http://minisat.se), [Glucose](http://www.labri.fr/perso/lsimon/glucose/), [PBLib](http://tools.computational-logic.org/content/pblib.php), or [OpenWBO](http://sat.inesc-id.pt/open-wbo/). For details about this core library refer to [LogicNG](https://github.com/logic-ng/LogicNG). 

This library provides two parsers for propositional formulas (`LogicNGPropositionalParser`) and pseudo-boolean formulas (`LogicNGPseudoBooleanParser`) which are based on the ANTLR parser generator.

## Usage

LogicNG is released in the Maven Central Repository. To include it just add

```xml

<dependency>
  <groupId>org.logicng</groupId>
  <artifactId>logicng-parser-j8</artifactId>
  <version>2.5.0</version>
</dependency>
```

to your Maven POM. If you are using Java 11, use `logicng-parser-j11` instead as `artifactId`.

For parsing a formula, you just create one of the two parsers and call `parse` on it:

```java
import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFactory;
import org.logicng.io.parsers.PropositionalParser;
import org.logicng.io.parsers.PseudoBooleanParser;

FormulaFactory f = new FormulaFactory();
PropositionalParser propositionalParser = new PropositionalParser(f);
Formula formula1 = propositionalParser.parse("A & ~(B | ~C)");

PseudoBooleanParser pseudoBooleanParser = new PseudoBooleanParser(f);
Formula formula2 = pseudoBooleanParser.parse("2 * A + 3 * B - 2 * C <= 3");
```

## License & Commercial Support

The library is released under the Apache License and therefore is free to use in any private, educational, or commercial projects. Commercial support is available through the German company [BooleWorks GmbH](http://www.booleworks.com) - the company behind LogicNG. Please contact Christoph Zengler at christoph@logicng.org for further details.
