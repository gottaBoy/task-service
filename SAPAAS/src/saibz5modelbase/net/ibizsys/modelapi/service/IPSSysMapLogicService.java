/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysMapLogic;
import net.ibizsys.modelapi.domain.PSSysMapView;
import net.ibizsys.modelapi.dto.PSSysMapLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysMapLogicService
extends IPSModelService<PSSysMapLogic, PSSysMapLogicDTO> {
    public List<PSSysMapLogic> listByPSSysMapView(PSSysMapView var1) throws Exception;

    public PSSysMapLogic get(PSSysMapView var1, String var2, boolean var3) throws Exception;

    public List<PSSysMapLogicDTO> listDTOByPSSysMapView(String var1) throws Exception;
}

