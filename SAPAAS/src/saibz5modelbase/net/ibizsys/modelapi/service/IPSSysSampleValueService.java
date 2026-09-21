/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysSampleValue;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysSampleValueDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysSampleValueService
extends IPSModelService<PSSysSampleValue, PSSysSampleValueDTO> {
    public List<PSSysSampleValue> listByPSModule(PSModule var1) throws Exception;

    public PSSysSampleValue get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysSampleValueDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysSampleValue> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysSampleValue get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysSampleValueDTO> listDTOByPSSystem(String var1) throws Exception;
}

