/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysPortletCat;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysPortletCatDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysPortletCatService
extends IPSModelService<PSSysPortletCat, PSSysPortletCatDTO> {
    public List<PSSysPortletCat> listByPSModule(PSModule var1) throws Exception;

    public PSSysPortletCat get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysPortletCatDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysPortletCat> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysPortletCat get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysPortletCatDTO> listDTOByPSSystem(String var1) throws Exception;
}

