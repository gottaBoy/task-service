/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEFInputTipSet;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSDEFInputTipSetDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFInputTipSetService
extends IPSModelService<PSDEFInputTipSet, PSDEFInputTipSetDTO> {
    public List<PSDEFInputTipSet> listByPSModule(PSModule var1) throws Exception;

    public PSDEFInputTipSet get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSDEFInputTipSetDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSDEFInputTipSet> listByPSSystem(PSSystem var1) throws Exception;

    public PSDEFInputTipSet get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSDEFInputTipSetDTO> listDTOByPSSystem(String var1) throws Exception;
}

