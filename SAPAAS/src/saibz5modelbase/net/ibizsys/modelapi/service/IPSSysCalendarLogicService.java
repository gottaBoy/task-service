/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysCalendar;
import net.ibizsys.modelapi.domain.PSSysCalendarLogic;
import net.ibizsys.modelapi.dto.PSSysCalendarLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysCalendarLogicService
extends IPSModelService<PSSysCalendarLogic, PSSysCalendarLogicDTO> {
    public List<PSSysCalendarLogic> listByPSSysCalendar(PSSysCalendar var1) throws Exception;

    public PSSysCalendarLogic get(PSSysCalendar var1, String var2, boolean var3) throws Exception;

    public List<PSSysCalendarLogicDTO> listDTOByPSSysCalendar(String var1) throws Exception;
}

