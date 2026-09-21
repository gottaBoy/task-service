/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataSync.IPSDEDataSync;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.Notify.IPSDENotify;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysLogic;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSequence;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Data.PSDEActionLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u884c\u4e3a\u9644\u52a0\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", description="", model="PSDEActionLogic")
public interface IPSDEActionLogic
extends IPSModelObject {
    public static final String ATTACHMODE_PREPARE = "PREPARE";
    public static final String ATTACHMODE_CHECK = "CHECK";
    public static final String ATTACHMODE_BEFORE = "BEFORE";
    public static final String ATTACHMODE_AFTER = "AFTER";
    public static final int ACTIONLOGICTYPE_INTERNAL = 1;
    public static final int ACTIONLOGICTYPE_EXTERNAL = 0;
    public static final int ACTIONLOGICTYPE_SCRIPT = 2;
    public static final int ACTIONLOGICTYPE_NOTIFY = 3;
    public static final int ACTIONLOGICTYPE_FILLMAINSTATE = 4;
    public static final int ACTIONLOGICTYPE_DATASYNC = 5;
    public static final int ACTIONLOGICTYPE_DSTDATAACTION = 6;
    public static final int ACTIONLOGICTYPE_DSTDATAACTION2 = 7;
    public static final int ACTIONLOGICTYPE_SYSLOGIC = 8;
    public static final int ACTIONLOGICTYPE_SYSTRANSLATOR = 9;
    public static final int ACTIONLOGICTYPE_SYSSEQUENCE = 10;
    public static final int ACTIONLOGICTYPE_DSTDELOGIC = 11;
    public static final int ACTIONLOGICTYPE_CHECKDEFVALUERULE = 50;
    public static final int ACTIONLOGICTYPE_CHECKMAINSTATE = 51;
    public static final int ACTIONLOGICTYPE_CHECKNOTMAINSTATE = 52;
    public static final int ACTIONLOGICTYPE_CHECKDSTDATAEXISTS = 53;
    public static final int ACTIONLOGICTYPE_CHECKDSTDATANOTEXISTS = 54;
    public static final int ACTIONLOGICTYPE_CHECKDSTDATAEXISTS2 = 55;
    public static final int ACTIONLOGICTYPE_CHECKDSTDATANOTEXISTS2 = 56;

    public void init(ISRFDAGlobalHelper var1, IPSDEAction var2, PSDEActionLogic var3) throws Exception;

    public IPSDEAction getPSDEAction();

    public String getAttachMode();

    public String getPSDELogicId();

    public String getPSDELogicName();

    public IPSDELogic getPSDELogic() throws Exception;

    public boolean isInternalLogic();

    public int getActionLogicType();

    public IPSDataEntity getDstPSDE() throws Exception;

    public IPSDEAction getDstPSDEAction() throws Exception;

    public IPSDELogic getDstPSDELogic() throws Exception;

    public boolean isValid();

    public boolean isCloneParam();

    public boolean isIgnoreException();

    public String getScriptCode();

    public boolean isPrepareLast();

    public int getPrepareLastMode();

    public IPSDENotify getPSDENotify() throws Exception;

    public int getLogicHolder();

    public boolean isEnableBackend();

    public boolean isEnableFront();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSXCodeObject getRender();

    public IPSDEMainState getPSDEMainState() throws Exception;

    public IPSDEField getPSDEField() throws Exception;

    public IPSDEFValueRule getPSDEFValueRule() throws Exception;

    public IPSDEDataSync getPSDEDataSync() throws Exception;

    public int getDataSyncEvent();

    public IPSDEDataSet getDstPSDEDataSet() throws Exception;

    public IPSDERBase getMajorPSDER() throws Exception;

    public IPSSysLogic getPSSysLogic() throws Exception;

    public IPSSysSequence getPSSysSequence() throws Exception;

    public IPSSysTranslator getPSSysTranslator() throws Exception;

    public int getErrorCode();

    public String getExceptionObj();

    public String getErrorInfo();

    public IPSLanguageRes getErrorInfoPSLanguageRes() throws Exception;

    public Properties getLogicParams();
}

