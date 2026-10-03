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
        if (object instanceof BaseDataEntity) {
            return (BaseDataEntity)object;
        }
        BaseDataEntity entity = new BaseDataEntity();
        if (object instanceof Map) {
            entity.FromMap((Map)object);
            return entity;
        }
        if (object instanceof org.mule.transport.NullPayload) {
            return entity;
        }
        throw new Exception("\u65e0\u6cd5\u8bc6\u522b\u7684\u5bf9\u8c61");
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

    public static ISRFDAGlobalHelper GetGlobalHelper(org.mule.api.MuleEventContext muleEventContext) {
        org.mule.api.MuleContext context = muleEventContext == null ? null : muleEventContext.getMuleContext();
        if (context == null || context.getRegistry() == null) {
            throw new IllegalArgumentException("Mule context and registry are required");
        }
        Object helper = context.getRegistry().lookupObject("SRFDACONTEXTHELPER");
        if (!(helper instanceof ISRFDAGlobalHelper)) {
            throw new IllegalStateException("Mule registry has no ISRFDAGlobalHelper at SRFDACONTEXTHELPER");
        }
        return (ISRFDAGlobalHelper)helper;
    }
}

