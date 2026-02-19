package com.ozalp.training.dataAccess;

import com.ozalp.training.models.entities.AthleteProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AthleteProgressRepository extends JpaRepository<AthleteProgress, Integer> {

    @Query("""
                select coalesce(sum(ap.pointsEarned), 0)
                from AthleteProgress ap
                where ap.status = com.ozalp.training.models.enums.AthleteProgressStatus.COMPLETED
                  and ap.trainingItemTask.trainingProgram.athleteUserProfileId = :userProfileId
                  and ap.trainingItemTask.trainingProgram.athleteUserProfileId = :userProfileId
                  and ap.createdAt >= :#{T(java.time.LocalDateTime).now().minusMonths(1)}
            """)
    int getTotalPointThisMonth(int userProfileId);

    @Query("""
                SELECT CAST(
                    CASE 
                        WHEN COUNT(ap) = 0 THEN 0
                        ELSE (SUM(
                            CASE 
                                WHEN ap.status = com.ozalp.training.models.enums.AthleteProgressStatus.COMPLETED 
                                THEN 1.0 ELSE 0.0 
                            END
                        ) * 100.0 / COUNT(ap))
                    END
                AS int)
                FROM AthleteProgress ap
                WHERE ap.createdAt >= :#{T(java.time.LocalDateTime).now().minusMonths(1)}
            """)
    int getAchievementPercentageThisMonth(int userProfile);

    @Query("""
            select ap from AthleteProgress ap
            where ap.trainingItemTask.trainingProgram.athleteUserProfileId = :userProfileId
            and ap.trainingItemTask.date >= :fromDate
            """)
    List<AthleteProgress> getDailyMissions(int userProfileId, LocalDate fromDate);
}
