/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSWFProcess;
import net.ibizsys.modelapi.domain.PSWFVersion;
import net.ibizsys.modelapi.dto.PSWFProcessDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWFProcessService
extends IPSModelService<PSWFProcess, PSWFProcessDTO> {
    public List<PSWFProcess> listByPSWFVersion(PSWFVersion var1) throws Exception;

    public PSWFProcess get(PSWFVersion var1, String var2, boolean var3) throws Exception;

    public List<PSWFProcessDTO> listDTOByPSWFVersion(String var1) throws Exception;
}

