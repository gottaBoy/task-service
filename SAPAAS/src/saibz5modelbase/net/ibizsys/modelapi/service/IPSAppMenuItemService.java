/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppMenu;
import net.ibizsys.modelapi.domain.PSAppMenuItem;
import net.ibizsys.modelapi.dto.PSAppMenuItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppMenuItemService
extends IPSModelService<PSAppMenuItem, PSAppMenuItemDTO> {
    public List<PSAppMenuItem> listByPSAppMenuItem(PSAppMenuItem var1) throws Exception;

    public PSAppMenuItem get(PSAppMenuItem var1, String var2, boolean var3) throws Exception;

    public List<PSAppMenuItemDTO> listDTOByPSAppMenuItem(String var1) throws Exception;

    public List<PSAppMenuItem> listByPSAppMenu(PSAppMenu var1) throws Exception;

    public PSAppMenuItem get(PSAppMenu var1, String var2, boolean var3) throws Exception;

    public List<PSAppMenuItemDTO> listDTOByPSAppMenu(String var1) throws Exception;

    public List<PSAppMenuItem> listAllChild(PSAppMenuItem var1) throws Exception;

    public List<PSAppMenuItem> listAllByPSAppMenu(PSAppMenu var1) throws Exception;

    public List<PSAppMenuItemDTO> listAllDTOByPSAppMenu(String var1) throws Exception;
}

