/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysDynaModel;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDynaModelService
extends IPSModelService<PSSysDynaModel, PSSysDynaModelDTO> {
    public List<PSSysDynaModel> listByPSModule(PSModule var1) throws Exception;

    public PSSysDynaModel get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysDynaModelDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysDynaModel> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysDynaModel get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysDynaModelDTO> listDTOByPSSystem(String var1) throws Exception;
}

