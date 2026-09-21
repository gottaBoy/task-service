/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDataView;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDataViewDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDataViewService
extends IPSModelService<PSDEDataView, PSDEDataViewDTO> {
    public List<PSDEDataView> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEDataView get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEDataViewDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

