/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERAggData;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERAggDataDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERAggDataDEFieldMapImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERBaseImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDERDEFMap;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDERAggDataImpl
extends PSDERBaseImpl
implements IPSDERAggData {
    private ArrayList<IPSDERAggDataDEFieldMap> psDERAggDataDEFieldMapList = null;
    private IPSDEDataSet sourcePSDEDataSet = null;

    @Override
    protected void onInit() throws Exception {
        this.strCodeName = this.psDER.getCODENAME();
        this.strMinorCodeName = this.psDER.getMINORCODENAME();
        this.onPreparePSDERAggDataDEFieldMaps();
        super.onInit();
    }

    protected void onPreparePSDERAggDataDEFieldMaps() throws Exception {
        if (this.psDERAggDataDEFieldMapList != null) {
            this.psDERAggDataDEFieldMapList.clear();
        }
        Vector<PSDERDEFMap> psDERAggDataDEFieldMapList = new Vector<PSDERDEFMap>();
        CallResult callResult = this.getPSModelHelper().getPSDERDEFMaps(this.getId(), psDERAggDataDEFieldMapList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u5173\u7cfb\u5c5e\u6027\u6620\u5c04\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        if (psDERAggDataDEFieldMapList.size() == 0) {
            return;
        }
        if (this.psDERAggDataDEFieldMapList == null) {
            this.psDERAggDataDEFieldMapList = new ArrayList();
        }
        for (PSDERDEFMap psDERDEFMap : psDERAggDataDEFieldMapList) {
            PSDERAggDataDEFieldMapImpl iPSDERAggDataDEFieldMap = new PSDERAggDataDEFieldMapImpl();
            iPSDERAggDataDEFieldMap.init(this.getDAGlobalHelper(), this, psDERDEFMap);
            this.psDERAggDataDEFieldMapList.add(iPSDERAggDataDEFieldMap);
        }
        Collections.sort(this.psDERAggDataDEFieldMapList, new Comparator<IPSDERAggDataDEFieldMap>(){

            @Override
            public int compare(IPSDERAggDataDEFieldMap o1, IPSDERAggDataDEFieldMap o2) {
                return StringHelper.compare((String)o1.getName(), (String)o2.getName(), (boolean)false);
            }
        });
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u5c5e\u6027\u6620\u5c04\u96c6\u5408", hideempty2=true, child=true, ignorepf=true, group="\u903b\u8f91", order=220)
    public Iterator<IPSDERAggDataDEFieldMap> getPSDERAggDataDEFieldMaps() {
        if (this.psDERAggDataDEFieldMapList == null || this.psDERAggDataDEFieldMapList.size() == 0) {
            return null;
        }
        return this.psDERAggDataDEFieldMapList.iterator();
    }

    @Override
    public String getSourcePSDEDataSetId() {
        return this.psDER.getMINORPSDEDSID();
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u6570\u636e\u96c6\u5bf9\u8c61", hideempty2=true, dumpref=true, ignorepf=true, from="__self__", from_method="getMinorPSDataEntityMust().getPSDEDataSet", fields={"MINORPSDEDSID"})
    public IPSDEDataSet getSourcePSDEDataSet() throws Exception {
        if (this.sourcePSDEDataSet != null) {
            return this.sourcePSDEDataSet;
        }
        this.sourcePSDEDataSet = !StringHelper.isNullOrEmpty((String)this.getSourcePSDEDataSetId()) ? this.getMinorPSDataEntity().getPSDEDataSet(this.getSourcePSDEDataSetId()) : this.getMinorPSDataEntity().getDefaultPSDEDataSet();
        return this.sourcePSDEDataSet;
    }
}

