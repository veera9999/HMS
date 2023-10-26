package org.example;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HMS {
    private static LinkedList<Patient> patientList = new LinkedList<Patient>();
    private static LinkedList<Doctor> doctorList = new LinkedList<Doctor>();
	// Create an Appointments object to manage appointments
	private static Appointments appointments = new Appointments();
    static InputStreamReader ir = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(ir);

    public static void main(String[] args) throws IOException {
        // Adding Patient Data
        patientList.add(new Patient(1, "Ashish", 24, "Male", "2342355", "as@gmail.com"));
        patientList.add(new Patient(2, "Jane", 56, "Female", "2342355", "jd@gmail.com"));

        // Adding Doctors Data
        doctorList.add(new Doctor("Michella", "Oncologist", "86647687"));
        doctorList.add(new Doctor("Grace", "Dermatologist", "23535235"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("********IDS 517 - Homework 4********");
        System.out.println("**************GROUP 1***************");
        System.out.println("************************************");

        // User Authentication
        String[] allowedUsers = { "Teja", "Shashank", "Ibrahim", "Lavisha" };
        String[] passwords = { "t1234", "s1234", "i1234", "l1234" };
        System.out.println("");
        System.out.println("********** User Authentication ***********");
        System.out.println("Enter User Name: ");
        String enteredUsername = br.readLine();

        //Console console = System.console();
        System.out.println("Enter Password: ");

        //char[] password1 = console.readPassword("Enter Password: ");
        String enteredPassword = scanner.nextLine();
        char[] password1 = enteredPassword.toCharArray();

        /*Console console = System.console();
        char[] password1 = console.readPassword("Enter Password: ");*/
        int u = allowedUsers.length;
        for (int n = 0; n < u; n++) {
            if (enteredUsername.equals(allowedUsers[n])) {
                if (new String(password1).equals(passwords[n])) {
                    System.out.println("Welcome " + enteredUsername + " !!");

                    while (true) {
                        while (true) {
                            System.out.println("**************************************");
                            System.out.println("\nChoose an option:");
                            System.out.println("**************************************");
                            System.out.println("1. Add a patient");
                            System.out.println("2. Add a doctor");
                            System.out.println("3. View patient details");
                            System.out.println("4. View doctor details");
                            System.out.println("5. Update patient details");
                            System.out.println("6. Update doctor details");
							System.out.println("7. Add Appointment");
							System.out.println("8. List Appointments");
                            System.out.println("9. Insert Timeslots");
                            System.out.println("10. List Timeslots");
                            System.out.println("11. Billing");
                            System.out.println("0. Exit");

                            int choice = scanner.nextInt();

                            switch (choice) {
                                case 1:
                                    addPatient(scanner);
                                    break;
                                case 2:
                                    addDoctor(scanner);
                                    break;
                                case 3:
                                    viewPatientDetails();
                                    break;
                                case 4:
                                    viewDoctorDetails();
                                    break;
                                case 5:
                                    updatePatientDetails(scanner);
                                    break;
                                case 6:
                                    updateDoctorDetails(scanner);
                                    break;
								case 7:
                                    addAppointment(scanner);
                                    break;
								case 8:
                                    listAppointments();
                                    break;
                                case 9:
                                    InsertTimeslots(scanner);
                                    break;
                                case 10:
                                    ListTimeslots(scanner);
                                    break;
                                case 11:
                                    Billing(scanner);
                                    break;
                                case 0:
                                    System.out.println("Exiting...");
                                    System.exit(0);
                                default:
                                    System.out.println("Invalid choice. Try again.");
                            }

                        }
                    }
                } else {
                    System.out.println("Entered Password Is Incorrect!!");
                }
            }
        }
        System.out.println("Incorrect Credentials Entered!!");
    }

	private static void listAppointments(){

		 // Get the list of all appointments
        List<Appointment> appointmentList = appointments.getAppointments();

        // Print the appointments
        System.out.println("Appointments:");
        for (Appointment appointment : appointmentList) {

            System.out.println("patient: " + appointment.getPatient().getName());
            System.out.println("Date and Time: " + appointment.getTimeSlot().getStartTime());
            System.out.println("AppointmentID: "+appointment.getAppointmentID());
        }
		
	}


	private static void addAppointment(Scanner scanner) throws IOException {
		
		System.out.println("Enter doctor name:");
        String doctorName = br.readLine();
		for (Doctor doctor : doctorList) {
			if (doctor.getName().equals(doctorName)) {
				System.out.println("TODO get doctor time slots and choose time slot");
				// Define a time slot
				Date startTime = new Date(); // This will set the start time to the current date and time.
				// Create a Date object for the end time (e.g., 1 hour later)
				Date endTime = new Date(startTime.getTime() + 3600000); // Add 1 hour in milliseconds

				TimeSlot timeSlot = new TimeSlot(startTime, endTime);

				System.out.println("Enter patient name:");
				String patientName = br.readLine();

				for (Patient patient : patientList) {
					if (patient.getName().equals(patientName)) {
						// Book an appointment

						Appointment appointment = new Appointment(Appointment.generateappID(),timeSlot, doctor, patient);
						// Add appointments to the list
        				appointments.addAppointment(appointment);
					}
				}
			}
		}

        System.out.println("appointment Added successfully");
    }
    
    private static void ListTimeslots(Scanner scanner) throws IOException{
        System.out.println("Enter doctor name:");
        String doctorName = br.readLine();
		for (Doctor doctor : doctorList) {
			if (doctor.getName().equals(doctorName)) {
				System.out.println("TODO get doctor time slots and choose time slot");
				// Define a time slot
               
                List<TimeSlot> timeSlotsList = doctor.getTimeSlots();

                for (TimeSlot timeSlot : timeSlotsList) {
                   System.out.println("Time Slot: " + timeSlot.getStartTime());
                }
			}
		}
		
	}
    
    private static void InsertTimeslots(Scanner scanner) throws IOException{
        System.out.println("Enter doctor name:");
        String doctorName = br.readLine();
		for (Doctor doctor : doctorList) {
			if (doctor.getName().equals(doctorName)) {
				System.out.println("TODO get doctor time slots and choose time slot");
				// Define a time slot
                try{
                System.out.println("Enter Time Slot(e.g., yyyy-MM-dd HH:mm:ss):");
                String input = br.readLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date startTime = dateFormat.parse(input);
                System.out.println("You entered: " + startTime);
                doctor.AddTimeSlot(startTime);
                }
                catch (ParseException e) {
                    System.out.println("Invalid date format. Please enter a date in the format yyyy-MM-dd HH:mm:ss.");
                }

			}
		}
    }

    private static void addPatient(Scanner scanner) throws IOException {
        System.out.println("Enter patient Id:");
        int ID = scanner.nextInt();

        System.out.println("Enter patient name:");
        String name = br.readLine();

        System.out.println("Enter patient age:");
        int age = scanner.nextInt();

        System.out.println("Enter patient gender:");
        String gender = scanner.next();

        System.out.println("Enter patient phone number:");
        String phoneNumber = scanner.next();

        System.out.println("Enter patient email:");
        String email = scanner.next();

        Patient patient = new Patient(ID, name, age, gender, phoneNumber, email);
        patientList.add(patient);
        System.out.println("Patient added successfully.");
    }

    private static void addDoctor(Scanner scanner) throws IOException {
        System.out.println("Enter doctor name:");
        String name = br.readLine();

        System.out.println("Enter doctor specialization:");
        String specialization = scanner.next();

        System.out.println("Enter doctor phone number:");
        String phoneNumber = scanner.next();

        Doctor doctor = new Doctor(name, specialization, phoneNumber);
        doctorList.add(doctor);
        System.out.println("Doctor added successfully.");
    }

    private static void viewPatientDetails() {
        if (patientList.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Patient Details:");
            System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s", "ID", "Name", "Age", "Gender", "Phone Number", "Email", "\n");
            System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Patient patient : patientList) {
                System.out.println("\n");
                System.out.format("%-14s %-15s %-15s %-15s %-15s %-15s",
                        patient.getID(), patient.getName(), patient.getAge(), patient.getGender(), patient.getPhoneNumber(), patient.getemail(), "\n");
            }
            System.out.println("\n");
        }
    }

    private static void viewDoctorDetails() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            System.out.println("************************");
            System.out.println("Doctor Details:");
            System.out.println("************************");
            System.out.format("%-15s %-15s %-15s", "Name", "Speciality", "PhoneNumber");
            System.out.println("\n");
            for (Doctor doctor : doctorList) {
                System.out.format("%-15s %-15s %-15s", doctor.getName(), doctor.getSpecialization(), doctor.getPhoneNumber());
                System.out.println("\n");
            }
        }
    }

    private static void updatePatientDetails(Scanner scanner) throws IOException {
        if (patientList.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("Enter patient name to update:");
            String name = br.readLine();

            for (Patient patient : patientList) {
                if (patient.getName().contains(name)) {
                    System.out.println("Enter updated age:");
                    int age = scanner.nextInt();
                    patient.setAge(age);

                    System.out.println("Enter updated gender:");
                    String gender = scanner.next();
                    patient.setGender(gender);

                    System.out.println("Enter updated phone number:");
                    String phoneNumber = scanner.next();
                    patient.setPhoneNumber(phoneNumber);

                    System.out.println("Patient details updated successfully.");
                    return;
                }
            }

            System.out.println("Patient not found.");
        }
    }

    private static void updateDoctorDetails(Scanner scanner) {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            System.out.println("Enter doctor name to update:");
            String name = scanner.next();

            for (Doctor doctor : doctorList) {
                if (doctor.getName().equals(name)) {
                    System.out.println("Enter updated specialization:");
                    String specialization = scanner.next();
                    doctor.setSpecialization(specialization);

                    System.out.println("Enter updated phone number:");
                    String phoneNumber = scanner.next();
                    doctor.setPhoneNumber(phoneNumber);

                    System.out.println("Doctor details updated successfully.");
                    return;
                }
            }

            System.out.println("Doctor not found.");
        }
    }

    public static void Billing(Scanner scanner)
    {
        System.out.println("Enter appointmentID: ");
        int appID = scanner.nextInt();
        Appointment app = Appointments.getAppointment(appID);
        if(app==null)
            System.out.println("Invalid AppointmentID");
        else {
            System.out.println("*************************************Billing Information********************************************************");
            System.out.println("Patient - ID: " + app.getPatient().getID());
            System.out.println("Patient Name: " + app.getPatient().getName());
            System.out.println("Patient Age: " + app.getPatient().getAge());
            System.out.println("Patient Gender: " + app.getPatient().getGender());
            System.out.println("Time Slot of Appointment: " + app.getTimeSlot().getStartTime() + " - " + app.getTimeSlot().getEndTime());
            System.out.println("Doctor Name: " + app.getDoctor().getName());
            System.out.println("Specialization: " + app.getDoctor().getSpecialization());
            System.out.println("Phone Number: " + app.getDoctor().getPhoneNumber());
            System.out.println("***********************************************************************************************************");
            System.out.println("Consultation Fee : $50");
        }

    }
}
