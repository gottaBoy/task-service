/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysDynaModelCat;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysDynaModelCatDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDynaModelCatService
extends IPSModelService<PSSysDynaModelCat, PSSysDynaModelCatDTO> {
    public List<PSSysDynaModelCat> listByPSModule(PSModule var1) throws Exception;

    public PSSysDynaModelCat get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysDynaModelCatDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysDynaModelCat> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysDynaModelCat get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysDynaModelCatDTO> listDTOByPSSystem(String var1) throws Exception;
}

