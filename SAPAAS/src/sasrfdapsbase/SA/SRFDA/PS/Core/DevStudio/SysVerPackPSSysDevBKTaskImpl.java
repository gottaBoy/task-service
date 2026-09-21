/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst
 *  net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.io.File;
import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SysVerPackPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SysVerPackPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        PSDevSlnSysVerService psDevSlnSysVerService = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class);
        PSDevSlnSysVer psDevSlnSysVer = new PSDevSlnSysVer();
        psDevSlnSysVer.setPSDevSlnSysVerId(this.psSysDevBKTask.getTASKPARAM2());
        psDevSlnSysVerService.get((IEntity)psDevSlnSysVer);
        if (DataObject.getBoolValue((Integer)psDevSlnSysVer.getPackSysModelInst(), (boolean)false)) {
            PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class);
            PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
            psDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
            psDevSlnSysService.get((IEntity)psDevSlnSys);
            PSSysModelInst psSysModelInst = this.getPSSysModelInst(psDevSlnSys, psDevSlnSysVer);
            if (StringHelper.isNullOrEmpty((String)psDevSlnSysVer.getPSSysModelInstId())) {
                PSDevSlnSysVer psDevSlnSysVer2 = new PSDevSlnSysVer();
                psDevSlnSysVer2.setPSDevSlnSysVerId(this.psSysDevBKTask.getTASKPARAM2());
                psDevSlnSysVer2.setPSSysModelInstId(psSysModelInst.getPSSysModelInstId());
                psDevSlnSysVer2.setPSSysModelInstName(psSysModelInst.getPSSysModelInstName());
                psDevSlnSysVerService.update((IEntity)psDevSlnSysVer2);
            }
        }
        PSSysSFPubService psSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSysSFPub psSysSFPub = new PSSysSFPub();
        psSysSFPub.setPSSysSFPubId(this.psSysDevBKTask.getTASKPARAM());
        psSysSFPubService.get((IEntity)psSysSFPub);
        return this.packSysVer(psSysSFPub);
    }

    protected String packSysVer(PSSysSFPub psSysSFPub) throws Exception {
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
        IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(true);
        String strCodeFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", null);
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = String.valueOf(strCodeFolder) + iPSSystem.getPSDevCenterDomain();
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = String.valueOf(strCodeFolder) + iPSSystem.getPubSystemId();
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = String.valueOf(strCodeFolder) + iPSSystem.getVCName();
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = String.valueOf(strCodeFolder) + "srv_" + psSysSFPub.getCodeName();
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = String.valueOf(strCodeFolder) + "TOOLS";
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = StringHelper.compare((String)PSTaskServerEnvImpl.getCurrent().getOSType(), (String)"LINUX", (boolean)true) == 0 ? String.valueOf(strCodeFolder) + "packsysver.sh" : String.valueOf(strCodeFolder) + "packsysver.bat";
        String strResult = this.runBat(strCodeFolder, false);
        return strResult;
    }

    protected PSSysModelInst getPSSysModelInst(PSDevSlnSys et, PSDevSlnSysVer psDevSlnSysVer) throws Exception {
        PSSysModelInstService psSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSysModelInst psSysModelInst = psDevSlnSysVer.getPSSysModelInst();
        String strSrcPSSysModelInstId = et.getPSSysModelInstId();
        if (psSysModelInst == null) {
            PSDevCenter psDevCenter;
            SelectCond selectCond = new SelectCond();
            selectCond.set("INSTSTATE", (Object)"20");
            PSDevSln psDevSln = et.getPSDevSln();
            PSDevCenter pSDevCenter = psDevCenter = psDevSln == null ? null : psDevSln.getPSDevCenter();
            if (psDevCenter != null && !StringHelper.isNullOrEmpty((String)psDevCenter.getPSSvrDomainId())) {
                selectCond.set("PSSVRDOMAINID", (Object)psDevCenter.getPSSvrDomainId());
            }
            if (!StringHelper.isNullOrEmpty((String)strSrcPSSysModelInstId)) {
                selectCond.set("INSTSTATE", (Object)"10");
            }
            selectCond.setFetchFirst(true);
            ArrayList psSysModelInstList = psSysModelInstService.select((ISelectCond)selectCond);
            if (psSysModelInstList.size() == 0) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u6a21\u578b\u5b9e\u4f8b"));
            }
            psSysModelInst = (PSSysModelInst)psSysModelInstList.get(0);
        }
        int nCurVersion = 0;
        IDEDataCtrl iDEDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE1895", "SYSTEM", null);
        SA.SRFDA.PS.Data.PSSysModelInst srcPSSysModelInst = new SA.SRFDA.PS.Data.PSSysModelInst();
        srcPSSysModelInst.setPSSYSMODELINSTID(psSysModelInst.getPSSysModelInstId());
        psSysModelInst.set("SRCPSSYSMODELINSTID", (Object)strSrcPSSysModelInstId);
        CallResult callResult = iDEDataCtrl.CustomCall("CLONE", (BaseDataEntity)srcPSSysModelInst);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u514b\u9686\u7cfb\u7edf\u6a21\u578b\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        nCurVersion = srcPSSysModelInst.getMODELVER();
        psSysModelInst.setPSDevCenterId(et.getPSDevSln().getPSDevCenterId());
        psSysModelInst.setPSDevCenterName(et.getPSDevSln().getPSDevCenterName());
        String strReferInfo = StringHelper.format((String)"[\u5f00\u53d1\u7cfb\u7edf\u6253\u5305]%1$s\\%2$s\\%3$s", (Object)et.getPSDevSlnName(), (Object)et.getPSDevSlnSysName(), (Object)psDevSlnSysVer.getPSDevSlnSysVerName());
        psSysModelInst.setRefInfo(strReferInfo);
        psSysModelInst.setModelVer(Integer.valueOf(nCurVersion));
        psSysModelInst.setInstState("30");
        psSysModelInstService.update((IEntity)psSysModelInst);
        return psSysModelInst;
    }
}

