/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDataView;
import net.ibizsys.modelapi.domain.PSDEDataViewLogic;
import net.ibizsys.modelapi.dto.PSDEDataViewLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDataViewLogicService
extends IPSModelService<PSDEDataViewLogic, PSDEDataViewLogicDTO> {
    public List<PSDEDataViewLogic> listByPSDEDataView(PSDEDataView var1) throws Exception;

    public PSDEDataViewLogic get(PSDEDataView var1, String var2, boolean var3) throws Exception;

    public List<PSDEDataViewLogicDTO> listDTOByPSDEDataView(String var1) throws Exception;
}

