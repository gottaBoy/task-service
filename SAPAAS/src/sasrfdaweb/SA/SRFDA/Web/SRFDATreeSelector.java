/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.WebEx.SRFExHidden
 */
package SA.SRFDA.Web;

import SA.SRFDA.Web.UI.TreeSelectorConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.WebEx.SRFExHidden;

public class SRFDATreeSelector
extends SRFExHidden {
    private TreeSelectorConfig treeSelectorConfig = null;

    protected XMLConfig CreateConfig() {
        return new TreeSelectorConfig();
    }

    public TreeSelectorConfig getTreeSelectorConfig() {
        return this.treeSelectorConfig;
    }

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.treeSelectorConfig = null;
        if (this.config != null && this.config instanceof TreeSelectorConfig) {
            this.treeSelectorConfig = (TreeSelectorConfig)this.config;
        }
    }
}

