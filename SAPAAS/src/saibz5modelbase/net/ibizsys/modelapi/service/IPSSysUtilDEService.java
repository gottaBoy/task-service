/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysModelGroup;
import net.ibizsys.modelapi.domain.PSSysUtilDE;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysUtilDEDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysUtilDEService
extends IPSModelService<PSSysUtilDE, PSSysUtilDEDTO> {
    public List<PSSysUtilDE> listByPSModule(PSModule var1) throws Exception;

    public PSSysUtilDE get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysUtilDEDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysUtilDE> listByPSSysModelGroup(PSSysModelGroup var1) throws Exception;

    public PSSysUtilDE get(PSSysModelGroup var1, String var2, boolean var3) throws Exception;

    public List<PSSysUtilDEDTO> listDTOByPSSysModelGroup(String var1) throws Exception;

    public List<PSSysUtilDE> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysUtilDE get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysUtilDEDTO> listDTOByPSSystem(String var1) throws Exception;
}

