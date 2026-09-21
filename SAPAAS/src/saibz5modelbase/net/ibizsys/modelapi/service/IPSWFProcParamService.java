/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSWFProcParam;
import net.ibizsys.modelapi.domain.PSWFProcess;
import net.ibizsys.modelapi.dto.PSWFProcParamDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWFProcParamService
extends IPSModelService<PSWFProcParam, PSWFProcParamDTO> {
    public List<PSWFProcParam> listByPSWFProcess(PSWFProcess var1) throws Exception;

    public PSWFProcParam get(PSWFProcess var1, String var2, boolean var3) throws Exception;

    public List<PSWFProcParamDTO> listDTOByPSWFProcess(String var1) throws Exception;
}

