/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysDBProc;
import net.ibizsys.modelapi.domain.PSSysDBScheme;
import net.ibizsys.modelapi.dto.PSSysDBProcDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDBProcService
extends IPSModelService<PSSysDBProc, PSSysDBProcDTO> {
    public List<PSSysDBProc> listByPSSysDBScheme(PSSysDBScheme var1) throws Exception;

    public PSSysDBProc get(PSSysDBScheme var1, String var2, boolean var3) throws Exception;

    public List<PSSysDBProcDTO> listDTOByPSSysDBScheme(String var1) throws Exception;
}

