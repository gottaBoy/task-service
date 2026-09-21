/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.IWSPagePublishContext;

public class DefaultWSPagePublishContext
implements IWSPagePublishContext {
    String strRootPath = "";
    String strRelativePath = "";

    public DefaultWSPagePublishContext(String strRootPath) {
        this.strRootPath = strRootPath;
    }

    @Override
    public String getRootPath() {
        return this.strRootPath;
    }

    @Override
    public String getRelativePath() {
        return this.strRelativePath;
    }

    @Override
    public void setRelativePath(String strRelativePath) {
        this.strRelativePath = strRelativePath;
    }
}

