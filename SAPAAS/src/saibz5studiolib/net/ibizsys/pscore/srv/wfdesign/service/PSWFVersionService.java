package net.ibizsys.pscore.srv.wfdesign.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.codelist.DynaSysRefModeCodeListModel;
import net.ibizsys.pscore.srv.codelist.WFUtilUIActionType2CodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVer;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLink;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFUtilUIAction;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVerLog;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Component
public class PSWFVersionService extends PSWFVersionServiceBase {
   public static final String XMLNODE_WFCONFIG = "WFCONFIG";
   public static final String XMLNODE_WFPROCESS = "WFPROCESS";
   public static final String XMLNODE_WFLINK = "WFLINK";
   private static final Log log = LogFactory.getLog(PSWFVersionService.class);
   private static String[] PREDEFINEDACTIONS = new String[]{
      "SENDBACK",
      "SUPPLYINFO",
      "ADDSTEPAFTER",
      "ADDSTEPBEFORE",
      "TAKEADVICE",
      "REASSIGN",
      "SENDCOPY",
      "USERACTION",
      "USERACTION2",
      "USERACTION3",
      "USERACTION4",
      "USERACTION5",
      "USERACTION6"
   };

   @Override
   public void getWithModel(PSWFVersion var1) throws Exception {
      if (!KeyValueHelper.isTempKey(var1.getPSWFVersionId())) {
         this.getTempMajor(var1);
      } else {
         this.getTemp(var1);
      }

      var1.setWFModel(this.getWFModel(var1));
      if (StringHelper.compare(var1.getPSWF().getWFEngineType(), "ACTIVITI", false) == 0) {
         var1.setActivitiModel(this.getActivitiModel(var1));
      }
   }

   protected String getWFModel(PSWFVersion var1) throws Exception {
      XmlNode var2 = new XmlNode();
      var2.setNodeName("WFCONFIG");
      var2.setAttribute("PSWFID", var1.getPSWFId());
      var2.setAttribute("PSSYSTEMID", var1.getPSSystemId());
      var2.setAttribute("PSWFVERSIONID", var1.getPSWFVersionId());
      PSWFProcessService var3 = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class.getCanonicalName(), this.getSessionFactory());

      for (PSWFProcess var6 : var3.selectTempByPSWFVersion(var1)) {
         XmlNode var7 = new XmlNode();
         var7.setNodeName("WFPROCESS");
         var6.fillXmlNode(var7, true);
         var2.addNode(var7);
      }

      PSWFLinkService var10 = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class.getCanonicalName(), this.getSessionFactory());

      for (PSWFLink var8 : var10.selectTempByPSWFVersion(var1)) {
         XmlNode var9 = new XmlNode();
         var9.setNodeName("WFLINK");
         var8.fillXmlNode(var9, true);
         var2.addNode(var9);
      }

      return XmlNode.export(var2);
   }

   protected String getActivitiModel(PSWFVersion var1) throws Exception {
      String var2 = var1.getActivitiModel();
      if (!StringHelper.isNullOrEmpty(var2) && var2.charAt(0) != '{') {
         XmlNode var3 = XmlNode.loadFromXML(var2);
         var2 = var3.getAttribute("ACTIVITIMODEL", "");
      }

      XmlNode var18 = new XmlNode();
      var18.setNodeName("WFCONFIG");
      var18.setAttribute("PSWFID", var1.getPSWFId());
      var18.setAttribute("PSSYSTEMID", var1.getPSSystemId());
      var18.setAttribute("PSWFVERSIONID", var1.getPSWFVersionId());
      if (StringHelper.isNullOrEmpty(var2)) {
         var18.setAttribute(
            "ACTIVITIMODEL",
            "{\"json_xml\":{\"resourceId\":\"\", \"stencilset\":{\"url\":\"stencilsets/bpmn2.0/bpmn2.0.json\",\"namespace\":\"http://b3mn.org/stencilset/bpmn2.0#\"}},\"name\":\"ibiz\",\"description\":\"\"}"
         );
      } else {
         PSWFProcessService var4 = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class.getCanonicalName(), this.getSessionFactory());
         ArrayList<PSWFProcess> var5 = var4.selectTempByPSWFVersion(var1);
         HashMap<String, String> var6 = new HashMap<String, String>();

         for (PSWFProcess var8 : var5) {
            if (!StringHelper.isNullOrEmpty(var8.getModelId())) {
               var6.put(var8.getModelId(), var8.getPSWFProcessId());
            }
         }

         PSWFLinkService var19 = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class.getCanonicalName(), this.getSessionFactory());

         for (PSWFLink var10 : var19.selectTempByPSWFVersion(var1)) {
            if (!StringHelper.isNullOrEmpty(var10.getModelId())) {
               var6.put(var10.getModelId(), var10.getPSWFLinkId());
            }
         }

         JSONObject var21 = JSONObject.parseObject(var2);
         JSONObject var22 = var21.getJSONObject("json_xml");
         if (var22 != null) {
            JSONArray var11 = var22.getJSONArray("childShapes");
            if (var11 != null) {
               int var12 = var11.size();

               for (int var13 = 0; var13 < var12; var13++) {
                  JSONObject var14 = var11.getJSONObject(var13);
                  String var15 = var14.getString("resourceId");
                  JSONObject var16 = var14.getJSONObject("properties");
                  String var17 = (String)var6.get(var15);
                  if (StringHelper.isNullOrEmpty(var17)) {
                     var17 = "";
                  }

                  var16.put("documentation", var17);
               }

               var2 = var21.toString();
            }
         }

         var18.setAttribute("ACTIVITIMODEL", var2);
      }

      return XmlNode.export(var18);
   }

   @Override
   public void updateWithModel(PSWFVersion var1) throws Exception {
      final PSWFVersion var2 = var1;
      var2.setSessionFactory(this.getSessionFactory());
      log.debug("开始[updateWithModel]作业");
      this.doServiceWork(
         new IServiceWork() {
            @Override
            public void execute(ITransaction var1) throws Exception {
               Object var2x = null;
               PSWFProcessService var3 = (PSWFProcessService)ServiceGlobal.getService(
                  PSWFProcessService.class.getCanonicalName(), PSWFVersionService.this.getSessionFactory()
               );
               ArrayList<PSWFProcess> var4 = var3.selectTempByPSWFVersion(var2);
               HashMap<String, PSWFProcess> var5 = new HashMap<String, PSWFProcess>();

               for (PSWFProcess var7 : var4) {
                  var5.put(var7.getPSWFProcessId(), var7);
               }

               PSWFLinkService var19 = (PSWFLinkService)ServiceGlobal.getService(
                  PSWFLinkService.class.getCanonicalName(), PSWFVersionService.this.getSessionFactory()
               );
               ArrayList<PSWFLink> var20 = var19.selectTempByPSWFVersion(var2);
               HashMap<String, PSWFLink> var8 = new HashMap<String, PSWFLink>();

               for (PSWFLink var10 : var20) {
                  var8.put(var10.getPSWFLinkId(), var10);
               }

               var2.setBPMNModel(null);
               if (StringHelper.compare(var2.getPSWF().getWFEngineType(), "ACTIVITI", false) == 0) {
                  String var21 = var2.getActivitiModel();
                  var2x = var21;
                  XmlNode var24 = XmlNode.loadFromXML(var21);
                  if (var24 != null) {
                     var24.setAttribute("PSWFID", var2.getPSWFId());
                     var24.setAttribute("PSSYSTEMID", var2.getPSSystemId());
                     var24.setAttribute("PSWFVERSIONID", var2.getPSWFVersionId());
                     String var11 = var24.getAttribute("ACTIVITIMODEL", "");
                     JSONObject var12 = null;
                     if (!StringHelper.isNullOrEmpty(var11)) {
                        var12 = JSONObject.parseObject(var11);
                        JSONObject var13 = var12.getJSONObject("json_xml");
                        if (var13 != null) {
                           JSONArray var14 = var13.getJSONArray("childShapes");
                           int var15 = DataObject.getIntegerValue(var2.getPSWF().getRemoteEngineFlag(), 0);
                           if (var14 != null) {
                              PSWFVersionHelper var16 = new PSWFVersionHelper(PSWFVersionService.this.getSessionFactory());
                              if (var15 == 1) {
                                 var16.updatePSWFVersionModel3(var2, var14, var5, var8);
                              } else {
                                 var16.updatePSWFVersionModel2(var2, var14, var5, var8);
                              }

                              var11 = var12.toString();
                              var24.setAttribute("ACTIVITIMODEL", var11);
                              String var17 = PSWFVersionService.this.getBPMNModel(var13.toString());
                              if (var15 == 1) {
                                 var17 = PSWFVersionService.this.processBPMNModel(var17);
                              }

                              var2.setBPMNModel(var17);
                           }
                        }
                     }

                     var2.setActivitiModel(XmlNode.export(var24));
                  } else {
                     var2.setActivitiModel(null);
                  }
               } else {
                  String var22 = var2.getWFModel();
                  var2x = var22;
                  XmlNode var25 = XmlNode.loadFromXML(var22);
                  if (var25 != null) {
                     var25.setAttribute("PSWFID", var2.getPSWFId());
                     var25.setAttribute("PSWFVERSIONID", var2.getPSWFVersionId());
                     var25.setAttribute("PSSYSTEMID", var2.getPSSystemId());
                     PSWFVersionService.this.updatePSWFVersionModel(var2, var25, var5, var8);
                     var2.setWFModel(XmlNode.export(var25));
                  } else {
                     var2.setWFModel(null);
                  }
               }

               boolean var23 = false;
               if (var8.size() > 0) {
                  for (PSWFLink var29 : var8.values()) {
                     if (StringHelper.isNullOrEmpty(var2.getPSWFVersionName())) {
                        PSWFVersionService.log.info(StringHelper.format("工作流版本[%1$s]删除连接[%2$s]", var2.getPSWFVersionId(), var29.getPSWFLinkName()));
                     } else {
                        PSWFVersionService.log.info(StringHelper.format("工作流版本[%1$s]删除连接[%2$s]", var2.getPSWFVersionName(), var29.getPSWFLinkName()));
                     }

                     var19.removeTemp(var29);
                     var23 = true;
                  }
               }

               if (var5.size() > 0) {
                  for (PSWFProcess var30 : var5.values()) {
                     if (StringHelper.isNullOrEmpty(var2.getPSWFVersionName())) {
                        PSWFVersionService.log.info(StringHelper.format("工作流版本[%1$s]删除处理[%2$s]", var2.getPSWFVersionId(), var30.getPSWFProcessName()));
                     } else {
                        PSWFVersionService.log.info(StringHelper.format("工作流版本[%1$s]删除处理[%2$s]", var2.getPSWFVersionName(), var30.getPSWFProcessName()));
                     }

                     var3.removeTemp(var30);
                     var23 = true;
                  }
               }

               if (var23) {
                  if (StringHelper.isNullOrEmpty(var2.getPSWFVersionName())) {
                     PSWFVersionService.log.info(StringHelper.format("工作流版本[%1$s]Xml模型\r\n%2$s", var2.getPSWFVersionId(), var2x));
                  } else {
                     PSWFVersionService.log.info(StringHelper.format("工作流版本[%1$s]Xml模型\r\n%2$s", var2.getPSWFVersionName(), var2x));
                  }
               }

               PSWFVersionService.this.resetPSDEUIActions(var2);
               PSWFVersionService.this.updateTempMajor(var2);
               PSWFVersionService.this.rebuildPSDEUIActions(var2);
               PSWFVersionService.this.createPSWFVerBak(var2);
            }
         }
      );
   }

   protected void updatePSWFVersionModel(PSWFVersion var1, XmlNode var2, HashMap<String, PSWFProcess> var3, HashMap<String, PSWFLink> var4) throws Exception {
      Iterator var5 = var2.getChildNodes();
      if (var5 != null) {
         ArrayList<XmlNode> var6 = new ArrayList<XmlNode>();
         ArrayList<XmlNode> var7 = new ArrayList<XmlNode>();
         PSWFProcessService var8 = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class.getCanonicalName(), this.getSessionFactory());
         PSWFLinkService var9 = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class.getCanonicalName(), this.getSessionFactory());

         while (var5.hasNext()) {
            XmlNode var10 = (XmlNode)var5.next();
            if (StringHelper.compare(var10.getNodeName(), "WFPROCESS", true) == 0) {
               String var11 = var10.getAttribute("PSWFPROCESSID", "");
               if (!StringHelper.isNullOrEmpty(var11)) {
                  PSWFProcess var12 = (PSWFProcess)var3.remove(var11);
                  if (var12 != null) {
                     boolean var13 = false;
                     if (StringHelper.compare(var12.getPSWFVersionId(), var1.getPSWFVersionId(), false) != 0) {
                        var12.setPSWFVersionId(var1.getPSWFVersionId());
                        var13 = true;
                     }

                     if (StringHelper.compare(var12.getPSWFVersionName(), var1.getPSWFVersionName(), false) != 0) {
                        var12.setPSWFVersionName(var1.getPSWFVersionName());
                        var13 = true;
                     }

                     String var14 = var10.getAttribute("LEFTPOS", "");
                     String var15 = var10.getAttribute("TOPPOS", "");
                     if (!StringHelper.isNullOrEmpty(var14)) {
                        int var16 = Integer.parseInt(var14);
                        if (var12.getLeftPos() == null || var12.getLeftPos() != var16) {
                           var12.setLeftPos(var16);
                           var13 = true;
                        }
                     }

                     if (!StringHelper.isNullOrEmpty(var15)) {
                        int var27 = Integer.parseInt(var15);
                        if (var12.getTopPos() == null || var12.getTopPos() != var27) {
                           var12.setTopPos(var27);
                           var13 = true;
                        }
                     }

                     if (var13) {
                        var8.updateTemp(var12);
                     }

                     var10.resetAttributes();
                     var12.fillXmlNode(var10, false);
                     var6.add(var10);
                  }
               }
            } else if (StringHelper.compare(var10.getNodeName(), "WFLINK", true) == 0) {
               String var20 = var10.getAttribute("PSWFLINKID", "");
               if (!StringHelper.isNullOrEmpty(var20)) {
                  PSWFLink var23 = (PSWFLink)var4.remove(var20);
                  if (var23 != null) {
                     boolean var24 = false;
                     String var25 = var10.getAttribute("FROMPSWFPROCID", "");
                     String var26 = var10.getAttribute("SRCENDPOINT", "");
                     if (StringHelper.compare(var23.getFromPSWFProcId(), var25, false) == 0
                        && (StringHelper.isNullOrEmpty(var23.getSrcEndPoint()) || StringHelper.compare(var23.getSrcEndPoint(), var26, false) == 0)) {
                        if (StringHelper.compare(var23.getPSWFVersionId(), var1.getPSWFVersionId(), false) != 0) {
                           var23.setPSWFVersionId(var1.getPSWFVersionId());
                           var24 = true;
                        }

                        if (StringHelper.compare(var23.getPSWFVersionName(), var1.getPSWFVersionName(), false) != 0) {
                           var23.setPSWFVersionName(var1.getPSWFVersionName());
                           var24 = true;
                        }

                        String var28 = var10.getAttribute("DSTENDPOINT", "");
                        String var17 = var10.getAttribute("TOPSWFPROCID", "");
                        if (StringHelper.compare(var23.getSrcEndPoint(), var26, false) != 0) {
                           var23.setSrcEndPoint(var26);
                           var24 = true;
                        }

                        if (StringHelper.compare(var23.getDstEndPoint(), var28, false) != 0) {
                           var23.setDstEndPoint(var28);
                           var24 = true;
                        }

                        if (StringHelper.compare(var23.getToPSWFProcId(), var17, false) != 0) {
                           var23.setToPSWFProcId(var17);
                           var24 = true;
                        }

                        if (var24) {
                           var9.updateTemp(var23);
                        }
                     } else {
                        log.error(StringHelper.format("工作流连接线[%1$s]起点发生变化", var23.getPSWFLinkName()));
                     }

                     var10.resetAttributes();
                     var23.fillXmlNode(var10, false);
                     var7.add(var10);
                  }
               }
            }
         }

         var2.resetChildNodes();

         for (XmlNode var21 : var6) {
            var2.addNode(var21);
         }

         for (XmlNode var22 : var7) {
            var2.addNode(var22);
         }
      }
   }

   @Override
   public void createWithModel(PSWFVersion var1) throws Exception {
      final PSWFVersion var2 = var1;
      var2.setSessionFactory(this.getSessionFactory());
      log.debug("开始[createWithModel]作业");
      this.doServiceWork(
         new IServiceWork() {
            @Override
            public void execute(ITransaction var1) throws Exception {
               PSWFProcessService var2x = (PSWFProcessService)ServiceGlobal.getService(
                  PSWFProcessService.class.getCanonicalName(), PSWFVersionService.this.getSessionFactory()
               );
               ArrayList<PSWFProcess> var3 = var2x.selectTempByPSWFVersion(var2);
               HashMap<String, PSWFProcess> var4 = new HashMap<String, PSWFProcess>();

               for (PSWFProcess var6 : var3) {
                  var4.put(var6.getPSWFProcessId(), var6);
               }

               PSWFLinkService var17 = (PSWFLinkService)ServiceGlobal.getService(
                  PSWFLinkService.class.getCanonicalName(), PSWFVersionService.this.getSessionFactory()
               );
               ArrayList<PSWFLink> var18 = var17.selectTempByPSWFVersion(var2);
               HashMap<String, PSWFLink> var7 = new HashMap<String, PSWFLink>();

               for (PSWFLink var9 : var18) {
                  var7.put(var9.getPSWFLinkId(), var9);
               }

               var2.setBPMNModel(null);
               if (StringHelper.compare(var2.getPSWF().getWFEngineType(), "ACTIVITI", false) == 0) {
                  String var19 = var2.getActivitiModel();
                  XmlNode var23 = XmlNode.loadFromXML(var19);
                  if (var23 != null) {
                     var23.setAttribute("PSWFID", var2.getPSWFId());
                     var23.setAttribute("PSSYSTEMID", var2.getPSSystemId());
                     var23.setAttribute("PSWFVERSIONID", var2.getPSWFVersionId());
                     String var10 = var23.getAttribute("ACTIVITIMODEL", "");
                     JSONObject var11 = null;
                     if (!StringHelper.isNullOrEmpty(var10)) {
                        var11 = JSONObject.parseObject(var10);
                        JSONObject var12 = var11.getJSONObject("json_xml");
                        if (var12 != null) {
                           JSONArray var13 = var12.getJSONArray("childShapes");
                           int var14 = DataObject.getIntegerValue(var2.getPSWF().getRemoteEngineFlag(), 0);
                           if (var13 != null) {
                              PSWFVersionHelper var15 = new PSWFVersionHelper(PSWFVersionService.this.getSessionFactory());
                              if (var14 == 1) {
                                 var15.updatePSWFVersionModel3(var2, var13, var4, var7);
                              } else {
                                 var15.updatePSWFVersionModel2(var2, var13, var4, var7);
                              }

                              var10 = var11.toString();
                              var23.setAttribute("ACTIVITIMODEL", var10);
                              String var16 = PSWFVersionService.this.getBPMNModel(var12.toString());
                              if (var14 == 1) {
                                 var16 = PSWFVersionService.this.processBPMNModel(var16);
                              }

                              var2.setBPMNModel(var16);
                           }
                        }
                     }

                     var2.setActivitiModel(XmlNode.export(var23));
                  } else {
                     var2.setActivitiModel(null);
                  }
               } else {
                  String var20 = var2.getWFModel();
                  XmlNode var24 = XmlNode.loadFromXML(var20);
                  if (var24 != null) {
                     var24.setAttribute("PSWFID", var2.getPSWFId());
                     var24.setAttribute("PSSYSTEMID", var2.getPSSystemId());
                     var24.setAttribute("PSWFVERSIONID", var2.getPSWFVersionId());
                     PSWFVersionService.this.updatePSWFVersionModel(var2, var24, var4, var7);
                     var2.setWFModel(XmlNode.export(var24));
                  } else {
                     var2.setWFModel(null);
                  }
               }

               if (var7.size() > 0) {
                  for (PSWFLink var25 : var7.values()) {
                     var17.removeTemp(var25);
                  }
               }

               if (var4.size() > 0) {
                  for (PSWFProcess var26 : var4.values()) {
                     var2x.removeTemp(var26);
                  }
               }

               if (!StringHelper.isNullOrEmpty(var2.getPSDynaInstId())) {
                  var2.setDynaSysRefMode(DynaSysRefModeCodeListModel.DYNASYSINST);
               }

               PSWFVersionService.this.createTempMajor(var2);
               PSWFVersionService.this.rebuildPSDEUIActions(var2);
               PSWFVersionService.this.createPSWFVerBak(var2);
            }
         }
      );
   }

   @Override
   public void getDraftWithModel(PSWFVersion var1) throws Exception {
      this.getDraftTempMajor(var1);
      var1.setWFModel(this.getWFModel(var1));
      if (StringHelper.compare(var1.getPSWF().getWFEngineType(), "ACTIVITI", false) == 0) {
         var1.setActivitiModel(this.getActivitiModel(var1));
      }
   }

   protected void onAfterGetDraftTemp(PSWFVersion var1) throws Exception {
      super.onAfterGetDraftTemp(var1);
      if (var1.getWFVersion() == null) {
         String var2 = var1.getPSWF().getPSWorkflowId();
         if (!StringHelper.isNullOrEmpty(var2)) {
            SelectContext var3 = new SelectContext();
            var3.addSelectField("WFVERSION", "WFVERSION", "MAX");
            var3.set("PSWFID", var2);
            ArrayList var4 = this.selectEx(var3);
            if (var4.size() > 0) {
               int var5 = DataObject.getIntegerValue(((PSWFVersion)var4.get(0)).getWFVersion(), 0);
               var1.setWFVersion(var5 + 1);
            }
         }
      }

      PSWFProcessService var6 = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, this.getSessionFactory());
      if (StringHelper.compare(var1.getPSWF().getWFEngineType(), "ACTIVITI", false) != 0) {
         PSWFProcess var7 = new PSWFProcess();
         var7.setWFProcessType("START");
         var7.setPSWFProcessName("开始流程");
         var7.setCodeName("Start");
         var7.setPSWFVersionId(var1.getPSWFVersionId());
         var7.setLeftPos(200);
         var7.setTopPos(200);
         var7.setPSSystemId(var1.getPSSystemId());
         var6.createTemp(var7);
         var7 = new PSWFProcess();
         var7.setWFProcessType("END");
         var7.setPSWFProcessName("结束");
         var7.setCodeName("End");
         var7.setPSWFVersionId(var1.getPSWFVersionId());
         var7.setLeftPos(400);
         var7.setTopPos(400);
         var7.setPSSystemId(var1.getPSSystemId());
         var6.createTemp(var7);
      }
   }

   protected void onAfterGetDraft(PSWFVersion var1) throws Exception {
      super.onAfterGetDraft(var1);
      if (var1.getWFVersion() == null) {
         String var2 = var1.getPSWF().getPSWorkflowId();
         if (!StringHelper.isNullOrEmpty(var2)) {
            SelectContext var3 = new SelectContext();
            var3.addSelectField("WFVERSION", "WFVERSION", "MAX");
            var3.set("PSWFID", var2);
            ArrayList var4 = this.selectEx(var3);
            if (var4.size() > 0) {
               int var5 = DataObject.getIntegerValue(((PSWFVersion)var4.get(0)).getWFVersion(), 0);
               var1.setWFVersion(var5 + 1);
            }
         }
      }
   }

   protected void onBeforeCreate(PSWFVersion var1) throws Exception {
      if (DataObject.getIntegerValue(var1.getPSWF().getWFProxyMode(), 0) == 1) {
         throw new Exception(StringHelper.format("工作流[%1$s]启动外部代理模式，不允许添加流程版本", var1.getPSWF().getPSWorkflowName()));
      }

      var1.setPSWFVersionName(this.calcPSWFVersionName(var1));
      var1.setWFModel(null);
      super.onBeforeCreate(var1);
   }

   protected void onBeforeUpdate(PSWFVersion var1) throws Exception {
      var1.setPSWFVersionName(this.calcPSWFVersionName(var1));
      var1.setWFModel(null);
      super.onBeforeUpdate(var1);
   }

   protected String calcPSWFVersionName(PSWFVersion var1) {
      if (StringHelper.isNullOrEmpty(var1.getPSWFName())) {
         return var1.getPSWFVersionName();
      } else if (DataObject.getBoolValue(var1.getEnableDynaSys(), false)) {
         return StringHelper.format("%1$s", var1.getPSWFName());
      } else if (var1.isWFVersionDirty() && var1.getWFVersion() != null) {
         return StringHelper.format("%1$s v%2$s", var1.getPSWFName(), var1.getWFVersion());
      } else {
         return var1.isDynaWFVerDirty() && var1.getDynaWFVer() != null
            ? StringHelper.format("%1$s v%2$s", var1.getPSWFName(), var1.getDynaWFVer())
            : var1.getPSWFVersionName();
      }
   }

   @Override
   public void getDraftFromWithModel(PSWFVersion var1) throws Exception {
      super.getDraftTempMajorFrom(var1);
      var1.setWFModel(this.getWFModel(var1));
      if (StringHelper.compare(var1.getPSWF().getWFEngineType(), "ACTIVITI", false) == 0) {
         var1.setActivitiModel(this.getActivitiModel(var1));
      }
   }

   protected void resetPSDEUIActions(PSWFVersion var1) throws Exception {
      PSDEUIActionService var2 = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, this.getSessionFactory());
      PSDEUAGroupService var3 = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, this.getSessionFactory());
      PSDEUAGroupDetailService var4 = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, this.getSessionFactory());
      PSWFVersion var5 = new PSWFVersion();
      var5.setPSWFVersionId((String)PSWFVersion.getOriginKey(var1));
      HashMap<String, PSDEUIAction> var6 = new HashMap<String, PSDEUIAction>();
      ArrayList<PSDEUAGroup> var7 = var3.selectByPSWFVersion(var5);

      ArrayList<PSDEUIAction> actions = var2.selectByPSWFVersion(var5);
      for (PSDEUIAction var10 : actions) {
         var6.put(var10.getPSDEUIActionId(), var10);
      }

      for (PSDEUAGroup var15 : var7) {
         for (PSDEUAGroupDetail var13 : var4.selectByPSDEUAGroup(var15)) {
            if (var6.containsKey(var13.getPSDEUIActionId())) {
               var4.remove(var13);
            }
         }
      }
   }

   protected void createPSWFVerBak(PSWFVersion var1) throws Exception {
      boolean var2 = false;
      if (var1.isEnableLogDirty()) {
         var2 = DataObject.getBoolValue(var1.getEnableLog(), false);
      } else {
         PSWFVersion var3 = this.getLast(var1);
         if (var3 != null) {
            var2 = DataObject.getBoolValue(var3.getEnableLog(), false);
         }
      }

      if (var2) {
         ArrayList var15 = new ArrayList();
         PSWFVersion var4 = new PSWFVersion();
         var4.setPSWFVersionId((String)PSWFVersion.getOriginKey(var1));
         this.get(var4);
         this.exportModel(var4, var15);
         if (var15.size() > 0) {
            var15.remove(0);
         }

         net.sf.json.JSONObject var5 = new net.sf.json.JSONObject();
         var5.put("items", var15.toArray());
         String var6 = var5.toString();
         int var7 = var6.length();
         String var8 = Base64Helper.encodeBytes(var6.getBytes("UTF8"), 2);
         int var9 = var8.length();
         String var10 = KeyValueHelper.genUniqueId(var8);
         PSWFVerLogService var11 = (PSWFVerLogService)ServiceGlobal.getService(PSWFVerLogService.class, this.getSessionFactory());
         SelectContext var12 = new SelectContext();
         var12.addSelectField(SelectField.create("PSWFVERLOGID"));
         var12.addSelectField(SelectField.create("BACKDATATAG"));
         var12.setMaxRowCount(1);
         var12.setConditon("PSWFVERSIONID", var4.getPSWFVersionId());
         var12.setOrderInfo("ORDER BY CREATEDATE DESC");
         ArrayList var13 = var11.selectEx(var12);
         if (var13.size() <= 0 || StringHelper.compare(((PSWFVerLog)var13.get(0)).getBackDataTag(), var10, false) != 0) {
            var12.reset();
            var12.addSelectField(SelectField.create("PSWFVERLOGID"));
            var12.setMaxRowCount(20);
            var12.setConditon("PSWFVERSIONID", var4.getPSWFVersionId());
            var12.setOrderInfo("ORDER BY CREATEDATE");
            var13 = var11.selectEx(var12);
            if (var13.size() >= 20) {
               PSWFVerLog var14 = (PSWFVerLog)var13.get(0);
               var11.remove(var14);
            }

            PSWFVerLog var17 = new PSWFVerLog();
            var17.setPSWFVerLogName(StringHelper.format("[%1$s]备份", DateHelper.toDateTimeString(new Date())));
            var17.setPSWFVersionId(var4.getPSWFVersionId());
            var17.setPSWFVersionName(var4.getPSWFVersionName());
            var17.setBackDataTag(var10);
            var17.setBackupData(var8);
            var11.create(var17, false);
         }
      }
   }

   public void restorePSWFVerLog(PSWFVerLog var1) throws Exception {
      final PSWFVerLog var2 = var1;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            PSWFVersionService.this.onRestorePSWFVerLog(var2);
         }
      });
   }

   protected void onRestorePSWFVerLog(PSWFVerLog var1) throws Exception {
      String var2 = new String(Base64Helper.decode(var1.getBackupData()), "UTF8");
      net.sf.json.JSONObject var3 = JSONObjectHelper.fromString(var2);
      net.sf.json.JSONArray var4 = var3.optJSONArray("items");
      if (var4 == null) {
         throw new Exception("备份数据无效");
      }

      for (int var5 = 0; var5 < var4.length(); var5++) {
         net.sf.json.JSONObject var6 = var4.getJSONObject(var5);
         String var7 = var6.optString("srfdename", "");
         if (StringHelper.isNullOrEmpty(var7)) {
            throw new Exception("没有指定导入的数据对象标识");
         }

         try {
            IService var8 = DEModelGlobal.getDEModel(var7).getService(this.getSessionFactory());
            String var9 = var8.importModel(var6);
            if (!StringHelper.isNullOrEmpty(var9)) {
               log.debug(StringHelper.format("[%1$s]导入数据[%2$s]", var8.getDEModel().getName(), var9));
            }
         } catch (Exception var10) {
            throw new Exception(StringHelper.format("导入数据发生异常，%1$s", var10.getMessage()), var10);
         }
      }

      PSWFVersion var11 = new PSWFVersion();
      var11.setPSWFVersionId(var1.getPSWFVersionId());
      this.get(var11);
      var11.set("SRFORIKEY", var1.getPSWFVersionId());
      this.resetPSDEUIActions(var11);
      this.rebuildPSDEUIActions(var11);
   }

   public void rebuildPSDEUIActions(PSWFVersion var1) throws Exception {
      PSDEUIActionService var2 = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, this.getSessionFactory());
      PSDEUAGroupService var3 = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, this.getSessionFactory());
      PSDEUAGroupDetailService var4 = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, this.getSessionFactory());
      PSWFUtilUIActionService var5 = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, this.getSessionFactory());
      boolean var6 = DataObject.getBoolValue(var1.getPSWF().getEnableMob(), false);
      PSWFVersion var7 = new PSWFVersion();
      var7.setPSWFVersionId((String)PSWFVersion.getOriginKey(var1));
      if (StringHelper.isNullOrEmpty(var7.getPSWFVersionId())) {
         var7.setPSWFVersionId(var1.getPSWFVersionId());
      }

      if (!StringHelper.isNullOrEmpty(var7.getPSWFVersionId()) && !KeyValueHelper.isTempKey(var7.getPSWFVersionId())) {
         ArrayList<PSDEUAGroup> var8 = var3.selectByPSWFVersion(var7);
         ArrayList<PSDEUIAction> var9 = var2.selectByPSWFVersion(var7);
         HashMap<String, PSDEUAGroup> var10 = new HashMap<String, PSDEUAGroup>();
         HashMap<String, PSDEUIAction> var11 = new HashMap<String, PSDEUIAction>();

         for (PSDEUAGroup var13 : var8) {
            var10.put(var13.getPSDEUAGroupId(), var13);
         }

         for (PSDEUIAction var38 : var9) {
            var11.put(var38.getPSDEUIActionId(), var38);
         }

         String var37 = var1.getPSWFId();
         String var39 = var7.getPSWFVersionId();
         String var14 = var1.getPSSystemId();
         HashMap var15 = new HashMap();
         WFUtilUIActionType2CodeListModel var16 = (WFUtilUIActionType2CodeListModel)CodeListGlobal.getCodeList(WFUtilUIActionType2CodeListModel.class);
         HashMap var17 = new HashMap();

         for (String var21 : PREDEFINEDACTIONS) {
            PSWFUtilUIAction var22 = new PSWFUtilUIAction();
            var22.setPSWFUtilUIActionId(KeyValueHelper.genUniqueId(var14, var21, var37, var1.getPSWFVersionId()));
            if (var5.get(var22, true)) {
               var17.put(var21, var22);
            } else {
               var22.setPSWFUtilUIActionId(KeyValueHelper.genUniqueId(var14, var21, var37, "__EMTPY__"));
               if (var5.get(var22, true)) {
                  var17.put(var21, var22);
               } else {
                  var22.setPSWFUtilUIActionId(KeyValueHelper.genUniqueId(var14, var21, "__EMTPY__", "__EMTPY__"));
                  if (var5.get(var22, true)) {
                     var17.put(var21, var22);
                  }
               }
            }
         }

         PSWFProcess var40 = null;
         PSWFProcessService var41 = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, this.getSessionFactory());

         for (PSWFProcess var45 : var41.selectByPSWFVersion(var7)) {
            if (StringHelper.compare(var45.getWFProcessType(), "INTERACTIVE", true) == 0 || StringHelper.compare(var45.getWFProcessType(), "START", true) == 0) {
               if (StringHelper.compare(var45.getWFProcessType(), "START", true) == 0) {
                  var40 = var45;
               }

               String var23 = var45.getPSWFProcessId();
               boolean var24 = false;
               if (var10.containsKey(var23)) {
                  var24 = true;
               } else {
                  for (PSDEUAGroup var26 : var8) {
                     if (StringHelper.compare(var26.getPSWFProcessId(), var45.getPSWFProcessId(), false) == 0
                        && StringHelper.compare(var26.getUAGTag(), "IAACTION", false) == 0
                        && StringHelper.isNullOrEmpty(var26.getUAGTag2())) {
                        var23 = var26.getPSDEUAGroupId();
                        var24 = true;
                        break;
                     }
                  }
               }

               PSDEUAGroup var59 = new PSDEUAGroup();
               var59.setPSDEUAGroupId(var23);
               var59.setPSSystemId(var1.getPSWF().getPSSystemId());
               var59.setPSSystemName(var1.getPSWF().getPSSystemName());
               var59.setPSWFId(var1.getPSWFId());
               var59.setPSWFVersionId(var7.getPSWFVersionId());
               var59.setPSDEUAGroupName(var45.getPSWFProcessName());
               var59.setUAGTag("IAACTION");
               var59.setUAGTag2(null);
               var59.setPSWFProcessId(var45.getPSWFProcessId());
               var59.setPSWFProcessName(var45.getPSWFProcessName());
               if (var24) {
                  var3.update(var59);
               } else {
                  var3.create(var59);
               }

               var10.remove(var23);
               var15.put(var45.getPSWFProcessId(), var23);
               if (var6) {
                  var23 = KeyValueHelper.genUniqueId("MOB", var45.getPSWFProcessId());
                  var24 = false;
                  if (var10.containsKey(var23)) {
                     var24 = true;
                  } else {
                     for (PSDEUAGroup var69 : var8) {
                        if (StringHelper.compare(var69.getPSWFProcessId(), var45.getPSWFProcessId(), false) == 0
                           && StringHelper.compare(var69.getUAGTag(), "IAACTION", false) == 0
                           && StringHelper.compare(var69.getUAGTag2(), "MOB", false) == 0) {
                           var23 = var69.getPSDEUAGroupId();
                           var24 = true;
                           break;
                        }
                     }
                  }

                  var59 = new PSDEUAGroup();
                  var59.setPSDEUAGroupId(var23);
                  var59.setPSSystemId(var1.getPSWF().getPSSystemId());
                  var59.setPSSystemName(var1.getPSWF().getPSSystemName());
                  var59.setPSWFId(var1.getPSWFId());
                  var59.setPSWFVersionId(var7.getPSWFVersionId());
                  var59.setPSDEUAGroupName(var45.getPSWFProcessName() + "[移动端]");
                  var59.setUAGTag("IAACTION");
                  var59.setUAGTag2("MOB");
                  var59.setPSWFProcessId(var45.getPSWFProcessId());
                  var59.setPSWFProcessName(var45.getPSWFProcessName());
                  if (var24) {
                     var3.update(var59);
                  } else {
                     var3.create(var59);
                  }

                  var10.remove(var23);
                  var15.put("MOB:" + var45.getPSWFProcessId(), var23);
               }

               if (StringHelper.compare(var45.getWFProcessType(), "INTERACTIVE", true) == 0) {
                  var23 = var45.getPredefinedActions();
                  if (!StringHelper.isNullOrEmpty(var23)) {
                     String[] var54 = var23.split("[;]");

                     for (String var28 : var54) {
                        ICodeItem var29 = var16.getCodeItem(var28);
                        PSWFUtilUIAction var30 = (PSWFUtilUIAction)var17.get(var28);
                        if (var30 == null) {
                           throw new Exception(StringHelper.format("没有获取工作流预定义行为[%1$s]设定", var29.getText()));
                        }

                        String var31 = KeyValueHelper.genUniqueId(var45.getPSWFProcessId(), var28);
                        boolean var32 = false;
                        if (var10.containsKey(var31)) {
                           var32 = true;
                        } else {
                           for (PSDEUAGroup var34 : var8) {
                              if (StringHelper.compare(var34.getPSWFProcessId(), var45.getPSWFProcessId(), false) == 0
                                 && StringHelper.compare(var34.getUAGTag(), "PDACTION", false) == 0
                                 && StringHelper.isNullOrEmpty(var34.getUAGTag2())
                                 && StringHelper.compare(var34.getUAGTag3(), var28, false) == 0) {
                                 var31 = var34.getPSDEUAGroupId();
                                 var32 = true;
                                 break;
                              }
                           }
                        }

                        PSDEUAGroup var105 = new PSDEUAGroup();
                        var105.setPSDEUAGroupId(var31);
                        var105.setPSSystemId(var1.getPSWF().getPSSystemId());
                        var105.setPSSystemName(var1.getPSWF().getPSSystemName());
                        var105.setPSWFId(var1.getPSWFId());
                        var105.setPSWFVersionId(var7.getPSWFVersionId());
                        var105.setPSDEUAGroupName(var45.getPSWFProcessName() + "[" + var29.getText() + "]");
                        var105.setUAGTag("PDACTION");
                        var105.setUAGTag2(null);
                        var105.setUAGTag3(var28);
                        var105.setPSWFProcessId(var45.getPSWFProcessId());
                        var105.setPSWFProcessName(var45.getPSWFProcessName());
                        if (var32) {
                           var3.update(var105);
                        } else {
                           var3.create(var105);
                        }

                        var10.remove(var31);
                        PSDEUAGroupDetail var108 = new PSDEUAGroupDetail();
                        var108.setDetailType("DEUIACTION");
                        var108.setPSDEUAGroupId(var31);
                        var108.setPSDEUIActionId(var30.getPSDEUIActionId());
                        var108.setOrderValue(100);
                        var108.setUIActionParams(StringHelper.format("srfwfid=%1$s\r\nsrfwfversionid=%2$s", var37, var39));
                        var4.save(var108);
                        if (var6) {
                           var31 = KeyValueHelper.genUniqueId("MOB", var45.getPSWFProcessId(), var28);
                           var32 = false;
                           if (var10.containsKey(var31)) {
                              var32 = true;
                           } else {
                              for (PSDEUAGroup var109 : var8) {
                                 if (StringHelper.compare(var109.getPSWFProcessId(), var45.getPSWFProcessId(), false) == 0
                                    && StringHelper.compare(var109.getUAGTag(), "PDACTION", false) == 0
                                    && StringHelper.compare(var109.getUAGTag2(), "MOB", false) == 0
                                    && StringHelper.compare(var109.getUAGTag3(), var28, false) == 0) {
                                    var31 = var109.getPSDEUAGroupId();
                                    var32 = true;
                                    break;
                                 }
                              }
                           }

                           var105 = new PSDEUAGroup();
                           var105.setPSDEUAGroupId(var31);
                           var105.setPSSystemId(var1.getPSWF().getPSSystemId());
                           var105.setPSSystemName(var1.getPSWF().getPSSystemName());
                           var105.setPSWFId(var1.getPSWFId());
                           var105.setPSWFVersionId(var7.getPSWFVersionId());
                           var105.setPSDEUAGroupName(var45.getPSWFProcessName() + "[" + var29.getText() + "][移动端]");
                           var105.setUAGTag("PDACTION");
                           var105.setUAGTag2("MOB");
                           var105.setUAGTag3(var28);
                           var105.setPSWFProcessId(var45.getPSWFProcessId());
                           var105.setPSWFProcessName(var45.getPSWFProcessName());
                           if (var32) {
                              var3.update(var105);
                           } else {
                              var3.create(var105);
                           }

                           var10.remove(var31);
                           var108 = new PSDEUAGroupDetail();
                           var108.setDetailType("DEUIACTION");
                           var108.setPSDEUAGroupId(var31);
                           var108.setPSDEUIActionId(var30.getPSDEUIActionId());
                           var108.setOrderValue(100);
                           var108.setUIActionParams(StringHelper.format("srfwfid=%1$s\r\nsrfwfversionid=%2$s", var37, var39));
                           var4.save(var108);
                        }
                     }
                  }
               }
            }
         }

         PSWFLinkService var44 = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, this.getSessionFactory());

         for (PSWFLink var55 : var44.selectByPSWFVersion(var7)) {
            if (StringHelper.compare(var55.getWFLinkType(), "IAACTION", true) == 0) {
               PSDEUIAction var63 = new PSDEUIAction();
               String var71 = var55.getPSWFLinkId();
               var63.setPSDEUIActionId(var71);
               boolean var77 = false;
               if (var11.containsKey(var71)) {
                  var77 = true;
               }

               var63.setPSWFId(var1.getPSWFId());
               var63.setPSWFVersionId(var7.getPSWFVersionId());
               var63.setCaption(var55.getLogicName());
               var63.setPSDEUIActionName(var55.getLogicName());
               var63.setCodeName(var55.getPSWFLinkName());
               if (!PSModelV2Helper.isCodeName(var55.getPSWFLinkName())) {
                  var63.setCodeName("A" + KeyValueHelper.genUniqueId(var55.getPSWFLinkName()).substring(0, 19));
               }

               var63.setCapPSLanResId(var55.getLNPSLanResId());
               var63.setCapPSLanResName(var55.getLNPSLanResName());
               var63.setTipPSLanResId(var55.getTipPSLanResId());
               var63.setTipPSLanResName(var55.getTipPSLanResName());
               var63.setPSWFLinkName(var55.getPSWFLinkName());
               var63.setActionTarget("MULTIKEY");
               var63.setPSWFProcessId(var55.getFromPSWFProcId());
               var63.setPSWFProcessName(var55.getFromPSWFProcName());
               if (StringHelper.isNullOrEmpty(var55.getPSDEViewBaseId())) {
                  var63.setUIActionType("WFBACKEND");
                  var63.setPSDEViewBaseId(null);
                  var63.setPSDEViewBaseName(null);
                  var63.setFrontProType(null);
               } else {
                  var63.setUIActionType("WFFRONT");
                  var63.setPSDEViewBaseId(var55.getPSDEViewBaseId());
                  var63.setPSDEViewBaseName(var55.getPSDEViewBaseName());
                  var63.setFrontProType("WIZARD");
               }

               try {
                  if (var77) {
                     var2.update(var63);
                  } else {
                     var63.setPSWFLinkId(var55.getPSWFLinkId());
                     var63.setTemplMode(0);
                     var63.setPSSystemId(var1.getPSSystemId());
                     var2.create(var63);
                  }
               } catch (Exception var35) {
                  throw new Exception(String.format("建立流程连接[%1$s]界面行为发生异常，%2$s", var55.getPSWFLinkName(), var35.getMessage()), var35);
               }

               var11.remove(var71);
               String var86 = (String)var15.get(var55.getFromPSWFProcId());
               PSDEUAGroupDetail var94 = new PSDEUAGroupDetail();
               var94.setDetailType("DEUIACTION");
               var94.setPSDEUAGroupId(var86);
               var94.setPSDEUIActionId(var71);
               var94.setOrderValue(var55.getOrderValue());
               var4.save(var94);
               if (var6) {
                  var63 = new PSDEUIAction();
                  var71 = KeyValueHelper.genUniqueId("MOB", var55.getPSWFLinkId());
                  var63.setPSDEUIActionId(var71);
                  var77 = false;
                  if (var11.containsKey(var71)) {
                     var77 = true;
                  }

                  var63.setPSWFId(var1.getPSWFId());
                  var63.setPSWFVersionId(var7.getPSWFVersionId());
                  var63.setCaption(var55.getLogicName());
                  var63.setPSDEUIActionName(var55.getLogicName() + "[移动端]");
                  var63.setCodeName(var55.getPSWFLinkName());
                  if (!PSModelV2Helper.isCodeName(var55.getPSWFLinkName())) {
                     var63.setCodeName("A" + KeyValueHelper.genUniqueId(var55.getPSWFLinkName()).substring(0, 19));
                  }

                  var63.setCapPSLanResId(var55.getLNPSLanResId());
                  var63.setCapPSLanResName(var55.getLNPSLanResName());
                  var63.setTipPSLanResId(var55.getTipPSLanResId());
                  var63.setTipPSLanResName(var55.getTipPSLanResName());
                  var63.setPSWFLinkName(var55.getPSWFLinkName());
                  var63.setActionTarget("MULTIKEY");
                  var63.setPSWFProcessId(var55.getFromPSWFProcId());
                  var63.setPSWFProcessName(var55.getFromPSWFProcName());
                  if (StringHelper.isNullOrEmpty(var55.getMobPSDEViewId())) {
                     var63.setUIActionType("WFBACKEND");
                     var63.setPSDEViewBaseId(null);
                     var63.setPSDEViewBaseName(null);
                     var63.setFrontProType(null);
                  } else {
                     var63.setUIActionType("WFFRONT");
                     var63.setPSDEViewBaseId(var55.getMobPSDEViewId());
                     var63.setPSDEViewBaseName(var55.getMobPSDEViewName());
                     var63.setFrontProType("WIZARD");
                  }

                  if (var77) {
                     var2.update(var63);
                  } else {
                     var63.setPSWFLinkId(var55.getPSWFLinkId());
                     var63.setTemplMode(0);
                     var63.setPSSystemId(var1.getPSSystemId());
                     var2.create(var63);
                  }

                  var11.remove(var71);
                  var86 = (String)var15.get("MOB:" + var55.getFromPSWFProcId());
                  var94 = new PSDEUAGroupDetail();
                  var94.setDetailType("DEUIACTION");
                  var94.setPSDEUAGroupId(var86);
                  var94.setPSDEUIActionId(var71);
                  var94.setOrderValue(var55.getOrderValue());
                  var4.save(var94);
               }
            }
         }

         if (var40 != null) {
            PSDEUIAction var50 = new PSDEUIAction();
            String var56 = KeyValueHelper.genUniqueId(var1.getPSSystemId(), "EDITVIEW_SAVEANDSTARTWFACTION");
            var50.setPSDEUIActionId(var56);
            if (!var2.get(var50, true)) {
               var50 = null;
            }

            String var65 = KeyValueHelper.genUniqueId(var1.getPSWFId(), var7.getPSWFVersionId(), "SAVEANDSTART");
            boolean var73 = false;
            if (var11.containsKey(var65)) {
               var73 = true;
            } else {
               for (PSDEUIAction var88 : var9) {
                  if (StringHelper.compare(var88.getUATag(), "SAVEANDSTART", false) == 0) {
                     var65 = var88.getPSDEUIActionId();
                     var73 = true;
                     break;
                  }
               }
            }

            PSDEUIAction var80 = new PSDEUIAction();
            var80.setPSDEUIActionId(var65);
            var80.setPSWFId(var1.getPSWFId());
            var80.setPSWFVersionId(var7.getPSWFVersionId());
            var80.setUATag("SAVEANDSTART");
            String var89 = var40.getPSWFProcessName();
            var80.setCaption(var89);
            var80.setPSDEUIActionName(var89);
            var80.setCodeName("SaveAndStart");
            var80.setUIActionType("SYS");
            var80.setPSSysUIActionId("EDITVIEW_SAVEANDSTARTWFACTION");
            var80.setCapPSLanResId(var40.getNamePSLanResId());
            var80.setCapPSLanResName(var40.getNamePSLanResName());
            if (var50 != null) {
               var80.setPSDEOPPrivId(var50.getPSDEOPPrivId());
               var80.setPSDEOPPrivName(var50.getPSDEOPPrivName());
            }

            var80.setPSWFProcessId(var40.getPSWFProcessId());
            var80.setPSWFProcessName(var40.getPSWFProcessName());
            if (var73) {
               var2.update(var80);
            } else {
               if (StringHelper.compare(var89, "开始", true) == 0) {
                  var89 = "开始流程";
               }

               var80.setCaption(var89);
               var80.setPSDEUIActionName(var89);
               if (var1.getPSWF() != null) {
                  String var96 = KeyValueHelper.genUniqueId(var1.getPSWF().getPSSystemId(), "IMAGE_010384");
                  PSSysImageService var99 = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, this.getSessionFactory());
                  PSSysImage var103 = new PSSysImage();
                  var103.setPSSysImageId(var96);
                  if (var99.get(var103, true)) {
                     var80.setPSSysImageId(var103.getPSSysImageId());
                     var80.setPSSysImageName(var103.getPSSysImageName());
                  }
               }

               var80.setTemplMode(0);
               var80.setPSSystemId(var1.getPSSystemId());
               var2.create(var80);
            }

            var11.remove(var65);
            String var97 = (String)var15.get(var40.getPSWFProcessId());
            PSDEUAGroupDetail var100 = new PSDEUAGroupDetail();
            var100.setDetailType("DEUIACTION");
            var100.setPSDEUAGroupId(var97);
            var100.setPSDEUIActionId(var65);
            var100.setOrderValue(100);
            var4.save(var100);
            if (var6) {
               var97 = (String)var15.get("MOB:" + var40.getPSWFProcessId());
               var100 = new PSDEUAGroupDetail();
               var100.setDetailType("DEUIACTION");
               var100.setPSDEUAGroupId(var97);
               var100.setPSDEUIActionId(var65);
               var100.setOrderValue(100);
               var4.save(var100);
            }

            if (!StringHelper.isNullOrEmpty(var40.getPSDEViewBaseId())) {
               var65 = KeyValueHelper.genUniqueId(var1.getPSWFId(), var7.getPSWFVersionId(), "WFSTARTWIZARD");
               var73 = false;
               if (var11.containsKey(var65)) {
                  var73 = true;
               } else {
                  for (PSDEUIAction var90 : var9) {
                     if (StringHelper.compare(var90.getUATag(), "WFSTARTWIZARD", false) == 0) {
                        var65 = var90.getPSDEUIActionId();
                        var73 = true;
                        break;
                     }
                  }
               }

               var80 = new PSDEUIAction();
               var80.setPSDEUIActionId(var65);
               var80.setPSWFId(var1.getPSWFId());
               var80.setPSWFVersionId(var7.getPSWFVersionId());
               var80.setUATag("WFSTARTWIZARD");
               var89 = var40.getPSWFProcessName();
               var80.setCaption(var89);
               var80.setPSDEUIActionName(var89);
               var80.setCodeName("WFStartWizard");
               var80.setActionTarget("SINGLEKEY");
               var80.setUIActionType("WFFRONT");
               var80.setPSDEViewBaseId(var40.getPSDEViewBaseId());
               var80.setPSDEViewBaseName(var40.getPSDEViewBaseName());
               var80.setFrontProType("WIZARD");
               var80.setCapPSLanResId(var40.getNamePSLanResId());
               var80.setCapPSLanResName(var40.getNamePSLanResName());
               var80.setPSWFProcessId(var40.getPSWFProcessId());
               var80.setPSWFProcessName(var40.getPSWFProcessName());
               if (var50 != null) {
                  var80.setPSDEOPPrivId(var50.getPSDEOPPrivId());
                  var80.setPSDEOPPrivName(var50.getPSDEOPPrivName());
               }

               if (var73) {
                  var2.update(var80);
               } else {
                  if (StringHelper.compare(var89, "开始", true) == 0) {
                     var89 = "开始流程";
                  }

                  var80.setCaption(var89);
                  var80.setPSDEUIActionName(var89);
                  var80.setTemplMode(0);
                  var80.setPSSystemId(var1.getPSSystemId());
                  var2.create(var80);
               }

               var11.remove(var65);
            }

            if (var6 && !StringHelper.isNullOrEmpty(var40.getMobPSDEViewId())) {
               var65 = KeyValueHelper.genUniqueId(var1.getPSWFId(), var7.getPSWFVersionId(), "MOBWFSTARTWIZARD");
               var73 = false;
               if (var11.containsKey(var65)) {
                  var73 = true;
               } else {
                  for (PSDEUIAction var92 : var9) {
                     if (StringHelper.compare(var92.getUATag(), "MOBWFSTARTWIZARD", false) == 0) {
                        var65 = var92.getPSDEUIActionId();
                        var73 = true;
                        break;
                     }
                  }
               }

               var80 = new PSDEUIAction();
               var80.setPSDEUIActionId(var65);
               var80.setPSWFId(var1.getPSWFId());
               var80.setPSWFVersionId(var7.getPSWFVersionId());
               var80.setUATag("MOBWFSTARTWIZARD");
               var89 = var40.getPSWFProcessName();
               var80.setCaption(var89);
               var80.setPSDEUIActionName(var89 + "[移动端]");
               var80.setCodeName("WFStartWizard");
               var80.setActionTarget("SINGLEKEY");
               var80.setUIActionType("WFFRONT");
               var80.setPSDEViewBaseId(var40.getMobPSDEViewId());
               var80.setPSDEViewBaseName(var40.getMobPSDEViewName());
               var80.setFrontProType("WIZARD");
               var80.setCapPSLanResId(var40.getNamePSLanResId());
               var80.setCapPSLanResName(var40.getNamePSLanResName());
               var80.setPSWFProcessId(var40.getPSWFProcessId());
               var80.setPSWFProcessName(var40.getPSWFProcessName());
               if (var50 != null) {
                  var80.setPSDEOPPrivId(var50.getPSDEOPPrivId());
                  var80.setPSDEOPPrivName(var50.getPSDEOPPrivName());
               }

               if (var73) {
                  var2.update(var80);
               } else {
                  if (StringHelper.compare(var89, "开始", true) == 0) {
                     var89 = "开始流程";
                  }

                  var80.setCaption(var89);
                  var80.setPSDEUIActionName(var89);
                  var80.setTemplMode(0);
                  var80.setPSSystemId(var1.getPSSystemId());
                  var2.create(var80);
               }

               var11.remove(var65);
            }
         }

         for (PSDEUAGroup var57 : var10.values()) {
            var3.remove(var57);
         }

         for (PSDEUIAction var58 : var11.values()) {
            for (PSDEUAGroupDetail var85 : var4.selectByPSDEUAAction(var58)) {
               var4.remove(var85);
            }

            var2.remove(var58);
         }
      } else {
         throw new Exception(StringHelper.format("无法重建工作流界面行为，传入流程版本标识无效"));
      }
   }

   public PSWFVersion getLastPSWFVersion(PSWorkflow var1) throws Exception {
      final PSWorkflow var2 = var1;
      final CallResult var3 = new CallResult();
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            String var2x = "SELECT *  FROM V_PSWFVERSION WHERE PSWFID=? AND ENABLE = 1 ORDER BY WFVERSION DESC";
            SqlParamList var3x = new SqlParamList();
            var3x.addString(var2.getPSWorkflowId());
            IEntity var4 = PSWFVersionService.this.getDAO().executeRawSelectOneSql(null, var2x, var3x);
            if (var4 != null) {
               PSWFVersion var5 = new PSWFVersion();
               var4.copyTo(var5, false);
               var3.setUserObject(var5);
            }
         }
      });
      return var3.getUserObject() == null ? null : (PSWFVersion)var3.getUserObject();
   }

   @Override
   protected void onCalcWFEngineType(PSWFVersion var1) throws Exception {
      if (!StringHelper.isNullOrEmpty(var1.getPSWFId())) {
         var1.setWFEngineType(var1.getPSWF().getWFEngineType());
      }
   }

   protected String getBPMNModel(String var1) throws Exception {
      JsonNode var2 = new ObjectMapper().readTree(var1);
      ObjectNode var3 = (ObjectNode)var2;
      if (var3.has("resourceId")) {
         var3.remove("resourceId");
      }

      var3.put("resourceId", "__WFVERSIONID__");
      if (var3.has("properties")) {
         ObjectNode var4 = (ObjectNode)var3.get("properties");
         if (var4.has("process_id")) {
            var4.remove("process_id");
         }

         var4.put("process_id", "__WFVERSIONID__");
      }

      BpmnJsonConverter var6 = new BpmnJsonConverter();
      BpmnModel var5 = var6.convertToBpmnModel(var2);
      return new String(new BpmnXMLConverter().convertToXML(var5), "UTF-8");
   }

   protected String processBPMNModel(String var1) throws Exception {
      try {
         StringReader var2 = new StringReader(var1);
         InputSource var11 = new InputSource(var2);
         DocumentBuilderFactory var4 = DocumentBuilderFactory.newInstance();
         DocumentBuilder var5 = var4.newDocumentBuilder();
         Document var6 = var5.parse(var11);
         this.changeXmlTagName(var6, "serviceTask", "userTask");
         TransformerFactory var7 = TransformerFactory.newInstance();
         Transformer var8 = var7.newTransformer();
         var8.setOutputProperty("encoding", "UTF-8");
         StringWriter var9 = new StringWriter();
         var8.transform(new DOMSource(var6), new StreamResult(var9));
         return var9.toString();
      } catch (Exception var10) {
         String var3 = StringHelper.format("Activiti流程配置模型处理异常，错误信息：%1$s", var10.getMessage());
         log.error(var3);
         throw new Exception(var3);
      }
   }

   protected void changeXmlTagName(Document var1, String var2, String var3) throws Exception {
      NodeList var4 = var1.getElementsByTagName(var2);

      for (int var5 = 0; var5 < var4.getLength(); var5++) {
         if (var4.item(var5) instanceof Element) {
            Element var6 = (Element)var4.item(var5);
            if (StringHelper.compare(var6.getAttribute("activiti:class"), "DEACTION", true) == 0) {
               var1.renameNode(var6, var6.getNamespaceURI(), var3);
               var6.removeAttribute("activiti:class");
            }
         }
      }
   }

   protected void onAfterCreate(PSWFVersion var1) throws Exception {
      this.initPSDynaWFVer(var1);
      super.onAfterCreate(var1);
   }

   protected void onAfterUpdate(PSWFVersion var1) throws Exception {
      this.initPSDynaWFVer(var1);
      super.onAfterUpdate(var1);
   }

   @Override
   protected void onFillEntityFullInfo_PSDynaWFVer(PSWFVersion var1, boolean var2) throws Exception {
      super.onFillEntityFullInfo_PSDynaWFVer(var1, var2);
      if (!StringHelper.isNullOrEmpty(var1.getPSDynaWFVerId())) {
         if (StringHelper.isNullOrEmpty(var1.getPSWFId())) {
            PSWFVersion var3 = new PSWFVersion();
            var3.setPSWFVersionId(var1.getPSDynaWFVerId());
            this.get(var3);
            var1.setPSWFId(var3.getPSWFId());
            var1.setPSWFName(var3.getPSWFName());
            var1.setWFEngineType(var3.getWFEngineType());
         }

         var1.setDynaSysRefMode(DynaSysRefModeCodeListModel.DYNASYSINST);
      }
   }

   @Override
   protected void onFillParentInfo_PSDynaWFVer(PSWFVersion var1, PSDynaWFVer var2) throws Exception {
      super.onFillParentInfo_PSDynaWFVer(var1, var2);
      if (!StringHelper.isNullOrEmpty(var1.getPSDynaWFVerId()) && StringHelper.isNullOrEmpty(var1.getPSWFId())) {
         PSWFVersion var3 = new PSWFVersion();
         var3.setPSWFVersionId(var1.getPSDynaWFVerId());
         this.get(var3);
         var1.setPSWFId(var3.getPSWFId());
         var1.setPSWFName(var3.getPSWFName());
         var1.setWFEngineType(var3.getWFEngineType());
      }
   }

   protected void initPSDynaWFVer(PSWFVersion var1) throws Exception {
      if (!isImpSysModelNowEx()) {
         if (var1.isEnableDynaSysDirty()) {
            if (DataObject.getBoolValue(var1.getEnableDynaSys(), false)) {
               if (var1.getPSWF() != null) {
                  if (!DataObject.getBoolValue(var1.getPSWF().getEnableDynaSys(), false)) {
                     throw new Exception(StringHelper.format("当前工作流没有启用动态系统功能，不能启用工作流版本的动态功能"));
                  }

                  PSDynaWFVerService var2 = (PSDynaWFVerService)ServiceGlobal.getService(PSDynaWFVerService.class, this.getSessionFactory());
                  PSDynaWFVer var3 = new PSDynaWFVer();
                  var3.setPSDynaWFVerId(var1.getPSWFVersionId());
                  if (var1.isPSWFVersionNameDirty()) {
                     var3.setPSDynaWFVerName(var1.getPSWFVersionName());
                  }

                  if (var1.getPSWF().getPSSystem() != null) {
                     var3.setPSDynaSysId(var1.getPSWF().getPSSystem().getPSSystemId());
                     var3.setPSDynaSysName(var1.getPSWF().getPSSystem().getPSSystemName());
                  }

                  var3.setPSDynaWFId(var1.getPSWF().getPSWorkflowId());
                  var3.setPSDynaWFName(var1.getPSWF().getPSWorkflowName());
                  var2.save(var3);
               }
            }
         }
      }
   }

   @Override
   public String getModelV2Tag(PSWFVersion var1) {
      return var1.getWFVersion() != null ? var1.getWFVersion().toString() : super.getModelV2Tag(var1);
   }
}
