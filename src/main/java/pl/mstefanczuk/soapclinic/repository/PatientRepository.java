package pl.mstefanczuk.soapclinic.repository;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import pl.mstefanczuk.clinic_web_service.Appointment;
import pl.mstefanczuk.clinic_web_service.Patient;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

@Component
public class PatientRepository {

    private static final Map<String, Patient> patients = new HashMap<>();

    @PostConstruct
    public void initData() {
        Patient bob = new Patient();
        bob.setPesel("90032407973");
        bob.setFirstName("Bob");
        bob.setLastName("Budowniczy");

        patients.put(bob.getPesel(), bob);

        Patient janusz = new Patient();
        janusz.setPesel("52112178361");
        janusz.setFirstName("Janusz");
        janusz.setLastName("Korwin Mikke");

        Appointment appointment = new Appointment();
        appointment.setAppointmentDateTime(LocalDateTime
                .of(2019, Month.FEBRUARY, 20, 13, 30).toString());
        appointment.setRoomNumber(11);
        janusz.getAppointments().put(appointment.getAppointmentDateTime(), appointment);

        patients.put(janusz.getPesel(), janusz);
    }

    public Patient findPatient(String pesel) {
        Assert.notNull(pesel, "Pesel must not be null");
        return patients.get(pesel);
    }

    public String createPatient(Patient patient) {
        Assert.notNull(patient, "Patient must not be null");
        patients.put(patient.getPesel(), patient);
        return patient.getPesel();
    }

    public Appointment makeAppointment(String patientPesel, Appointment appointment) {
        Patient patient = patients.get(patientPesel);
        patient.getAppointments().put(appointment.getAppointmentDateTime(), appointment);
        return appointment;
    }

    public Appointment changeAppointmentDateTime(String patientPesel, String oldDateTime, String newDateTime) {
        Patient patient = patients.get(patientPesel);
        Appointment appointment = patient.getAppointments().get(oldDateTime);
        appointment.setAppointmentDateTime(newDateTime);
        patient.getAppointments().remove(oldDateTime);
        patient.getAppointments().put(newDateTime, appointment);
        return appointment;
    }
}
