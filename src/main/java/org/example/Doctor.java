package org.example;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Doctor {
    private String name;
    private String specialization;
    private String phoneNumber;
    private LinkedList<TimeSlot> Timeslots; 

    public Doctor(String name, String specialization, String phoneNumber) {
        this.name = name;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
        Timeslots = new LinkedList<>();
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void AddTimeSlot(Date startTime) {
        
        // Create a Date object for the end time (e.g., 1 hour later)
		Date endTime = new Date(startTime.getTime() + 1200000); // Add 20 min in milliseconds
        TimeSlot timeSlot = new TimeSlot(startTime, endTime);
        Timeslots.add(timeSlot);
    }


    public List<TimeSlot> getTimeSlots() {
        return Timeslots;
    }
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "Name: " + name + ", Specialization: " + specialization + ", Phone Number: " + phoneNumber;
    }
}