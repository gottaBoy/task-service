/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEFUIMode;
import net.ibizsys.modelapi.domain.PSDEField;
import net.ibizsys.modelapi.dto.PSDEFUIModeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFUIModeService
extends IPSModelService<PSDEFUIMode, PSDEFUIModeDTO> {
    public List<PSDEFUIMode> listByPSDEField(PSDEField var1) throws Exception;

    public PSDEFUIMode get(PSDEField var1, String var2, boolean var3) throws Exception;

    public List<PSDEFUIModeDTO> listDTOByPSDEField(String var1) throws Exception;
}

