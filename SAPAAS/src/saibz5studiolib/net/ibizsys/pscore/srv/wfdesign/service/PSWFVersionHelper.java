/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.alibaba.fastjson.JSONArray
 *  com.alibaba.fastjson.JSONObject
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.wfdesign.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLink;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkCond;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcSubWF;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcessBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcSubWFService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSWFVersionHelper {
    private static final Log log = LogFactory.getLog(PSWFVersionHelper.class);
    ThreadLocal<SessionFactory> curSessionFactory = new ThreadLocal();
    private static HashMap<String, String> defDataTypeMap = new HashMap();
    private static HashMap<String, String> condOpMap = new HashMap();

    public PSWFVersionHelper(SessionFactory sessionFactory) {
        this.curSessionFactory.set(sessionFactory);
    }

    public SessionFactory getSessionFactory() {
        return this.curSessionFactory.get();
    }

    /*
     * WARNING - void declaration
     */
    protected void updatePSWFVersionModel2(PSWFVersion pSWFVersion, JSONArray jSONArray, HashMap<String, PSWFProcess> hashMap, HashMap<String, PSWFLink> hashMap2) throws Exception {
        void var16_25;
        Object object;
        EntityBase entityBase;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        Object object72;
        HashMap<String, String> hashMap3 = new HashMap<String, String>();
        HashMap<Object, Object> hashMap4 = new HashMap<Object, Object>();
        HashMap<PSWFProcessBase, JSONObject> hashMap5 = new HashMap<PSWFProcessBase, JSONObject>();
        HashMap<Object, EntityBase> hashMap6 = new HashMap<Object, EntityBase>();
        HashMap<String, EntityBase> hashMap7 = new HashMap<String, EntityBase>();
        int n = jSONArray.size();
        PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        HashMap<Object, JSONObject> hashMap8 = new HashMap<Object, JSONObject>();
        for (int i = 0; i < n; ++i) {
            JSONObject jSONObject;
            int n2;
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String object82 = jSONObject2.getString("resourceId");
            object72 = jSONObject2.getJSONObject("properties");
            object6 = jSONObject2.getJSONArray("outgoing");
            if (object6 != null) {
                int n3 = object6.size();
                for (n2 = 0; n2 < n3; ++n2) {
                    JSONObject jSONObject3 = object6.getJSONObject(n2);
                    String string = jSONObject3.getString("resourceId");
                    if (StringHelper.isNullOrEmpty((String)string)) continue;
                    hashMap3.put(string, object82);
                }
            }
            object5 = jSONObject2.getJSONObject("bounds");
            n2 = -1;
            int n4 = -1;
            int n5 = -1;
            int n6 = -1;
            if (object5 != null) {
                object4 = object5.getJSONObject("upperLeft");
                object3 = object5.getJSONObject("lowerRight");
                if (object4 != null) {
                    n2 = object4.getIntValue("x");
                    n4 = object4.getIntValue("y");
                    if (object3 != null) {
                        n5 = object3.getIntValue("x") - n2;
                        n6 = object3.getIntValue("y") - n4;
                    }
                }
            }
            object4 = object72.getString("documentation");
            object3 = object72.getString("name");
            object2 = jSONObject2.getJSONObject("stencil").getString("id");
            entityBase = null;
            if (!(StringHelper.isNullOrEmpty((String)object4) || StringHelper.compare((String)object2, (String)"StartNoneEvent", (boolean)true) != 0 && StringHelper.compare((String)object2, (String)"EndNoneEvent", (boolean)true) != 0 && StringHelper.compare((String)object2, (String)"UserTask", (boolean)true) != 0 && StringHelper.compare((String)object2, (String)"ServiceTask", (boolean)true) != 0 && StringHelper.compare((String)object2, (String)"ExclusiveGateway", (boolean)true) != 0 && StringHelper.compare((String)object2, (String)"InclusiveGateway", (boolean)true) != 0 && StringHelper.compare((String)object2, (String)"ParallelGateway", (boolean)true) != 0 && StringHelper.compare((String)object2, (String)"SubProcess", (boolean)true) != 0 && StringHelper.compare((String)object2, (String)"CatchTimerEvent", (boolean)true) != 0 && StringHelper.compare((String)object2, (String)"CallActivity", (boolean)true) != 0)) {
                entityBase = hashMap.remove(object4);
                if (entityBase == null) {
                    object4 = null;
                } else {
                    hashMap6.put(object4, entityBase);
                    hashMap7.put(object82, entityBase);
                }
            }
            if (StringHelper.isNullOrEmpty((String)object4)) {
                entityBase = null;
                if (StringHelper.compare((String)object2, (String)"StartNoneEvent", (boolean)true) == 0) {
                    entityBase = new PSWFProcess();
                    entityBase.setWFProcessType("START");
                    if (StringHelper.isNullOrEmpty((String)object3)) {
                        object3 = "\u5f00\u59cb";
                    }
                } else if (StringHelper.compare((String)object2, (String)"UserTask", (boolean)true) == 0) {
                    entityBase = new PSWFProcess();
                    entityBase.setWFProcessType("INTERACTIVE");
                    object3 = "\u7528\u6237\u4efb\u52a1";
                } else if (StringHelper.compare((String)object2, (String)"EndNoneEvent", (boolean)true) == 0) {
                    entityBase = new PSWFProcess();
                    entityBase.setWFProcessType("END");
                    if (StringHelper.isNullOrEmpty((String)object3)) {
                        object3 = "\u7ed3\u675f";
                    }
                } else if (StringHelper.compare((String)object2, (String)"ServiceTask", (boolean)true) == 0) {
                    entityBase = new PSWFProcess();
                    entityBase.setWFProcessType("PROCESS");
                    object3 = "\u670d\u52a1\u4efb\u52a1";
                } else if (StringHelper.compare((String)object2, (String)"SubProcess", (boolean)true) == 0) {
                    entityBase = new PSWFProcess();
                    entityBase.setWFProcessType("EMBED");
                    object3 = "\u5b50\u6d41\u7a0b";
                } else if (StringHelper.compare((String)object2, (String)"ExclusiveGateway", (boolean)true) == 0) {
                    entityBase = new PSWFProcess();
                    entityBase.setWFProcessType("EXCLUSIVEGATEWAY");
                    object3 = "\u6392\u5b83\u7f51\u5173";
                } else if (StringHelper.compare((String)object2, (String)"InclusiveGateway", (boolean)true) == 0) {
                    entityBase = new PSWFProcess();
                    entityBase.setWFProcessType("INCLUSIVEGATEWAY");
                    object3 = "\u5305\u5bb9\u7f51\u5173";
                } else if (StringHelper.compare((String)object2, (String)"ParallelGateway", (boolean)true) == 0) {
                    entityBase = new PSWFProcess();
                    entityBase.setWFProcessType("PARALLELGATEWAY");
                    object3 = "\u5e76\u884c\u7f51\u5173";
                } else if (StringHelper.compare((String)object2, (String)"CatchTimerEvent", (boolean)true) == 0) {
                    entityBase = new PSWFProcess();
                    entityBase.setWFProcessType("TIMEREVENT");
                    object3 = "\u5b9a\u65f6\u89e6\u53d1";
                } else if (StringHelper.compare((String)object2, (String)"CallActivity", (boolean)true) == 0) {
                    entityBase = new PSWFProcess();
                    entityBase.setWFProcessType("CALLORGACTIVITY");
                    object3 = "\u8c03\u7528\u7ec4\u7ec7\u6d41\u7a0b";
                }
                if (entityBase != null) {
                    entityBase.setPSWFProcessName((String)object3);
                    entityBase.setModelId(object82);
                    entityBase.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                    entityBase.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                    entityBase.setPSWFId(pSWFVersion.getPSWFId());
                    entityBase.setPSWFName(pSWFVersion.getPSWFName());
                    if (n2 >= 0) {
                        entityBase.setLeftPos(n2);
                    }
                    if (n4 >= 0) {
                        entityBase.setTopPos(n4);
                    }
                    pSWFProcessService.createTemp(entityBase);
                    object72.put("documentation", (Object)entityBase.getPSWFProcessId());
                    object4 = entityBase.getPSWFProcessId();
                    hashMap6.put(object4, entityBase);
                    hashMap7.put(object82, entityBase);
                }
            } else if (entityBase != null) {
                entityBase.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                entityBase.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                entityBase.setPSWFId(pSWFVersion.getPSWFId());
                entityBase.setPSWFName(pSWFVersion.getPSWFName());
                entityBase.setModelId(object82);
                if (n2 >= 0) {
                    entityBase.setLeftPos(n2);
                } else {
                    entityBase.resetLeftPos();
                }
                if (n4 >= 0) {
                    entityBase.setTopPos(n4);
                } else {
                    entityBase.resetTopPos();
                }
                pSWFProcessService.updateTemp((IEntity)entityBase);
            }
            if (!StringHelper.isNullOrEmpty((String)object4)) {
                hashMap4.put(object82, object4);
            }
            if (entityBase != null) {
                object = entityBase.getMultiInstMode();
                if (StringHelper.compare((String)object2, (String)"UserTask", (boolean)true) == 0 && (StringHelper.compare((String)object, (String)"PARALLEL", (boolean)true) == 0 || StringHelper.compare((String)object, (String)"SEQUENTIAL", (boolean)true) == 0)) {
                    hashMap5.put((PSWFProcessBase)entityBase, (JSONObject)object72);
                }
            }
            if (StringHelper.compare((String)object2, (String)"ServiceTask", (boolean)true) == 0) {
                object72.put("servicetaskclass", (Object)"net.ibizsys.pswf.core.ActivitiWFDEActionProcessDelegate");
            }
            if (StringHelper.compare((String)object2, (String)"SubProcess", (boolean)true) == 0) {
                object = jSONObject2.getString("resourceId");
                int arrayList = ((String)object).indexOf("sid-");
                if (arrayList == 0) {
                    object = ((String)object).substring(4);
                }
                jSONObject = this.fillSubProcessModel((PSWFProcess)entityBase, jSONObject2, (String)object);
                hashMap8.put(object, jSONObject);
            }
            if (entityBase != null && StringHelper.compare((String)object2, (String)"CatchTimerEvent", (boolean)true) == 0) {
                object72.put("timerdatedefinition", (Object)StringHelper.format((String)"${ACVTIVEDATA.%1$s}", (Object)entityBase.getTimeoutPSDEFName()));
            }
            if (StringHelper.compare((String)object2, (String)"StartNoneEvent", (boolean)true) != 0 && StringHelper.compare((String)object2, (String)"EndNoneEvent", (boolean)true) != 0 && StringHelper.compare((String)object2, (String)"UserTask", (boolean)true) != 0 && StringHelper.compare((String)object2, (String)"ExclusiveGateway", (boolean)true) != 0 && StringHelper.compare((String)object2, (String)"InclusiveGateway", (boolean)true) != 0 && StringHelper.compare((String)object2, (String)"ParallelGateway", (boolean)true) != 0 && StringHelper.compare((String)object2, (String)"CatchTimerEvent", (boolean)true) != 0) continue;
            object = new ArrayList();
            ArrayList<JSONObject> jSONObject6 = new ArrayList<JSONObject>();
            if (StringHelper.compare((String)object2, (String)"UserTask", (boolean)true) == 0) {
                jSONObject = new JSONObject();
                jSONObject.put("event", (Object)"all");
                jSONObject.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFInteractiveProcessListener");
                jSONObject.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFInteractiveProcessListener");
                jSONObject.put("expression", (Object)"");
                jSONObject.put("delegateExpression", (Object)"");
                ((ArrayList)object).add(jSONObject);
            } else if (StringHelper.compare((String)object2, (String)"StartNoneEvent", (boolean)true) == 0) {
                jSONObject = new JSONObject();
                jSONObject.put("event", (Object)"start");
                jSONObject.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFStartListener");
                jSONObject.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFStartListener");
                jSONObject.put("expression", (Object)"");
                jSONObject.put("delegateExpression", (Object)"");
                jSONObject6.add(jSONObject);
            } else if (StringHelper.compare((String)object2, (String)"EndNoneEvent", (boolean)true) == 0) {
                jSONObject = new JSONObject();
                jSONObject.put("event", (Object)"end");
                jSONObject.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFEndListener");
                jSONObject.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFEndListener");
                jSONObject.put("expression", (Object)"");
                jSONObject.put("delegateExpression", (Object)"");
                jSONObject6.add(jSONObject);
            } else if (StringHelper.compare((String)object2, (String)"CatchTimerEvent", (boolean)true) == 0) {
                jSONObject = new JSONObject();
                jSONObject.put("event", (Object)"start");
                jSONObject.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFIntermediateCatchEventListener");
                jSONObject.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFIntermediateCatchEventListener");
                jSONObject.put("expression", (Object)"");
                jSONObject.put("delegateExpression", (Object)"");
                jSONObject6.add(jSONObject);
            }
            if (((ArrayList)object).size() > 0) {
                jSONObject = new JSONObject();
                jSONObject.put("taskListeners", (Object)((ArrayList)object).toArray());
                object72.put("tasklisteners", (Object)jSONObject);
            }
            if (jSONObject6.size() <= 0) continue;
            jSONObject = new JSONObject();
            jSONObject.put("executionListeners", (Object)jSONObject6.toArray());
            object72.put("executionlisteners", (Object)jSONObject);
        }
        Random random = new Random();
        for (int i = 0; i < jSONArray.size(); ++i) {
            JSONObject jSONObject;
            JSONObject iterator = jSONArray.getJSONObject(i);
            object72 = iterator.getJSONObject("stencil").getString("id");
            if (StringHelper.compare((String)object72, (String)"SequenceFlow", (boolean)true) != 0 && StringHelper.compare((String)object72, (String)"MessageFlow", (boolean)true) != 0) continue;
            object6 = iterator.getString("resourceId");
            object5 = iterator.getJSONObject("properties");
            String string = object5.getString("documentation");
            JSONObject jSONObject4 = iterator.getJSONObject("executionlisteners");
            String string2 = "";
            JSONArray jSONArray2 = iterator.getJSONArray("outgoing");
            if (jSONArray2 != null && jSONArray2.size() > 0) {
                object4 = jSONArray2.getJSONObject(0);
                string2 = object4.getString("resourceId");
            }
            object4 = null;
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                object4 = (PSWFProcess)hashMap7.get(string2);
            }
            object3 = (String)hashMap3.get(object6);
            object2 = null;
            if (!StringHelper.isNullOrEmpty((String)object3)) {
                object2 = (PSWFProcess)hashMap7.get(object3);
            }
            entityBase = null;
            object = object5.getString("name");
            if (!StringHelper.isNullOrEmpty((String)string) && (entityBase = hashMap2.remove(string)) == null) {
                string = null;
            }
            if (entityBase == null) {
                if (StringHelper.compare((String)object72, (String)"SequenceFlow", (boolean)true) == 0 && object2 != null) {
                    entityBase = new PSWFLink();
                    if (StringHelper.compare((String)((PSWFProcessBase)object2).getWFProcessType(), (String)"INTERACTIVE", (boolean)false) == 0) {
                        entityBase.setWFLinkType("IAACTION");
                        int n7 = random.nextInt(100);
                        entityBase.setPSWFLinkName(StringHelper.format((String)"C%1$s", (Object)n7));
                        if (StringHelper.isNullOrEmpty((String)object)) {
                            object = StringHelper.format((String)"\u64cd\u4f5c%1$s", (Object)n7);
                        }
                        entityBase.setLogicName((String)object);
                        entityBase.setOrderValue(100);
                    } else if (StringHelper.compare((String)((PSWFProcessBase)object2).getWFProcessType(), (String)"EMBED", (boolean)false) == 0 || StringHelper.compare((String)((PSWFProcessBase)object2).getWFProcessType(), (String)"CALLORGACTIVITY", (boolean)false) == 0) {
                        entityBase.setWFLinkType("WFRETURN");
                        int n8 = random.nextInt(100);
                        entityBase.setPSWFLinkName(StringHelper.format((String)"C%1$s", (Object)n8));
                        if (StringHelper.isNullOrEmpty((String)object)) {
                            object = StringHelper.format((String)"\u64cd\u4f5c%1$s", (Object)n8);
                        }
                        entityBase.setLogicName((String)object);
                        entityBase.setOrderValue(100);
                    } else {
                        int n9 = random.nextInt(100);
                        entityBase.setWFLinkType("ROUTE");
                        entityBase.setPSWFLinkName(StringHelper.format((String)"\u8fde\u63a5%1$s", (Object)n9));
                        entityBase.setOrderValue(100);
                    }
                }
                if (entityBase != null) {
                    entityBase.setModelId((String)object6);
                    entityBase.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                    entityBase.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                    entityBase.setPSWFId(pSWFVersion.getPSWFId());
                    entityBase.setPSWFName(pSWFVersion.getPSWFName());
                    if (object2 != null) {
                        entityBase.setFromPSWFProcId(((PSWFProcessBase)object2).getPSWFProcessId());
                        entityBase.setFromPSWFProcName(((PSWFProcessBase)object2).getPSWFProcessName());
                    }
                    if (object4 != null) {
                        entityBase.setToPSWFProcId(((PSWFProcessBase)object4).getPSWFProcessId());
                        entityBase.setToPSWFProcName(((PSWFProcessBase)object4).getPSWFProcessName());
                    }
                    pSWFLinkService.createTemp(entityBase);
                    object5.put("documentation", (Object)entityBase.getPSWFLinkId());
                    string = entityBase.getPSWFLinkId();
                }
            } else {
                EntityBase entityBase2;
                Object object8;
                boolean bl = false;
                boolean bl2 = false;
                int n10 = DataObject.getIntegerValue((Object)entityBase.getDefaultLink(), (Integer)0);
                if (n10 == 1) {
                    object5.put("defaultflow", (Object)true);
                } else {
                    object5.put("defaultflow", (Object)false);
                    object8 = "";
                    if (StringHelper.compare((String)entityBase.getWFLinkType(), (String)"IAACTION", (boolean)true) == 0) {
                        object8 = StringHelper.format((String)"${CONNECTION == '%1$s'}", (Object)entityBase.getPSWFLinkName());
                    } else {
                        object8 = entityBase.getCustomCond();
                        if (StringHelper.isNullOrEmpty((String)object8) && pSWFVersion.getPSWF() != null && pSWFVersion.getPSWF().getPSWFDEs().size() > 0) {
                            entityBase2 = pSWFVersion.getPSWF().getPSWFDEs().get(0);
                            object8 = this.getActivitiCustomCond((PSWFLink)entityBase, (PSWFDE)entityBase2);
                        }
                    }
                    if (!StringHelper.isNullOrEmpty((String)object8)) {
                        object5.put("conditionsequenceflow", object8);
                    }
                }
                if (StringHelper.compare((String)entityBase.getModelId(), (String)object6, (boolean)false) != 0) {
                    entityBase.setModelId((String)object6);
                    bl = true;
                }
                if (object2 != null) {
                    if (StringHelper.compare((String)entityBase.getFromPSWFProcId(), (String)((PSWFProcessBase)object2).getPSWFProcessId(), (boolean)false) != 0) {
                        bl = true;
                        entityBase.setFromPSWFProcId(((PSWFProcessBase)object2).getPSWFProcessId());
                        entityBase.setFromPSWFProcName(((PSWFProcessBase)object2).getPSWFProcessName());
                    }
                } else {
                    bl = true;
                    entityBase.setFromPSWFProcId(null);
                    entityBase.setFromPSWFProcName(null);
                }
                if (object4 != null) {
                    if (StringHelper.compare((String)entityBase.getToPSWFProcId(), (String)((PSWFProcessBase)object4).getPSWFProcessId(), (boolean)false) != 0) {
                        bl = true;
                        entityBase.setToPSWFProcId(((PSWFProcessBase)object4).getPSWFProcessId());
                        entityBase.setToPSWFProcName(((PSWFProcessBase)object4).getPSWFProcessName());
                    }
                } else {
                    bl = true;
                    entityBase.setToPSWFProcId(null);
                    entityBase.setToPSWFProcName(null);
                }
                if (object2 != null) {
                    if (StringHelper.compare((String)((PSWFProcessBase)object2).getWFProcessType(), (String)"INTERACTIVE", (boolean)false) == 0) {
                        if (StringHelper.compare((String)entityBase.getWFLinkType(), (String)"IAACTION", (boolean)false) != 0) {
                            bl2 = true;
                            entityBase.setWFLinkType("IAACTION");
                        }
                    } else if (StringHelper.compare((String)((PSWFProcessBase)object2).getWFProcessType(), (String)"EMBED", (boolean)false) == 0 || StringHelper.compare((String)((PSWFProcessBase)object2).getWFProcessType(), (String)"CALLORGACTIVITY", (boolean)false) == 0) {
                        if (StringHelper.compare((String)entityBase.getWFLinkType(), (String)"WFRETURN", (boolean)false) != 0) {
                            bl2 = true;
                            entityBase.setWFLinkType("WFRETURN");
                        }
                    } else if (StringHelper.compare((String)entityBase.getWFLinkType(), (String)"ROUTE", (boolean)false) != 0) {
                        bl2 = true;
                        entityBase.setWFLinkType("ROUTE");
                    }
                } else {
                    bl2 = true;
                    entityBase.setWFLinkType("ROUTE");
                }
                if (bl2 || bl) {
                    pSWFLinkService.updateTemp((IEntity)entityBase);
                }
                if (bl && !StringHelper.isNullOrEmpty((Object)(object8 = entityBase.get("SRFORIKEY")))) {
                    entityBase2 = new PSWFLink();
                    entityBase2.setPSWFLinkId((String)object8);
                    entityBase2.setFromPSWFProcId(null);
                    entityBase2.setToPSWFProcId(null);
                    pSWFLinkService.update(entityBase2, false);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)string)) {
                hashMap4.put(object6, string);
            }
            if (entityBase == null) continue;
            ArrayList<JSONObject> arrayList = new ArrayList<JSONObject>();
            if (StringHelper.compare((String)entityBase.getWFLinkType(), (String)"IAACTION", (boolean)true) == 0) {
                jSONObject = new JSONObject();
                jSONObject.put("event", (Object)"take");
                jSONObject.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFIAActionLinkListener");
                jSONObject.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFIAActionLinkListener");
                jSONObject.put("expression", (Object)"");
                jSONObject.put("delegateExpression", (Object)"");
                arrayList.add(jSONObject);
            } else if (StringHelper.compare((String)entityBase.getWFLinkType(), (String)"WFRETURN", (boolean)true) == 0) {
                jSONObject = new JSONObject();
                jSONObject.put("event", (Object)"take");
                jSONObject.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFIAActionLinkListener");
                jSONObject.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFIAActionLinkListener");
                jSONObject.put("expression", (Object)"");
                jSONObject.put("delegateExpression", (Object)"");
                arrayList.add(jSONObject);
            } else {
                jSONObject = new JSONObject();
                jSONObject.put("event", (Object)"take");
                jSONObject.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFRouteLinkListener");
                jSONObject.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFRouteLinkListener");
                jSONObject.put("expression", (Object)"");
                jSONObject.put("delegateExpression", (Object)"");
                arrayList.add(jSONObject);
            }
            if (object5.containsKey((Object)"executionlisteners")) {
                object5.remove((Object)"executionlisteners");
            }
            if (arrayList.size() <= 0) continue;
            jSONObject = new JSONObject();
            jSONObject.put("executionListeners", (Object)arrayList.toArray());
            object5.put("executionlisteners", (Object)jSONObject);
        }
        for (Map.Entry entry : hashMap5.entrySet()) {
            object72 = ((PSWFProcess)entry.getKey()).getMultiInstMode();
            object6 = (JSONObject)entry.getValue();
            object5 = new PSWFLink();
            ((PSWFLinkBase)object5).setFromPSWFProcId(((PSWFProcess)entry.getKey()).getPSWFProcessId());
            pSWFLinkService.selectTemp(object5, false);
            if (StringHelper.compare((String)object72, (String)"PARALLEL", (boolean)true) == 0) {
                object6.put("multiinstance_type", (Object)"Parallel");
            }
            if (StringHelper.compare((String)object72, (String)"SEQUENTIAL", (boolean)true) == 0) {
                object6.put("multiinstance_type", (Object)"Sequential");
            }
            object6.put("multiinstance_collection", (Object)"SRFASSIGNEELIST");
            object6.put("multiinstance_variable", (Object)"SRFASSIGNEE");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("assignee", (Object)"${SRFASSIGNEE}");
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("assignment", (Object)jSONObject);
            object6.put("usertaskassignment", (Object)jSONObject5);
            String string = ((PSWFLinkBase)object5).getCustomCond();
            if (StringHelper.isNullOrEmpty((String)string)) {
                string = "${nrOfCompletedInstances/nrOfInstances == 1}";
            }
            object6.put("multiinstance_condition", (Object)string);
            JSONArray jSONArray3 = new JSONArray();
            object4 = new JSONObject();
            object4.put("event", (Object)"all");
            object4.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFMultiInstInteractiveProcessListener");
            object4.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFMultiInstInteractiveProcessListener");
            object4.put("expression", (Object)"");
            object4.put("delegateExpression", (Object)"");
            jSONArray3.add(object4);
            object3 = new JSONObject();
            object3.put("taskListeners", (Object)jSONArray3);
            object6.put("tasklisteners", object3);
            object2 = new JSONObject();
            entityBase = new JSONArray();
            object = new JSONObject();
            object.put("event", (Object)"start");
            object.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFMultiInstStartListener");
            object.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFMultiInstStartListener");
            object.put("expression", (Object)"");
            object.put("delegateExpression", (Object)"");
            entityBase.add(object);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("event", (Object)"end");
            jSONObject6.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFMultiInstEndListener");
            jSONObject6.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFMultiInstEndListener");
            jSONObject6.put("expression", (Object)"");
            jSONObject6.put("delegateExpression", (Object)"");
            entityBase.add((Object)jSONObject6);
            object2.put("executionListeners", (Object)entityBase);
            object6.put("executionlisteners", object2);
        }
        Vector vector = new Vector();
        boolean bl = false;
        while (var16_25 < n) {
            String[] stringArray;
            object72 = jSONArray.getJSONObject((int)var16_25);
            object6 = object72.getJSONObject("stencil").getString("id");
            if ((StringHelper.compare((String)object6, (String)"SequenceFlow", (boolean)true) == 0 || StringHelper.compare((String)object6, (String)"MessageFlow", (boolean)true) == 0) && ((String)(object5 = object72.getString("resourceId"))).indexOf("sf_") == 0 && (stringArray = ((String)object5).split("_")).length > 1) {
                String string = stringArray[1];
                if (hashMap8.containsKey(string) && ((HashMap)hashMap8.get(string)).containsKey(object5)) {
                    ((HashMap)hashMap8.get(string)).remove(object5);
                } else {
                    vector.add(object72);
                }
            }
            ++var16_25;
        }
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            object72 = (JSONObject)iterator.next();
            jSONArray.remove(object72);
        }
        for (Object object72 : hashMap8.keySet()) {
            object6 = (HashMap)hashMap8.get(object72);
            for (String string : ((HashMap)object6).keySet()) {
                jSONArray.add(((HashMap)object6).get(string));
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    protected void updatePSWFVersionModel3(PSWFVersion pSWFVersion, JSONArray jSONArray, HashMap<String, PSWFProcess> hashMap, HashMap<String, PSWFLink> hashMap2) throws Exception {
        void var16_25;
        Object object;
        Object object2;
        Object object32;
        Object object4;
        String string;
        Object object5;
        Object object6;
        Object object72;
        HashMap<String, String> hashMap3 = new HashMap<String, String>();
        HashMap<Object, Iterator<Object>> hashMap4 = new HashMap<Object, Iterator<Object>>();
        HashMap<Object, JSONObject> hashMap5 = new HashMap<Object, JSONObject>();
        HashMap<Object, Object> hashMap6 = new HashMap<Object, Object>();
        HashMap<String, Object> hashMap7 = new HashMap<String, Object>();
        int n = jSONArray.size();
        PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        HashMap<Object, JSONObject> hashMap8 = new HashMap<Object, JSONObject>();
        for (int i = 0; i < n; ++i) {
            JSONObject jSONObject;
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String object82 = jSONObject2.getString("resourceId");
            object72 = jSONObject2.getJSONObject("properties");
            object6 = jSONObject2.getJSONArray("outgoing");
            if (object6 != null) {
                int n2 = object6.size();
                for (int j = 0; j < n2; ++j) {
                    object5 = object6.getJSONObject(j);
                    string = object5.getString("resourceId");
                    if (StringHelper.isNullOrEmpty((String)string)) continue;
                    hashMap3.put(string, object82);
                }
            }
            object4 = object72.getString("documentation");
            object32 = object72.getString("name");
            object5 = jSONObject2.getJSONObject("stencil").getString("id");
            string = jSONObject2.getJSONObject("bounds");
            int n3 = -1;
            int n4 = -1;
            int n5 = -1;
            int n6 = -1;
            if (string != null) {
                object2 = string.getJSONObject("upperLeft");
                object = string.getJSONObject("lowerRight");
                if (object2 != null) {
                    n3 = object2.getIntValue("x");
                    n4 = object2.getIntValue("y");
                    if (object != null) {
                        n5 = object.getIntValue("x") - n3;
                        n6 = object.getIntValue("y") - n4;
                    }
                }
            }
            object2 = null;
            if (!(StringHelper.isNullOrEmpty((String)object4) || StringHelper.compare((String)object5, (String)"StartNoneEvent", (boolean)true) != 0 && StringHelper.compare((String)object5, (String)"EndNoneEvent", (boolean)true) != 0 && StringHelper.compare((String)object5, (String)"UserTask", (boolean)true) != 0 && StringHelper.compare((String)object5, (String)"ServiceTask", (boolean)true) != 0 && StringHelper.compare((String)object5, (String)"ExclusiveGateway", (boolean)true) != 0 && StringHelper.compare((String)object5, (String)"InclusiveGateway", (boolean)true) != 0 && StringHelper.compare((String)object5, (String)"ParallelGateway", (boolean)true) != 0 && StringHelper.compare((String)object5, (String)"SubProcess", (boolean)true) != 0 && StringHelper.compare((String)object5, (String)"CatchTimerEvent", (boolean)true) != 0 && StringHelper.compare((String)object5, (String)"CallActivity", (boolean)true) != 0)) {
                object2 = hashMap.remove(object4);
                if (object2 == null) {
                    object4 = null;
                } else {
                    hashMap6.put(object4, object2);
                    hashMap7.put(object82, object2);
                }
            }
            if (StringHelper.isNullOrEmpty(object4)) {
                object2 = null;
                if (StringHelper.compare((String)object5, (String)"StartNoneEvent", (boolean)true) == 0) {
                    object2 = new PSWFProcess();
                    ((PSWFProcessBase)object2).setWFProcessType("START");
                    if (StringHelper.isNullOrEmpty((String)object32)) {
                        object32 = "\u5f00\u59cb";
                    }
                } else if (StringHelper.compare((String)object5, (String)"UserTask", (boolean)true) == 0) {
                    object2 = new PSWFProcess();
                    ((PSWFProcessBase)object2).setWFProcessType("INTERACTIVE");
                    object32 = "\u7528\u6237\u4efb\u52a1";
                } else if (StringHelper.compare((String)object5, (String)"EndNoneEvent", (boolean)true) == 0) {
                    object2 = new PSWFProcess();
                    ((PSWFProcessBase)object2).setWFProcessType("END");
                    if (StringHelper.isNullOrEmpty((String)object32)) {
                        object32 = "\u7ed3\u675f";
                    }
                } else if (StringHelper.compare((String)object5, (String)"ServiceTask", (boolean)true) == 0) {
                    object2 = new PSWFProcess();
                    ((PSWFProcessBase)object2).setWFProcessType("PROCESS");
                    object32 = "\u670d\u52a1\u4efb\u52a1";
                } else if (StringHelper.compare((String)object5, (String)"SubProcess", (boolean)true) == 0) {
                    object2 = new PSWFProcess();
                    ((PSWFProcessBase)object2).setWFProcessType("EMBED");
                    object32 = "\u5b50\u6d41\u7a0b";
                } else if (StringHelper.compare((String)object5, (String)"ExclusiveGateway", (boolean)true) == 0) {
                    object2 = new PSWFProcess();
                    ((PSWFProcessBase)object2).setWFProcessType("EXCLUSIVEGATEWAY");
                    object32 = "\u6392\u5b83\u7f51\u5173";
                } else if (StringHelper.compare((String)object5, (String)"InclusiveGateway", (boolean)true) == 0) {
                    object2 = new PSWFProcess();
                    ((PSWFProcessBase)object2).setWFProcessType("INCLUSIVEGATEWAY");
                    object32 = "\u5305\u5bb9\u7f51\u5173";
                } else if (StringHelper.compare((String)object5, (String)"ParallelGateway", (boolean)true) == 0) {
                    object2 = new PSWFProcess();
                    ((PSWFProcessBase)object2).setWFProcessType("PARALLELGATEWAY");
                    object32 = "\u5e76\u884c\u7f51\u5173";
                } else if (StringHelper.compare((String)object5, (String)"CatchTimerEvent", (boolean)true) == 0) {
                    object2 = new PSWFProcess();
                    ((PSWFProcessBase)object2).setWFProcessType("TIMEREVENT");
                    object32 = "\u5b9a\u65f6\u89e6\u53d1";
                } else if (StringHelper.compare((String)object5, (String)"CallActivity", (boolean)true) == 0) {
                    object2 = new PSWFProcess();
                    ((PSWFProcessBase)object2).setWFProcessType("CALLORGACTIVITY");
                    object32 = "\u8c03\u7528\u7ec4\u7ec7\u6d41\u7a0b";
                }
                if (object2 != null) {
                    ((PSWFProcessBase)object2).setPSWFProcessName((String)object32);
                    ((PSWFProcessBase)object2).setModelId(object82);
                    ((PSWFProcessBase)object2).setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                    ((PSWFProcessBase)object2).setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                    ((PSWFProcessBase)object2).setPSWFId(pSWFVersion.getPSWFId());
                    ((PSWFProcessBase)object2).setPSWFName(pSWFVersion.getPSWFName());
                    if (n3 >= 0) {
                        ((PSWFProcessBase)object2).setLeftPos(n3);
                    }
                    if (n4 >= 0) {
                        ((PSWFProcessBase)object2).setTopPos(n4);
                    }
                    pSWFProcessService.createTemp(object2);
                    object72.put("documentation", (Object)((PSWFProcessBase)object2).getPSWFProcessId());
                    object4 = ((PSWFProcessBase)object2).getPSWFProcessId();
                    hashMap6.put(object4, object2);
                    hashMap7.put(object82, object2);
                }
            } else if (object2 != null) {
                ((PSWFProcessBase)object2).setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                ((PSWFProcessBase)object2).setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                ((PSWFProcessBase)object2).setPSWFId(pSWFVersion.getPSWFId());
                ((PSWFProcessBase)object2).setPSWFName(pSWFVersion.getPSWFName());
                ((PSWFProcessBase)object2).setModelId(object82);
                if (n3 >= 0) {
                    ((PSWFProcessBase)object2).setLeftPos(n3);
                } else {
                    ((PSWFProcessBase)object2).resetLeftPos();
                }
                if (n4 >= 0) {
                    ((PSWFProcessBase)object2).setTopPos(n4);
                } else {
                    ((PSWFProcessBase)object2).resetTopPos();
                }
                pSWFProcessService.updateTemp((IEntity)object2);
            }
            if (!StringHelper.isNullOrEmpty(object4)) {
                hashMap4.put(object82, (Iterator<Object>)object4);
            }
            if (object2 != null) {
                object = ((PSWFProcessBase)object2).getMultiInstMode();
                if (StringHelper.compare((String)object5, (String)"UserTask", (boolean)true) == 0 && (StringHelper.compare((String)object, (String)"PARALLEL", (boolean)true) == 0 || StringHelper.compare((String)object, (String)"SEQUENTIAL", (boolean)true) == 0)) {
                    hashMap5.put(object2, (JSONObject)object72);
                }
            }
            if (StringHelper.compare((String)object5, (String)"ServiceTask", (boolean)true) == 0) {
                if (object2 != null && StringHelper.compare((String)((PSWFProcessBase)object2).getNormalProcType(), (String)"DEACTION", (boolean)true) == 0) {
                    object72.put("servicetaskclass", (Object)"DEACTION");
                } else if (object72.containsKey((Object)"servicetaskclass")) {
                    object72.remove((Object)"servicetaskclass");
                }
            }
            if (StringHelper.compare((String)object5, (String)"SubProcess", (boolean)true) == 0) {
                object = jSONObject2.getString("resourceId");
                int arrayList = ((String)object).indexOf("sid-");
                if (arrayList == 0) {
                    object = ((String)object).substring(4);
                }
                jSONObject = this.fillSubProcessModel((PSWFProcess)object2, jSONObject2, (String)object);
                hashMap8.put(object, jSONObject);
            }
            if (object2 != null && StringHelper.compare((String)object5, (String)"CatchTimerEvent", (boolean)true) == 0) {
                object72.put("timerdatedefinition", (Object)StringHelper.format((String)"${ACVTIVEDATA.%1$s}", (Object)((PSWFProcessBase)object2).getTimeoutPSDEFName()));
            }
            if (StringHelper.compare((String)object5, (String)"StartNoneEvent", (boolean)true) != 0 && StringHelper.compare((String)object5, (String)"EndNoneEvent", (boolean)true) != 0 && StringHelper.compare((String)object5, (String)"UserTask", (boolean)true) != 0 && StringHelper.compare((String)object5, (String)"ExclusiveGateway", (boolean)true) != 0 && StringHelper.compare((String)object5, (String)"InclusiveGateway", (boolean)true) != 0 && StringHelper.compare((String)object5, (String)"ParallelGateway", (boolean)true) != 0 && StringHelper.compare((String)object5, (String)"CatchTimerEvent", (boolean)true) != 0) continue;
            object = new ArrayList();
            ArrayList<JSONObject> jSONObject5 = new ArrayList<JSONObject>();
            if (StringHelper.compare((String)object5, (String)"UserTask", (boolean)true) == 0) {
                jSONObject = new JSONObject();
                jSONObject.put("event", (Object)"all");
                jSONObject.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFInteractiveProcessListener");
                jSONObject.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFInteractiveProcessListener");
                jSONObject.put("expression", (Object)"");
                jSONObject.put("delegateExpression", (Object)"");
                ((ArrayList)object).add(jSONObject);
            } else if (StringHelper.compare((String)object5, (String)"StartNoneEvent", (boolean)true) == 0) {
                jSONObject = new JSONObject();
                jSONObject.put("event", (Object)"start");
                jSONObject.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFStartListener");
                jSONObject.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFStartListener");
                jSONObject.put("expression", (Object)"");
                jSONObject.put("delegateExpression", (Object)"");
                jSONObject5.add(jSONObject);
            } else if (StringHelper.compare((String)object5, (String)"EndNoneEvent", (boolean)true) == 0) {
                jSONObject = new JSONObject();
                jSONObject.put("event", (Object)"end");
                jSONObject.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFEndListener");
                jSONObject.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFEndListener");
                jSONObject.put("expression", (Object)"");
                jSONObject.put("delegateExpression", (Object)"");
                jSONObject5.add(jSONObject);
            } else if (StringHelper.compare((String)object5, (String)"CatchTimerEvent", (boolean)true) == 0) {
                jSONObject = new JSONObject();
                jSONObject.put("event", (Object)"start");
                jSONObject.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFIntermediateCatchEventListener");
                jSONObject.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFIntermediateCatchEventListener");
                jSONObject.put("expression", (Object)"");
                jSONObject.put("delegateExpression", (Object)"");
                jSONObject5.add(jSONObject);
            }
            if (((ArrayList)object).size() > 0) {
                jSONObject = new JSONObject();
                jSONObject.put("taskListeners", (Object)((ArrayList)object).toArray());
                object72.put("tasklisteners", (Object)jSONObject);
            }
            if (jSONObject5.size() <= 0) continue;
            jSONObject = new JSONObject();
            jSONObject.put("executionListeners", (Object)jSONObject5.toArray());
            object72.put("executionlisteners", (Object)jSONObject);
        }
        Random random = new Random();
        for (int i = 0; i < jSONArray.size(); ++i) {
            JSONObject jSONObject;
            Object object8;
            JSONObject iterator = jSONArray.getJSONObject(i);
            object72 = iterator.getJSONObject("stencil").getString("id");
            if (StringHelper.compare((String)object72, (String)"SequenceFlow", (boolean)true) != 0 && StringHelper.compare((String)object72, (String)"MessageFlow", (boolean)true) != 0) continue;
            object6 = iterator.getString("resourceId");
            object4 = iterator.getJSONObject("properties");
            object32 = object4.getString("documentation");
            object5 = iterator.getJSONObject("executionlisteners");
            string = "";
            JSONArray jSONArray2 = iterator.getJSONArray("outgoing");
            if (jSONArray2 != null && jSONArray2.size() > 0) {
                object8 = jSONArray2.getJSONObject(0);
                string = object8.getString("resourceId");
            }
            object8 = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                object8 = (PSWFProcess)hashMap7.get(string);
            }
            String string2 = (String)hashMap3.get(object6);
            PSWFProcess pSWFProcess = null;
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                pSWFProcess = (PSWFProcess)hashMap7.get(string2);
            }
            object2 = null;
            object = object4.getString("name");
            if (!StringHelper.isNullOrEmpty((String)object32) && (object2 = hashMap2.remove(object32)) == null) {
                object32 = null;
            }
            if (object2 == null) {
                if (StringHelper.compare((String)object72, (String)"SequenceFlow", (boolean)true) == 0 && pSWFProcess != null) {
                    object2 = new PSWFLink();
                    if (StringHelper.compare((String)pSWFProcess.getWFProcessType(), (String)"INTERACTIVE", (boolean)false) == 0) {
                        ((PSWFLinkBase)object2).setWFLinkType("IAACTION");
                        int n7 = random.nextInt(100);
                        ((PSWFLinkBase)object2).setPSWFLinkName(StringHelper.format((String)"C%1$s", (Object)n7));
                        if (StringHelper.isNullOrEmpty((String)object)) {
                            object = StringHelper.format((String)"\u64cd\u4f5c%1$s", (Object)n7);
                        }
                        ((PSWFLinkBase)object2).setLogicName((String)object);
                        ((PSWFLinkBase)object2).setOrderValue(100);
                    } else if (StringHelper.compare((String)pSWFProcess.getWFProcessType(), (String)"EMBED", (boolean)false) == 0 || StringHelper.compare((String)pSWFProcess.getWFProcessType(), (String)"CALLORGACTIVITY", (boolean)false) == 0) {
                        ((PSWFLinkBase)object2).setWFLinkType("WFRETURN");
                        int n8 = random.nextInt(100);
                        ((PSWFLinkBase)object2).setPSWFLinkName(StringHelper.format((String)"C%1$s", (Object)n8));
                        if (StringHelper.isNullOrEmpty((String)object)) {
                            object = StringHelper.format((String)"\u64cd\u4f5c%1$s", (Object)n8);
                        }
                        ((PSWFLinkBase)object2).setLogicName((String)object);
                        ((PSWFLinkBase)object2).setOrderValue(100);
                    } else {
                        int n9 = random.nextInt(100);
                        ((PSWFLinkBase)object2).setWFLinkType("ROUTE");
                        ((PSWFLinkBase)object2).setPSWFLinkName(StringHelper.format((String)"\u8fde\u63a5%1$s", (Object)n9));
                        ((PSWFLinkBase)object2).setOrderValue(100);
                    }
                }
                if (object2 != null) {
                    ((PSWFLinkBase)object2).setModelId((String)object6);
                    ((PSWFLinkBase)object2).setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                    ((PSWFLinkBase)object2).setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                    ((PSWFLinkBase)object2).setPSWFId(pSWFVersion.getPSWFId());
                    ((PSWFLinkBase)object2).setPSWFName(pSWFVersion.getPSWFName());
                    if (pSWFProcess != null) {
                        ((PSWFLinkBase)object2).setFromPSWFProcId(pSWFProcess.getPSWFProcessId());
                        ((PSWFLinkBase)object2).setFromPSWFProcName(pSWFProcess.getPSWFProcessName());
                    }
                    if (object8 != null) {
                        ((PSWFLinkBase)object2).setToPSWFProcId(((PSWFProcessBase)object8).getPSWFProcessId());
                        ((PSWFLinkBase)object2).setToPSWFProcName(((PSWFProcessBase)object8).getPSWFProcessName());
                    }
                    pSWFLinkService.createTemp(object2);
                    object4.put("documentation", (Object)((PSWFLinkBase)object2).getPSWFLinkId());
                    object32 = ((PSWFLinkBase)object2).getPSWFLinkId();
                }
            } else {
                EntityBase entityBase;
                Object object9;
                boolean bl = false;
                boolean bl2 = false;
                int n10 = DataObject.getIntegerValue((Object)((PSWFLinkBase)object2).getDefaultLink(), (Integer)0);
                if (n10 == 1) {
                    object4.put("defaultflow", (Object)true);
                } else {
                    object4.put("defaultflow", (Object)false);
                    object9 = "";
                    if (StringHelper.compare((String)((PSWFLinkBase)object2).getWFLinkType(), (String)"IAACTION", (boolean)true) == 0) {
                        object9 = StringHelper.format((String)"${CONNECTION == '%1$s'}", (Object)((PSWFLinkBase)object2).getPSWFLinkName());
                    } else {
                        object9 = ((PSWFLinkBase)object2).getCustomCond();
                        if (StringHelper.isNullOrEmpty((String)object9) && pSWFVersion.getPSWF() != null && pSWFVersion.getPSWF().getPSWFDEs().size() > 0) {
                            entityBase = pSWFVersion.getPSWF().getPSWFDEs().get(0);
                            object9 = this.getActivitiCustomCond((PSWFLink)object2, (PSWFDE)entityBase);
                        }
                    }
                    if (!StringHelper.isNullOrEmpty((String)object9)) {
                        object4.put("conditionsequenceflow", object9);
                    }
                }
                if (StringHelper.compare((String)((PSWFLinkBase)object2).getModelId(), (String)object6, (boolean)false) != 0) {
                    ((PSWFLinkBase)object2).setModelId((String)object6);
                    bl = true;
                }
                if (pSWFProcess != null) {
                    if (StringHelper.compare((String)((PSWFLinkBase)object2).getFromPSWFProcId(), (String)pSWFProcess.getPSWFProcessId(), (boolean)false) != 0) {
                        bl = true;
                        ((PSWFLinkBase)object2).setFromPSWFProcId(pSWFProcess.getPSWFProcessId());
                        ((PSWFLinkBase)object2).setFromPSWFProcName(pSWFProcess.getPSWFProcessName());
                    }
                } else {
                    bl = true;
                    ((PSWFLinkBase)object2).setFromPSWFProcId(null);
                    ((PSWFLinkBase)object2).setFromPSWFProcName(null);
                }
                if (object8 != null) {
                    if (StringHelper.compare((String)((PSWFLinkBase)object2).getToPSWFProcId(), (String)((PSWFProcessBase)object8).getPSWFProcessId(), (boolean)false) != 0) {
                        bl = true;
                        ((PSWFLinkBase)object2).setToPSWFProcId(((PSWFProcessBase)object8).getPSWFProcessId());
                        ((PSWFLinkBase)object2).setToPSWFProcName(((PSWFProcessBase)object8).getPSWFProcessName());
                    }
                } else {
                    bl = true;
                    ((PSWFLinkBase)object2).setToPSWFProcId(null);
                    ((PSWFLinkBase)object2).setToPSWFProcName(null);
                }
                if (pSWFProcess != null) {
                    if (StringHelper.compare((String)pSWFProcess.getWFProcessType(), (String)"INTERACTIVE", (boolean)false) == 0) {
                        if (StringHelper.compare((String)((PSWFLinkBase)object2).getWFLinkType(), (String)"IAACTION", (boolean)false) != 0) {
                            bl2 = true;
                            ((PSWFLinkBase)object2).setWFLinkType("IAACTION");
                        }
                    } else if (StringHelper.compare((String)pSWFProcess.getWFProcessType(), (String)"EMBED", (boolean)false) == 0 || StringHelper.compare((String)pSWFProcess.getWFProcessType(), (String)"CALLORGACTIVITY", (boolean)false) == 0) {
                        if (StringHelper.compare((String)((PSWFLinkBase)object2).getWFLinkType(), (String)"WFRETURN", (boolean)false) != 0) {
                            bl2 = true;
                            ((PSWFLinkBase)object2).setWFLinkType("WFRETURN");
                        }
                    } else if (StringHelper.compare((String)((PSWFLinkBase)object2).getWFLinkType(), (String)"ROUTE", (boolean)false) != 0) {
                        bl2 = true;
                        ((PSWFLinkBase)object2).setWFLinkType("ROUTE");
                    }
                } else {
                    bl2 = true;
                    ((PSWFLinkBase)object2).setWFLinkType("ROUTE");
                }
                if (bl2 || bl) {
                    pSWFLinkService.updateTemp((IEntity)object2);
                }
                if (bl && !StringHelper.isNullOrEmpty((Object)(object9 = ((PSWFLinkBase)object2).get("SRFORIKEY")))) {
                    entityBase = new PSWFLink();
                    entityBase.setPSWFLinkId((String)object9);
                    entityBase.setFromPSWFProcId(null);
                    entityBase.setToPSWFProcId(null);
                    pSWFLinkService.update(entityBase, false);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)object32)) {
                hashMap4.put(object6, (Iterator<Object>)object32);
            }
            if (object2 == null) continue;
            ArrayList<JSONObject> arrayList = new ArrayList<JSONObject>();
            if (StringHelper.compare((String)((PSWFLinkBase)object2).getWFLinkType(), (String)"IAACTION", (boolean)true) == 0) {
                jSONObject = new JSONObject();
                jSONObject.put("event", (Object)"take");
                jSONObject.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFIAActionLinkListener");
                jSONObject.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFIAActionLinkListener");
                jSONObject.put("expression", (Object)"");
                jSONObject.put("delegateExpression", (Object)"");
                arrayList.add(jSONObject);
            } else if (StringHelper.compare((String)((PSWFLinkBase)object2).getWFLinkType(), (String)"WFRETURN", (boolean)true) == 0) {
                jSONObject = new JSONObject();
                jSONObject.put("event", (Object)"take");
                jSONObject.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFIAActionLinkListener");
                jSONObject.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFIAActionLinkListener");
                jSONObject.put("expression", (Object)"");
                jSONObject.put("delegateExpression", (Object)"");
                arrayList.add(jSONObject);
            } else {
                jSONObject = new JSONObject();
                jSONObject.put("event", (Object)"take");
                jSONObject.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFRouteLinkListener");
                jSONObject.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFRouteLinkListener");
                jSONObject.put("expression", (Object)"");
                jSONObject.put("delegateExpression", (Object)"");
                arrayList.add(jSONObject);
            }
            if (object4.containsKey((Object)"executionlisteners")) {
                object4.remove((Object)"executionlisteners");
            }
            if (arrayList.size() <= 0) continue;
            jSONObject = new JSONObject();
            jSONObject.put("executionListeners", (Object)arrayList.toArray());
            object4.put("executionlisteners", (Object)jSONObject);
        }
        for (Map.Entry entry : hashMap5.entrySet()) {
            object72 = ((PSWFProcess)entry.getKey()).getMultiInstMode();
            object6 = (JSONObject)entry.getValue();
            object4 = new PSWFLink();
            ((PSWFLinkBase)object4).setFromPSWFProcId(((PSWFProcess)entry.getKey()).getPSWFProcessId());
            pSWFLinkService.selectTemp(object4, false);
            if (StringHelper.compare((String)object72, (String)"PARALLEL", (boolean)true) == 0) {
                object6.put("multiinstance_type", (Object)"Parallel");
            }
            if (StringHelper.compare((String)object72, (String)"SEQUENTIAL", (boolean)true) == 0) {
                object6.put("multiinstance_type", (Object)"Sequential");
            }
            object6.put("multiinstance_collection", (Object)"SRFASSIGNEELIST");
            object6.put("multiinstance_variable", (Object)"SRFASSIGNEE");
            object32 = new JSONObject();
            object32.put("assignee", (Object)"${SRFASSIGNEE}");
            object5 = new JSONObject();
            object5.put("assignment", object32);
            object6.put("usertaskassignment", object5);
            string = ((PSWFLinkBase)object4).getCustomCond();
            if (StringHelper.isNullOrEmpty((String)string)) {
                string = "${nrOfCompletedInstances/nrOfInstances == 1}";
            }
            object6.put("multiinstance_condition", (Object)string);
            JSONArray jSONArray3 = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", (Object)"all");
            jSONObject.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFMultiInstInteractiveProcessListener");
            jSONObject.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFMultiInstInteractiveProcessListener");
            jSONObject.put("expression", (Object)"");
            jSONObject.put("delegateExpression", (Object)"");
            jSONArray3.add((Object)jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("taskListeners", (Object)jSONArray3);
            object6.put("tasklisteners", (Object)jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            object2 = new JSONArray();
            object = new JSONObject();
            object.put("event", (Object)"start");
            object.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFMultiInstStartListener");
            object.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFMultiInstStartListener");
            object.put("expression", (Object)"");
            object.put("delegateExpression", (Object)"");
            object2.add(object);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("event", (Object)"end");
            jSONObject4.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFMultiInstEndListener");
            jSONObject4.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFMultiInstEndListener");
            jSONObject4.put("expression", (Object)"");
            jSONObject4.put("delegateExpression", (Object)"");
            object2.add((Object)jSONObject4);
            jSONObject3.put("executionListeners", object2);
            object6.put("executionlisteners", (Object)jSONObject3);
        }
        Vector vector = new Vector();
        boolean bl = false;
        while (var16_25 < n) {
            object72 = jSONArray.getJSONObject((int)var16_25);
            object6 = object72.getJSONObject("stencil").getString("id");
            if ((StringHelper.compare((String)object6, (String)"SequenceFlow", (boolean)true) == 0 || StringHelper.compare((String)object6, (String)"MessageFlow", (boolean)true) == 0) && ((String)(object4 = object72.getString("resourceId"))).indexOf("sf_") == 0 && ((String[])(object32 = ((String)object4).split("_"))).length > 1) {
                object5 = object32[1];
                if (hashMap8.containsKey(object5) && ((HashMap)hashMap8.get(object5)).containsKey(object4)) {
                    ((HashMap)hashMap8.get(object5)).remove(object4);
                } else {
                    vector.add(object72);
                }
            }
            ++var16_25;
        }
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            object72 = (JSONObject)iterator.next();
            jSONArray.remove(object72);
        }
        for (Object object72 : hashMap8.keySet()) {
            object6 = (HashMap)hashMap8.get(object72);
            for (Object object32 : ((HashMap)object6).keySet()) {
                jSONArray.add(((HashMap)object6).get(object32));
            }
        }
    }

    protected HashMap<String, JSONObject> fillSubProcessModel(PSWFProcess pSWFProcess, JSONObject jSONObject, String string) {
        HashMap<String, JSONObject> hashMap = new HashMap<String, JSONObject>();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("properties");
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("event", (Object)"start");
            jSONObject4.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFSubProcessStartListener");
            jSONObject4.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFSubProcessStartListener");
            jSONObject4.put("expression", (Object)"");
            jSONObject4.put("delegateExpression", (Object)"");
            jSONArray.add((Object)jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("event", (Object)"end");
            jSONObject5.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFSubProcessEndListener");
            jSONObject5.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFSubProcessEndListener");
            jSONObject5.put("expression", (Object)"");
            jSONObject5.put("delegateExpression", (Object)"");
            jSONArray.add((Object)jSONObject5);
            jSONObject3.put("executionListeners", (Object)jSONArray);
            jSONObject2.put("executionlisteners", (Object)jSONObject3);
            int n = 0;
            JSONArray jSONArray2 = new JSONArray();
            PSWFProcSubWFService pSWFProcSubWFService = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSWFProcSubWF> arrayList = pSWFProcSubWFService.selectTempByPSWFProcess(pSWFProcess);
            String string2 = "";
            String string3 = StringHelper.format((String)"st_%1$s", (Object)string);
            String string4 = StringHelper.format((String)"ed_%1$s", (Object)string);
            JSONObject jSONObject6 = this.getJOShape("StartNoneEvent", string3, "\u5f00\u59cb");
            jSONObject6.put("bounds", (Object)this.getJOBounds(15.0, 30.0, 45.0, 60.0));
            JSONObject jSONObject7 = this.getJOShape("EndNoneEvent", string4, "\u7ed3\u675f");
            jSONObject7.put("bounds", (Object)this.getJOBounds(300.0, 60.0, 328.0, 88.0));
            for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
                String string5 = StringHelper.format((String)"ca_%1$s_%2$s", (Object)string, (Object)n);
                String string6 = pSWFProcSubWF.getPSWFProcSubWFName();
                String string7 = pSWFProcSubWF.getEmbedPSWFId();
                String string8 = pSWFProcSubWF.getEmbedPSWFVerId();
                if (!StringHelper.isNullOrEmpty((String)string8)) {
                    string8 = StringHelper.format((String)"WFVER%1$s", (Object)string8);
                }
                String string9 = pSWFProcSubWF.getEmbedPSDEId();
                String string10 = pSWFProcSubWF.getEmbedPSDEDSName();
                String string11 = StringHelper.format((String)"sf_%1$s_%2$s_s", (Object)string, (Object)n);
                JSONObject jSONObject8 = this.getJOSequenceFlow(string11, "", "", string5);
                String string12 = StringHelper.format((String)"sf_%1$s_%2$s_e", (Object)string, (Object)n);
                JSONObject jSONObject9 = this.getJOSequenceFlow(string12, "", "", string4);
                JSONObject jSONObject10 = this.getJOShape("CallActivity", string5, string6);
                JSONObject jSONObject11 = jSONObject10.getJSONObject("properties");
                jSONObject11.put("asynchronousdefinition", (Object)"false");
                jSONObject11.put("exclusivedefinition", (Object)"false");
                jSONObject11.put("executionlisteners", (Object)this.getJOActivitiExecutionListeners(string9, string7, string8, string10));
                jSONObject11.put("callactivitycalledelement", (Object)string8);
                jSONObject11.put("callactivityinparameters", (Object)this.getJOActivitiParameters());
                jSONObject11.put("callactivityoutparameters", (Object)"");
                jSONObject11.put("multiinstance_type", (Object)"Parallel");
                jSONObject11.put("callactivityoutparameters", (Object)"");
                jSONObject11.put("multiinstance_cardinality", (Object)"");
                jSONObject11.put("multiinstance_collection", (Object)"BUSINESSKEYLIST");
                jSONObject11.put("multiinstance_variable", (Object)"BUSINESSKEY");
                jSONObject11.put("multiinstance_condition", (Object)"${nrOfCompletedInstances/nrOfInstances == 1}");
                jSONObject11.put("isforcompensation", (Object)"false");
                jSONObject10.put("bounds", (Object)this.getJOBounds(125.0, 15 + n * 55, 225.0, 65 + n * 55));
                jSONObject10.put("outgoing", (Object)this.getJAOutgoing(string12));
                jSONArray2.add((Object)jSONObject10);
                hashMap.put(string11, jSONObject8);
                hashMap.put(string12, jSONObject9);
                ++n;
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    string2 = string2 + ",";
                }
                string2 = string2 + string11;
            }
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                jSONObject6.put("outgoing", (Object)this.getJAOutgoing(string2));
            }
            jSONArray2.add((Object)jSONObject6);
            jSONArray2.add((Object)jSONObject7);
            jSONObject.put("childShapes", (Object)jSONArray2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return hashMap;
    }

    protected JSONObject getJOShape(String string, String string2, String string3) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("resourceId", (Object)string2);
        JSONObject jSONObject2 = this.getJOProperties(string3, "");
        jSONObject.put("properties", (Object)jSONObject2);
        jSONObject.put("stencil", (Object)this.getJOStendcil(string));
        jSONObject.put("outgoing", (Object)new JSONArray());
        jSONObject.put("childShapes", (Object)new JSONArray());
        jSONObject.put("dockers", (Object)new JSONArray());
        return jSONObject;
    }

    protected JSONObject getJOProperties(String string, String string2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("overrideid", (Object)"");
        jSONObject.put("name", (Object)string);
        jSONObject.put("documentation", (Object)string2);
        jSONObject.put("executionlisteners", (Object)"");
        return jSONObject;
    }

    protected JSONObject getJOStendcil(String string) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", (Object)string);
        return jSONObject;
    }

    protected JSONObject getJOTarget(String string) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("resourceId", (Object)string);
        return jSONObject;
    }

    protected JSONArray getJAOutgoing(String string) {
        JSONArray jSONArray = new JSONArray();
        if (!StringHelper.isNullOrEmpty((String)string)) {
            for (String string2 : string.split(",")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resourceId", (Object)string2);
                jSONArray.add((Object)jSONObject);
            }
        }
        return jSONArray;
    }

    protected JSONObject getJOSequenceFlow(String string, String string2, String string3, String string4) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("resourceId", (Object)string);
        jSONObject.put("properties", (Object)this.getJOProperties("", "subprocess"));
        jSONObject.put("stencil", (Object)this.getJOStendcil("SequenceFlow"));
        jSONObject.put("childShapes", (Object)new JSONArray());
        jSONObject.put("outgoing", (Object)this.getJAOutgoing(string4));
        jSONObject.put("bounds", (Object)this.getJOBounds(15.0, 15.0, 50.0, 50.0));
        jSONObject.put("dockers", (Object)this.getJADockers(15.0, 15.0, 50.0, 40.0));
        jSONObject.put("target", (Object)this.getJOTarget(string4));
        return jSONObject;
    }

    protected JSONObject getJOActivitiParameters() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.add((Object)this.getJOParam("BUSINESSKEY", "SRFKEY"));
        jSONArray.add((Object)this.getJOParam("SUBWFVERSIONID", "WFVERSIONID"));
        jSONArray.add((Object)this.getJOParam("SUBWFWORKFLOWID", "WFWORKFLOWID"));
        jSONArray.add((Object)this.getJOParam("SUBOPPERSONID", "SRFOPPERSONID"));
        jSONArray.add((Object)this.getJOParam("SUBDEID", "SRFDEID"));
        jSONArray.add((Object)this.getJOParam("SUBPINSTANCEID", "SRFPINSTANCEID"));
        jSONArray.add((Object)this.getJOParam("SUBPSTEPID", "SRFPSTEPID"));
        jSONObject.put("inParameters", (Object)jSONArray);
        return jSONObject;
    }

    protected JSONObject getJOParam(String string, String string2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("source", (Object)string);
        jSONObject.put("sourceExpression", (Object)"");
        jSONObject.put("target", (Object)string2);
        return jSONObject;
    }

    protected JSONObject getJOActivitiExecutionListeners(String string, String string2, String string3, String string4) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("event", (Object)"start");
        jSONObject2.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFCallActivitiStartListener");
        jSONObject2.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFCallActivitiStartListener");
        jSONObject2.put("expression", (Object)"");
        jSONObject2.put("delegateExpression", (Object)"");
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.add((Object)this.getJOField("SUBDEID", string));
        jSONArray2.add((Object)this.getJOField("SUBWFWORKFLOWID", string2));
        jSONArray2.add((Object)this.getJOField("SUBWFVERSIONID", string3));
        jSONArray2.add((Object)this.getJOField("SUBDSID", string4));
        jSONObject2.put("fields", (Object)jSONArray2);
        jSONArray.add((Object)jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("event", (Object)"end");
        jSONObject3.put("implementation", (Object)"net.ibizsys.pswf.core.ActivitiWFCallActivitiEndListener");
        jSONObject3.put("className", (Object)"net.ibizsys.pswf.core.ActivitiWFCallActivitiEndListener");
        jSONObject3.put("expression", (Object)"");
        jSONObject3.put("delegateExpression", (Object)"");
        jSONArray.add((Object)jSONObject3);
        jSONObject.put("executionListeners", (Object)jSONArray);
        return jSONObject;
    }

    protected JSONObject getJOField(String string, String string2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", (Object)string);
        jSONObject.put("implementation", (Object)string2);
        jSONObject.put("string", (Object)string2);
        jSONObject.put("stringValue", (Object)"");
        jSONObject.put("expression", (Object)"");
        return jSONObject;
    }

    protected JSONObject getJOBounds(double d, double d2, double d3, double d4) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("x", (Object)d);
        jSONObject2.put("y", (Object)d2);
        jSONObject.put("upperLeft", (Object)jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("x", (Object)d3);
        jSONObject3.put("y", (Object)d4);
        jSONObject.put("lowerRight", (Object)jSONObject3);
        return jSONObject;
    }

    protected JSONArray getJADockers(double d, double d2, double d3, double d4) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("x", (Object)d);
        jSONObject.put("y", (Object)d2);
        jSONArray.add((Object)jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("x", (Object)d3);
        jSONObject2.put("y", (Object)d4);
        jSONArray.add((Object)jSONObject2);
        return jSONArray;
    }

    protected String getActivitiCustomCond(PSWFLink pSWFLink, PSWFDE pSWFDE) throws Exception {
        Object object;
        ArrayList<PSWFLinkCond> arrayList = pSWFLink.getPSWFLinkConds();
        if (arrayList.size() == 0) {
            return "";
        }
        Collections.sort(arrayList, new Comparator<PSWFLinkCond>(){

            @Override
            public int compare(PSWFLinkCond pSWFLinkCond, PSWFLinkCond pSWFLinkCond2) {
                try {
                    int n = DataObject.getIntegerValue((Object)pSWFLinkCond.getOrderValue(), (Integer)99999999);
                    int n2 = DataObject.getIntegerValue((Object)pSWFLinkCond2.getOrderValue(), (Integer)99999999);
                    if (n > n2) {
                        return 1;
                    }
                    if (n < n2) {
                        return -1;
                    }
                }
                catch (Exception exception) {
                    log.error((Object)exception);
                }
                return 0;
            }
        });
        HashMap<String, PSDEField> hashMap = new HashMap<String, PSDEField>();
        if (pSWFDE.getPSDE() != null) {
            object = pSWFDE.getPSDE().getPSDEFields();
            Iterator<PSDEField> iterator = ((ArrayList)object).iterator();
            while (iterator.hasNext()) {
                PSDEField pSDEField = iterator.next();
                hashMap.put(pSDEField.getPSDEFieldId(), pSDEField);
                hashMap.put(pSDEField.getPSDEFieldName().toUpperCase(), pSDEField);
            }
        }
        if (!StringHelper.isNullOrEmpty((String)(object = this.getActivitiCustomCond(null, arrayList, hashMap)))) {
            return StringHelper.format((String)"${%1$s}", (Object)object);
        }
        return "";
    }

    protected String getActivitiCustomCond(PSWFLinkCond pSWFLinkCond, ArrayList<PSWFLinkCond> arrayList, HashMap<String, PSDEField> hashMap) throws Exception {
        String string = "";
        String string2 = " && ";
        if (pSWFLinkCond != null) {
            string2 = StringHelper.compare((String)pSWFLinkCond.getGroupOP(), (String)"AND", (boolean)false) == 0 ? " && " : " || ";
        }
        for (PSWFLinkCond pSWFLinkCond2 : arrayList) {
            if (pSWFLinkCond == null ? !StringHelper.isNullOrEmpty((String)pSWFLinkCond2.getPPSWFLinkCondId()) : StringHelper.compare((String)pSWFLinkCond2.getPPSWFLinkCondId(), (String)pSWFLinkCond.getPSWFLinkCondId(), (boolean)false) != 0) continue;
            String string3 = "";
            if (StringHelper.compare((String)pSWFLinkCond2.getLogicType(), (String)"GROUP", (boolean)true) == 0) {
                string3 = this.getActivitiCustomCond(pSWFLinkCond2, arrayList, hashMap);
            } else {
                String string4;
                String string5;
                if (StringHelper.compare((String)pSWFLinkCond2.getLogicType(), (String)"SINGLE", (boolean)true) != 0) continue;
                PSDEField pSDEField = null;
                String string6 = null;
                if (!StringHelper.isNullOrEmpty((String)pSWFLinkCond2.getCustomDSTParam())) {
                    pSDEField = hashMap.get(pSWFLinkCond2.getCustomDSTParam().toUpperCase());
                } else if (!StringHelper.isNullOrEmpty((String)pSWFLinkCond2.getDstPSDEFId())) {
                    pSDEField = hashMap.get(pSWFLinkCond2.getDstPSDEFId());
                } else if (!StringHelper.isNullOrEmpty((String)pSWFLinkCond2.getDstPSDEFName())) {
                    pSDEField = hashMap.get(pSWFLinkCond2.getDstPSDEFName().toUpperCase());
                }
                string6 = pSWFLinkCond2.getCustomDSTParam();
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    string6 = pSDEField != null ? pSDEField.getPSDEFieldName() : pSWFLinkCond2.getDstPSDEFName();
                }
                int n = 25;
                if (pSDEField != null) {
                    n = this.getPSDEFieldStdDataType(pSDEField, 1);
                }
                if (StringHelper.isNullOrEmpty((String)(string5 = this.getCondOp(string4 = pSWFLinkCond2.getPSDBValueOPId())))) continue;
                if (DataTypeHelper.isStringDataType((int)n)) {
                    string3 = StringHelper.format((String)"ACTIVEDATA.%1$s %2$s '%3$s'", (Object)string6, (Object)string5, (Object)pSWFLinkCond2.getCondValue());
                } else if (DataTypeHelper.isIntType((int)n) || DataTypeHelper.isDoubleType((int)n)) {
                    string3 = StringHelper.format((String)"ACTIVEDATA.%1$s %2$s %3$s", (Object)string6, (Object)string5, (Object)pSWFLinkCond2.getCondValue());
                } else if (DataTypeHelper.isDateTimeDataType((int)n)) {
                    string3 = StringHelper.format((String)"ACTIVEDATA.%1$s %2$s '%3$s'", (Object)string6, (Object)string5, (Object)pSWFLinkCond2.getCondValue());
                }
            }
            if (StringHelper.isNullOrEmpty((String)string3)) continue;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + string2;
            }
            string = string + string3;
        }
        if (!StringHelper.isNullOrEmpty((String)string)) {
            string = StringHelper.format((String)"(%1$s)", (Object)string);
        }
        return string;
    }

    protected int getPSDEFieldStdDataType(PSDEField pSDEField, int n) throws Exception {
        if (n >= 10) {
            return 25;
        }
        if (pSDEField.getDERPSDEF() != null) {
            return this.getPSDEFieldStdDataType(pSDEField.getDERPSDEF(), n++);
        }
        String string = pSDEField.getPSDataTypeId();
        String string2 = defDataTypeMap.get(string);
        return DataTypeHelper.fromString((String)string2, (boolean)true);
    }

    protected String getCondOp(String string) throws Exception {
        return condOpMap.get(string);
    }

    static {
        defDataTypeMap.put("ACID", "BIGINT");
        defDataTypeMap.put("BIGINT", "BIGINT");
        defDataTypeMap.put("CODELISTTEXT", "VARCHAR");
        defDataTypeMap.put("CURRENCY", "VARCHAR");
        defDataTypeMap.put("CURRENCYUNIT", "VARCHAR");
        defDataTypeMap.put("DATE", "DATETIME");
        defDataTypeMap.put("DATETIME", "DATETIME");
        defDataTypeMap.put("DATETIME_BIRTHDAY", "DATETIME");
        defDataTypeMap.put("DECIMAL", "DECIMAL");
        defDataTypeMap.put("FLOAT", "FLOAT");
        defDataTypeMap.put("GUID", "VARCHAR");
        defDataTypeMap.put("HTMLTEXT", "TEXT");
        defDataTypeMap.put("INHERIT", "(\u8fde\u63a5\u5c5e\u6027\u7c7b\u578b)");
        defDataTypeMap.put("INT", "INT");
        defDataTypeMap.put("LONGTEXT", "TEXT");
        defDataTypeMap.put("LONGTEXT_1000", "VARCHAR");
        defDataTypeMap.put("NBID", "INT");
        defDataTypeMap.put("NMCODELIST", "INT");
        defDataTypeMap.put("NSCODELIST", "INT");
        defDataTypeMap.put("PICKUP", "(\u8fde\u63a5\u5c5e\u6027\u7c7b\u578b)");
        defDataTypeMap.put("PICKUPDATA", "(\u8fde\u63a5\u5c5e\u6027\u7c7b\u578b)");
        defDataTypeMap.put("PICKUPTEXT", "(\u8fde\u63a5\u5c5e\u6027\u7c7b\u578b)");
        defDataTypeMap.put("SBID", "VARCHAR");
        defDataTypeMap.put("SMCODELIST", "VARCHAR");
        defDataTypeMap.put("SSCODELIST", "VARCHAR");
        defDataTypeMap.put("TEXT", "VARCHAR");
        defDataTypeMap.put("TEXT_EMAIL", "VARCHAR");
        defDataTypeMap.put("TIME", "VARCHAR");
        defDataTypeMap.put("TRUEFALSE", "INT");
        defDataTypeMap.put("VARBINARY", "VARBINARY");
        defDataTypeMap.put("WFSTATE", "INT");
        defDataTypeMap.put("YESNO", "INT");
        condOpMap.put("EQ", "==");
        condOpMap.put("GT", ">");
        condOpMap.put("GTANDEQ", ">=");
        condOpMap.put("LT", "<");
        condOpMap.put("LTANDEQ", "<=");
        condOpMap.put("NOTEQ", "!=");
    }
}

