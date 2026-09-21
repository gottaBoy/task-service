/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysSearchDoc;
import net.ibizsys.modelapi.domain.PSSysSearchField;
import net.ibizsys.modelapi.dto.PSSysSearchFieldDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysSearchFieldService
extends IPSModelService<PSSysSearchField, PSSysSearchFieldDTO> {
    public List<PSSysSearchField> listByPSSysSearchDoc(PSSysSearchDoc var1) throws Exception;

    public PSSysSearchField get(PSSysSearchDoc var1, String var2, boolean var3) throws Exception;

    public List<PSSysSearchFieldDTO> listDTOByPSSysSearchDoc(String var1) throws Exception;
}

