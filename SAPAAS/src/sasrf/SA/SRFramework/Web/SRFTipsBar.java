/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.TipsBarBuilder;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.UI.TipsConfig;
import SA.SRFramework.Web.UI.TipsItemConfig;
import javax.servlet.jsp.JspWriter;

public class SRFTipsBar
extends SRFWebControl {
    private String m_strMessageId = "";
    private String m_strMessage = "";
    private TipsBarBuilder tipsBarBuilder = null;

    public void setMessage(String value) {
        this.m_strMessage = value;
    }

    public void setMessageId(String value) {
        this.m_strMessageId = value;
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        this.tipsBarBuilder = this.GetTipsBarBuilder();
    }

    @Override
    protected void OnRender(JspWriter output) {
        if (this.tipsBarBuilder == null) {
            return;
        }
        try {
            output.println("<!-- TipsBar:Start -->");
            this.tipsBarBuilder.setControlId(this.getUniqueID());
            this.tipsBarBuilder.setCurWebContext(this.getWebContext());
            this.tipsBarBuilder.setMessage(this.GetMessage());
            this.tipsBarBuilder.Render(output);
            output.println("<!-- TipsBar:End -->");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    protected String GetMessage() {
        TipsConfig tipsConfig;
        if (StringHelper.Length(this.m_strMessage) != 0) {
            return this.m_strMessage;
        }
        if (StringHelper.Length(this.m_strMessageId) == 0) {
            this.m_strMessageId = this.getID();
        }
        if ((tipsConfig = this.getWebContext().getTips().Get(this.getWebContext().getCurLanguage())) == null) {
            return "&nbsp;";
        }
        TipsItemConfig tipsItemConfig = tipsConfig.Find(this.m_strMessageId);
        if (tipsItemConfig == null) {
            return "&nbsp;";
        }
        return tipsItemConfig.getMessage();
    }

    protected TipsBarBuilder GetTipsBarBuilder() {
        return this.getWebContext().getCurThemeConfig().GetTipsBarBuilder();
    }
}

