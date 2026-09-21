/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBDScheme;
import net.ibizsys.modelapi.domain.PSSysBDTableRS;
import net.ibizsys.modelapi.dto.PSSysBDTableRSDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBDTableRSService
extends IPSModelService<PSSysBDTableRS, PSSysBDTableRSDTO> {
    public List<PSSysBDTableRS> listByPSSysBDScheme(PSSysBDScheme var1) throws Exception;

    public PSSysBDTableRS get(PSSysBDScheme var1, String var2, boolean var3) throws Exception;

    public List<PSSysBDTableRSDTO> listDTOByPSSysBDScheme(String var1) throws Exception;
}

