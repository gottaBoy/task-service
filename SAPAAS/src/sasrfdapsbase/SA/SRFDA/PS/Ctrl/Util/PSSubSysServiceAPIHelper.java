/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.codelist.DESAModeCodeListModel
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEField
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADERS
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetail
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.Util;

import SA.SRFDA.PS.Core.Util.FileWriterHelper2;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.DESAModeCodeListModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEField;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADERS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubSysServiceAPIHelper {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIHelper.class);
    private static String[] METHODS = new String[]{"POST", "GET", "PUT", "DELETE", "HEAD", "PATCH", "OPTIONS", "TRACE"};
    private static HashMap<String, Integer> SIMPLEMAP = new HashMap();

    static {
        SIMPLEMAP.put("object", 0);
        SIMPLEMAP.put("int", 9);
        SIMPLEMAP.put("integer", 9);
        SIMPLEMAP.put("double", 6);
        SIMPLEMAP.put("decimal", 6);
        SIMPLEMAP.put("long", 1);
        SIMPLEMAP.put("string", 25);
        SIMPLEMAP.put("boolean", 3);
    }

    public static void main(String[] args) {
        PSSubSysServiceAPI psSubSysServiceAPI = new PSSubSysServiceAPI();
        psSubSysServiceAPI.setServicePath("http://172.16.102.5:58003/api");
        try {
            String strModel = FileWriterHelper2.readFile("C:\\Users\\lionlau\\Desktop\\api-docs.json");
            HashMap<String, PSSubSysSADE> psSubSysSADEMap = new HashMap<String, PSSubSysSADE>();
            HashMap<String, PSSubSysSADEField> psSubSysSADEFieldMap = new HashMap<String, PSSubSysSADEField>();
            HashMap<String, PSSubSysSADERS> psSubSysSADERSMap = new HashMap<String, PSSubSysSADERS>();
            HashMap<String, PSSubSysSADetail> psSubSysSADetailMap = new HashMap<String, PSSubSysSADetail>();
            PSSubSysServiceAPIHelper psSubSysServiceAPIHelper = new PSSubSysServiceAPIHelper();
            psSubSysServiceAPIHelper.importSwaggerV2(strModel, psSubSysServiceAPI, psSubSysSADEMap, psSubSysSADEFieldMap, psSubSysSADERSMap, psSubSysSADetailMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void importSwaggerV2(String strModel, PSSubSysServiceAPI last, Map<String, PSSubSysSADE> psSubSysSADEMap, Map<String, PSSubSysSADEField> psSubSysSADEFieldMap, Map<String, PSSubSysSADERS> psSubSysSADERSMap, Map<String, PSSubSysSADetail> psSubSysSADetailMap) throws Exception {
        ObjectNode definitions;
        Iterator names;
        JsonNode definitionsNode;
        PSSubSysSADetail psSubSysSADetail;
        ObjectNode paths;
        Iterator names2;
        JsonNode pathsNode;
        String strPath;
        ObjectNode jsonObject = null;
        try {
            jsonObject = (ObjectNode)JsonNodeHelper.fromString((String)strModel);
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.format((String)"\u4f20\u5165\u6a21\u578b\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c%1$s", (Object)ex.getMessage()), ex);
        }
        String host = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"host", null);
        String basePath = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"basePath", null);
        String string = strPath = host == null ? "" : host;
        if (basePath != null) {
            strPath = String.valueOf(strPath) + basePath;
        }
        String strReplaceContent = "";
        int nPos = last.getServicePath().indexOf(strPath);
        if (nPos != -1) {
            strReplaceContent = last.getServicePath().substring(nPos + strPath.length());
        }
        if (strReplaceContent.length() == 0 || strReplaceContent.charAt(0) != '/') {
            strReplaceContent = "/" + strReplaceContent;
        }
        if ((pathsNode = jsonObject.get("paths")) instanceof ObjectNode && (names2 = (paths = (ObjectNode)pathsNode).fieldNames()) != null) {
            while (names2.hasNext()) {
                ObjectNode pathNode;
                String strName2;
                String strName = (String)names2.next();
                String string2 = strName2 = strName.replace(strReplaceContent, "");
                if (strName2.length() > 0 && strName2.charAt(0) == '/') {
                    strName2 = strName2.substring(1);
                }
                if ((psSubSysSADetail = this.parseSwaggerV2Path(strName2, pathNode = (ObjectNode)paths.get(strName), true, last, psSubSysSADEMap, psSubSysSADEFieldMap, psSubSysSADERSMap, psSubSysSADetailMap)) == null) continue;
                psSubSysSADetail.setServiceUrl(string2);
                psSubSysSADetailMap.put(string2, psSubSysSADetail);
            }
        }
        if ((definitionsNode = jsonObject.get("definitions")) instanceof ObjectNode && (names = (definitions = (ObjectNode)definitionsNode).fieldNames()) != null) {
            while (names.hasNext()) {
                String strName = (String)names.next();
                ObjectNode objectNode = (ObjectNode)definitions.get(strName);
                this.parseSwaggerV2Definition(strName, objectNode, last, psSubSysSADEMap, psSubSysSADEFieldMap, psSubSysSADERSMap, psSubSysSADetailMap);
            }
        }
        for (Map.Entry<String, PSSubSysSADE> entry : psSubSysSADEMap.entrySet()) {
            PSSubSysSADE psSubSysSADE = entry.getValue();
            System.out.println(String.format("\u63a5\u53e3\u5bf9\u8c61[%1$s][%2$s]", psSubSysSADE.getPSSubSysSADEName(), psSubSysSADE.getMajorFlag()));
            System.out.println(String.format("\u5c5e\u6027\u96c6\u5408", new Object[0]));
            for (Map.Entry<String, PSSubSysSADEField> entry2 : psSubSysSADEFieldMap.entrySet()) {
                PSSubSysSADEField psSubSysSADEField = entry2.getValue();
                if (StringHelper.compare((String)psSubSysSADEField.getPSSubSysSADEId(), (String)psSubSysSADE.getPSSubSysSADEId(), (boolean)false) != 0) continue;
                System.out.println(String.format("\t\u5c5e\u6027[%1$s][%2$s][%3$s]", psSubSysSADEField.getPSSubSysSADEFieldName(), psSubSysSADEField.getStdDataType(), psSubSysSADEField.getMemo()));
            }
            System.out.println(String.format("\u5173\u7cfb\u96c6\u5408", new Object[0]));
            for (Map.Entry<String, PSSubSysSADEField> entry3 : psSubSysSADERSMap.entrySet()) {
                PSSubSysSADERS psSubSysSADERS = (PSSubSysSADERS)entry3.getValue();
                if (StringHelper.compare((String)psSubSysSADERS.getPPSSubSysSADEId(), (String)psSubSysSADE.getPSSubSysSADEId(), (boolean)false) != 0) continue;
                System.out.println(String.format("\t\u4ece\u5173\u7cfb[%1$s][%2$s]", psSubSysSADERS.getCPSSubSysSADEName(), psSubSysSADERS.getCodeName()));
            }
            System.out.println(String.format("\u65b9\u6cd5\u96c6\u5408", new Object[0]));
            for (Map.Entry<String, PSSubSysSADEField> entry4 : psSubSysSADetailMap.entrySet()) {
                psSubSysSADetail = (PSSubSysSADetail)entry4.getValue();
                if (StringHelper.compare((String)psSubSysSADetail.getPSSubSysSADEId(), (String)psSubSysSADE.getPSSubSysSADEId(), (boolean)false) != 0) continue;
                System.out.println(String.format("\t\u65b9\u6cd5[%1$s][%2$s]", psSubSysSADetail.getPSSubSysSADetailName(), psSubSysSADetail.getServiceUrl()));
            }
        }
    }

    protected PSSubSysSADetail parseSwaggerV2Path(String strName, ObjectNode pathNode, boolean bMajor, PSSubSysServiceAPI last, Map<String, PSSubSysSADE> psSubSysSADEMap, Map<String, PSSubSysSADEField> psSubSysSADEFieldMap, Map<String, PSSubSysSADERS> psSubSysSADERSMap, Map<String, PSSubSysSADetail> psSubSysSADetailMap) throws Exception {
        String[] parts = strName.split("[/]");
        if (parts.length == 0) {
            log.error((Object)String.format("\u670d\u52a1\u8def\u5f84[%1$s]\u65e0\u6548", strName));
            return null;
        }
        String strDEName = parts[0];
        if (StringHelper.isNullOrEmpty((String)strDEName)) {
            log.error((Object)String.format("\u670d\u52a1\u5b9e\u4f53\u540d\u79f0\u65e0\u6548", strDEName));
            return null;
        }
        PSSubSysSADE psSubSysSADE = psSubSysSADEMap.get(strDEName);
        if (psSubSysSADE == null) {
            psSubSysSADE = new PSSubSysSADE();
            psSubSysSADE.setPSSubSysSADEId(strDEName);
            psSubSysSADE.setPSSubSysSADEName(strDEName);
            psSubSysSADEMap.put(strDEName, psSubSysSADE);
        }
        psSubSysSADE.setMajorFlag(Integer.valueOf(1));
        if (parts.length <= 1) {
            log.error((Object)String.format("\u670d\u52a1\u8def\u5f84[%1$s]\u65e0\u6548\uff0c\u65e0\u6cd5\u8fdb\u4e00\u6b65\u5224\u65ad", strName));
            return null;
        }
        String strMethodName = "";
        String strPart2 = parts[1];
        if (strPart2.indexOf("{") != 0) {
            strMethodName = strPart2;
        }
        if (StringHelper.isNullOrEmpty((String)strMethodName)) {
            int cfr_ignored_0 = parts.length;
            return null;
        }
        return this.parseSwaggerV2Method(strMethodName, pathNode, psSubSysSADE, last, psSubSysSADEMap, psSubSysSADEFieldMap, psSubSysSADERSMap, psSubSysSADetailMap);
    }

    protected PSSubSysSADetail parseSwaggerV2Method(String strName, ObjectNode methodNode, PSSubSysSADE psSubSysSADE, PSSubSysServiceAPI last, Map<String, PSSubSysSADE> psSubSysSADEMap, Map<String, PSSubSysSADEField> psSubSysSADEFieldMap, Map<String, PSSubSysSADERS> psSubSysSADERSMap, Map<String, PSSubSysSADetail> psSubSysSADetailMap) throws Exception {
        ObjectNode response200Node;
        ObjectNode responsesNode;
        JsonNode response200;
        JsonNode responses;
        String originalRef;
        String ref;
        ObjectNode schemaBody;
        JsonNode schema;
        ObjectNode methodParam = null;
        String method = null;
        String[] stringArray = METHODS;
        int n = METHODS.length;
        int n2 = 0;
        while (n2 < n) {
            String strMethod = stringArray[n2];
            JsonNode jsonNode = methodNode.get(strMethod.toLowerCase());
            if (jsonNode instanceof ObjectNode) {
                method = strMethod;
                methodParam = (ObjectNode)jsonNode;
                break;
            }
            ++n2;
        }
        if (methodParam == null) {
            log.error((Object)String.format("\u8282\u70b9[%1$s]\u672a\u6307\u5b9a\u65b9\u6cd5\u53c2\u6570", methodNode.toString()));
            return null;
        }
        PSSubSysSADetail psSubSysSADetail = new PSSubSysSADetail();
        String summary = JsonNodeHelper.getString(methodParam, (String)"summary", null);
        String operationId = JsonNodeHelper.getString(methodParam, (String)"operationId", null);
        psSubSysSADetail.setPSSubSysSADetailId(operationId);
        psSubSysSADetail.setMemo(summary);
        psSubSysSADetail.setPSSubSysSADetailName(strName);
        psSubSysSADetail.setPSSubSysSADEId(psSubSysSADE.getPSSubSysSADEId());
        psSubSysSADetail.setPSSubSysSADEName(psSubSysSADE.getPSSubSysSADEName());
        JsonNode parameters = methodParam.get("parameters");
        if (parameters instanceof ArrayNode) {
            ObjectNode parametersBody = null;
            ArrayNode arrayNode = (ArrayNode)parameters;
            if (arrayNode.size() > 0 && arrayNode.get(0) instanceof ObjectNode) {
                parametersBody = (ObjectNode)arrayNode.get(0);
            }
            if (parametersBody == null) {
                log.error((Object)String.format("\u8282\u70b9[%1$s]\u672a\u6307\u5b9a\u53c2\u6570\u5185\u5bb9", methodNode.toString()));
                return null;
            }
            String in = JsonNodeHelper.getString(parametersBody, (String)"in", null);
            String name = JsonNodeHelper.getString((ObjectNode)parametersBody, (String)"dto", null);
            schema = parametersBody.get("schema");
            if (schema instanceof ObjectNode) {
                psSubSysSADetail.setRequestParamType("ENTITY");
                schemaBody = (ObjectNode)schema;
                ref = JsonNodeHelper.getString((ObjectNode)schemaBody, (String)"$ref", null);
                originalRef = JsonNodeHelper.getString((ObjectNode)schemaBody, (String)"originalRef", null);
                if (!StringHelper.isNullOrEmpty((String)ref)) {
                    PSSubSysSADE inPSSubSysSADE = psSubSysSADEMap.get(ref);
                    if (inPSSubSysSADE == null) {
                        inPSSubSysSADE = new PSSubSysSADE();
                        inPSSubSysSADE.setPSSubSysSADEId(ref);
                        inPSSubSysSADE.setPSSubSysSADEName(originalRef);
                        inPSSubSysSADE.setMajorFlag(DESAModeCodeListModel.NESTED);
                        psSubSysSADEMap.put(ref, inPSSubSysSADE);
                    }
                    psSubSysSADetail.setInPSSubSysSADEId(inPSSubSysSADE.getPSSubSysSADEId());
                    psSubSysSADetail.setInPSSubSysSADEName(inPSSubSysSADE.getPSSubSysSADEName());
                }
            }
        }
        if ((responses = methodParam.get("responses")) instanceof ObjectNode && (response200 = (responsesNode = (ObjectNode)responses).get("200")) instanceof ObjectNode && (schema = (response200Node = (ObjectNode)response200).get("schema")) instanceof ObjectNode) {
            Integer nSimpleType;
            String strRealOriginalRef;
            String[] items;
            schemaBody = (ObjectNode)schema;
            ref = JsonNodeHelper.getString((ObjectNode)schemaBody, (String)"$ref", null);
            originalRef = JsonNodeHelper.getString((ObjectNode)schemaBody, (String)"originalRef", null);
            String realOriginalRef = null;
            boolean bArray = false;
            boolean bPage = false;
            if (!StringHelper.isNullOrEmpty((String)originalRef) && (items = (strRealOriginalRef = originalRef.replace("\u00ab", "|").replace("\u00bb", "")).split("[|]")).length > 1) {
                realOriginalRef = items[items.length - 1];
                int i = 0;
                while (i < items.length - 1) {
                    if (StringHelper.compare((String)"Page", (String)items[i], (boolean)true) == 0) {
                        bPage = true;
                        break;
                    }
                    if (StringHelper.compare((String)"List", (String)items[i], (boolean)true) == 0) {
                        bArray = true;
                        break;
                    }
                    ++i;
                }
            }
            if (StringHelper.isNullOrEmpty(realOriginalRef)) {
                realOriginalRef = originalRef;
            }
            if ((nSimpleType = SIMPLEMAP.get(realOriginalRef.toLowerCase())) == null) {
                String realRef = String.format("#/definitions/%1$s", realOriginalRef);
                PSSubSysSADE inPSSubSysSADE = psSubSysSADEMap.get(realRef);
                if (inPSSubSysSADE == null) {
                    inPSSubSysSADE = new PSSubSysSADE();
                    inPSSubSysSADE.setPSSubSysSADEId(realRef);
                    inPSSubSysSADE.setPSSubSysSADEName(realOriginalRef);
                    inPSSubSysSADE.setMajorFlag(DESAModeCodeListModel.NESTED);
                    psSubSysSADEMap.put(realRef, inPSSubSysSADE);
                }
                psSubSysSADetail.setOutPSSubSysSADEId(inPSSubSysSADE.getPSSubSysSADEId());
                psSubSysSADetail.setOutPSSubSysSADEName(inPSSubSysSADE.getPSSubSysSADEName());
                if (bPage) {
                    psSubSysSADetail.setRetValType("PAGE");
                } else if (bArray) {
                    psSubSysSADetail.setRetValType("ENTITIES");
                } else {
                    psSubSysSADetail.setRetValType("ENTITY");
                }
            } else {
                psSubSysSADetail.setRetStdDataType(nSimpleType);
                if (bArray) {
                    psSubSysSADetail.setRetValType("SIMPLES");
                } else {
                    psSubSysSADetail.setRetValType("SIMPLE");
                }
            }
        }
        return psSubSysSADetail;
    }

    protected PSSubSysSADE parseSwaggerV2Definition(String strName, ObjectNode definitionNode, PSSubSysServiceAPI last, Map<String, PSSubSysSADE> psSubSysSADEMap, Map<String, PSSubSysSADEField> psSubSysSADEFieldMap, Map<String, PSSubSysSADERS> psSubSysSADERSMap, Map<String, PSSubSysSADetail> psSubSysSADetailMap) throws Exception {
        JsonNode properties;
        String strTitle;
        if (StringHelper.isNullOrEmpty((String)strName)) {
            return null;
        }
        String strOriginalRef = strName;
        String strRealOriginalRef = strOriginalRef.replace("\u00ab", "|").replace("\u00bb", "");
        String[] paths = strRealOriginalRef.split("[|]");
        if (paths.length > 1) {
            return null;
        }
        String strType = JsonNodeHelper.getString((ObjectNode)definitionNode, (String)"type", null);
        if (StringHelper.compare((String)strType, (String)"object", (boolean)true) != 0) {
            return null;
        }
        String realRef = String.format("#/definitions/%1$s", strName);
        PSSubSysSADE psSubSysSADE = psSubSysSADEMap.get(realRef);
        if (psSubSysSADE == null) {
            psSubSysSADE = new PSSubSysSADE();
            psSubSysSADE.setPSSubSysSADEId(realRef);
            psSubSysSADE.setPSSubSysSADEName(strName);
            psSubSysSADE.setMajorFlag(DESAModeCodeListModel.NESTED);
            psSubSysSADEMap.put(realRef, psSubSysSADE);
        }
        if (!StringHelper.isNullOrEmpty((String)(strTitle = JsonNodeHelper.getString((ObjectNode)definitionNode, (String)"title", null)))) {
            strTitle = strTitle.replace("\u00ab", "|").replace("\u00bb", "");
        }
        psSubSysSADE.setMemo(strTitle);
        HashMap<String, String> requiredMap = null;
        JsonNode required = definitionNode.get("required");
        if (required instanceof ArrayNode) {
            requiredMap = new HashMap<String, String>();
            ArrayNode arrayNode = (ArrayNode)required;
            int i = 0;
            while (i < arrayNode.size()) {
                String strField = arrayNode.get(i).asText();
                requiredMap.put(strField, "");
                ++i;
            }
        }
        if ((properties = definitionNode.get("properties")) != null) {
            int nOrderValue = 100;
            Iterator names = properties.fieldNames();
            if (names != null) {
                while (names.hasNext()) {
                    Integer nStdDataType;
                    String strFieldName = (String)names.next();
                    ObjectNode propertyNode = (ObjectNode)properties.get(strFieldName);
                    String strFieldType = JsonNodeHelper.getString((ObjectNode)propertyNode, (String)"type", null);
                    if (StringHelper.isNullOrEmpty((String)strFieldType)) {
                        log.error((Object)String.format("\u5bf9\u8c61[%1$s]\u5c5e\u6027[%2$s]\u672a\u6307\u5b9a\u7c7b\u578b", psSubSysSADE.getPSSubSysSADEName(), strFieldName));
                        continue;
                    }
                    String strDescription = JsonNodeHelper.getString((ObjectNode)propertyNode, (String)"description", null);
                    boolean bArray = false;
                    if (StringHelper.compare((String)strFieldType, (String)"array", (boolean)true) == 0) {
                        bArray = true;
                        JsonNode items = propertyNode.get("items");
                        if (items instanceof ObjectNode) {
                            ObjectNode itemsNode = (ObjectNode)items;
                            String ref = JsonNodeHelper.getString((ObjectNode)itemsNode, (String)"$ref", null);
                            String originalRef = JsonNodeHelper.getString((ObjectNode)itemsNode, (String)"originalRef", null);
                            if (!StringHelper.isNullOrEmpty((String)ref) && !StringHelper.isNullOrEmpty((String)originalRef)) {
                                String strRSTag;
                                PSSubSysSADERS psSubSysSADERS;
                                PSSubSysSADE refPSSubSysSADE = psSubSysSADEMap.get(ref);
                                if (refPSSubSysSADE == null) {
                                    refPSSubSysSADE = new PSSubSysSADE();
                                    refPSSubSysSADE.setPSSubSysSADEId(ref);
                                    refPSSubSysSADE.setPSSubSysSADEName(originalRef);
                                    refPSSubSysSADE.setMajorFlag(DESAModeCodeListModel.NESTED);
                                    psSubSysSADEMap.put(ref, refPSSubSysSADE);
                                }
                                if ((psSubSysSADERS = psSubSysSADERSMap.get(strRSTag = String.format("%1$s|%2$s", psSubSysSADE.getPSSubSysSADEId(), refPSSubSysSADE.getPSSubSysSADEId()))) != null) continue;
                                psSubSysSADERS = new PSSubSysSADERS();
                                psSubSysSADERS.setPSSubSysSADERSId(strRSTag);
                                psSubSysSADERS.setPSSubSysSADERSName(String.format("%1$s_%2$s", psSubSysSADE.getPSSubSysSADEName(), refPSSubSysSADE.getPSSubSysSADEName()));
                                psSubSysSADERS.setPPSSubSysSADEId(psSubSysSADE.getPSSubSysSADEId());
                                psSubSysSADERS.setPPSSubSysSADEName(psSubSysSADE.getPSSubSysSADEName());
                                psSubSysSADERS.setCPSSubSysSADEId(refPSSubSysSADE.getPSSubSysSADEId());
                                psSubSysSADERS.setCPSSubSysSADEName(refPSSubSysSADE.getPSSubSysSADEName());
                                psSubSysSADERS.setCodeName(strFieldName);
                                psSubSysSADERSMap.put(strRSTag, psSubSysSADERS);
                                continue;
                            }
                            strFieldType = JsonNodeHelper.getString((ObjectNode)itemsNode, (String)"type", null);
                            if (StringHelper.isNullOrEmpty((String)strFieldType)) {
                                log.error((Object)String.format("\u5bf9\u8c61[%1$s]\u5c5e\u6027[%2$s]\u672a\u6307\u5b9a\u6570\u7ec4\u7684\u7c7b\u578b", psSubSysSADE.getPSSubSysSADEName(), strFieldName));
                                continue;
                            }
                        }
                    }
                    if ((nStdDataType = SIMPLEMAP.get(strFieldType.toLowerCase())) == null) {
                        log.error((Object)String.format("\u5bf9\u8c61[%1$s]\u5c5e\u6027[%2$s]\u7c7b\u578b[%3$s]\u65e0\u6cd5\u8bc6\u522b", psSubSysSADE.getPSSubSysSADEName(), strFieldName, strFieldType));
                        nStdDataType = 0;
                    }
                    nOrderValue += 100;
                    String strFieldTag = String.format("%1$s|%2$s", psSubSysSADE.getPSSubSysSADEId(), strFieldName);
                    PSSubSysSADEField psSubSysSADEField = new PSSubSysSADEField();
                    psSubSysSADEField.setPSSubSysSADEFieldId(strFieldTag);
                    psSubSysSADEField.setPSSubSysSADEFieldName(strFieldName);
                    psSubSysSADEField.setPSSubSysSADEId(psSubSysSADE.getPSSubSysSADEId());
                    psSubSysSADEField.setPSSubSysSADEName(psSubSysSADE.getPSSubSysSADEName());
                    psSubSysSADEField.setCodeName(strFieldName);
                    psSubSysSADEField.setStdDataType(nStdDataType);
                    if (requiredMap != null) {
                        psSubSysSADEField.setAllowEmpty(Integer.valueOf(!requiredMap.containsKey(strFieldName) ? 1 : 0));
                    }
                    psSubSysSADEField.setOrderValue(Integer.valueOf(nOrderValue));
                    psSubSysSADEField.setMemo(strDescription);
                    psSubSysSADEFieldMap.put(strFieldTag, psSubSysSADEField);
                }
            }
        }
        return psSubSysSADE;
    }
}

