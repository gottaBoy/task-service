/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEFVRCond;
import net.ibizsys.modelapi.domain.PSDEFValueRule;
import net.ibizsys.modelapi.dto.PSDEFVRCondDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFVRCondService
extends IPSModelService<PSDEFVRCond, PSDEFVRCondDTO> {
    public List<PSDEFVRCond> listByPSDEFVRCond(PSDEFVRCond var1) throws Exception;

    public PSDEFVRCond get(PSDEFVRCond var1, String var2, boolean var3) throws Exception;

    public List<PSDEFVRCondDTO> listDTOByPSDEFVRCond(String var1) throws Exception;

    public List<PSDEFVRCond> listByPSDEFValueRule(PSDEFValueRule var1) throws Exception;

    public PSDEFVRCond get(PSDEFValueRule var1, String var2, boolean var3) throws Exception;

    public List<PSDEFVRCondDTO> listDTOByPSDEFValueRule(String var1) throws Exception;

    public List<PSDEFVRCond> listAllChild(PSDEFVRCond var1) throws Exception;

    public List<PSDEFVRCond> listAllByPSDEFValueRule(PSDEFValueRule var1) throws Exception;

    public List<PSDEFVRCondDTO> listAllDTOByPSDEFValueRule(String var1) throws Exception;
}

