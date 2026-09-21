/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.UI.IPAddressTextBoxConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExIPAddressTextBox
extends SRFExTextBox {
    protected IPAddressTextBoxConfig ipAddressTextBoxConfig = null;
    private static final Log log = LogFactory.getLog(SRFExIPAddressTextBox.class);

    @Override
    protected XMLConfig CreateConfig() {
        return new IPAddressTextBoxConfig();
    }

    public IPAddressTextBoxConfig getIPAddressTextBoxConfig() {
        if (this.ipAddressTextBoxConfig == null) {
            this.InitConfig();
        }
        return this.ipAddressTextBoxConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.ipAddressTextBoxConfig = null;
        if (this.config != null && this.config instanceof IPAddressTextBoxConfig) {
            this.ipAddressTextBoxConfig = (IPAddressTextBoxConfig)this.config;
        }
    }

    @Override
    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            return "_V = SRFUtility.ip2long($FGV(_ID));";
        }
        return "$FSV(_ID,SRFUtility.long2ip(_V));";
    }
}

