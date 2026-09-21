/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppTitleBar;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppTitleBarDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppTitleBarService
extends IPSModelService<PSAppTitleBar, PSAppTitleBarDTO> {
    public List<PSAppTitleBar> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppTitleBar get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppTitleBarDTO> listDTOByPSSysApp(String var1) throws Exception;
}

