/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSSysContentCat;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysResource;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u8d44\u6e90\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysResource")
public interface IPSSysResource
extends IPSSystemObject,
IPSSysSFPubObject {
    public static final String RESOURCETYPE_IMAGE = "IMAGE";
    public static final String RESOURCETYPE_STRING = "STRING";
    public static final String RESOURCETYPE_ZIPFILE = "ZIPFILE";
    public static final String RESOURCETYPE_GITPROJECT = "GITPROJECT";
    public static final String RESOURCETYPE_SYSCONTENTCAT = "SYSCONTENTCAT";
    public static final String RESOURCETYPE_DEFILE = "DEFILE";
    public static final String RESOURCETYPE_OSSFILE = "OSSFILE";
    public static final String RESOURCETYPE_USER = "USER";
    public static final String RESOURCETYPE_USER2 = "USER2";
    public static final String RESOURCETYPE_USER3 = "USER3";
    public static final String RESOURCETYPE_USER4 = "USER4";
    public static final String RESOURCETYPE_USER5 = "USER5";
    public static final String RESOURCETYPE_USER6 = "USER6";
    public static final String RESOURCETYPE_USER7 = "USER7";
    public static final String RESOURCETYPE_USER8 = "USER8";
    public static final String RESOURCETYPE_USER9 = "USER9";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysResource var3) throws Exception;

    public String getResourceType();

    public String getResTag();

    public String getContent();

    public IPSSystemModule getPSSystemModule();

    public String getAuthMode();

    public String getAuthAccessTokenUrl();

    public String getAuthClientId();

    public String getAuthClientSecret();

    public String getAuthParam();

    public String getAuthParam2();

    public Properties getResourceParams();

    public String getResourceUri();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public IPSSysContentCat getPSSysContentCat();

    public IPSDataEntity getPSDataEntity();

    public IPSDEDataSet getPSDEDataSet();

    public IPSDEField getNamePSDEField();

    public IPSDEField getContentPSDEField();

    public IPSDEField getPathPSDEField();

    public IPSDEField getTagPSDEField();

    public IPSDEField getUserPSDEField();

    public IPSDEField getUser2PSDEField();
}

