/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Report.Web;

import SA.SRFramework.Report.UI.ChartConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.IWebCtrl;
import SA.SRFramework.Web.SRFImage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

public class SRFChartImage
extends SRFImage
implements IWebCtrl {
    private static String CHARTRENDER = "CHARTRENDER";
    private ChartConfig curChartConfig = null;
    private String strImageId = "";
    private String strImagePathWithOutSessionKey = "";

    @Override
    protected void OnRender(JspWriter output) {
        try {
            String sessionId = this.getWebContext().getPageContext().getSession().getId();
            if (this.curChartConfig != null || StringHelper.Length(this.strImageId) != 0) {
                String strRenderPath = this.getWebContext().getWebConfig().GetExtValue(CHARTRENDER, "/sachartrender");
                strRenderPath = SRFChartImage.fixAbsolutURL(strRenderPath, this.getWebContext().getPage().getRequest());
                String strImageKey = "";
                strImageKey = this.curChartConfig != null ? this.getWebContext().getUserCharts().RegisterChart(this.curChartConfig) : this.strImageId;
                strRenderPath = String.valueOf(strRenderPath) + "?IMG_ID=" + strImageKey;
                strRenderPath = String.valueOf(strRenderPath) + "&HEIGHT=" + this.getHeight();
                this.strImagePathWithOutSessionKey = strRenderPath = String.valueOf(strRenderPath) + "&WIDTH=" + this.getWidth();
                this.setImageUrl(strRenderPath);
            } else {
                this.setImageUrl(this.strImagePathWithOutSessionKey.replace("SASRFSESSIONID", sessionId));
            }
            super.OnRender(output);
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return;
        }
    }

    private static String fixAbsolutURL(String url, HttpServletRequest request) {
        if (url.startsWith("/")) {
            String context = request.getContextPath();
            url = String.valueOf(context) + url;
        }
        return url;
    }

    public void setChartConfig(ChartConfig value) {
        this.curChartConfig = value;
    }

    public void setImageId(String value) {
        this.strImageId = value;
    }

    @Override
    public void SetStrValue(String strValue) {
        this.setImageUrl(strValue);
    }

    @Override
    public String GetCtrlValue() {
        return this.getImageUrl();
    }

    @Override
    public boolean DoCommand(String strCmdId, Object cmdArg1, Object cmdArg2) {
        return false;
    }

    @Override
    protected boolean OnReadFromViewStates() {
        String strKey = String.valueOf(this.getUniqueID()) + "_CHARTIMG";
        Object objValue = this.getPage().getViewStates().Get(strKey);
        if (objValue != null) {
            this.strImagePathWithOutSessionKey = (String)objValue;
        }
        return false;
    }

    @Override
    protected boolean OnWriteToViewStates() {
        if (StringHelper.StringLength(this.strImagePathWithOutSessionKey) != 0) {
            String strKey = String.valueOf(this.getUniqueID()) + "_CHARTIMG";
            this.getPage().getViewStates().Set(strKey, this.strImagePathWithOutSessionKey);
        }
        return false;
    }
}

