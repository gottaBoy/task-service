/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysPFPITempl;
import net.ibizsys.modelapi.domain.PSSysPFPlugin;
import net.ibizsys.modelapi.dto.PSSysPFPITemplDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysPFPITemplService
extends IPSModelService<PSSysPFPITempl, PSSysPFPITemplDTO> {
    public List<PSSysPFPITempl> listByPSSysPFPlugin(PSSysPFPlugin var1) throws Exception;

    public PSSysPFPITempl get(PSSysPFPlugin var1, String var2, boolean var3) throws Exception;

    public List<PSSysPFPITemplDTO> listDTOByPSSysPFPlugin(String var1) throws Exception;
}

