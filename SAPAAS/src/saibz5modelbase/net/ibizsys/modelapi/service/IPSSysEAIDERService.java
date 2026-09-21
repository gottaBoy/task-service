/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysEAIDE;
import net.ibizsys.modelapi.domain.PSSysEAIDER;
import net.ibizsys.modelapi.dto.PSSysEAIDERDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysEAIDERService
extends IPSModelService<PSSysEAIDER, PSSysEAIDERDTO> {
    public List<PSSysEAIDER> listByPSSysEAIDE(PSSysEAIDE var1) throws Exception;

    public PSSysEAIDER get(PSSysEAIDE var1, String var2, boolean var3) throws Exception;

    public List<PSSysEAIDERDTO> listDTOByPSSysEAIDE(String var1) throws Exception;
}

