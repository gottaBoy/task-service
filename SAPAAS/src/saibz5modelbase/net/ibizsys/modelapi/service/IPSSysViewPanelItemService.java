/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysViewPanel;
import net.ibizsys.modelapi.domain.PSSysViewPanelItem;
import net.ibizsys.modelapi.dto.PSSysViewPanelItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysViewPanelItemService
extends IPSModelService<PSSysViewPanelItem, PSSysViewPanelItemDTO> {
    public List<PSSysViewPanelItem> listByPSSysViewPanelItem(PSSysViewPanelItem var1) throws Exception;

    public PSSysViewPanelItem get(PSSysViewPanelItem var1, String var2, boolean var3) throws Exception;

    public List<PSSysViewPanelItemDTO> listDTOByPSSysViewPanelItem(String var1) throws Exception;

    public List<PSSysViewPanelItem> listByPSSysViewPanel(PSSysViewPanel var1) throws Exception;

    public PSSysViewPanelItem get(PSSysViewPanel var1, String var2, boolean var3) throws Exception;

    public List<PSSysViewPanelItemDTO> listDTOByPSSysViewPanel(String var1) throws Exception;

    public List<PSSysViewPanelItem> listAllChild(PSSysViewPanelItem var1) throws Exception;

    public List<PSSysViewPanelItem> listAllByPSSysViewPanel(PSSysViewPanel var1) throws Exception;

    public List<PSSysViewPanelItemDTO> listAllDTOByPSSysViewPanel(String var1) throws Exception;
}

