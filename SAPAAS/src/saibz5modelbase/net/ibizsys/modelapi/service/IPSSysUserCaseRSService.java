/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysUserCaseRS;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysUserCaseRSDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysUserCaseRSService
extends IPSModelService<PSSysUserCaseRS, PSSysUserCaseRSDTO> {
    public List<PSSysUserCaseRS> listByPSModule(PSModule var1) throws Exception;

    public PSSysUserCaseRS get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysUserCaseRSDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysUserCaseRS> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysUserCaseRS get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysUserCaseRSDTO> listDTOByPSSystem(String var1) throws Exception;
}

