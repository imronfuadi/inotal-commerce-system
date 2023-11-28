package com.inotalcommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "m_role")
public class Role {

	@Id
	@Size(max = 30)
	private String kd;
	
	private String description;
}
