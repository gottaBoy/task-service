/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBDInstCfg;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysBDInstCfgDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBDInstCfgService
extends IPSModelService<PSSysBDInstCfg, PSSysBDInstCfgDTO> {
    public List<PSSysBDInstCfg> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysBDInstCfg get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysBDInstCfgDTO> listDTOByPSSystem(String var1) throws Exception;
}

