/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSSysContentCat;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysContent;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u9884\u7f6e\u5185\u5bb9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysContent")
public interface IPSSysContent
extends IPSSystemObject,
IPSSysSFPubObject {
    public static final String CONTENTTYPE_RAW = "RAW";
    public static final String CONTENTTYPE_HTML = "HTML";

    public void init(ISRFDAGlobalHelper var1, IPSSysContentCat var2, PSSysContent var3) throws Exception;

    public IPSSysContentCat getPSSysContentCat();

    public String getContentType();

    @Override
    public String getCodeName();

    public String getContent();

    public String getContentTag();

    public String getContentTag2();

    public String getContentTag3();

    public String getContentTag4();

    public IPSSystemModule getPSSystemModule();

    public String getContentPath();

    public String getSubject();
}

