/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysPFPlugin;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysPFPluginService
extends IPSModelService<PSSysPFPlugin, PSSysPFPluginDTO> {
    public List<PSSysPFPlugin> listByPSModule(PSModule var1) throws Exception;

    public PSSysPFPlugin get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysPFPluginDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysPFPlugin> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysPFPlugin get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysPFPluginDTO> listDTOByPSSystem(String var1) throws Exception;
}

