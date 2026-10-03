/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Deploy.IPSDCDeployCenter;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatformNode;
import SA.SRFDA.PS.Core.Deploy.IPSSysRunSession;
import SA.SRFDA.PS.Core.Deploy.PSSysRunSessionImpl;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskSessionContext;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSDevSlnSysDynaInst;
import SA.SRFDA.PS.Core.IPSDevSlnSysRuntime;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Data.PSSysRunSession;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class StartupExPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(StartupExPSSysDevBKTaskImpl.class);
    private IPSSysRunSession iPSSysRunSession = null;
    private IPSDevSlnSys iPSDevSlnSys = null;
    private IPSSystem iPSSystem = null;
    private IPSDevSlnSysDynaInst iPSDevSlnSysDynaInst = null;
    private PSDCRegistryItem lastPSDCRegistryItem = null;
    private PSDCRegistryItem psDCRegistryItem = null;
    private PSDCRegistryItem nodePSDCRegistryItem = null;
    private String strBackupPSDCRegistryItemId = null;

    @Override
    protected void onInit() throws Exception {
        PSSysRunSession psSysRunSession = new PSSysRunSession();
        CallResult callResult = this.getPSModelHelper().getPSSysRunSession(this.getTaskParam(), psSysRunSession);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u7cfb\u7edf\u8fd0\u884c\u4f1a\u8bdd\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysDevBKTask.getPSDYNAINSTID())) {
            this.iPSDevSlnSysDynaInst = this.getPSModelStorage().getPSDevSlnSysDynaInst(this.psSysDevBKTask.getPSDYNAINSTID());
            this.iPSDevSlnSys = this.iPSDevSlnSysDynaInst.getPSDevSlnSys();
        } else {
            this.iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
        }
        this.iPSSystem = this.iPSDevSlnSys.getPSSystem(false);
        if (this.iPSSystem.getLoadedLevel() < this.getModelLoadLevel()) {
            this.iPSSystem = this.iPSDevSlnSys.reloadPSSystem(this.getModelLoadLevel());
        }
        PSSysRunSessionImpl psSysRunSessionImpl = new PSSysRunSessionImpl();
        psSysRunSessionImpl.init(this.getDAGlobalHelper(), this.iPSSystem, psSysRunSession);
        this.iPSSysRunSession = psSysRunSessionImpl;
        super.onInit();
    }

    @Override
    public boolean run(IPSBKTaskSessionContext iPSBKTaskSessionContext) {
        if (this.iPSSysRunSession.isRebuildMode()) {
            ((IPSSystemUtil)((Object)this.iPSDevSlnSys)).resetFileCache();
        }
        return super.run(iPSBKTaskSessionContext);
    }

    @Override
    protected void onBeforeRun() throws Exception {
        block29: {
            int nQuickModeEx;
            IPSDevSlnSysRuntime iPSDevSlnSysRuntime;
            if (StringHelper.compare((String)this.getTaskType(), (String)"STARTUPEX5", (boolean)false) != 0 && StringHelper.compare((String)this.getTaskType(), (String)"STARTUPEX6", (boolean)false) != 0) break block29;
            IPSDCDeployCenter iPSDCDeployCenter = null;
            if (this.iPSDevSlnSys instanceof IPSDevSlnSysRuntime && (iPSDevSlnSysRuntime = (IPSDevSlnSysRuntime)((Object)this.iPSDevSlnSys)).getPSDeployCenter() != null && iPSDevSlnSysRuntime.getPSDeployCenter() instanceof IPSDCDeployCenter) {
                iPSDCDeployCenter = (IPSDCDeployCenter)iPSDevSlnSysRuntime.getPSDeployCenter();
            }
            String strItemTag = null;
            IPSDCMSPlatformNode iPSDCMSPlatformNode = null;
            if (StringHelper.compare((String)this.getTaskType(), (String)"STARTUPEX5", (boolean)false) == 0) {
                if (this.getPSSysRunSession().getPSDevSlnMSDepAPI() != null) {
                    iPSDCMSPlatformNode = this.getPSSysRunSession().getPSDevSlnMSDepAPI().getPSDCMSPlatformNode();
                    strItemTag = "api";
                }
            } else if (StringHelper.compare((String)this.getTaskType(), (String)"STARTUPEX6", (boolean)false) == 0 && this.getPSSysRunSession().getPSDevSlnMSDepApp() != null) {
                iPSDCMSPlatformNode = this.getPSSysRunSession().getPSDevSlnMSDepApp().getPSDCMSPlatformNode();
                strItemTag = "app";
            }
            if ((nQuickModeEx = this.getPSSysRunSession().getQuickModeEx()) > 0 || iPSDCDeployCenter == null) {
                String strPSDCRegistryItemId = null;
                if (nQuickModeEx == 2) {
                    strPSDCRegistryItemId = this.getPSSysRunSession().getPSDCRegistryItemId();
                }
                if (StringHelper.isNullOrEmpty(strPSDCRegistryItemId) && iPSDCMSPlatformNode != null) {
                    strPSDCRegistryItemId = iPSDCMSPlatformNode.getPSDCRegistryItemId();
                }
                if (!StringHelper.isNullOrEmpty((String)strPSDCRegistryItemId)) {
                    PSDCRegistryItemService psDCRegistryItemService = (PSDCRegistryItemService)ServiceGlobal.getService(PSDCRegistryItemService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    PSDCRegistryItem psDCRegistryItem = new PSDCRegistryItem();
                    psDCRegistryItem.setPSDCRegistryItemId(strPSDCRegistryItemId);
                    if (!psDCRegistryItemService.get(psDCRegistryItem, true)) {
                        throw new Exception(String.format("\u8282\u70b9[%1$s]\u6307\u5b9a\u955c\u50cf[%2$s]\u4e0d\u5b58\u5728", iPSDCMSPlatformNode.getName(), strPSDCRegistryItemId));
                    }
                    this.nodePSDCRegistryItem = psDCRegistryItem;
                }
            }
            if (this.getNodePSDCRegistryItem() != null || iPSDCDeployCenter == null || iPSDCDeployCenter.getPSRegistryRepo() == null || StringHelper.isNullOrEmpty((String)iPSDCDeployCenter.getPSDCRegistryRepoId())) break block29;
            try {
                IPSSysServiceAPI iPSSysServiceAPI = null;
                IPSApplication iPSApplication = null;
                if (StringHelper.compare((String)this.getTaskType(), (String)"STARTUPEX5", (boolean)false) == 0) {
                    if (this.getPSSysRunSession().getPSDevSlnMSDepAPI() != null) {
                        iPSSysServiceAPI = this.getPSSysRunSession().getPSDevSlnMSDepAPI().getPSSysServiceAPI();
                    }
                } else if (StringHelper.compare((String)this.getTaskType(), (String)"STARTUPEX6", (boolean)false) == 0 && this.getPSSysRunSession().getPSDevSlnMSDepApp() != null) {
                    iPSApplication = this.getPSSysRunSession().getPSDevSlnMSDepApp().getPSApplication();
                }
                if (iPSSysServiceAPI == null && iPSApplication == null) break block29;
                PSDCRegistryItemService psDCRegistryItemService = (PSDCRegistryItemService)ServiceGlobal.getService(PSDCRegistryItemService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                String strDate = String.format("%1$tY.%1$tm.%1$td", new Date());
                SelectContext selectContext = new SelectContext();
                selectContext.set("PSDCREGISTRYREPOID", (Object)iPSDCDeployCenter.getPSDCRegistryRepoId());
                selectContext.set("PSDEVSLNSYSID", (Object)this.iPSDevSlnSys.getId());
                if (iPSSysServiceAPI != null) {
                    selectContext.set("ITEMTAG", (Object)"api");
                    selectContext.set("ITEMTAG2", (Object)iPSSysServiceAPI.getCodeName().toLowerCase());
                } else {
                    selectContext.set("ITEMTAG", (Object)"app");
                    selectContext.set("ITEMTAG2", (Object)iPSApplication.getCodeName().toLowerCase());
                }
                selectContext.set("ITEMTAG3", (Object)strDate);
                selectContext.setOrderInfo("order by PSDCREGISTRYITEMNAME desc");
                selectContext.setMaxRowCount(1);
                ArrayList list = psDCRegistryItemService.select((ISelectCond)selectContext);
                PSDCRegistryItem lastPSDCRegistryItem = null;
                if (list != null && list.size() != 0) {
                    lastPSDCRegistryItem = (PSDCRegistryItem)list.get(0);
                }
                String strNewVersion = null;
                boolean bMatch = false;
                int i = 1;
                while (i < 100) {
                    block32: {
                        block30: {
                            block31: {
                                strNewVersion = String.format("%1$s.%2$03d", strDate, i);
                                if (lastPSDCRegistryItem == null) break block30;
                                if (!bMatch) break block31;
                                if (lastPSDCRegistryItem.getPSDCRegistryItemName().indexOf(strNewVersion) == -1) {
                                    break;
                                }
                                break block32;
                            }
                            if (lastPSDCRegistryItem.getPSDCRegistryItemName().indexOf(strNewVersion) == -1) break block32;
                            bMatch = true;
                            break block32;
                        }
                        bMatch = true;
                        break;
                    }
                    ++i;
                }
                if (!bMatch) {
                    strNewVersion = String.format("%1$s.%2$06d", strDate, Math.abs(new Random().nextInt(100000)));
                }
                if (!this.getPSModelStorage().isCloudMode() && this.getPSSysRunSession().isQuickMode() && lastPSDCRegistryItem == null) {
                    selectContext.reset();
                    selectContext.set("PSDCREGISTRYREPOID", (Object)iPSDCDeployCenter.getPSDCRegistryRepoId());
                    selectContext.set("PSDEVSLNSYSID", (Object)this.iPSDevSlnSys.getId());
                    if (iPSSysServiceAPI != null) {
                        selectContext.set("ITEMTAG", (Object)"api");
                        selectContext.set("ITEMTAG2", (Object)iPSSysServiceAPI.getCodeName().toLowerCase());
                    } else {
                        selectContext.set("ITEMTAG", (Object)"app");
                        selectContext.set("ITEMTAG2", (Object)iPSApplication.getCodeName().toLowerCase());
                    }
                    selectContext.setOrderInfo("order by PSDCREGISTRYITEMNAME desc");
                    selectContext.setMaxRowCount(1);
                    list = psDCRegistryItemService.select((ISelectCond)selectContext);
                    if (list != null && list.size() != 0) {
                        lastPSDCRegistryItem = (PSDCRegistryItem)list.get(0);
                    }
                }
                PSDCRegistryItem psDCRegistryItem = new PSDCRegistryItem();
                psDCRegistryItem.setPSDevSlnSysId(this.iPSDevSlnSys.getId());
                psDCRegistryItem.setPSDevSlnSysName(this.iPSDevSlnSys.getName());
                psDCRegistryItem.setPSDCRegistryRepoId(iPSDCDeployCenter.getPSDCRegistryRepoId());
                if (iPSSysServiceAPI != null) {
                    psDCRegistryItem.setPSDCRegistryItemName(String.format("%1$s-%2$s-%3$s-%4$s:%5$s", this.iPSDevSlnSys.getPSDevSlnCodeName(), this.iPSDevSlnSys.getName(), "api", iPSSysServiceAPI.getCodeName(), strNewVersion).toLowerCase());
                    psDCRegistryItem.setItemTag("api");
                    psDCRegistryItem.setItemTag2(iPSSysServiceAPI.getCodeName().toLowerCase());
                    psDCRegistryItem.setItemTag3(strDate);
                    psDCRegistryItem.setLogicName(iPSSysServiceAPI.getName());
                } else {
                    psDCRegistryItem.setPSDCRegistryItemName(String.format("%1$s-%2$s-%3$s-%4$s:%5$s", this.iPSDevSlnSys.getPSDevSlnCodeName(), this.iPSDevSlnSys.getName(), "app", iPSApplication.getCodeName(), strNewVersion).toLowerCase());
                    psDCRegistryItem.setItemTag("app");
                    psDCRegistryItem.setItemTag2(iPSApplication.getCodeName().toLowerCase());
                    psDCRegistryItem.setItemTag3(strDate);
                    psDCRegistryItem.setLogicName(iPSApplication.getName());
                }
                psDCRegistryItemService.create(psDCRegistryItem, false);
                this.psDCRegistryItem = psDCRegistryItem;
                this.lastPSDCRegistryItem = lastPSDCRegistryItem;
                if (iPSDCMSPlatformNode != null) {
                    this.strBackupPSDCRegistryItemId = iPSDCMSPlatformNode.getPSDCRegistryItemId();
                }
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u4e2d\u5fc3\u955c\u50cf\u9879\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        super.onBeforeRun();
    }

    @Override
    public IPSSysRunSession getPSSysRunSession() {
        return this.iPSSysRunSession;
    }

    public PSDCRegistryItem getPSDCRegistryItem() {
        return this.psDCRegistryItem;
    }

    public PSDCRegistryItem getLastPSDCRegistryItem() {
        return this.lastPSDCRegistryItem;
    }

    public PSDCRegistryItem getNodePSDCRegistryItem() {
        return this.nodePSDCRegistryItem;
    }

    public String getBackupPSDCRegistryItemId() {
        return this.strBackupPSDCRegistryItemId;
    }
}
