/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDELNParam;
import net.ibizsys.modelapi.domain.PSDELogicNode;
import net.ibizsys.modelapi.dto.PSDELNParamDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDELNParamService
extends IPSModelService<PSDELNParam, PSDELNParamDTO> {
    public List<PSDELNParam> listByPSDELogicNode(PSDELogicNode var1) throws Exception;

    public PSDELNParam get(PSDELogicNode var1, String var2, boolean var3) throws Exception;

    public List<PSDELNParamDTO> listDTOByPSDELogicNode(String var1) throws Exception;
}

