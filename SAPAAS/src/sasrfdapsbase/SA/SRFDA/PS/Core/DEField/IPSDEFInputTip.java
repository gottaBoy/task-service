/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEFInputTip
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSDEFInputTipSet;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSDEFInputTip;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEFInputTip;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEFInputTip")
public interface IPSDEFInputTip
extends IPSDEFieldObject,
IDEFInputTip {
    public void init(ISRFDAGlobalHelper var1, IPSDEField var2, PSDEFInputTip var3) throws Exception;

    public boolean isDefault();

    public IPSLanguageRes getContentPSLanguageRes();

    public IPSDEFInputTipSet getPSDEFInputTipSet();

    public String getUniqueTag();

    @Override
    public String getCodeName();

    public String getTipMode();

    public String getRawContent();

    public String getHtmlContent();

    public String getContent();
}

