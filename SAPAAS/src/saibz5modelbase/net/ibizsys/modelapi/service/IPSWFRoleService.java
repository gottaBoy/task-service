/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.domain.PSWFRole;
import net.ibizsys.modelapi.dto.PSWFRoleDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWFRoleService
extends IPSModelService<PSWFRole, PSWFRoleDTO> {
    public List<PSWFRole> listByPSModule(PSModule var1) throws Exception;

    public PSWFRole get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSWFRoleDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSWFRole> listByPSSystem(PSSystem var1) throws Exception;

    public PSWFRole get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSWFRoleDTO> listDTOByPSSystem(String var1) throws Exception;
}

