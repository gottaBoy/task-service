/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysEAIDE;
import net.ibizsys.modelapi.domain.PSSysEAIDEField;
import net.ibizsys.modelapi.dto.PSSysEAIDEFieldDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysEAIDEFieldService
extends IPSModelService<PSSysEAIDEField, PSSysEAIDEFieldDTO> {
    public List<PSSysEAIDEField> listByPSSysEAIDE(PSSysEAIDE var1) throws Exception;

    public PSSysEAIDEField get(PSSysEAIDE var1, String var2, boolean var3) throws Exception;

    public List<PSSysEAIDEFieldDTO> listDTOByPSSysEAIDE(String var1) throws Exception;
}

