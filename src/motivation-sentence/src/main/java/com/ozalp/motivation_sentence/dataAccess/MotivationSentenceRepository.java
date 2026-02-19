package com.ozalp.motivation_sentence.dataAccess;

import com.ozalp.motivation_sentence.models.entities.MotivationSentence;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MotivationSentenceRepository extends JpaRepository<MotivationSentence, Integer> {

    @Query("SELECT n FROM MotivationSentence n ORDER BY function('RANDOM')")
    List<MotivationSentence> getRandomSentence(Pageable pageable);
}
