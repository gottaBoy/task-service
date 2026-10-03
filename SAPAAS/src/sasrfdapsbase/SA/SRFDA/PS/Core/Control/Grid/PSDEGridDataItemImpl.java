/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTOField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodReturn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridDataItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridFieldColumn;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Data.IPSDataItemParam;
import SA.SRFDA.PS.Core.Data.PSDataItemImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEGridDataItemImpl
extends PSDataItemImpl
implements IPSDEGridDataItem {
    private static final Log log = LogFactory.getLog(PSDEGridDataItemImpl.class);
    private boolean bDataAccessAction = false;
    private String strPrivilegeId = null;
    private IPSDEGrid iPSDEGrid = null;
    private IPSDEGridColumn iPSDEGridColumn = null;
    private boolean bTreeNodeValue = false;
    private boolean bTreeNodePValue = false;
    private boolean bTreeNodeText = false;
    private boolean bTreeNodePText = false;
    private IPSDEField iPSDEField = null;
    private IPSAppDEField iPSAppDEField = null;
    private boolean bCustomCode = false;
    private String strScriptCode = null;

    public void init(IPSDEGridColumn iPSDEGridColumn) throws Exception {
        this.iPSDEGridColumn = iPSDEGridColumn;
        this.iPSDEGrid = this.iPSDEGridColumn.getPSDEGrid();
        this.onInit();
    }

    public void init(IPSDEGrid iPSDEGrid) throws Exception {
        this.iPSDEGrid = iPSDEGrid;
        this.onInit();
    }

    protected void onInit() throws Exception {
        IPSDEGridFieldColumn iPSDEGridFieldColumn;
        if (this.getPSDEGridColumn() != null && this.getPSDEGridColumn() instanceof IPSDEGridFieldColumn && StringHelper.compare((String)(iPSDEGridFieldColumn = (IPSDEGridFieldColumn)this.getPSDEGridColumn()).getCLConvertMode(), (String)"BACKEND", (boolean)true) == 0) {
            this.setConvertToCodeItemText(true);
        }
        if (this.getPSDEField() != null) {
            this.setDataType(this.getPSDEField().getStdDataType());
        }
        super.onInit();
    }

    @PSModelRTMeta(description="\u8bbf\u95ee\u63a7\u5236\u6570\u636e\u9879", ignoredumpvalues="false")
    public boolean isDataAccessAction() {
        return this.bDataAccessAction;
    }

    public void setDataAccessAction(boolean bDataAccessAction) {
        this.bDataAccessAction = bDataAccessAction;
    }

    public String getPrivilegeId() {
        return this.strPrivilegeId;
    }

    public void setPrivilegeId(String strPrivilegeId) {
        this.strPrivilegeId = strPrivilegeId;
    }

    @Override
    public String getModelId() {
        if (this.getPSDEGrid() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEGrid().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    public String getModelType() {
        return "PSDEGRIDDATAITEM";
    }

    @Override
    public IPSDEGrid getPSDEGrid() {
        return this.iPSDEGrid;
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.getPSDEGrid() != null) {
            return this.getPSDEGrid().getPSSysModelInstId();
        }
        return super.getPSSysModelInstId();
    }

    @Override
    public IPSDEGridColumn getPSDEGridColumn() {
        return this.iPSDEGridColumn;
    }

    @Override
    public boolean isTreeNodeValue() {
        return this.bTreeNodeValue;
    }

    public void setTreeNodeValue(boolean bTreeNodeValue) {
        this.bTreeNodeValue = bTreeNodeValue;
    }

    @Override
    public boolean isTreeNodePValue() {
        return this.bTreeNodePValue;
    }

    public void setTreeNodePValue(boolean bTreeNodePValue) {
        this.bTreeNodePValue = bTreeNodePValue;
    }

    @Override
    public boolean isTreeNodeText() {
        return this.bTreeNodeText;
    }

    public void setTreeNodeText(boolean bTreeNodeText) {
        this.bTreeNodeText = bTreeNodeText;
    }

    @Override
    public boolean isTreeNodePText() {
        return this.bTreeNodePText;
    }

    public void setTreeNodePText(boolean bTreeNodePText) {
        this.bTreeNodePText = bTreeNodePText;
    }

    @Override
    public IPSDEField getPSDEField() {
        if (this.iPSDEField != null) {
            return this.iPSDEField;
        }
        IPSDEField iPSDEField = null;
        if (this.getDataItemParam() != null && this.getDataItemParam() instanceof IPSDataItemParam && (iPSDEField = ((IPSDataItemParam)this.getDataItemParam()).getPSDEField()) == null && this.getPSDEGrid() != null) {
            try {
                iPSDEField = this.getPSDEGrid().getPSDataEntity().getPSDEField(this.getDataItemParam().getName(), true);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (iPSDEField == null && this.getPSDEGridColumn() != null && this.getPSDEGridColumn() instanceof IPSDEGridFieldColumn) {
            iPSDEField = ((IPSDEGridFieldColumn)this.getPSDEGridColumn()).getPSDEField();
        }
        try {
            if (iPSDEField != null && this.getPSDEGrid() != null && this.getPSDEGrid().getPSAppDataEntity() != null) {
                this.iPSAppDEField = this.getPSDEGrid().getPSAppDataEntity().getPSAppDEField(iPSDEField.getId(), true);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.iPSDEField = iPSDEField;
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true)
    public IPSAppDEField getPSAppDEField() {
        this.getPSDEField();
        return this.iPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u683c\u5f0f\u5316", hideempty2=true, dump=false)
    public String getFormat() {
        return super.getFormat();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u65701\u683c\u5f0f\u5316", hideempty2=true, modelattr="format")
    public String getDataItemParam0Format() {
        if (this.getDataItemParam() != null && this.getDataItemParam() instanceof IPSDataItemParam) {
            return this.getDataItemParam().getFormat();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801\u6a21\u5f0f", ignoredumpvalues="false", model="PSDEGridCol", fields={"CUSTOMMODE"})
    public boolean isCustomCode() {
        return this.bCustomCode;
    }

    public void setCustomCode(boolean bCustomCode) {
        this.bCustomCode = bCustomCode;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", model="PSDEGridCol", fields={"CUSTOMCODE"})
    public String getScriptCode() {
        return this.strScriptCode;
    }

    public void setScriptCode(String strScriptCode) {
        this.strScriptCode = strScriptCode;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u7c7b\u578b", codelist="EditorValueType", ignoredumpvalues="SIMPLE")
    public String getValueType() {
        block7: {
            IPSAppDEMethodDTOField iPSAppDEMethodDTOField;
            block10: {
                block9: {
                    block8: {
                        if (this.getPSAppDEField() == null) {
                            return null;
                        }
                        IPSAppDEMethodDTO iPSAppDEMethodDTO;
                        try {
                           iPSAppDEMethodDTO = this.getPSAppDEMethodDTO();
                           if (iPSAppDEMethodDTO == null || (iPSAppDEMethodDTOField = iPSAppDEMethodDTO.getPSAppDEMethodDTOField(this.getPSAppDEField(), true)) == null) break block7;
                        }
                        catch (Exception ex) {
                           log.error((Object)ex);
                           break block7;
                        }
                        if (!"SIMPLE".equals(iPSAppDEMethodDTOField.getType())) break block8;
                        return "SIMPLE";
                    }
                    if (!"SIMPLES".equals(iPSAppDEMethodDTOField.getType())) break block9;
                    return "SIMPLES";
                }
                if (!"DTOS".equals(iPSAppDEMethodDTOField.getType())) break block10;
                return "OBJECTS";
            }
            try {
                if ("DTO".equals(iPSAppDEMethodDTOField.getType())) {
                    return "OBJECT";
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return null;
    }

    protected IPSAppDEMethodDTO getPSAppDEMethodDTO() throws Exception {
        if (this.getPSDEGrid().getFetchPSControlAction() == null || this.getPSDEGrid().getFetchPSControlAction().getPSAppDEMethod() == null || this.getPSDEGrid().getFetchPSControlAction().getPSAppDEMethod().getPSAppDEMethodReturn() == null) {
            return null;
        }
        IPSAppDEMethodReturn iPSAppDEMethodReturn = this.getPSDEGrid().getFetchPSControlAction().getPSAppDEMethod().getPSAppDEMethodReturn();
        if ("DTO".equals(iPSAppDEMethodReturn.getType()) || "DTOS".equals(iPSAppDEMethodReturn.getType()) || "PAGE".equals(iPSAppDEMethodReturn.getType())) {
            return iPSAppDEMethodReturn.getPSAppDEMethodDTO();
        }
        return null;
    }
}

