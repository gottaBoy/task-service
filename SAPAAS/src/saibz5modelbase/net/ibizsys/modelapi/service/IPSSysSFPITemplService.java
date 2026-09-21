/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysSFPITempl;
import net.ibizsys.modelapi.domain.PSSysSFPlugin;
import net.ibizsys.modelapi.dto.PSSysSFPITemplDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysSFPITemplService
extends IPSModelService<PSSysSFPITempl, PSSysSFPITemplDTO> {
    public List<PSSysSFPITempl> listByPSSysSFPlugin(PSSysSFPlugin var1) throws Exception;

    public PSSysSFPITempl get(PSSysSFPlugin var1, String var2, boolean var3) throws Exception;

    public List<PSSysSFPITemplDTO> listDTOByPSSysSFPlugin(String var1) throws Exception;
}

