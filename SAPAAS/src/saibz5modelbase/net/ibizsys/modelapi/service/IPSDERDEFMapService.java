/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDER;
import net.ibizsys.modelapi.domain.PSDERDEFMap;
import net.ibizsys.modelapi.dto.PSDERDEFMapDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDERDEFMapService
extends IPSModelService<PSDERDEFMap, PSDERDEFMapDTO> {
    public List<PSDERDEFMap> listByPSDER(PSDER var1) throws Exception;

    public PSDERDEFMap get(PSDER var1, String var2, boolean var3) throws Exception;

    public List<PSDERDEFMapDTO> listDTOByPSDER(String var1) throws Exception;
}

