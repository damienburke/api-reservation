package com.twa.flights.api.reservation.model

data class ReservationResponse(
    val id: String,
    val passengers: List<Passenger>,
    val contact: Contact,
    val itineraryId: String
)