/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.counter.IPSSysCounter
 *  net.ibizsys.model.control.counter.IPSSysCounterRef
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.ajax.counter;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.ajax.counter.IPSSysCounterRefRuntime;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.control.counter.IPSSysCounterRef;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSSysCounterRefImpl
extends PSObjectImpl
implements IPSSysCounterRef,
IPSSysCounterRefRuntime {
    private IPSSysCounter iPSSysCounter;
    private ObjectNode jsonRefMode;
    private String strTag = "";

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSysCounter iPSSysCounter, ObjectNode jsonRefMode) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.iPSSysCounter = iPSSysCounter;
        this.jsonRefMode = jsonRefMode;
        this.setId(StringHelper.format((String)"%1$s|%2$s", (Object)iPSSysCounter.getId(), (Object)jsonRefMode.toString()));
        this.setName(StringHelper.format((String)"%1$s|%2$s", (Object)iPSSysCounter.getName(), (Object)jsonRefMode.toString()));
        this.strTag = KeyValueHelper.genUniqueId((String)iPSSysCounter.getId(), (String)jsonRefMode.toString());
        this.onInit();
    }

    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668")
    public IPSSysCounter getPSSysCounter() {
        return this.iPSSysCounter;
    }

    @PSModelRTMeta(description="\u5f15\u7528\u6a21\u5f0f")
    public ObjectNode getRefMode() {
        return this.jsonRefMode;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSSysCounter).getPSSysModelInstId();
    }

    public String getTag() {
        return this.strTag;
    }

    @Override
    public String getModelType() {
        return "PSSYSCOUNTERREF";
    }
}

