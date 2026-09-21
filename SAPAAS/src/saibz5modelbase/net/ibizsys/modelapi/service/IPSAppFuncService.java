/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppFunc;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppFuncDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppFuncService
extends IPSModelService<PSAppFunc, PSAppFuncDTO> {
    public List<PSAppFunc> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppFunc get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppFuncDTO> listDTOByPSSysApp(String var1) throws Exception;
}

