/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  MuleEventContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Endpoint;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.HashMap;
import java.util.Map;

public class BaseProcessEndpoint {
    public static BaseDataEntity GetDataEntity(Object object) throws Exception {
        throw new Error("Unresolved compilation problem: \n\tNullPayload cannot be resolved to a type\n");
    }

    public static Map GetPayload(Object objPayload, BaseDataEntity dataEntity) throws Exception {
        return BaseProcessEndpoint.GetPayload(objPayload, dataEntity, false);
    }

    public static Map GetPayload(Object objPayload, BaseDataEntity dataEntity, boolean bReset) throws Exception {
        if (objPayload instanceof Map) {
            Map map = (Map)objPayload;
            if (bReset) {
                map.clear();
            }
            dataEntity.FillMap(map);
            return map;
        }
        if (objPayload instanceof BaseDataEntity) {
            BaseDataEntity lastDataEntity = (BaseDataEntity)objPayload;
            HashMap map = new HashMap();
            if (!bReset) {
                lastDataEntity.FillMap(map);
            }
            dataEntity.FillMap(map);
            return map;
        }
        throw new Exception("\u65e0\u6cd5\u8bc6\u522b\u7684\u5bf9\u8c61");
    }

    public static ISRFDAGlobalHelper GetGlobalHelper(MuleEventContext muleEventContext) {
        throw new Error("Unresolved compilation problem: \n\tMuleEventContext cannot be resolved to a type\n");
    }
}

