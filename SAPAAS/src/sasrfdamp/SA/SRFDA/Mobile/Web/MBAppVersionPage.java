/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Mobile.Web;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class MBAppVersionPage
extends SRFDAPageEx {
    private String strLastVersion = "";

    protected void OnLoad() {
        super.OnLoad();
        String strAction = this.getWebContext().GetParamValue("ACTION");
        StringHelper.Compare((String)strAction, (String)"GETLASTVERSION", (boolean)true);
    }

    public boolean IsLast() {
        String strAppId = this.getWebContext().GetParamValue("appid");
        String strAppVersion = this.getWebContext().GetParamValue("appversion");
        String strOSVersion = this.getWebContext().GetParamValue("osversion");
        this.strLastVersion = this.getLastValidVersion(strAppId);
        if (StringHelper.IsNullOrEmpty((String)this.strLastVersion)) {
            return true;
        }
        return StringHelper.Compare((String)strAppVersion, (String)this.strLastVersion, (boolean)true) == 0;
    }

    protected String getLastValidVersion(String strAppId) {
        IDEDataCtrl iDEDataCtrl = this.GetDEDataCtrl("DE0388");
        BaseDataEntity condition = new BaseDataEntity();
        condition.SetParamValue("MOBILEAPPID", (Object)strAppId);
        Vector vector = new Vector();
        CallResult callResult = iDEDataCtrl.Select(condition, vector);
        if (callResult.IsOk() && vector.size() > 0) {
            BaseDataEntity dataEntity = (BaseDataEntity)vector.get(0);
            return dataEntity.GetParamStringValue("MOBAPPVERNAME", "");
        }
        return "";
    }

    public String getLastVersion() {
        return "HD ver " + this.strLastVersion;
    }
}

