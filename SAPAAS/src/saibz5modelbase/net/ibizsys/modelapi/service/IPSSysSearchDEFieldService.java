/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysSearchDE;
import net.ibizsys.modelapi.domain.PSSysSearchDEField;
import net.ibizsys.modelapi.dto.PSSysSearchDEFieldDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysSearchDEFieldService
extends IPSModelService<PSSysSearchDEField, PSSysSearchDEFieldDTO> {
    public List<PSSysSearchDEField> listByPSSysSearchDE(PSSysSearchDE var1) throws Exception;

    public PSSysSearchDEField get(PSSysSearchDE var1, String var2, boolean var3) throws Exception;

    public List<PSSysSearchDEFieldDTO> listDTOByPSSysSearchDE(String var1) throws Exception;
}

