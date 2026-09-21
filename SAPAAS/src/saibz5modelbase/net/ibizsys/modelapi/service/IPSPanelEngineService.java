/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSPanelEngine;
import net.ibizsys.modelapi.domain.PSSysViewPanel;
import net.ibizsys.modelapi.dto.PSPanelEngineDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSPanelEngineService
extends IPSModelService<PSPanelEngine, PSPanelEngineDTO> {
    public List<PSPanelEngine> listByPSSysViewPanel(PSSysViewPanel var1) throws Exception;

    public PSPanelEngine get(PSSysViewPanel var1, String var2, boolean var3) throws Exception;

    public List<PSPanelEngineDTO> listDTOByPSSysViewPanel(String var1) throws Exception;
}

