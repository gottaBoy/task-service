/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysDataSyncAgent;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysDataSyncAgentDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDataSyncAgentService
extends IPSModelService<PSSysDataSyncAgent, PSSysDataSyncAgentDTO> {
    public List<PSSysDataSyncAgent> listByPSModule(PSModule var1) throws Exception;

    public PSSysDataSyncAgent get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysDataSyncAgentDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysDataSyncAgent> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysDataSyncAgent get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysDataSyncAgentDTO> listDTOByPSSystem(String var1) throws Exception;
}

