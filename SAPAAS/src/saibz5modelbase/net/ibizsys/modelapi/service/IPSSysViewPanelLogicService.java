/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysViewPanel;
import net.ibizsys.modelapi.domain.PSSysViewPanelLogic;
import net.ibizsys.modelapi.dto.PSSysViewPanelLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysViewPanelLogicService
extends IPSModelService<PSSysViewPanelLogic, PSSysViewPanelLogicDTO> {
    public List<PSSysViewPanelLogic> listByPSSysViewPanel(PSSysViewPanel var1) throws Exception;

    public PSSysViewPanelLogic get(PSSysViewPanel var1, String var2, boolean var3) throws Exception;

    public List<PSSysViewPanelLogicDTO> listDTOByPSSysViewPanel(String var1) throws Exception;
}

