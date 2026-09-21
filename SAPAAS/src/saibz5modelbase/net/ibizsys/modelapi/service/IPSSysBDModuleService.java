/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBDModule;
import net.ibizsys.modelapi.domain.PSSysBDScheme;
import net.ibizsys.modelapi.dto.PSSysBDModuleDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBDModuleService
extends IPSModelService<PSSysBDModule, PSSysBDModuleDTO> {
    public List<PSSysBDModule> listByPSSysBDScheme(PSSysBDScheme var1) throws Exception;

    public PSSysBDModule get(PSSysBDScheme var1, String var2, boolean var3) throws Exception;

    public List<PSSysBDModuleDTO> listDTOByPSSysBDScheme(String var1) throws Exception;
}

