/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysViewPanel;
import net.ibizsys.modelapi.domain.PSSysViewPanelModel;
import net.ibizsys.modelapi.dto.PSSysViewPanelModelDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysViewPanelModelService
extends IPSModelService<PSSysViewPanelModel, PSSysViewPanelModelDTO> {
    public List<PSSysViewPanelModel> listByPSSysViewPanel(PSSysViewPanel var1) throws Exception;

    public PSSysViewPanelModel get(PSSysViewPanel var1, String var2, boolean var3) throws Exception;

    public List<PSSysViewPanelModelDTO> listDTOByPSSysViewPanel(String var1) throws Exception;
}

