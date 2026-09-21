/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysCounter;
import net.ibizsys.modelapi.domain.PSSysCounterItem;
import net.ibizsys.modelapi.dto.PSSysCounterItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysCounterItemService
extends IPSModelService<PSSysCounterItem, PSSysCounterItemDTO> {
    public List<PSSysCounterItem> listByPSSysCounter(PSSysCounter var1) throws Exception;

    public PSSysCounterItem get(PSSysCounter var1, String var2, boolean var3) throws Exception;

    public List<PSSysCounterItemDTO> listDTOByPSSysCounter(String var1) throws Exception;
}

