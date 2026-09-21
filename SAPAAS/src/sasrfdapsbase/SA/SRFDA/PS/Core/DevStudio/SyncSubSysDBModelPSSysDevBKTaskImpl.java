/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.config.entity.PSSubSys
 *  net.ibizsys.pscore.srv.config.entity.PSSubSysVer
 *  net.ibizsys.pscore.srv.config.service.PSSubSysService
 *  net.ibizsys.pscore.srv.config.service.PSSubSysVerService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.DevStudio.PSSysBTException;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.entity.PSSubSysVer;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.ibizsys.pscore.srv.config.service.PSSubSysVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SyncSubSysDBModelPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SyncSubSysDBModelPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        PSSystemDBCfgService psSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSystemDBCfg psSystemDBConfig2 = new PSSystemDBCfg();
        psSystemDBConfig2.setPSSystemDBCfgId(this.psSysDevBKTask.getTASKPARAM());
        psSystemDBCfgService.get((IEntity)psSystemDBConfig2);
        return this.syncSubSysDBModel(psSystemDBConfig2);
    }

    protected String syncSubSysDBModel(PSSystemDBCfg psSystemDBConfig) throws Exception {
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        PSSystem psSystem = new PSSystem();
        psSystem.setPSSystemId(psSystemDBConfig.getPSSystemId());
        String strPSSystemId = psSystemDBConfig.getPSSystemId();
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
        ArrayList modelList = new ArrayList();
        PSSysRefService psSysRefService = (PSSysRefService)ServiceGlobal.getService(PSSysRefService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psSysRefList = psSysRefService.selectByPSSystem((PSSystemBase)psSystem, "ORDER BY ORDERVALUE");
        psSystem.setSessionFactory(sessionFactory);
        psSystem.get();
        for (PSSysRef psSysRef : psSysRefList) {
            if (!DataObject.getBoolValue((Integer)psSysRef.getValidFlag(), (boolean)true)) continue;
            sBuilderEx.append("\u5bfc\u5165\u7cfb\u7edf\u5f15\u7528[%1$s]\r\n", (Object)psSysRef.getPSSysRefName());
            sBuilderEx.append(this.syncSubSysDBModel(psSystemDBConfig, psSysRef, psSystem));
        }
        sBuilderEx.append("\u5bfc\u5165\u5b50\u7cfb\u7edf\u6570\u636e\u7ed3\u6784\u5b8c\u6210\u3002");
        return sBuilderEx.toString();
    }

    protected String syncSubSysDBModel(PSSystemDBCfg psSystemDBConfig, PSSysRef psSysRef, PSSystem psSystem) throws Exception {
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        String strSubSysModelInstId = "";
        int nCurVersion = -1;
        if (StringHelper.isNullOrEmpty((String)psSysRef.getSysRefType()) || StringHelper.compare((String)psSysRef.getSysRefType(), (String)"SUBSYS", (boolean)true) == 0) {
            PSSubSysService psSubSysService = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class);
            PSSubSys psSubSys = new PSSubSys();
            psSubSys.setPSSubSysId(psSysRef.getPSSubSysId());
            if (!psSubSysService.get((IEntity)psSubSys, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b50\u7cfb\u7edf[%1$s]", (Object)psSysRef.getPSSysRefName()));
            }
            PSSubSysVerService psSubSysVerService = (PSSubSysVerService)ServiceGlobal.getService(PSSubSysVerService.class);
            PSSubSysVer psSubSysVer = new PSSubSysVer();
            psSubSysVer.setPSSubSysId(psSubSys.getPSSubSysId());
            psSubSysVer.setVersion(psSubSys.getVersion());
            if (!psSubSysVerService.select((IEntity)psSubSysVer, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b50\u7cfb\u7edf[%1$s]\u7248\u672c[%2$s]", (Object)psSysRef.getPSSysRefName(), (Object)psSubSys.getVersion()));
            }
            nCurVersion = psSubSys.getVersion();
            strSubSysModelInstId = psSubSysVer.getPSSysModelInstId();
        } else if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            PSDevSlnSysRef psDevSlnSysRef = new PSDevSlnSysRef();
            psDevSlnSysRef.setSessionFactory(PSCoreSysServiceBase.getCurMajorSessionFactory());
            psDevSlnSysRef.setRefPSDevSlnSysId(psSysRef.getPSDevSlnSysId());
            psDevSlnSysRef.setPSDevSlnSysId(psSystem.getPSDevSlnSysId());
            if (!psDevSlnSysRef.select(true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf\u5f15\u7528[%1$s]", (Object)psSysRef.getPSDevSlnSysName()));
            }
            PSDevSlnSys refPSDevSlnSys = new PSDevSlnSys();
            refPSDevSlnSys.setPSDevSlnSysId(psSysRef.getPSDevSlnSysId());
            refPSDevSlnSys.setSessionFactory(PSCoreSysServiceBase.getCurMajorSessionFactory());
            if (!refPSDevSlnSys.get(true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f15\u7528\u5f00\u53d1\u7cfb\u7edf[%1$s]\uff0c\u6807\u8bc6\u4e3a[%2$s]", (Object)psSysRef.getPSDevSlnSysName(), (Object)psSysRef.getPSDevSlnSysId()));
            }
            strSubSysModelInstId = refPSDevSlnSys.getPSSysModelInstId();
        }
        SessionFactory sysRefSessionFactory = PSSysModelInstGlobal.getSessionFactory((String)strSubSysModelInstId);
        PSSysDMItemService psSysDMItemService = (PSSysDMItemService)ServiceGlobal.getService(PSSysDMItemService.class, (SessionFactory)sysRefSessionFactory);
        ArrayList psSysDMItemList = psSysDMItemService.selectByPSSystemDBCfg((PSSystemDBCfgBase)psSystemDBConfig);
        Collections.sort(psSysDMItemList, new Comparator<PSSysDMItem>(){

            @Override
            public int compare(PSSysDMItem arg0, PSSysDMItem arg1) {
                int nRet = StringHelper.compare((String)arg0.getPSDEName(), (String)arg1.getPSDEName(), (boolean)false);
                if (nRet != 0) {
                    return nRet;
                }
                return StringHelper.compare((String)arg0.getPSSysDMItemName(), (String)arg1.getPSSysDMItemName(), (boolean)false);
            }
        });
        ArrayList<String> modelList = new ArrayList<String>();
        StringBuilderEx sb = new StringBuilderEx();
        this.appendDMCode(sb, psSysDMItemList, "TABLE");
        String strCode = sb.toString();
        if (!StringHelper.isNullOrEmpty((String)strCode)) {
            modelList.add(strCode);
        }
        sb.reset();
        this.appendDMCode(sb, psSysDMItemList, "COLUMN");
        modelList.add(sb.toString());
        strCode = sb.toString();
        if (!StringHelper.isNullOrEmpty((String)strCode)) {
            modelList.add(strCode);
        }
        if (DataObject.getBoolValue((Integer)psSystemDBConfig.getPubViewFlag(), (boolean)true)) {
            sb.reset();
            this.appendDMCode(sb, psSysDMItemList, "VIEW");
            modelList.add(sb.toString());
            strCode = sb.toString();
            if (!StringHelper.isNullOrEmpty((String)strCode)) {
                modelList.add(strCode);
            }
        }
        sb.reset();
        if (DataObject.getBoolValue((Integer)psSystemDBConfig.getPubFKeyFlag(), (boolean)true)) {
            this.appendDMCode(sb, psSysDMItemList, "FKEY");
        }
        if (DataObject.getBoolValue((Integer)psSystemDBConfig.getPubIndexFlag(), (boolean)true)) {
            this.appendDMCode(sb, psSysDMItemList, "INDEX");
        }
        modelList.add(sb.toString());
        strCode = sb.toString();
        if (!StringHelper.isNullOrEmpty((String)strCode)) {
            modelList.add(strCode);
        }
        this.onPublishDBModel(psSystemDBConfig, modelList);
        return sBuilderEx.toString();
    }

    protected void appendDMCode(StringBuilderEx sb, ArrayList<PSSysDMItem> psSysDMItemList, String strDBObjType) {
        for (PSSysDMItem psSysDMItem : psSysDMItemList) {
            if (StringHelper.compare((String)psSysDMItem.getDBObjType(), (String)strDBObjType, (boolean)true) != 0) continue;
            if (!StringHelper.isNullOrEmpty((String)psSysDMItem.getDropSql())) {
                sb.append(psSysDMItem.getDropSql());
                sb.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            }
            if (!StringHelper.isNullOrEmpty((String)psSysDMItem.getCreateSql3())) {
                sb.append(psSysDMItem.getCreateSql3());
                sb.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            }
            if (!StringHelper.isNullOrEmpty((String)psSysDMItem.getCreateSql())) {
                sb.append(psSysDMItem.getCreateSql());
                sb.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            } else if (!StringHelper.isNullOrEmpty((String)psSysDMItem.getCreateSql4())) {
                sb.append(psSysDMItem.getCreateSql4());
                sb.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            }
            if (StringHelper.isNullOrEmpty((String)psSysDMItem.getCreateSql2())) continue;
            sb.append(psSysDMItem.getCreateSql2());
            sb.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
        }
    }

    protected void onPublishDBModel(PSSystemDBCfg psSystemDBConfig, ArrayList<String> modelList) throws Exception {
        IPSDBDevInst jitPSDBDevInst;
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
        IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(false);
        if (iPSSystem.getLoadedLevel() < this.getModelLoadLevel()) {
            iPSSystem = iPSDevSlnSys.reloadPSSystem(this.getModelLoadLevel());
        }
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(psSystemDBConfig.getPSSystemDBCfgName());
        IPSDBDevInst iPSDBDevInst = null;
        if (!StringHelper.isNullOrEmpty((String)psSystemDBConfig.getPSDBDevInstId())) {
            iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(psSystemDBConfig.getPSDBDevInstId());
        }
        if ((jitPSDBDevInst = iPSSystem.getJITPSDBDevInst()) == null || StringHelper.compare((String)jitPSDBDevInst.getDBType(), (String)iPSDBType.getId(), (boolean)false) != 0) {
            jitPSDBDevInst = null;
        }
        if (iPSDBDevInst == null && jitPSDBDevInst == null) {
            throw new PSSysBTException(5, StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u6709\u6548\u6570\u636e\u5e93\u5b9e\u4f8b"));
        }
        if (iPSDBDevInst != null) {
            this.onPublishDBModel(iPSDBType, iPSDBDevInst, modelList);
        }
        if (jitPSDBDevInst != null && (iPSDBDevInst == null || StringHelper.compare((String)iPSDBDevInst.getId(), (String)jitPSDBDevInst.getId(), (boolean)false) != 0)) {
            this.onPublishDBModel(iPSDBType, jitPSDBDevInst, modelList);
        }
    }

    protected void onPublishDBModel(IPSDBType iPSDBType, IPSDBDevInst iPSDBDevInst, ArrayList<String> modelList) throws Exception {
        int nIndex = 0;
        for (String strModel : modelList) {
            String[] sqls;
            if (StringHelper.isNullOrEmpty((String)strModel)) continue;
            String[] stringArray = sqls = StringHelper.split((String)strModel, (String)"/**\u5206\u5272\u7ebf**/");
            int n = sqls.length;
            int n2 = 0;
            while (n2 < n) {
                String strSql = stringArray[n2];
                if (!StringHelper.isNullOrEmpty((String)(strSql = strSql.trim()))) {
                    log.debug((Object)StringHelper.format((String)"\u6267\u884c\u6a21\u578b\u4ee3\u7801[%1$s]\r\n%2$s", (Object)(++nIndex), (Object)strSql));
                    CallResult callResult = iPSDBType.callCreateDBModelSql(iPSDBDevInst, strSql);
                    if (callResult.isError()) {
                        log.error((Object)callResult.getErrorInfo());
                    }
                }
                ++n2;
            }
        }
    }
}

