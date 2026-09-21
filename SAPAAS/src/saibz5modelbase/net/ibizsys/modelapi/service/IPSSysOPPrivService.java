/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysOPPriv;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysOPPrivDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysOPPrivService
extends IPSModelService<PSSysOPPriv, PSSysOPPrivDTO> {
    public List<PSSysOPPriv> listByPSModule(PSModule var1) throws Exception;

    public PSSysOPPriv get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysOPPrivDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysOPPriv> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysOPPriv get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysOPPrivDTO> listDTOByPSSystem(String var1) throws Exception;
}

