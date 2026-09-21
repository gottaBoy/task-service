/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

public class ListItem {
    private String text = "";
    private String value = "";
    private boolean selected = false;
    private boolean disabled = false;

    public ListItem() {
    }

    public ListItem(String text, String value) {
        this.text = text;
        this.value = value.trim();
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setValue(String value) {
        this.value = value.trim();
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getText() {
        if (this.text == null) {
            return "";
        }
        return this.text;
    }

    public String getValue() {
        if (this.value == null) {
            return "";
        }
        return this.value;
    }

    public boolean getSelected() {
        return this.selected;
    }

    public boolean getDisabled() {
        return this.disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}

