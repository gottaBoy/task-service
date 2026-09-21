/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSObjectEx;
import SA.SRFDA.PS.Core.IPSObjectProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class PSObjectExImpl
implements IPSObjectEx {
    private IPSObject iPSObject = null;
    private HashMap<String, IPSObjectProperty> psObjectPropertyMap = null;
    private HashMap<String, ArrayList<IPSObjectProperty>> psPropertyGroupMap = null;

    public PSObjectExImpl(IPSObject iPSObject) {
        this.iPSObject = iPSObject;
    }

    @Override
    public IPSObject getPSObject() {
        return this.iPSObject;
    }

    @Override
    public IPSObjectProperty getPSProperty(String strName) throws Exception {
        this.preparePSProperties();
        return this.psObjectPropertyMap.get(strName.toUpperCase());
    }

    @Override
    public Iterator<IPSObjectProperty> getPSProperties(String strGroupTag) throws Exception {
        this.preparePSProperties();
        ArrayList<IPSObjectProperty> list = this.psPropertyGroupMap.get(strGroupTag.toUpperCase());
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    protected synchronized void preparePSProperties() throws Exception {
        if (this.psObjectPropertyMap != null) {
            return;
        }
        this.psObjectPropertyMap = new HashMap();
        this.onPreparePSProperties();
        this.psPropertyGroupMap = new HashMap();
        for (IPSObjectProperty iPSObjectProperty : this.psObjectPropertyMap.values()) {
            ArrayList<IPSObjectProperty> list = this.psPropertyGroupMap.get(iPSObjectProperty.getGroupTag());
            if (list == null) {
                list = new ArrayList();
                this.psPropertyGroupMap.put(iPSObjectProperty.getGroupTag().toUpperCase(), list);
            }
            list.add(iPSObjectProperty);
        }
        for (ArrayList arrayList : this.psPropertyGroupMap.values()) {
            Collections.sort(arrayList, new Comparator<IPSObjectProperty>(){

                @Override
                public int compare(IPSObjectProperty arg0, IPSObjectProperty arg1) {
                    return arg0.getName().compareTo(arg1.getName());
                }
            });
        }
    }

    protected void onPreparePSProperties() throws Exception {
    }

    @Override
    public IPSObjectProperty registerPSProperty(IPSObjectProperty iPSObjectProperty) {
        this.psObjectPropertyMap.put(iPSObjectProperty.getName().toUpperCase(), iPSObjectProperty);
        return iPSObjectProperty;
    }

    @Override
    public void unregisterPSProperty(String strName) {
        this.psObjectPropertyMap.remove(strName.toUpperCase());
    }
}

