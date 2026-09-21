/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelExporter;
import SA.SRFDA.PS.Core.PSModelExporterBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

@PSModelIgnoreMeta
public class PSDEServiceAPIMethodExporter
extends PSModelExporterBase {
    public static final String ATTR_METHODTYPE = "methodtype";
    public static final String ATTR_REQUESTMETHOD = "requestmethod";
    public static final String ATTR_REQUESTPATH = "requestpath";
    public static final String ATTR_DEACTION = "deaction";
    public static final String ATTR_DEDATASET = "dedataset";

    @Override
    protected void onFillJsonObject(ObjectNode objectNode, IPSModelObject iPSModelObject, String strMode) throws Exception {
        IPSDEServiceAPIMethod iPSDEServiceAPIMethod = (IPSDEServiceAPIMethod)iPSModelObject;
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_METHODTYPE, (Object)iPSDEServiceAPIMethod.getMethodType());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"codename", (Object)iPSDEServiceAPIMethod.getCodeName());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_REQUESTMETHOD, (Object)iPSDEServiceAPIMethod.getPSRESTfulAPI().getRequestMethod());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_REQUESTPATH, (Object)iPSDEServiceAPIMethod.getPSRESTfulAPI().getRequestPath());
        if (StringHelper.compare((String)iPSDEServiceAPIMethod.getMethodType(), (String)"DEACTION", (boolean)true) == 0) {
            ObjectNode deactionNode = PSModelExporter.toJsonObject(iPSDEServiceAPIMethod.getPSDEAction(), "SIMPLE");
            JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_DEACTION, (Object)deactionNode);
        } else if (StringHelper.compare((String)iPSDEServiceAPIMethod.getMethodType(), (String)"FETCH", (boolean)true) == 0 || StringHelper.compare((String)iPSDEServiceAPIMethod.getMethodType(), (String)"FETCHTEMP", (boolean)true) == 0) {
            ObjectNode dedatasetNode = PSModelExporter.toJsonObject(iPSDEServiceAPIMethod.getPSDEDataSet(), "SIMPLE");
            JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_DEDATASET, (Object)dedatasetNode);
        }
        super.onFillJsonObject(objectNode, iPSModelObject, strMode);
    }
}

