/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSLanguageRes;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSLanguageResService
extends IPSModelService<PSLanguageRes, PSLanguageResDTO> {
    public List<PSLanguageRes> listByPSModule(PSModule var1) throws Exception;

    public PSLanguageRes get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSLanguageResDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSLanguageRes> listByPSSystem(PSSystem var1) throws Exception;

    public PSLanguageRes get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSLanguageResDTO> listDTOByPSSystem(String var1) throws Exception;
}

