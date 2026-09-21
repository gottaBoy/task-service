/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysViewLogic;
import net.ibizsys.modelapi.domain.PSSysViewLogicParam;
import net.ibizsys.modelapi.dto.PSSysViewLogicParamDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysViewLogicParamService
extends IPSModelService<PSSysViewLogicParam, PSSysViewLogicParamDTO> {
    public List<PSSysViewLogicParam> listByPSSysViewLogic(PSSysViewLogic var1) throws Exception;

    public PSSysViewLogicParam get(PSSysViewLogic var1, String var2, boolean var3) throws Exception;

    public List<PSSysViewLogicParamDTO> listDTOByPSSysViewLogic(String var1) throws Exception;
}

