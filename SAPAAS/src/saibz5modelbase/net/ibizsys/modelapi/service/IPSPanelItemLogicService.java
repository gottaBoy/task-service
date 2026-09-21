/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSPanelItemLogic;
import net.ibizsys.modelapi.domain.PSSysViewPanelItem;
import net.ibizsys.modelapi.dto.PSPanelItemLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSPanelItemLogicService
extends IPSModelService<PSPanelItemLogic, PSPanelItemLogicDTO> {
    public List<PSPanelItemLogic> listByPSPanelItemLogic(PSPanelItemLogic var1) throws Exception;

    public PSPanelItemLogic get(PSPanelItemLogic var1, String var2, boolean var3) throws Exception;

    public List<PSPanelItemLogicDTO> listDTOByPSPanelItemLogic(String var1) throws Exception;

    public List<PSPanelItemLogic> listByPSSysViewPanelItem(PSSysViewPanelItem var1) throws Exception;

    public PSPanelItemLogic get(PSSysViewPanelItem var1, String var2, boolean var3) throws Exception;

    public List<PSPanelItemLogicDTO> listDTOByPSSysViewPanelItem(String var1) throws Exception;

    public List<PSPanelItemLogic> listAllChild(PSPanelItemLogic var1) throws Exception;

    public List<PSPanelItemLogic> listAllByPSSysViewPanelItem(PSSysViewPanelItem var1) throws Exception;

    public List<PSPanelItemLogicDTO> listAllDTOByPSSysViewPanelItem(String var1) throws Exception;
}

