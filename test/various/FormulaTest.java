package various;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FormulaTest {

    @Test
    void prepare() {

        int N = 1;

        List<String> entries = Arrays.asList("CH3(1)CH2(1)CH3");
        List<String> inputs = new ArrayList<>();

        for (int i = 0; i < entries.size(); i++)
            inputs.add(entries.get(i));

        String result = (new Formula()).driveAction(Formula.prepare(inputs));

        assertEquals("VALID", result);

        System.out.println("SECOND TEST------------");
        /*
         * SECOND TEST
         */
        entries = Arrays.asList("CH3   CH3","(1)   (1)");
        inputs = new ArrayList<>();

        for (int i = 0; i < entries.size(); i++)
            inputs.add(entries.get(i));

        result = (new Formula()).driveAction(Formula.prepare(inputs));

        assertEquals("VALID", result);


        /*
         * THIRD TEST
         */
        entries = Arrays.asList("CH2(2)CH0(1)CH1(2)CH0(1)CH3","      (1)         (1)");
        inputs = new ArrayList<>();

        for (int i = 0; i < entries.size(); i++)
            inputs.add(entries.get(i));

        result = (new Formula()).driveAction(Formula.prepare(inputs));

        assertEquals("VALID", result);
    }

    @Test
    void driveAction() {
    }
}