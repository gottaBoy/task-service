/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.domain.PSWFWorkTime;
import net.ibizsys.modelapi.dto.PSWFWorkTimeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWFWorkTimeService
extends IPSModelService<PSWFWorkTime, PSWFWorkTimeDTO> {
    public List<PSWFWorkTime> listByPSModule(PSModule var1) throws Exception;

    public PSWFWorkTime get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSWFWorkTimeDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSWFWorkTime> listByPSSystem(PSSystem var1) throws Exception;

    public PSWFWorkTime get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSWFWorkTimeDTO> listDTOByPSSystem(String var1) throws Exception;
}

