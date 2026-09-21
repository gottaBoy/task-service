/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEActionTempl;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSDEActionTemplDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEActionTemplService
extends IPSModelService<PSDEActionTempl, PSDEActionTemplDTO> {
    public List<PSDEActionTempl> listByPSModule(PSModule var1) throws Exception;

    public PSDEActionTempl get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSDEActionTemplDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSDEActionTempl> listByPSSystem(PSSystem var1) throws Exception;

    public PSDEActionTempl get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSDEActionTemplDTO> listDTOByPSSystem(String var1) throws Exception;
}

