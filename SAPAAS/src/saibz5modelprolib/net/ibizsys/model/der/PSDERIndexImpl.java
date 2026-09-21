/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.der.IPSDERIndex
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.der;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.der.IPSDERIndex;
import net.ibizsys.model.der.PSDERBaseImpl;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSDERIndexImpl
extends PSDERBaseImpl
implements IPSDERIndex {
    private Properties properties = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDER.getPROPERTYMAP())) {
            this.properties = PropertiesHelper.load((String)this.psDER.getPROPERTYMAP());
        }
        this.strCodeName = this.psDER.getCODENAME();
        if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
            this.strCodeName = this.getMajorPSDataEntity().getCodeName();
        }
        super.onInit();
    }

    @PSModelRTMeta(description="\u7d22\u5f15\u7c7b\u578b\u8bc6\u522b\u503c")
    public String getTypeValue() {
        return this.psDER.getINDEXVALUE();
    }

    public Iterator getPropertyMapNames() {
        if (this.properties == null) {
            return null;
        }
        return this.properties.keySet().iterator();
    }

    public String getPropertyMap(String strName) {
        return PropertiesHelper.getProperty((Properties)this.properties, (String)strName);
    }

    @Override
    protected void onFillViewParentModeJO(ObjectNode jo) {
        super.onFillViewParentModeJO(jo);
        if (!jo.has("SRFDERINDEXID".toLowerCase())) {
            jo.put("SRFDERINDEXID".toLowerCase(), this.getName());
        }
    }
}

