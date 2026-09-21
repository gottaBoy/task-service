/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEAction;
import net.ibizsys.modelapi.domain.PSDEActionVR;
import net.ibizsys.modelapi.dto.PSDEActionVRDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEActionVRService
extends IPSModelService<PSDEActionVR, PSDEActionVRDTO> {
    public List<PSDEActionVR> listByPSDEAction(PSDEAction var1) throws Exception;

    public PSDEActionVR get(PSDEAction var1, String var2, boolean var3) throws Exception;

    public List<PSDEActionVRDTO> listDTOByPSDEAction(String var1) throws Exception;
}

