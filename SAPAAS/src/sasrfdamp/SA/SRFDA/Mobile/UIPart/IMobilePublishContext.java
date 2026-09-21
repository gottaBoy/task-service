/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 */
package SA.SRFDA.Mobile.UIPart;

import SA.SRFDA.Mobile.UIPart.IMobileUIPart;
import SA.SRFDA.Web.ISRFDAWebContext;

public interface IMobilePublishContext {
    public ISRFDAWebContext getWebContext();

    public String getLanguage();

    public boolean getMinSize();

    public boolean getAlwaysCreate();

    public String getRuntimeFolder();

    public void RegisterCSSFile(String var1);

    public void RegisterJSFile(String var1);

    public IMobileUIPart FindUIPart(String var1);

    public String CalcUniqueName(String var1);
}

