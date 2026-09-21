/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDQCode;
import net.ibizsys.modelapi.domain.PSDEDQCodeCond;
import net.ibizsys.modelapi.dto.PSDEDQCodeCondDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDQCodeCondService
extends IPSModelService<PSDEDQCodeCond, PSDEDQCodeCondDTO> {
    public List<PSDEDQCodeCond> listByPSDEDQCode(PSDEDQCode var1) throws Exception;

    public PSDEDQCodeCond get(PSDEDQCode var1, String var2, boolean var3) throws Exception;

    public List<PSDEDQCodeCondDTO> listDTOByPSDEDQCode(String var1) throws Exception;
}

