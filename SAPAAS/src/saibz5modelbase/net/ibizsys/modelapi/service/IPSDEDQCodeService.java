/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDQCode;
import net.ibizsys.modelapi.domain.PSDEDataQuery;
import net.ibizsys.modelapi.dto.PSDEDQCodeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDQCodeService
extends IPSModelService<PSDEDQCode, PSDEDQCodeDTO> {
    public List<PSDEDQCode> listByPSDEDataQuery(PSDEDataQuery var1) throws Exception;

    public PSDEDQCode get(PSDEDataQuery var1, String var2, boolean var3) throws Exception;

    public List<PSDEDQCodeDTO> listDTOByPSDEDataQuery(String var1) throws Exception;
}

