/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEFInputTip;
import net.ibizsys.modelapi.domain.PSDEField;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.dto.PSDEFInputTipDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFInputTipService
extends IPSModelService<PSDEFInputTip, PSDEFInputTipDTO> {
    public List<PSDEFInputTip> listByPSModule(PSModule var1) throws Exception;

    public PSDEFInputTip get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSDEFInputTipDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSDEFInputTip> listByPSDEField(PSDEField var1) throws Exception;

    public PSDEFInputTip get(PSDEField var1, String var2, boolean var3) throws Exception;

    public List<PSDEFInputTipDTO> listDTOByPSDEField(String var1) throws Exception;
}

