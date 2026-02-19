package com.ozalp.healthy_eating_tip.models.entities;

import com.ozalp.healthy_eating_tip.models.enums.Icon;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "healthy_eating_tips")
@Getter
@Setter
@NoArgsConstructor
public class HealthyEatingTip extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Icon icon = Icon.NUTRIENT;

    public HealthyEatingTip(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
