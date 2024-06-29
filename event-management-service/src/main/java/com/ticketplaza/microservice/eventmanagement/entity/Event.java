package com.ticketplaza.microservice.eventmanagement.entity;

import java.time.LocalDateTime;
import com.ticketplaza.microservice.eventmanagement.enums.EventCategory;
import com.ticketplaza.microservice.eventmanagement.enums.EventStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EventDetails")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String eventName;
	private String location;
	private String eventDescription;
	private String organizerId;
	private int totalSeats;
	private int bookedSeats;
	@Enumerated(EnumType.STRING)
	private EventCategory eventCategory;
	@Enumerated(EnumType.STRING)
	private EventStatus eventStatus;
}
