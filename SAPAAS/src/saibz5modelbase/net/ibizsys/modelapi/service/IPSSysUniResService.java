/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysUniRes;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysUniResDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysUniResService
extends IPSModelService<PSSysUniRes, PSSysUniResDTO> {
    public List<PSSysUniRes> listByPSModule(PSModule var1) throws Exception;

    public PSSysUniRes get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysUniResDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysUniRes> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysUniRes get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysUniResDTO> listDTOByPSSystem(String var1) throws Exception;
}

