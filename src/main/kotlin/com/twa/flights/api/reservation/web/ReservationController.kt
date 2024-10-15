package com.twa.flights.api.reservation.web

import com.twa.flights.api.reservation.model.Contact
import com.twa.flights.api.reservation.model.Passenger
import com.twa.flights.api.reservation.model.ReservationRequest
import com.twa.flights.api.reservation.model.ReservationResponse
import com.twa.flights.api.reservation.service.ReservationService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/flights/")
@Validated
class ReservationController(val reservationService: ReservationService) {

    @GetMapping("reservation/{id}")
    fun get(@PathVariable("id") id: String): ResponseEntity<ReservationResponse?> {
        println("get $id")
        return ResponseEntity
            .status(200)
            .body(reservationService.getReservationById(id))
    }

    @PostMapping("reservation")
    fun create(@Valid @RequestBody request: ReservationRequest): ResponseEntity<ReservationResponse> {
        println("create")
        return ResponseEntity.status(201).body(reservationService.saveReservationById(request))
    }

}