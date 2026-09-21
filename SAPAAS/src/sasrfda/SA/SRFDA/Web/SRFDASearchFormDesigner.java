/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 */
package SA.SRFDA.Web;

import SA.SRFDA.Web.SRFDAFormDesigner;
import SA.SRFDA.Web.UI.SearchFormDesignerConfig;
import SA.SRFramework.Base.XMLConfig;

public class SRFDASearchFormDesigner
extends SRFDAFormDesigner {
    protected SearchFormDesignerConfig searchFormDesignerConfig = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new SearchFormDesignerConfig();
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.searchFormDesignerConfig = null;
        if (this.config != null && this.config instanceof SearchFormDesignerConfig) {
            this.searchFormDesignerConfig = (SearchFormDesignerConfig)this.config;
        }
    }

    @Override
    protected boolean OnGetSearchFormMode() {
        return true;
    }

    @Override
    protected boolean OnGetDEFGroupSFMode() {
        return this.searchFormDesignerConfig.isDEFGroupSPMode();
    }
}

