/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.util;

import net.ibizsys.modelapi.service.IPSAppModuleService;
import net.ibizsys.modelapi.service.IPSDEDRItemService;
import net.ibizsys.modelapi.service.IPSDEUAGroupService;
import net.ibizsys.modelapi.service.IPSDEUIActionService;
import net.ibizsys.modelapi.service.IPSDEViewBaseService;
import net.ibizsys.modelapi.service.IPSDEViewCtrlService;
import net.ibizsys.modelapi.service.IPSLanguageResService;
import net.ibizsys.modelapi.service.IPSSysBDTableDEService;
import net.ibizsys.modelapi.service.IPSSystemService;
import net.ibizsys.modelapi.service.IPSWFLinkCondService;
import net.ibizsys.modelapi.service.IPSWFLinkService;
import net.ibizsys.modelapi.service.implex.PSAppModuleServiceImplEx;
import net.ibizsys.modelapi.service.implex.PSDEDRItemServiceImplEx;
import net.ibizsys.modelapi.service.implex.PSDEUAGroupServiceImplEx;
import net.ibizsys.modelapi.service.implex.PSDEUIActionServiceImplEx;
import net.ibizsys.modelapi.service.implex.PSDEViewBaseServiceImplEx;
import net.ibizsys.modelapi.service.implex.PSDEViewCtrlServiceImplEx;
import net.ibizsys.modelapi.service.implex.PSLanguageResServiceImplEx;
import net.ibizsys.modelapi.service.implex.PSSysBDTableDEServiceImplEx;
import net.ibizsys.modelapi.service.implex.PSSystemServiceImplEx;
import net.ibizsys.modelapi.service.implex.PSWFLinkCondServiceImplEx;
import net.ibizsys.modelapi.service.implex.PSWFLinkServiceImplEx;
import net.ibizsys.modelapi.util.PSModelServiceUtil;

public class PSModelServiceUtilEx
extends PSModelServiceUtil {
    @Override
    protected IPSSystemService createPSSystemService() {
        return new PSSystemServiceImplEx();
    }

    @Override
    protected IPSSysBDTableDEService createPSSysBDTableDEService() {
        return new PSSysBDTableDEServiceImplEx();
    }

    @Override
    protected IPSAppModuleService createPSAppModuleService() {
        return new PSAppModuleServiceImplEx();
    }

    @Override
    protected IPSWFLinkService createPSWFLinkService() {
        return new PSWFLinkServiceImplEx();
    }

    @Override
    protected IPSDEDRItemService createPSDEDRItemService() {
        return new PSDEDRItemServiceImplEx();
    }

    @Override
    protected IPSDEViewCtrlService createPSDEViewCtrlService() {
        return new PSDEViewCtrlServiceImplEx();
    }

    @Override
    protected IPSWFLinkCondService createPSWFLinkCondService() {
        return new PSWFLinkCondServiceImplEx();
    }

    @Override
    protected IPSDEUAGroupService createPSDEUAGroupService() {
        return new PSDEUAGroupServiceImplEx();
    }

    @Override
    protected IPSDEUIActionService createPSDEUIActionService() {
        return new PSDEUIActionServiceImplEx();
    }

    @Override
    protected IPSDEViewBaseService createPSDEViewBaseService() {
        return new PSDEViewBaseServiceImplEx();
    }

    @Override
    protected IPSLanguageResService createPSLanguageResService() {
        return new PSLanguageResServiceImplEx();
    }
}

