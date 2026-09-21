/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEFSFItem;
import net.ibizsys.modelapi.domain.PSDEField;
import net.ibizsys.modelapi.dto.PSDEFSFItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFSFItemService
extends IPSModelService<PSDEFSFItem, PSDEFSFItemDTO> {
    public List<PSDEFSFItem> listByPSDEField(PSDEField var1) throws Exception;

    public PSDEFSFItem get(PSDEField var1, String var2, boolean var3) throws Exception;

    public List<PSDEFSFItemDTO> listDTOByPSDEField(String var1) throws Exception;
}

