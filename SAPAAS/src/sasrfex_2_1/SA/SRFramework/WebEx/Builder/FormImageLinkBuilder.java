/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.UI.FormImageLinkConfig;
import java.io.Writer;

public class FormImageLinkBuilder
extends BaseBuilder {
    public static void RenderScript(Writer writer, SRFExControl parentControl, FormImageLinkConfig formImageLinkConfig) {
        try {
            FormImageLinkConfig globalFormImageLinkConfig;
            String strImage = "";
            String strLinkURL = "";
            String strAppendParams = "";
            String strAppendFormParams = "";
            String strLinkTarget = "";
            String strFormId = "";
            String strFormImageLinkId = formImageLinkConfig.getFormImageLinkId();
            String strTips = "";
            String strWindowMode = "";
            int nWindowWidth = 0;
            int nWindowHeight = 0;
            String strWindowResizable = "";
            String strWindowScroll = "";
            String strWindowStatus = "";
            if (StringHelper.Length((String)strFormImageLinkId) > 0 && (globalFormImageLinkConfig = parentControl.getPage().getWebContext().getFormImageLinkMgr().Get(strFormImageLinkId)) != null) {
                strImage = globalFormImageLinkConfig.getImage();
                strLinkURL = globalFormImageLinkConfig.getLinkURL();
                strAppendParams = globalFormImageLinkConfig.getAppendParams();
                strAppendFormParams = globalFormImageLinkConfig.getAppendFormParams();
                strLinkTarget = globalFormImageLinkConfig.getLinkTarget();
                strFormId = globalFormImageLinkConfig.getFormId();
                strTips = globalFormImageLinkConfig.getTips();
                strWindowMode = globalFormImageLinkConfig.getWindowMode();
                if (StringHelper.Length((String)strWindowMode) > 0) {
                    nWindowWidth = globalFormImageLinkConfig.getWindowWidth();
                    nWindowHeight = globalFormImageLinkConfig.getWindowHeight();
                    strWindowResizable = globalFormImageLinkConfig.getWindowResizable();
                    strWindowScroll = globalFormImageLinkConfig.getWindowScroll();
                    strWindowStatus = globalFormImageLinkConfig.getWindowStatus();
                }
            }
            if (StringHelper.Length((String)formImageLinkConfig.getImage()) > 0) {
                strImage = formImageLinkConfig.getImage();
            }
            if (StringHelper.Length((String)formImageLinkConfig.getLinkURL()) > 0) {
                strLinkURL = formImageLinkConfig.getLinkURL();
            }
            if (StringHelper.Length((String)formImageLinkConfig.getAppendParams()) > 0) {
                strAppendParams = formImageLinkConfig.getAppendParams();
            }
            if (StringHelper.Length((String)formImageLinkConfig.getAppendFormParams()) > 0) {
                strAppendFormParams = formImageLinkConfig.getAppendFormParams();
            }
            if (StringHelper.Length((String)formImageLinkConfig.getLinkTarget()) > 0) {
                strLinkTarget = formImageLinkConfig.getLinkTarget();
            }
            if (StringHelper.Length((String)formImageLinkConfig.getTips()) > 0) {
                strTips = formImageLinkConfig.getTips();
            }
            if (StringHelper.Length((String)formImageLinkConfig.getWindowMode()) > 0) {
                strWindowMode = formImageLinkConfig.getWindowMode();
            }
            if (StringHelper.Length((String)strWindowMode) > 0) {
                if (formImageLinkConfig.getWindowWidth() != 0) {
                    nWindowWidth = formImageLinkConfig.getWindowWidth();
                }
                if (formImageLinkConfig.getWindowHeight() != 0) {
                    nWindowHeight = formImageLinkConfig.getWindowHeight();
                }
                if (StringHelper.Length((String)formImageLinkConfig.getWindowResizable()) > 0) {
                    strWindowResizable = formImageLinkConfig.getWindowResizable();
                }
                if (StringHelper.Length((String)formImageLinkConfig.getWindowScroll()) > 0) {
                    strWindowScroll = formImageLinkConfig.getWindowScroll();
                }
                if (StringHelper.Length((String)formImageLinkConfig.getWindowStatus()) > 0) {
                    strWindowStatus = formImageLinkConfig.getWindowStatus();
                }
                if (nWindowWidth == 0) {
                    nWindowWidth = 800;
                }
                if (nWindowHeight == 0) {
                    nWindowHeight = 600;
                }
            }
            if (StringHelper.Length((String)strImage) == 0) {
                strImage = "../sasrfex/images/default/icon_datepicker.gif";
            }
            if (StringHelper.Length((String)strLinkTarget) > 0) {
                strLinkTarget = StringHelper.Format((String)"target='%1$s'", (Object)strLinkTarget);
            }
            if (StringHelper.Length((String)strTips) == 0) {
                strTips = "\u70b9\u51fb\u67e5\u770b\u8be6\u7ec6\u4fe1\u606f";
            }
            if (StringHelper.Length((String)formImageLinkConfig.getFormId()) > 0) {
                strFormId = formImageLinkConfig.getFormId();
            }
            SRFExBaseForm form = null;
            if (StringHelper.Length((String)strFormId) == 0) {
                strFormId = parentControl.getPage().getDefaultFormId();
            }
            form = parentControl.getPage().getForms().FindForm(strFormId);
            StringBuilderEx script = new StringBuilderEx();
            script.Append("$P.link['%1$s_GOTO'] = {};", parentControl.getUniqueID());
            script.Append("$P.link['%1$s_GOTO'].click = function(){", parentControl.getUniqueID());
            strAppendParams = parentControl.getPage().getWebContext().GetParamsString(strAppendParams);
            if (StringHelper.Length((String)strAppendParams) > 0) {
                strLinkURL = strLinkURL.indexOf("?") == -1 ? String.valueOf(strLinkURL) + "?" : String.valueOf(strLinkURL) + "&";
                strLinkURL = String.valueOf(strLinkURL) + strAppendParams;
            }
            strLinkURL = strLinkURL.indexOf("?") == -1 ? String.valueOf(strLinkURL) + "?" : String.valueOf(strLinkURL) + "&";
            script.Append("var _URL='%1$s';", strLinkURL);
            script.Append("var _PARAMS={};");
            if (form != null && StringHelper.Length((String)strAppendFormParams) > 0) {
                script.Append("var _F=$P.form['%1$s']._FORM;", form.getFormId());
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
                            script.Append("_PARAMS['%1$s']=_F.G('%2$s');", strParamName, control.getUniqueID());
                        }
                    }
                    ++i;
                }
            }
            script.Append("_URL+=Ext.urlEncode(_PARAMS);");
            if (StringHelper.Length((String)strWindowMode) > 0) {
                if (StringHelper.Compare((String)strWindowMode, (String)"MODEL", (boolean)true) == 0) {
                    script.Append(BrowserJSHelper.getShowDialogScript(null, "_URL", "", nWindowWidth, nWindowHeight, strWindowResizable, strWindowScroll, strWindowStatus));
                }
            } else {
                script.Append("Ext.getDom('%1$s_GOTO').href =_URL;\r\n", parentControl.getUniqueID());
                script.Append("Ext.getDom('%1$s_GOTO').click();\r\n", parentControl.getUniqueID());
                script.Append("return;");
            }
            script.Append("};");
            parentControl.getPage().RegisterOnReadyScript(3, script.toString());
            script.Reset();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String GetLinkText(SRFExControl parentControl, FormImageLinkConfig formImageLinkConfig) {
        try {
            FormImageLinkConfig globalFormImageLinkConfig;
            String strImage = "";
            String strLinkTarget = "";
            String strFormImageLinkId = formImageLinkConfig.getFormImageLinkId();
            String strTips = "";
            String strWindowMode = "";
            if (StringHelper.Length((String)strFormImageLinkId) > 0 && (globalFormImageLinkConfig = parentControl.getPage().getWebContext().getFormImageLinkMgr().Get(strFormImageLinkId)) != null) {
                strImage = globalFormImageLinkConfig.getImage();
                strLinkTarget = globalFormImageLinkConfig.getLinkTarget();
                strTips = globalFormImageLinkConfig.getTips();
                strWindowMode = globalFormImageLinkConfig.getWindowMode();
            }
            if (StringHelper.Length((String)formImageLinkConfig.getImage()) > 0) {
                strImage = formImageLinkConfig.getImage();
            }
            if (StringHelper.Length((String)formImageLinkConfig.getLinkTarget()) > 0) {
                strLinkTarget = formImageLinkConfig.getLinkTarget();
            }
            if (StringHelper.Length((String)formImageLinkConfig.getWindowMode()) > 0) {
                strWindowMode = formImageLinkConfig.getWindowMode();
            }
            if (StringHelper.Length((String)strImage) == 0) {
                strImage = "../sasrfex/images/default/icon_gotolink.gif";
            }
            if (StringHelper.Length((String)strLinkTarget) > 0) {
                strLinkTarget = StringHelper.Format((String)"target='%1$s'", (Object)strLinkTarget);
            }
            if (StringHelper.Length((String)formImageLinkConfig.getTips()) > 0) {
                strTips = formImageLinkConfig.getTips();
            }
            if (StringHelper.Length((String)strTips) == 0) {
                strTips = "\u70b9\u51fb\u67e5\u770b\u8be6\u7ec6\u4fe1\u606f";
            }
            if (StringHelper.Length((String)strWindowMode) > 0) {
                return StringHelper.Format((String)"<A  href=\"javascript:$P.link['%1$s_GOTO'].click()\"><IMG src='%2$s' border='0' align='absMiddle' alt='%3$s'></A>", (Object)parentControl.getUniqueID(), (Object)strImage, (Object)strTips);
            }
            return StringHelper.Format((String)"<A  href=\"javascript:$P.link['%1$s_GOTO'].click()\"><IMG src='%2$s' border='0' align='absMiddle' alt='%4$s'></A><A %3$s id='%1$s_GOTO' style='display:none;'></A>", (Object)parentControl.getUniqueID(), (Object)strImage, (Object)strLinkTarget, (Object)strTips);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}

