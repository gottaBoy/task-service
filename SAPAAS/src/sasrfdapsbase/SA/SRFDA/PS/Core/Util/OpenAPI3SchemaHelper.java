/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInputDTO;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEFilterDTO;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OpenAPI3SchemaHelper {
    private static final Log log = LogFactory.getLog(OpenAPI3SchemaHelper.class);
    private static ObjectMapper objMapper = new ObjectMapper();
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_REF = "$ref";
    public static final String FIELD_CONTENT = "content";
    public static final String FIELD_JSONSCHEMA = "schema";
    public static final String FIELD_JSONSCHEMAS = "schemas";
    public static final String FIELD_SCHEMA_COMPONENTS = "components";
    public static final String FIELD_SCHEMA_PATHS = "paths";
    public static final String FIELD_SCHEMA_TAGS = "tags";
    public static final String FIELD_SCHEMA_INFO = "info";
    public static final String FIELD_PATH_SUMMARY = "summary";
    public static final String FIELD_PATH_TAGS = "tags";
    public static final String FIELD_PATH_GET = "get";
    public static final String FIELD_PATH_PUT = "put";
    public static final String FIELD_PATH_POST = "post";
    public static final String FIELD_PATH_DELETE = "delete";
    public static final String FIELD_PATH_OPTIONS = "options";
    public static final String FIELD_PATH_HEADER = "header";
    public static final String FIELD_PATH_PATCH = "patch";
    public static final String FIELD_PATH_TRACE = "trace";
    public static final String FIELD_PATH_PARAMETERS = "parameters";
    public static final String FIELD_PATH_OPERATIONID = "operationId";
    public static final String FIELD_PATH_REQUESTBODY = "requestBody";
    public static final String FIELD_PATH_RESPONSES = "responses";
    public static final String FIELD_PARAMETER_REQUIRED = "required";
    public static final String FIELD_PARAMETER_SCHEMA = "schema";
    public static final String FIELD_PARAMETER_IN = "in";
    public static final String FIELD_JSONSCHEMA_REF = "$ref";
    public static final String FIELD_JSONSCHEMA_TYPE = "type";
    public static final String FIELD_JSONSCHEMA_PROPERTIES = "properties";
    public static final String FIELD_JSONSCHEMA_ITEMS = "items";
    public static final String TYPE_JSONSCHEMA_NULL = "null";
    public static final String TYPE_JSONSCHEMA_BOOLEAN = "boolean";
    public static final String TYPE_JSONSCHEMA_OBJECT = "object";
    public static final String TYPE_JSONSCHEMA_ARRAY = "array";
    public static final String TYPE_JSONSCHEMA_NUMBER = "number";
    public static final String TYPE_JSONSCHEMA_INTEGER = "integer";
    public static final String TYPE_JSONSCHEMA_STRING = "string";
    public static final String TYPE_JSONSCHEMA_UNKNOWN = "unknown";
    private IPSSysServiceAPI iPSSysServiceAPI = null;
    private Map<String, ObjectNode> tagNodeMap = new TreeMap<String, ObjectNode>();
    private Map<String, ObjectNode> componentNodeMap = new LinkedHashMap<String, ObjectNode>();
    private Map<String, ObjectNode> pathNodeMap = new LinkedHashMap<String, ObjectNode>();

    public OpenAPI3SchemaHelper(IPSSysServiceAPI iPSSysServiceAPI) {
        this.iPSSysServiceAPI = iPSSysServiceAPI;
    }

    protected IPSSysServiceAPI getPSSysServiceAPI() {
        return this.iPSSysServiceAPI;
    }

    public ObjectNode export() throws Exception {
        this.tagNodeMap.clear();
        this.pathNodeMap.clear();
        this.componentNodeMap.clear();
        this.onExport();
        ObjectNode apiNode = JsonNodeHelper.createObjectNode();
        apiNode.put("openapi", "3.0.3");
        ObjectNode infoNode = apiNode.putObject(FIELD_SCHEMA_INFO);
        infoNode.put("title", this.getPSSysServiceAPI().getName());
        infoNode.put("version", "1.0");
        ArrayNode tagsNode = apiNode.putArray("tags");
        for (Map.Entry<String, ObjectNode> entry : this.tagNodeMap.entrySet()) {
            tagsNode.add((JsonNode)entry.getValue());
        }
        ObjectNode pathsNode = apiNode.putObject(FIELD_SCHEMA_PATHS);
        for (Map.Entry<String, ObjectNode> entry : this.pathNodeMap.entrySet()) {
            pathsNode.put(entry.getKey(), (JsonNode)entry.getValue());
        }
        ObjectNode componentsNode = apiNode.putObject(FIELD_SCHEMA_COMPONENTS);
        ObjectNode schemasNode = componentsNode.putObject(FIELD_JSONSCHEMAS);
        for (Map.Entry<String, ObjectNode> entry : this.componentNodeMap.entrySet()) {
            schemasNode.put(entry.getKey(), (JsonNode)entry.getValue());
        }
        return apiNode;
    }

    /*
     * Unable to fully structure code
     */
    protected void onExport() throws Exception {
        psDEServiceAPIs = this.getPSSysServiceAPI().getPSDEServiceAPIs();
        if (psDEServiceAPIs != null) ** GOTO lbl7
        return;
lbl-1000:
        // 1 sources

        {
            iPSDEServiceAPI = psDEServiceAPIs.next();
            if (iPSDEServiceAPI.getAPIMode() != 1 && iPSDEServiceAPI.getAPIMode() != 0) continue;
            this.registerPSDEServiceAPIMapping(iPSDEServiceAPI);
lbl7:
            // 3 sources

            ** while (psDEServiceAPIs.hasNext())
        }
lbl8:
        // 1 sources

    }

    protected void registerPSDEServiceAPIMapping(IPSDEServiceAPI iPSDEServiceAPI) throws Exception {
        Object iPSDEServiceAPIMethod;
        Iterator<IPSDEServiceAPIMethod> psDEServiceAPIMethods;
        String strAPICodeName = this.getPSSysServiceAPI().getCodeName().toLowerCase();
        String strCurId = iPSDEServiceAPI.getId();
        Iterator<IPSDEServiceAPIRS> psDEServiceAPIRSs = this.getPSSysServiceAPI().getPSDEServiceAPIRSs();
        if (psDEServiceAPIRSs != null) {
            while (psDEServiceAPIRSs.hasNext()) {
                String strRequestPath;
                Iterator<IPSDEServiceAPIMethod> psDEServiceAPIMethods2;
                IPSDEServiceAPIRS iPSDEServiceAPIRS = psDEServiceAPIRSs.next();
                if (!iPSDEServiceAPIRS.getMinorPSDEServiceAPI().getId().equals(strCurId) || (psDEServiceAPIMethods2 = iPSDEServiceAPIRS.getPSDEServiceAPIMethods()) == null) continue;
                IPSDEServiceAPI majorPSDEServiceAPI = iPSDEServiceAPIRS.getMajorPSDEServiceAPI();
                String strPath = String.format("/%1$s/%2$s/{pkey}/%3$s", strAPICodeName, Inflector.getInstance().pluralize((Object)majorPSDEServiceAPI.getCodeName()).toLowerCase(), Inflector.getInstance().pluralize((Object)iPSDEServiceAPI.getCodeName()).toLowerCase());
                String strPath2 = String.format("/%1$s/**/%2$s/{pkey}/%3$s", strAPICodeName, Inflector.getInstance().pluralize((Object)majorPSDEServiceAPI.getCodeName()).toLowerCase(), Inflector.getInstance().pluralize((Object)iPSDEServiceAPI.getCodeName()).toLowerCase());
                while (psDEServiceAPIMethods2.hasNext()) {
                    String strRequestPath2;
                    IPSDEServiceAPIMethod iPSDEServiceAPIMethod2 = psDEServiceAPIMethods2.next();
                    if ("FETCH".equals(iPSDEServiceAPIMethod2.getMethodType())) {
                        strRequestPath = String.valueOf(strPath) + "/" + iPSDEServiceAPIMethod2.getCodeName().toLowerCase();
                        strRequestPath2 = String.valueOf(strPath2) + "/" + iPSDEServiceAPIMethod2.getCodeName().toLowerCase();
                        if ("POST".equals(iPSDEServiceAPIMethod2.getRequestMethod())) {
                            this.registerMapping(iPSDEServiceAPI, iPSDEServiceAPIRS, iPSDEServiceAPIMethod2, strRequestPath, strRequestPath2);
                            continue;
                        }
                        if (!"GET".equals(iPSDEServiceAPIMethod2.getRequestMethod())) continue;
                        this.registerMapping(iPSDEServiceAPI, iPSDEServiceAPIRS, iPSDEServiceAPIMethod2, strRequestPath, strRequestPath2);
                        continue;
                    }
                    if (!"DEACTION".equals(iPSDEServiceAPIMethod2.getMethodType())) continue;
                    strRequestPath = String.valueOf(strPath) + this.getRequestPath(iPSDEServiceAPIMethod2);
                    strRequestPath2 = String.valueOf(strPath2) + this.getRequestPath(iPSDEServiceAPIMethod2);
                    if ("GET".equals(iPSDEServiceAPIMethod2.getRequestMethod()) || "DELETE".equals(iPSDEServiceAPIMethod2.getRequestMethod())) {
                        if (iPSDEServiceAPIMethod2.isNeedResourceKey()) {
                            this.registerMapping(iPSDEServiceAPI, iPSDEServiceAPIRS, iPSDEServiceAPIMethod2, strRequestPath, strRequestPath2);
                            continue;
                        }
                        this.registerMapping(iPSDEServiceAPI, iPSDEServiceAPIRS, iPSDEServiceAPIMethod2, strRequestPath, strRequestPath2);
                        continue;
                    }
                    if (!"POST".equals(iPSDEServiceAPIMethod2.getRequestMethod()) && !"PUT".equals(iPSDEServiceAPIMethod2.getRequestMethod())) continue;
                    if (iPSDEServiceAPIMethod2.isNeedResourceKey()) {
                        this.registerMapping(iPSDEServiceAPI, iPSDEServiceAPIRS, iPSDEServiceAPIMethod2, strRequestPath, strRequestPath2);
                        continue;
                    }
                    this.registerMapping(iPSDEServiceAPI, iPSDEServiceAPIRS, iPSDEServiceAPIMethod2, strRequestPath, strRequestPath2);
                }
                String strRequestPath2 = String.valueOf(strPath) + "/importtemplate";
                strRequestPath = String.valueOf(strPath2) + "/importtemplate";
                strRequestPath2 = String.valueOf(strPath) + "/exportdata/{param}";
                String strRequestPath22 = String.valueOf(strPath) + "/exportdata/{param}/{key}";
                String strRequestPath3 = String.valueOf(strPath2) + "/exportdata/{param}";
                String string = String.valueOf(strPath2) + "/exportdata/{param}/{key}";
                strRequestPath2 = String.valueOf(strPath) + "/importdata";
                String string2 = String.valueOf(strPath2) + "/importdata";
                strRequestPath2 = String.valueOf(strPath) + "/printdata/{key}";
                string2 = String.valueOf(strPath2) + "/printdata/{key}";
            }
        }
        if ((psDEServiceAPIMethods = iPSDEServiceAPI.getPSDEServiceAPIMethods()) == null) {
            return;
        }
        String strPath = String.format("/%1$s/%2$s", this.getPSSysServiceAPI().getCodeName().toLowerCase(), Inflector.getInstance().pluralize((Object)iPSDEServiceAPI.getCodeName()).toLowerCase());
        while (psDEServiceAPIMethods.hasNext()) {
            String strRequestPath;
            iPSDEServiceAPIMethod = psDEServiceAPIMethods.next();
            if ("FETCH".equals(iPSDEServiceAPIMethod.getMethodType())) {
                strRequestPath = String.valueOf(strPath) + "/" + iPSDEServiceAPIMethod.getCodeName().toLowerCase();
                if ("POST".equals(iPSDEServiceAPIMethod.getRequestMethod())) {
                    this.registerMapping(iPSDEServiceAPI, null, (IPSDEServiceAPIMethod)iPSDEServiceAPIMethod, strRequestPath);
                    continue;
                }
                if ("GET".equals(iPSDEServiceAPIMethod.getRequestMethod())) {
                    this.registerMapping(iPSDEServiceAPI, null, (IPSDEServiceAPIMethod)iPSDEServiceAPIMethod, strRequestPath);
                    continue;
                }
                log.warn((Object)String.format("\u65e0\u6cd5\u6ce8\u518c\uff1aFETCH[%1$s] %2$s", iPSDEServiceAPIMethod.getRequestMethod(), strRequestPath));
                continue;
            }
            if (!"DEACTION".equals(iPSDEServiceAPIMethod.getMethodType())) continue;
            strRequestPath = String.valueOf(strPath) + this.getRequestPath((IPSDEServiceAPIMethod)iPSDEServiceAPIMethod);
            if ("GET".equals(iPSDEServiceAPIMethod.getRequestMethod()) || "DELETE".equals(iPSDEServiceAPIMethod.getRequestMethod())) {
                if (iPSDEServiceAPIMethod.isNeedResourceKey()) {
                    this.registerMapping(iPSDEServiceAPI, null, (IPSDEServiceAPIMethod)iPSDEServiceAPIMethod, strRequestPath);
                    continue;
                }
                this.registerMapping(iPSDEServiceAPI, null, (IPSDEServiceAPIMethod)iPSDEServiceAPIMethod, strRequestPath);
                continue;
            }
            if (!"POST".equals(iPSDEServiceAPIMethod.getRequestMethod()) && !"PUT".equals(iPSDEServiceAPIMethod.getRequestMethod())) continue;
            if (iPSDEServiceAPIMethod.isNeedResourceKey()) {
                this.registerMapping(iPSDEServiceAPI, null, (IPSDEServiceAPIMethod)iPSDEServiceAPIMethod, strRequestPath);
                continue;
            }
            this.registerMapping(iPSDEServiceAPI, null, (IPSDEServiceAPIMethod)iPSDEServiceAPIMethod, strRequestPath);
        }
        iPSDEServiceAPIMethod = String.valueOf(strPath) + "/importtemplate";
        String strRequestPath = String.valueOf(strPath) + "/exportdata/{param}";
        String string = String.valueOf(strPath) + "/exportdata/{param}/{key}";
        String string3 = String.valueOf(strPath) + "/importdata";
        string3 = String.valueOf(strPath) + "/printdata/{key}";
    }

    protected String getRequestPath(IPSDEServiceAPIMethod iPSDEServiceAPIMethod) {
        if (iPSDEServiceAPIMethod.isNeedResourceKey()) {
            if (iPSDEServiceAPIMethod.isNoServiceCodeName()) {
                return "/{key}";
            }
            return "/{key}/" + iPSDEServiceAPIMethod.getCodeName().toLowerCase();
        }
        if (iPSDEServiceAPIMethod.isNoServiceCodeName()) {
            return "";
        }
        return "/" + iPSDEServiceAPIMethod.getCodeName().toLowerCase();
    }

    protected void registerMapping(IPSDEServiceAPI iPSDEServiceAPI, IPSDEServiceAPIRS iPSDEServiceAPIRS, IPSDEServiceAPIMethod iPSDEServiceAPIMethod, String ... paths) throws Exception {
        String description;
        String summary;
        String strSysTag = this.getPSSysServiceAPI().getPSSystem().getName();
        String strApiTag = this.getPSSysServiceAPI().getCodeName();
        String strTag = String.format("%1$s-%2$s-controller", strApiTag, iPSDEServiceAPI.getCodeName()).toLowerCase();
        if (!this.tagNodeMap.containsKey(strTag)) {
            String strApiDesc;
            String strSysDesc;
            String strDesc = iPSDEServiceAPI.getLogicName();
            if (StringHelper.isNullOrEmpty((String)strDesc)) {
                strDesc = iPSDEServiceAPI.getPSDataEntity().getLogicName();
            }
            if (StringHelper.isNullOrEmpty((String)(strSysDesc = this.getPSSysServiceAPI().getPSSystem().getLogicName()))) {
                strSysDesc = strSysTag;
            }
            if (StringHelper.isNullOrEmpty((String)(strApiDesc = this.getPSSysServiceAPI().getName()))) {
                strApiDesc = strApiTag;
            }
            ObjectNode tagNode = JsonNodeHelper.createObjectNode();
            tagNode.put(FIELD_NAME, strTag);
            tagNode.put(FIELD_DESCRIPTION, strDesc);
            this.tagNodeMap.put(strTag, tagNode);
        }
        if (StringHelper.isNullOrEmpty((String)(summary = ""))) {
            if (iPSDEServiceAPIMethod.getPSDEAction() != null) {
                summary = iPSDEServiceAPIMethod.getPSDEAction().getLogicName();
            } else if (iPSDEServiceAPIMethod.getPSDEDataSet() != null) {
                summary = iPSDEServiceAPIMethod.getPSDEDataSet().getLogicName();
            }
        }
        if (StringHelper.isNullOrEmpty((String)(description = iPSDEServiceAPIMethod.getMemo()))) {
            if (iPSDEServiceAPIMethod.getPSDEAction() != null) {
                description = iPSDEServiceAPIMethod.getPSDEAction().getMemo();
            } else if (iPSDEServiceAPIMethod.getPSDEDataSet() != null) {
                description = iPSDEServiceAPIMethod.getPSDEDataSet().getMemo();
            }
        }
        int i = 0;
        while (i < paths.length) {
            String strType;
            IPSDEMethodDTO iPSDEMethodDTO;
            String path = paths[i];
            ObjectNode pathNode = this.pathNodeMap.get(path);
            if (pathNode == null) {
                pathNode = JsonNodeHelper.createObjectNode();
                this.pathNodeMap.put(path, pathNode);
            }
            ObjectNode operationNode = pathNode.putObject(iPSDEServiceAPIMethod.getRequestMethod().toLowerCase());
            ArrayNode tagsNode = operationNode.putArray("tags");
            tagsNode.add(strTag);
            String uniqueId = iPSDEServiceAPIMethod.getCodeName();
            if (StringHelper.isNullOrEmpty((String)uniqueId) && iPSDEServiceAPIMethod.getPSDEAction() != null) {
                uniqueId = iPSDEServiceAPIMethod.getPSDEAction().getCodeName();
            }
            if (iPSDEServiceAPIRS != null) {
                uniqueId = String.format("%1$s__%2$s__%3$s", iPSDEServiceAPIRS.getMajorPSDEServiceAPI().getCodeName(), uniqueId, i);
            }
            operationNode.put(FIELD_PATH_OPERATIONID, uniqueId);
            operationNode.put(FIELD_PATH_SUMMARY, summary);
            ArrayNode parametersNode = this.getParametersNode(iPSDEServiceAPI, iPSDEServiceAPIRS, iPSDEServiceAPIMethod);
            operationNode.put(FIELD_PATH_PARAMETERS, (JsonNode)parametersNode);
            if (iPSDEServiceAPIMethod.getPSDEServiceAPIMethodInput() != null && (iPSDEMethodDTO = iPSDEServiceAPIMethod.getPSDEServiceAPIMethodInput().getPSDEMethodDTO()) != null) {
                String strRefTag = this.getJsonSchemaRefId(strSysTag, strApiTag, iPSDEServiceAPI.getPSDataEntity(), iPSDEMethodDTO);
                ObjectNode requestBodyNode = operationNode.putObject(FIELD_PATH_REQUESTBODY);
                ObjectNode contentNode = requestBodyNode.putObject(FIELD_CONTENT);
                ObjectNode jsonNode = contentNode.putObject("application/json");
                ObjectNode schemaNode = jsonNode.putObject("schema");
                schemaNode.put("$ref", strRefTag);
            }
            ObjectNode responsesNode = operationNode.putObject(FIELD_PATH_RESPONSES);
            ObjectNode okNode = responsesNode.putObject("200");
            okNode.put(FIELD_DESCRIPTION, "OK");
            if (iPSDEServiceAPIMethod.getPSDEServiceAPIMethodReturn() != null && !"VOID".equals(strType = iPSDEServiceAPIMethod.getPSDEServiceAPIMethodReturn().getType())) {
                ObjectNode schemaNode = okNode.putObject(FIELD_CONTENT).putObject("*/*").putObject("schema");
                IPSDEMethodDTO iPSDEMethodDTO2 = iPSDEServiceAPIMethod.getPSDEServiceAPIMethodReturn().getPSDEMethodDTO();
                if (iPSDEMethodDTO2 != null) {
                    String strRefTag = this.getJsonSchemaRefId(strSysTag, strApiTag, iPSDEServiceAPI.getPSDataEntity(), iPSDEMethodDTO2);
                    if ("DTOS".equals(strType) || "PAGE".equals(strType)) {
                        schemaNode.put(FIELD_JSONSCHEMA_TYPE, TYPE_JSONSCHEMA_ARRAY);
                        ObjectNode itemsNode = schemaNode.putObject(FIELD_JSONSCHEMA_ITEMS);
                        itemsNode.put("$ref", strRefTag);
                    } else {
                        schemaNode.put("$ref", strRefTag);
                    }
                } else if ("SIMPLES".equals(strType)) {
                    schemaNode.put(FIELD_JSONSCHEMA_TYPE, TYPE_JSONSCHEMA_ARRAY);
                    ObjectNode itemsNode = schemaNode.putObject(FIELD_JSONSCHEMA_ITEMS);
                    itemsNode.put(FIELD_JSONSCHEMA_TYPE, this.getSimpleJSType(iPSDEServiceAPIMethod.getPSDEServiceAPIMethodReturn().getStdDataType()));
                } else {
                    schemaNode.put(FIELD_JSONSCHEMA_TYPE, this.getSimpleJSType(iPSDEServiceAPIMethod.getPSDEServiceAPIMethodReturn().getStdDataType()));
                }
            }
            ++i;
        }
    }

    protected ArrayNode getParametersNode(IPSDEServiceAPI iPSDEServiceAPI, IPSDEServiceAPIRS iPSDEServiceAPIRS, IPSDEServiceAPIMethod iPSDEServiceAPIMethod) throws Exception {
        ObjectNode schemaNode;
        ObjectNode parameterNode;
        ArrayNode parametersNode = objMapper.createArrayNode();
        if (iPSDEServiceAPIRS != null) {
            parameterNode = parametersNode.addObject();
            parameterNode.put(FIELD_NAME, "pkey");
            parameterNode.put(FIELD_PARAMETER_IN, "path");
            parameterNode.put(FIELD_DESCRIPTION, "\u7236\u952e\u503c");
            parameterNode.put(FIELD_PARAMETER_REQUIRED, true);
            schemaNode = parameterNode.putObject("schema");
            schemaNode.put(FIELD_JSONSCHEMA_TYPE, TYPE_JSONSCHEMA_STRING);
        }
        if (iPSDEServiceAPIMethod.isNeedResourceKey()) {
            parameterNode = parametersNode.addObject();
            parameterNode.put(FIELD_NAME, "key");
            parameterNode.put(FIELD_PARAMETER_IN, "path");
            parameterNode.put(FIELD_DESCRIPTION, "\u952e\u503c");
            parameterNode.put(FIELD_PARAMETER_REQUIRED, true);
            schemaNode = parameterNode.putObject("schema");
            schemaNode.put(FIELD_JSONSCHEMA_TYPE, TYPE_JSONSCHEMA_STRING);
        }
        return parametersNode;
    }

    protected String getJsonSchemaRefId(String strSysTag, String strApiTag, IPSDataEntity iPSDataEntity, IPSDEMethodDTO iPSDEMethodDTO) throws Exception {
        if (iPSDataEntity == null || iPSDEMethodDTO == null) {
            return null;
        }
        String strJsonSchemaTag = String.format("%1$s__%2$s__%3$s", strSysTag, iPSDataEntity.getName().toLowerCase(), iPSDEMethodDTO.getName());
        if (!this.componentNodeMap.containsKey(strJsonSchemaTag)) {
            IPSDEMethodDTO iPSDEMethodDTO2;
            ObjectNode schemaNode = JsonNodeHelper.createObjectNode();
            this.componentNodeMap.put(strJsonSchemaTag, schemaNode);
            schemaNode.put(FIELD_JSONSCHEMA_TYPE, TYPE_JSONSCHEMA_OBJECT);
            ObjectNode propertiesNode = schemaNode.putObject(FIELD_JSONSCHEMA_PROPERTIES);
            Iterator<? extends IPSDEMethodDTOField> psDEMethodDTOFieldList = iPSDEMethodDTO.getPSDEMethodDTOFields();
            if (iPSDEMethodDTO instanceof IPSDEActionInputDTO) {
                iPSDEMethodDTO2 = (IPSDEActionInputDTO)iPSDEMethodDTO;
            } else if (iPSDEMethodDTO instanceof IPSDEFilterDTO) {
                iPSDEMethodDTO2 = (IPSDEFilterDTO)iPSDEMethodDTO;
            }
            if (psDEMethodDTOFieldList != null) {
                while (psDEMethodDTOFieldList.hasNext()) {
                    ObjectNode itemsNode;
                    IPSDEMethodDTOField iPSDEMethodDTOField = psDEMethodDTOFieldList.next();
                    ObjectNode propertyNode = propertiesNode.putObject(iPSDEMethodDTOField.getName().toLowerCase());
                    propertyNode.put(FIELD_DESCRIPTION, iPSDEMethodDTOField.getLogicName());
                    String strFieldType = iPSDEMethodDTOField.getType();
                    if ("DTO".equals(strFieldType)) {
                        String strRefTag = this.getJsonSchemaRefId(strSysTag, strApiTag, iPSDEMethodDTOField.getRefPSDataEntity(), iPSDEMethodDTOField.getRefPSDEMethodDTO());
                        if (!StringHelper.isNullOrEmpty((String)strRefTag)) {
                            propertyNode.put("$ref", strRefTag);
                            continue;
                        }
                        propertyNode.put(FIELD_JSONSCHEMA_TYPE, TYPE_JSONSCHEMA_OBJECT);
                        continue;
                    }
                    if ("DTOS".equals(strFieldType)) {
                        propertyNode.put(FIELD_JSONSCHEMA_TYPE, TYPE_JSONSCHEMA_ARRAY);
                        itemsNode = propertyNode.putObject(FIELD_JSONSCHEMA_ITEMS);
                        String strRefTag = this.getJsonSchemaRefId(strSysTag, strApiTag, iPSDEMethodDTOField.getRefPSDataEntity(), iPSDEMethodDTOField.getRefPSDEMethodDTO());
                        if (!StringHelper.isNullOrEmpty((String)strRefTag)) {
                            itemsNode.put("$ref", strRefTag);
                            continue;
                        }
                        itemsNode.put(FIELD_JSONSCHEMA_TYPE, TYPE_JSONSCHEMA_OBJECT);
                        continue;
                    }
                    if ("SIMPLES".equals(strFieldType)) {
                        propertyNode.put(FIELD_JSONSCHEMA_TYPE, TYPE_JSONSCHEMA_ARRAY);
                        itemsNode = propertyNode.putObject(FIELD_JSONSCHEMA_ITEMS);
                        itemsNode.put(FIELD_JSONSCHEMA_TYPE, this.getSimpleJSType(iPSDEMethodDTOField.getStdDataType()));
                        continue;
                    }
                    propertyNode.put(FIELD_JSONSCHEMA_TYPE, this.getSimpleJSType(iPSDEMethodDTOField.getStdDataType()));
                }
            }
        }
        return String.format("#/components/schemas/%1$s__%2$s__%3$s", strSysTag, iPSDataEntity.getName().toLowerCase(), iPSDEMethodDTO.getName());
    }

    protected String getSimpleJSType(int nStdDataType) {
        if (DataTypeHelper.isStringDataType((int)nStdDataType)) {
            return TYPE_JSONSCHEMA_STRING;
        }
        if (DataTypeHelper.isIntType((int)nStdDataType)) {
            return TYPE_JSONSCHEMA_INTEGER;
        }
        if (DataTypeHelper.isDateTimeDataType((int)nStdDataType)) {
            return TYPE_JSONSCHEMA_STRING;
        }
        if (DataTypeHelper.isDoubleType((int)nStdDataType)) {
            return TYPE_JSONSCHEMA_NUMBER;
        }
        return TYPE_JSONSCHEMA_STRING;
    }
}

