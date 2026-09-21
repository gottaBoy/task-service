/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDataImp;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDataImpDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDataImpService
extends IPSModelService<PSDEDataImp, PSDEDataImpDTO> {
    public List<PSDEDataImp> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEDataImp get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEDataImpDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

