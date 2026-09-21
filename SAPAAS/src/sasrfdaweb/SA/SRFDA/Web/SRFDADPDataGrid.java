/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.WebUtility
 *  SA.SRFramework.WebEx.DP.UI.DPDataGridConfig
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExIFrame
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.WebUtility;
import SA.SRFramework.WebEx.DP.UI.DPDataGridConfig;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExIFrame;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.io.Writer;

public class SRFDADPDataGrid
extends SRFExControl {
    protected DPDataGridConfig dpDataGridConfig = null;
    protected SRFExIFrame iFrame = null;

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.dpDataGridConfig = null;
        if (this.config != null && this.config instanceof DPDataGridConfig) {
            this.dpDataGridConfig = (DPDataGridConfig)this.config;
        }
    }

    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        this.iFrame = null;
        if (this.dpDataGridConfig != null) {
            this.iFrame = new SRFExIFrame();
            this.iFrame.InitConfig();
            this.iFrame.setID("Iframe");
            if (this.getBaseControlConfig().getWidthEx() == 0.0) {
                this.iFrame.getIFrameConfig().setWidthEx(1.0);
            } else {
                this.iFrame.getIFrameConfig().setWidthEx(this.getBaseControlConfig().getWidthEx());
            }
            this.iFrame.getIFrameConfig().setHeightEx(this.getBaseControlConfig().getHeightEx());
            this.iFrame.getIFrameConfig().setFrameBorder(0);
            this.iFrame.getIFrameConfig().setScroll("no");
            String strGridViewUrl = this.dpDataGridConfig.getURL();
            String strDEMainState = this.getWebContext().GetParamValue("SRFDEMAINSTATE");
            if (!StringHelper.IsNullOrEmpty((String)strDEMainState)) {
                strGridViewUrl = String.valueOf(URLHelper.AppendURLSeperator((String)strGridViewUrl)) + StringHelper.Format((String)"%1$s=%2$s", (Object)"SRFPDEMAINSTATE", (Object)strDEMainState);
            }
            this.iFrame.getIFrameConfig().setURL(strGridViewUrl);
            this.AddControl((SRFExControl)this.iFrame);
        }
    }

    public DPDataGridConfig getDPDataGridConfig() {
        return this.dpDataGridConfig;
    }

    public void Render(Writer writer) {
        try {
            if (this.iFrame == null) {
                this.getPage().PageLog((Object)this, 1, "Iframe \u5bf9\u8c61\u65e0\u6548");
                return;
            }
            this.RenderChild(writer, "Iframe");
            StringBuilderEx script = new StringBuilderEx();
            if (this.getPage().getDefaultForm() == null) {
                return;
            }
            SRFExForm form = (SRFExForm)this.getPage().getDefaultForm();
            String strKeyFields = this.dpDataGridConfig.getKeyFields();
            String strRelatedFields = this.dpDataGridConfig.getRelatedFields();
            String strGetStatesScript = "var X={};";
            String strGetStatesCondition = "";
            if (!StringHelper.IsNullOrEmpty((String)strRelatedFields)) {
                String[] stateFields = strRelatedFields.split("[;]");
                int i = 0;
                while (i < stateFields.length) {
                    SRFExControl control;
                    if (!StringHelper.IsNullOrEmpty((String)stateFields[i]) && (control = form.FindControl(stateFields[i])) != null) {
                        if (!StringHelper.IsNullOrEmpty((String)strGetStatesCondition)) {
                            strGetStatesCondition = String.valueOf(strGetStatesCondition) + "||";
                        }
                        strGetStatesCondition = String.valueOf(strGetStatesCondition) + StringHelper.Format((String)"_I=='%1$s'", (Object)control.getUniqueID());
                        strGetStatesScript = String.valueOf(strGetStatesScript) + StringHelper.Format((String)"X.%1$s=_F.G('%2$s');", (Object)stateFields[i].toUpperCase(), (Object)control.getUniqueID());
                    }
                    ++i;
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)strKeyFields)) {
                String strCondition = "_I==''";
                String strGetKeysScript = "var Z={_UF:_F._UF};";
                String strTestKeysScript = "";
                String[] keyFields = strKeyFields.split("[;]");
                int i = 0;
                while (i < keyFields.length) {
                    SRFExControl control;
                    if (!StringHelper.IsNullOrEmpty((String)keyFields[i]) && (control = form.FindControl(keyFields[i])) != null) {
                        if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                            strCondition = String.valueOf(strCondition) + "||";
                        }
                        strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"_I=='%1$s'", (Object)control.getUniqueID());
                        strGetKeysScript = String.valueOf(strGetKeysScript) + StringHelper.Format((String)"Z.%1$s=_F.G('%2$s');", (Object)keyFields[i].toUpperCase(), (Object)control.getUniqueID());
                        if (!StringHelper.IsNullOrEmpty((String)strTestKeysScript)) {
                            strTestKeysScript = String.valueOf(strTestKeysScript) + "&&";
                        }
                        strTestKeysScript = String.valueOf(strTestKeysScript) + StringHelper.Format((String)"(_F.G('%1$s')=='')", (Object)control.getUniqueID());
                    }
                    ++i;
                }
                if (!StringHelper.IsNullOrEmpty((String)strGetKeysScript)) {
                    script.Append("var en=Ext.isIE?'readystatechange':'load';");
                    script.Append("Ext.get('%1$s').on(en,$P.object['%2$s'].delayload);", (Object)this.iFrame.getUniqueID(), (Object)this.getUniqueID());
                    this.getPage().RegisterOnReadyScript(2, script.toString());
                    script.Reset();
                }
                script.Append("$P.object['%1$s']={ifloaded:false};\r\n", (Object)this.getUniqueID());
                script.Append("$P.object['%1$s'].delayload=function(){window.setTimeout(\"$P.object['%1$s'].ifload()\",500);};\r\n", (Object)this.getUniqueID());
                script.Append("$P.object['%1$s'].ifload=function(_1){\r\n", (Object)this.getUniqueID());
                script.Append("var _F=%1$s;", (Object)form.getFormId());
                script.Append("%1$s", (Object)strGetKeysScript);
                if (!StringHelper.IsNullOrEmpty((String)strGetStatesScript)) {
                    script.Append("%1$s", (Object)strGetStatesScript);
                }
                script.Append("var A=Ext.getDom('%1$s');\r\n", (Object)this.iFrame.getUniqueID());
                script.Append("if(A==null)return;");
                script.Append("$P.object['%1$s'].ifloaded=true;\r\n", (Object)this.getUniqueID());
                script.Append("var _W=A.contentWindow;");
                if (!this.getDPDataGridConfig().getTempData()) {
                    String strSaveMajorTip = this.getDPDataGridConfig().getSaveMajorTip();
                    if (StringHelper.IsNullOrEmpty((String)strSaveMajorTip)) {
                        strSaveMajorTip = "\u8bf7\u5148\u4fdd\u5b58\u4e3b\u6570\u636e";
                    }
                    script.Append("if(!_F._UF){");
                    script.Append("if(_W.$P.maskhelper){_W.$P.maskhelper.mask(\"%1$s\");}", (Object)strSaveMajorTip);
                    script.Append("return;}\r\n");
                }
                script.Append("if(_W.setsummarykey2){_W.setsummarykey2(Z);}\r\n");
                if (!StringHelper.IsNullOrEmpty((String)strGetStatesScript)) {
                    script.Append("if(_W.setstates){_W.setstates(X);}\r\n");
                }
                script.Append("};\r\n", (Object)this.getUniqueID());
                this.getPage().RegisterScript(2, script.toString());
                script.Reset();
                if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                    script.Append("$P.object['%1$s'].itemchanged=function(_I,_F){\r\n", (Object)this.getUniqueID());
                    script.Append("if(!( %1$s))return;", (Object)strCondition);
                    script.Append("if(!$P.object['%1$s'].ifloaded)return;", (Object)this.getUniqueID());
                    script.Append("var ifr=Ext.getDom('%1$s');\r\n", (Object)this.iFrame.getUniqueID());
                    script.Append("if(ifr==null)return;");
                    script.Append("var _W=ifr.contentWindow;if(!_W.$P)return;");
                    if (!this.getDPDataGridConfig().getTempData()) {
                        String strSaveMajorTip = this.getDPDataGridConfig().getSaveMajorTip();
                        if (StringHelper.IsNullOrEmpty((String)strSaveMajorTip)) {
                            strSaveMajorTip = "\u8bf7\u5148\u4fdd\u5b58\u4e3b\u6570\u636e";
                        }
                        script.Append("if(!_F._UF){");
                        script.Append("if(_W.$P.maskhelper){_W.$P.maskhelper.mask(\"%1$s\");}", (Object)strSaveMajorTip);
                        script.Append("return;}\r\n");
                    }
                    script.Append("if(_W.$P.maskhelper){_W.$P.maskhelper.unmask();}");
                    script.Append("%1$s ", (Object)strGetKeysScript);
                    script.Append("if(_W.setsummarykey){_W.setsummarykey(Z);}\r\n", (Object)this.getUniqueID());
                    if (!StringHelper.IsNullOrEmpty((String)strGetStatesCondition)) {
                        script.Append("if(%1$s){", (Object)strGetStatesCondition);
                        script.Append("%1$s", (Object)strGetStatesScript);
                        script.Append("if(_W.setstates){_W.setstates(X);}}\r\n", (Object)this.getUniqueID());
                    }
                    script.Append("};\r\n");
                    this.getPage().RegisterScript(2, script.toString());
                    script.Reset();
                    form.getItemValueChangedAction().AppendAfterCode(StringHelper.Format((String)"$P.object['%1$s'].itemchanged(_I,_F);", (Object)this.getUniqueID()));
                }
            }
            if (this.dpDataGridConfig.isSaveBeforeMajor()) {
                script.Reset();
                script.Append("$P.object['%1$s'].savedata=function(){\r\n", (Object)this.getUniqueID());
                script.Append("if(!$P.object['%1$s'].ifloaded){alert('\u5173\u8054\u6570\u636e\u754c\u9762\u672a\u52a0\u8f7d\uff0c\u65e0\u6cd5\u4fdd\u5b58\u6570\u636e\uff01');return false;}", (Object)this.getUniqueID());
                script.Append("var ifr=Ext.getDom('%1$s');\r\n", (Object)this.iFrame.getUniqueID());
                script.Append("if(ifr==null){alert('\u5173\u8054\u6570\u636e\u754c\u9762\u65e0\u6548\uff0c\u65e0\u6cd5\u4fdd\u5b58\u6570\u636e\uff01');return false;}");
                script.Append("var _W=ifr.contentWindow;");
                script.Append("if(_W.savedata){var _R=_W.savedata({});if(!_R&&$P.setpageinfo){$P.setpageinfo(\"%2$s\");}return _R;}\r\n", (Object)this.getUniqueID(), (Object)WebUtility.GetJSONText((String)"\u4fdd\u5b58\u6570\u636e\u53d1\u751f\u9519\u8bef!", (boolean)false));
                script.Append("alert('\u5173\u8054\u6570\u636e\u6ca1\u6709\u63d0\u4f9b\u4fdd\u5b58\u63a5\u53e3\uff0c\u65e0\u6cd5\u4fdd\u5b58\u6570\u636e\uff01');return false;");
                script.Append("};\r\n");
                this.getPage().RegisterScript(2, script.toString());
                form.getSaveAction().AppendBeforeCode(StringHelper.Format((String)"_F.showindicator();var bRet=$P.object['%1$s'].savedata();_F.hideindicator();if(!bRet){return;}", (Object)this.getUniqueID()));
                script.Reset();
                script.Append("$P.object['%1$s'].isdirty=function(){\r\n", (Object)this.getUniqueID());
                script.Append("if(!$P.object['%1$s'].ifloaded){alert('\u5173\u8054\u6570\u636e\u754c\u9762\u672a\u52a0\u8f7d\uff0c\u65e0\u6cd5\u5224\u65ad\u662f\u5426\u5df2\u4fee\u6539\u6570\u636e\uff01');return false;}", (Object)this.getUniqueID());
                script.Append("var ifr=Ext.getDom('%1$s');\r\n", (Object)this.iFrame.getUniqueID());
                script.Append("if(ifr==null){alert('\u5173\u8054\u6570\u636e\u754c\u9762\u65e0\u6548\uff0c\u65e0\u6cd5\u5224\u65ad\u662f\u5426\u5df2\u4fee\u6539\u6570\u636e\uff01');return false;}");
                script.Append("var _W=ifr.contentWindow;");
                script.Append("if(_W.isdirty){return _W.isdirty();}\r\n");
                script.Append("return false;");
                script.Append("};\r\n");
                this.getPage().RegisterScript(2, script.toString());
                form.getIsDirtyAction().AppendAfterCode(StringHelper.Format((String)"if(_R)return _R;_R=$P.object['%1$s'].isdirty();", (Object)this.getUniqueID()));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

