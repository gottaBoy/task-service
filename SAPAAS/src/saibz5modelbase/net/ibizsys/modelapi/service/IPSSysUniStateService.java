/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysUniState;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysUniStateDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysUniStateService
extends IPSModelService<PSSysUniState, PSSysUniStateDTO> {
    public List<PSSysUniState> listByPSModule(PSModule var1) throws Exception;

    public PSSysUniState get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysUniStateDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysUniState> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysUniState get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysUniStateDTO> listDTOByPSSystem(String var1) throws Exception;
}

