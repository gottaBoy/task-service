/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysOPPriv;
import net.ibizsys.modelapi.domain.PSSysUserRoleData;
import net.ibizsys.modelapi.dto.PSSysUserRoleDataDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysUserRoleDataService
extends IPSModelService<PSSysUserRoleData, PSSysUserRoleDataDTO> {
    public List<PSSysUserRoleData> listByPSSysOPPriv(PSSysOPPriv var1) throws Exception;

    public PSSysUserRoleData get(PSSysOPPriv var1, String var2, boolean var3) throws Exception;

    public List<PSSysUserRoleDataDTO> listDTOByPSSysOPPriv(String var1) throws Exception;
}

