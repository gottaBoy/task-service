/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysReqItem;
import net.ibizsys.modelapi.domain.PSSysReqItemHis;
import net.ibizsys.modelapi.dto.PSSysReqItemHisDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysReqItemHisService
extends IPSModelService<PSSysReqItemHis, PSSysReqItemHisDTO> {
    public List<PSSysReqItemHis> listByPSSysReqItem(PSSysReqItem var1) throws Exception;

    public PSSysReqItemHis get(PSSysReqItem var1, String var2, boolean var3) throws Exception;

    public List<PSSysReqItemHisDTO> listDTOByPSSysReqItem(String var1) throws Exception;
}

