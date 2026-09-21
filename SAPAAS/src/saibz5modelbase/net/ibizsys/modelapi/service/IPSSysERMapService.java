/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysERMap;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysERMapDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysERMapService
extends IPSModelService<PSSysERMap, PSSysERMapDTO> {
    public List<PSSysERMap> listByPSModule(PSModule var1) throws Exception;

    public PSSysERMap get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysERMapDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysERMap> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysERMap get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysERMapDTO> listDTOByPSSystem(String var1) throws Exception;
}

