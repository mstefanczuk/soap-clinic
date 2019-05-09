package pl.mstefanczuk.clinic_web_service;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "appointment"
})
@XmlRootElement(name = "changeAppointmentDateTimeResponse")
@Getter
@Setter
public class ChangeAppointmentDateTimeResponse {

    private Appointment appointment;
}
