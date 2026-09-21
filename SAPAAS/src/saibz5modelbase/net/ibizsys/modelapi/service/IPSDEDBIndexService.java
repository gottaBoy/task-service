/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDBIndex;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDBIndexDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDBIndexService
extends IPSModelService<PSDEDBIndex, PSDEDBIndexDTO> {
    public List<PSDEDBIndex> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEDBIndex get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEDBIndexDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

