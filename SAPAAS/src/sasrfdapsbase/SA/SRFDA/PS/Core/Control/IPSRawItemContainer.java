/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSRawItemBase;
import SA.SRFDA.PS.Core.Control.IPSRawItemParam;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import java.util.Iterator;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u76f4\u63a5\u5185\u5bb9\u9879\u5bb9\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSRawItemContainer
extends IPSModelObject {
    public String getCaption();

    public String getContentType();

    public String getRawItemStyle();

    public double getRawItemWidth();

    public double getRawItemHeight();

    public String getRawItemCssStyle();

    public String getRawItemDynaClass();

    public Properties getRawItemParams();

    public int getRawItemParam(String var1, int var2);

    public String getRawItemParam(String var1, String var2);

    public double getRawItemParam(String var1, double var2);

    public boolean getRawItemParam(String var1, boolean var2);

    public IPSRawItemBase getPSRawItem() throws Exception;

    public String getRawItemName();

    public String getPredefinedType();

    public IPSSysCss getPSSysCss();

    public IPSSysImage getPSSysImage();

    public IPSSysResource getPSSysResource();

    public String getContent();

    public String getRenderMode();

    public Iterator<? extends IPSRawItemParam> getPSRawItemParams();

    public boolean isTemplateMode();

    public IPSLanguageRes getTooltipPSLanguageRes();

    public String getTooltip();
}

