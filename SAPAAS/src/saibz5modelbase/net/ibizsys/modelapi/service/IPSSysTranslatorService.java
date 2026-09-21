/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysTranslator;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysTranslatorDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysTranslatorService
extends IPSModelService<PSSysTranslator, PSSysTranslatorDTO> {
    public List<PSSysTranslator> listByPSModule(PSModule var1) throws Exception;

    public PSSysTranslator get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysTranslatorDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysTranslator> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysTranslator get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysTranslatorDTO> listDTOByPSSystem(String var1) throws Exception;
}

