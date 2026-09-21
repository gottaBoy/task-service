/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysViewLogic;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysViewLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysViewLogicService
extends IPSModelService<PSSysViewLogic, PSSysViewLogicDTO> {
    public List<PSSysViewLogic> listByPSModule(PSModule var1) throws Exception;

    public PSSysViewLogic get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysViewLogicDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysViewLogic> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysViewLogic get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysViewLogicDTO> listDTOByPSSystem(String var1) throws Exception;
}

