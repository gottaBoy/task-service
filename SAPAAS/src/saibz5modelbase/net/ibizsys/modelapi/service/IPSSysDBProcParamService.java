/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysDBProc;
import net.ibizsys.modelapi.domain.PSSysDBProcParam;
import net.ibizsys.modelapi.dto.PSSysDBProcParamDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDBProcParamService
extends IPSModelService<PSSysDBProcParam, PSSysDBProcParamDTO> {
    public List<PSSysDBProcParam> listByPSSysDBProc(PSSysDBProc var1) throws Exception;

    public PSSysDBProcParam get(PSSysDBProc var1, String var2, boolean var3) throws Exception;

    public List<PSSysDBProcParamDTO> listDTOByPSSysDBProc(String var1) throws Exception;
}

