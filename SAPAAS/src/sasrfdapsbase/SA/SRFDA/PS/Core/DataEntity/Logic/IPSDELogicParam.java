/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParamBase;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Data.PSDELogicParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDELogicParam")
public interface IPSDELogicParam
extends IPSDELogicParamBase {
    public static final String FILETYPE_TEMP = "TEMP";
    public static final String FILETYPE_URL = "URL";
    public static final String FILETYPE_STORAGESERVICE = "STORAGESERVICE";
    public static final int PARAMMODE_CHATCOMPLETIONREQUEST = 13;
    public static final int PARAMMODE_CHATCOMPLETIONRESULT = 14;

    public void init(ISRFDAGlobalHelper var1, IPSDELogic var2, PSDELogicParam var3) throws Exception;

    public IPSDELogic getPSDELogic();

    public IPSDataEntity getParamPSDataEntity() throws Exception;

    public boolean isSessionParam();

    public boolean isEnvParam();

    public boolean isLastParam();

    public String getParamTag();

    public String getParamTag2();

    public boolean isEntityParam();

    public boolean isFilterParam();

    public boolean isEntityListParam();

    public boolean isEntityMapParam();

    public boolean isLastReturnParam();

    public boolean isEntityPageParam();

    public boolean isFileParam();

    public boolean isFileListParam();

    public boolean isSimpleParam();

    public boolean isSimpleListParam();

    public boolean isChatCompletionRequestParam();

    public boolean isChatCompletionResultParam();

    public boolean isAppContextParam();

    public boolean isWebContextParam();

    public boolean isWebResponseParam();

    public boolean isAppGlobalParam();

    public int getStdDataType();

    public IPSSFXCodeObject getRender();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public String getDefaultValueType();

    public String getDefaultValue();

    public boolean isCloneParam();

    public boolean isOriginEntity();

    public String getFileType();

    public String getFileUrl();

    public Properties getParams();

    public IPSSysTranslator getPSSysTranslator();
}

