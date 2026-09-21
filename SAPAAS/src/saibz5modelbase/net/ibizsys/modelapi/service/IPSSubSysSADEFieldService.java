/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSubSysSADE;
import net.ibizsys.modelapi.domain.PSSubSysSADEField;
import net.ibizsys.modelapi.dto.PSSubSysSADEFieldDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSubSysSADEFieldService
extends IPSModelService<PSSubSysSADEField, PSSubSysSADEFieldDTO> {
    public List<PSSubSysSADEField> listByPSSubSysSADE(PSSubSysSADE var1) throws Exception;

    public PSSubSysSADEField get(PSSubSysSADE var1, String var2, boolean var3) throws Exception;

    public List<PSSubSysSADEFieldDTO> listDTOByPSSubSysSADE(String var1) throws Exception;
}

