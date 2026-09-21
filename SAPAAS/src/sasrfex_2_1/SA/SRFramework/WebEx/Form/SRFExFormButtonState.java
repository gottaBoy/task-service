/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.Form;

public class SRFExFormButtonState {
    protected String strButtonId = "";
    protected String strButtonStateId = "";
    protected boolean bDefault = false;
    protected boolean bFormHasKey = false;

    public SRFExFormButtonState(String strButtonId, String strButtonStateId, boolean bDefault) {
        this.strButtonId = strButtonId;
        this.strButtonStateId = strButtonStateId;
        this.bDefault = bDefault;
    }

    public String getButtonId() {
        return this.strButtonId;
    }

    public void setButtonId(String strButtonId) {
        this.strButtonId = strButtonId;
    }

    public String getButtonStateId() {
        return this.strButtonStateId;
    }

    public void setButtonStateId(String strButtonStateId) {
        this.strButtonStateId = strButtonStateId;
    }

    public boolean isDefault() {
        return this.bDefault;
    }

    public void setDefault(boolean default1) {
        this.bDefault = default1;
    }

    public boolean isFormHasKey() {
        return this.bFormHasKey;
    }

    public void setFormHasKey(boolean formHasKey) {
        this.bFormHasKey = formHasKey;
    }
}

