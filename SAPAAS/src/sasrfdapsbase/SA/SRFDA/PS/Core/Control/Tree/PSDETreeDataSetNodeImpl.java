/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeDataSetNode;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeNodeImplBase;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import net.ibizsys.paas.util.StringHelper;

public class PSDETreeDataSetNodeImpl
extends PSDETreeNodeImplBase
implements IPSDETreeDataSetNode {
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSDEDataSet filterPSDEDataSet = null;
    private IPSDEAction removePSDEAction = null;
    private IPSDEOPPriv removePSDEOPPriv = null;
    private IPSDEAction updatePSDEAction = null;
    private IPSDEOPPriv updatePSDEOPPriv = null;
    private IPSDELogic activeDataPSDELogic = null;
    private IPSDEAction movePSDEAction = null;
    private IPSDEOPPriv movePSDEOPPriv = null;
    private IPSDEField idPSDEField = null;
    private IPSDEField textPSDEField = null;
    private IPSDEField iconPSDEField = null;
    private IPSDEField sortPSDEField = null;
    private IPSDEField childCntPSDEField = null;
    private IPSDEField leafFlagPSDEField = null;
    private IPSDEField tipsPSDEField = null;
    private IPSDEField clsPSDEField = null;
    private IPSDEField dataPSDEField = null;
    private IPSDEField data2PSDEField = null;
    private IPSDEField linkPSDEField = null;
    private IPSDEField shapeClsPSDEField = null;
    private IPSAppDEField idPSAppDEField = null;
    private IPSAppDEField textPSAppDEField = null;
    private IPSAppDEField iconPSAppDEField = null;
    private IPSAppDEField sortPSAppDEField = null;
    private IPSAppDEField childCntPSAppDEField = null;
    private IPSAppDEField leafFlagPSAppDEField = null;
    private IPSAppDEField tipsPSAppDEField = null;
    private IPSAppDEField clsPSAppDEField = null;
    private IPSAppDEField dataPSAppDEField = null;
    private IPSAppDEField data2PSAppDEField = null;
    private IPSAppDEField linkPSAppDEField = null;
    private IPSAppDEField shapeClsPSAppDEField = null;
    private IPSAppDEDataSet iPSAppDEDataSet = null;
    private IPSAppDEDataSet filterPSAppDEDataSet = null;
    private IPSAppDEAction removePSAppDEAction = null;
    private IPSAppDEAction updatePSAppDEAction = null;
    private IPSAppDEAction movePSAppDEAction = null;
    private List<IPSAppDEField> psAppDEFieldList = null;
    private int nMaxSize = -1;
    private boolean bAppendCaption = false;
    private int nPagingSize = 1000;
    private boolean bEnablePaging = false;
    private boolean bDistinctMode = false;
    private String strDataSourceType = "DEDATASET";
    private IPSDEAction iPSDEAction = null;
    private IPSDELogic iPSDELogic = null;
    private IPSAppDEAction iPSAppDEAction = null;
    private IPSAppDELogic iPSAppDELogic = null;
    private String strDataName = null;
    private String strScriptCode = null;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected void onInit() throws Exception {
        if (this.getPSDataEntity() == null) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u4e3a\u6811\u89c6\u56fe[%1$s]\u8282\u70b9[%2$s]\u6307\u5b9a\u5b9e\u4f53", (Object)this.getPSDETree().getName(), (Object)this.getName()));
        }
        this.setEnableRemoveDataDefault(true);
        this.setEnableEditDataDefault(true);
        this.setEnablePrintDefault(this.getPSDataEntity().hasPSDEPrint());
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getDATASOURCE())) {
            this.strDataSourceType = this.psDETreeNode.getDATASOURCE();
        }
        if (StringHelper.compare((String)this.getDataSourceType(), (String)"DEDATASET", (boolean)false) == 0) {
            if (StringHelper.isNullOrEmpty((String)this.psDETreeNode.getPSDEDSID())) {
                throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u6e90\u6570\u636e\u96c6\u5bf9\u8c61");
            }
            this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psDETreeNode.getPSDEDSID());
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getFILTERPSDEDSID())) {
                this.filterPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psDETreeNode.getFILTERPSDEDSID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getPSDELOGICID())) {
                this.activeDataPSDELogic = this.getPSDataEntity().getPSDELogic(this.psDETreeNode.getPSDELOGICID());
            }
        } else if (StringHelper.compare((String)this.getDataSourceType(), (String)"DEACTION", (boolean)false) == 0) {
            if (StringHelper.isNullOrEmpty((String)this.psDETreeNode.getPSDEACTIONID())) throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u6e90\u884c\u4e3a\u5bf9\u8c61");
            this.iPSDEAction = this.getPSDataEntity().getPSDEAction(this.psDETreeNode.getPSDEACTIONID());
        } else if (StringHelper.compare((String)this.getDataSourceType(), (String)"DELOGIC", (boolean)false) == 0) {
            if (StringHelper.isNullOrEmpty((String)this.psDETreeNode.getPSDELOGICID())) throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u6e90\u5904\u7406\u903b\u8f91\u5bf9\u8c61");
            this.iPSDELogic = this.getPSDataEntity().getPSDELogic(this.psDETreeNode.getPSDELOGICID());
        } else if (StringHelper.compare((String)this.getDataSourceType(), (String)"APPGLOBALPARAM", (boolean)false) == 0 || StringHelper.compare((String)this.getDataSourceType(), (String)"TOPVIEWSESSIONPARAM", (boolean)false) == 0 || StringHelper.compare((String)this.getDataSourceType(), (String)"VIEWSESSIONPARAM", (boolean)false) == 0 || StringHelper.compare((String)this.getDataSourceType(), (String)"PARENTDATAPARAM", (boolean)false) == 0) {
            this.strDataName = this.psDETreeNode.getFIELDNAME();
            if (StringHelper.isNullOrEmpty((String)this.strDataName)) {
                throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u5bf9\u8c61\u540d\u79f0");
            }
        } else if (StringHelper.compare((String)this.getDataSourceType(), (String)"CUSTOM", (boolean)false) == 0) {
            this.strScriptCode = this.psDETreeNode.getCUSTOMCODE();
            if (StringHelper.isNullOrEmpty((String)this.strScriptCode)) {
                throw new Exception("\u672a\u6307\u5b9a\u81ea\u5b9a\u4e49\u4ee3\u7801");
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getREMOVEPSDEACTIONID())) {
            this.removePSDEAction = this.getPSDataEntity().getPSDEAction(this.psDETreeNode.getREMOVEPSDEACTIONID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getREMOVEPSDEOPPRIVID())) {
            this.removePSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv(this.psDETreeNode.getREMOVEPSDEOPPRIVID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getUPDATEPSDEACTIONID())) {
            this.updatePSDEAction = this.getPSDataEntity().getPSDEAction(this.psDETreeNode.getUPDATEPSDEACTIONID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getUPDATEPSDEOPPRIVID())) {
            this.updatePSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv(this.psDETreeNode.getUPDATEPSDEOPPRIVID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getMOVEPSDEACTIONID())) {
            this.movePSDEAction = this.getPSDataEntity().getPSDEAction(this.psDETreeNode.getMOVEPSDEACTIONID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getMOVEPSDEOPPRIVID())) {
            this.movePSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv(this.psDETreeNode.getMOVEPSDEOPPRIVID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getKEYPSDEFID())) {
            this.idPSDEField = this.getPSDataEntity().getPSDEField(this.psDETreeNode.getKEYPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getTEXTPSDEFID())) {
            this.textPSDEField = this.getPSDataEntity().getPSDEField(this.psDETreeNode.getTEXTPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getICONPSDEFID())) {
            this.iconPSDEField = this.getPSDataEntity().getPSDEField(this.psDETreeNode.getICONPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getSORTPSDEFID())) {
            this.sortPSDEField = this.getPSDataEntity().getPSDEField(this.psDETreeNode.getSORTPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getCHILDCNTPSDEFID())) {
            this.childCntPSDEField = this.getPSDataEntity().getPSDEField(this.psDETreeNode.getCHILDCNTPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getLEAFFLAGPSDEFID())) {
            this.leafFlagPSDEField = this.getPSDataEntity().getPSDEField(this.psDETreeNode.getLEAFFLAGPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getTIPSPSDEFID())) {
            this.tipsPSDEField = this.getPSDataEntity().getPSDEField(this.psDETreeNode.getTIPSPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getCLSPSDEFID())) {
            this.clsPSDEField = this.getPSDataEntity().getPSDEField(this.psDETreeNode.getCLSPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getDATAPSDEFID())) {
            this.dataPSDEField = this.getPSDataEntity().getPSDEField(this.psDETreeNode.getDATAPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getDATA2PSDEFID())) {
            this.data2PSDEField = this.getPSDataEntity().getPSDEField(this.psDETreeNode.getDATA2PSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getLINKPSDEFID())) {
            this.linkPSDEField = this.getPSDataEntity().getPSDEField(this.psDETreeNode.getLINKPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getSHAPECLSPSDEFID())) {
            this.shapeClsPSDEField = this.getPSDataEntity().getPSDEField(this.psDETreeNode.getSHAPECLSPSDEFID());
        }
        if (!this.psDETreeNode.isMAXSIZENull()) {
            this.nMaxSize = this.psDETreeNode.getMAXSIZE();
            if (this.nMaxSize <= 0) {
                this.nMaxSize = -1;
            }
        }
        if (!this.psDETreeNode.isAPPENDCAPFLAGNull()) {
            this.bAppendCaption = this.psDETreeNode.getAPPENDCAPFLAG();
        }
        if (!this.psDETreeNode.isENABLEPAGINGNull()) {
            this.bEnablePaging = this.psDETreeNode.getENABLEPAGING();
        }
        if (this.isEnablePaging() && !this.psDETreeNode.isPAGESIZENull() && this.psDETreeNode.getPAGESIZE() > 0) {
            this.nPagingSize = this.psDETreeNode.getPAGESIZE();
        }
        if (!this.psDETreeNode.isDISTINCTMODENull()) {
            this.bDistinctMode = this.psDETreeNode.getDISTINCTMODE();
        }
        boolean bTryMode = true;
        if (this.getPSAppDataEntity() != null) {
            IPSAppDEMethod iPSAppMethod;
            if (this.getPSDEDataSet() != null && (iPSAppMethod = this.getPSAppDataEntity().getPSAppDEMethod(this.getPSDEDataSet(), bTryMode)) instanceof IPSAppDEDataSet) {
                this.iPSAppDEDataSet = (IPSAppDEDataSet)iPSAppMethod;
            }
            if (this.getFilterPSDEDataSet() != null && (iPSAppMethod = this.getPSAppDataEntity().getPSAppDEMethod(this.getFilterPSDEDataSet(), bTryMode)) instanceof IPSAppDEDataSet) {
                this.filterPSAppDEDataSet = (IPSAppDEDataSet)iPSAppMethod;
            }
            if (this.getPSDEAction() != null && (iPSAppMethod = this.getPSAppDataEntity().getPSAppDEMethod(this.getPSDEAction(), bTryMode)) instanceof IPSAppDEAction) {
                this.iPSAppDEAction = (IPSAppDEAction)iPSAppMethod;
            }
            if (this.getPSDELogic() != null) {
                this.iPSAppDELogic = this.getPSAppDataEntity().getPSAppDELogic(this.getPSDELogic().getId(), bTryMode);
            }
            if (this.getIdPSDEField() != null) {
                this.idPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getIdPSDEField().getId(), bTryMode);
            } else if (this.getPSDataEntity().getKeyPSDEField() != null) {
                this.idPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getPSDataEntity().getKeyPSDEField(), bTryMode);
            }
            if (this.getTextPSDEField() != null) {
                this.textPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getTextPSDEField().getId(), bTryMode);
            } else if (this.getPSDataEntity().getMajorPSDEField() != null) {
                this.textPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getPSDataEntity().getMajorPSDEField(), bTryMode);
            }
            if (this.getIconPSDEField() != null) {
                this.iconPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getIconPSDEField().getId(), bTryMode);
            }
            if (this.getSortPSDEField() != null) {
                this.sortPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getSortPSDEField().getId(), bTryMode);
            }
            if (this.getChildCntPSDEField() != null) {
                this.childCntPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getChildCntPSDEField().getId(), bTryMode);
            }
            if (this.getLeafFlagPSDEField() != null) {
                this.leafFlagPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getLeafFlagPSDEField().getId(), bTryMode);
            }
            if (this.getTipsPSDEField() != null) {
                this.tipsPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getTipsPSDEField().getId(), bTryMode);
            }
            if (this.getClsPSDEField() != null) {
                this.clsPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getClsPSDEField().getId(), bTryMode);
            }
            if (this.getDataPSDEField() != null) {
                this.dataPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getDataPSDEField(), bTryMode);
            }
            if (this.getData2PSDEField() != null) {
                this.data2PSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getData2PSDEField(), bTryMode);
            }
            if (this.getLinkPSDEField() != null) {
                this.linkPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getLinkPSDEField(), bTryMode);
            }
            if (this.getShapeClsPSDEField() != null) {
                this.shapeClsPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getShapeClsPSDEField(), bTryMode);
            }
            this.psAppDEFieldList = new ArrayList<IPSAppDEField>();
            LinkedHashMap<String, IPSAppDEField> psAppDEFieldMap = new LinkedHashMap<String, IPSAppDEField>();
            if (this.getIdPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getIdPSAppDEField().getName(), this.getIdPSAppDEField());
            }
            if (this.getTextPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getTextPSAppDEField().getName(), this.getTextPSAppDEField());
            }
            if (this.getIconPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getIconPSAppDEField().getName(), this.getIconPSAppDEField());
            }
            if (this.getSortPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getSortPSAppDEField().getName(), this.getSortPSAppDEField());
            }
            if (this.getChildCntPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getChildCntPSAppDEField().getName(), this.getChildCntPSAppDEField());
            }
            if (this.getLeafFlagPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getLeafFlagPSAppDEField().getName(), this.getLeafFlagPSAppDEField());
            }
            if (this.getTipsPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getTipsPSAppDEField().getName(), this.getTipsPSAppDEField());
            }
            if (this.getClsPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getClsPSAppDEField().getName(), this.getClsPSAppDEField());
            }
            if (this.getDataPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getDataPSAppDEField().getName(), this.getDataPSAppDEField());
            }
            if (this.getData2PSAppDEField() != null) {
                psAppDEFieldMap.put(this.getData2PSAppDEField().getName(), this.getData2PSAppDEField());
            }
            if (this.getLinkPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getLinkPSAppDEField().getName(), this.getLinkPSAppDEField());
            }
            if (this.getShapeClsPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getShapeClsPSAppDEField().getName(), this.getShapeClsPSAppDEField());
            }
            this.psAppDEFieldList.addAll(psAppDEFieldMap.values());
            Collections.sort(this.psAppDEFieldList, new Comparator<IPSAppDEField>(){

                @Override
                public int compare(IPSAppDEField o1, IPSAppDEField o2) {
                    return StringHelper.compare((String)o1.getName(), (String)o2.getName(), (boolean)false);
                }
            });
            if (this.getRemovePSDEAction() != null) {
                this.removePSAppDEAction = this.getPSAppDataEntity().getPSAppDEAction(this.getRemovePSDEAction(), bTryMode);
            }
            if (this.getUpdatePSDEAction() != null) {
                this.updatePSAppDEAction = this.getPSAppDataEntity().getPSAppDEAction(this.getUpdatePSDEAction(), bTryMode);
            }
            if (this.getMovePSDEAction() != null) {
                this.movePSAppDEAction = this.getPSAppDataEntity().getPSAppDEAction(this.getMovePSDEAction(), bTryMode);
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61")
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61")
    public IPSDEDataSet getFilterPSDEDataSet() {
        return this.filterPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61")
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u903b\u8f91\u5bf9\u8c61")
    public IPSDELogic getPSDELogic() {
        return this.iPSDELogic;
    }

    @Override
    public String getDEName() {
        return this.getPSDataEntity().getName();
    }

    public String getDEDataSetName() {
        if (this.getPSDEDataSet() != null) {
            return this.getPSDEDataSet().getCodeName();
        }
        return null;
    }

    public String getFilterDEDataSetName() {
        if (this.getFilterPSDEDataSet() != null) {
            return this.getFilterPSDEDataSet().getCodeName();
        }
        return null;
    }

    @Override
    public String getIdField() {
        return this.psDETreeNode.getKEYPSDEFNAME();
    }

    @Override
    public String getTextField() {
        return this.psDETreeNode.getTEXTPSDEFNAME();
    }

    @Override
    public String getIconField() {
        return this.psDETreeNode.getICONPSDEFNAME();
    }

    @Override
    public String getSortField() {
        return this.psDETreeNode.getSORTPSDEFNAME();
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u6392\u5e8f\u65b9\u5411", codelist="DETreeNodeSortDir", fields={"SORTDIR"})
    public String getSortDir() {
        return this.psDETreeNode.getSORTDIR();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u6392\u91cd\u6a21\u5f0f", fields={"DISTINCTMODE"}, ignoredumpvalues="false")
    public boolean isDistinctMode() {
        return this.bDistinctMode;
    }

    @Override
    public String getChildCntField() {
        return this.psDETreeNode.getCHILDCNTPSDEFNAME();
    }

    public String getRemoveDEActionName() {
        if (this.getRemovePSDEAction() == null) {
            return null;
        }
        return this.getRemovePSDEAction().getName();
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u6570\u636e\u8bbf\u95ee\u884c\u4e3a", hideempty2=true)
    public String getRemoveDataAccessAction() {
        if (this.getRemovePSDEOPPriv() == null) {
            return null;
        }
        return this.getRemovePSDEOPPriv().getName();
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getRemovePSDEAction() {
        return this.removePSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u8981\u6c42\u64cd\u4f5c\u6807\u8bc6", fields={"REMOVEPSDEOPPRIVID"})
    public IPSDEOPPriv getRemovePSDEOPPriv() {
        return this.removePSDEOPPriv;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getUpdatePSDEAction() {
        return this.updatePSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u8981\u6c42\u64cd\u4f5c\u6807\u8bc6", fields={"UPDATEPSDEOPPRIVID"})
    public IPSDEOPPriv getUpdatePSDEOPPriv() {
        return this.updatePSDEOPPriv;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getMovePSDEAction() {
        return this.movePSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u8981\u6c42\u64cd\u4f5c\u6807\u8bc6", fields={"MOVEPSDEOPPRIVID"})
    public IPSDEOPPriv getMovePSDEOPPriv() {
        return this.movePSDEOPPriv;
    }

    public String getActiveDataDELogicId() {
        if (this.getActiveDataPSDELogic() == null) {
            return null;
        }
        return this.getActiveDataPSDELogic().getId();
    }

    @Override
    @PSModelRTMeta(description="\u5f53\u524d\u6570\u636e\u8f6c\u6362\u903b\u8f91")
    public IPSDELogic getActiveDataPSDELogic() {
        return this.activeDataPSDELogic;
    }

    @Override
    public String getDataTypeField() {
        return this.psDETreeNode.getDATATYPEPSDEFNAME();
    }

    @Override
    public String getLeafFlagField() {
        return this.psDETreeNode.getLEAFFLAGPSDEFNAME();
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u6807\u8bc6\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getIdPSDEField() {
        return this.idPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u6587\u672c\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getTextPSDEField() {
        return this.textPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u56fe\u6807\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getIconPSDEField() {
        return this.iconPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u6392\u5e8f\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getSortPSDEField() {
        return this.sortPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u8ba1\u6570\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getChildCntPSDEField() {
        return this.childCntPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u53f6\u8282\u70b9\u6807\u8bc6\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getLeafFlagPSDEField() {
        return this.leafFlagPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u63d0\u793a\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getTipsPSDEField() {
        return this.tipsPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u6837\u5f0f\u8868\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getClsPSDEField() {
        return this.clsPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u52a0\u8f7d\u8282\u70b9\u6570", fields={"MAXSIZE"})
    public int getMaxSize() {
        return this.nMaxSize;
    }

    @Override
    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() throws Exception {
        if (this.getPSDEDataSet() != null) {
            return this.getPSDEDataSet().getADPSDEDQConditions();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u6587\u672c\u683c\u5f0f\u5316", fields={"CAPTION"})
    public String getTextFormat() {
        return this.psDETreeNode.getCAPTION();
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u6807\u8bc6\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"KEYPSDEFID"})
    public IPSAppDEField getIdPSAppDEField() {
        return this.idPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u6587\u672c\u503c\u5c5e\u6027\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"TEXTPSDEFID"})
    public IPSAppDEField getTextPSAppDEField() {
        return this.textPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u56fe\u6807\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"ICONPSDEFID"})
    public IPSAppDEField getIconPSAppDEField() {
        return this.iconPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u6392\u5e8f\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"SORTPSDEFID"})
    public IPSAppDEField getSortPSAppDEField() {
        return this.sortPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u8ba1\u6570\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"CHILDCNTPSDEFID"})
    public IPSAppDEField getChildCntPSAppDEField() {
        return this.childCntPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u53f6\u8282\u70b9\u6807\u8bc6\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"LEAFFLAGPSDEFID"})
    public IPSAppDEField getLeafFlagPSAppDEField() {
        return this.leafFlagPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u63d0\u793a\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"TIPSPSDEFID"})
    public IPSAppDEField getTipsPSAppDEField() {
        return this.tipsPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u6837\u5f0f\u8868\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"CLSPSDEFID"})
    public IPSAppDEField getClsPSAppDEField() {
        return this.clsPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getDataPSDEField() {
        return this.dataPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u503c2\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getData2PSDEField() {
        return this.data2PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"DATAPSDEFID"})
    public IPSAppDEField getDataPSAppDEField() {
        return this.dataPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u503c2\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"DATA2PSDEFID"})
    public IPSAppDEField getData2PSAppDEField() {
        return this.data2PSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u94fe\u63a5\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getLinkPSDEField() {
        return this.linkPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u94fe\u63a5\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"LINKPSDEFID"})
    public IPSAppDEField getLinkPSAppDEField() {
        return this.linkPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u7ed3\u679c\u96c6\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDEDSID"})
    public IPSAppDEDataSet getPSAppDEDataSet() {
        return this.iPSAppDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u5e94\u7528\u5b9e\u4f53\u7ed3\u679c\u96c6\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"FILTERPSDEDSID"})
    public IPSAppDEDataSet getFilterPSAppDEDataSet() {
        return this.filterPSAppDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDEACTIONID"})
    public IPSAppDEAction getPSAppDEAction() {
        return this.iPSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u903b\u8f91\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDELOGICID"})
    public IPSAppDELogic getPSAppDELogic() {
        return this.iPSAppDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5c5e\u6027\u96c6\u5408", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public Iterator<IPSAppDEField> getPSAppDEFields() throws Exception {
        if (this.psAppDEFieldList == null || this.psAppDEFieldList.size() == 0) {
            return null;
        }
        return this.psAppDEFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u6570\u636e\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"REMOVEPSDEACTIONID"})
    public IPSAppDEAction getRemovePSAppDEAction() {
        return this.removePSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u8282\u70b9\u6807\u9898", ignoredumpvalues="false", fields={"APPENDCAPFLAG"})
    public boolean isAppendCaption() {
        return this.bAppendCaption;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true, dumpref=true, fields={"PSDEID"})
    public IPSAppDataEntity getPSAppDataEntity() {
        return super.getPSAppDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u67e5\u8be2\u6761\u4ef6", fields={"CUSTOMCOND"})
    public String getCustomCond() {
        return this.psDETreeNode.getCUSTOMCOND();
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u6570\u636e\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"UPDATEPSDEACTIONID"})
    public IPSAppDEAction getUpdatePSAppDEAction() {
        return this.updatePSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u6570\u636e\u8bbf\u95ee\u884c\u4e3a", hideempty2=true)
    public String getUpdateDataAccessAction() {
        if (this.getUpdatePSDEOPPriv() == null) {
            return null;
        }
        return this.getUpdatePSDEOPPriv().getName();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5206\u9875", fields={"ENABLEPAGING"}, ignoredumpvalues="false")
    public boolean isEnablePaging() {
        return this.bEnablePaging;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u9875\u5927\u5c0f", ignoredumpvalues="-1", fields={"PAGESIZE"})
    public int getPagingSize() {
        if (!this.isEnablePaging()) {
            return -1;
        }
        return this.nPagingSize;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u5f62\u6837\u5f0f\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getShapeClsPSDEField() {
        return this.shapeClsPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u5f62\u6837\u5f0f\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"SHAPECLSPSDEFID"})
    public IPSAppDEField getShapeClsPSAppDEField() {
        return this.shapeClsPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u6570\u636e\u8bbf\u95ee\u884c\u4e3a", hideempty2=true)
    public String getMoveDataAccessAction() {
        if (this.getMovePSDEOPPriv() == null) {
            return null;
        }
        return this.getMovePSDEOPPriv().getName();
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u6570\u636e\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"MOVEPSDEACTIONID"})
    public IPSAppDEAction getMovePSAppDEAction() {
        return this.movePSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u6e90\u7c7b\u578b", hideempty=true, codelist="DETreeNodeSource", fields={"DATASOURCE"})
    public String getDataSourceType() {
        return this.strDataSourceType;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", hideempty2=true, fields={"CUSTOMCODE"})
    public String getScriptCode() {
        return this.strScriptCode;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5bf9\u8c61\u540d\u79f0", hideempty2=true, fields={"FIELDNAME"})
    public String getDataName() {
        return this.strDataName;
    }
}

