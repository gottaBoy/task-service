/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysResource;

@PSModelInterfaceMeta(title="\u76f4\u63a5\u5185\u5bb9\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3", description="\u8fd9\u4e2a\u662f\u65e9\u671f\u7684\u76f4\u63a5\u5185\u5bb9\u63a5\u53e3\uff0c\u53ea\u7ea6\u5b9a\u4e86\u76f4\u63a5\u5185\u5bb9\u7684\u76f8\u5173\u5c5e\u6027\uff0c\u5e76\u6ca1\u6709\u5f62\u6210\u5bf9\u8c61\uff08\u5982\u7f16\u8f91\u5668\uff09\u3002\u540e\u7eed\u4f7f\u7528\u76f4\u63a5\u5185\u5bb9\u7ec4\u4ef6\u63a5\u53e3{@link IPSRawItemBase}")
@PSModelRTIgnoreMeta
public interface IPSRawItem
extends IPSModelObject {
    public static final String CONTENTTYPE_RAW = "RAW";
    public static final String CONTENTTYPE_HTML = "HTML";
    public static final String CONTENTTYPE_IMAGE = "IMAGE";
    public static final String CONTENTTYPE_ICON = "ICON";
    public static final String CONTENTTYPE_MARKDOWN = "MARKDOWN";

    public String getContentType();

    public String getRawContent();

    public String getHtmlContent();

    public String getOriRawContent();

    public String getOriHtmlContent();

    public IPSSysImage getPSSysImage();

    public double getRawItemHeight();

    public double getRawItemWidth();

    public IPSSysResource getPSSysResource();
}

