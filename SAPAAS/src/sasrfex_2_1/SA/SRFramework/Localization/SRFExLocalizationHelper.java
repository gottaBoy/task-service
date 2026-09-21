/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Localization;

import SA.SRFramework.Localization.ISRFExLocalizationHelper;

public class SRFExLocalizationHelper
implements ISRFExLocalizationHelper {
    @Override
    public String GetLocalization(String strLanguage, String strResId, String strResId2, String strDefault) {
        return strDefault;
    }

    @Override
    public String GetLocalization(String strLanguage, String strResId, String strDefault) {
        return this.GetLocalization(strLanguage, strResId, "", strDefault);
    }

    @Override
    public void Reload() {
    }
}

