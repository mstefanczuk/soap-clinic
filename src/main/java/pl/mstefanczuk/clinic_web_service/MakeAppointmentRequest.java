package pl.mstefanczuk.clinic_web_service;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "patientPesel",
        "appointment"
})
@XmlRootElement(name = "makeAppointmentRequest")
@Getter
@Setter
public class MakeAppointmentRequest {

    private String patientPesel;
    private Appointment appointment;
}

