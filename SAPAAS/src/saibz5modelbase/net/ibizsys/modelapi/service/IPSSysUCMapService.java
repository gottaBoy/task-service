/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysUCMap;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysUCMapDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysUCMapService
extends IPSModelService<PSSysUCMap, PSSysUCMapDTO> {
    public List<PSSysUCMap> listByPSModule(PSModule var1) throws Exception;

    public PSSysUCMap get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysUCMapDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysUCMap> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysUCMap get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysUCMapDTO> listDTOByPSSystem(String var1) throws Exception;
}

