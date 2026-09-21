/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Localization.ISRFExLocalizationHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Localization;

import SA.SRFDA.Ctrl.Data.LanguageItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Localization.ISRFExLocalizationHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFDALocalizationHelper
implements ISRFExLocalizationHelper {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected String strLanguage = "";
    protected Hashtable<String, String> languageItemMap = new Hashtable();
    protected String strDefaultLanguage = "";
    protected boolean bHasDefaultLanguage = true;
    private static Log log = LogFactory.getLog(SRFDALocalizationHelper.class);

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, String strLanguage) {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.strLanguage = strLanguage;
        this.strDefaultLanguage = iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "DEFAULTLANGUAGE", "");
        this.bHasDefaultLanguage = !StringHelper.IsNullOrEmpty((String)this.strDefaultLanguage);
        this.Reload();
    }

    public void Reload() {
        this.languageItemMap.clear();
        if (StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            Vector<LanguageItem> languageItems = new Vector<LanguageItem>();
            CallResult callResult = this.iDAGlobalHelper.getDAModelHelper().GetLanguageItems(null, languageItems);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u672c\u5730\u5316\u8bed\u8a00\u5b9a\u4e49\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return;
            }
            for (LanguageItem languageItem : languageItems) {
                String strContent = languageItem.getCONTENT();
                this.languageItemMap.put(languageItem.getLANGUAGEITEMID().toUpperCase(), strContent);
            }
        } else {
            String[] languages = this.strLanguage.split("[|]");
            int i = 0;
            while (i < languages.length) {
                Vector<LanguageItem> languageItems = new Vector<LanguageItem>();
                CallResult callResult = this.iDAGlobalHelper.getDAModelHelper().GetLanguageItems(languages[i], languageItems);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u672c\u5730\u5316\u8bed\u8a00[%2$s]\u5b9a\u4e49\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo(), (Object)languages[i]));
                } else {
                    for (LanguageItem languageItem : languageItems) {
                        String strContent = languageItem.getCONTENT();
                        this.languageItemMap.put(languageItem.getLANGUAGEITEMID().toUpperCase(), strContent);
                    }
                }
                ++i;
            }
        }
    }

    public String GetLocalization(String strLanguage, String strResId, String strResId2, String strDefault) {
        String strKey;
        String strValue;
        if (StringHelper.IsNullOrEmpty((String)strResId)) {
            if (StringHelper.IsNullOrEmpty((String)strResId2)) {
                return strDefault;
            }
            return this.GetLocalization(strLanguage, strResId2, "", strDefault);
        }
        if (StringHelper.IsNullOrEmpty((String)strLanguage)) {
            if (!this.bHasDefaultLanguage) {
                return strDefault;
            }
            strLanguage = this.strDefaultLanguage;
        }
        if ((strValue = this.languageItemMap.get(strKey = StringHelper.Format((String)"%1$s.%2$s", (Object)strLanguage, (Object)strResId).toUpperCase())) == null) {
            if (!StringHelper.IsNullOrEmpty((String)strResId2)) {
                strKey = StringHelper.Format((String)"%1$s.%2$s", (Object)strLanguage, (Object)strResId2).toUpperCase();
                strValue = this.languageItemMap.get(strKey);
                if (strValue == null) {
                    if (log.isDebugEnabled()) {
                        log.debug((Object)StringHelper.Format((String)"\u6ca1\u6709\u5b9a\u4e49\u8bed\u8a00\u8d44\u6e90[%1$s],\u4f7f\u7528\u9ed8\u8ba4\u503c[%2$s]", (Object)strKey, (Object)strDefault));
                    }
                    return strDefault;
                }
                return strValue;
            }
            if (log.isDebugEnabled()) {
                log.debug((Object)StringHelper.Format((String)"\u6ca1\u6709\u5b9a\u4e49\u8bed\u8a00\u8d44\u6e90[%1$s],\u4f7f\u7528\u9ed8\u8ba4\u503c[%2$s]", (Object)strKey, (Object)strDefault));
            }
            return strDefault;
        }
        return strValue;
    }

    public String GetLocalization(String strLanguage, String strResId, String strDefault) {
        return this.GetLocalization(strLanguage, strResId, "", strDefault);
    }

    public static String GetRes_DELogicName(String strDEId) {
        return StringHelper.Format((String)"DE.LNAME.%1$s", (Object)strDEId);
    }

    public static String GetRes_DEFLogicName(String strDEId, String strDEFName) {
        return StringHelper.Format((String)"DEF.LNAME.%1$s.%2$s", (Object)strDEId, (Object)strDEFName);
    }

    public static String GetRes_TBBText(String strPageType, String strButton) {
        return StringHelper.Format((String)"TBB.TEXT.%1$s.%2$s", (Object)strPageType, (Object)strButton);
    }

    public static String GetRes_TBBTooltip(String strPageType, String strButton) {
        return StringHelper.Format((String)"TBB.TOOLTIP.%1$s.%2$s", (Object)strPageType, (Object)strButton);
    }

    public static String GetRes_MenuItemCaption(String strPageType, String strButton) {
        return StringHelper.Format((String)"MENUITEM.CAPTION.%1$s.%2$s", (Object)strPageType, (Object)strButton);
    }
}

