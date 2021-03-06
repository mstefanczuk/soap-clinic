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
        "appointmentDateTime"
})
@XmlRootElement(name = "cancelAppointmentRequest")
@Getter
@Setter
public class CancelAppointmentRequest {

    private String patientPesel;
    private String appointmentDateTime;
}
