/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDERepItem;
import net.ibizsys.modelapi.domain.PSDEReport;
import net.ibizsys.modelapi.dto.PSDERepItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDERepItemService
extends IPSModelService<PSDERepItem, PSDERepItemDTO> {
    public List<PSDERepItem> listByPSDEReport(PSDEReport var1) throws Exception;

    public PSDERepItem get(PSDEReport var1, String var2, boolean var3) throws Exception;

    public List<PSDERepItemDTO> listDTOByPSDEReport(String var1) throws Exception;
}

