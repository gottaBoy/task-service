/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysTDItem;
import net.ibizsys.modelapi.domain.PSSysTestData;
import net.ibizsys.modelapi.dto.PSSysTDItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysTDItemService
extends IPSModelService<PSSysTDItem, PSSysTDItemDTO> {
    public List<PSSysTDItem> listByPSSysTestData(PSSysTestData var1) throws Exception;

    public PSSysTDItem get(PSSysTestData var1, String var2, boolean var3) throws Exception;

    public List<PSSysTDItemDTO> listDTOByPSSysTestData(String var1) throws Exception;
}

