/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEGEIVR;
import net.ibizsys.modelapi.domain.PSDEGrid;
import net.ibizsys.modelapi.dto.PSDEGEIVRDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEGEIVRService
extends IPSModelService<PSDEGEIVR, PSDEGEIVRDTO> {
    public List<PSDEGEIVR> listByPSDEGrid(PSDEGrid var1) throws Exception;

    public PSDEGEIVR get(PSDEGrid var1, String var2, boolean var3) throws Exception;

    public List<PSDEGEIVRDTO> listDTOByPSDEGrid(String var1) throws Exception;
}

