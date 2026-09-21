/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Notify;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Notify.IPSDENotify;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTarget;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDENotifyTarget;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u901a\u77e5\u76ee\u6807\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDENotifyTarget")
public interface IPSDENotifyTarget
extends IPSModelObject {
    public static final String TARGETTYPE_DEFIELD = "DEFIELD";
    public static final String TARGETTYPE_SYSMSGTARGET = "SYSMSGTARGET";
    public static final String TARGETTYPE_USER = "USER";
    public static final String TARGETTYPE_USER2 = "USER2";

    public void init(ISRFDAGlobalHelper var1, IPSDENotify var2, PSDENotifyTarget var3) throws Exception;

    public IPSDENotify getPSDENotify();

    public String getTargetType();

    public IPSSysMsgTarget getPSSysMsgTarget() throws Exception;

    public IPSDEField getTargetPSDEField();

    public IPSDEField getTargetTypePSDEField();

    public String getFilter();

    public String getData();
}

