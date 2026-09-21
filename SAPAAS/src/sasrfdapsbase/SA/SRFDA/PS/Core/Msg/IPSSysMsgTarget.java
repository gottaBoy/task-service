/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Msg;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysUtil;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysMsgTarget;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u6d88\u606f\u76ee\u6807\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysMsgTarget")
public interface IPSSysMsgTarget
extends IPSSystemObject,
IPSSysSFPubObject {
    public static final String MSGTARGETTYPE_RUNTIME = "RUNTIME";
    public static final String MSGTARGETTYPE_DE = "DE";
    public static final String MSGTARGETTYPE_USER = "USER";
    public static final String MSGTARGETTYPE_USER2 = "USER2";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysMsgTarget var3) throws Exception;

    public String getMsgTargetType();

    public IPSSystemModule getPSSystemModule();

    public IPSDataEntity getPSDataEntity();

    public IPSDEDataSet getPSDEDataSet();

    public IPSDEField getTargetPSDEField();

    public IPSDEField getTargetTypePSDEField();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSXCodeObject getRender();

    public String getMsgTargetTag();

    public String getMsgTargetTag2();

    public Properties getMsgTargetParams();

    public IPSSysUtil getPSSysUtil();
}

