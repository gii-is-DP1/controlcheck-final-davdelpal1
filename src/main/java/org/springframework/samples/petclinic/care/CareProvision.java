package org.springframework.samples.petclinic.care;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "care_provisions")
public class CareProvision extends BaseEntity{ 
	@NotNull
	@Column(name = "duration")
	@Min(0)
    private double duration;
	@ManyToOne
	@JoinColumn(name = "visit")
    Visit visit;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "care")
    private Care care;   
}
