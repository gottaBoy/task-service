/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysMsgQueue;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysMsgQueueDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysMsgQueueService
extends IPSModelService<PSSysMsgQueue, PSSysMsgQueueDTO> {
    public List<PSSysMsgQueue> listByPSModule(PSModule var1) throws Exception;

    public PSSysMsgQueue get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysMsgQueueDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysMsgQueue> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysMsgQueue get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysMsgQueueDTO> listDTOByPSSystem(String var1) throws Exception;
}

