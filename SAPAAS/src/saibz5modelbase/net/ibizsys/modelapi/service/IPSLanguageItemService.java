/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSLanguage;
import net.ibizsys.modelapi.domain.PSLanguageItem;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.dto.PSLanguageItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSLanguageItemService
extends IPSModelService<PSLanguageItem, PSLanguageItemDTO> {
    public List<PSLanguageItem> listByPSModule(PSModule var1) throws Exception;

    public PSLanguageItem get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSLanguageItemDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSLanguageItem> listByPSLanguage(PSLanguage var1) throws Exception;

    public PSLanguageItem get(PSLanguage var1, String var2, boolean var3) throws Exception;

    public List<PSLanguageItemDTO> listDTOByPSLanguage(String var1) throws Exception;
}

