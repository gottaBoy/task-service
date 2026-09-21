/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDataSet;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDataSetService
extends IPSModelService<PSDEDataSet, PSDEDataSetDTO> {
    public List<PSDEDataSet> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEDataSet get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEDataSetDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

