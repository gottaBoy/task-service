/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEAction;
import net.ibizsys.modelapi.domain.PSDEActionParam;
import net.ibizsys.modelapi.dto.PSDEActionParamDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEActionParamService
extends IPSModelService<PSDEActionParam, PSDEActionParamDTO> {
    public List<PSDEActionParam> listByPSDEAction(PSDEAction var1) throws Exception;

    public PSDEActionParam get(PSDEAction var1, String var2, boolean var3) throws Exception;

    public List<PSDEActionParamDTO> listDTOByPSDEAction(String var1) throws Exception;
}

