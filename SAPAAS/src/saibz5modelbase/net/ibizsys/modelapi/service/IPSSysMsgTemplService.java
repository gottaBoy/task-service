/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysMsgTempl;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysMsgTemplDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysMsgTemplService
extends IPSModelService<PSSysMsgTempl, PSSysMsgTemplDTO> {
    public List<PSSysMsgTempl> listByPSModule(PSModule var1) throws Exception;

    public PSSysMsgTempl get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysMsgTemplDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysMsgTempl> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysMsgTempl get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysMsgTemplDTO> listDTOByPSSystem(String var1) throws Exception;
}

