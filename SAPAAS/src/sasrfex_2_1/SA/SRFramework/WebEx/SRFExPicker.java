/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExHidden;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.UI.PickerConfig;
import java.io.Writer;

public class SRFExPicker
extends SRFExHidden {
    protected SRFExTextBox textBox = new SRFExTextBox();
    protected PickerConfig pickupConfig = null;

    @Override
    protected void OnInit() {
        super.OnInit();
        this.AddControl(this.textBox);
    }

    @Override
    protected XMLConfig CreateConfig() {
        return new PickerConfig();
    }

    public PickerConfig getPickupConfig() {
        return this.pickupConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.pickupConfig = null;
        if (this.config != null && this.config instanceof PickerConfig) {
            this.pickupConfig = (PickerConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        if (this.pickupConfig != null) {
            this.textBox.setConfig(this.pickupConfig.getTextBoxConfig());
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            super.OnRender(writer);
            String strScript = "";
            if (StringHelper.Length((String)this.getPickupConfig().getPickupCall()) > 0) {
                strScript = StringHelper.Format((String)"%1$s('%2$s','%3$s')", (Object)this.getPickupConfig().getPickupCall(), (Object)this.getUniqueID(), (Object)this.textBox.getUniqueID());
            }
            this.textBox.getTextBoxConfig().setTextMode(3);
            if (this.getPickupConfig().getPickOnly() || StringHelper.Length((String)this.textBox.getTextBoxConfig().getACMode()) == 0) {
                this.textBox.getTextBoxConfig().setReadOnly(true);
            } else {
                this.textBox.getTextBoxConfig().setReadOnly(false);
            }
            this.textBox.Render(writer);
            writer.write(String.format("<A href='#' onclick=\"javascript:%1$s\"><IMG src=\"%2$s\" align=\"absMiddle\" border=\"0\" alt=\"%3$s\"></A>", strScript, this.getPickupConfig().getImage(), this.getPickupConfig().getTipMessage()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

