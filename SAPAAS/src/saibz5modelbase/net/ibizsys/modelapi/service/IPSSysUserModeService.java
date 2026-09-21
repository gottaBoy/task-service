/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysUserMode;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysUserModeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysUserModeService
extends IPSModelService<PSSysUserMode, PSSysUserModeDTO> {
    public List<PSSysUserMode> listByPSModule(PSModule var1) throws Exception;

    public PSSysUserMode get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysUserModeDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysUserMode> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysUserMode get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysUserModeDTO> listDTOByPSSystem(String var1) throws Exception;
}

