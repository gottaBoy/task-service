/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDETable;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDETableDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDETableService
extends IPSModelService<PSDETable, PSDETableDTO> {
    public List<PSDETable> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDETable get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDETableDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

