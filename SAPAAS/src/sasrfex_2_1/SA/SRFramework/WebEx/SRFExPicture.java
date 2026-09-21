/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExHidden;
import SA.SRFramework.WebEx.UI.PictureConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.io.Writer;

public class SRFExPicture
extends SRFExHidden {
    protected PictureConfig pictureConfig = null;
    public static final String LANRESID_UPLOADTEXT = "CONTROL.PICTURE.UPLOAD.TEXT";
    public static final String LANRESID_REMOVETEXT = "CONTROL.PICTURE.REMOVE.TEXT";
    public static final String LANRESID_UPLOADTIPS = "CONTROL.PICTURE.UPLOAD.TIPS";
    public static final String LANRESID_REMOVETIPS = "CONTROL.PICTURE.REMOVE.TIPS";

    @Override
    protected XMLConfig CreateConfig() {
        return new PictureConfig();
    }

    public PictureConfig getPictureConfig() {
        return this.pictureConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.pictureConfig = null;
        if (this.config != null && this.config instanceof PictureConfig) {
            this.pictureConfig = (PictureConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            super.OnRender(writer);
            if (this.getBaseControlConfig().getWidthEx() == 0.0) {
                writer.write("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            } else {
                writer.write(StringHelper.Format((String)"<table border='0' cellspacing='0' cellpadding='0' style='width:%1$s'>", (Object)this.getBaseControlConfig().getWidthString()));
            }
            writer.write("<tr><td >");
            String strUploadText = this.getWebContext().GetLocalization(this.getPictureConfig().getUploadTextResId(), LANRESID_UPLOADTEXT, this.getPictureConfig().getUploadText());
            String strUploadTips = this.getWebContext().GetLocalization(this.getPictureConfig().getUploadTipResId(), LANRESID_UPLOADTIPS, this.getPictureConfig().getUploadTipMessage());
            String strRemoveText = this.getWebContext().GetLocalization(this.getPictureConfig().getRemoveTextResId(), LANRESID_REMOVETEXT, this.getPictureConfig().getRemoveText());
            String strRemoveTips = this.getWebContext().GetLocalization(this.getPictureConfig().getRemoveTipResId(), LANRESID_REMOVETIPS, this.getPictureConfig().getRemoveTipMessage());
            writer.write(String.format("<A onclick=\"javascript:%1$s\" href='#'><IMG id='IMG_%3$s' src=\"%2$s\" border=\"0\" title=\"%4$s\" align='absmiddle' ><SPAN class='sx-normaltext'>%5$s</SPAN></A>", StringHelper.Format((String)"$P.object['%1$s'].upload();", (Object)this.getUniqueID()), this.getPictureConfig().getUploadImage(), this.getUniqueID(), strUploadTips, strUploadText));
            writer.write("&nbsp;");
            writer.write(String.format("<A onclick=\"javascript:%1$s\" href='#'><IMG id='IMG2_%3$s' src=\"%2$s\" border=\"0\" title=\"%4$s\" align='absmiddle'><SPAN class='sx-normaltext'>%5$s</SPAN></A>", StringHelper.Format((String)"$P.object['%1$s'].remove();", (Object)this.getUniqueID()), this.getPictureConfig().getRemoveImage(), this.getUniqueID(), strRemoveTips, strRemoveText));
            writer.write("</td></tr>");
            writer.write(StringHelper.Format((String)"<tr><td style=\"padding-top:2px;\">"));
            writer.write(StringHelper.Format((String)"<A id='%1$s_PIC_A' href='#' ><IMG id='%1$s_PIC' border='0' ", (Object)this.getUniqueID()));
            if (this.pictureConfig.getPictureWidth() > 0) {
                writer.write(StringHelper.Format((String)" width='%1$s' ", (Object)this.pictureConfig.getPictureWidth()));
            }
            if (this.pictureConfig.getPictureHeight() > 0) {
                writer.write(StringHelper.Format((String)" height='%1$s' ", (Object)this.pictureConfig.getPictureHeight()));
            }
            writer.write(StringHelper.Format((String)"></A>"));
            writer.write("</td></tr>");
            writer.write("</table>");
            StringBuilderEx script = new StringBuilderEx();
            script.Append("\r\n");
            script.Append("$P.object['%1$s'] = new SRFPicture({id:'%1$s',pictureid:'%1$s_PIC',uploadpage:'%2$s',downloadpage:'%3$s'});\r\n", this.getUniqueID(), this.GetUploadPagePath(), this.GetDownloadPagePath());
            this.getPage().RegisterScript(3, script.toString());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            StringBuilderEx script = new StringBuilderEx();
            script.Append("_V =$P.object['%1$s'].getvalue();\r\n", this.getUniqueID());
            script.Append("$FSV(_ID,_V);\r\n");
            return script.toString();
        }
        return StringHelper.Format((String)"if(_V==$FGV(_ID))break;$FSV(_ID,_V);$P.object['%1$s'].setvalue(_V);", (Object)this.getUniqueID());
    }

    @Override
    public String getItemEnableStateJSCall() {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("$P.object['%1$s'].setenable(_V);", this.getUniqueID());
        script.Append("Ext.getDom('IMG_%1$s').src = _V?'%2$s':'%3$s';", this.getUniqueID(), this.getPictureConfig().getUploadImage(), this.getPictureConfig().getDisableUploadImage());
        script.Append("Ext.getDom('IMG2_%1$s').src = _V?'%2$s':'%3$s';", this.getUniqueID(), this.getPictureConfig().getRemoveImage(), this.getPictureConfig().getDisableRemoveImage());
        return script.toString();
    }

    protected String GetUploadPagePath() {
        String strUploadFilePath = this.pictureConfig.getUploadPagePath();
        if (StringHelper.IsNullOrEmpty((String)strUploadFilePath)) {
            strUploadFilePath = this.getPage().getWebContext().getWebExConfig().GetValue("SRFEXWEB", "UPLOADPICPAGEPATH", "");
        }
        if (!StringHelper.IsNullOrEmpty((String)this.pictureConfig.getFolder())) {
            strUploadFilePath = URLHelper.AppendURLSeperator(strUploadFilePath);
            strUploadFilePath = String.valueOf(strUploadFilePath) + StringHelper.Format((String)"FOLDER=%1$s", (Object)this.pictureConfig.getFolder());
        }
        return strUploadFilePath;
    }

    protected String GetDownloadPagePath() {
        String strDownloadFilePath = this.pictureConfig.getDownloadPagePath();
        if (StringHelper.IsNullOrEmpty((String)strDownloadFilePath)) {
            strDownloadFilePath = this.getPage().getWebContext().getWebExConfig().GetValue("SRFEXWEB", "DOWNLOADPICPAGEPATH", "");
        }
        return strDownloadFilePath;
    }
}

