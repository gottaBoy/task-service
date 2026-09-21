/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysSearchDE;
import net.ibizsys.modelapi.domain.PSSysSearchScheme;
import net.ibizsys.modelapi.dto.PSSysSearchDEDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysSearchDEService
extends IPSModelService<PSSysSearchDE, PSSysSearchDEDTO> {
    public List<PSSysSearchDE> listByPSSysSearchScheme(PSSysSearchScheme var1) throws Exception;

    public PSSysSearchDE get(PSSysSearchScheme var1, String var2, boolean var3) throws Exception;

    public List<PSSysSearchDEDTO> listDTOByPSSysSearchScheme(String var1) throws Exception;
}

