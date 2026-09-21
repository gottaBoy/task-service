/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDataQuery;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDataQueryDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDataQueryService
extends IPSModelService<PSDEDataQuery, PSDEDataQueryDTO> {
    public List<PSDEDataQuery> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEDataQuery get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEDataQueryDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

