/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSWFLink;
import net.ibizsys.modelapi.domain.PSWFLinkRole;
import net.ibizsys.modelapi.dto.PSWFLinkRoleDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWFLinkRoleService
extends IPSModelService<PSWFLinkRole, PSWFLinkRoleDTO> {
    public List<PSWFLinkRole> listByPSWFLink(PSWFLink var1) throws Exception;

    public PSWFLinkRole get(PSWFLink var1, String var2, boolean var3) throws Exception;

    public List<PSWFLinkRoleDTO> listDTOByPSWFLink(String var1) throws Exception;
}

