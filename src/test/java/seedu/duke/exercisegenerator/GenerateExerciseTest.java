package seedu.duke.exercisegenerator;

import org.junit.jupiter.api.Test;
import seedu.duke.exersisedata.ExerciseData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GenerateExerciseTest {

    /**
     * Checks if able to generate exercise list of size equal to count
     */
    @Test
    void testGeneration() {
        GenerateExercise generateExercise = new GenerateExercise();
        assertEquals(5, generateExercise.generateRandomSet(5).size());
        assertEquals(0, generateExercise.generateRandomSet(0).size());
        assertEquals(0, generateExercise.generateRandomSet(-1).size());
    }

    /**
     * Checks if ArrayList contains exercise data
     */
    @Test
    void testData() {
        GenerateExercise generateExercise = new GenerateExercise();
        ArrayList<ExerciseData> exerciseDatas = generateExercise.generateRandomSet(5);
        assertNotNull(exerciseDatas.get(0));
    }
}