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
import SA.SRFramework.WebEx.UI.FileUploaderConfig;
import SA.SRFramework.WebEx.Utility.ContextHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.XMLNode;
import java.io.Writer;

public class SRFExFileUploader
extends SRFExHidden {
    public static final String LANRESID_UPLOADTEXT = "CONTROL.UPLOADER.UPLOAD.TEXT";
    public static final String LANRESID_REMOVETEXT = "CONTROL.UPLOADER.REMOVE.TEXT";
    public static final String LANRESID_UPLOADTIPS = "CONTROL.UPLOADER.UPLOAD.TIPS";
    public static final String LANRESID_REMOVETIPS = "CONTROL.UPLOADER.REMOVE.TIPS";
    protected FileUploaderConfig fileUploaderConfig = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new FileUploaderConfig();
    }

    public FileUploaderConfig getFileUploaderConfig() {
        return this.fileUploaderConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.fileUploaderConfig = null;
        if (this.config != null && this.config instanceof FileUploaderConfig) {
            this.fileUploaderConfig = (FileUploaderConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            super.OnRender(writer);
            String strUploadText = this.getWebContext().GetLocalization(this.getFileUploaderConfig().getUploadTextResId(), LANRESID_UPLOADTEXT, this.getFileUploaderConfig().getUploadText());
            String strUploadTips = this.getWebContext().GetLocalization(this.getFileUploaderConfig().getUploadTipResId(), LANRESID_UPLOADTIPS, this.getFileUploaderConfig().getUploadTipMessage());
            String strRemoveText = this.getWebContext().GetLocalization(this.getFileUploaderConfig().getRemoveTextResId(), LANRESID_REMOVETEXT, this.getFileUploaderConfig().getRemoveText());
            String strRemoveTips = this.getWebContext().GetLocalization(this.getFileUploaderConfig().getRemoveTipResId(), LANRESID_REMOVETIPS, this.getFileUploaderConfig().getRemoveTipMessage());
            String strCallScript = StringHelper.Format((String)"$P.object['%1$s'].upload();", (Object)this.getUniqueID());
            if (this.getBaseControlConfig().getWidthEx() == 0.0) {
                writer.write("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            } else {
                writer.write(StringHelper.Format((String)"<table  border='0' cellspacing='0' cellpadding='0' style='width:%1$s'>", (Object)this.getBaseControlConfig().getWidthString()));
            }
            writer.write(StringHelper.Format((String)"<tr><td id='%1$s_FILELIST'>", (Object)this.getUniqueID()));
            writer.write("&nbsp;</td>");
            writer.write("<td width='20' valign='top' style=\"padding-top:4px;\">");
            writer.write(String.format("<A onclick=\"javascript:%1$s\" href='#'><IMG id='IMG_%3$s' src=\"%2$s\"  border=\"0\" title=\"%4$s\" ></A>", strCallScript, this.getFileUploaderConfig().getUploadImage(), this.getUniqueID(), strUploadTips));
            writer.write("</td>");
            writer.write("</tr></table>");
            StringBuilderEx script = new StringBuilderEx();
            script.Append("\r\n");
            script.Append("$P.object['%1$s']=new SRFFileUploader({id:'%1$s',filelistid:'%1$s_FILELIST',uploadpage:'%2$s',downloadpage:'%3$s',maxcount:%4$s});\r\n", this.getUniqueID(), this.GetUploadPagePath(), this.GetDownloadPagePath(), this.fileUploaderConfig.getMaxCount());
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
        script.Append("Ext.getDom('IMG_%1$s').src=_V?'%2$s':'%3$s';", this.getUniqueID(), this.getFileUploaderConfig().getUploadImage(), this.getFileUploaderConfig().getDisableUploadImage());
        return script.toString();
    }

    protected String GetUploadPagePath() {
        String strUploadFilePath = this.fileUploaderConfig.getUploadPagePath();
        if (StringHelper.IsNullOrEmpty((String)strUploadFilePath)) {
            strUploadFilePath = this.getPage().getWebContext().getWebExConfig().GetValue("SRFEXWEB", "UPLOADPAGEPATH", "");
        }
        if (!StringHelper.IsNullOrEmpty((String)this.fileUploaderConfig.getFolder())) {
            strUploadFilePath = URLHelper.AppendURLSeperator(strUploadFilePath);
            strUploadFilePath = String.valueOf(strUploadFilePath) + StringHelper.Format((String)"FOLDER=%1$s", (Object)this.fileUploaderConfig.getFolder());
        }
        return strUploadFilePath;
    }

    protected String GetDownloadPagePath() {
        String strDownloadFilePath = this.fileUploaderConfig.getDownloadPagePath();
        if (StringHelper.IsNullOrEmpty((String)strDownloadFilePath)) {
            strDownloadFilePath = this.getPage().getWebContext().getWebExConfig().GetValue("SRFEXWEB", "DOWNLOADPAGEPATH", "");
        }
        return strDownloadFilePath;
    }

    public static String RenderFileList(String strXML, ContextHelper contextHelper, String strDownloadFilePath) {
        XMLNode xmlNode;
        block10: {
            block9: {
                block8: {
                    if (StringHelper.IsNullOrEmpty((String)strXML)) {
                        return "";
                    }
                    if (StringHelper.IsNullOrEmpty((String)strDownloadFilePath)) {
                        strDownloadFilePath = contextHelper.getWebExConfig().GetValue("SRFEXWEB", "DOWNLOADPAGEPATH", "");
                    }
                    strDownloadFilePath = URLHelper.AppendURLSeperator(strDownloadFilePath);
                    xmlNode = new XMLNode();
                    XMLConfig.LoadFromXML((String)strXML, (XMLConfig)xmlNode);
                    if (xmlNode != null) break block8;
                    return "";
                }
                if (xmlNode.getChildNodes() != null) break block9;
                return "";
            }
            if (xmlNode.getChildNodes().size() != 0) break block10;
            return "";
        }
        try {
            StringBuilderEx html = new StringBuilderEx();
            html.Append("<table width='100%' border='0' cellspacing='2' cellpadding='2'>");
            int nCount = xmlNode.getChildNodes().size();
            int i = 0;
            while (i < nCount) {
                XMLNode itemNode = xmlNode.getChildNodes().get(i);
                html.Append("<tr><td>");
                html.Append("<a href='#' onclick=\"javascript:SRFUtility.download('%1$sFILEID=%2$s');\"><span class='sx-normaltext'>%3$s</span></a>", strDownloadFilePath, itemNode.GetExtValue("FILEID", ""), itemNode.GetExtValue("FILENAME", ""));
                html.Append("</td></tr>");
                ++i;
            }
            html.Append("</table>");
            return html.toString();
        }
        catch (Exception exception) {
            return "";
        }
    }
}

