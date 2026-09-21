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
import SA.SRFramework.WebEx.UI.WordEditorConfig;
import java.io.Writer;

public class SRFExWordEditor
extends SRFExHidden {
    protected WordEditorConfig wordEditorConfig = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new WordEditorConfig();
    }

    public WordEditorConfig getWordEditorConfig() {
        return this.wordEditorConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.wordEditorConfig = null;
        if (this.config != null && this.config instanceof WordEditorConfig) {
            this.wordEditorConfig = (WordEditorConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            super.OnRender(writer);
            StringBuilderEx script = new StringBuilderEx();
            if (this.getBaseControlConfig().getWidthEx() == 0.0) {
                script.Append("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            } else {
                script.Append("<table  border='0' cellspacing='0' cellpadding='0' style='width:%1$s'>", this.getBaseControlConfig().getWidthString());
            }
            script.Append("<tr><td height='20'>");
            script.Append("<select id=\"TEMPL_%1$s\" >", this.getUniqueID());
            script.Append("<option value=\"1\">\u53d1\u6587\u5957\u7ea2</option>");
            script.Append("<option value=\"2\">\u516c\u6587\u5957\u7ea2</option>");
            script.Append("<option value=\"3\">\u516c\u6587\u5957\u7ea22</option>");
            script.Append("<option value=\"4\">\u6536\u6587\u5957\u7ea2</option>");
            script.Append("</select>");
            script.Append("<INPUT type=\"button\" id=\"%1$s_addtempl\" value=\"\u589e\u52a0\u6a21\u677f\" onclick=\"$P.object['%1$s'].addtempl()\">", this.getUniqueID());
            script.Append("<select id=\"SEC_%1$s\" >", this.getUniqueID());
            script.Append("<option value=\"1\">\u793a\u4f8b\u7ae0</option>");
            script.Append("</select>");
            script.Append("<INPUT type=\"button\" id=\"%1$s_addsecsign\" value=\"\u589e\u52a0\u7b7e\u7ae0\" onclick=\"$P.object['%1$s'].addsecsign()\">", this.getUniqueID());
            script.Append("</td></tr>");
            script.Append("<tr><td>");
            script.Append("<FORM ID=\"form_%1$s\" METHOD=\"post\" ACTION=\"../srfpage/uploadfile2.jsp\" ENCTYPE=\"multipart/form-data\" >", this.getUniqueID());
            script.Append("<INPUT type='FILE' ID=\"FILE_%1$s\" NAME=\"FILE_%1$s\" style='display:none'>", this.getUniqueID());
            script.Append("</FORM>");
            script.Append("<OBJECT id=\"%1$s_OCX\" codeBase=\"../officeeditor/officecontrol.cab#version=4,0,1,2\" classid=clsid:A39F1330-3322-4a1d-9BF0-0BA2BB90E970 width=\"%2$s\" height=\"%3$s\">", this.getUniqueID(), this.getWordEditorConfig().getWidthString(), this.getWordEditorConfig().getHeightString());
            script.Append("<PARAM NAME=\"_ExtentX\" VALUE=\"33946\">");
            script.Append("\t<PARAM NAME=\"_ExtentY\" VALUE=\"33073\">");
            script.Append("\t<PARAM NAME=\"BorderColor\" VALUE=\"14402205\">");
            script.Append("\t<PARAM NAME=\"BackColor\" VALUE=\"-2147483643\">");
            script.Append("\t<PARAM NAME=\"ForeColor\" VALUE=\"-2147483640\">");
            script.Append("\t<PARAM NAME=\"TitlebarColor\" VALUE=\"15658734\">");
            script.Append("\t<PARAM NAME=\"TitlebarTextColor\" VALUE=\"0\">");
            script.Append(" <PARAM NAME=\"BorderStyle\" VALUE=\"1\">");
            script.Append("\t<PARAM NAME=\"Titlebar\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"Toolbars\" VALUE=\"1\">");
            script.Append("\t<PARAM NAME=\"IsShowToolMenu\" VALUE=\"1\">");
            script.Append(" <PARAM NAME=\"IsNoCopy\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"IsHiddenOpenURL\" VALUE=\"0\">");
            script.Append(" <PARAM NAME=\"MaxUploadSize\" VALUE=\"10000000\">");
            script.Append(" <PARAM NAME=\"NetworkBufferSize\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"Menubar\" VALUE=\"1\">");
            script.Append("\t<PARAM NAME=\"Statusbar\" VALUE=\"1\">");
            script.Append(" <PARAM NAME=\"FileNew\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"FileOpen\" VALUE=\"-1\">");
            script.Append("\t<PARAM NAME=\"FileClose\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"FileSave\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"FileSaveAs\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"FilePrint\" VALUE=\"-1\">");
            script.Append("\t<PARAM NAME=\"FilePrintPreview\" VALUE=\"-1\">");
            script.Append("\t<PARAM NAME=\"FilePageSetup\" VALUE=\"-1\">");
            script.Append("\t<PARAM NAME=\"FileProperties\" VALUE=\"-1\">");
            script.Append("\t<PARAM NAME=\"IsStrictNoCopy\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"IsUseUTF8URL\" VALUE=\"1\">");
            script.Append("\t<PARAM NAME=\"MenubarColor\" VALUE=\"14402205\">");
            script.Append("\t<PARAM NAME=\"CustomMenuCaption\" VALUE=\"\u6211\u7684\u83dc\u5355\">");
            script.Append("\t<PARAM NAME=\"IsUseControlAgent\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"IsUseUTF8Data\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"IsSaveDocExtention\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"IsDirectConnect\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"SignCursorType\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"IsResetToolbarsOnOpen\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"IsSaveDataIfHasVDS\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"MenuButtonStyle\" VALUE=\"7\">");
            script.Append("\t<PARAM NAME=\"MenuButtonColor\" VALUE=\"16180947\">");
            script.Append(" <PARAM NAME=\"MenuButtonFrameColor\" VALUE=\"14924434\">");
            script.Append("\t<PARAM NAME=\"MenuBarStyle\" VALUE=\"3\">");
            script.Append("\t<PARAM NAME=\"IsGetPicOnlyOnHandSign\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"IsSecurityOptionsOpen\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"IsShowHelpMenu\" VALUE=\"1\">");
            script.Append("\t<PARAM NAME=\"IsShowInsertMenu\" VALUE=\"1\">");
            script.Append("\t<PARAM NAME=\"IsAutoDetectWebCharSet\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"WebCodePage\" VALUE=\"936\">");
            script.Append("\t<PARAM NAME=\"IsShowEditMenu\" VALUE=\"1\">");
            script.Append("\t<PARAM NAME=\"IsShowFileErrorMsg\" VALUE=\"1\">");
            script.Append("\t<PARAM NAME=\"IsShowNetErrorMsg\" VALUE=\"1\">");
            script.Append(" <PARAM NAME=\"ReceiveDataTimeOut\" VALUE=\"180\">");
            script.Append("\t<PARAM NAME=\"ConnectServerTimeOut\" VALUE=\"180\">");
            script.Append("\t<PARAM NAME=\"IsRemoveMacrosOnSave\" VALUE=\"1\">");
            script.Append(" <PARAM NAME=\"IsForceCheckSecSignCertCRLOnline\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"IsAutoLockOnSecSign\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"IsAllowAddSignOnLockedDoc\" VALUE=\"0\">");
            script.Append("\t<PARAM NAME=\"IsEnable2007ReviewCommand\" VALUE=\"1\">");
            script.Append("\t<PARAM NAME=\"DefaultOpenDocType\" VALUE=\"0\">");
            script.Append("</OBJECT>");
            script.Append("</td></tr>");
            script.Append("</table>");
            writer.write(script.toString());
            script.Reset();
            script.Append("$P.object['%1$s']={};\r\n", this.getUniqueID());
            script.Append("$P.object['%1$s'].load=function(_1){\r\n", this.getUniqueID());
            script.Append("try{var ocx=document.getElementById(\"%1$s_OCX\");\r\n", this.getUniqueID());
            script.Append("if(_1==''){ocx.BeginOpenFromURL('../officeeditor/init.doc',true,false);}\r\n");
            script.Append("else{ocx.BeginOpenFromURL('../srfpage/exportfile.jsp?FILEID='+_1,true,false);}\r\n");
            script.Append("}catch(e){};}\r\n");
            script.Append("$P.object['%1$s'].save=function(){\r\n", this.getUniqueID());
            script.Append("try{var ocx=document.getElementById(\"%1$s_OCX\");\r\n", this.getUniqueID());
            script.Append("var ret=ocx.SaveToURL('../srfpage/uploadfile2.jsp','FILE_%1$s','','word.doc','form_%1$s',true);\r\n", this.getUniqueID());
            script.Append("Ext.getDom('%1$s').value =ret;return ret;", this.getUniqueID());
            script.Append("}catch(e){};}\r\n");
            script.Append("$P.object['%1$s'].setreadonly=function(_1){\r\n", this.getUniqueID());
            script.Append("try{var ocx=document.getElementById(\"%1$s_OCX\");\r\n", this.getUniqueID());
            script.Append("ocx.SetReadOnly(!_1,'');\r\n");
            script.Append("Ext.getDom('%1$s_addtempl').disabled=!_1;\r\n", this.getUniqueID());
            script.Append("Ext.getDom('%1$s_addsecsign').disabled=!_1;\r\n", this.getUniqueID());
            script.Append("}catch(e){};}\r\n");
            script.Append("$P.object['%1$s'].addtempl=function(_1){\r\n", this.getUniqueID());
            script.Append("try{var ocx=document.getElementById(\"%1$s_OCX\");\r\n", this.getUniqueID());
            script.Append("var va=document.getElementById(\"TEMPL_%1$s\").value;\r\n", this.getUniqueID());
            script.Append("if(va=='')return;\r\n");
            script.Append("ocx.AddTemplateFromURL('../officeeditor/templ'+va+'.doc');\r\n");
            script.Append("}catch(e){};}\r\n");
            script.Append("$P.object['%1$s'].addsecsign=function(_1){\r\n", this.getUniqueID());
            script.Append("try{var ocx=document.getElementById(\"%1$s_OCX\");\r\n", this.getUniqueID());
            script.Append("var va=document.getElementById(\"SEC_%1$s\").value;\r\n", this.getUniqueID());
            script.Append("if(va=='')return;\r\n");
            script.Append("ocx.AddSecSignFromURL('%1$s','../officeeditor/secsign'+va+'.esp');\r\n", this.getWebContext().getCurUserName());
            script.Append("}catch(e){};}\r\n");
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
            script.Append("_V=$P.object['%1$s'].save();\r\n", this.getUniqueID());
            return script.toString();
        }
        return StringHelper.Format((String)"if(_V!=$FGV(_ID)||_V==''){$FSV(_ID,_V);$P.object['%1$s'].load(_V);}", (Object)this.getUniqueID());
    }

    @Override
    public String getItemEnableStateJSCall() {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("$P.object['%1$s'].setreadonly(_V);", this.getUniqueID());
        return script.toString();
    }
}

