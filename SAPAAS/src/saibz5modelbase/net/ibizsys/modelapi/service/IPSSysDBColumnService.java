/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysDBColumn;
import net.ibizsys.modelapi.domain.PSSysDBTable;
import net.ibizsys.modelapi.dto.PSSysDBColumnDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDBColumnService
extends IPSModelService<PSSysDBColumn, PSSysDBColumnDTO> {
    public List<PSSysDBColumn> listByPSSysDBTable(PSSysDBTable var1) throws Exception;

    public PSSysDBColumn get(PSSysDBTable var1, String var2, boolean var3) throws Exception;

    public List<PSSysDBColumnDTO> listDTOByPSSysDBTable(String var1) throws Exception;
}

