/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysReqItem;
import net.ibizsys.modelapi.domain.PSSysReqItemData;
import net.ibizsys.modelapi.dto.PSSysReqItemDataDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysReqItemDataService
extends IPSModelService<PSSysReqItemData, PSSysReqItemDataDTO> {
    public List<PSSysReqItemData> listByPSSysReqItem(PSSysReqItem var1) throws Exception;

    public PSSysReqItemData get(PSSysReqItem var1, String var2, boolean var3) throws Exception;

    public List<PSSysReqItemDataDTO> listDTOByPSSysReqItem(String var1) throws Exception;
}

