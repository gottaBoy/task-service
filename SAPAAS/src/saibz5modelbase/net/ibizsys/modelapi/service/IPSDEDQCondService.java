/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDQCond;
import net.ibizsys.modelapi.domain.PSDEDQJoin;
import net.ibizsys.modelapi.dto.PSDEDQCondDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDQCondService
extends IPSModelService<PSDEDQCond, PSDEDQCondDTO> {
    public List<PSDEDQCond> listByPSDEDQCond(PSDEDQCond var1) throws Exception;

    public PSDEDQCond get(PSDEDQCond var1, String var2, boolean var3) throws Exception;

    public List<PSDEDQCondDTO> listDTOByPSDEDQCond(String var1) throws Exception;

    public List<PSDEDQCond> listByPSDEDQJoin(PSDEDQJoin var1) throws Exception;

    public PSDEDQCond get(PSDEDQJoin var1, String var2, boolean var3) throws Exception;

    public List<PSDEDQCondDTO> listDTOByPSDEDQJoin(String var1) throws Exception;

    public List<PSDEDQCond> listAllChild(PSDEDQCond var1) throws Exception;

    public List<PSDEDQCond> listAllByPSDEDQJoin(PSDEDQJoin var1) throws Exception;

    public List<PSDEDQCondDTO> listAllDTOByPSDEDQJoin(String var1) throws Exception;
}

