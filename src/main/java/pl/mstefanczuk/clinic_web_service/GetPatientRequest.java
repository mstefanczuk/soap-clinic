package pl.mstefanczuk.clinic_web_service;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "pesel"
})
@XmlRootElement(name = "getPatientRequest")
@Getter
@Setter
public class GetPatientRequest {

    private String pesel;
}
