/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDQCode;
import net.ibizsys.modelapi.domain.PSDEDQCodeExp;
import net.ibizsys.modelapi.dto.PSDEDQCodeExpDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDQCodeExpService
extends IPSModelService<PSDEDQCodeExp, PSDEDQCodeExpDTO> {
    public List<PSDEDQCodeExp> listByPSDEDQCode(PSDEDQCode var1) throws Exception;

    public PSDEDQCodeExp get(PSDEDQCode var1, String var2, boolean var3) throws Exception;

    public List<PSDEDQCodeExpDTO> listDTOByPSDEDQCode(String var1) throws Exception;
}

