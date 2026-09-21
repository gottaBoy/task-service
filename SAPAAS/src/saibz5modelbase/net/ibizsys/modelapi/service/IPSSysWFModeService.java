/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysWFMode;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysWFModeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysWFModeService
extends IPSModelService<PSSysWFMode, PSSysWFModeDTO> {
    public List<PSSysWFMode> listByPSModule(PSModule var1) throws Exception;

    public PSSysWFMode get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysWFModeDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysWFMode> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysWFMode get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysWFModeDTO> listDTOByPSSystem(String var1) throws Exception;
}

