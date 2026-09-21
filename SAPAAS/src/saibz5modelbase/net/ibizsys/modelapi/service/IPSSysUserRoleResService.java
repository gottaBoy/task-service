/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysOPPriv;
import net.ibizsys.modelapi.domain.PSSysUserRoleRes;
import net.ibizsys.modelapi.dto.PSSysUserRoleResDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysUserRoleResService
extends IPSModelService<PSSysUserRoleRes, PSSysUserRoleResDTO> {
    public List<PSSysUserRoleRes> listByPSSysOPPriv(PSSysOPPriv var1) throws Exception;

    public PSSysUserRoleRes get(PSSysOPPriv var1, String var2, boolean var3) throws Exception;

    public List<PSSysUserRoleResDTO> listDTOByPSSysOPPriv(String var1) throws Exception;
}

