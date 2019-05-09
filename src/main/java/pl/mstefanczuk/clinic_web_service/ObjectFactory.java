package pl.mstefanczuk.clinic_web_service;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public GetPatientRequest createGetPatientRequest() {
        return new GetPatientRequest();
    }

    public GetPatientResponse createGetPatientResponse() {
        return new GetPatientResponse();
    }

    public Patient createPatient() {
        return new Patient();
    }

    public Appointment createAppointment() {
        return new Appointment();
    }
}
