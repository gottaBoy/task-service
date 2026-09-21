/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDELogic;
import net.ibizsys.modelapi.domain.PSDELogicParam;
import net.ibizsys.modelapi.dto.PSDELogicParamDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDELogicParamService
extends IPSModelService<PSDELogicParam, PSDELogicParamDTO> {
    public List<PSDELogicParam> listByPSDELogic(PSDELogic var1) throws Exception;

    public PSDELogicParam get(PSDELogic var1, String var2, boolean var3) throws Exception;

    public List<PSDELogicParamDTO> listDTOByPSDELogic(String var1) throws Exception;
}

