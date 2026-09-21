/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysTCInput;
import net.ibizsys.modelapi.domain.PSSysTestCase;
import net.ibizsys.modelapi.dto.PSSysTCInputDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysTCInputService
extends IPSModelService<PSSysTCInput, PSSysTCInputDTO> {
    public List<PSSysTCInput> listByPSSysTestCase(PSSysTestCase var1) throws Exception;

    public PSSysTCInput get(PSSysTestCase var1, String var2, boolean var3) throws Exception;

    public List<PSSysTCInputDTO> listDTOByPSSysTestCase(String var1) throws Exception;
}

