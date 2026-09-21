/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.domain.PSSystemDBCfg;
import net.ibizsys.modelapi.dto.PSSystemDBCfgDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSystemDBCfgService
extends IPSModelService<PSSystemDBCfg, PSSystemDBCfgDTO> {
    public List<PSSystemDBCfg> listByPSSystem(PSSystem var1) throws Exception;

    public PSSystemDBCfg get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSystemDBCfgDTO> listDTOByPSSystem(String var1) throws Exception;
}

