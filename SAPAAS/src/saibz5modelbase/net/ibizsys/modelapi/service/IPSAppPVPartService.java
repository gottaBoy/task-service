/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppPVPart;
import net.ibizsys.modelapi.domain.PSAppPortalView;
import net.ibizsys.modelapi.dto.PSAppPVPartDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppPVPartService
extends IPSModelService<PSAppPVPart, PSAppPVPartDTO> {
    public List<PSAppPVPart> listByPSAppPVPart(PSAppPVPart var1) throws Exception;

    public PSAppPVPart get(PSAppPVPart var1, String var2, boolean var3) throws Exception;

    public List<PSAppPVPartDTO> listDTOByPSAppPVPart(String var1) throws Exception;

    public List<PSAppPVPart> listByPSAppPortalView(PSAppPortalView var1) throws Exception;

    public PSAppPVPart get(PSAppPortalView var1, String var2, boolean var3) throws Exception;

    public List<PSAppPVPartDTO> listDTOByPSAppPortalView(String var1) throws Exception;

    public List<PSAppPVPart> listAllChild(PSAppPVPart var1) throws Exception;

    public List<PSAppPVPart> listAllByPSAppPortalView(PSAppPortalView var1) throws Exception;

    public List<PSAppPVPartDTO> listAllDTOByPSAppPortalView(String var1) throws Exception;
}

