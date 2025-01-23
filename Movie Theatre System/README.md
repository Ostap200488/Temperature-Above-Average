Movie Ticket Booking System

Overview

The Movie Ticket Booking System is a Java-based console application that allows users to register, log in, select movies, book seats, and view their booking history. The application simulates a movie theater experience, providing a simple interface for seat reservation and management.

Features

User Registration and Login

Users can create accounts and securely log in.

Movie Selection

Users can choose from a predefined list of available movies.

Seat Booking

Displays available seats.

Allows users to book a seat by entering its number.

Marks booked seats as unavailable.

Booking History

Displays a history of bookings with details such as the username, movie, seat number, and booking time.

Seat Management

Shows available seats.

Prevents booking of already reserved seats.

Missing Features

Seat Cancellation: The current implementation does not allow users to cancel booked seats.

Seat Suggestions: If a selected seat is unavailable, the system does not suggest alternative seats.

Initial Seating Chart Retrieval: There is no explicit method to display the seating chart before bookings.

How to Run

Prerequisites:

Java Development Kit (JDK) installed on your system.

Steps:

Compile the program:

javac MovieTicketBookingSystem.java

Run the program:

java MovieTicketBookingSystem

Follow the on-screen prompts to:

Register and log in.

Select a movie.

View available seats and book one.

View your booking history.

Classes and Their Responsibilities

User: Represents a user with a username and password.

UserManager: Manages user registration and login.

Movie: Represents a movie available for booking.

Seat: Represents a seat in the theater with attributes for number, row, column, and availability.

SeatSelection: Handles displaying and booking of seats.

Booking: Records details of a booking, including username, movie, seat, and timestamp.

BookingHistory: Stores and retrieves booking history.

Example Workflow

Sign Up:

Enter a username and password to create an account.

Log In:

Use your credentials to log in.

Movie Selection:

Choose a movie from the list.

Seat Booking:

View available seats and book one by entering the seat number.

View Booking History:

See a summary of your bookings.
