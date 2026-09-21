/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppPkg;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppPkgDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppPkgService
extends IPSModelService<PSAppPkg, PSAppPkgDTO> {
    public List<PSAppPkg> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppPkg get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppPkgDTO> listDTOByPSSysApp(String var1) throws Exception;
}

