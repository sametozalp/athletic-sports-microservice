package org.ozalp.utils.consts;

public final class ApiParams {

    public final static class Auth {

        public final static String REGISTER = "/register";

    }

    public final static class Role {
        public final static String CREATE = "/create";
    }

    public final static class UserProfile {
        public final static String UPDATE = "/update";
        public final static String GET_PROFILE_DETAIL = "/getProfileDetail/{id}";

    }

    public final static class UserRole {
        public final static String CREATE = "/create";
    }

    public final static class HealthyEatingTip {
        public final static String CREATE = "/create";
        public final static String RANDOM = "/random";

    }

    public final static class Membership {
        public final static String CREATE = "/create";
    }

    public final static class MembershipRequest {
        public final static String CREATE = "/create";
    }

    public final static class MotivationSentence {
        public final static String CREATE = "/create";
        public final static String RANDOM = "/random";
    }

    public final static class Organization {
        public final static String CREATE = "/create";
        public final static String GET_ORGANIZATION_DETAIL = "/getDetail/{id}";
    }

    public final static class AthleteProgress {
        public final static String CREATE = "/create";
    }

    public final static class CoachingAssignment {
        public final static String CREATE = "/create";
        public final static String DELETE = "/delete/{id}";
    }

    public final static class Exercise {
        public final static String CREATE = "/create";
    }

    public final static class MealItemTask {
        public final static String CREATE = "/create";
    }

    public final static class TrainingItem {
        public final static String GET_ALL = "/getAll";
    }

    public final static class TrainingProgram {
        public final static String CREATE = "/create";
    }
}
