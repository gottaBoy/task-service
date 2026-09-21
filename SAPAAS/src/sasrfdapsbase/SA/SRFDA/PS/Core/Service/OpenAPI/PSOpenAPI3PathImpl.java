/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Operation;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Parameter;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Path;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3ObjectImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3OperationImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSOpenAPI3PathImpl
extends PSOpenAPI3ObjectImpl
implements IPSOpenAPI3Path {
    private static final Log log = LogFactory.getLog(PSOpenAPI3PathImpl.class);
    private Map<String, IPSOpenAPI3Operation> psOpenAPI3OperationMap = new LinkedHashMap<String, IPSOpenAPI3Operation>();
    private Map<String, IPSOpenAPI3Parameter> psOpenAPI3ParameterMap = null;
    private static String[] METHODS = new String[]{"get", "put", "post", "delete", "options", "header", "patch", "trace"};

    @Override
    protected void onInit() throws Exception {
        String[] stringArray = METHODS;
        int n = METHODS.length;
        int n2 = 0;
        while (n2 < n) {
            String strMethod = stringArray[n2];
            if (this.getObjectNode().has(strMethod)) {
                JsonNode jsonNode = this.getObjectNode().get(strMethod);
                if (jsonNode instanceof ObjectNode) {
                    this.setPSOpenAPI3Operation(strMethod, this.getPSOpenAPI3Operation(strMethod, (ObjectNode)jsonNode));
                } else {
                    throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strMethod));
                }
            }
            ++n2;
        }
        if (this.getObjectNode().has("parameters")) {
            JsonNode jsonNode = this.getObjectNode().get("parameters");
            this.setPSOpenAPI3ParameterMap(this.getPSOpenAPI3ParameterMap("parameters", jsonNode));
        }
        super.onInit();
    }

    protected IPSOpenAPI3Operation getPSOpenAPI3Operation(String strName, ObjectNode objData) throws Exception {
        PSOpenAPI3OperationImpl psOpenAPI3OperationImpl = new PSOpenAPI3OperationImpl();
        psOpenAPI3OperationImpl.init(this.getDAGlobalHelper(), this, strName, (JsonNode)objData);
        return psOpenAPI3OperationImpl;
    }

    @Override
    @PSModelRTMeta(description="\u6458\u8981\u4fe1\u606f")
    public String getSummary() {
        if (this.getObjectNode().has("summary")) {
            return this.getObjectNode().get("summary").textValue();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="GET\u64cd\u4f5c")
    public IPSOpenAPI3Operation getGetPSOpenAPI3Operation() {
        try {
            return this.getPSOpenAPI3Operation("get", true);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="PUT\u64cd\u4f5c")
    public IPSOpenAPI3Operation getPutPSOpenAPI3Operation() {
        try {
            return this.getPSOpenAPI3Operation("put", true);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="POST\u64cd\u4f5c")
    public IPSOpenAPI3Operation getPostPSOpenAPI3Operation() {
        try {
            return this.getPSOpenAPI3Operation("post", true);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="DELETE\u64cd\u4f5c")
    public IPSOpenAPI3Operation getDeletePSOpenAPI3Operation() {
        try {
            return this.getPSOpenAPI3Operation("delete", true);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="OPTIONS\u64cd\u4f5c")
    public IPSOpenAPI3Operation getOptionsPSOpenAPI3Operation() {
        try {
            return this.getPSOpenAPI3Operation("options", true);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="HEADER\u64cd\u4f5c")
    public IPSOpenAPI3Operation getHeaderPSOpenAPI3Operation() {
        try {
            return this.getPSOpenAPI3Operation("header", true);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="PATCH\u64cd\u4f5c")
    public IPSOpenAPI3Operation getPatchPSOpenAPI3Operation() {
        try {
            return this.getPSOpenAPI3Operation("patch", true);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="TRACE\u64cd\u4f5c")
    public IPSOpenAPI3Operation getTracePSOpenAPI3Operation() {
        try {
            return this.getPSOpenAPI3Operation("trace", true);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u96c6\u5408")
    public Iterator<IPSOpenAPI3Operation> getPSOpenAPI3Operations() {
        if (this.psOpenAPI3OperationMap == null || this.psOpenAPI3OperationMap.size() == 0) {
            return null;
        }
        return this.psOpenAPI3OperationMap.values().iterator();
    }

    @Override
    public IPSOpenAPI3Operation getPSOpenAPI3Operation(String strName, boolean bTryMode) throws Exception {
        IPSOpenAPI3Operation iPSOpenAPI3Operation = this.psOpenAPI3OperationMap.get(strName);
        if (iPSOpenAPI3Operation != null || bTryMode) {
            return iPSOpenAPI3Operation;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u64cd\u4f5c\u5bf9\u8c61[%1$s]", strName));
    }

    protected void setPSOpenAPI3Operation(String strName, IPSOpenAPI3Operation iPSOpenAPI3Operation) {
        this.psOpenAPI3OperationMap.put(strName, iPSOpenAPI3Operation);
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u96c6\u5408")
    public Iterator<IPSOpenAPI3Parameter> getPSOpenAPI3Parameters() {
        if (this.psOpenAPI3ParameterMap == null || this.psOpenAPI3ParameterMap.size() == 0) {
            return null;
        }
        return this.psOpenAPI3ParameterMap.values().iterator();
    }

    @Override
    public IPSOpenAPI3Parameter getPSOpenAPI3Parameter(String strName, boolean bTryMode) throws Exception {
        IPSOpenAPI3Parameter iPSOpenAPI3Parameter = this.psOpenAPI3ParameterMap.get(strName);
        if (iPSOpenAPI3Parameter != null || bTryMode) {
            return iPSOpenAPI3Parameter;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53c2\u6570\u5bf9\u8c61[%1$s]", strName));
    }

    protected void setPSOpenAPI3ParameterMap(Map<String, IPSOpenAPI3Parameter> psOpenAPI3ParameterMap) {
        this.psOpenAPI3ParameterMap = psOpenAPI3ParameterMap;
    }

    @Override
    public String getModelType() {
        return "PSOPENAPI3PATH$" + this.getPSJsonNodeOwner().getModelType();
    }
}

