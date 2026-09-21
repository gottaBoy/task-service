/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppWF;
import net.ibizsys.modelapi.domain.PSAppWFVer;
import net.ibizsys.modelapi.dto.PSAppWFVerDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppWFVerService
extends IPSModelService<PSAppWFVer, PSAppWFVerDTO> {
    public List<PSAppWFVer> listByPSAppWF(PSAppWF var1) throws Exception;

    public PSAppWFVer get(PSAppWF var1, String var2, boolean var3) throws Exception;

    public List<PSAppWFVerDTO> listDTOByPSAppWF(String var1) throws Exception;
}

