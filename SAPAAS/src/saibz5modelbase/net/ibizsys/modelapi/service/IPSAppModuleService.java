/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppModule;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppModuleDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppModuleService
extends IPSModelService<PSAppModule, PSAppModuleDTO> {
    public List<PSAppModule> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppModule get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppModuleDTO> listDTOByPSSysApp(String var1) throws Exception;
}

