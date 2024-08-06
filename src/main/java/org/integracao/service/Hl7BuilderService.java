package org.integracao.service;

import org.integracao.model.AttendancePatient;
import org.integracao.model.Hl7Objects;
import org.springframework.stereotype.Service;

@Service
public class Hl7BuilderService {

    public Hl7Objects buildHl7Object(AttendancePatient attendancePatient) {
        Hl7Objects hl7Object = new Hl7Objects();
        hl7Object.setResourceType("Encounter");
        hl7Object.setIdentifier(String.valueOf(attendancePatient.getNrAtendimento()));
        // Build other HL7 components based on AttendancePatient data...
        return hl7Object;
    }
}
