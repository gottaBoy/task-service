/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.domain.PSSysServiceAPI;
import net.ibizsys.modelapi.domain.PSSysTestPrj;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysTestPrjDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysTestPrjService
extends IPSModelService<PSSysTestPrj, PSSysTestPrjDTO> {
    public List<PSSysTestPrj> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSSysTestPrj get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSSysTestPrjDTO> listDTOByPSSysApp(String var1) throws Exception;

    public List<PSSysTestPrj> listByPSSysServiceAPI(PSSysServiceAPI var1) throws Exception;

    public PSSysTestPrj get(PSSysServiceAPI var1, String var2, boolean var3) throws Exception;

    public List<PSSysTestPrjDTO> listDTOByPSSysServiceAPI(String var1) throws Exception;

    public List<PSSysTestPrj> listByPSModule(PSModule var1) throws Exception;

    public PSSysTestPrj get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysTestPrjDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysTestPrj> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysTestPrj get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysTestPrjDTO> listDTOByPSSystem(String var1) throws Exception;
}

