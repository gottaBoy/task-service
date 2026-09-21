/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysTestData;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysTestDataDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysTestDataService
extends IPSModelService<PSSysTestData, PSSysTestDataDTO> {
    public List<PSSysTestData> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSSysTestData get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSSysTestDataDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSSysTestData> listByPSModule(PSModule var1) throws Exception;

    public PSSysTestData get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysTestDataDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysTestData> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysTestData get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysTestDataDTO> listDTOByPSSystem(String var1) throws Exception;
}

