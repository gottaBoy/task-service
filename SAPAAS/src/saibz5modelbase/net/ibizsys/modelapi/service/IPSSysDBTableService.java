/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysDBScheme;
import net.ibizsys.modelapi.domain.PSSysDBTable;
import net.ibizsys.modelapi.dto.PSSysDBTableDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDBTableService
extends IPSModelService<PSSysDBTable, PSSysDBTableDTO> {
    public List<PSSysDBTable> listByPSSysDBScheme(PSSysDBScheme var1) throws Exception;

    public PSSysDBTable get(PSSysDBScheme var1, String var2, boolean var3) throws Exception;

    public List<PSSysDBTableDTO> listDTOByPSSysDBScheme(String var1) throws Exception;
}

