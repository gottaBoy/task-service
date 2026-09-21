/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDER;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDERService
extends IPSModelService<PSDER, PSDERDTO> {
    public List<PSDER> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDER get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDERDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

