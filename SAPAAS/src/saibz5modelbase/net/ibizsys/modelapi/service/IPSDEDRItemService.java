/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDRItem;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDRItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDRItemService
extends IPSModelService<PSDEDRItem, PSDEDRItemDTO> {
    public List<PSDEDRItem> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEDRItem get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEDRItemDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

