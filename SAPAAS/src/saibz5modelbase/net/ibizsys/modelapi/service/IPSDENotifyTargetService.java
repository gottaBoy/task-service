/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDENotify;
import net.ibizsys.modelapi.domain.PSDENotifyTarget;
import net.ibizsys.modelapi.dto.PSDENotifyTargetDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDENotifyTargetService
extends IPSModelService<PSDENotifyTarget, PSDENotifyTargetDTO> {
    public List<PSDENotifyTarget> listByPSDENotify(PSDENotify var1) throws Exception;

    public PSDENotifyTarget get(PSDENotify var1, String var2, boolean var3) throws Exception;

    public List<PSDENotifyTargetDTO> listDTOByPSDENotify(String var1) throws Exception;
}

