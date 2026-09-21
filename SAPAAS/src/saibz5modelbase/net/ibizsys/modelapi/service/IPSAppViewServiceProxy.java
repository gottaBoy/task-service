/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppModule;
import net.ibizsys.modelapi.domain.PSAppView;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppViewDTO;
import net.ibizsys.modelapi.service.IPSAppViewService;

public interface IPSAppViewServiceProxy
extends IPSAppViewService<PSAppView, PSAppViewDTO> {
    @Override
    public List<PSAppView> listByPSAppModule(PSAppModule var1) throws Exception;

    @Override
    public PSAppView get(PSAppModule var1, String var2, boolean var3) throws Exception;

    @Override
    public List<PSAppViewDTO> listDTOByPSAppModule(String var1) throws Exception;

    @Override
    public List<PSAppView> listByPSSysApp(PSSysApp var1) throws Exception;

    @Override
    public PSAppView get(PSSysApp var1, String var2, boolean var3) throws Exception;

    @Override
    public List<PSAppViewDTO> listDTOByPSSysApp(String var1) throws Exception;
}

