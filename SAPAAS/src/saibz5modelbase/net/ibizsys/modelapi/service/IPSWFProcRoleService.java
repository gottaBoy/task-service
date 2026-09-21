/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSWFProcRole;
import net.ibizsys.modelapi.domain.PSWFProcess;
import net.ibizsys.modelapi.dto.PSWFProcRoleDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWFProcRoleService
extends IPSModelService<PSWFProcRole, PSWFProcRoleDTO> {
    public List<PSWFProcRole> listByPSWFProcess(PSWFProcess var1) throws Exception;

    public PSWFProcRole get(PSWFProcess var1, String var2, boolean var3) throws Exception;

    public List<PSWFProcRoleDTO> listDTOByPSWFProcess(String var1) throws Exception;
}

