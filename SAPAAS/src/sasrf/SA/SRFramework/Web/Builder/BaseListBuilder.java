/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Data.SearchResult;
import SA.SRFramework.Web.Builder.UIBuilder;
import SA.SRFramework.Web.UI.UserCtrlMgr;
import java.util.Hashtable;

public abstract class BaseListBuilder
extends UIBuilder {
    protected static String EMPTY = "EMPTY";
    protected static String SEARCHEMPTY = "SEARCHEMPTY";
    protected static String ERRORINPUT = "ERRORINPUT";
    protected static String DEFAULT = "DEFAULT";
    protected SearchResult searchResult = null;
    protected int nConditonCount = 0;
    protected Hashtable userColumnList = new Hashtable();
    protected boolean bUserInputError = false;
    protected UserCtrlMgr userCtrlMgr = null;

    public void setDataSource(SearchResult value) {
        this.searchResult = value;
    }

    public void setConditonCount(int value) {
        this.nConditonCount = value;
    }

    public void setUserInputError(boolean value) {
        this.bUserInputError = value;
    }
}

