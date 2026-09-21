/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppLan;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppLanDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppLanService
extends IPSModelService<PSAppLan, PSAppLanDTO> {
    public List<PSAppLan> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppLan get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppLanDTO> listDTOByPSSysApp(String var1) throws Exception;
}

