/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppPortlet;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppPortletDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppPortletService
extends IPSModelService<PSAppPortlet, PSAppPortletDTO> {
    public List<PSAppPortlet> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppPortlet get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppPortletDTO> listDTOByPSSysApp(String var1) throws Exception;
}

