/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.Workspace.IPSWorkspaceType;
import SA.SRFDA.PS.Core.Workspace.PSWorkspacePeriod;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.sql.Timestamp;
import java.util.Date;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWorkspaceTypeDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSWorkspaceTypeDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSWorkspaceTypeId = dataEntity.getParamStringValue("PSWORKSPACETYPEID", "");
        this.getPSModelStorage().resetPSWorkspaceType(strPSWorkspaceTypeId);
        IPSWorkspaceType iPSWorkspaceType = this.getPSModelStorage().getPSWorkspaceType(strPSWorkspaceTypeId);
        String strTestDate = iPSWorkspaceType.getUserParam("TESTDATE", null);
        if (!StringHelper.isNullOrEmpty((String)strTestDate)) {
            Timestamp calcTime = new Timestamp(DateHelper.parse((String)strTestDate).getTime());
            PSWorkspacePeriod psWorkspacePeriod = iPSWorkspaceType.calcPSWorkspacePeriod(calcTime, true);
            if (psWorkspacePeriod == null) {
                log.info((Object)StringHelper.format((String)"\u8ba1\u7b97\u65f6\u95f4[%1$s]\u5468\u671f\u65e0\u8fd4\u56de", (Object)DateHelper.toDateTimeString((Date)calcTime)));
            } else {
                log.info((Object)StringHelper.format((String)"\u8ba1\u7b97\u65f6\u95f4[%1$s]\u5468\u671f[%2$s]-[%3$s]===[%4$s]", (Object)DateHelper.toDateTimeString((Date)calcTime), (Object)DateHelper.toDateTimeString((Date)psWorkspacePeriod.getBeginTime()), (Object)DateHelper.toDateTimeString((Date)psWorkspacePeriod.getEndTime()), (Object)psWorkspacePeriod.isNextMode()));
            }
        }
    }
}

