/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysTCAssert;
import net.ibizsys.modelapi.domain.PSSysTestCase;
import net.ibizsys.modelapi.dto.PSSysTCAssertDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysTCAssertService
extends IPSModelService<PSSysTCAssert, PSSysTCAssertDTO> {
    public List<PSSysTCAssert> listByPSSysTestCase(PSSysTestCase var1) throws Exception;

    public PSSysTCAssert get(PSSysTestCase var1, String var2, boolean var3) throws Exception;

    public List<PSSysTCAssertDTO> listDTOByPSSysTestCase(String var1) throws Exception;
}

