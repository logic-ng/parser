package org.logicng.io.parsers.readers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.logicng.formulas.CType;
import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFactory;
import org.logicng.io.parsers.ParserException;

import java.io.IOException;
import java.util.Arrays;

public class FormulaReaderTest {

    @Test
    public void testReadPropositionalFormula() throws ParserException, IOException {
        final FormulaFactory f = new FormulaFactory();
        final Formula formula = FormulaReader.readPropositionalFormula("src/test/resources/formula1.txt", f);
        final Formula expected = f.and(
                f.variable("v0"),
                f.and(f.implication(f.variable("v1"), f.variable("v0")), f.implication(f.literal("v1", false), f.literal("v0", false))),
                f.or(f.literal("v1", false), f.variable("v2"))
        );
        assertThat(formula).isEqualTo(expected);
    }

    @Test
    public void testReadPseudoBooleanFormula() throws ParserException, IOException {
        final FormulaFactory f = new FormulaFactory();
        final Formula formula = FormulaReader.readPseudoBooleanFormula("src/test/resources/formula2.txt", f);
        final Formula expected = f.and(
                f.amo(f.variable("v0")),
                f.and(f.implication(f.variable("v1"), f.variable("v0")), f.implication(f.literal("v1", false), f.literal("v0", false))),
                f.amo(f.variable("v2")),
                f.pbc(CType.LE, 6, Arrays.asList(f.variable("v0"), f.literal("v2", false)), Arrays.asList(8, -3))
        );
        assertThat(formula).isEqualTo(expected);
    }
}
