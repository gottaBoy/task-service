/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;
import java.util.ArrayList;

public class BaseFormItemGroup
extends XMLConfig {
    protected static String FORMITEM = "FORMITEM";
    protected ArrayList groupItemList = new ArrayList();

    public ArrayList getItems() {
        return this.groupItemList;
    }
}

