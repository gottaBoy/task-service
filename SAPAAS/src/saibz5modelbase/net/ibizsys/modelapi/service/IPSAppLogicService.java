/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppLogic;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppLogicService
extends IPSModelService<PSAppLogic, PSAppLogicDTO> {
    public List<PSAppLogic> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppLogic get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppLogicDTO> listDTOByPSSysApp(String var1) throws Exception;
}

