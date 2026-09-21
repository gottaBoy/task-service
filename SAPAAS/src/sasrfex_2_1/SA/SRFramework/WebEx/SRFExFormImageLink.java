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
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.FormImageLinkConfig;
import java.io.Writer;

public class SRFExFormImageLink
extends SRFExControl {
    protected FormImageLinkConfig formImageLinkConfig = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new FormImageLinkConfig();
    }

    public FormImageLinkConfig getFormImageLinkConfig() {
        return this.formImageLinkConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.formImageLinkConfig = null;
        if (this.config != null && this.config instanceof FormImageLinkConfig) {
            this.formImageLinkConfig = (FormImageLinkConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            FormImageLinkConfig globalFormImageLinkConfig;
            String strImage = "";
            String strLinkURL = "";
            String strAppendParams = "";
            String strAppendFormParams = "";
            String strLinkTarget = "";
            String strFormId = "";
            String strFormImageLinkId = this.getFormImageLinkConfig().getFormImageLinkId();
            String strTips = "";
            if (StringHelper.Length((String)strFormImageLinkId) > 0 && (globalFormImageLinkConfig = this.getPage().getWebContext().getFormImageLinkMgr().Get(strFormImageLinkId)) != null) {
                strImage = globalFormImageLinkConfig.getImage();
                strLinkURL = globalFormImageLinkConfig.getLinkURL();
                strAppendParams = globalFormImageLinkConfig.getAppendParams();
                strAppendFormParams = globalFormImageLinkConfig.getAppendFormParams();
                strLinkTarget = globalFormImageLinkConfig.getLinkTarget();
                strFormId = globalFormImageLinkConfig.getFormId();
            }
            if (StringHelper.Length((String)this.getFormImageLinkConfig().getImage()) > 0) {
                strImage = this.getFormImageLinkConfig().getImage();
            }
            if (StringHelper.Length((String)this.getFormImageLinkConfig().getLinkURL()) > 0) {
                strLinkURL = this.getFormImageLinkConfig().getLinkURL();
            }
            if (StringHelper.Length((String)this.getFormImageLinkConfig().getAppendParams()) > 0) {
                strAppendParams = this.getFormImageLinkConfig().getAppendParams();
            }
            if (StringHelper.Length((String)this.getFormImageLinkConfig().getAppendFormParams()) > 0) {
                strAppendFormParams = this.getFormImageLinkConfig().getAppendFormParams();
            }
            if (StringHelper.Length((String)this.getFormImageLinkConfig().getLinkTarget()) > 0) {
                strLinkTarget = this.getFormImageLinkConfig().getLinkTarget();
            }
            if (StringHelper.Length((String)strImage) == 0) {
                strImage = "../sasrfex/images/default/icon_gotolink.gif";
            }
            if (StringHelper.Length((String)strLinkTarget) > 0) {
                strLinkTarget = StringHelper.Format((String)"target='%1$s'", (Object)strLinkTarget);
            }
            if (StringHelper.Length((String)this.getFormImageLinkConfig().getFormId()) > 0) {
                strFormId = this.getFormImageLinkConfig().getFormId();
            }
            SRFExBaseForm form = null;
            if (StringHelper.Length((String)strFormId) == 0) {
                strFormId = this.getPage().getDefaultFormId();
            }
            form = this.getPage().getForms().FindForm(strFormId);
            writer.write(StringHelper.Format((String)"<A alt='%4$s' href='#' onclick=\"javascript:$P.link['%1$s'].click()\"><IMG src='%2$s' border='0' align='absMiddle'  ></A><A %3$s id='%1$s' style='display:none;'></A>", (Object)this.getUniqueID(), (Object)strImage, (Object)strLinkTarget, (Object)strTips));
            StringBuilderEx script = new StringBuilderEx();
            script.Append("$P.link['%1$s'] = {};", this.getUniqueID());
            script.Append("$P.link['%1$s'].click = function(){", this.getUniqueID());
            strAppendParams = this.getPage().getWebContext().GetParamsString(strAppendParams);
            if (StringHelper.Length((String)strAppendParams) > 0) {
                strLinkURL = strLinkURL.indexOf("?") == -1 ? String.valueOf(strLinkURL) + "?" : String.valueOf(strLinkURL) + "&";
                strLinkURL = String.valueOf(strLinkURL) + strAppendParams;
            }
            strLinkURL = strLinkURL.indexOf("?") == -1 ? String.valueOf(strLinkURL) + "?" : String.valueOf(strLinkURL) + "&";
            script.Append("var _URL = '%1$s';", strLinkURL);
            script.Append("var _PARAMS = {};");
            if (form != null && StringHelper.Length((String)strAppendFormParams) > 0) {
                String[] formParams = strAppendFormParams.split("[,]");
                int i = 0;
                while (i < formParams.length) {
                    String[] formParamPair;
                    String strFormParam = formParams[i];
                    if (StringHelper.Length((String)strFormParam) != 0 && (formParamPair = strFormParam.split("[|]")).length != 0) {
                        SRFExControl control;
                        String strParamName = formParamPair[0];
                        String strValueName = formParamPair[0];
                        if (formParamPair.length >= 2) {
                            strValueName = formParamPair[1];
                        }
                        if ((control = form.FindControl(strValueName)) != null) {
                            script.Append("_PARAMS['%1$s'] = $P.form['%2$s']._FORM.getvalue('%3$s');", strParamName, form.getFormId(), control.getUniqueID());
                        }
                    }
                    ++i;
                }
            }
            if (this.getFormImageLinkConfig().getJSFunc()) {
                script.Append("%1$s(Ext.urlDecode('%2$s'),_PARAMS);\r\n", strLinkURL, strAppendParams);
            } else {
                script.Append("_URL+=Ext.urlEncode(_PARAMS);");
                script.Append("Ext.getDom('%1$s').href = _URL;\r\n", this.getUniqueID());
                script.Append("Ext.getDom('%1$s').click();\r\n", this.getUniqueID());
            }
            script.Append("return;");
            script.Append("};");
            this.getPage().RegisterOnReadyScript(3, script.toString());
            script.Reset();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

