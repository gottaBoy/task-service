/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysEAIDataType;
import net.ibizsys.modelapi.domain.PSSysEAIScheme;
import net.ibizsys.modelapi.dto.PSSysEAIDataTypeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysEAIDataTypeService
extends IPSModelService<PSSysEAIDataType, PSSysEAIDataTypeDTO> {
    public List<PSSysEAIDataType> listByPSSysEAIScheme(PSSysEAIScheme var1) throws Exception;

    public PSSysEAIDataType get(PSSysEAIScheme var1, String var2, boolean var3) throws Exception;

    public List<PSSysEAIDataTypeDTO> listDTOByPSSysEAIScheme(String var1) throws Exception;
}

