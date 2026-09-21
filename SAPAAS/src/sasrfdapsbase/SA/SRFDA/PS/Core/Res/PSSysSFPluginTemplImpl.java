/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DynaModel.IPSDynaModelAttr;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Data.PSSFPluginTempl;
import SA.SRFDA.PS.Data.PSSysSFPluginTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSSysSFPluginTemplImpl
extends PSSystemObjectImpl
implements IPSSysSFPluginTempl {
    private static final Log log = LogFactory.getLog(PSSysSFPluginTemplImpl.class);
    private static final Map<String, String> ignoreFieldMap = new HashMap<String, String>();
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSF iPSSF = null;
    protected PSSysSFPluginTempl psSysSFPluginTempl = null;
    private String[] xCodes = null;
    private ThreadLocal<Integer> currentThreadCallCount = new ThreadLocal();

    static {
        ignoreFieldMap.put("TEMPLCODEEX", "");
        ignoreFieldMap.put("TEMPLCODE2EX", "");
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysSFPlugin iPSSysSFPlugin, PSSysSFPluginTempl psSysSFPluginTempl) throws Exception {
        try {
            Enumeration<Object> keys;
            Properties properties;
            this.psSysSFPluginTempl = psSysSFPluginTempl;
            this.iPSSysSFPlugin = iPSSysSFPlugin;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setId(this.psSysSFPluginTempl.getPSSYSSFPITEMPLID());
            this.setName(this.psSysSFPluginTempl.getPSSYSSFPITEMPLNAME());
            this.setPSSystem(this.iPSSysSFPlugin.getPSSystem());
            this.setPSObjectData(this.psSysSFPluginTempl);
            if (!StringHelper.isNullOrEmpty((String)this.psSysSFPluginTempl.getTEMPLCODEEX())) {
                this.psSysSFPluginTempl.setTEMPLCODE(this.psSysSFPluginTempl.getTEMPLCODEEX());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysSFPluginTempl.getTEMPLCODE2EX())) {
                this.psSysSFPluginTempl.setTEMPLCODE2(this.psSysSFPluginTempl.getTEMPLCODE2EX());
            }
            this.iPSSF = this.getPSModelStorage().getPSSF(this.psSysSFPluginTempl.getPSSFID());
            if (!StringHelper.isNullOrEmpty((String)this.psSysSFPluginTempl.getCODEMAP()) && (properties = PropertiesHelper.load((String)this.psSysSFPluginTempl.getCODEMAP())) != null && (keys = properties.keys()) != null) {
                while (keys.hasMoreElements()) {
                    String strCode;
                    String strKey = (String)keys.nextElement();
                    String strValue = PropertiesHelper.getProperty((Properties)properties, (String)strKey);
                    if (StringHelper.isNullOrEmpty((String)strValue) || StringHelper.isNullOrEmpty((String)(strCode = this.psSysSFPluginTempl.getParamStringValue(StringHelper.format((String)"TEMPL%1$s", (Object)(strValue = strValue.toUpperCase())), "")))) continue;
                    String strCode2 = this.psSysSFPluginTempl.getParamStringValue(StringHelper.format((String)"TEMPL%1$s", (Object)strKey), "");
                    if (!StringHelper.isNullOrEmpty((String)strCode2)) {
                        String strExInfo = StringHelper.format((String)"\u4ee3\u7801\u6210\u5458[%1$s]\u5df2\u5b58\u5728\uff0c\u65e0\u6cd5\u4f7f\u7528[%2$s]\u8986\u76d6", (Object)strKey, (Object)strValue);
                        log.warn((Object)StringHelper.format((String)"%1$s%2$s", (Object)this.getLogName(), (Object)strExInfo));
                        if (this.getPSSystemUtil() == null) continue;
                        this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), strExInfo);
                        continue;
                    }
                    this.psSysSFPluginTempl.set(StringHelper.format((String)"TEMPL%1$s", (Object)strKey), strCode);
                }
            }
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
    protected void onInit() throws Exception {
        Iterator<? extends IPSDynaModelAttr> psDynaModelAttrs;
        super.onInit();
        if (this.getPSDynaModel() != null && (psDynaModelAttrs = this.getPSDynaModel().getPSDynaModelAttrs()) != null) {
            while (psDynaModelAttrs.hasNext()) {
                IPSDynaModelAttr iPSDynaModelAttr = psDynaModelAttrs.next();
                if (StringHelper.compare((String)iPSDynaModelAttr.getValueType(), (String)"VALUE", (boolean)false) != 0) continue;
                String strKey = iPSDynaModelAttr.getName();
                String strCode = iPSDynaModelAttr.getValue();
                if (StringHelper.isNullOrEmpty((String)strCode)) continue;
                String strCode2 = this.psSysSFPluginTempl.getParamStringValue(StringHelper.format((String)"TEMPL%1$s", (Object)strKey), "");
                if (!StringHelper.isNullOrEmpty((String)strCode2)) {
                    String strExInfo = StringHelper.format((String)"\u4ee3\u7801\u6210\u5458[%1$s]\u5df2\u5b58\u5728\uff0c\u65e0\u6cd5\u4f7f\u7528\u52a8\u6001\u6a21\u578b\u5c5e\u6027\u8986\u76d6", (Object)strKey);
                    log.warn((Object)StringHelper.format((String)"%1$s%2$s", (Object)this.getLogName(), (Object)strExInfo));
                    if (this.getPSSystemUtil() == null) continue;
                    this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), strExInfo);
                    continue;
                }
                this.psSysSFPluginTempl.set(StringHelper.format((String)"TEMPL%1$s", (Object)strKey), strCode);
            }
        }
        ArrayList<String> xCodeList = new ArrayList<String>();
        HashMap xCodeMap = new HashMap();
        this.psSysSFPluginTempl.FillMap(xCodeMap);
        for (Map.Entry entry : xCodeMap.entrySet()) {
            String strKey = ((String)entry.getKey()).toUpperCase();
            if (ignoreFieldMap.containsKey(strKey) || strKey.indexOf("TEMPL") != 0 || StringHelper.isNullOrEmpty(entry.getValue())) continue;
            xCodeList.add(strKey.substring(5));
        }
        if (xCodeList.size() > 0) {
            this.xCodes = xCodeList.toArray(new String[xCodeList.size()]);
        }
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSSFPluginTempl psSFPluginTempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSSF getPSSF() {
        return this.iPSSF;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6a21\u677f\u63d2\u4ef6")
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    public String getCode(String strCodeTag) {
        String strCodeTag2 = StringHelper.format((String)"TEMPL%1$s", (Object)strCodeTag);
        return this.psSysSFPluginTempl.getParamStringValue(strCodeTag2, "");
    }

    @Override
    public String getModelType() {
        return "PSSYSSFPITEMPL";
    }

    @Override
    public BaseDataEntity getPSSFPluginTemplData() {
        return this.psSysSFPluginTempl;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u4ee3\u7801\u96c6\u5408")
    public String[] getXCodes() {
        return this.xCodes;
    }

    @Override
    public boolean hasXCode(String strTag) {
        if (this.getXCodes() != null) {
            String[] stringArray = this.getXCodes();
            int n = stringArray.length;
            int n2 = 0;
            while (n2 < n) {
                String strXCode = stringArray[n2];
                if (StringHelper.compare((String)strXCode, (String)strTag, (boolean)true) == 0) {
                    return true;
                }
                ++n2;
            }
        }
        return false;
    }

    @Override
    public String getXCode(String strCodeType, Object objItem, Map<String, Object> params) throws Exception {
        try {
            this.logCallCount(1);
            if (StringHelper.isNullOrEmpty((String)strCodeType)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u4ee3\u7801\u7c7b\u578b");
            }
            HashMap<String, Object> paramMap = new HashMap<String, Object>();
            Map<String, Object> curParams = PSTemplHelper.getCurrentParams();
            if (curParams != null) {
                paramMap.putAll(curParams);
            }
            if (params != null) {
                paramMap.putAll(params);
            }
            if (objItem != null) {
                paramMap.put("item", objItem);
            }
            String strCodeName = StringHelper.format((String)"TEMPL%1$s", (Object)strCodeType);
            String strCode = PSTemplHelper.generateCode(this.getPSSFPluginTemplData(), strCodeName, paramMap);
            this.logCallCount(-1);
            return strCode;
        }
        catch (Exception ex) {
            this.currentThreadCallCount.set(null);
            throw ex;
        }
    }

    private void logCallCount(int nStep) throws Exception {
        Integer nValue = this.currentThreadCallCount.get();
        if (nValue == null) {
            if (nStep <= 0) {
                return;
            }
            nValue = 0;
        }
        if ((nValue = Integer.valueOf(nValue + nStep)) <= 0) {
            this.currentThreadCallCount.set(null);
        } else {
            if (nValue >= 3) {
                this.currentThreadCallCount.set(null);
                throw new Exception(StringHelper.format((String)"\u540e\u53f0\u6a21\u677f\u63d2\u4ef6[%1$s]\u5b58\u5728\u9012\u5f52\u8c03\u7528", (Object)this.getName()));
            }
            this.currentThreadCallCount.set(nValue);
        }
    }
}

