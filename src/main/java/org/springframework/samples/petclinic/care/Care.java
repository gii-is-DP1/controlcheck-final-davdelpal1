package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "care")
public class Care extends BaseEntity{
	@NotEmpty
	@Size(min = 5, max = 30)
	@Column(name = "name", unique= true)
    private String name;
	@Column(name ="description")
	@NotEmpty
    private String description;
	@ManyToMany(cascade = CascadeType.ALL)
	@NotEmpty
	@JoinColumn(name = "compatiblePetTypes")
    private Set<PetType> compatiblePetTypes;
}
