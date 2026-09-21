/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppView;
import net.ibizsys.modelapi.domain.PSDEAction;
import net.ibizsys.modelapi.domain.PSDEField;
import net.ibizsys.modelapi.domain.PSDELogic;
import net.ibizsys.modelapi.domain.PSDEServiceAPI;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSSysTestCase;
import net.ibizsys.modelapi.domain.PSSysTestPrj;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysTestCaseDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysTestCaseService
extends IPSModelService<PSSysTestCase, PSSysTestCaseDTO> {
    public List<PSSysTestCase> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSSysTestCase get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSSysTestCaseDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSSysTestCase> listByPSDEAction(PSDEAction var1) throws Exception;

    public PSSysTestCase get(PSDEAction var1, String var2, boolean var3) throws Exception;

    public List<PSSysTestCaseDTO> listDTOByPSDEAction(String var1) throws Exception;

    public List<PSSysTestCase> listByPSDELogic(PSDELogic var1) throws Exception;

    public PSSysTestCase get(PSDELogic var1, String var2, boolean var3) throws Exception;

    public List<PSSysTestCaseDTO> listDTOByPSDELogic(String var1) throws Exception;

    public List<PSSysTestCase> listByPSSysTestPrj(PSSysTestPrj var1) throws Exception;

    public PSSysTestCase get(PSSysTestPrj var1, String var2, boolean var3) throws Exception;

    public List<PSSysTestCaseDTO> listDTOByPSSysTestPrj(String var1) throws Exception;

    public List<PSSysTestCase> listByPSAppView(PSAppView var1) throws Exception;

    public PSSysTestCase get(PSAppView var1, String var2, boolean var3) throws Exception;

    public List<PSSysTestCaseDTO> listDTOByPSAppView(String var1) throws Exception;

    public List<PSSysTestCase> listByPSDEField(PSDEField var1) throws Exception;

    public PSSysTestCase get(PSDEField var1, String var2, boolean var3) throws Exception;

    public List<PSSysTestCaseDTO> listDTOByPSDEField(String var1) throws Exception;

    public List<PSSysTestCase> listByPSDEServiceAPI(PSDEServiceAPI var1) throws Exception;

    public PSSysTestCase get(PSDEServiceAPI var1, String var2, boolean var3) throws Exception;

    public List<PSSysTestCaseDTO> listDTOByPSDEServiceAPI(String var1) throws Exception;

    public List<PSSysTestCase> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysTestCase get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysTestCaseDTO> listDTOByPSSystem(String var1) throws Exception;
}

