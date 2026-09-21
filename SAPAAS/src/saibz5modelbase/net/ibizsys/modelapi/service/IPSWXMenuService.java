/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSWXAccount;
import net.ibizsys.modelapi.domain.PSWXEntApp;
import net.ibizsys.modelapi.domain.PSWXMenu;
import net.ibizsys.modelapi.dto.PSWXMenuDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWXMenuService
extends IPSModelService<PSWXMenu, PSWXMenuDTO> {
    public List<PSWXMenu> listByPSWXEntApp(PSWXEntApp var1) throws Exception;

    public PSWXMenu get(PSWXEntApp var1, String var2, boolean var3) throws Exception;

    public List<PSWXMenuDTO> listDTOByPSWXEntApp(String var1) throws Exception;

    public List<PSWXMenu> listByPSWXAccount(PSWXAccount var1) throws Exception;

    public PSWXMenu get(PSWXAccount var1, String var2, boolean var3) throws Exception;

    public List<PSWXMenuDTO> listDTOByPSWXAccount(String var1) throws Exception;
}

