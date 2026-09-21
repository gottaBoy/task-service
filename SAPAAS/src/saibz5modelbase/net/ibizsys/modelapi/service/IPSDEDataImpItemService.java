/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDataImp;
import net.ibizsys.modelapi.domain.PSDEDataImpItem;
import net.ibizsys.modelapi.dto.PSDEDataImpItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDataImpItemService
extends IPSModelService<PSDEDataImpItem, PSDEDataImpItemDTO> {
    public List<PSDEDataImpItem> listByPSDEDataImp(PSDEDataImp var1) throws Exception;

    public PSDEDataImpItem get(PSDEDataImp var1, String var2, boolean var3) throws Exception;

    public List<PSDEDataImpItemDTO> listDTOByPSDEDataImp(String var1) throws Exception;
}

