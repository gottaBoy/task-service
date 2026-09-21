/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysTestModule;
import net.ibizsys.modelapi.domain.PSSysTestPrj;
import net.ibizsys.modelapi.dto.PSSysTestModuleDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysTestModuleService
extends IPSModelService<PSSysTestModule, PSSysTestModuleDTO> {
    public List<PSSysTestModule> listByPSSysTestPrj(PSSysTestPrj var1) throws Exception;

    public PSSysTestModule get(PSSysTestPrj var1, String var2, boolean var3) throws Exception;

    public List<PSSysTestModuleDTO> listDTOByPSSysTestPrj(String var1) throws Exception;
}

