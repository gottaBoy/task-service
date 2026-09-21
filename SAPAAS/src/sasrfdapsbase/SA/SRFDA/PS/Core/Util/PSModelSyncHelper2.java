/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSModule
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroup
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.Util.IPSDevSlnSysModelStorage;
import SA.SRFDA.PS.Core.Util.PSModelSyncHelperBase;
import java.util.List;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroup;
import org.hibernate.SessionFactory;

public class PSModelSyncHelper2
extends PSModelSyncHelperBase {
    public PSModelSyncHelper2(PSDevSlnSys psDevSlnSys, SessionFactory sessionFactory) {
        super(psDevSlnSys, sessionFactory);
    }

    @Override
    protected String onSync(PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        List<PSModule> srcPSModuleList;
        List<PSSysModelGroup> srcPSSysModelGroupList = refPSDevSlnSysModelStorage.select("PSSYSMODELGROUP", null, PSSysModelGroup.class);
        if (srcPSSysModelGroupList != null) {
            for (PSSysModelGroup srcPSSysModelGroup : srcPSSysModelGroupList) {
                PSSysModelGroup dstPSSysModelGroup = this.getPSDevSlnSysModelStorage().getByCodeName("PSSYSMODELGROUP", null, srcPSSysModelGroup.getCodeName(), PSSysModelGroup.class);
                if (dstPSSysModelGroup == null) {
                    dstPSSysModelGroup = new PSSysModelGroup();
                    dstPSSysModelGroup.setPSSysModelGroupName(srcPSSysModelGroup.getPSSysModelGroupName());
                    dstPSSysModelGroup.setCodeName(srcPSSysModelGroup.getCodeName());
                    dstPSSysModelGroup.setGroupTag(srcPSSysModelGroup.getGroupTag());
                    dstPSSysModelGroup.setGroupTag2(srcPSSysModelGroup.getGroupTag2());
                    dstPSSysModelGroup.setGroupTag3(srcPSSysModelGroup.getGroupTag3());
                    dstPSSysModelGroup.setGroupTag4(srcPSSysModelGroup.getGroupTag4());
                    this.getPSDevSlnSysModelStorage().create("PSSYSMODELGROUP", (IEntity)dstPSSysModelGroup);
                }
                this.mapPSModel("PSSYSMODELGROUP", srcPSSysModelGroup.getPSSysModelGroupId(), dstPSSysModelGroup);
            }
        }
        if ((srcPSModuleList = refPSDevSlnSysModelStorage.select("PSMODULE", null, PSModule.class)) != null) {
            for (PSModule srcPSModule : srcPSModuleList) {
                PSSysModelGroup dstPSSysModelGroup;
                if (StringHelper.isNullOrEmpty((String)srcPSModule.getPSSysModelGroupId()) || (dstPSSysModelGroup = this.getDstPSModel("PSSYSMODELGROUP", srcPSModule.getPSSysModelGroupId(), PSSysModelGroup.class)) == null) continue;
                SelectCond selectCond = new SelectCond();
                selectCond.set("pssysmodelgroupid", (Object)dstPSSysModelGroup.getPSSysModelGroupId());
                PSModule dstPSModule = this.getPSDevSlnSysModelStorage().getByCodeName("PSMODULE", (ISelectCond)selectCond, srcPSModule.getCodeName(), PSModule.class);
                if (dstPSModule == null) {
                    dstPSModule = new PSModule();
                    dstPSModule.setPSModuleName(srcPSModule.getPSModuleName());
                    dstPSModule.setCodeName(srcPSModule.getCodeName());
                    dstPSModule.setPSSysModelGroupId(dstPSSysModelGroup.getPSSysModelGroupId());
                    dstPSModule.setDefaultFlag(srcPSModule.getDefaultFlag());
                    try {
                        this.getPSDevSlnSysModelStorage().create("PSMODULE", (IEntity)dstPSModule);
                    }
                    catch (Exception ex) {
                        throw new Exception(String.format("\u540c\u6b65\u7cfb\u7edf\u6a21\u5757[%1$s][%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", srcPSModule.getPSModuleName(), srcPSModule.getCodeName(), ex.getMessage()), ex);
                    }
                }
                this.mapPSModel("PSMODULE", srcPSModule.getPSModuleId(), dstPSModule);
                this.syncPSDataEntites(srcPSModule, psDevSlnSysRef, refPSDevSlnSysModelStorage);
            }
        }
        this.syncPSDERs(psDevSlnSysRef, refPSDevSlnSysModelStorage);
        this.syncPSCodeLists(psDevSlnSysRef, refPSDevSlnSysModelStorage);
        this.syncPSCodeItems(psDevSlnSysRef, refPSDevSlnSysModelStorage);
        this.syncPSDEFields(psDevSlnSysRef, refPSDevSlnSysModelStorage);
        this.syncPSDERDEFMaps(psDevSlnSysRef, refPSDevSlnSysModelStorage);
        return super.onSync(psDevSlnSysRef, refPSDevSlnSysModelStorage);
    }
}

