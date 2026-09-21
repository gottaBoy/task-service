/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysSearchBar;
import net.ibizsys.modelapi.domain.PSSysSearchBarItem;
import net.ibizsys.modelapi.dto.PSSysSearchBarItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysSearchBarItemService
extends IPSModelService<PSSysSearchBarItem, PSSysSearchBarItemDTO> {
    public List<PSSysSearchBarItem> listByPSSysSearchBar(PSSysSearchBar var1) throws Exception;

    public PSSysSearchBarItem get(PSSysSearchBar var1, String var2, boolean var3) throws Exception;

    public List<PSSysSearchBarItemDTO> listDTOByPSSysSearchBar(String var1) throws Exception;
}

