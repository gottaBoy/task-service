/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysCalendarItem;
import net.ibizsys.modelapi.domain.PSSysCalendarItemRV;
import net.ibizsys.modelapi.dto.PSSysCalendarItemRVDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysCalendarItemRVService
extends IPSModelService<PSSysCalendarItemRV, PSSysCalendarItemRVDTO> {
    public List<PSSysCalendarItemRV> listByPSSysCalendarItem(PSSysCalendarItem var1) throws Exception;

    public PSSysCalendarItemRV get(PSSysCalendarItem var1, String var2, boolean var3) throws Exception;

    public List<PSSysCalendarItemRVDTO> listDTOByPSSysCalendarItem(String var1) throws Exception;
}

