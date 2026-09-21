/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.DEField.PSDEFieldExporter;
import SA.SRFDA.PS.Core.DEField.SimplePSDEFieldExporter;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionExporter;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERExporter;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataSetExporter;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityExporter;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEServiceAPIExporter;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEServiceAPIMethodExporter;
import SA.SRFDA.PS.Core.DataEntity.SimplePSDataEntityExporter;
import SA.SRFDA.PS.Core.IPSModelExporter;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.Service.PSSysServiceAPIExporter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSModelExporter {
    private static HashMap<String, IPSModelExporter> psModelExporterMap = new HashMap();

    static {
        psModelExporterMap.put("PSSYSSERVICEAPI", new PSSysServiceAPIExporter());
        psModelExporterMap.put("PSDESERVICEAPI", new PSDEServiceAPIExporter());
        psModelExporterMap.put("PSDESADETAIL", new PSDEServiceAPIMethodExporter());
        psModelExporterMap.put("PSDATAENTITY", new PSDataEntityExporter());
        psModelExporterMap.put("PSDATAENTITY|SIMPLE", new SimplePSDataEntityExporter());
        psModelExporterMap.put("PSDEFIELD", new PSDEFieldExporter());
        psModelExporterMap.put("PSDEFIELD|SIMPLE", new SimplePSDEFieldExporter());
        psModelExporterMap.put("PSDER", new PSDERExporter());
        psModelExporterMap.put("PSDER_DER11", new PSDERExporter());
        psModelExporterMap.put("PSDER_DER1N", new PSDERExporter());
        psModelExporterMap.put("PSDER_DERINDEX", new PSDERExporter());
        psModelExporterMap.put("PSDER_DERINHERIT", new PSDERExporter());
        psModelExporterMap.put("PSDER_DERMULINH", new PSDERExporter());
        psModelExporterMap.put("PSDEACTION", new PSDEActionExporter());
        psModelExporterMap.put("PSDEDATASET", new PSDEDataSetExporter());
    }

    public static ObjectNode toJsonObject(IPSModelObject iPSModelObject) throws Exception {
        return PSModelExporter.toJsonObject(null, iPSModelObject, null);
    }

    public static ObjectNode toJsonObject(IPSModelObject iPSModelObject, String strMode) throws Exception {
        return PSModelExporter.toJsonObject(null, iPSModelObject, strMode);
    }

    public static ObjectNode toJsonObject(ObjectNode objectNode, IPSModelObject iPSModelObject, String strMode) throws Exception {
        String strModelType;
        if (objectNode == null) {
            objectNode = JsonNodeHelper.createObjectNode();
        }
        IPSModelExporter iPSModelExporter = null;
        String strModelTag = strModelType = iPSModelObject.getModelType();
        if (!StringHelper.isNullOrEmpty((String)strMode)) {
            strModelTag = String.valueOf(strModelTag) + "|" + strMode;
        }
        if ((iPSModelExporter = psModelExporterMap.get(strModelTag)) == null) {
            if (!StringHelper.isNullOrEmpty((String)strMode)) {
                iPSModelExporter = psModelExporterMap.get(strModelType);
            }
            if (iPSModelExporter == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7c7b\u578b\u4e3a[%1$s]\u7684\u6a21\u578b\u5bfc\u51fa\u5bf9\u8c61", (Object)strModelTag));
            }
        }
        return iPSModelExporter.toJsonObject(objectNode, iPSModelObject, strMode);
    }
}

