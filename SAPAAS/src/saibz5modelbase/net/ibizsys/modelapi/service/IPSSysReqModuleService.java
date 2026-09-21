/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysReqModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysReqModuleDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysReqModuleService
extends IPSModelService<PSSysReqModule, PSSysReqModuleDTO> {
    public List<PSSysReqModule> listByPSSysReqModule(PSSysReqModule var1) throws Exception;

    public PSSysReqModule get(PSSysReqModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysReqModuleDTO> listDTOByPSSysReqModule(String var1) throws Exception;

    public List<PSSysReqModule> listByPSModule(PSModule var1) throws Exception;

    public PSSysReqModule get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysReqModuleDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysReqModule> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysReqModule get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysReqModuleDTO> listDTOByPSSystem(String var1) throws Exception;

    public List<PSSysReqModule> listAllChild(PSSysReqModule var1) throws Exception;

    public List<PSSysReqModule> listAllByPSModule(PSModule var1) throws Exception;

    public List<PSSysReqModuleDTO> listAllDTOByPSModule(String var1) throws Exception;

    public List<PSSysReqModule> listAllByPSSystem(PSSystem var1) throws Exception;

    public List<PSSysReqModuleDTO> listAllDTOByPSSystem(String var1) throws Exception;
}

