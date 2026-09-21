/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNode;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeOwner;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodes;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSJsonNodesImpl<T extends IPSJsonNode>
extends PSObjectImpl
implements IPSJsonNodes<T> {
    private static final Log log = LogFactory.getLog(PSJsonNodesImpl.class);
    private IPSJsonNodeOwner iPSJsonNodeOwner = null;
    private ObjectNode objectNode = null;
    private Map<String, T> itemMap = new LinkedHashMap<String, T>();

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSJsonNodeOwner iPSJsonNodeOwner, String strName, ObjectNode objectNode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSJsonNodeOwner(iPSJsonNodeOwner);
            this.setName(strName);
            this.setObjectNode(objectNode);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    public IPSJsonNodeOwner getPSJsonNodeOwner() {
        return this.iPSJsonNodeOwner;
    }

    protected void setPSJsonNodeOwner(IPSJsonNodeOwner iPSJsonNodeOwner) {
        this.iPSJsonNodeOwner = iPSJsonNodeOwner;
    }

    @Override
    protected void onInit() throws Exception {
        Iterator fieldNames = this.getObjectNode().fieldNames();
        if (fieldNames != null) {
            while (fieldNames.hasNext()) {
                JsonNode jsonNode;
                String strFieldName = (String)fieldNames.next();
                T t = this.getItem(strFieldName, jsonNode = this.getObjectNode().get(strFieldName));
                if (t == null) continue;
                this.itemMap.put(strFieldName, t);
            }
        }
        super.onInit();
    }

    @Override
    public JsonNode getJsonNode() {
        return this.getObjectNode();
    }

    public ObjectNode getObjectNode() {
        return this.objectNode;
    }

    protected void setObjectNode(ObjectNode objectNode) {
        this.objectNode = objectNode;
    }

    protected abstract T getItem(String var1, JsonNode var2) throws Exception;

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u540d\u79f0\u96c6\u5408")
    public Iterator<String> getItemNames() {
        if (this.itemMap == null || this.itemMap.size() == 0) {
            return null;
        }
        return this.itemMap.keySet().iterator();
    }

    @Override
    public T getItem(String strName, boolean bTryMode) throws Exception {
        IPSJsonNode t = (IPSJsonNode)this.itemMap.get(strName);
        if (t != null || bTryMode) {
            return (T)t;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6807\u8bc6[%1$s]\u5b50\u9879", strName));
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u96c6\u5408")
    public Iterator<T> getItems() {
        if (this.itemMap == null || this.itemMap.size() == 0) {
            return null;
        }
        return this.itemMap.values().iterator();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSystem());
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSystem().getPSSysModelInstId();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSJsonNodeOwner().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return this.getPSJsonNodeOwner().getModelId();
    }

    @Override
    public IPSSystem getPSSystem() {
        return this.getPSJsonNodeOwner().getPSSystem();
    }
}

