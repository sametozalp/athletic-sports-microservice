package com.ozalp.healthy_eating_tip.dataAccess;

import com.ozalp.healthy_eating_tip.models.entities.HealthyEatingTip;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HealthyEatingTipRepository extends JpaRepository<HealthyEatingTip, Integer> {

    @Query("SELECT n FROM HealthyEatingTip n ORDER BY function('RANDOM')")
    List<HealthyEatingTip> getRandomTip(Pageable pageable);
}
