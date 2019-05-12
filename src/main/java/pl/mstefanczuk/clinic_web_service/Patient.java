package pl.mstefanczuk.clinic_web_service;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patient", propOrder = {
        "firstName",
        "lastName",
        "pesel",
        "appointments"
})
@Getter
@Setter
public class Patient {

    private String firstName;
    private String lastName;
    @XmlElement(required = true)
    private String pesel;
    private Map<String, Appointment> appointments;

    public Map<String, Appointment> getAppointments() {
        if (appointments == null) {
            appointments = new HashMap<>();
        }
        return this.appointments;
    }
}
