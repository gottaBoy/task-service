/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDELLCond;
import net.ibizsys.modelapi.domain.PSDELogicLink;
import net.ibizsys.modelapi.dto.PSDELLCondDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDELLCondService
extends IPSModelService<PSDELLCond, PSDELLCondDTO> {
    public List<PSDELLCond> listByPSDELLCond(PSDELLCond var1) throws Exception;

    public PSDELLCond get(PSDELLCond var1, String var2, boolean var3) throws Exception;

    public List<PSDELLCondDTO> listDTOByPSDELLCond(String var1) throws Exception;

    public List<PSDELLCond> listByPSDELogicLink(PSDELogicLink var1) throws Exception;

    public PSDELLCond get(PSDELogicLink var1, String var2, boolean var3) throws Exception;

    public List<PSDELLCondDTO> listDTOByPSDELogicLink(String var1) throws Exception;

    public List<PSDELLCond> listAllChild(PSDELLCond var1) throws Exception;

    public List<PSDELLCond> listAllByPSDELogicLink(PSDELogicLink var1) throws Exception;

    public List<PSDELLCondDTO> listAllDTOByPSDELogicLink(String var1) throws Exception;
}

