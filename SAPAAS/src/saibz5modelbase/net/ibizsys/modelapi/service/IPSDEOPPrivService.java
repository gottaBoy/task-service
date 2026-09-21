/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEOPPriv;
import net.ibizsys.modelapi.domain.PSDER;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSDEOPPrivDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEOPPrivService
extends IPSModelService<PSDEOPPriv, PSDEOPPrivDTO> {
    public List<PSDEOPPriv> listByPSDER(PSDER var1) throws Exception;

    public PSDEOPPriv get(PSDER var1, String var2, boolean var3) throws Exception;

    public List<PSDEOPPrivDTO> listDTOByPSDER(String var1) throws Exception;

    public List<PSDEOPPriv> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEOPPriv get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEOPPrivDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSDEOPPriv> listByPSModule(PSModule var1) throws Exception;

    public PSDEOPPriv get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSDEOPPrivDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSDEOPPriv> listByPSSystem(PSSystem var1) throws Exception;

    public PSDEOPPriv get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSDEOPPrivDTO> listDTOByPSSystem(String var1) throws Exception;
}

