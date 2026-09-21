/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEACMode;
import net.ibizsys.modelapi.domain.PSDEACModeItem;
import net.ibizsys.modelapi.dto.PSDEACModeItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEACModeItemService
extends IPSModelService<PSDEACModeItem, PSDEACModeItemDTO> {
    public List<PSDEACModeItem> listByPSDEACMode(PSDEACMode var1) throws Exception;

    public PSDEACModeItem get(PSDEACMode var1, String var2, boolean var3) throws Exception;

    public List<PSDEACModeItemDTO> listDTOByPSDEACMode(String var1) throws Exception;
}

