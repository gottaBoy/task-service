/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

public class TabCtrlItem {
    public String strId = "";
    public String strName = "";
    public String strImage = "";

    public TabCtrlItem() {
    }

    public TabCtrlItem(String strId, String strName, String strImage) {
        this.strImage = strImage;
        this.strId = strId;
        this.strName = strName;
    }

    public TabCtrlItem(String strId, String strName) {
        this.strId = strId;
        this.strName = strName;
    }

    public String getId() {
        return this.strId;
    }

    public void setId(String value) {
        this.strId = value;
    }

    public String getName() {
        return this.strName;
    }

    public void setName(String value) {
        this.strName = value;
    }

    public String getImage() {
        return this.strImage;
    }

    public void setImage(String value) {
        this.strImage = value;
    }
}

