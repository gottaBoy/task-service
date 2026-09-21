/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysEAIDataType;
import net.ibizsys.modelapi.domain.PSSysEAIDataTypeItem;
import net.ibizsys.modelapi.dto.PSSysEAIDataTypeItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysEAIDataTypeItemService
extends IPSModelService<PSSysEAIDataTypeItem, PSSysEAIDataTypeItemDTO> {
    public List<PSSysEAIDataTypeItem> listByPSSysEAIDataType(PSSysEAIDataType var1) throws Exception;

    public PSSysEAIDataTypeItem get(PSSysEAIDataType var1, String var2, boolean var3) throws Exception;

    public List<PSSysEAIDataTypeItemDTO> listDTOByPSSysEAIDataType(String var1) throws Exception;
}

