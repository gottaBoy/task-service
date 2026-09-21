/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEOPPrivRole;
import net.ibizsys.modelapi.domain.PSDEUserRole;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSSysOPPriv;
import net.ibizsys.modelapi.dto.PSDEOPPrivRoleDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEOPPrivRoleService
extends IPSModelService<PSDEOPPrivRole, PSDEOPPrivRoleDTO> {
    public List<PSDEOPPrivRole> listByPSDEUserRole(PSDEUserRole var1) throws Exception;

    public PSDEOPPrivRole get(PSDEUserRole var1, String var2, boolean var3) throws Exception;

    public List<PSDEOPPrivRoleDTO> listDTOByPSDEUserRole(String var1) throws Exception;

    public List<PSDEOPPrivRole> listByPSSysOPPriv(PSSysOPPriv var1) throws Exception;

    public PSDEOPPrivRole get(PSSysOPPriv var1, String var2, boolean var3) throws Exception;

    public List<PSDEOPPrivRoleDTO> listDTOByPSSysOPPriv(String var1) throws Exception;

    public List<PSDEOPPrivRole> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEOPPrivRole get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEOPPrivRoleDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

