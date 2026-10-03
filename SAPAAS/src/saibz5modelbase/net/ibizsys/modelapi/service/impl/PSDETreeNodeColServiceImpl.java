/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSDETreeNode;
import net.ibizsys.modelapi.domain.PSDETreeNodeCol;
import net.ibizsys.modelapi.domain.PSDETreeView;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDETreeColDTO;
import net.ibizsys.modelapi.dto.PSDETreeNodeColDTO;
import net.ibizsys.modelapi.dto.PSDETreeNodeDTO;
import net.ibizsys.modelapi.dto.PSDETreeViewDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSSysDictCatDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysEditorStyleDTO;
import net.ibizsys.modelapi.service.IPSDETreeNodeColService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDETreeNodeColServiceImpl
extends PSModelServiceImplBase<PSDETreeNodeCol, PSDETreeNodeColDTO>
implements IPSDETreeNodeColService {
    private static final Log log = LogFactory.getLog(PSDETreeNodeColServiceImpl.class);

    @Override
    public List<PSDETreeNodeCol> listByPSDETreeNode(PSDETreeNode parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDETreeNodeCol get(PSDETreeNode parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDETreeNodeCol> list = this.listByPSDETreeNode(parent);
        if (list != null) {
            for (PSDETreeNodeCol item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSDETreeNodeColDTO> listDTOByPSDETreeNode(String strParentKey) throws Exception {
        PSDETreeNode psdetreenode = (PSDETreeNode)PSModelServiceUtil.getInstance().getPSDETreeNodeService().get(strParentKey);
        List<PSDETreeNodeCol> list = this.listByPSDETreeNode(psdetreenode);
        if (list != null) {
            ArrayList<PSDETreeNodeColDTO> dtoList = new ArrayList<PSDETreeNodeColDTO>();
            for (PSDETreeNodeCol item : list) {
                PSDETreeNodeColDTO dto = (PSDETreeNodeColDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDETreeNodeCol> listByPSDETreeView(PSDETreeView parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDETreeNodeCol get(PSDETreeView parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDETreeNodeCol> list = this.listByPSDETreeView(parent);
        if (list != null) {
            for (PSDETreeNodeCol item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSDETreeNodeColDTO> listDTOByPSDETreeView(String strParentKey) throws Exception {
        PSDETreeView psdetreeview = (PSDETreeView)PSModelServiceUtil.getInstance().getPSDETreeViewService().get(strParentKey);
        List<PSDETreeNodeCol> list = this.listByPSDETreeView(psdetreeview);
        if (list != null) {
            ArrayList<PSDETreeNodeColDTO> dtoList = new ArrayList<PSDETreeNodeColDTO>();
            for (PSDETreeNodeCol item : list) {
                PSDETreeNodeColDTO dto = (PSDETreeNodeColDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDETreeNodeCol> onListAll() throws Exception {
        ArrayList<PSDETreeNodeCol> list = new ArrayList<PSDETreeNodeCol>();
        List<PSDETreeNode> psdetreenodes = PSModelServiceUtil.getInstance().getPSDETreeNodeService().listAll();
        if (psdetreenodes != null) {
            for (PSDETreeNode parent : psdetreenodes) {
                List<PSDETreeNodeCol> items = this.listByPSDETreeNode(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    @Override
    protected PSDETreeNodeCol onGet(String strParentKey, String strCurKey) throws Exception {
        PSDETreeNodeCol item;
        PSDETreeNode psdetreenode = (PSDETreeNode)PSModelServiceUtil.getInstance().getPSDETreeNodeService().get(strParentKey, true);
        if (psdetreenode != null && (item = this.get(psdetreenode, strCurKey, true)) != null) {
            return item;
        }
        return (PSDETreeNodeCol)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDETreeNodeColDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDETreeNodeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDETreeNodeService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDETreeViewId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDETreeViewService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDETreeNodeCol et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDETreeNodeColName())) {
            return et.getPSDETreeNodeColName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDETreeNodeColDTO dto, PSDETreeNodeCol t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDETreeNodeColId(t.getId().replace("/", "."));
        }
        if (t.getAllowEmpty() != null || !bIgnoreNull) {
            dto.setAllowEmpty(t.getAllowEmpty());
        }
        if (t.getCLConvertMode() != null || !bIgnoreNull) {
            dto.setCLConvertMode(t.getCLConvertMode());
        }
        if (t.getCodeListConfigMode() != null || !bIgnoreNull) {
            dto.setCodeListConfigMode(t.getCodeListConfigMode());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateDV() != null || !bIgnoreNull) {
            dto.setCreateDV(t.getCreateDV());
        }
        if (t.getCreateDVT() != null || !bIgnoreNull) {
            dto.setCreateDVT(t.getCreateDVT());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomCode() != null || !bIgnoreNull) {
            dto.setCustomCode(t.getCustomCode());
        }
        if (t.getCustomMode() != null || !bIgnoreNull) {
            dto.setCustomMode(t.getCustomMode());
        }
        if (t.getDefaultValue() != null || !bIgnoreNull) {
            dto.setDefaultValue(t.getDefaultValue());
        }
        if (t.getEditorParams() != null || !bIgnoreNull) {
            dto.setEditorParams(t.getEditorParams());
        }
        if (t.getEditorType() != null || !bIgnoreNull) {
            dto.setEditorType(t.getEditorType());
        }
        if (t.getEnableCond() != null || !bIgnoreNull) {
            dto.setEnableCond(t.getEnableCond());
        }
        if (t.getEnableItemPriv() != null || !bIgnoreNull) {
            dto.setEnableItemPriv(t.getEnableItemPriv());
        }
        if (t.getEnableRowEdit() != null || !bIgnoreNull) {
            dto.setEnableRowEdit(t.getEnableRowEdit());
        }
        if (t.getGroupItem() != null || !bIgnoreNull) {
            dto.setGroupItem(t.getGroupItem());
        }
        if (t.getHiddenDataItem() != null || !bIgnoreNull) {
            dto.setHiddenDataItem(t.getHiddenDataItem());
        }
        if (t.getIgnoreInput() != null || !bIgnoreNull) {
            dto.setIgnoreInput(t.getIgnoreInput());
        }
        if (t.getLinkPSDEViewId() != null || !bIgnoreNull) {
            dto.setLinkPSDEViewId(t.getLinkPSDEViewId());
        }
        if (t.getLinkPSDEViewName() != null || !bIgnoreNull) {
            dto.setLinkPSDEViewName(t.getLinkPSDEViewName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getNeedCodeListConfig() != null || !bIgnoreNull) {
            dto.setNeedCodeListConfig(t.getNeedCodeListConfig());
        }
        if (t.getPickupPSDEViewId() != null || !bIgnoreNull) {
            dto.setPickupPSDEViewId(t.getPickupPSDEViewId());
        }
        if (t.getPickupPSDEViewName() != null || !bIgnoreNull) {
            dto.setPickupPSDEViewName(t.getPickupPSDEViewName());
        }
        if (t.getPlaceHolder() != null || !bIgnoreNull) {
            dto.setPlaceHolder(t.getPlaceHolder());
        }
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDETreeColId() != null || !bIgnoreNull) {
            dto.setPSDETreeColId(t.getPSDETreeColId());
        }
        if (t.getPSDETreeColName() != null || !bIgnoreNull) {
            dto.setPSDETreeColName(t.getPSDETreeColName());
        }
        if (t.getPSDETreeNodeColName() != null || !bIgnoreNull) {
            dto.setPSDETreeNodeColName(t.getPSDETreeNodeColName());
        }
        if (t.getPSDETreeNodeId() != null || !bIgnoreNull) {
            dto.setPSDETreeNodeId(t.getPSDETreeNodeId());
        }
        if (t.getPSDETreeNodeName() != null || !bIgnoreNull) {
            dto.setPSDETreeNodeName(t.getPSDETreeNodeName());
        }
        if (t.getPSDETreeViewId() != null || !bIgnoreNull) {
            dto.setPSDETreeViewId(t.getPSDETreeViewId());
        }
        if (t.getPSDETreeViewName() != null || !bIgnoreNull) {
            dto.setPSDETreeViewName(t.getPSDETreeViewName());
        }
        if (t.getPSSysDictCatId() != null || !bIgnoreNull) {
            dto.setPSSysDictCatId(t.getPSSysDictCatId());
        }
        if (t.getPSSysDictCatName() != null || !bIgnoreNull) {
            dto.setPSSysDictCatName(t.getPSSysDictCatName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysEditorStyleId() != null || !bIgnoreNull) {
            dto.setPSSysEditorStyleId(t.getPSSysEditorStyleId());
        }
        if (t.getPSSysEditorStyleName() != null || !bIgnoreNull) {
            dto.setPSSysEditorStyleName(t.getPSSysEditorStyleName());
        }
        if (t.getResetItemName() != null || !bIgnoreNull) {
            dto.setResetItemName(t.getResetItemName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateDV() != null || !bIgnoreNull) {
            dto.setUpdateDV(t.getUpdateDV());
        }
        if (t.getUpdateDVT() != null || !bIgnoreNull) {
            dto.setUpdateDVT(t.getUpdateDVT());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserCat() != null || !bIgnoreNull) {
            dto.setUserCat(t.getUserCat());
        }
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (t.getValueFormat() != null || !bIgnoreNull) {
            dto.setValueFormat(t.getValueFormat());
        }
        if (t.getValueItemName() != null || !bIgnoreNull) {
            dto.setValueItemName(t.getValueItemName());
        }
        if (StringUtils.hasLength((String)dto.getLinkPSDEViewId())) {
            dto.setLinkPSDEViewId(this.getRealPSModelId(t, dto.getLinkPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPickupPSDEViewId())) {
            dto.setPickupPSDEViewId(this.getRealPSModelId(t, dto.getPickupPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeColId())) {
            dto.setPSDETreeColId(this.getRealPSModelId(t, dto.getPSDETreeColId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeNodeId())) {
            dto.setPSDETreeNodeId(this.getRealPSModelId(t, dto.getPSDETreeNodeId()).replace("/", "."));
        }
        if ("PSDETREENODE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDETreeNodeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeViewId())) {
            dto.setPSDETreeViewId(this.getRealPSModelId(t, dto.getPSDETreeViewId()).replace("/", "."));
        }
        if ("PSDETREEVIEW".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDETreeViewId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDictCatId())) {
            dto.setPSSysDictCatId(this.getRealPSModelId(t, dto.getPSSysDictCatId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysEditorStyleId())) {
            dto.setPSSysEditorStyleId(this.getRealPSModelId(t, dto.getPSSysEditorStyleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLinkPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getLinkPSDEViewId());
            dto.setLinkPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setLinkPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPickupPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPickupPSDEViewId());
            dto.setPickupPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setPickupPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeColId())) {
            linkDTO = (PSDETreeColDTO)PSModelServiceUtil.getInstance().getPSDETreeColService().getDTO(dto.getPSDETreeColId());
            dto.setPSDETreeColName(((PSDETreeColDTO)linkDTO).getPSDETreeColName());
        } else {
            dto.setPSDETreeColName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeNodeId())) {
            linkDTO = (PSDETreeNodeDTO)PSModelServiceUtil.getInstance().getPSDETreeNodeService().getDTO(dto.getPSDETreeNodeId());
            dto.setPSDETreeNodeName(((PSDETreeNodeDTO)linkDTO).getPSDETreeNodeName());
        } else {
            dto.setPSDETreeNodeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeViewId())) {
            linkDTO = (PSDETreeViewDTO)PSModelServiceUtil.getInstance().getPSDETreeViewService().getDTO(dto.getPSDETreeViewId());
            dto.setPSDETreeViewName(((PSDETreeViewDTO)linkDTO).getPSDETreeViewName());
        } else {
            dto.setPSDETreeViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDictCatId())) {
            linkDTO = (PSSysDictCatDTO)PSModelServiceUtil.getInstance().getPSSysDictCatService().getDTO(dto.getPSSysDictCatId());
            dto.setPSSysDictCatName(((PSSysDictCatDTO)linkDTO).getPSSysDictCatName());
        } else {
            dto.setPSSysDictCatName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysEditorStyleId())) {
            linkDTO = (PSSysEditorStyleDTO)PSModelServiceUtil.getInstance().getPSSysEditorStyleService().getDTO(dto.getPSSysEditorStyleId());
            dto.setPSSysEditorStyleName(((PSSysEditorStyleDTO)linkDTO).getPSSysEditorStyleName());
        } else {
            dto.setPSSysEditorStyleName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDETREENODECOL";
    }

    @Override
    public PSDETreeNodeCol createDomain() {
        return new PSDETreeNodeCol();
    }

    @Override
    public PSDETreeNodeColDTO createDTO() {
        return new PSDETreeNodeColDTO();
    }
}

