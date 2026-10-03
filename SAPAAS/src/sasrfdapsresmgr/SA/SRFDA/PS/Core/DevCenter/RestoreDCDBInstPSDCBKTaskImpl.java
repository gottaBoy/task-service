/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Database.IPSDBType
 *  SA.SRFDA.PS.Core.Database.IPSDBType4
 *  SA.SRFDA.PS.Core.DevCenter.PSDevCenterBKTaskImplBase
 *  SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstBK
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstBKService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDBType4;
import SA.SRFDA.PS.Core.DevCenter.PSDevCenterBKTaskImplBase;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstBK;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstBKService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import org.hibernate.SessionFactory;

public class RestoreDCDBInstPSDCBKTaskImpl
extends PSDevCenterBKTaskImplBase {
    protected String onRun() throws Exception {
        String strPSDCDBInstId = this.getTaskParam();
        PSDevCenterDBInstService psDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevCenterDBInst psDevCenterDBInst = new PSDevCenterDBInst();
        psDevCenterDBInst.setPSDevCenterDBInstId(strPSDCDBInstId);
        psDevCenterDBInstService.get(psDevCenterDBInst);
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(psDevCenterDBInst.getDBType());
        if (!(iPSDBType instanceof IPSDBType4)) {
            throw new Exception(StringHelper.format((String)"\u6570\u636e\u5e93[%1$s]\u4e0d\u652f\u6301\u6570\u636e\u5e93\u6062\u590d\u64cd\u4f5c", (Object)iPSDBType.getName()));
        }
        IPSDBType4 iPSDBType4 = (IPSDBType4)iPSDBType;
        BaseDataEntity psDevCenterDBInstData = new BaseDataEntity();
        PSDEDataCtrl.convertEntity((IEntity)psDevCenterDBInst, (BaseDataEntity)psDevCenterDBInstData);
        PSDCDBInstBKService psDCDBInstBKService = (PSDCDBInstBKService)ServiceGlobal.getService(PSDCDBInstBKService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCDBInstBK psDCDBInstBK = new PSDCDBInstBK();
        String strPSDCDBInstBKId = this.getTaskParam2();
        psDCDBInstBK.setPSDCDBInstBKId(strPSDCDBInstBKId);
        psDCDBInstBKService.get(psDCDBInstBK);
        BaseDataEntity psDCDBInstBKData = new BaseDataEntity();
        PSDEDataCtrl.convertEntity((IEntity)psDCDBInstBK, (BaseDataEntity)psDCDBInstBKData);
        this.updatePSDCBKTaskStep("\u6b63\u5728\u6062\u590d", 300, 300);
        iPSDBType4.restoreDBInst("PSDEVCENTERDBINST", psDevCenterDBInstData, psDCDBInstBKData);
        this.updatePSDCBKTaskStep("", 0);
        return super.onRun();
    }
}
