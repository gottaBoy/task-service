/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSWFVersion;
import net.ibizsys.modelapi.domain.PSWorkflow;
import net.ibizsys.modelapi.dto.PSWFVersionDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWFVersionService
extends IPSModelService<PSWFVersion, PSWFVersionDTO> {
    public List<PSWFVersion> listByPSWorkflow(PSWorkflow var1) throws Exception;

    public PSWFVersion get(PSWorkflow var1, String var2, boolean var3) throws Exception;

    public List<PSWFVersionDTO> listDTOByPSWorkflow(String var1) throws Exception;
}

