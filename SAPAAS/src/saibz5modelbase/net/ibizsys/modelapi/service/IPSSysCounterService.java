/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysCounter;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysCounterDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysCounterService
extends IPSModelService<PSSysCounter, PSSysCounterDTO> {
    public List<PSSysCounter> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSSysCounter get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSSysCounterDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSSysCounter> listByPSModule(PSModule var1) throws Exception;

    public PSSysCounter get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysCounterDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysCounter> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysCounter get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysCounterDTO> listDTOByPSSystem(String var1) throws Exception;
}

