/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.util.Base64Helper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.util.JsonUtils
 *  net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSModelRT;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.util.JsonUtils;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSModelRTDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSModelRTDataCtrl.class);
    private static Map<String, Pattern> regExPatternMap = new HashMap<String, Pattern>();
    public static final int PATTERN_MAXCACHE = 2000;
    public static final String CUSTOMCALL_LISTMODELRT = "LISTMODELRT";
    public static final String CUSTOMCALL_INSPECTMODELRT = "INSPECTMODELRT";
    public static final String TAG_MODELLIST = "SRFMODELLIST";

    public static Pattern getPattern(String strRegEx) {
        Pattern p = regExPatternMap.get(strRegEx);
        if (p == null) {
            p = Pattern.compile(strRegEx);
            if (regExPatternMap.size() > 2000) {
                regExPatternMap.clear();
            }
            regExPatternMap.put(strRegEx, p);
        }
        return p;
    }

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_LISTMODELRT, (boolean)true) == 0) {
            return this.listCodes(dataEntity);
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INSPECTMODELRT, (boolean)true) == 0) {
            return this.inspectModelRT(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public static String toJsonString(ArrayList<PSModelRT> psModelRTList) throws Exception {
        return PSModelRTDataCtrl.toJsonString(psModelRTList, false);
    }

    public static String toJsonString(ArrayList<PSModelRT> psModelRTList, boolean bConvertTime) throws Exception {
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSModelRT baseDataEntity : psModelRTList) {
            JSONObject jo = BaseDataEntity.ToJSONObject((BaseDataEntity)baseDataEntity, (boolean)false);
            if (bConvertTime) {
                jo = DataObject.convertJSONValueTimeFmt((JSONObject)jo, (String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL");
            }
            list.add(jo);
        }
        return JSONArray.fromArray((Object[])list.toArray()).toString();
    }

    public CallResult listCodes(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSModelRT psModelRT = new PSModelRT();
            psModelRT.proxy(dataEntity);
            this.onListCodes(psModelRT);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6a21\u578b\u8fd0\u884c\u65f6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onListCodes(PSModelRT psModelRT) throws Exception {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        PSModels.setPSSysAppId(null);
        String strPSSystemId = psModelRT.getParamStringValue("PSSYSTEMID", "");
        String strPSDevSlnSysId = psModelRT.getParamStringValue("PSDEVSLNSYSID", "");
        String strPSSysAppId = psModelRT.getParamStringValue("PSSYSAPPID", "");
        String strPSDEId = psModelRT.getParamStringValue("srfdeid", "");
        String strKey = psModelRT.getParamStringValue("srfkey", "");
        boolean bV6Mode = psModelRT.GetParamBoolValue("V6MODE", false);
        String strPSModelRTId = psModelRT.getPSMODELRTID();
        boolean bDebugMode = PSTaskServerEnvImpl.getCurrent().isDebugMode();
        PSModels.setPSSysAppId(strPSSysAppId);
        IPSSystem iPSSystem = this.getPSSystem(strPSDevSlnSysId, strPSSystemId, IPSSystem.LOADLEVEL_CODE, true);
        IPSSystemUtil iPSSystemUtil = (IPSSystemUtil)((Object)iPSSystem);
        ArrayList<PSModelRT> psModelRTList = new ArrayList<PSModelRT>();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSModelRTId)) {
            ArrayList<IPSObject> list = iPSSystemUtil.getPSModels(strPSDEId, strKey);
            for (IPSObject iPSObject : list) {
                if (!(iPSObject instanceof IPSModelObject)) continue;
                IPSModelObject iPSModelObject = (IPSModelObject)iPSObject;
                PSModelRT psModelRT2 = new PSModelRT();
                psModelRT2.setLEAFFLAG(false);
                psModelRT2.setRTTYPE("PSOBJECT");
                psModelRT2.setPSMODELRTNAME(SA.SRFramework.Utility.StringHelper.Format((String)"[%1$s]%2$s", (Object)PSModels.getModelName((String)iPSModelObject.getModelType()), (Object)iPSModelObject.getModelName()));
                psModelRT2.setPSMODELRTID(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s@%2$s@%3$s", (Object)"PSOBJECT", (Object)iPSModelObject.getModelType(), (Object)iPSModelObject.getId()));
                psModelRT2.setPSMODELRTID(String.valueOf(psModelRT2.getPSMODELRTID()) + "@" + KeyValueHelper.genGuidEx());
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSModelObject.getModelType())) {
                    psModelRT2.setICONPATH(SA.SRFramework.Utility.StringHelper.Format((String)"default/de/icon_%1$s.png", (Object)iPSModelObject.getModelType().toLowerCase()));
                } else {
                    psModelRT2.setICONPATH(SA.SRFramework.Utility.StringHelper.Format((String)"default/icon_alert.png"));
                }
                psModelRT2.setORDERVALUE(100);
                psModelRTList.add(psModelRT2);
            }
        } else {
            IPSObject iPSObject;
            Iterator<IPSObject> iterator;
            ArrayList<IPSObject> list;
            String[] items = strPSModelRTId.split("[@]");
            if (SA.SRFramework.Utility.StringHelper.Compare((String)items[0], (String)"PSOBJECT", (boolean)true) == 0) {
                IPSObject iPSObject2;
                Iterator<IPSObject> psModelRT2;
                String strModelId = items[2].replace("__*__", "@");
                ArrayList<IPSObject> list2 = iPSSystemUtil.getPSModels(items[1], strModelId);
                if (list2.size() > 0 && (psModelRT2 = list2.iterator()).hasNext() && (iPSObject2 = psModelRT2.next()) instanceof IPSModelObject) {
                    Method[] methods;
                    int n;
                    IPSModelObject iPSModelObject = (IPSModelObject)iPSObject2;
                    String strModelType = iPSModelObject.getModelType(items[1]);
                    HashMap<String, Method> clsMethodMap = null;
                    Class<?> intClass = iPSModelObject.getModelClass(strModelType);
                    if (intClass != null) {
                        Method[] methods2;
                        clsMethodMap = new HashMap<String, Method>();
                        Method[] methodArray = methods2 = intClass.getMethods();
                        n = methods2.length;
                        int n2 = 0;
                        while (n2 < n) {
                            Method m = methodArray[n2];
                            clsMethodMap.put(m.getName(), m);
                            ++n2;
                        }
                    }
                    Class<?> modelCls = iPSModelObject.getClass();
                    Method[] methodArray = methods = modelCls.getMethods();
                    int n3 = methods.length;
                    n = 0;
                    while (n < n3) {
                        block85: {
                            PSModelRTMeta meta;
                            Method m = methodArray[n];
                            if (!(clsMethodMap != null && !clsMethodMap.containsKey(m.getName()) || (meta = m.getAnnotation(PSModelRTMeta.class)) == null || meta.debugmode() && !bDebugMode)) {
                                try {
                                    Object objValue;
                                    String strText;
                                    PSModelRT psModelRT22;
                                    block84: {
                                        psModelRT22 = new PSModelRT();
                                        if (meta.hidemethod()) {
                                            psModelRT22.setPSMODELRTID(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s@%2$s@%3$s@%4$s", (Object)"METHOD", (Object)"__HIDE__", (Object)strModelType, (Object)iPSModelObject.getModelId(strModelType).replace("@", "__*__")));
                                        } else {
                                            psModelRT22.setPSMODELRTID(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s@%2$s@%3$s@%4$s", (Object)"METHOD", (Object)m.getName(), (Object)strModelType, (Object)iPSModelObject.getModelId(strModelType).replace("@", "__*__")));
                                        }
                                        psModelRT22.setPSMODELRTID(String.valueOf(psModelRT22.getPSMODELRTID()) + "@" + KeyValueHelper.genGuidEx());
                                        psModelRT22.setLEAFFLAG(true);
                                        psModelRT22.setORDERVALUE(meta.order());
                                        psModelRT22.setICONPATH("icon_itemparam.png");
                                        psModelRT22.setRTTYPE("VALUE");
                                        strText = meta.name();
                                        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strText)) {
                                            strText = bV6Mode ? m.getName() : "<input type=\"text\" value=\"" + m.getName() + "\"/>";
                                        }
                                        if (meta.hidemethod()) {
                                            strText = "";
                                        }
                                        if (bV6Mode) {
                                            psModelRT22.setMETHODNAME(strText);
                                        }
                                        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)meta.description())) {
                                            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strText)) {
                                                strText = String.valueOf(strText) + "#";
                                            }
                                            strText = String.valueOf(strText) + SA.SRFramework.Utility.StringHelper.Format((String)"%1$s", (Object)meta.description());
                                        }
                                        objValue = null;
                                        try {
                                            objValue = SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)meta.displayvalue()) ? m.invoke(iPSModelObject, new Object[0]) : meta.displayvalue();
                                        }
                                        catch (Exception ex2) {
                                            objValue = ex2.getMessage();
                                            if (!StringHelper.isNullOrEmpty((Object)objValue)) break block84;
                                            if (ex2.getCause() != null) {
                                                objValue = ex2.getCause().getMessage();
                                            }
                                            if (!StringHelper.isNullOrEmpty((Object)objValue)) break block84;
                                            objValue = "!\u672a\u77e5\u5f02\u5e38";
                                        }
                                    }
                                    if (objValue == null) {
                                        if (!bV6Mode && (meta.hideempty() || meta.hideempty2())) break block85;
                                        strText = String.valueOf(strText) + SA.SRFramework.Utility.StringHelper.Format((String)" ==> (null)");
                                    } else if (objValue instanceof IPSModelObject) {
                                        IPSModelObject iPSModelObject2 = (IPSModelObject)objValue;
                                        String strModelType2 = iPSModelObject2.getModelType(meta.modeltype());
                                        psModelRT22.setRTTYPE("PSOBJECT");
                                        psModelRT22.setLEAFFLAG(false);
                                        strText = String.valueOf(strText) + SA.SRFramework.Utility.StringHelper.Format((String)" ==> {[%1$s]%2$s}", (Object)PSModels.getModelName((String)strModelType2), (Object)iPSModelObject2.getModelName(strModelType2));
                                        psModelRT22.setPSMODELRTID(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s@%2$s@%3$s", (Object)"PSOBJECT", (Object)strModelType2, (Object)iPSModelObject2.getModelId(strModelType2).replace("@", "__*__")));
                                        psModelRT22.setPSMODELRTID(String.valueOf(psModelRT22.getPSMODELRTID()) + "@" + KeyValueHelper.genGuidEx());
                                        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strModelType2)) {
                                            psModelRT22.setICONPATH(SA.SRFramework.Utility.StringHelper.Format((String)"default/icon_alert.png"));
                                        } else {
                                            psModelRT22.setICONPATH(SA.SRFramework.Utility.StringHelper.Format((String)"default/de/icon_%1$s.png", (Object)strModelType2.toLowerCase()));
                                        }
                                    } else if (objValue instanceof Iterator || objValue instanceof ArrayList || objValue.getClass().isArray()) {
                                        int nCount = 0;
                                        psModelRT22.setICONPATH("icon_group.png");
                                        if (objValue instanceof Iterator) {
                                            Iterator it = (Iterator)objValue;
                                            while (it.hasNext()) {
                                                Object objItem = it.next();
                                                ++nCount;
                                            }
                                        } else if (objValue instanceof ArrayList) {
                                            for (Object objItem : (ArrayList)objValue) {
                                                ++nCount;
                                            }
                                        } else if (objValue.getClass().isArray()) {
                                            if (objValue instanceof Object[]) {
                                                nCount = ((Object[])objValue).length;
                                            } else if (objValue instanceof double[]) {
                                                nCount = ((double[])objValue).length;
                                            } else if (objValue instanceof int[]) {
                                                nCount = ((int[])objValue).length;
                                            } else {
                                                nCount = 1;
                                            }
                                        }
                                        if (nCount == 0 && !bV6Mode && meta.hideempty2()) break block85;
                                        strText = String.valueOf(strText) + SA.SRFramework.Utility.StringHelper.Format((String)" ==> [%1$s]", (Object)nCount);
                                        psModelRT22.setLEAFFLAG(false);
                                    } else {
                                        if (!bV6Mode && meta.hideempty2() && objValue instanceof String && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)((String)objValue))) break block85;
                                        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)meta.hidevalues())) {
                                            String[] values = meta.hidevalues().split("[;]");
                                            String strValue = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s", (Object)objValue);
                                            boolean bHide = false;
                                            String[] stringArray = values;
                                            int n4 = values.length;
                                            int n5 = 0;
                                            while (n5 < n4) {
                                                String strItem = stringArray[n5];
                                                if (SA.SRFramework.Utility.StringHelper.Compare((String)strValue, (String)strItem, (boolean)true) == 0) {
                                                    bHide = true;
                                                    break;
                                                }
                                                ++n5;
                                            }
                                            if (bHide) break block85;
                                        }
                                        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)meta.codelist())) {
                                            strText = String.valueOf(strText) + SA.SRFramework.Utility.StringHelper.Format((String)" ==> %1$s", (Object)this.getShortContent(objValue, !bV6Mode));
                                        } else {
                                            try {
                                                String strCodeListId = SA.SRFramework.Utility.StringHelper.Format((String)"net.ibizsys.pscore.srv.codelist.%1$sCodeListModel", (Object)meta.codelist());
                                                ICodeListModel iCodeListModel = (ICodeListModel)CodeListGlobal.getCodeList((String)strCodeListId);
                                                if (iCodeListModel != null) {
                                                    String strCodeItemText = iCodeListModel.getCodeListText(objValue.toString(), true);
                                                    strText = String.valueOf(strText) + SA.SRFramework.Utility.StringHelper.Format((String)" ==> %1$s(%2$s) [%3$s]", (Object)strCodeItemText, (Object)objValue, (Object)meta.codelist());
                                                } else {
                                                    strText = String.valueOf(strText) + SA.SRFramework.Utility.StringHelper.Format((String)" ==> (%1$s)!\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%2$s]", (Object)objValue, (Object)meta.codelist());
                                                }
                                            }
                                            catch (Exception e) {
                                                strText = String.valueOf(strText) + SA.SRFramework.Utility.StringHelper.Format((String)" ==> (%1$s)!%2$s[%3$s]", (Object)objValue, (Object)meta.codelist(), (Object)e.getMessage());
                                                log.error((Object)e);
                                            }
                                        }
                                    }
                                    psModelRT22.setPSMODELRTNAME(strText);
                                    psModelRTList.add(psModelRT22);
                                }
                                catch (Exception e) {
                                    log.error((Object)e);
                                    psModelRTList.clear();
                                    PSModelRT psModelRT23 = new PSModelRT();
                                    psModelRT23.setPSMODELRTID(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s@%2$s@%3$s@%4$s", (Object)"METHOD", (Object)m.getName(), (Object)iPSModelObject.getModelType(), (Object)iPSModelObject.getModelId().replace("@", "__*__")));
                                    psModelRT23.setPSMODELRTID(String.valueOf(psModelRT23.getPSMODELRTID()) + "@" + KeyValueHelper.genGuidEx());
                                    psModelRT23.setLEAFFLAG(true);
                                    psModelRT23.setRTTYPE("VALUE");
                                    psModelRT23.setPSMODELRTNAME(e.getMessage());
                                    psModelRT23.setICONPATH(SA.SRFramework.Utility.StringHelper.Format((String)"icon_dgexcell.png"));
                                    psModelRT23.setORDERVALUE(0);
                                    psModelRTList.add(psModelRT23);
                                }
                            }
                        }
                        ++n;
                    }
                }
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)items[0], (String)"METHOD", (boolean)true) == 0 && (list = iPSSystemUtil.getPSModels(items[2], items[3])).size() > 0 && (iterator = list.iterator()).hasNext() && (iPSObject = iterator.next()) instanceof IPSModelObject) {
                Method[] methods;
                IPSModelObject iPSModelObject = (IPSModelObject)iPSObject;
                String strModelType = iPSModelObject.getModelType(items[2]);
                Class<?> modelCls = iPSModelObject.getClass();
                Method[] methodArray = methods = modelCls.getMethods();
                int n = methods.length;
                int n6 = 0;
                while (n6 < n) {
                    PSModelRTMeta meta;
                    Method m = methodArray[n6];
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)m.getName(), (String)items[1], (boolean)true) == 0 && (meta = m.getAnnotation(PSModelRTMeta.class)) != null) {
                        try {
                            Object objValue = m.invoke(iPSModelObject, new Object[0]);
                            if (!(objValue instanceof Iterator) && !(objValue instanceof ArrayList) && !objValue.getClass().isArray()) break;
                            Iterator it = null;
                            if (objValue instanceof Iterator) {
                                it = (Iterator)objValue;
                            } else if (objValue instanceof ArrayList) {
                                it = ((ArrayList)objValue).iterator();
                            } else if (objValue.getClass().isArray()) {
                                int i;
                                ArrayList<Object> list2 = new ArrayList<Object>();
                                if (objValue instanceof Object[]) {
                                    Object[] list3 = (Object[])objValue;
                                    i = 0;
                                    while (i < list3.length) {
                                        list2.add(list3[i]);
                                        ++i;
                                    }
                                } else if (objValue instanceof double[]) {
                                    double[] list3 = (double[])objValue;
                                    i = 0;
                                    while (i < list3.length) {
                                        list2.add((double)list3[i]);
                                        ++i;
                                    }
                                } else if (objValue instanceof int[]) {
                                    int[] list3 = (int[])objValue;
                                    i = 0;
                                    while (i < list3.length) {
                                        list2.add((int)list3[i]);
                                        ++i;
                                    }
                                } else {
                                    list2.add("\u672a\u77e5\u7c7b\u578b");
                                }
                                it = list2.iterator();
                            }
                            int nIndex = 0;
                            while (it.hasNext()) {
                                ++nIndex;
                                Object objItem = it.next();
                                if (objItem instanceof IPSModelObject) {
                                    IPSModelObject iPSModelObject2 = (IPSModelObject)objItem;
                                    String strModelType2 = iPSModelObject2.getModelType(meta.modeltype());
                                    PSModelRT psModelRT2 = new PSModelRT();
                                    psModelRT2.setRTTYPE("PSOBJECT");
                                    psModelRT2.setPSMODELRTNAME(SA.SRFramework.Utility.StringHelper.Format((String)"[%1$s]%2$s", (Object)PSModels.getModelName((String)strModelType2), (Object)iPSModelObject2.getModelName(strModelType2)));
                                    psModelRT2.setLEAFFLAG(false);
                                    psModelRT2.setPSMODELRTID(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s@%2$s@%3$s", (Object)"PSOBJECT", (Object)strModelType2, (Object)iPSModelObject2.getModelId(strModelType2).replace("@", "__*__")));
                                    psModelRT2.setPSMODELRTID(String.valueOf(psModelRT2.getPSMODELRTID()) + "@" + KeyValueHelper.genGuidEx());
                                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strModelType2)) {
                                        psModelRT2.setICONPATH(SA.SRFramework.Utility.StringHelper.Format((String)"default/de/icon_%1$s.png", (Object)strModelType2.toLowerCase()));
                                    } else {
                                        psModelRT2.setICONPATH(SA.SRFramework.Utility.StringHelper.Format((String)"default/icon_alert.png"));
                                    }
                                    psModelRT2.setORDERVALUE(nIndex);
                                    psModelRTList.add(psModelRT2);
                                    continue;
                                }
                                PSModelRT psModelRT2 = new PSModelRT();
                                psModelRT2.setPSMODELRTID(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s@%2$s@%3$s@%4$s", (Object)"METHOD", (Object)m.getName(), (Object)strModelType, (Object)iPSModelObject.getModelId(strModelType).replace("@", "__*__")));
                                psModelRT2.setPSMODELRTID(String.valueOf(psModelRT2.getPSMODELRTID()) + "@" + KeyValueHelper.genGuidEx());
                                psModelRT2.setLEAFFLAG(true);
                                psModelRT2.setRTTYPE("VALUE");
                                if (objItem == null) {
                                    psModelRT2.setPSMODELRTNAME("null");
                                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)m.getName(), (String)"getUserParamNames", (boolean)false) == 0) {
                                    Object objValue2 = iPSModelObject.getUserParam(objItem.toString());
                                    if (objValue2 == null) {
                                        psModelRT2.setPSMODELRTNAME(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s ==> (null)", objItem));
                                    } else {
                                        psModelRT2.setPSMODELRTNAME(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s ==> %2$s", objItem, (Object)this.getShortContent(objValue2, !bV6Mode)));
                                    }
                                } else {
                                    psModelRT2.setPSMODELRTNAME(this.getShortContent(objItem.toString(), !bV6Mode));
                                }
                                psModelRT2.setICONPATH(SA.SRFramework.Utility.StringHelper.Format((String)"icon_dgexcell.png"));
                                psModelRT2.setORDERVALUE(nIndex);
                                psModelRTList.add(psModelRT2);
                            }
                        }
                        catch (Exception e) {
                            log.error((Object)e);
                            psModelRTList.clear();
                            PSModelRT psModelRT2 = new PSModelRT();
                            psModelRT2.setPSMODELRTID(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s@%2$s@%3$s@%4$s", (Object)"METHOD", (Object)m.getName(), (Object)iPSModelObject.getModelType(), (Object)iPSModelObject.getModelId().replace("@", "__*__")));
                            psModelRT2.setPSMODELRTID(String.valueOf(psModelRT2.getPSMODELRTID()) + "@" + KeyValueHelper.genGuidEx());
                            psModelRT2.setLEAFFLAG(true);
                            psModelRT2.setRTTYPE("VALUE");
                            psModelRT2.setPSMODELRTNAME(e.getMessage());
                            psModelRT2.setICONPATH(SA.SRFramework.Utility.StringHelper.Format((String)"icon_dgexcell.png"));
                            psModelRT2.setORDERVALUE(0);
                            psModelRTList.add(psModelRT2);
                        }
                        break;
                    }
                    ++n6;
                }
            }
        }
        Collections.sort(psModelRTList, new Comparator<PSModelRT>(){

            @Override
            public int compare(PSModelRT o1, PSModelRT o2) {
                int nOrderValue = o1.getORDERVALUE() - o2.getORDERVALUE();
                if (nOrderValue != 0) {
                    return nOrderValue;
                }
                return SA.SRFramework.Utility.StringHelper.Compare((String)o1.getPSMODELRTNAME(), (String)o2.getPSMODELRTNAME(), (boolean)false);
            }
        });
        psModelRT.set(TAG_MODELLIST, Base64Helper.encodeBytes((byte[])PSModelRTDataCtrl.toJsonString(psModelRTList).getBytes("GBK")));
    }

    public CallResult inspectModelRT(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSModelRT psModelRT = new PSModelRT();
            psModelRT.proxy(dataEntity);
            this.onInspectModelRT(psModelRT);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6a21\u578b\u8fd0\u884c\u65f6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInspectModelRT(PSModelRT psModelRT) throws Exception {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        PSModels.setPSSysAppId(null);
        String strPSSystemId = psModelRT.getParamStringValue("PSSYSTEMID", "");
        String strPSDevSlnSysId = psModelRT.getParamStringValue("PSDEVSLNSYSID", "");
        String strPSSysAppId = psModelRT.getParamStringValue("PSSYSAPPID", "");
        String strPSDEId = psModelRT.getParamStringValue("srfdeid", "");
        String strKey = psModelRT.getParamStringValue("srfkey", "");
        boolean bV6Mode = psModelRT.GetParamBoolValue("V6MODE", false);
        String strModel = psModelRT.getParamStringValue("srfmodel", "");
        ObjectNode model = JsonUtils.toObjectNode((Object)strModel);
        ObjectNode properties = (ObjectNode)model.get("properties");
        String strPSModelRTId = psModelRT.getPSMODELRTID();
        boolean bDebugMode = PSTaskServerEnvImpl.getCurrent().isDebugMode();
        PSModels.setPSSysAppId(strPSSysAppId);
        IPSSystem iPSSystem = this.getPSSystem(strPSDevSlnSysId, strPSSystemId, IPSSystem.LOADLEVEL_CODE, true);
        IPSSystemUtil iPSSystemUtil = (IPSSystemUtil)((Object)iPSSystem);
        ArrayList psModelRTList = new ArrayList();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSModelRTId)) {
            ArrayList<IPSObject> list = iPSSystemUtil.getPSModels(strPSDEId, strKey);
            for (IPSObject iPSObject : list) {
                IPSModelObject iPSModelObject;
                ObjectNode node;
                ArrayNode arrayNode = JsonUtils.createArrayNode();
                if (iPSObject instanceof IPSModelObject && (node = this.getPSModelObjectModel(iPSModelObject = (IPSModelObject)iPSObject, properties)) != null) {
                    arrayNode.add((JsonNode)node);
                }
                psModelRT.set(TAG_MODELLIST, Base64Helper.encodeBytes((byte[])arrayNode.toString().getBytes("GBK")));
            }
        }
    }

    /*
     * Enabled aggressive exception aggregation
     */
    protected ObjectNode getPSModelObjectModel(IPSModelObject iPSModelObject, ObjectNode properties) throws Exception {
        Class<?> modelCls = iPSModelObject.getClass();
        Method[] methods = modelCls.getMethods();
        ObjectNode ret = JsonUtils.createObjectNode();
        ret.put("modelid", iPSModelObject.getId());
        ret.put("modeltype", iPSModelObject.getModelType());
        ret.put("name", iPSModelObject.getName());
        if (properties != null) {
            Iterator names = properties.fieldNames();
            block4: while (names.hasNext()) {
                String strName = (String)names.next();
                JsonNode jsonNode = properties.get(strName);
                Method[] methodArray = methods;
                int n = methods.length;
                int n2 = 0;
                while (n2 < n) {
                    PSModelRTMeta meta;
                    Method m = methodArray[n2];
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)m.getName(), (String)strName, (boolean)true) == 0 && (meta = m.getAnnotation(PSModelRTMeta.class)) != null) {
                        String strFieldName = meta.description();
                        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strFieldName)) {
                            strFieldName = strName;
                        }
                        try {
                            Object objValue = m.invoke(iPSModelObject, new Object[0]);
                            if (objValue instanceof Iterator || objValue instanceof ArrayList || objValue.getClass().isArray()) {
                                Iterator it = null;
                                if (objValue instanceof Iterator) {
                                    it = (Iterator)objValue;
                                } else if (objValue instanceof ArrayList) {
                                    it = ((ArrayList)objValue).iterator();
                                } else if (objValue.getClass().isArray()) {
                                    ArrayList<Object> list2 = new ArrayList<Object>();
                                    if (objValue instanceof Object[]) {
                                        Object[] objectArray = (Object[])objValue;
                                        int i = 0;
                                        while (i < objectArray.length) {
                                            list2.add(objectArray[i]);
                                            ++i;
                                        }
                                    } else if (objValue instanceof double[]) {
                                        double[] dArray = (double[])objValue;
                                        int i = 0;
                                        while (i < dArray.length) {
                                            list2.add(dArray[i]);
                                            ++i;
                                        }
                                    } else if (objValue instanceof int[]) {
                                        int[] nArray = (int[])objValue;
                                        int i = 0;
                                        while (i < nArray.length) {
                                            list2.add(nArray[i]);
                                            ++i;
                                        }
                                    } else {
                                        list2.add("\u672a\u77e5\u7c7b\u578b");
                                    }
                                    it = list2.iterator();
                                }
                                ObjectNode properteis2 = null;
                                if (jsonNode instanceof ObjectNode) {
                                    ObjectNode objectNode = (ObjectNode)jsonNode;
                                    strFieldName = JsonUtils.getField((ObjectNode)objectNode, (String)"name", (String)strFieldName);
                                    JsonNode propertiesNode = objectNode.get("properties");
                                    if (propertiesNode instanceof ObjectNode) {
                                        properteis2 = (ObjectNode)propertiesNode;
                                    }
                                }
                                ArrayNode arrayNode = ret.putArray(strFieldName);
                                int nIndex = 0;
                                while (it.hasNext()) {
                                    IPSModelObject iPSModelObject2;
                                    ObjectNode ret2;
                                    ++nIndex;
                                    Object objItem = it.next();
                                    if (!(objItem instanceof IPSModelObject) || (ret2 = this.getPSModelObjectModel(iPSModelObject2 = (IPSModelObject)objItem, properteis2)) == null) continue;
                                    arrayNode.add((JsonNode)ret2);
                                }
                                continue block4;
                            }
                            if (objValue instanceof IPSModelObject) {
                                if (jsonNode instanceof ObjectNode) {
                                    ObjectNode objectNode = (ObjectNode)jsonNode;
                                    strFieldName = JsonUtils.getField((ObjectNode)objectNode, (String)"name", (String)strFieldName);
                                    JsonNode propertiesNode = objectNode.get("properties");
                                    if (propertiesNode instanceof ObjectNode) {
                                        ObjectNode objectNode2 = this.getPSModelObjectModel((IPSModelObject)objValue, (ObjectNode)propertiesNode);
                                        if (objectNode2 == null) continue block4;
                                        ret.put(strFieldName, (JsonNode)objectNode2);
                                        continue block4;
                                    }
                                    ObjectNode objectNode3 = this.getPSModelObjectModel((IPSModelObject)objValue, null);
                                    if (objectNode3 == null) continue block4;
                                    ret.put(strFieldName, (JsonNode)objectNode3);
                                    continue block4;
                                }
                                ObjectNode ret2 = this.getPSModelObjectModel((IPSModelObject)objValue, null);
                                if (ret2 == null) continue block4;
                                ret.put(strFieldName, (JsonNode)ret2);
                                continue block4;
                            }
                            if (objValue == null) continue block4;
                            String strValue = objValue.toString();
                            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)meta.codelist())) {
                                try {
                                    String strCodeListId = SA.SRFramework.Utility.StringHelper.Format((String)"net.ibizsys.pscore.srv.codelist.%1$sCodeListModel", (Object)meta.codelist());
                                    ICodeListModel iCodeListModel = (ICodeListModel)CodeListGlobal.getCodeList((String)strCodeListId);
                                    if (iCodeListModel != null) {
                                        strValue = iCodeListModel.getCodeListText(strValue, true);
                                    }
                                }
                                catch (Exception e) {
                                    log.error((Object)e);
                                }
                            }
                            if (jsonNode instanceof ObjectNode) {
                                Pattern p;
                                Matcher matcher;
                                Pattern p2;
                                Matcher matcher2;
                                ObjectNode objectNode = (ObjectNode)jsonNode;
                                String string = JsonUtils.getField((ObjectNode)objectNode, (String)"include", (String)"");
                                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)string) && !(matcher2 = (p2 = PSModelRTDataCtrl.getPattern(string)).matcher(objValue.toString())).matches()) {
                                    return null;
                                }
                                String strExclude = JsonUtils.getField((ObjectNode)objectNode, (String)"exclude", (String)"");
                                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strExclude) && (matcher = (p = PSModelRTDataCtrl.getPattern(strExclude)).matcher(objValue.toString())).matches()) {
                                    return null;
                                }
                                strFieldName = JsonUtils.getField((ObjectNode)objectNode, (String)"name", (String)strFieldName);
                                ret.put(strFieldName, strValue);
                                continue block4;
                            }
                            if (jsonNode != null) {
                                ret.put(jsonNode.asText(), strValue);
                                continue block4;
                            }
                            ret.put(strFieldName, strValue);
                        }
                        catch (Exception e) {
                            log.error((Object)e);
                        }
                        continue block4;
                    }
                    ++n2;
                }
            }
        }
        return ret;
    }

    @Override
    protected IPSSystem getPSSystem(String strPSDevSlnSysId, String strPSSystemId, int nLoadLevel, boolean bLoadApp) throws Exception {
        PSDevSlnSys psDevSlnSys = PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).getPSDevSlnSys(strPSDevSlnSysId);
        if (DataObject.getBoolValue((Integer)psDevSlnSys.getShareFlag(), (boolean)false)) {
            SA.SRFDA.PS.Data.PSDevSlnSys psDevSlnSys2 = new SA.SRFDA.PS.Data.PSDevSlnSys();
            CallResult callResult = this.getPSModelHelper().getPSDevSlnSysByMajorInst(psDevSlnSys.getPSSysModelInstId(), psDevSlnSys2);
            if (callResult.isOk()) {
                strPSDevSlnSysId = psDevSlnSys2.getPSDEVSLNSYSID();
                strPSSystemId = psDevSlnSys2.getPSSYSTEMID();
            } else {
                log.warn((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u52a8\u6001\u8fd0\u884c\u65f6\u65e0\u6cd5\u83b7\u53d6\u5171\u4eab\u6a21\u5f0f\u7cfb\u7edf[%1$s]\u4e3b\u7cfb\u7edf\uff0c\u4f7f\u7528\u5f53\u524d\u7cfb\u7edf\u7ee7\u7eed\u64cd\u4f5c", (Object)strPSDevSlnSysId));
            }
        }
        return super.getPSSystem(strPSDevSlnSysId, strPSSystemId, nLoadLevel, bLoadApp);
    }

    protected String getShortContent(Object objContent, boolean bHtml) {
        String strRet = null;
        strRet = objContent instanceof String ? (String)objContent : SA.SRFramework.Utility.StringHelper.Format((String)"%1$s", (Object)objContent);
        if (strRet.length() > 100) {
            strRet = String.valueOf(strRet.substring(0, 95)) + "...";
        }
        if (bHtml) {
            return WebUtility.textToHTMLWithoutReturn((String)strRet);
        }
        return strRet;
    }
}
