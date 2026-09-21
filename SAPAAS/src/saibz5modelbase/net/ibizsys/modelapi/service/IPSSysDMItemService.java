/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSSysDMItem;
import net.ibizsys.modelapi.domain.PSSystemDBCfg;
import net.ibizsys.modelapi.dto.PSSysDMItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDMItemService
extends IPSModelService<PSSysDMItem, PSSysDMItemDTO> {
    public List<PSSysDMItem> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSSysDMItem get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSSysDMItemDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSSysDMItem> listByPSSystemDBCfg(PSSystemDBCfg var1) throws Exception;

    public PSSysDMItem get(PSSystemDBCfg var1, String var2, boolean var3) throws Exception;

    public List<PSSysDMItemDTO> listDTOByPSSystemDBCfg(String var1) throws Exception;
}

