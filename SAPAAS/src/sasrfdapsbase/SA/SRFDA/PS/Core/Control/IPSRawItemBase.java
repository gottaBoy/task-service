/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.IPSRawItemContainer;
import SA.SRFDA.PS.Core.Control.IPSRawItemParam;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u754c\u9762\u90e8\u4ef6\u76f4\u63a5\u5185\u5bb9\u6210\u5458\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", typefield="contentType", implement="PSRawItemImpl")
public interface IPSRawItemBase
extends IPSModelObject {
    public static final String RAWITEMTYPE_RAW = "RAW";
    public static final String RAWITEMTYPE_HTML = "HTML";
    public static final String RAWITEMTYPE_IMAGE = "IMAGE";
    public static final String RAWITEMTYPE_ICON = "ICON";
    public static final String RAWITEMTYPE_MARKDOWN = "MARKDOWN";
    public static final String RAWITEMTYPE_PLACEHOLDER = "PLACEHOLDER";
    public static final String RAWITEMTYPE_VIDEO = "VIDEO";

    public void init(ISRFDAGlobalHelper var1, IPSRawItemContainer var2, String var3) throws Exception;

    public String getContentType();

    public IPSRawItemContainer getPSRawItemContainer();

    public String getPredefinedType();

    public Iterator<? extends IPSRawItemParam> getPSRawItemParams();

    public IPSSysCss getPSSysCss();

    public String getCssStyle();

    public String getDynaClass();

    public double getRawItemHeight();

    public double getRawItemWidth();

    public boolean isTemplateMode();

    public Iterator<? extends IPSControlLogic> getPSControlLogics();

    public Iterator<? extends IPSControlAttribute> getPSControlAttributes();

    public Iterator<? extends IPSControlRender> getPSControlRenders();

    public IPSLanguageRes getTooltipPSLanguageRes();

    public String getTooltip();
}

