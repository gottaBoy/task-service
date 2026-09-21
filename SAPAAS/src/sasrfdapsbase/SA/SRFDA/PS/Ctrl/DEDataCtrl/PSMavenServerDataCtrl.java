/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMavenServerDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSMavenServerDataCtrl.class);
    private static final Object objLock = new Object();
    public static final String CUSTOMCALL_INITREP = "INITREP";
    public static final String CUSTOMCALL_INITREP2 = "INITREP2";
    public static final String CUSTOMCALL_UPDATEAUTHZ = "UPDATEAUTHZ";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        return super.OnCustomCall(strCallName, dataEntity);
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSMavenServerId = dataEntity.getParamStringValue("PSMAVENSERVERID", "");
        this.getPSModelStorage().resetPSMavenServer(strPSMavenServerId);
    }
}

