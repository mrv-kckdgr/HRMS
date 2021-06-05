package com.example.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resume_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//@Column(name="resume_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity=Resume.class)
	@JoinColumn(name="resume_id", referencedColumnName = "id")
	private Resume resume;
	
	@Column(name="language_name")
	@NotBlank(message = "Dil adı boş geçilemez!!!")
	private String languageName;
	
	@Column(name="language_level")
	@NotBlank(message = "Dil seviyesi boş geçilemez!!!")
	private char languageLevel;
	
	@Column(name="create_date")
	//@Temporal(TemporalType.DATE)
	private Date createDate;
	
	
}
