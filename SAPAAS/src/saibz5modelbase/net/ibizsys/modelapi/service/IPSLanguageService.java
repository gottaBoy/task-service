/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSLanguage;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSLanguageDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSLanguageService
extends IPSModelService<PSLanguage, PSLanguageDTO> {
    public List<PSLanguage> listByPSSystem(PSSystem var1) throws Exception;

    public PSLanguage get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSLanguageDTO> listDTOByPSSystem(String var1) throws Exception;
}

