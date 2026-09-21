/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysMsgTarget;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysMsgTargetDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysMsgTargetService
extends IPSModelService<PSSysMsgTarget, PSSysMsgTargetDTO> {
    public List<PSSysMsgTarget> listByPSModule(PSModule var1) throws Exception;

    public PSSysMsgTarget get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysMsgTargetDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysMsgTarget> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysMsgTarget get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysMsgTargetDTO> listDTOByPSSystem(String var1) throws Exception;
}

