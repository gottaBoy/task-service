/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEMSOPPriv;
import net.ibizsys.modelapi.domain.PSDEMainState;
import net.ibizsys.modelapi.dto.PSDEMSOPPrivDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEMSOPPrivService
extends IPSModelService<PSDEMSOPPriv, PSDEMSOPPrivDTO> {
    public List<PSDEMSOPPriv> listByPSDEMainState(PSDEMainState var1) throws Exception;

    public PSDEMSOPPriv get(PSDEMainState var1, String var2, boolean var3) throws Exception;

    public List<PSDEMSOPPrivDTO> listDTOByPSDEMainState(String var1) throws Exception;
}

