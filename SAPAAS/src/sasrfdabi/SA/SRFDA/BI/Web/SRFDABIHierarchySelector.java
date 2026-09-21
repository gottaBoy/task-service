/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.WebEx.SRFExHidden
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.BI.Web.UI.BIHierarchySelectorConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.WebEx.SRFExHidden;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFDABIHierarchySelector
extends SRFExHidden {
    private static final Log log = LogFactory.getLog(SRFDABIHierarchySelector.class);
    protected BIHierarchySelectorConfig biHierarchySelectorConfig = null;

    protected void OnInit() {
        super.OnInit();
    }

    protected XMLConfig CreateConfig() {
        return new BIHierarchySelectorConfig();
    }

    public BIHierarchySelectorConfig getBIHierarchySelectorConfig() {
        return this.biHierarchySelectorConfig;
    }

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.biHierarchySelectorConfig = null;
        if (this.config != null && this.config instanceof BIHierarchySelectorConfig) {
            this.biHierarchySelectorConfig = (BIHierarchySelectorConfig)this.config;
        }
    }
}

