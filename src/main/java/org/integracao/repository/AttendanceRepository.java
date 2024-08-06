package org.integracao.repository;

import org.integracao.model.ResponseStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AttendanceRepository {

    private final JdbcTemplate jdbcTemplate;

    public AttendanceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveResponseStatus(Long idIntegracao, ResponseStatus responseStatus) {
        String sql = "UPDATE GHAS_CID_T SET IE_INTEGRADO = ?, DS_LOG = ? WHERE ID_INTEGRACAO = ?";
        jdbcTemplate.update(sql, responseStatus.getStatus(), responseStatus.getLog(), idIntegracao);
    }
}
