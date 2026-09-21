/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExIFrame
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.Default.IfGridViewPage2;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExIFrame;
import SA.SRFramework.WebEx.Utility.URLHelper;

public class NavFrameIFPage
extends IfGridViewPage2 {
    @Override
    protected void CreateIFrame() {
        if (this.iFrame != null) {
            return;
        }
        this.iFrame = new SRFExIFrame();
        this.iFrame.InitConfig();
        this.iFrame.setID("iframe");
        this.iFrame.getIFrameConfig().setWidth(0);
        this.iFrame.getIFrameConfig().setHeight(0);
        this.iFrame.getIFrameConfig().setScroll("no");
        String strWithOutParam = "TABVIEWPAGEID";
        strWithOutParam = String.valueOf(strWithOutParam) + "|";
        strWithOutParam = String.valueOf(strWithOutParam) + "TABVIEWID";
        strWithOutParam = String.valueOf(strWithOutParam) + "|";
        strWithOutParam = String.valueOf(strWithOutParam) + "REALID";
        String strPath = this.getWebContext().GetParamValue("REALURL");
        if (StringHelper.IsNullOrEmpty((String)strPath)) {
            strPath = this.GetRealGridViewPath();
        }
        strPath = URLHelper.AppendURLSeperator((String)strPath);
        strPath = String.valueOf(strPath) + "SRFIFVIEW=TRUE&";
        strPath = String.valueOf(strPath) + this.getWebContext().GetQueryStringWithout(strWithOutParam);
        strPath = URLHelper.AppendURLSeperator((String)strPath);
        this.strIframeURL = strPath = String.valueOf(strPath) + "SRFIFVIEW=TRUE&";
        this.iFrame.getIFrameConfig().setURL(this.strIframeURL);
        this.AddControl((SRFExControl)this.iFrame);
    }
}

