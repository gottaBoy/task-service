/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDETBItem;
import net.ibizsys.modelapi.domain.PSDEToolbar;
import net.ibizsys.modelapi.dto.PSDETBItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDETBItemService
extends IPSModelService<PSDETBItem, PSDETBItemDTO> {
    public List<PSDETBItem> listByPSDETBItem(PSDETBItem var1) throws Exception;

    public PSDETBItem get(PSDETBItem var1, String var2, boolean var3) throws Exception;

    public List<PSDETBItemDTO> listDTOByPSDETBItem(String var1) throws Exception;

    public List<PSDETBItem> listByPSDEToolbar(PSDEToolbar var1) throws Exception;

    public PSDETBItem get(PSDEToolbar var1, String var2, boolean var3) throws Exception;

    public List<PSDETBItemDTO> listDTOByPSDEToolbar(String var1) throws Exception;

    public List<PSDETBItem> listAllChild(PSDETBItem var1) throws Exception;

    public List<PSDETBItem> listAllByPSDEToolbar(PSDEToolbar var1) throws Exception;

    public List<PSDETBItemDTO> listAllDTOByPSDEToolbar(String var1) throws Exception;
}

