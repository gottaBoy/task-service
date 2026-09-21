/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndex;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndexDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERBaseImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERIndexDEFieldMapImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDERDEFMap;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;

@PSModelPFIgnoreMeta
public class PSDERIndexImpl
extends PSDERBaseImpl
implements IPSDERIndex {
    private Properties properties = null;
    private ArrayList<IPSDERIndexDEFieldMap> psDERIndexDEFieldMapList = null;

    @Override
    protected void onInit() throws Exception {
        if (!this.isInherit() && StringHelper.Compare((String)this.getMajorPSDataEntity().getIndexDEType(), (String)"INDEX", (boolean)false) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5173\u7cfb\u4e3b\u5b9e\u4f53[%1$s]\u7d22\u5f15\u7c7b\u578b\u5fc5\u987b\u4e3a[\u7d22\u5f15\u4e3b\u5b9e\u4f53]", (Object)this.getMajorPSDataEntity().getName()));
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDER.getPROPERTYMAP())) {
            this.properties = PropertiesHelper.load((String)this.psDER.getPROPERTYMAP());
        }
        this.strCodeName = this.psDER.getCODENAME();
        if (StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
            this.strCodeName = this.getMajorPSDataEntity().getCodeName();
        }
        this.onPreparePSDERIndexDEFieldMaps();
        super.onInit();
    }

    protected void onPreparePSDERIndexDEFieldMaps() throws Exception {
        if (this.psDERIndexDEFieldMapList != null) {
            this.psDERIndexDEFieldMapList.clear();
        }
        Vector<PSDERDEFMap> psDERIndexDEFieldMapList = new Vector<PSDERDEFMap>();
        CallResult callResult = this.getPSModelHelper().getPSDERDEFMaps(this.getId(), psDERIndexDEFieldMapList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5173\u7cfb\u5c5e\u6027\u6620\u5c04\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        if (psDERIndexDEFieldMapList.size() == 0) {
            Iterator names = this.getPropertyMapNames();
            if (names != null) {
                while (names.hasNext()) {
                    String strMajorPSDEFName = (String)names.next();
                    String strMinorPSDEFName = this.getPropertyMap(strMajorPSDEFName);
                    if (StringHelper.IsNullOrEmpty((String)strMinorPSDEFName)) {
                        strMinorPSDEFName = strMajorPSDEFName;
                    }
                    if (StringHelper.IsNullOrEmpty((String)strMajorPSDEFName) || StringHelper.IsNullOrEmpty((String)strMinorPSDEFName)) continue;
                    PSDERDEFMap psDERDEFMap = new PSDERDEFMap();
                    psDERDEFMap.setPSDERDEFMAPID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strMajorPSDEFName, (String)strMinorPSDEFName));
                    psDERDEFMap.setPSDERDEFMAPNAME(StringHelper.Format((String)"%1$s=%2$s", (Object)strMajorPSDEFName, (Object)strMinorPSDEFName));
                    psDERDEFMap.setMAJORPSDEFNAME(strMajorPSDEFName);
                    if (strMinorPSDEFName.indexOf("#") == 0) {
                        psDERDEFMap.setSRCVALUE(strMinorPSDEFName.substring(1));
                    } else {
                        psDERDEFMap.setMINORPSDEFNAME(strMinorPSDEFName);
                    }
                    psDERDEFMap.set("AUTOMODEL", 1);
                    psDERIndexDEFieldMapList.add(psDERDEFMap);
                }
            }
            if (psDERIndexDEFieldMapList.size() == 0) {
                return;
            }
        }
        if (this.psDERIndexDEFieldMapList == null) {
            this.psDERIndexDEFieldMapList = new ArrayList();
        }
        for (PSDERDEFMap psDERDEFMap : psDERIndexDEFieldMapList) {
            PSDERIndexDEFieldMapImpl iPSDERIndexDEFieldMap = new PSDERIndexDEFieldMapImpl();
            iPSDERIndexDEFieldMap.init(this.getDAGlobalHelper(), this, psDERDEFMap);
            this.psDERIndexDEFieldMapList.add(iPSDERIndexDEFieldMap);
        }
    }

    @Override
    @PSModelRTMeta(description="\u7d22\u5f15\u7c7b\u578b\u8bc6\u522b\u503c", fields={"INDEXVALUE"})
    public String getTypeValue() {
        return this.psDER.getINDEXVALUE();
    }

    @Override
    public Iterator getPropertyMapNames() {
        if (this.properties == null) {
            return null;
        }
        return this.properties.keySet().iterator();
    }

    @Override
    public String getPropertyMap(String strName) {
        return PropertiesHelper.getProperty((Properties)this.properties, (String)strName);
    }

    @Override
    protected void onFillViewParentModeJO(JSONObject jo) {
        super.onFillViewParentModeJO(jo);
        if (!jo.has("SRFDERINDEXID".toLowerCase())) {
            jo.put("SRFDERINDEXID".toLowerCase(), (Object)this.getName());
        }
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u5c5e\u6027\u6620\u5c04\u96c6\u5408", hideempty2=true, child=true)
    public Iterator<IPSDERIndexDEFieldMap> getPSDERIndexDEFieldMaps() {
        if (this.psDERIndexDEFieldMapList == null || this.psDERIndexDEFieldMapList.size() == 0) {
            return null;
        }
        return this.psDERIndexDEFieldMapList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u865a\u62df\u6a21\u5f0f", ignoredumpvalues="false", staticcode="this.getMajorPSDataEntityMust().isVirtual()")
    public boolean isVirtual() {
        return this.getMajorPSDataEntity().isVirtual();
    }

    @Override
    @PSModelRTMeta(description="\u7ee7\u627f\u6a21\u5f0f", ignoredumpvalues="false", staticcode="false")
    public boolean isInherit() {
        return false;
    }
}

