/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDataSync;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDataSyncDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDataSyncService
extends IPSModelService<PSDEDataSync, PSDEDataSyncDTO> {
    public List<PSDEDataSync> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEDataSync get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEDataSyncDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

