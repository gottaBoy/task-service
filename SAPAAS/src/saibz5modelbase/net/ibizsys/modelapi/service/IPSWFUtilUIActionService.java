/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysWFSetting;
import net.ibizsys.modelapi.domain.PSWFUtilUIAction;
import net.ibizsys.modelapi.domain.PSWFVersion;
import net.ibizsys.modelapi.domain.PSWorkflow;
import net.ibizsys.modelapi.dto.PSWFUtilUIActionDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWFUtilUIActionService
extends IPSModelService<PSWFUtilUIAction, PSWFUtilUIActionDTO> {
    public List<PSWFUtilUIAction> listByPSWFVersion(PSWFVersion var1) throws Exception;

    public PSWFUtilUIAction get(PSWFVersion var1, String var2, boolean var3) throws Exception;

    public List<PSWFUtilUIActionDTO> listDTOByPSWFVersion(String var1) throws Exception;

    public List<PSWFUtilUIAction> listByPSWorkflow(PSWorkflow var1) throws Exception;

    public PSWFUtilUIAction get(PSWorkflow var1, String var2, boolean var3) throws Exception;

    public List<PSWFUtilUIActionDTO> listDTOByPSWorkflow(String var1) throws Exception;

    public List<PSWFUtilUIAction> listByPSSysWFSetting(PSSysWFSetting var1) throws Exception;

    public PSWFUtilUIAction get(PSSysWFSetting var1, String var2, boolean var3) throws Exception;

    public List<PSWFUtilUIActionDTO> listDTOByPSSysWFSetting(String var1) throws Exception;
}

