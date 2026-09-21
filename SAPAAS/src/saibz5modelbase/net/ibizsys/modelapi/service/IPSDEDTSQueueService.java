/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDTSQueue;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDTSQueueDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDTSQueueService
extends IPSModelService<PSDEDTSQueue, PSDEDTSQueueDTO> {
    public List<PSDEDTSQueue> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEDTSQueue get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEDTSQueueDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

