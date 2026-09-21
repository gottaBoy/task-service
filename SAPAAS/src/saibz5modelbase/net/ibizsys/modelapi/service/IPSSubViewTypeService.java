/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSubViewType;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSubViewTypeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSubViewTypeService
extends IPSModelService<PSSubViewType, PSSubViewTypeDTO> {
    public List<PSSubViewType> listByPSModule(PSModule var1) throws Exception;

    public PSSubViewType get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSubViewTypeDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSubViewType> listByPSSystem(PSSystem var1) throws Exception;

    public PSSubViewType get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSubViewTypeDTO> listDTOByPSSystem(String var1) throws Exception;
}

