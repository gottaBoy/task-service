/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppUtilPage;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppUtilPageDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppUtilPageService
extends IPSModelService<PSAppUtilPage, PSAppUtilPageDTO> {
    public List<PSAppUtilPage> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppUtilPage get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppUtilPageDTO> listDTOByPSSysApp(String var1) throws Exception;
}

