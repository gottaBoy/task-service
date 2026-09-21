/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSACHandler;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSACHandlerDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSACHandlerService
extends IPSModelService<PSACHandler, PSACHandlerDTO> {
    public List<PSACHandler> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSACHandler get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSACHandlerDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSACHandler> listByPSModule(PSModule var1) throws Exception;

    public PSACHandler get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSACHandlerDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSACHandler> listByPSSystem(PSSystem var1) throws Exception;

    public PSACHandler get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSACHandlerDTO> listDTOByPSSystem(String var1) throws Exception;
}

