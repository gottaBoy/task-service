/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysUserDR;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysUserDRDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysUserDRService
extends IPSModelService<PSSysUserDR, PSSysUserDRDTO> {
    public List<PSSysUserDR> listByPSModule(PSModule var1) throws Exception;

    public PSSysUserDR get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysUserDRDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysUserDR> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysUserDR get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysUserDRDTO> listDTOByPSSystem(String var1) throws Exception;
}

