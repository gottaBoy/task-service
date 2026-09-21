/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysTranslator;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u503c\u8f6c\u6362\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysTranslator")
public interface IPSSysTranslator
extends IPSSystemObject,
IPSSysSFPubObject {
    public static final String TRANSLATORTYPE_DESTORAGE = "DESTORAGE";
    public static final String TRANSLATORTYPE_CODELIST = "CODELIST";
    public static final String TRANSLATORTYPE_USER = "USER";
    public static final String TRANSLATORTYPE_USER2 = "USER2";
    public static final String TRANSLATORTYPE_USER3 = "USER3";
    public static final String TRANSLATORTYPE_USER4 = "USER4";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysTranslator var3) throws Exception;

    public String getTranslatorType();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public IPSDataEntity getPSDataEntity();

    public IPSXCodeObject getRender();

    public String getTranslatorTag();

    public String getTranslatorTag2();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSDEField getKeyPSDEField();

    public IPSDEField getValuePSDEField();

    public IPSDEField getUserPSDEField();

    public IPSDEField getUser2PSDEField();

    public IPSCodeList getPSCodeList() throws Exception;

    public Properties getTranslatorParams();
}

