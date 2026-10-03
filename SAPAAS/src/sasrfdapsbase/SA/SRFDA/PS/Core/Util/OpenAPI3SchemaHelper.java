package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInputDTO;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEFilterDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
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
   private Map<String, ObjectNode> tagNodeMap = new TreeMap<>();
   private Map<String, ObjectNode> componentNodeMap = new LinkedHashMap<>();
   private Map<String, ObjectNode> pathNodeMap = new LinkedHashMap<>();

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
      ObjectNode infoNode = apiNode.putObject("info");
      infoNode.put("title", this.getPSSysServiceAPI().getName());
      infoNode.put("version", "1.0");
      ArrayNode tagsNode = apiNode.putArray("tags");

      for (Entry<String, ObjectNode> entry : this.tagNodeMap.entrySet()) {
         tagsNode.add(entry.getValue());
      }

      ObjectNode pathsNode = apiNode.putObject("paths");

      for (Entry<String, ObjectNode> entry : this.pathNodeMap.entrySet()) {
         pathsNode.put(entry.getKey(), entry.getValue());
      }

      ObjectNode componentsNode = apiNode.putObject("components");
      ObjectNode schemasNode = componentsNode.putObject("schemas");

      for (Entry<String, ObjectNode> entry : this.componentNodeMap.entrySet()) {
         schemasNode.put(entry.getKey(), entry.getValue());
      }

      return apiNode;
   }

   protected void onExport() throws Exception {
      Iterator<IPSDEServiceAPI> psDEServiceAPIs = this.getPSSysServiceAPI().getPSDEServiceAPIs();
      if (psDEServiceAPIs != null) {
         while (psDEServiceAPIs.hasNext()) {
            IPSDEServiceAPI iPSDEServiceAPI = psDEServiceAPIs.next();
            if (iPSDEServiceAPI.getAPIMode() == 1 || iPSDEServiceAPI.getAPIMode() == 0) {
               this.registerPSDEServiceAPIMapping(iPSDEServiceAPI);
            }
         }
      }
   }

   protected void registerPSDEServiceAPIMapping(IPSDEServiceAPI iPSDEServiceAPI) throws Exception {
      String strAPICodeName = this.getPSSysServiceAPI().getCodeName().toLowerCase();
      String strCurId = iPSDEServiceAPI.getId();
      Iterator<IPSDEServiceAPIRS> psDEServiceAPIRSs = this.getPSSysServiceAPI().getPSDEServiceAPIRSs();
      if (psDEServiceAPIRSs != null) {
         while (psDEServiceAPIRSs.hasNext()) {
            IPSDEServiceAPIRS iPSDEServiceAPIRS = psDEServiceAPIRSs.next();
            if (iPSDEServiceAPIRS.getMinorPSDEServiceAPI().getId().equals(strCurId)) {
               Iterator<IPSDEServiceAPIMethod> psDEServiceAPIMethods = iPSDEServiceAPIRS.getPSDEServiceAPIMethods();
               if (psDEServiceAPIMethods != null) {
                  IPSDEServiceAPI majorPSDEServiceAPI = iPSDEServiceAPIRS.getMajorPSDEServiceAPI();
                  String strPath = String.format(
                     "/%1$s/%2$s/{pkey}/%3$s",
                     strAPICodeName,
                     Inflector.getInstance().pluralize(majorPSDEServiceAPI.getCodeName()).toLowerCase(),
                     Inflector.getInstance().pluralize(iPSDEServiceAPI.getCodeName()).toLowerCase()
                  );
                  String strPath2 = String.format(
                     "/%1$s/**/%2$s/{pkey}/%3$s",
                     strAPICodeName,
                     Inflector.getInstance().pluralize(majorPSDEServiceAPI.getCodeName()).toLowerCase(),
                     Inflector.getInstance().pluralize(iPSDEServiceAPI.getCodeName()).toLowerCase()
                  );

                  while (psDEServiceAPIMethods.hasNext()) {
                     IPSDEServiceAPIMethod iPSDEServiceAPIMethod = psDEServiceAPIMethods.next();
                     if ("FETCH".equals(iPSDEServiceAPIMethod.getMethodType())) {
                        String strRequestPath = strPath + "/" + iPSDEServiceAPIMethod.getCodeName().toLowerCase();
                        String strRequestPath2 = strPath2 + "/" + iPSDEServiceAPIMethod.getCodeName().toLowerCase();
                        if ("POST".equals(iPSDEServiceAPIMethod.getRequestMethod())) {
                           this.registerMapping(iPSDEServiceAPI, iPSDEServiceAPIRS, iPSDEServiceAPIMethod, strRequestPath, strRequestPath2);
                        } else if ("GET".equals(iPSDEServiceAPIMethod.getRequestMethod())) {
                           this.registerMapping(iPSDEServiceAPI, iPSDEServiceAPIRS, iPSDEServiceAPIMethod, strRequestPath, strRequestPath2);
                        }
                     } else if ("DEACTION".equals(iPSDEServiceAPIMethod.getMethodType())) {
                        String strRequestPath = strPath + this.getRequestPath(iPSDEServiceAPIMethod);
                        String strRequestPath2 = strPath2 + this.getRequestPath(iPSDEServiceAPIMethod);
                        if (!"GET".equals(iPSDEServiceAPIMethod.getRequestMethod()) && !"DELETE".equals(iPSDEServiceAPIMethod.getRequestMethod())) {
                           if ("POST".equals(iPSDEServiceAPIMethod.getRequestMethod()) || "PUT".equals(iPSDEServiceAPIMethod.getRequestMethod())) {
                              if (iPSDEServiceAPIMethod.isNeedResourceKey()) {
                                 this.registerMapping(iPSDEServiceAPI, iPSDEServiceAPIRS, iPSDEServiceAPIMethod, strRequestPath, strRequestPath2);
                              } else {
                                 this.registerMapping(iPSDEServiceAPI, iPSDEServiceAPIRS, iPSDEServiceAPIMethod, strRequestPath, strRequestPath2);
                              }
                           }
                        } else if (iPSDEServiceAPIMethod.isNeedResourceKey()) {
                           this.registerMapping(iPSDEServiceAPI, iPSDEServiceAPIRS, iPSDEServiceAPIMethod, strRequestPath, strRequestPath2);
                        } else {
                           this.registerMapping(iPSDEServiceAPI, iPSDEServiceAPIRS, iPSDEServiceAPIMethod, strRequestPath, strRequestPath2);
                        }
                     }
                  }

                  String strRequestPath = strPath + "/importtemplate";
                  String strRequestPath2 = strPath2 + "/importtemplate";
                  strRequestPath = strPath + "/exportdata/{param}";
                  strRequestPath2 = strPath + "/exportdata/{param}/{key}";
                  String strRequestPath3 = strPath2 + "/exportdata/{param}";
                  String var13 = strPath2 + "/exportdata/{param}/{key}";
                  strRequestPath = strPath + "/importdata";
                  strRequestPath2 = strPath2 + "/importdata";
                  strRequestPath = strPath + "/printdata/{key}";
                  strRequestPath2 = strPath2 + "/printdata/{key}";
               }
            }
         }
      }

      Iterator<IPSDEServiceAPIMethod> psDEServiceAPIMethods = iPSDEServiceAPI.getPSDEServiceAPIMethods();
      if (psDEServiceAPIMethods != null) {
         String strPath = String.format(
            "/%1$s/%2$s", this.getPSSysServiceAPI().getCodeName().toLowerCase(), Inflector.getInstance().pluralize(iPSDEServiceAPI.getCodeName()).toLowerCase()
         );

         while (psDEServiceAPIMethods.hasNext()) {
            IPSDEServiceAPIMethod iPSDEServiceAPIMethod = psDEServiceAPIMethods.next();
            if ("FETCH".equals(iPSDEServiceAPIMethod.getMethodType())) {
               String strRequestPath = strPath + "/" + iPSDEServiceAPIMethod.getCodeName().toLowerCase();
               if ("POST".equals(iPSDEServiceAPIMethod.getRequestMethod())) {
                  this.registerMapping(iPSDEServiceAPI, null, iPSDEServiceAPIMethod, strRequestPath);
               } else if ("GET".equals(iPSDEServiceAPIMethod.getRequestMethod())) {
                  this.registerMapping(iPSDEServiceAPI, null, iPSDEServiceAPIMethod, strRequestPath);
               } else {
                  log.warn(String.format("无法注册：FETCH[%1$s] %2$s", iPSDEServiceAPIMethod.getRequestMethod(), strRequestPath));
               }
            } else if ("DEACTION".equals(iPSDEServiceAPIMethod.getMethodType())) {
               String strRequestPath = strPath + this.getRequestPath(iPSDEServiceAPIMethod);
               if (!"GET".equals(iPSDEServiceAPIMethod.getRequestMethod()) && !"DELETE".equals(iPSDEServiceAPIMethod.getRequestMethod())) {
                  if ("POST".equals(iPSDEServiceAPIMethod.getRequestMethod()) || "PUT".equals(iPSDEServiceAPIMethod.getRequestMethod())) {
                     if (iPSDEServiceAPIMethod.isNeedResourceKey()) {
                        this.registerMapping(iPSDEServiceAPI, null, iPSDEServiceAPIMethod, strRequestPath);
                     } else {
                        this.registerMapping(iPSDEServiceAPI, null, iPSDEServiceAPIMethod, strRequestPath);
                     }
                  }
               } else if (iPSDEServiceAPIMethod.isNeedResourceKey()) {
                  this.registerMapping(iPSDEServiceAPI, null, iPSDEServiceAPIMethod, strRequestPath);
               } else {
                  this.registerMapping(iPSDEServiceAPI, null, iPSDEServiceAPIMethod, strRequestPath);
               }
            }
         }

         String strRequestPath = strPath + "/importtemplate";
         strRequestPath = strPath + "/exportdata/{param}";
         String var23 = strPath + "/exportdata/{param}/{key}";
         strRequestPath = strPath + "/importdata";
         strRequestPath = strPath + "/printdata/{key}";
      }
   }

   protected String getRequestPath(IPSDEServiceAPIMethod iPSDEServiceAPIMethod) {
      if (iPSDEServiceAPIMethod.isNeedResourceKey()) {
         return iPSDEServiceAPIMethod.isNoServiceCodeName() ? "/{key}" : "/{key}/" + iPSDEServiceAPIMethod.getCodeName().toLowerCase();
      } else {
         return iPSDEServiceAPIMethod.isNoServiceCodeName() ? "" : "/" + iPSDEServiceAPIMethod.getCodeName().toLowerCase();
      }
   }

   protected void registerMapping(
      IPSDEServiceAPI iPSDEServiceAPI, IPSDEServiceAPIRS iPSDEServiceAPIRS, IPSDEServiceAPIMethod iPSDEServiceAPIMethod, String... paths
   ) throws Exception {
      String strSysTag = this.getPSSysServiceAPI().getPSSystem().getName();
      String strApiTag = this.getPSSysServiceAPI().getCodeName();
      String strTag = String.format("%1$s-%2$s-controller", strApiTag, iPSDEServiceAPI.getCodeName()).toLowerCase();
      if (!this.tagNodeMap.containsKey(strTag)) {
         String strDesc = iPSDEServiceAPI.getLogicName();
         if (StringHelper.isNullOrEmpty(strDesc)) {
            strDesc = iPSDEServiceAPI.getPSDataEntity().getLogicName();
         }

         String strSysDesc = this.getPSSysServiceAPI().getPSSystem().getLogicName();
         if (StringHelper.isNullOrEmpty(strSysDesc)) {
            ;
         }

         String strApiDesc = this.getPSSysServiceAPI().getName();
         if (StringHelper.isNullOrEmpty(strApiDesc)) {
            ;
         }

         ObjectNode tagNode = JsonNodeHelper.createObjectNode();
         tagNode.put("name", strTag);
         tagNode.put("description", strDesc);
         this.tagNodeMap.put(strTag, tagNode);
      }

      String summary = "";
      if (StringHelper.isNullOrEmpty(summary)) {
         if (iPSDEServiceAPIMethod.getPSDEAction() != null) {
            summary = iPSDEServiceAPIMethod.getPSDEAction().getLogicName();
         } else if (iPSDEServiceAPIMethod.getPSDEDataSet() != null) {
            summary = iPSDEServiceAPIMethod.getPSDEDataSet().getLogicName();
         }
      }

      String description = iPSDEServiceAPIMethod.getMemo();
      if (StringHelper.isNullOrEmpty(description)) {
         if (iPSDEServiceAPIMethod.getPSDEAction() != null) {
            description = iPSDEServiceAPIMethod.getPSDEAction().getMemo();
         } else if (iPSDEServiceAPIMethod.getPSDEDataSet() != null) {
            description = iPSDEServiceAPIMethod.getPSDEDataSet().getMemo();
         }
      }

      for (int i = 0; i < paths.length; i++) {
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
         if (StringHelper.isNullOrEmpty(uniqueId) && iPSDEServiceAPIMethod.getPSDEAction() != null) {
            uniqueId = iPSDEServiceAPIMethod.getPSDEAction().getCodeName();
         }

         if (iPSDEServiceAPIRS != null) {
            uniqueId = String.format("%1$s__%2$s__%3$s", iPSDEServiceAPIRS.getMajorPSDEServiceAPI().getCodeName(), uniqueId, i);
         }

         operationNode.put("operationId", uniqueId);
         operationNode.put("summary", summary);
         ArrayNode parametersNode = this.getParametersNode(iPSDEServiceAPI, iPSDEServiceAPIRS, iPSDEServiceAPIMethod);
         operationNode.put("parameters", parametersNode);
         if (iPSDEServiceAPIMethod.getPSDEServiceAPIMethodInput() != null) {
            IPSDEMethodDTO iPSDEMethodDTO = iPSDEServiceAPIMethod.getPSDEServiceAPIMethodInput().getPSDEMethodDTO();
            if (iPSDEMethodDTO != null) {
               String strRefTag = this.getJsonSchemaRefId(strSysTag, strApiTag, iPSDEServiceAPI.getPSDataEntity(), iPSDEMethodDTO);
               ObjectNode requestBodyNode = operationNode.putObject("requestBody");
               ObjectNode contentNode = requestBodyNode.putObject("content");
               ObjectNode jsonNode = contentNode.putObject("application/json");
               ObjectNode schemaNode = jsonNode.putObject("schema");
               schemaNode.put("$ref", strRefTag);
            }
         }

         ObjectNode responsesNode = operationNode.putObject("responses");
         ObjectNode okNode = responsesNode.putObject("200");
         okNode.put("description", "OK");
         if (iPSDEServiceAPIMethod.getPSDEServiceAPIMethodReturn() != null) {
            String strType = iPSDEServiceAPIMethod.getPSDEServiceAPIMethodReturn().getType();
            if (!"VOID".equals(strType)) {
               ObjectNode schemaNode = okNode.putObject("content").putObject("*/*").putObject("schema");
               IPSDEMethodDTO iPSDEMethodDTO = iPSDEServiceAPIMethod.getPSDEServiceAPIMethodReturn().getPSDEMethodDTO();
               if (iPSDEMethodDTO != null) {
                  String strRefTag = this.getJsonSchemaRefId(strSysTag, strApiTag, iPSDEServiceAPI.getPSDataEntity(), iPSDEMethodDTO);
                  if (!"DTOS".equals(strType) && !"PAGE".equals(strType)) {
                     schemaNode.put("$ref", strRefTag);
                  } else {
                     schemaNode.put("type", "array");
                     ObjectNode itemsNode = schemaNode.putObject("items");
                     itemsNode.put("$ref", strRefTag);
                  }
               } else if ("SIMPLES".equals(strType)) {
                  schemaNode.put("type", "array");
                  ObjectNode itemsNode = schemaNode.putObject("items");
                  itemsNode.put("type", this.getSimpleJSType(iPSDEServiceAPIMethod.getPSDEServiceAPIMethodReturn().getStdDataType()));
               } else {
                  schemaNode.put("type", this.getSimpleJSType(iPSDEServiceAPIMethod.getPSDEServiceAPIMethodReturn().getStdDataType()));
               }
            }
         }
      }
   }

   protected ArrayNode getParametersNode(IPSDEServiceAPI iPSDEServiceAPI, IPSDEServiceAPIRS iPSDEServiceAPIRS, IPSDEServiceAPIMethod iPSDEServiceAPIMethod) throws Exception {
      ArrayNode parametersNode = objMapper.createArrayNode();
      if (iPSDEServiceAPIRS != null) {
         ObjectNode parameterNode = parametersNode.addObject();
         parameterNode.put("name", "pkey");
         parameterNode.put("in", "path");
         parameterNode.put("description", "父键值");
         parameterNode.put("required", true);
         ObjectNode schemaNode = parameterNode.putObject("schema");
         schemaNode.put("type", "string");
      }

      if (iPSDEServiceAPIMethod.isNeedResourceKey()) {
         ObjectNode parameterNode = parametersNode.addObject();
         parameterNode.put("name", "key");
         parameterNode.put("in", "path");
         parameterNode.put("description", "键值");
         parameterNode.put("required", true);
         ObjectNode schemaNode = parameterNode.putObject("schema");
         schemaNode.put("type", "string");
      }

      return parametersNode;
   }

   protected String getJsonSchemaRefId(String strSysTag, String strApiTag, IPSDataEntity iPSDataEntity, IPSDEMethodDTO iPSDEMethodDTO) throws Exception {
      if (iPSDataEntity != null && iPSDEMethodDTO != null) {
         String strJsonSchemaTag = String.format("%1$s__%2$s__%3$s", strSysTag, iPSDataEntity.getName().toLowerCase(), iPSDEMethodDTO.getName());
         if (!this.componentNodeMap.containsKey(strJsonSchemaTag)) {
            ObjectNode schemaNode = JsonNodeHelper.createObjectNode();
            this.componentNodeMap.put(strJsonSchemaTag, schemaNode);
            schemaNode.put("type", "object");
            ObjectNode propertiesNode = schemaNode.putObject("properties");
            Iterator<? extends IPSDEMethodDTOField> psDEMethodDTOFieldList = iPSDEMethodDTO.getPSDEMethodDTOFields();
            if (iPSDEMethodDTO instanceof IPSDEActionInputDTO) {
               IPSDEActionInputDTO iPSDEMethodDTOField = (IPSDEActionInputDTO)iPSDEMethodDTO;
            } else if (iPSDEMethodDTO instanceof IPSDEFilterDTO) {
               IPSDEFilterDTO var14 = (IPSDEFilterDTO)iPSDEMethodDTO;
            }

            if (psDEMethodDTOFieldList != null) {
               while (psDEMethodDTOFieldList.hasNext()) {
                  IPSDEMethodDTOField iPSDEMethodDTOField = psDEMethodDTOFieldList.next();
                  ObjectNode propertyNode = propertiesNode.putObject(iPSDEMethodDTOField.getName().toLowerCase());
                  propertyNode.put("description", iPSDEMethodDTOField.getLogicName());
                  String strFieldType = iPSDEMethodDTOField.getType();
                  if ("DTO".equals(strFieldType)) {
                     String strRefTag = this.getJsonSchemaRefId(
                        strSysTag, strApiTag, iPSDEMethodDTOField.getRefPSDataEntity(), iPSDEMethodDTOField.getRefPSDEMethodDTO()
                     );
                     if (!StringHelper.isNullOrEmpty(strRefTag)) {
                        propertyNode.put("$ref", strRefTag);
                     } else {
                        propertyNode.put("type", "object");
                     }
                  } else if ("DTOS".equals(strFieldType)) {
                     propertyNode.put("type", "array");
                     ObjectNode itemsNode = propertyNode.putObject("items");
                     String strRefTag = this.getJsonSchemaRefId(
                        strSysTag, strApiTag, iPSDEMethodDTOField.getRefPSDataEntity(), iPSDEMethodDTOField.getRefPSDEMethodDTO()
                     );
                     if (!StringHelper.isNullOrEmpty(strRefTag)) {
                        itemsNode.put("$ref", strRefTag);
                     } else {
                        itemsNode.put("type", "object");
                     }
                  } else if ("SIMPLES".equals(strFieldType)) {
                     propertyNode.put("type", "array");
                     ObjectNode itemsNode = propertyNode.putObject("items");
                     itemsNode.put("type", this.getSimpleJSType(iPSDEMethodDTOField.getStdDataType()));
                  } else {
                     propertyNode.put("type", this.getSimpleJSType(iPSDEMethodDTOField.getStdDataType()));
                  }
               }
            }
         }

         return String.format("#/components/schemas/%1$s__%2$s__%3$s", strSysTag, iPSDataEntity.getName().toLowerCase(), iPSDEMethodDTO.getName());
      } else {
         return null;
      }
   }

   protected String getSimpleJSType(int nStdDataType) {
      if (DataTypeHelper.isStringDataType(nStdDataType)) {
         return "string";
      } else if (DataTypeHelper.isIntType(nStdDataType)) {
         return "integer";
      } else if (DataTypeHelper.isDateTimeDataType(nStdDataType)) {
         return "string";
      } else {
         return DataTypeHelper.isDoubleType(nStdDataType) ? "number" : "string";
      }
   }
}
