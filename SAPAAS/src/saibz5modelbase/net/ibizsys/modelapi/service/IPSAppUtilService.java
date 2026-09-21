/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppUtil;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppUtilDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppUtilService
extends IPSModelService<PSAppUtil, PSAppUtilDTO> {
    public List<PSAppUtil> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppUtil get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppUtilDTO> listDTOByPSSysApp(String var1) throws Exception;
}

