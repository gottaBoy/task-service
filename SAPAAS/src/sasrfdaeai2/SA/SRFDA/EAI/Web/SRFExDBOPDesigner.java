/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.WebEx.SRFExHidden
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.EAI.Web;

import SA.SRFDA.EAI.Web.UI.DBOPDesignerConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.WebEx.SRFExHidden;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExDBOPDesigner
extends SRFExHidden {
    protected DBOPDesignerConfig designerConfig = null;
    private static final Log log = LogFactory.getLog(SRFExDBOPDesigner.class);

    protected XMLConfig CreateConfig() {
        return new DBOPDesignerConfig();
    }

    public DBOPDesignerConfig getDesignerConfig() {
        if (this.designerConfig == null) {
            this.InitConfig();
        }
        return this.designerConfig;
    }

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.designerConfig = null;
        if (this.config != null && this.config instanceof DBOPDesignerConfig) {
            this.designerConfig = (DBOPDesignerConfig)this.config;
        }
    }
}

