/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDENotify;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDENotifyDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDENotifyService
extends IPSModelService<PSDENotify, PSDENotifyDTO> {
    public List<PSDENotify> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDENotify get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDENotifyDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

