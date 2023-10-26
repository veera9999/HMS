package org.example;

import java.sql.Date;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Appointment {

    public static int appID=0;
    public  int AppointmentID;
    private TimeSlot timeSlot;
    private Doctor doctor;
    private Patient patient;

    public Appointment(int AppointmentID, TimeSlot timeSlot, Doctor doctor, Patient patient) {
        this.AppointmentID = generateappID();
        this.timeSlot = timeSlot;
        this.doctor = doctor;
        this.patient = patient;
    }

    public int getAppointmentID(){return AppointmentID;}
    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public static int generateappID()
    {
        appID+=1;
        return appID;
    }
}


class Appointments {
    private static  LinkedList<Appointment> appointmentList;

    public Appointments() {
        appointmentList = new LinkedList<>();
    }

    // Add a new appointment to the list
    public void addAppointment(Appointment appointment) {
        appointmentList.add(appointment);
    }

    // Remove an appointment from the list
    public void removeAppointment(Appointment appointment) {
        appointmentList.remove(appointment);
    }

    // Get a list of all appointments
    public List<Appointment> getAppointments() {
        return appointmentList;
    }

    public static  Appointment getAppointment(int appointmentID)
    {
        Appointment app=null;
        for(Appointment App: appointmentList)
        {
            if(appointmentID == app.AppointmentID)
            {
                app=App;
                System.out.println(app.getPatient().getName());
            }
        }
        if(app==null)
        return null;
        else
            return app;
    }

}



// public class Main {
//     public static void main(String[] args) {
//         // Create a doctor and a patient
//         Doctor doctor = new Doctor("Dr. Smith");
//         Patient patient = new Patient("John Doe");

//         // Define a time slot
//         TimeSlot timeSlot = new TimeSlot(new Date(), new Date());

//         // Book an appointment
//         Appointment appointment = new Appointment(timeSlot, doctor, patient);

//         // Display appointment details
//         System.out.println("Appointment Details:");
//         System.out.println("Doctor: " + appointment.getDoctor().getName());
//         System.out.println("Patient: " + appointment.getPatient().getName());
//         System.out.println("Time Slot: " + appointment.getTimeSlot().getStartTime() + " - " + appointment.getTimeSlot().getEndTime());
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         // Create appointments
//         Appointment appointment1 = new Appointment(new Date(), new Date(), "Medical checkup");
//         Appointment appointment2 = new Appointment(new Date(), new Date(), "Dental cleaning");

//         // Create an Appointments object to manage appointments
//         Appointments appointments = new Appointments();

//         // Add appointments to the list
//         appointments.addAppointment(appointment1);
//         appointments.addAppointment(appointment2);

//         // Display all appointments
//         List<Appointment> allAppointments = appointments.getAppointments();
//         for (Appointment appointment : allAppointments) {
//             System.out.println(appointment);
//         }

//         // Search for appointments by description
//         List<Appointment> searchResults = appointments.searchAppointmentsByDescription("Medical");
//         if (!searchResults.isEmpty()) {
//             System.out.println("Search Results:");
//             for (Appointment appointment : searchResults) {
//                 System.out.println(appointment);
//             }
//         } else {
//             System.out.println("No matching appointments found.");
//         }
//     }
// }

