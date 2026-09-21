/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysSearchDoc;
import net.ibizsys.modelapi.domain.PSSysSearchScheme;
import net.ibizsys.modelapi.dto.PSSysSearchDocDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysSearchDocService
extends IPSModelService<PSSysSearchDoc, PSSysSearchDocDTO> {
    public List<PSSysSearchDoc> listByPSSysSearchScheme(PSSysSearchScheme var1) throws Exception;

    public PSSysSearchDoc get(PSSysSearchScheme var1, String var2, boolean var3) throws Exception;

    public List<PSSysSearchDocDTO> listDTOByPSSysSearchScheme(String var1) throws Exception;
}

