/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEPrint;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEPrintDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEPrintService
extends IPSModelService<PSDEPrint, PSDEPrintDTO> {
    public List<PSDEPrint> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEPrint get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEPrintDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

