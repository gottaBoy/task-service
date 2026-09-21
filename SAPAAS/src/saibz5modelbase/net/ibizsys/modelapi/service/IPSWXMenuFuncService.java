/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSWXAccount;
import net.ibizsys.modelapi.domain.PSWXEntApp;
import net.ibizsys.modelapi.domain.PSWXMenuFunc;
import net.ibizsys.modelapi.dto.PSWXMenuFuncDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWXMenuFuncService
extends IPSModelService<PSWXMenuFunc, PSWXMenuFuncDTO> {
    public List<PSWXMenuFunc> listByPSWXEntApp(PSWXEntApp var1) throws Exception;

    public PSWXMenuFunc get(PSWXEntApp var1, String var2, boolean var3) throws Exception;

    public List<PSWXMenuFuncDTO> listDTOByPSWXEntApp(String var1) throws Exception;

    public List<PSWXMenuFunc> listByPSWXAccount(PSWXAccount var1) throws Exception;

    public PSWXMenuFunc get(PSWXAccount var1, String var2, boolean var3) throws Exception;

    public List<PSWXMenuFuncDTO> listDTOByPSWXAccount(String var1) throws Exception;
}

