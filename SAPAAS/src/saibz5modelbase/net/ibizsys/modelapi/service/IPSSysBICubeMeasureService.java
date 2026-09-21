/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBICube;
import net.ibizsys.modelapi.domain.PSSysBICubeMeasure;
import net.ibizsys.modelapi.dto.PSSysBICubeMeasureDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBICubeMeasureService
extends IPSModelService<PSSysBICubeMeasure, PSSysBICubeMeasureDTO> {
    public List<PSSysBICubeMeasure> listByPSSysBICube(PSSysBICube var1) throws Exception;

    public PSSysBICubeMeasure get(PSSysBICube var1, String var2, boolean var3) throws Exception;

    public List<PSSysBICubeMeasureDTO> listDTOByPSSysBICube(String var1) throws Exception;
}

