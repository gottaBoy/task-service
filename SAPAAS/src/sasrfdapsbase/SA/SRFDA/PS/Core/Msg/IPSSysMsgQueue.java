/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Msg;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
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
import SA.SRFDA.PS.Data.PSSysMsgQueue;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u6d88\u606f\u961f\u5217\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysMsgQueue")
public interface IPSSysMsgQueue
extends IPSSystemObject,
IPSSysSFPubObject {
    public static final String MSGQUEUETYPE_RUNTIME = "RUNTIME";
    public static final String MSGQUEUETYPE_DE = "DE";
    public static final String MSGQUEUETYPE_USER = "USER";
    public static final String MSGQUEUETYPE_USER2 = "USER2";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysMsgQueue var3) throws Exception;

    public String getMsgQueueType();

    public IPSSystemModule getPSSystemModule();

    public IPSDataEntity getPSDataEntity();

    public IPSDEField getTargetPSDEField();

    public IPSDEField getTargetTypePSDEField();

    public IPSDEField getTagPSDEField();

    public IPSDEField getTag2PSDEField();

    public IPSDEField getTitlePSDEField();

    public IPSDEField getContentPSDEField();

    public IPSDEField getMsgTypePSDEField();

    public IPSDEField getSendTimePSDEField();

    public IPSDEField getStatePSDEField();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSXCodeObject getRender();

    public String getMsgQueueTag();

    public String getMsgQueueTag2();

    public IPSDEField getSMSContentPSDEField();

    public IPSDEField getIMContentPSDEField();

    public IPSDEField getWXContentPSDEField();

    public IPSDEField getDDContentPSDEField();

    public IPSDEField getTaskUrlPSDEField();

    public IPSDEField getMobTaskUrlPSDEField();

    public IPSDEField getFilePSDEField();

    public Properties getMsgQueueParams();

    public IPSSysUtil getPSSysUtil();
}

