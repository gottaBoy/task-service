/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService
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
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PubSysDBModelPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(PubSysDBModelPSSysDevBKTaskImpl.class);

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
        return this.pubSysDBModel(psSystemDBConfig2);
    }

    protected String pubSysDBModel(PSSystemDBCfg psSystemDBConfig) throws Exception {
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
        PSSysDMItemService psSysDMItemService = (PSSysDMItemService)ServiceGlobal.getService(PSSysDMItemService.class, (SessionFactory)sessionFactory);
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
        strCode = sb.toString();
        if (!StringHelper.isNullOrEmpty((String)strCode)) {
            modelList.add(strCode);
        }
        sb.reset();
        this.appendDMCode(sb, psSysDMItemList, "VIEW");
        strCode = sb.toString();
        if (!StringHelper.isNullOrEmpty((String)strCode)) {
            modelList.add(strCode);
        }
        sb.reset();
        this.appendDMCode(sb, psSysDMItemList, "FKEY");
        this.appendDMCode(sb, psSysDMItemList, "INDEX");
        strCode = sb.toString();
        if (!StringHelper.isNullOrEmpty((String)strCode)) {
            modelList.add(strCode);
        }
        this.onPublishDBModel(psSystemDBConfig, modelList);
        return null;
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
            throw new PSSysBTException(5, StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u6709\u6548\u7684\u6570\u636e\u5e93\u5b9e\u4f8b"));
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

