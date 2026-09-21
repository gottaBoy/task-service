/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysMapItem;
import net.ibizsys.modelapi.domain.PSSysMapView;
import net.ibizsys.modelapi.dto.PSSysMapItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysMapItemService
extends IPSModelService<PSSysMapItem, PSSysMapItemDTO> {
    public List<PSSysMapItem> listByPSSysMapView(PSSysMapView var1) throws Exception;

    public PSSysMapItem get(PSSysMapView var1, String var2, boolean var3) throws Exception;

    public List<PSSysMapItemDTO> listDTOByPSSysMapView(String var1) throws Exception;
}

