/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.DEField;
import net.ibizsys.paas.core.DEFields;
import net.ibizsys.paas.util.StringHelper;

public class DEFieldsAnnoHelper {
    private HashMap<String, DEField> deFieldMap = new HashMap();
    private ArrayList<DEField> deFieldList = new ArrayList();
    private DEFields defields = null;

    public DEFieldsAnnoHelper(DEFields defields) {
        this.defields = defields;
        DEField[] dEFieldArray = this.defields.value();
        int n = dEFieldArray.length;
        int n2 = 0;
        while (n2 < n) {
            DEField defield = dEFieldArray[n2];
            this.deFieldList.add(defield);
            this.deFieldMap.put(defield.id(), defield);
            this.deFieldMap.put(defield.name(), defield);
            ++n2;
        }
    }

    public DEField getDEField(String strName, boolean bTry) throws Exception {
        DEField defield = this.deFieldMap.get(strName);
        if (defield == null && !bTry) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]", strName));
        }
        return defield;
    }

    public Iterator<DEField> getDEFields() {
        return this.deFieldList.iterator();
    }
}

