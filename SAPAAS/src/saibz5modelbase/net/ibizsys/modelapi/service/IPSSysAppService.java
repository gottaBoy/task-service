/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysAppService
extends IPSModelService<PSSysApp, PSSysAppDTO> {
    public List<PSSysApp> listByPSModule(PSModule var1) throws Exception;

    public PSSysApp get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysAppDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysApp> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysApp get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysAppDTO> listDTOByPSSystem(String var1) throws Exception;
}

