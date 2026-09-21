/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.LayoutItem;
import SA.SRFDA.Ctrl.IDAConfigPublishContext;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import net.sf.json.JSONObject;

public interface ILayoutItemPublisher
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, LayoutItem var2) throws Exception;

    public JSONObject Publish(IDAConfigPublishContext var1, BaseDataEntity var2, JSONObject var3) throws Exception;
}

