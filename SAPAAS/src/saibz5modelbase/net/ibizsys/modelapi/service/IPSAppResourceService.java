/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppResource;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppResourceDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppResourceService
extends IPSModelService<PSAppResource, PSAppResourceDTO> {
    public List<PSAppResource> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppResource get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppResourceDTO> listDTOByPSSysApp(String var1) throws Exception;
}

