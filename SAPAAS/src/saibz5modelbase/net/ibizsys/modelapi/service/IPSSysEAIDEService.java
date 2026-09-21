/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysEAIDE;
import net.ibizsys.modelapi.domain.PSSysEAIScheme;
import net.ibizsys.modelapi.dto.PSSysEAIDEDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysEAIDEService
extends IPSModelService<PSSysEAIDE, PSSysEAIDEDTO> {
    public List<PSSysEAIDE> listByPSSysEAIScheme(PSSysEAIScheme var1) throws Exception;

    public PSSysEAIDE get(PSSysEAIScheme var1, String var2, boolean var3) throws Exception;

    public List<PSSysEAIDEDTO> listDTOByPSSysEAIScheme(String var1) throws Exception;
}

