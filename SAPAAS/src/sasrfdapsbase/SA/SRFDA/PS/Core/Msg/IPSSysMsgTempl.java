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
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysMsgTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u6d88\u606f\u6a21\u677f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysMsgTempl")
public interface IPSSysMsgTempl
extends IPSSystemObject,
IPSSysSFPubObject {
    public static final String CONTENTTYPE_TEXT = "TEXT";
    public static final String CONTENTTYPE_HTML = "HTML";
    public static final String MSGTEMPLTYPE_STATIC = "STATIC";
    public static final String MSGTEMPLTYPE_RUNTIME = "RUNTIME";
    public static final String MSGTEMPLTYPE_DE = "DE";
    public static final String MSGTEMPLTYPE_USER = "USER";
    public static final String MSGTEMPLTYPE_USER2 = "USER2";
    public static final String MSGTEMPLENGINE_FREEMARKER = "FREEMARKER";
    public static final String MSGTEMPLENGINE_GROOVY = "GROOVY";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysMsgTempl var3) throws Exception;

    public String getContent();

    public String getContentType();

    public String getIMContent();

    public boolean isMailGroupSend();

    public String getSMSContent();

    public String getSubject();

    @Deprecated
    public String getWCContent();

    public String getWXContent();

    public IPSLanguageRes getContentPSLanguageRes();

    public IPSLanguageRes getIMPSLanguageRes();

    public IPSLanguageRes getSMSPSLanguageRes();

    public IPSLanguageRes getSubPSLanguageRes();

    public IPSLanguageRes getWXPSLanguageRes();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public String getDDContent();

    public IPSLanguageRes getDDPSLanguageRes();

    public String getTaskUrl();

    public String getMobTaskUrl();

    public int getScriptMode();

    public String getScriptCode();

    public String getMsgTemplType();

    public String getTemplEngine();

    public String getMsgTemplTag();

    public String getMsgTemplTag2();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSXCodeObject getRender();

    public Properties getMsgTemplParams();

    public IPSDataEntity getPSDataEntity();

    public IPSDEDataSet getPSDEDataSet();

    public IPSDEField getTemplTagPSDEField();

    public IPSDEField getUserPSDEField();

    public IPSDEField getUser2PSDEField();

    public IPSDEField getSubjectPSDEField();

    public IPSDEField getContentPSDEField();

    public IPSDEField getContentTypePSDEField();

    public IPSDEField getTaskUrlPSDEField();

    public IPSDEField getMobTaskUrlPSDEField();

    public IPSDEField getLanPSDEField();

    public IPSDEField getSMSContentPSDEField();

    public IPSDEField getIMContentPSDEField();

    public IPSDEField getWXContentPSDEField();

    public IPSDEField getDDContentPSDEField();
}

