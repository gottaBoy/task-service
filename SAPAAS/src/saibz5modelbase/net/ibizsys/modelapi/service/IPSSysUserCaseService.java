/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysUserCase;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysUserCaseDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysUserCaseService
extends IPSModelService<PSSysUserCase, PSSysUserCaseDTO> {
    public List<PSSysUserCase> listByPSModule(PSModule var1) throws Exception;

    public PSSysUserCase get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysUserCaseDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysUserCase> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysUserCase get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysUserCaseDTO> listDTOByPSSystem(String var1) throws Exception;
}

