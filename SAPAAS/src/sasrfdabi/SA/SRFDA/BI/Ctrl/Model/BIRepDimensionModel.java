/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.BI.Ctrl.Model;

import SA.SRFDA.BI.Ctrl.IBICubeCache;
import SA.SRFDA.BI.Ctrl.IBIHierarchyHelper;
import SA.SRFDA.BI.Ctrl.IBILevelHelper;
import SA.SRFDA.BI.Ctrl.IBIRepDMHelper;
import SA.SRFDA.BI.Ctrl.Model.BIReportExModel;
import SA.SRFDA.BI.Ctrl.Model.BaseBIObjectModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Vector;
import net.sf.json.JSONObject;

public class BIRepDimensionModel
extends BaseBIObjectModel {
    protected IBIRepDMHelper iBIRepDMHelper = null;
    protected IBICubeCache iIBICubeCache = null;
    protected ArrayList<String> dataList = new ArrayList();
    protected ArrayList<String> keyList = new ArrayList();
    protected int nLevelCount = 0;
    protected ArrayList<String> levelList = new ArrayList();
    protected ArrayList<String> levelTypeList = new ArrayList();

    public void Init(BIReportExModel biReportExModel, IBIRepDMHelper iBIRepDMHelper, IBICubeCache iIBICubeCache) throws Exception {
        this.iBIRepDMHelper = iBIRepDMHelper;
        this.iIBICubeCache = iIBICubeCache;
        this.setId(iBIRepDMHelper.getBIHierarchy().getShortId());
        this.setCaption(iBIRepDMHelper.getBIHierarchy().getLogicName());
        this.setUniqueName(iBIRepDMHelper.getBIHierarchy().getUniqueName());
        IBIHierarchyHelper iBIHierarchyHelper = iBIRepDMHelper.getBIHierarchy();
        if ((StringHelper.Compare((String)biReportExModel.getMode(), (String)"CHART", (boolean)true) == 0 || StringHelper.Compare((String)iBIRepDMHelper.getPlacement(), (String)"COLHEADER", (boolean)true) == 0) && this.iIBICubeCache != null) {
            Vector<BaseDataEntity> datas = iIBICubeCache.getBIHierarchyDatas(iBIHierarchyHelper.getUniqueName());
            for (BaseDataEntity data : datas) {
                String strDataCaption = iBIHierarchyHelper.getDataCaption(data);
                this.dataList.add(strDataCaption);
            }
            for (BaseDataEntity data : datas) {
                String strDataKey = iBIHierarchyHelper.getDataKey(data);
                this.keyList.add(strDataKey);
            }
        }
        this.setLevelCount(iBIHierarchyHelper.getBILevels().size());
        for (IBILevelHelper iBILevelHelper : iBIHierarchyHelper.getBILevels()) {
            this.levelList.add(iBILevelHelper.getName());
            this.levelTypeList.add(iBILevelHelper.getLevelType());
        }
    }

    @Override
    protected void OnFillJSONObject(JSONObject jsonObject) throws Exception {
        super.OnFillJSONObject(jsonObject);
        jsonObject.put("columnwidth", this.iBIRepDMHelper.getColumnWidth());
        if (this.dataList.size() > 0) {
            jsonObject.put("datas", (Object)this.dataList.toArray());
        }
        if (this.keyList.size() > 0) {
            jsonObject.put("keys", (Object)this.keyList.toArray());
        }
        jsonObject.put("levels", (Object)this.levelList.toArray());
        jsonObject.put("leveltypes", (Object)this.levelTypeList.toArray());
        jsonObject.put("levelcnt", this.getLevelCount());
        jsonObject.put("dmtype", (Object)this.iBIRepDMHelper.getBIDimension().getDimensionType());
    }

    public int getLevelCount() {
        return this.nLevelCount;
    }

    public void setLevelCount(int nLevelCount) {
        this.nLevelCount = nLevelCount;
    }

    public ArrayList<String> getDataList() {
        return this.dataList;
    }

    public ArrayList<String> getKeyList() {
        return this.keyList;
    }

    public int getColumnWidth() {
        return this.iBIRepDMHelper.getColumnWidth();
    }
}

