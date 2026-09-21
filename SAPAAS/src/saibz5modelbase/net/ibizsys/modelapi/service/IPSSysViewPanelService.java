/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysViewPanel;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysViewPanelDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysViewPanelService
extends IPSModelService<PSSysViewPanel, PSSysViewPanelDTO> {
    public List<PSSysViewPanel> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSSysViewPanel get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSSysViewPanelDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSSysViewPanel> listByPSModule(PSModule var1) throws Exception;

    public PSSysViewPanel get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysViewPanelDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysViewPanel> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysViewPanel get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysViewPanelDTO> listDTOByPSSystem(String var1) throws Exception;
}

