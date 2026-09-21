/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEList;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEListDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEListService
extends IPSModelService<PSDEList, PSDEListDTO> {
    public List<PSDEList> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEList get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEListDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

