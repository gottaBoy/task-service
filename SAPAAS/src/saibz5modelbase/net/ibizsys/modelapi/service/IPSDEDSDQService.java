/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDSDQ;
import net.ibizsys.modelapi.domain.PSDEDataSet;
import net.ibizsys.modelapi.dto.PSDEDSDQDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDSDQService
extends IPSModelService<PSDEDSDQ, PSDEDSDQDTO> {
    public List<PSDEDSDQ> listByPSDEDataSet(PSDEDataSet var1) throws Exception;

    public PSDEDSDQ get(PSDEDataSet var1, String var2, boolean var3) throws Exception;

    public List<PSDEDSDQDTO> listDTOByPSDEDataSet(String var1) throws Exception;
}

