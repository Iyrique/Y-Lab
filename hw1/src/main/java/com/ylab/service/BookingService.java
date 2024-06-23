package com.ylab.service;

import com.ylab.model.Booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for managing bookings.
 */
public class BookingService {

    private List<Booking> bookings = new ArrayList<>();
    private int bookingCounter = 0;

    /**
     * Adds a new booking.
     *
     * @param username    the username of the user making the booking
     * @param resourceId  the ID of the resource being booked
     * @param startTime   the start time of the booking
     * @param endTime     the end time of the booking
     * @param isWorkspace true if the resource is a workspace, false if it is a conference room
     * @throws IllegalArgumentException if the time slot is already booked
     */
    public void addBooking(String username, int resourceId, LocalDateTime startTime, LocalDateTime endTime, boolean isWorkspace) {
        for (Booking booking : bookings) {
            if (booking.getResourceId() == resourceId &&
                    ((startTime.isBefore(booking.getEndTime()) && endTime.isAfter(booking.getStartTime())) ||
                            startTime.equals(booking.getStartTime()) ||
                            endTime.equals(booking.getEndTime()))) {
                throw new IllegalArgumentException("Time slot is already booked");
            }
        }
        bookingCounter++;
        bookings.add(new Booking(bookingCounter, username, resourceId, startTime, endTime, isWorkspace));
    }

    /**
     * Cancels a booking by ID.
     *
     * @param id the ID of the booking
     */
    public void cancelBooking(int id) {
        bookings.removeIf(booking -> booking.getId() == id);
    }

    /**
     * Gets all bookings.
     *
     * @return a list of all bookings
     */
    public List<Booking> getAllBookings() {
        return bookings;
    }

    /**
     * Filters bookings by date, user or resource.
     *
     * @param date       the date to filter bookings
     * @param username   the username to filter bookings
     * @param resourceId the resource ID to filter bookings
     * @return a list of filtered bookings
     */
    public List<Booking> filterBookings(LocalDateTime date, String username, Integer resourceId) {
        return bookings.stream()
                .filter(booking -> (date == null || (booking.getStartTime().toLocalDate().equals(date.toLocalDate()) || booking.getEndTime().toLocalDate().equals(date.toLocalDate()))) &&
                        (username == null || booking.getUsername().equals(username)) &&
                        (resourceId == null || booking.getResourceId() == resourceId))
                .collect(Collectors.toList());
    }
}
