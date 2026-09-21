/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysModelGroup;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysModelGroupDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysModelGroupService
extends IPSModelService<PSSysModelGroup, PSSysModelGroupDTO> {
    public List<PSSysModelGroup> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysModelGroup get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysModelGroupDTO> listDTOByPSSystem(String var1) throws Exception;
}

