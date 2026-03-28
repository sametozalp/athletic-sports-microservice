package org.ozalp.utils.consts;

public final class EventConst {

    public final static String MAIL_GROUP_ID = "mail";

    public final static String QUICK_START_GROUP_ID = "quick-start";

    public final static class Topics {
        public final static String CREATED_USER_PROFILE = "created-user-profile";
        public final static String CREATED_TRAINING_PROGRAM = "created-training-program";
        public final static String CREATED_MEMBERSHIP = "created-membership";
        public final static String CREATED_MEMBERSHIP_REQUEST = "created-membership-request";
        public final static String CREATED_ORGANIZATION = "created-organization";

    }

    public final static class QuickStartSaga {
        public final static String QUICK_START_AUTH_STAGE_COMPLETED = "quick-start-auth-stage-completed";
        public final static String QUICK_START_MEMBERSHIP_STAGE_COMPLETED = "quick-start-membership-stage-completed";
        public final static String QUICK_START_TRAINING_STAGE_COMPLETED = "quick-start-training-stage-completed";
        public final static String QUICK_START_MAIL_STAGE_COMPLETED = "quick-start-mail-stage-completed";
    }

    public final static class QuickStartSagaRollback {
        public final static String QUICK_START_AUTH_STAGE_ROLLBACK = "quick-start-auth-stage-rollback";
        public final static String QUICK_START_MEMBERSHIP_STAGE_ROLLBACK = "quick-start-membership-stage-rollback";
        public final static String QUICK_START_TRAINING_STAGE_ROLLBACK = "quick-start-training-stage-rollback";
        public final static String QUICK_START_MAIL_STAGE_ROLLBACK = "quick-start-mail-stage-rollback";
    }


}
