package org.integracao.model;

import lombok.Data;

import java.util.Date;

@Data
public class AttendancePatient {

    private Long idIntegracao;
    private String nmPaciente;
    private Date dtNascimento;
    private Integer nrAtendimento;
    private String ieTipoAtendimento;
    private String nmEstabelecimento;
    private String dsSetorAtendimento;
    private String nmMedico;
    private String ieSexoPac;
    private String cdEspecialidade;
    private String dsEspecialidade;
    private Double qtTemp;
    private String qtTempUnidMed;
    private Double qtPaSistolica;
    private String qtPaSistolicaUnidMed;
    private Double qtPaDiasistolica;
    private String qtPaDiasistolicaUnidMed;
    private Double qtSaturacaoO2;
    private String qtSatO2UnidMed;
    private Double qtGlicemiaCapilar;
    private String qtGlicemiaCapilarUnidMed;
    private Double qtPeso;
    private String qtPesoUnidMed;
    private Double qtAlturaCm;
    private String qtAlturaCmUnidMed;
    private Double qtCircunfPanturrilha;
    private String qtCircunfPantUnidMed;
    private Double qtCircunfBraco;
    private String qtCircunfBracoUnidMed;
    private Double qtCircunfCintura;
    private String qtCircunfCinturaUnidMed;

}
