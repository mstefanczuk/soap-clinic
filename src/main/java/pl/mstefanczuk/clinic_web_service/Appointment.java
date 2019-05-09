package pl.mstefanczuk.clinic_web_service;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appointment", propOrder = {
        "appointmentDateTime",
        "roomNumber"
})
@Getter
@Setter
public class Appointment {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    private String appointmentDateTime;
    private int roomNumber;
}
