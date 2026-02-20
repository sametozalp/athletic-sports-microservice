package org.ozalp.utils.consts;

public final class ApiConst {

    private final static String API = "/api";

    private final static class VERSIONS {

        public final static String V1 = "/v1";
    }

    public final static class ApiPath {
        // AUTH
        public final static String AUTH = API + VERSIONS.V1 + "/auth";
        public final static String ROLE = API + VERSIONS.V1 + "/role";
        public final static String USER_PROFILE = API + VERSIONS.V1 + "/userProfile";
        public final static String USER_ROLE = API + VERSIONS.V1 + "/userRole";

        // HEALTHY EATING TIP
        public final static String HEALTHY_EATING_TIP = API + VERSIONS.V1 + "/healthyEatingTip";

        // MEMBERSHIP
        public final static String MEMBERSHIP = API + VERSIONS.V1 + "/membership";
        public final static String MEMBERSHIP_REQUEST = API + VERSIONS.V1 + "/membershipRequest";

        // MOTIVATION SENTENCE
        public final static String MOTIVATION_SENTENCE = API + VERSIONS.V1 + "/motivationSentence";

        // ORGANIZATION
        public final static String ORGANIZATION = API + VERSIONS.V1 + "/organization";

        // TRAINING
        public final static String ATHLETE_PROGRESS = API + VERSIONS.V1 + "/athleteProgress";
        public final static String COACHING_ASSIGNMENT = API + VERSIONS.V1 + "/coachingAssignment";
        public final static String EXERCISE = API + VERSIONS.V1 + "/exercise";
        public final static String MEAL_ITEM_TASK = API + VERSIONS.V1 + "/mealItemTask";
        public final static String TRAINING_ITEM_TASK = API + VERSIONS.V1 + "/trainingItemTask";
        public final static String TRAINING_PROGRAM = API + VERSIONS.V1 + "/trainingProgram";
    }
}
