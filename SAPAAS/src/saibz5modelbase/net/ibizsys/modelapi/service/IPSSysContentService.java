/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysContent;
import net.ibizsys.modelapi.domain.PSSysContentCat;
import net.ibizsys.modelapi.dto.PSSysContentDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysContentService
extends IPSModelService<PSSysContent, PSSysContentDTO> {
    public List<PSSysContent> listByPSSysContentCat(PSSysContentCat var1) throws Exception;

    public PSSysContent get(PSSysContentCat var1, String var2, boolean var3) throws Exception;

    public List<PSSysContentDTO> listDTOByPSSysContentCat(String var1) throws Exception;
}

