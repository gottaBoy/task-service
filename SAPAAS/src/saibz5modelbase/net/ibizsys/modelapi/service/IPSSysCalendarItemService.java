/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysCalendar;
import net.ibizsys.modelapi.domain.PSSysCalendarItem;
import net.ibizsys.modelapi.dto.PSSysCalendarItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysCalendarItemService
extends IPSModelService<PSSysCalendarItem, PSSysCalendarItemDTO> {
    public List<PSSysCalendarItem> listByPSSysCalendar(PSSysCalendar var1) throws Exception;

    public PSSysCalendarItem get(PSSysCalendar var1, String var2, boolean var3) throws Exception;

    public List<PSSysCalendarItemDTO> listDTOByPSSysCalendar(String var1) throws Exception;
}

