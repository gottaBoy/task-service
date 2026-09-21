/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDataView;
import net.ibizsys.modelapi.domain.PSDEList;
import net.ibizsys.modelapi.domain.PSDEListItem;
import net.ibizsys.modelapi.dto.PSDEListItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEListItemService
extends IPSModelService<PSDEListItem, PSDEListItemDTO> {
    public List<PSDEListItem> listByPSDEDataView(PSDEDataView var1) throws Exception;

    public PSDEListItem get(PSDEDataView var1, String var2, boolean var3) throws Exception;

    public List<PSDEListItemDTO> listDTOByPSDEDataView(String var1) throws Exception;

    public List<PSDEListItem> listByPSDEList(PSDEList var1) throws Exception;

    public PSDEListItem get(PSDEList var1, String var2, boolean var3) throws Exception;

    public List<PSDEListItemDTO> listDTOByPSDEList(String var1) throws Exception;
}

