/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysUnit;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysUnitDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysUnitService
extends IPSModelService<PSSysUnit, PSSysUnitDTO> {
    public List<PSSysUnit> listByPSModule(PSModule var1) throws Exception;

    public PSSysUnit get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysUnitDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysUnit> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysUnit get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysUnitDTO> listDTOByPSSystem(String var1) throws Exception;
}

