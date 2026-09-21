/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysModelGroup;
import net.ibizsys.modelapi.domain.PSSysRef;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSModuleService
extends IPSModelService<PSModule, PSModuleDTO> {
    public List<PSModule> listByPSSysModelGroup(PSSysModelGroup var1) throws Exception;

    public PSModule get(PSSysModelGroup var1, String var2, boolean var3) throws Exception;

    public List<PSModuleDTO> listDTOByPSSysModelGroup(String var1) throws Exception;

    public List<PSModule> listByPSSysRef(PSSysRef var1) throws Exception;

    public PSModule get(PSSysRef var1, String var2, boolean var3) throws Exception;

    public List<PSModuleDTO> listDTOByPSSysRef(String var1) throws Exception;

    public List<PSModule> listByPSSystem(PSSystem var1) throws Exception;

    public PSModule get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSModuleDTO> listDTOByPSSystem(String var1) throws Exception;
}

