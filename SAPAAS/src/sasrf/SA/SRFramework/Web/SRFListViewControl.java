/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

import SA.SRFramework.Data.SearchResult;
import SA.SRFramework.Web.SRFWebControl;

public class SRFListViewControl
extends SRFWebControl {
    protected SearchResult searchResult = null;
    protected boolean bInputError = false;
    protected String strUserMessage = "";

    public void setDataSource(SearchResult value) {
        this.searchResult = value;
    }

    public void setInputError(boolean value) {
        this.bInputError = value;
    }

    public void setUserMessage(String value) {
        this.strUserMessage = value;
    }
}

