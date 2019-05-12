package pl.mstefanczuk.soapclinic.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.mstefanczuk.clinic_web_service.*;
import pl.mstefanczuk.soapclinic.repository.PatientRepository;

@Endpoint
public class PatientEndpoint {

    private static final String NAMESPACE_URI = "http://mstefanczuk.pl/clinic-web-service";

    private final PatientRepository patientRepository;

    @Autowired
    public PatientEndpoint(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPatientRequest")
    @ResponsePayload
    public GetPatientResponse getPatient(@RequestPayload GetPatientRequest request) {
        GetPatientResponse response = new GetPatientResponse();
        response.setPatient(patientRepository.findPatient(request.getPesel()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createPatientRequest")
    @ResponsePayload
    public CreatePatientResponse createPatient(@RequestPayload CreatePatientRequest request) {
        CreatePatientResponse response = new CreatePatientResponse();
        Patient patient = request.getPatient();
        patientRepository.createPatient(request.getPatient());
        response.setPesel(patient.getPesel());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "makeAppointmentRequest")
    @ResponsePayload
    public MakeAppointmentResponse makeAppointment(@RequestPayload MakeAppointmentRequest request) {
        MakeAppointmentResponse response = new MakeAppointmentResponse();
        Appointment appointment = patientRepository.makeAppointment(request.getPatientPesel(), request.getAppointment());
        response.setAppointment(appointment);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "changeAppointmentDateTimeRequest")
    @ResponsePayload
    public ChangeAppointmentDateTimeResponse changeAppointmentDateTime(@RequestPayload ChangeAppointmentDateTimeRequest request) {
        ChangeAppointmentDateTimeResponse response = new ChangeAppointmentDateTimeResponse();
        Appointment appointment = patientRepository.changeAppointmentDateTime(request.getPatientPesel(),
                request.getOldDateTime(), request.getNewDateTime());
        response.setAppointment(appointment);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "cancelAppointmentRequest")
    @ResponsePayload
    public CancelAppointmentResponse cancelAppointment(@RequestPayload CancelAppointmentRequest request) {
        CancelAppointmentResponse response = new CancelAppointmentResponse();
        String responseString = patientRepository.cancelAppointment(request.getPatientPesel(), request.getAppointmentDateTime());
        response.setResponse(responseString);
        return response;
    }
}
