/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysSFPlugin;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysSFPluginService
extends IPSModelService<PSSysSFPlugin, PSSysSFPluginDTO> {
    public List<PSSysSFPlugin> listByPSModule(PSModule var1) throws Exception;

    public PSSysSFPlugin get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysSFPluginDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysSFPlugin> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysSFPlugin get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysSFPluginDTO> listDTOByPSSystem(String var1) throws Exception;
}

