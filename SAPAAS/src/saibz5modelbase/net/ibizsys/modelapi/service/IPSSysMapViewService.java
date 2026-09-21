/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSSysMapView;
import net.ibizsys.modelapi.dto.PSSysMapViewDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysMapViewService
extends IPSModelService<PSSysMapView, PSSysMapViewDTO> {
    public List<PSSysMapView> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSSysMapView get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSSysMapViewDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

