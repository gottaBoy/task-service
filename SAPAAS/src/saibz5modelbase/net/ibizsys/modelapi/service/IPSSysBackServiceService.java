/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysBackService;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysBackServiceDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBackServiceService
extends IPSModelService<PSSysBackService, PSSysBackServiceDTO> {
    public List<PSSysBackService> listByPSModule(PSModule var1) throws Exception;

    public PSSysBackService get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysBackServiceDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysBackService> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysBackService get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysBackServiceDTO> listDTOByPSSystem(String var1) throws Exception;
}

