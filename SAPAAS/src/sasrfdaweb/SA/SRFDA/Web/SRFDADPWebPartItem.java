/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.WebEx.DP.IDPUserItem
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.DP.UI.DPRawItemConfig
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExSpan
 */
package SA.SRFDA.Web;

import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.WebEx.DP.IDPUserItem;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.DP.UI.DPRawItemConfig;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExSpan;
import java.util.Properties;

public class SRFDADPWebPartItem
implements IDPUserItem {
    public SRFExControl CreateControl(SRFExDPEx dpEx, DPRawItemConfig dpRawItemConfig) {
        try {
            SRFExSpan span = new SRFExSpan();
            span.InitConfig();
            span.setID(dpRawItemConfig.getID());
            Properties properties = PropertiesHelper.Load((String)dpRawItemConfig.getContent());
            span.getSpanConfig().setText(dpRawItemConfig.GetExtValue("TEXT", "\u7f51\u9875\u90e8\u4ef6"));
            span.getSpanConfig().setContainer(true);
            span.getSpanConfig().setBorder(true);
            String strWidth = PropertiesHelper.GetProperty((Properties)properties, (String)"WIDTH", (String)"1");
            span.getSpanConfig().setWidthEx(Double.parseDouble(strWidth));
            String strHeight = PropertiesHelper.GetProperty((Properties)properties, (String)"HEIGHT", (String)"300");
            span.getSpanConfig().setHeightEx(Double.parseDouble(strHeight));
            return span;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

