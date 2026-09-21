/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysCalendar;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysCalendarDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysCalendarService
extends IPSModelService<PSSysCalendar, PSSysCalendarDTO> {
    public List<PSSysCalendar> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSSysCalendar get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSSysCalendarDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSSysCalendar> listByPSModule(PSModule var1) throws Exception;

    public PSSysCalendar get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysCalendarDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysCalendar> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysCalendar get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysCalendarDTO> listDTOByPSSystem(String var1) throws Exception;
}

