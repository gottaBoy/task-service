/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Base;

import SA.SRFramework.Base.XMLConfig;
import java.util.ArrayList;

public class CollectionXMLConfig
extends XMLConfig {
    protected ArrayList arrayList = new ArrayList();

    public ArrayList getList() {
        return this.arrayList;
    }

    @Override
    protected void CloneCopy(Object dst) {
        super.CloneCopy(dst);
        CollectionXMLConfig obj = (CollectionXMLConfig)dst;
        for (Object objItem : this.arrayList) {
            if (!(objItem instanceof XMLConfig)) continue;
            obj.getList().add(((XMLConfig)objItem).clone());
        }
    }

    @Override
    protected Object CreateCloneObject() {
        return new CollectionXMLConfig();
    }
}

