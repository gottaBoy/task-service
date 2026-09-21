/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEUserRole;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEUserRoleDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEUserRoleService
extends IPSModelService<PSDEUserRole, PSDEUserRoleDTO> {
    public List<PSDEUserRole> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEUserRole get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEUserRoleDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

