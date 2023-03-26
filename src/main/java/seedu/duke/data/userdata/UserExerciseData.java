package seedu.duke.data.userdata;

import java.util.HashMap;

public class UserExerciseData {

    /**
     * This class takes in data from all workout sessions finished by
     * the user and stores these exercises as the key and their
     * frequencies as the value in a HashMap.
     *
     * @param userCareerData Contains data on all the user sessions completed by the user.
     * @return HashMap containing unique exercises and their frequencies of completion.
     */
    public static HashMap<String, Integer> addUserExerciseHistory (UserCareerData userCareerData) {
        assert userCareerData != null : "User career data should not be null!";
        HashMap<String, Integer> userExerciseDataMap = new HashMap<>();
        //Get the names of all exercises from each of the sessions, then
        // get their individual frequencies
        int totalSessionsArraySize = userCareerData.getTotalUserCareerSessions().size();
        for (int i = 0; i < totalSessionsArraySize; i += 1) {
            int indivSessionsArraySize = userCareerData.getTotalUserCareerSessions().
                                                       get(i).getSessionExercises().size();

            for (int j = 0; j < indivSessionsArraySize; j++) {
                String exerciseName = userCareerData.getTotalUserCareerSessions().
                                                    get(i).getSessionExercises().get(j).getName();

                if (userExerciseDataMap.containsKey(exerciseName)) {
                    int count = userExerciseDataMap.get(exerciseName);
                    userExerciseDataMap.put(exerciseName, count + 1);
                } else {
                    userExerciseDataMap.put(exerciseName, 1);
                }
            }
        }
        return userExerciseDataMap;
    }

}