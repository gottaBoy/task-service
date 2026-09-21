/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSWFProcSubWF;
import net.ibizsys.modelapi.domain.PSWFProcess;
import net.ibizsys.modelapi.dto.PSWFProcSubWFDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWFProcSubWFService
extends IPSModelService<PSWFProcSubWF, PSWFProcSubWFDTO> {
    public List<PSWFProcSubWF> listByPSWFProcess(PSWFProcess var1) throws Exception;

    public PSWFProcSubWF get(PSWFProcess var1, String var2, boolean var3) throws Exception;

    public List<PSWFProcSubWFDTO> listDTOByPSWFProcess(String var1) throws Exception;
}

