package org.integracao.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.integracao.model.AttendancePatient;
import org.integracao.model.Hl7Objects;
import org.integracao.model.ResponseStatus;
import org.integracao.repository.AttendanceRepository;
import org.integracao.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private Hl7BuilderService hl7BuilderService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void processBundle(String bundleJson) {
        // Parse bundle JSON to extract necessary information
        AttendancePatient attendancePatient = parseBundle(bundleJson);

        // Build HL7 object
        Hl7Objects hl7Object = hl7BuilderService.buildHl7Object(attendancePatient);

        // Mock sending HL7 object to external API and getting response
        ResponseStatus responseStatus = sendToExternalApi(hl7Object);

        // Save response status to database
        attendanceRepository.saveResponseStatus(attendancePatient.getIdIntegracao(), responseStatus);
    }

    private AttendancePatient parseBundle(String bundleJson) {
        try {
            JsonNode root = objectMapper.readTree(bundleJson);
            JsonNode entryNode = root.path("entry").get(0);
            JsonNode resourceNode = entryNode.path("resource");

            AttendancePatient patient = new AttendancePatient();
            patient.setIdIntegracao(resourceNode.path("identifier").get(0).path("value").asLong());
            patient.setNmPaciente(resourceNode.path("name").get(0).path("text").asText());
            patient.setDtNascimento(DateUtil.parseDate(resourceNode.path("birthDate").asText()));
            // Set other properties...

            return patient;
        } catch (IOException e) {
            throw new RuntimeException("Error parsing bundle", e);
        }
    }

    private ResponseStatus sendToExternalApi(Hl7Objects hl7Object) {
        // Mock sending logic
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setStatus("T");
        responseStatus.setLog("Mock success log");
        return responseStatus;
    }
}
