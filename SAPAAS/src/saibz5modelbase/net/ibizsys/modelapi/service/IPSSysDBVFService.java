/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysDBVF;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysDBVFDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDBVFService
extends IPSModelService<PSSysDBVF, PSSysDBVFDTO> {
    public List<PSSysDBVF> listByPSModule(PSModule var1) throws Exception;

    public PSSysDBVF get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysDBVFDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysDBVF> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysDBVF get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysDBVFDTO> listDTOByPSSystem(String var1) throws Exception;
}

