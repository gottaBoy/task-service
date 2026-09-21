/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Mobile.UIPart;

import SA.SRFDA.Mobile.UIPart.IMobilePublishContext;
import SA.SRFDA.Mobile.UIPart.IMobileUIPart;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import java.util.Vector;

public class DefaultMobilePublishContext
implements IMobilePublishContext {
    protected ISRFDAWebContext webContext = null;
    protected Hashtable<String, IMobileUIPart> mobileUIPartMap = new Hashtable();
    protected Hashtable<String, Integer> uiPartUniqueNameMap = new Hashtable();
    protected String strRuntimeFolder = "";
    protected boolean bAlwaysCreate = false;
    protected Vector<String> cssFiles = new Vector();
    protected Vector<String> jsFiles = new Vector();

    @Override
    public void RegisterCSSFile(String strCSSFile) {
        this.cssFiles.add(strCSSFile);
    }

    @Override
    public void RegisterJSFile(String strJSFile) {
        this.jsFiles.add(strJSFile);
    }

    public Vector<String> getCSSFiles() {
        return this.cssFiles;
    }

    public Vector<String> getJSFiles() {
        return this.jsFiles;
    }

    @Override
    public boolean getAlwaysCreate() {
        return this.bAlwaysCreate;
    }

    public void setAlwaysCreate(boolean bAlwaysCreate) {
        this.bAlwaysCreate = bAlwaysCreate;
    }

    @Override
    public String getLanguage() {
        return null;
    }

    @Override
    public boolean getMinSize() {
        return false;
    }

    @Override
    public String getRuntimeFolder() {
        return this.strRuntimeFolder;
    }

    public void setRuntimeFolder(String strRuntimeFolder) {
        this.strRuntimeFolder = strRuntimeFolder;
    }

    @Override
    public ISRFDAWebContext getWebContext() {
        return this.webContext;
    }

    public void setWebContext(ISRFDAWebContext webContext) {
        this.webContext = webContext;
    }

    @Override
    public IMobileUIPart FindUIPart(String strUIPartId) {
        return this.mobileUIPartMap.get(strUIPartId);
    }

    public void RegisterUIPart(IMobileUIPart mobileUIPart) {
        if (mobileUIPart == null) {
            return;
        }
        this.mobileUIPartMap.put(mobileUIPart.getId(), mobileUIPart);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String CalcUniqueName(String strPreFix) {
        Integer nLastValue = 500;
        Hashtable<String, Integer> hashtable = this.uiPartUniqueNameMap;
        synchronized (hashtable) {
            if (this.uiPartUniqueNameMap.containsKey(strPreFix)) {
                nLastValue = this.uiPartUniqueNameMap.get(strPreFix);
                nLastValue = nLastValue + 1;
            }
            this.uiPartUniqueNameMap.put(strPreFix, nLastValue);
        }
        return StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)nLastValue);
    }
}

