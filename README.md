# Objectives
- Utilize the String class.
- Implement try-catch blocks to handle exceptions.
- Read data from a file using the Scanner class.
- Write data to a file using the PrintWriter class.

# Task Overview
In this phase, a new small flight is considered where the seat number is represented as a string consisting of a row number (e.g., 1, 2, …, 12) and a character (A, B, C, or D) representing the column number.


# Seat Class
- Define a Seat class with the following attributes and methods:
   - Private String seatNumber with getter and setter methods.
   - Private seat row number.
   - Private seat column number.
   - Private String for passenger name with getter and setter methods. If the name is null, the seat is considered empty.
   - Constructor that takes a seat number string.
   - Static method isValid that validates if the seat number is valid.
   - Static methods getRow and getColumn to extract row and column numbers from the seat number.
   - Method isEmpty to check if the seat is empty.
   - toString method to represent seat object's information as a string.

# Flight Program Class
- Create a Flight program class with the following components:
   - Private static ragged array of seats reflecting the new flight seat map.
   - Main method to initialize the seats array and display a menu with options.
       - Read passengers file.
       - Reserve a new empty seat.
       - Delete a reserved seat.
       - Delete all reserved seats.
       - Update passengers file.
       - Quit.
  - Option 1: Read passengers file from passengers.txt. Update the seats array based on reserved seats in the file. Handle wrong seat numbers or duplicate reservations.
  - Option 2: Prompt the user for seat number string and passenger name to reserve a seat.
  - Option 5: Write reserved seats information back to passengers file.


# File Format
passengers.txt format:


# Note
- Utilize try-catch blocks for error handling, including file I/O operations.
- Ensure proper validation of seat numbers and passenger information.
- Handle updating and writing back data to the file systematically to prevent data loss or corruption.
