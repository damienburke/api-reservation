package com.twa.flights.api.reservation.model

import jakarta.validation.constraints.NotEmpty

data class ReservationRequest(
    val passengers: List<Passenger>,
    val contact: Contact,
    @field:NotEmpty(message = "Itinerary Id cannot be null")
    val itineraryId: String
)

data class Passenger(
    val type: String,
    val gender: String,
    val birth: String,
    val nationality: String,
    val firstName: String,
    val lastName: String,
    val document: Document
)

data class Document(val number: String, val type: String, val expiration: String)

data class Contact(val telephone: String, val email: String)