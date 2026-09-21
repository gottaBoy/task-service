/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Form.SRFExFormItemErrors
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl.Form;

import SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExFormItemErrors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMStateServerFormActionHelper
extends BaseDAFormActionHelper {
    Log log = LogFactory.getLog(IMStateServerFormActionHelper.class);

    protected boolean OnSaveActionAfterFillDataEntity(BaseDataEntity dataEntity, boolean bInsert, SRFExFormItemErrors errors) {
        if (!super.OnSaveActionAfterFillDataEntity(dataEntity, bInsert, errors)) {
            return false;
        }
        String strMode = dataEntity.GetParamStringValue("CONFIGMODE", "");
        if (StringHelper.Compare((String)strMode, (String)"1", (boolean)true) == 0) {
            String strIPAddr = dataEntity.GetParamStringValue("IPADDR", "");
            String strAddr = StringHelper.Format((String)"http://%1$s:9090/SAIMServer/im/meeting?", (Object)strIPAddr);
            String strCometAddr = StringHelper.Format((String)"http://%1$s:991/SAIMServer/im/meetingcomet?", (Object)strIPAddr);
            dataEntity.SetParamValue("SERVERPATH", (Object)strAddr);
            dataEntity.SetParamValue("SERVERCOMETPATH", (Object)strCometAddr);
        } else {
            StringHelper.Compare((String)strMode, (String)"2", (boolean)true);
        }
        return true;
    }
}

