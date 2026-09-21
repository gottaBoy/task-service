/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppMenu;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppMenuDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppMenuService
extends IPSModelService<PSAppMenu, PSAppMenuDTO> {
    public List<PSAppMenu> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppMenu get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppMenuDTO> listDTOByPSSysApp(String var1) throws Exception;
}

