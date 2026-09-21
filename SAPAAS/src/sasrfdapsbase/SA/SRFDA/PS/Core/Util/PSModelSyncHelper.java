/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEField
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSModule
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroup
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.Util.IPSDevSlnSysModelStorage;
import SA.SRFDA.PS.Core.Util.PSModelSyncHelperBase;
import java.util.HashMap;
import java.util.List;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroup;
import org.hibernate.SessionFactory;

public class PSModelSyncHelper
extends PSModelSyncHelperBase {
    public PSModelSyncHelper(PSDevSlnSys psDevSlnSys, SessionFactory sessionFactory) {
        super(psDevSlnSys, sessionFactory);
    }

    @Override
    protected String onSync(PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        List<PSSysModelGroup> srcPSSysModelGroupList;
        PSSysModelGroup defaultPSSysModelGroup = this.getPSDevSlnSysModelStorage().getByCodeName("PSSYSMODELGROUP", null, "ES_" + psDevSlnSysRef.getRefMode(), PSSysModelGroup.class);
        if (defaultPSSysModelGroup == null) {
            defaultPSSysModelGroup = new PSSysModelGroup();
            defaultPSSysModelGroup.setPSSysModelGroupName(refPSDevSlnSysModelStorage.getPSDevSlnSys().getPSDevSlnSysName());
            defaultPSSysModelGroup.setCodeName("ES_" + psDevSlnSysRef.getRefMode());
            defaultPSSysModelGroup.setGroupTag("ETLSOURCE");
            defaultPSSysModelGroup.setGroupTag2(psDevSlnSysRef.getRefMode());
            this.getPSDevSlnSysModelStorage().create("PSSYSMODELGROUP", (IEntity)defaultPSSysModelGroup);
        }
        if ((srcPSSysModelGroupList = refPSDevSlnSysModelStorage.select("PSSYSMODELGROUP", null, PSSysModelGroup.class)) != null) {
            for (PSSysModelGroup srcPSSysModelGroup : srcPSSysModelGroupList) {
                String strDstCodeName = String.format("ES_%1$s__%2$s", psDevSlnSysRef.getRefMode(), srcPSSysModelGroup.getCodeName());
                PSSysModelGroup dstPSSysModelGroup = this.getPSDevSlnSysModelStorage().getByCodeName("PSSYSMODELGROUP", null, strDstCodeName, PSSysModelGroup.class);
                if (dstPSSysModelGroup == null) {
                    dstPSSysModelGroup = new PSSysModelGroup();
                    dstPSSysModelGroup.setPSSysModelGroupName(srcPSSysModelGroup.getPSSysModelGroupName());
                    dstPSSysModelGroup.setCodeName(strDstCodeName);
                    dstPSSysModelGroup.setGroupTag("ETLSOURCE");
                    dstPSSysModelGroup.setGroupTag2(psDevSlnSysRef.getRefMode());
                    dstPSSysModelGroup.setGroupTag3(srcPSSysModelGroup.getCodeName());
                    this.getPSDevSlnSysModelStorage().create("PSSYSMODELGROUP", (IEntity)dstPSSysModelGroup);
                }
                this.mapPSModel("PSSYSMODELGROUP", srcPSSysModelGroup.getPSSysModelGroupId(), dstPSSysModelGroup);
            }
        }
        List<PSModule> srcPSModuleList = refPSDevSlnSysModelStorage.select("PSMODULE", null, PSModule.class);
        PSModule defaultDstPSModule = null;
        if (srcPSModuleList != null) {
            PSModule defaultPSModule = null;
            for (PSModule srcPSModule : srcPSModuleList) {
                if (!StringHelper.isNullOrEmpty((String)srcPSModule.getPSSysRefId()) || !StringHelper.isNullOrEmpty((String)srcPSModule.getPSSysModelGroupId()) || DataObject.getIntegerValue((Object)srcPSModule.getDefaultFlag(), (Integer)0) != 1) continue;
                defaultPSModule = srcPSModule;
                break;
            }
            if (defaultPSModule == null) {
                throw new Exception("\u5f15\u7528\u7cfb\u7edf\u672a\u5b9a\u4e49\u9ed8\u8ba4\u6a21\u5757");
            }
            for (PSModule srcPSModule : srcPSModuleList) {
                if (!StringHelper.isNullOrEmpty((String)srcPSModule.getPSSysRefId())) continue;
                PSSysModelGroup dstPSSysModelGroup = this.getDstPSModel("PSSYSMODELGROUP", srcPSModule.getPSSysModelGroupId(), PSSysModelGroup.class);
                if (dstPSSysModelGroup == null) {
                    dstPSSysModelGroup = defaultPSSysModelGroup;
                }
                SelectCond selectCond = new SelectCond();
                selectCond.set("pssysmodelgroupid", (Object)dstPSSysModelGroup.getPSSysModelGroupId());
                PSModule dstPSModule = this.getPSDevSlnSysModelStorage().getByCodeName("PSMODULE", (ISelectCond)selectCond, srcPSModule.getCodeName(), PSModule.class);
                if (dstPSModule == null) {
                    dstPSModule = new PSModule();
                    dstPSModule.setPSModuleName(srcPSModule.getPSModuleName());
                    dstPSModule.setCodeName(srcPSModule.getCodeName());
                    dstPSModule.setPSSysModelGroupId(dstPSSysModelGroup.getPSSysModelGroupId());
                    if (defaultPSModule.getPSModuleId().equals(srcPSModule.getPSModuleId())) {
                        dstPSModule.setDefaultFlag(Integer.valueOf(1));
                    } else {
                        dstPSModule.setDefaultFlag(Integer.valueOf(0));
                    }
                    try {
                        this.getPSDevSlnSysModelStorage().create("PSMODULE", (IEntity)dstPSModule);
                    }
                    catch (Exception ex) {
                        throw new Exception(String.format("\u540c\u6b65\u7cfb\u7edf\u6a21\u5757[%1$s][%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", srcPSModule.getPSModuleName(), srcPSModule.getCodeName(), ex.getMessage()), ex);
                    }
                }
                this.mapPSModel("PSMODULE", srcPSModule.getPSModuleId(), dstPSModule);
                if (DataObject.getIntegerValue((Object)dstPSModule.getDefaultFlag(), (Integer)0) == 1) {
                    defaultDstPSModule = dstPSModule;
                }
                this.syncPSDataEntites(srcPSModule, psDevSlnSysRef, refPSDevSlnSysModelStorage);
            }
        }
        this.syncPSDERs(psDevSlnSysRef, refPSDevSlnSysModelStorage);
        this.syncPSCodeLists(defaultDstPSModule, psDevSlnSysRef, refPSDevSlnSysModelStorage);
        this.syncPSCodeItems(psDevSlnSysRef, refPSDevSlnSysModelStorage);
        this.syncPSDEFields(psDevSlnSysRef, refPSDevSlnSysModelStorage);
        this.syncPSDERDEFMaps(psDevSlnSysRef, refPSDevSlnSysModelStorage);
        return super.onSync(psDevSlnSysRef, refPSDevSlnSysModelStorage);
    }

    protected String syncPSCodeLists(PSModule defaultDstPSModule, PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        List<PSDEField> srcPSDEFieldList = refPSDevSlnSysModelStorage.select("PSDEFIELD", null, PSDEField.class);
        HashMap<String, String> psCodeListMap = new HashMap<String, String>();
        for (PSDEField srcPSDEField : srcPSDEFieldList) {
            PSDataEntity dstPSDataEntity;
            if (StringHelper.isNullOrEmpty((String)srcPSDEField.getPSCodeListId()) || (dstPSDataEntity = this.getDstPSModel("PSDATAENTITY", srcPSDEField.getPSDEId(), PSDataEntity.class)) == null) continue;
            psCodeListMap.put(srcPSDEField.getPSCodeListId(), "");
        }
        List<PSCodeList> srcPSCodeListList = refPSDevSlnSysModelStorage.select("PSCODELIST", null, PSCodeList.class);
        if (srcPSCodeListList != null) {
            for (PSCodeList srcPSCodeList : srcPSCodeListList) {
                if (!psCodeListMap.containsKey(srcPSCodeList.getPSCodeListId())) continue;
                PSModule dstPSModule = null;
                SelectCond selectCond = new SelectCond();
                if (StringHelper.isNullOrEmpty((String)srcPSCodeList.getPSModuleId())) {
                    dstPSModule = defaultDstPSModule;
                } else {
                    dstPSModule = this.getDstPSModel("PSMODULE", srcPSCodeList.getPSModuleId(), PSModule.class);
                    if (dstPSModule == null) {
                        dstPSModule = defaultDstPSModule;
                    }
                }
                selectCond.set("psmoduleid", (Object)dstPSModule.getPSModuleId());
                PSCodeList dstPSCodeList = this.getPSDevSlnSysModelStorage().getByCodeName("PSCODELIST", (ISelectCond)selectCond, srcPSCodeList.getCodeName(), PSCodeList.class);
                if (dstPSCodeList == null) {
                    dstPSCodeList = new PSCodeList();
                    dstPSCodeList.setPSCodeListName(srcPSCodeList.getPSCodeListName());
                    dstPSCodeList.setCodeName(srcPSCodeList.getCodeName());
                    dstPSCodeList.setCodeListSN(srcPSCodeList.getCodeListSN());
                    dstPSCodeList.setCLType(srcPSCodeList.getCLType());
                    dstPSCodeList.setPSModuleId(dstPSModule.getPSModuleId());
                    dstPSCodeList.setPSModuleName(dstPSModule.getPSModuleName());
                    dstPSCodeList.setOrMode(srcPSCodeList.getOrMode());
                    dstPSCodeList.setNumberItem(srcPSCodeList.getNumberItem());
                    try {
                        this.getPSDevSlnSysModelStorage().create("PSCODELIST", (IEntity)dstPSCodeList);
                    }
                    catch (Exception ex) {
                        throw new Exception(String.format("\u540c\u6b65\u4ee3\u7801\u8868[%1$s][%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", srcPSCodeList.getPSCodeListName(), srcPSCodeList.getCodeName(), ex.getMessage()), ex);
                    }
                }
                this.mapPSModel("PSCODELIST", srcPSCodeList.getPSCodeListId(), dstPSCodeList);
            }
        }
        return null;
    }
}

