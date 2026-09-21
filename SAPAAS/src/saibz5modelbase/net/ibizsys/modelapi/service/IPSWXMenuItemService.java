/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSWXMenu;
import net.ibizsys.modelapi.domain.PSWXMenuItem;
import net.ibizsys.modelapi.dto.PSWXMenuItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWXMenuItemService
extends IPSModelService<PSWXMenuItem, PSWXMenuItemDTO> {
    public List<PSWXMenuItem> listByPSWXMenuItem(PSWXMenuItem var1) throws Exception;

    public PSWXMenuItem get(PSWXMenuItem var1, String var2, boolean var3) throws Exception;

    public List<PSWXMenuItemDTO> listDTOByPSWXMenuItem(String var1) throws Exception;

    public List<PSWXMenuItem> listByPSWXMenu(PSWXMenu var1) throws Exception;

    public PSWXMenuItem get(PSWXMenu var1, String var2, boolean var3) throws Exception;

    public List<PSWXMenuItemDTO> listDTOByPSWXMenu(String var1) throws Exception;

    public List<PSWXMenuItem> listAllChild(PSWXMenuItem var1) throws Exception;

    public List<PSWXMenuItem> listAllByPSWXMenu(PSWXMenu var1) throws Exception;

    public List<PSWXMenuItemDTO> listAllDTOByPSWXMenu(String var1) throws Exception;
}

