package pl.mstefanczuk.soapclinic.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
        customFaultCode = "{" + NullPatientPeselException.NAMESPACE_URI + "}PESEL_NULL")
public class NullPatientPeselException extends RuntimeException {

    static final String NAMESPACE_URI = "http://mstefanczuk.pl/clinic-web-service";

    public NullPatientPeselException() {
        super("Patient pesel must not be null");
    }
}
