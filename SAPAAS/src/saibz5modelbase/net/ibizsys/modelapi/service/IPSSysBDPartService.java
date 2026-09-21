/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBDPart;
import net.ibizsys.modelapi.domain.PSSysBDScheme;
import net.ibizsys.modelapi.dto.PSSysBDPartDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBDPartService
extends IPSModelService<PSSysBDPart, PSSysBDPartDTO> {
    public List<PSSysBDPart> listByPSSysBDScheme(PSSysBDScheme var1) throws Exception;

    public PSSysBDPart get(PSSysBDScheme var1, String var2, boolean var3) throws Exception;

    public List<PSSysBDPartDTO> listDTOByPSSysBDScheme(String var1) throws Exception;
}

