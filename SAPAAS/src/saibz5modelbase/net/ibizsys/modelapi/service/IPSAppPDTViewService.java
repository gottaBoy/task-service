/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppPDTView;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppPDTViewDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppPDTViewService
extends IPSModelService<PSAppPDTView, PSAppPDTViewDTO> {
    public List<PSAppPDTView> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppPDTView get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppPDTViewDTO> listDTOByPSSysApp(String var1) throws Exception;
}

