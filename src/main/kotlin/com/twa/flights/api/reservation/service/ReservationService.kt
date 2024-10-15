package com.twa.flights.api.reservation.service

import com.twa.flights.api.reservation.model.Contact
import com.twa.flights.api.reservation.model.Passenger
import com.twa.flights.api.reservation.model.ReservationRequest
import com.twa.flights.api.reservation.model.ReservationResponse
import org.springframework.stereotype.Service
import java.util.UUID
import mu.KotlinLogging

@Service
class ReservationService {

    private val logger = KotlinLogging.logger {}

    fun getReservationById(id: String): ReservationResponse {

        logger.info { "getReservationById $id" }

        val passengers = mutableListOf<Passenger>()
        val contact = Contact(telephone = "123-123-99990", email = "fds@gmail.com")
        val itineraryId = "123"
        return ReservationResponse(
            passengers = passengers,
            contact = contact,
            itineraryId = itineraryId,
            id = id
        )
    }

    fun saveReservationById(request: ReservationRequest): ReservationResponse {
        val passengers = mutableListOf<Passenger>()
        val contact = Contact(telephone = "123", email = "fds")
        val itineraryId = "123"
        return ReservationResponse(
            passengers = passengers,
            contact = contact,
            itineraryId = itineraryId,
            id = UUID.randomUUID().toString()
        )
    }
}