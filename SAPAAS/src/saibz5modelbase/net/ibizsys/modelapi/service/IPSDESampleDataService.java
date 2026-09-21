/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDESampleData;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDESampleDataDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDESampleDataService
extends IPSModelService<PSDESampleData, PSDESampleDataDTO> {
    public List<PSDESampleData> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDESampleData get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDESampleDataDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

