package com.bagudu.mvp.role;

import com.bagudu.mvp.model.Auditable;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author bbagudu
 */
@Entity
public class Role extends Auditable<String> implements Serializable {
	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String description;
    private String details;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}
