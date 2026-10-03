/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItem
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItemRS
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemRSService
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemService
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppStoryBoardService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.Util.PSAppStoryBoardHelper;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItemRS;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemRSService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppStoryBoardService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SyncAppSBModelPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SyncAppSBModelPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psSysDevBKTask.getTASKPARAM())) {
            return "\u6ca1\u6709\u6307\u5b9a\u5e94\u7528\u6545\u4e8b\u677f";
        }
        PSAppStoryBoardService psAppStoryBoardService = (PSAppStoryBoardService)ServiceGlobal.getService(PSAppStoryBoardService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSAppStoryBoard psppStoryBoard2 = new PSAppStoryBoard();
        psppStoryBoard2.setPSAppStoryBoardId(this.psSysDevBKTask.getTASKPARAM());
        psAppStoryBoardService.get(psppStoryBoard2);
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
        IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(false);
        if (iPSSystem.getLoadedLevel() < this.getModelLoadLevel()) {
            iPSSystem = iPSDevSlnSys.reloadPSSystem(this.getModelLoadLevel());
        }
        IPSApplication iPSApplication = PSSystemUtil.loadPSApplication(iPSSystem, psppStoryBoard2.getPSSysAppId(), this.getModelLoadLevel());
        try {
            PSCoreSysServiceBase.setCurrentPSSystemId((String)iPSSystem.getId());
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId((String)this.getPSDevSlnSysId());
            String strRet = this.syncAppSBModel(psppStoryBoard2, iPSApplication);
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            return strRet;
        }
        catch (Exception ex) {
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            throw ex;
        }
    }

    protected String syncAppSBModel(PSAppStoryBoard psAppStoryBoard2, IPSApplication iPSApplication) throws Exception {
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
        PSAppStoryBoardService psAppStoryBoardService = (PSAppStoryBoardService)ServiceGlobal.getService(PSAppStoryBoardService.class, (SessionFactory)sessionFactory);
        psAppStoryBoardService.reset(psAppStoryBoard2);
        PSAppSBItemService psAppSBItemService = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)sessionFactory);
        PSAppSBItemRSService psAppSBItemRSService = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)sessionFactory);
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSAPPSTORYBOARDID", (Object)psAppStoryBoard2.getPSAppStoryBoardId());
        ArrayList<PSAppSBItem> psAppSBItemList = psAppSBItemService.select((ISelectCond)selectCond);
        PSAppStoryBoardHelper psAppStoryBoardHelper = new PSAppStoryBoardHelper();
        HashMap<String, PSAppSBItem> psAppSBItemMap = new HashMap<String, PSAppSBItem>();
        ArrayList<PSAppSBItemRS> psAppSBItemRSList = new ArrayList<PSAppSBItemRS>();
        HashMap<String, String> psAppSBItemCodeNameMap = new HashMap<String, String>();
        if (psAppSBItemList.size() > 0) {
            for (PSAppSBItem psAppSBItem : psAppSBItemList) {
                if (StringHelper.isNullOrEmpty((String)psAppSBItem.getPSAppViewId())) continue;
                psAppSBItemMap.put(psAppSBItem.getPSAppViewId(), psAppSBItem);
                psAppSBItemCodeNameMap.put(psAppSBItem.getCodeName().toUpperCase(), "");
            }
            for (PSAppSBItem psAppSBItem : psAppSBItemList) {
                if (StringHelper.isNullOrEmpty((String)psAppSBItem.getPSAppViewId())) continue;
                IPSAppView iPSAppView = iPSApplication.getPSAppView(psAppSBItem.getPSAppViewId(), false);
                psAppStoryBoardHelper.getPSAppSBItem(iPSAppView, false, psAppStoryBoard2, psAppSBItemMap, psAppSBItemRSList);
            }
        } else {
            IPSAppView iPSAppView = iPSApplication.getDefaultPSAppView();
            if (iPSAppView != null) {
                psAppStoryBoardHelper.getPSAppSBItem(iPSAppView, false, psAppStoryBoard2, psAppSBItemMap, psAppSBItemRSList);
            }
        }
        Timestamp curTime = new Timestamp(System.currentTimeMillis());
        int nIndex = 100;
        ArrayList<PSAppSBItem> psAppSBItemList2 = new ArrayList<PSAppSBItem>();
        for (PSAppSBItem psAppSBItem : psAppSBItemMap.values()) {
            if (DataObject.getBoolValue((Integer)psAppSBItem.getUserFlag(), (boolean)false)) continue;
            String strCodeName = "";
            while (psAppSBItemCodeNameMap.containsKey((strCodeName = StringHelper.format((String)"Auto%1$s", (Object)(++nIndex))).toUpperCase())) {
            }
            psAppSBItem.setValidFlag(Integer.valueOf(1));
            psAppSBItem.setUserFlag(Integer.valueOf(0));
            psAppSBItem.setCodeName(strCodeName);
            psAppSBItem.setCreateMan("SYSTEM");
            psAppSBItem.setUpdateMan("SYSTEM");
            psAppSBItem.setCreateDate(curTime);
            psAppSBItem.setUpdateDate(curTime);
            psAppSBItemList2.add(psAppSBItem);
        }
        nIndex = 100;
        ArrayList<PSAppSBItemRS> psAppSBItemRSList2 = new ArrayList<PSAppSBItemRS>();
        for (PSAppSBItemRS psAppSBItemRS : psAppSBItemRSList) {
            String strCodeName = StringHelper.format((String)"Auto%1$s", (Object)nIndex);
            ++nIndex;
            psAppSBItemRS.setValidFlag(Integer.valueOf(1));
            psAppSBItemRS.setUserFlag(Integer.valueOf(0));
            psAppSBItemRS.setCodeName(strCodeName);
            psAppSBItemRS.setCreateMan("SYSTEM");
            psAppSBItemRS.setUpdateMan("SYSTEM");
            psAppSBItemRS.setCreateDate(curTime);
            psAppSBItemRS.setUpdateDate(curTime);
            psAppSBItemRSList2.add(psAppSBItemRS);
        }
        PSSysModelInstGlobal.active((String)this.getPSSysModelInstId());
        psAppSBItemService.executeBatchCreate(new ArrayList<IEntity>(psAppSBItemList2), 2000);
        PSSysModelInstGlobal.active((String)this.getPSSysModelInstId());
        psAppSBItemRSService.executeBatchCreate(new ArrayList<IEntity>(psAppSBItemRSList2), 2000);
        return sBuilderEx.toString();
    }
}
