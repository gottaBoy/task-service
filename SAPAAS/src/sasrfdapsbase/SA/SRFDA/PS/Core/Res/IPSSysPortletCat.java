/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysPortletCat;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u5206\u7c7b\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysPortletCat")
public interface IPSSysPortletCat
extends IPSModelObject,
IPSSystemObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysPortletCat var3) throws Exception;

    @Override
    public String getCodeName();

    public IPSLanguageRes getNamePSLanguageRes();

    public IPSSystemModule getPSSystemModule();

    public IPSSysImage getPSSysImage();

    public IPSSysCss getPSSysCss();

    public String getUniqueTag();
}

