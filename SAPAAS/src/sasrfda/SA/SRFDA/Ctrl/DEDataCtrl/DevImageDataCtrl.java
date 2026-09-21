/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.IDevImageDataCtrl;
import SA.SRFDA.Ctrl.Data.DevImgDetail;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public class DevImageDataCtrl
extends BaseDEDataCtrl
implements IDevImageDataCtrl {
    @Override
    public CallResult ListDevImgDetails(String strDevImageId, Vector<DevImgDetail> details) {
        String strSQL = "select * from V_SRFDEVIMGDETAIL WHERE DEVIMAGEID = ? ";
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strDevImageId);
        return BaseDEDataCtrl.SelectMultiEx(this.getGlobalHelper(), this.GetDEHelper().GetDBStorage(), strSQL, callParamList.GetList(), details, DevImgDetail.class.getName());
    }
}

