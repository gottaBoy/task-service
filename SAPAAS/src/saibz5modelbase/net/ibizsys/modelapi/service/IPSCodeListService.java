/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSCodeList;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSCodeListService
extends IPSModelService<PSCodeList, PSCodeListDTO> {
    public List<PSCodeList> listByPSModule(PSModule var1) throws Exception;

    public PSCodeList get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSCodeListDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSCodeList> listByPSSystem(PSSystem var1) throws Exception;

    public PSCodeList get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSCodeListDTO> listDTOByPSSystem(String var1) throws Exception;
}

