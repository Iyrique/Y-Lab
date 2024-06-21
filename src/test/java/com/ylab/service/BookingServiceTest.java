package com.ylab.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

/**
 * Tests for BookingService.
 */
public class BookingServiceTest {

    private BookingService bookingService;

    @BeforeEach
    public void setUp() {
        bookingService = new BookingService();
    }

    @Test
    public void testAddBooking() {
        LocalDateTime startTime = LocalDateTime.of(2023, 1, 1, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2023, 1, 1, 12, 0);

        bookingService.addBooking("user1", 1, startTime, endTime, true);
        assertThat(bookingService.getAllBookings()).hasSize(1);
    }

    @Test
    public void testAddBookingConflict() {
        LocalDateTime startTime = LocalDateTime.of(2023, 1, 1, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2023, 1, 1, 12, 0);

        bookingService.addBooking("user1", 1, startTime, endTime, true);
        assertThrows(IllegalArgumentException.class, () -> {
            bookingService.addBooking("user2", 1, startTime.plusHours(1), endTime.plusHours(1), true);
        });
    }

    @Test
    public void testCancelBooking() {
        LocalDateTime startTime = LocalDateTime.of(2023, 1, 1, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2023, 1, 1, 12, 0);

        bookingService.addBooking("user1", 1, startTime, endTime, true);
        bookingService.cancelBooking(1);
        assertThat(bookingService.getAllBookings()).isEmpty();
    }

    @Test
    public void testFilterBookingsByDate() {
        LocalDateTime startTime = LocalDateTime.of(2023, 1, 1, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2023, 1, 1, 12, 0);

        bookingService.addBooking("user1", 1, startTime, endTime, true);
        assertThat(bookingService.filterBookings(startTime, null, null)).hasSize(1);
    }

    @Test
    public void testFilterBookingsByUser() {
        LocalDateTime startTime = LocalDateTime.of(2023, 1, 1, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2023, 1, 1, 12, 0);

        bookingService.addBooking("user1", 1, startTime, endTime, true);
        assertThat(bookingService.filterBookings(null, "user1", null)).hasSize(1);
    }

    @Test
    public void testFilterBookingsByResource() {
        LocalDateTime startTime = LocalDateTime.of(2023, 1, 1, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2023, 1, 1, 12, 0);

        bookingService.addBooking("user1", 1, startTime, endTime, true);
        assertThat(bookingService.filterBookings(null, null, 1)).hasSize(1);
    }
}
