package com.guilhermeamorim.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.convert.Jsr310Converters;

import com.guilhermeamorim.model.enums.EntryStatus;
import com.guilhermeamorim.model.enums.EntryType;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "entry", schema = "finances")
@Data
@Builder
public class Entry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "entry_description")
	private String description;
	
	@Column(name = "entry_month")
	private Integer month;
	
	@Column(name = "entry_year")
	private Integer year;
	
	@Column(name = "entry_value")
	private BigDecimal value;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@Column(name = "created")
	@Convert(converter = Jsr310Converters.LocalDateTimeToDateConverter.class)
	private LocalDate created;
	
	@Column(name = "entry_type")
	@Enumerated(value = EnumType.STRING)
	private EntryType type;
	
	@Column(name = "entry_status")
	@Enumerated(value = EnumType.STRING)
	private EntryStatus status;
	
}
