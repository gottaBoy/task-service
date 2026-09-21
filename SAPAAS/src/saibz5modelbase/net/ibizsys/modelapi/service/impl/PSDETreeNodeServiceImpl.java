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
import net.ibizsys.modelapi.domain.PSDETreeNodeRV;
import net.ibizsys.modelapi.domain.PSDETreeView;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDEGridDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDEOPPrivDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDEToolbarDTO;
import net.ibizsys.modelapi.dto.PSDETreeNodeColDTO;
import net.ibizsys.modelapi.dto.PSDETreeNodeDTO;
import net.ibizsys.modelapi.dto.PSDETreeNodeRVDTO;
import net.ibizsys.modelapi.dto.PSDETreeViewDTO;
import net.ibizsys.modelapi.dto.PSDEUAGroupDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelDTO;
import net.ibizsys.modelapi.service.IPSDETreeNodeService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDETreeNodeServiceImpl
extends PSModelServiceImplBase<PSDETreeNode, PSDETreeNodeDTO>
implements IPSDETreeNodeService {
    private static final Log log = LogFactory.getLog(PSDETreeNodeServiceImpl.class);

    @Override
    public List<PSDETreeNode> listByPSDETreeView(PSDETreeView parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDETreeNode get(PSDETreeView parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDETreeNode> list = this.listByPSDETreeView(parent);
        if (list != null) {
            for (PSDETreeNode item : list) {
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
    public List<PSDETreeNodeDTO> listDTOByPSDETreeView(String strParentKey) throws Exception {
        PSDETreeView psdetreeview = (PSDETreeView)PSModelServiceUtil.getInstance().getPSDETreeViewService().get(strParentKey);
        List<PSDETreeNode> list = this.listByPSDETreeView(psdetreeview);
        if (list != null) {
            ArrayList<PSDETreeNodeDTO> dtoList = new ArrayList<PSDETreeNodeDTO>();
            for (PSDETreeNode item : list) {
                PSDETreeNodeDTO dto = (PSDETreeNodeDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDETreeNode> onListAll() throws Exception {
        ArrayList<PSDETreeNode> list = new ArrayList<PSDETreeNode>();
        List psdetreeviews = PSModelServiceUtil.getInstance().getPSDETreeViewService().listAll();
        if (psdetreeviews != null) {
            for (PSDETreeView parent : psdetreeviews) {
                List<PSDETreeNode> items = this.listByPSDETreeView(parent);
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
    protected PSDETreeNode onGet(String strParentKey, String strCurKey) throws Exception {
        PSDETreeNode item;
        PSDETreeView psdetreeview = (PSDETreeView)PSModelServiceUtil.getInstance().getPSDETreeViewService().get(strParentKey, true);
        if (psdetreeview != null && (item = this.get(psdetreeview, strCurKey, true)) != null) {
            return item;
        }
        return (PSDETreeNode)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDETreeNodeDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDETreeViewId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDETreeViewService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDETreeNode et) throws Exception {
        if (StringUtils.hasLength((String)et.getNodeType())) {
            return et.getNodeType();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDETreeNodeDTO dto, PSDETreeNode t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDETreeNodeId(t.getId().replace("/", "."));
        }
        if (t.getActionParam() != null || !bIgnoreNull) {
            dto.setActionParam(t.getActionParam());
        }
        if (t.getAppendCapFlag() != null || !bIgnoreNull) {
            dto.setAppendCapFlag(t.getAppendCapFlag());
        }
        if (t.getAppendPNodeId() != null || !bIgnoreNull) {
            dto.setAppendPNodeId(t.getAppendPNodeId());
        }
        if (t.getCaption() != null || !bIgnoreNull) {
            dto.setCaption(t.getCaption());
        }
        if (t.getChecked() != null || !bIgnoreNull) {
            dto.setChecked(t.getChecked());
        }
        if (t.getChildCntPSDEFId() != null || !bIgnoreNull) {
            dto.setChildCntPSDEFId(t.getChildCntPSDEFId());
        }
        if (t.getChildCntPSDEFName() != null || !bIgnoreNull) {
            dto.setChildCntPSDEFName(t.getChildCntPSDEFName());
        }
        if (t.getClsPSDEFId() != null || !bIgnoreNull) {
            dto.setClsPSDEFId(t.getClsPSDEFId());
        }
        if (t.getClsPSDEFName() != null || !bIgnoreNull) {
            dto.setClsPSDEFName(t.getClsPSDEFName());
        }
        if (t.getCMRefresh() != null || !bIgnoreNull) {
            dto.setCMRefresh(t.getCMRefresh());
        }
        if (t.getCMRemove() != null || !bIgnoreNull) {
            dto.setCMRemove(t.getCMRemove());
        }
        if (t.getCounterId() != null || !bIgnoreNull) {
            dto.setCounterId(t.getCounterId());
        }
        if (t.getCounterMode() != null || !bIgnoreNull) {
            dto.setCounterMode(t.getCounterMode());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomCond() != null || !bIgnoreNull) {
            dto.setCustomCond(t.getCustomCond());
        }
        if (t.getDataTypePSDEFId() != null || !bIgnoreNull) {
            dto.setDataTypePSDEFId(t.getDataTypePSDEFId());
        }
        if (t.getDataTypePSDEFName() != null || !bIgnoreNull) {
            dto.setDataTypePSDEFName(t.getDataTypePSDEFName());
        }
        if (t.getDisableSelect() != null || !bIgnoreNull) {
            dto.setDisableSelect(t.getDisableSelect());
        }
        if (t.getDistinctMode() != null || !bIgnoreNull) {
            dto.setDistinctMode(t.getDistinctMode());
        }
        if (t.getDynaClass() != null || !bIgnoreNull) {
            dto.setDynaClass(t.getDynaClass());
        }
        if (t.getEditDataMode() != null || !bIgnoreNull) {
            dto.setEditDataMode(t.getEditDataMode());
        }
        if (t.getEditMode() != null || !bIgnoreNull) {
            dto.setEditMode(t.getEditMode());
        }
        if (t.getEnableCheck() != null || !bIgnoreNull) {
            dto.setEnableCheck(t.getEnableCheck());
        }
        if (t.getEnableQuickSearch() != null || !bIgnoreNull) {
            dto.setEnableQuickSearch(t.getEnableQuickSearch());
        }
        if (t.getEnableUP() != null || !bIgnoreNull) {
            dto.setEnableUP(t.getEnableUP());
        }
        if (t.getEnableViewActions() != null || !bIgnoreNull) {
            dto.setEnableViewActions(t.getEnableViewActions());
        }
        if (t.getExpand() != null || !bIgnoreNull) {
            dto.setExpand(t.getExpand());
        }
        if (t.getFilterPSDEDSId() != null || !bIgnoreNull) {
            dto.setFilterPSDEDSId(t.getFilterPSDEDSId());
        }
        if (t.getFilterPSDEDSName() != null || !bIgnoreNull) {
            dto.setFilterPSDEDSName(t.getFilterPSDEDSName());
        }
        if (t.getIconPSDEFId() != null || !bIgnoreNull) {
            dto.setIconPSDEFId(t.getIconPSDEFId());
        }
        if (t.getIconPSDEFName() != null || !bIgnoreNull) {
            dto.setIconPSDEFName(t.getIconPSDEFName());
        }
        if (t.getKeyPSDEFId() != null || !bIgnoreNull) {
            dto.setKeyPSDEFId(t.getKeyPSDEFId());
        }
        if (t.getKeyPSDEFName() != null || !bIgnoreNull) {
            dto.setKeyPSDEFName(t.getKeyPSDEFName());
        }
        if (t.getLeafFlagPSDEFId() != null || !bIgnoreNull) {
            dto.setLeafFlagPSDEFId(t.getLeafFlagPSDEFId());
        }
        if (t.getLeafFlagPSDEFName() != null || !bIgnoreNull) {
            dto.setLeafFlagPSDEFName(t.getLeafFlagPSDEFName());
        }
        if (t.getMaxSize() != null || !bIgnoreNull) {
            dto.setMaxSize(t.getMaxSize());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getModelObj() != null || !bIgnoreNull) {
            dto.setModelObj(t.getModelObj());
        }
        if (t.getNamePSLanResId() != null || !bIgnoreNull) {
            dto.setNamePSLanResId(t.getNamePSLanResId());
        }
        if (t.getNamePSLanResName() != null || !bIgnoreNull) {
            dto.setNamePSLanResName(t.getNamePSLanResName());
        }
        if (t.getNavViewFilter() != null || !bIgnoreNull) {
            dto.setNavViewFilter(t.getNavViewFilter());
        }
        if (t.getNavViewFilterDesc() != null || !bIgnoreNull) {
            dto.setNavViewFilterDesc(t.getNavViewFilterDesc());
        }
        if (t.getNavViewParam() != null || !bIgnoreNull) {
            dto.setNavViewParam(t.getNavViewParam());
        }
        if (t.getNewDataMode() != null || !bIgnoreNull) {
            dto.setNewDataMode(t.getNewDataMode());
        }
        if (t.getNo2PSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setNo2PSDEUAGroupId(t.getNo2PSDEUAGroupId());
        }
        if (t.getNo2PSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setNo2PSDEUAGroupName(t.getNo2PSDEUAGroupName());
        }
        if (t.getNodeAction() != null || !bIgnoreNull) {
            dto.setNodeAction(t.getNodeAction());
        }
        if (t.getNodeDataType() != null || !bIgnoreNull) {
            dto.setNodeDataType(t.getNodeDataType());
        }
        if (t.getNodeId2PSDEFId() != null || !bIgnoreNull) {
            dto.setNodeId2PSDEFId(t.getNodeId2PSDEFId());
        }
        if (t.getNodeId2PSDEFName() != null || !bIgnoreNull) {
            dto.setNodeId2PSDEFName(t.getNodeId2PSDEFName());
        }
        if (t.getNodeId3PSDEFId() != null || !bIgnoreNull) {
            dto.setNodeId3PSDEFId(t.getNodeId3PSDEFId());
        }
        if (t.getNodeId3PSDEFName() != null || !bIgnoreNull) {
            dto.setNodeId3PSDEFName(t.getNodeId3PSDEFName());
        }
        if (t.getNodeId4PSDEFId() != null || !bIgnoreNull) {
            dto.setNodeId4PSDEFId(t.getNodeId4PSDEFId());
        }
        if (t.getNodeId4PSDEFName() != null || !bIgnoreNull) {
            dto.setNodeId4PSDEFName(t.getNodeId4PSDEFName());
        }
        if (t.getNodeIdPSDEFId() != null || !bIgnoreNull) {
            dto.setNodeIdPSDEFId(t.getNodeIdPSDEFId());
        }
        if (t.getNodeIdPSDEFName() != null || !bIgnoreNull) {
            dto.setNodeIdPSDEFName(t.getNodeIdPSDEFName());
        }
        if (t.getNodeType() != null || !bIgnoreNull) {
            dto.setNodeType(t.getNodeType());
        }
        if (t.getNodeValue() != null || !bIgnoreNull) {
            dto.setNodeValue(t.getNodeValue());
        }
        if (t.getPreventXSS() != null || !bIgnoreNull) {
            dto.setPreventXSS(t.getPreventXSS());
        }
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSDEDSId() != null || !bIgnoreNull) {
            dto.setPSDEDSId(t.getPSDEDSId());
        }
        if (t.getPSDEDSName() != null || !bIgnoreNull) {
            dto.setPSDEDSName(t.getPSDEDSName());
        }
        if (t.getPSDEGridId() != null || !bIgnoreNull) {
            dto.setPSDEGridId(t.getPSDEGridId());
        }
        if (t.getPSDEGridName() != null || !bIgnoreNull) {
            dto.setPSDEGridName(t.getPSDEGridName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDELogicId() != null || !bIgnoreNull) {
            dto.setPSDELogicId(t.getPSDELogicId());
        }
        if (t.getPSDELogicName() != null || !bIgnoreNull) {
            dto.setPSDELogicName(t.getPSDELogicName());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDERId() != null || !bIgnoreNull) {
            dto.setPSDERId(t.getPSDERId());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
        }
        if (t.getPSDEToolbarId() != null || !bIgnoreNull) {
            dto.setPSDEToolbarId(t.getPSDEToolbarId());
        }
        if (t.getPSDEToolbarName() != null || !bIgnoreNull) {
            dto.setPSDEToolbarName(t.getPSDEToolbarName());
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
        if (t.getPSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupId(t.getPSDEUAGroupId());
        }
        if (t.getPSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupName(t.getPSDEUAGroupName());
        }
        if (t.getPSDEViewBaseId() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseId(t.getPSDEViewBaseId());
        }
        if (t.getPSDEViewBaseName() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseName(t.getPSDEViewBaseName());
        }
        if (t.getPSSysCssId() != null || !bIgnoreNull) {
            dto.setPSSysCssId(t.getPSSysCssId());
        }
        if (t.getPSSysCssName() != null || !bIgnoreNull) {
            dto.setPSSysCssName(t.getPSSysCssName());
        }
        if (t.getPSSysImageId() != null || !bIgnoreNull) {
            dto.setPSSysImageId(t.getPSSysImageId());
        }
        if (t.getPSSysImageName() != null || !bIgnoreNull) {
            dto.setPSSysImageName(t.getPSSysImageName());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSysViewPanelId() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelId(t.getPSSysViewPanelId());
        }
        if (t.getPSSysViewPanelName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelName(t.getPSSysViewPanelName());
        }
        if (t.getRemovePSDEActionId() != null || !bIgnoreNull) {
            dto.setRemovePSDEActionId(t.getRemovePSDEActionId());
        }
        if (t.getRemovePSDEActionName() != null || !bIgnoreNull) {
            dto.setRemovePSDEActionName(t.getRemovePSDEActionName());
        }
        if (t.getRemovePSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setRemovePSDEOPPrivId(t.getRemovePSDEOPPrivId());
        }
        if (t.getRemovePSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setRemovePSDEOPPrivName(t.getRemovePSDEOPPrivName());
        }
        if (t.getRootNode() != null || !bIgnoreNull) {
            dto.setRootNode(t.getRootNode());
        }
        if (t.getSelected() != null || !bIgnoreNull) {
            dto.setSelected(t.getSelected());
        }
        if (t.getSortDir() != null || !bIgnoreNull) {
            dto.setSortDir(t.getSortDir());
        }
        if (t.getSortPSDEFId() != null || !bIgnoreNull) {
            dto.setSortPSDEFId(t.getSortPSDEFId());
        }
        if (t.getSortPSDEFName() != null || !bIgnoreNull) {
            dto.setSortPSDEFName(t.getSortPSDEFName());
        }
        if (t.getTextPSDEFId() != null || !bIgnoreNull) {
            dto.setTextPSDEFId(t.getTextPSDEFId());
        }
        if (t.getTextPSDEFName() != null || !bIgnoreNull) {
            dto.setTextPSDEFName(t.getTextPSDEFName());
        }
        if (t.getTipPSLanResId() != null || !bIgnoreNull) {
            dto.setTipPSLanResId(t.getTipPSLanResId());
        }
        if (t.getTipPSLanResName() != null || !bIgnoreNull) {
            dto.setTipPSLanResName(t.getTipPSLanResName());
        }
        if (t.getTipsPSDEFId() != null || !bIgnoreNull) {
            dto.setTipsPSDEFId(t.getTipsPSDEFId());
        }
        if (t.getTipsPSDEFName() != null || !bIgnoreNull) {
            dto.setTipsPSDEFName(t.getTipsPSDEFName());
        }
        if (t.getTooltipInfo() != null || !bIgnoreNull) {
            dto.setTooltipInfo(t.getTooltipInfo());
        }
        if (t.getTreeNodeType() != null || !bIgnoreNull) {
            dto.setTreeNodeType(t.getTreeNodeType());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUpdatePSDEActionId() != null || !bIgnoreNull) {
            dto.setUpdatePSDEActionId(t.getUpdatePSDEActionId());
        }
        if (t.getUpdatePSDEActionName() != null || !bIgnoreNull) {
            dto.setUpdatePSDEActionName(t.getUpdatePSDEActionName());
        }
        if (t.getUpdatePSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setUpdatePSDEOPPrivId(t.getUpdatePSDEOPPrivId());
        }
        if (t.getUpdatePSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setUpdatePSDEOPPrivName(t.getUpdatePSDEOPPrivName());
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
        if (t.getUserTag3() != null || !bIgnoreNull) {
            dto.setUserTag3(t.getUserTag3());
        }
        if (t.getUserTag4() != null || !bIgnoreNull) {
            dto.setUserTag4(t.getUserTag4());
        }
        if (t.getViewActions() != null || !bIgnoreNull) {
            dto.setViewActions(t.getViewActions());
        }
        if (StringUtils.hasLength((String)dto.getChildCntPSDEFId())) {
            dto.setChildCntPSDEFId(this.getRealPSModelId(t, dto.getChildCntPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getClsPSDEFId())) {
            dto.setClsPSDEFId(this.getRealPSModelId(t, dto.getClsPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDataTypePSDEFId())) {
            dto.setDataTypePSDEFId(this.getRealPSModelId(t, dto.getDataTypePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getFilterPSDEDSId())) {
            dto.setFilterPSDEDSId(this.getRealPSModelId(t, dto.getFilterPSDEDSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getIconPSDEFId())) {
            dto.setIconPSDEFId(this.getRealPSModelId(t, dto.getIconPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getKeyPSDEFId())) {
            dto.setKeyPSDEFId(this.getRealPSModelId(t, dto.getKeyPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLeafFlagPSDEFId())) {
            dto.setLeafFlagPSDEFId(this.getRealPSModelId(t, dto.getLeafFlagPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNamePSLanResId())) {
            dto.setNamePSLanResId(this.getRealPSModelId(t, dto.getNamePSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo2PSDEUAGroupId())) {
            dto.setNo2PSDEUAGroupId(this.getRealPSModelId(t, dto.getNo2PSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNodeId2PSDEFId())) {
            dto.setNodeId2PSDEFId(this.getRealPSModelId(t, dto.getNodeId2PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNodeId3PSDEFId())) {
            dto.setNodeId3PSDEFId(this.getRealPSModelId(t, dto.getNodeId3PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNodeId4PSDEFId())) {
            dto.setNodeId4PSDEFId(this.getRealPSModelId(t, dto.getNodeId4PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNodeIdPSDEFId())) {
            dto.setNodeIdPSDEFId(this.getRealPSModelId(t, dto.getNodeIdPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            dto.setPSDEDSId(this.getRealPSModelId(t, dto.getPSDEDSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEGridId())) {
            dto.setPSDEGridId(this.getRealPSModelId(t, dto.getPSDEGridId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            dto.setPSDELogicId(this.getRealPSModelId(t, dto.getPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEToolbarId())) {
            dto.setPSDEToolbarId(this.getRealPSModelId(t, dto.getPSDEToolbarId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeViewId())) {
            dto.setPSDETreeViewId(this.getRealPSModelId(t, dto.getPSDETreeViewId()).replace("/", "."));
        }
        if ("PSDETREEVIEW".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDETreeViewId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            dto.setPSDEUAGroupId(this.getRealPSModelId(t, dto.getPSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            dto.setPSDEViewBaseId(this.getRealPSModelId(t, dto.getPSDEViewBaseId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            dto.setPSSysViewPanelId(this.getRealPSModelId(t, dto.getPSSysViewPanelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEActionId())) {
            dto.setRemovePSDEActionId(this.getRealPSModelId(t, dto.getRemovePSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEOPPrivId())) {
            dto.setRemovePSDEOPPrivId(this.getRealPSModelId(t, dto.getRemovePSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSortPSDEFId())) {
            dto.setSortPSDEFId(this.getRealPSModelId(t, dto.getSortPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTextPSDEFId())) {
            dto.setTextPSDEFId(this.getRealPSModelId(t, dto.getTextPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            dto.setTipPSLanResId(this.getRealPSModelId(t, dto.getTipPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTipsPSDEFId())) {
            dto.setTipsPSDEFId(this.getRealPSModelId(t, dto.getTipsPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEActionId())) {
            dto.setUpdatePSDEActionId(this.getRealPSModelId(t, dto.getUpdatePSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEOPPrivId())) {
            dto.setUpdatePSDEOPPrivId(this.getRealPSModelId(t, dto.getUpdatePSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getChildCntPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getChildCntPSDEFId());
            dto.setChildCntPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setChildCntPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getClsPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getClsPSDEFId());
            dto.setClsPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setClsPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getDataTypePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getDataTypePSDEFId());
            dto.setDataTypePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setDataTypePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getFilterPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getFilterPSDEDSId());
            dto.setFilterPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setFilterPSDEDSName(null);
        }
        if (StringUtils.hasLength((String)dto.getIconPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getIconPSDEFId());
            dto.setIconPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setIconPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getKeyPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getKeyPSDEFId());
            dto.setKeyPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setKeyPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getLeafFlagPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getLeafFlagPSDEFId());
            dto.setLeafFlagPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setLeafFlagPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getNamePSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getNamePSLanResId());
            dto.setNamePSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setNamePSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo2PSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getNo2PSDEUAGroupId());
            dto.setNo2PSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setNo2PSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getNodeId2PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getNodeId2PSDEFId());
            dto.setNodeId2PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setNodeId2PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getNodeId3PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getNodeId3PSDEFId());
            dto.setNodeId3PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setNodeId3PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getNodeId4PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getNodeId4PSDEFId());
            dto.setNodeId4PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setNodeId4PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getNodeIdPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getNodeIdPSDEFId());
            dto.setNodeIdPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setNodeIdPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDSId());
            dto.setPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDSName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEGridId())) {
            linkDTO = (PSDEGridDTO)PSModelServiceUtil.getInstance().getPSDEGridService().getDTO(dto.getPSDEGridId());
            dto.setPSDEGridName(((PSDEGridDTO)linkDTO).getPSDEGridName());
        } else {
            dto.setPSDEGridName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getPSDELogicId());
            dto.setPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEToolbarId())) {
            linkDTO = (PSDEToolbarDTO)PSModelServiceUtil.getInstance().getPSDEToolbarService().getDTO(dto.getPSDEToolbarId());
            dto.setPSDEToolbarName(((PSDEToolbarDTO)linkDTO).getPSDEToolbarName());
        } else {
            dto.setPSDEToolbarName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeViewId())) {
            linkDTO = (PSDETreeViewDTO)PSModelServiceUtil.getInstance().getPSDETreeViewService().getDTO(dto.getPSDETreeViewId());
            dto.setPSDETreeViewName(((PSDETreeViewDTO)linkDTO).getPSDETreeViewName());
            dto.setPSSystemId(((PSDETreeViewDTO)linkDTO).getPSSystemId());
        } else {
            dto.setPSDETreeViewName(null);
            dto.setPSSystemId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getPSDEUAGroupId());
            dto.setPSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setPSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPSDEViewBaseId());
            dto.setPSDEViewBaseName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setPSDEViewBaseName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getPSSysCssId());
            dto.setPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            linkDTO = (PSSysImageDTO)PSModelServiceUtil.getInstance().getPSSysImageService().getDTO(dto.getPSSysImageId());
            dto.setPSSysImageName(((PSSysImageDTO)linkDTO).getPSSysImageName());
        } else {
            dto.setPSSysImageName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            linkDTO = (PSSysViewPanelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelService().getDTO(dto.getPSSysViewPanelId());
            dto.setPSSysViewPanelName(((PSSysViewPanelDTO)linkDTO).getPSSysViewPanelName());
        } else {
            dto.setPSSysViewPanelName(null);
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getRemovePSDEActionId());
            dto.setRemovePSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setRemovePSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getRemovePSDEOPPrivId());
            dto.setRemovePSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setRemovePSDEOPPrivName(null);
        }
        if (StringUtils.hasLength((String)dto.getSortPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getSortPSDEFId());
            dto.setSortPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setSortPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTextPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTextPSDEFId());
            dto.setTextPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTextPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getTipPSLanResId());
            dto.setTipPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setTipPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getTipsPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTipsPSDEFId());
            dto.setTipsPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTipsPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getUpdatePSDEActionId());
            dto.setUpdatePSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setUpdatePSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getUpdatePSDEOPPrivId());
            dto.setUpdatePSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setUpdatePSDEOPPrivName(null);
        }
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSDETreeNodeColService().listByPSDETreeNode(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDETreeNodeColDTO> psdetreenodecols = new ArrayList<PSDETreeNodeColDTO>();
            for (PSDETreeNodeCol pSDETreeNodeCol : list) {
                dstItem = (PSDETreeNodeColDTO)PSModelServiceUtil.getInstance().getPSDETreeNodeColService().toDTO(pSDETreeNodeCol);
                psdetreenodecols.add((PSDETreeNodeColDTO)dstItem);
            }
            dto.setPsdetreenodecols(psdetreenodecols);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDETreeNodeRVService().listByPSDETreeNode(t)) != null && list.size() > 0) {
            ArrayList<PSDETreeNodeRVDTO> psdetreenodervs = new ArrayList<PSDETreeNodeRVDTO>();
            for (PSDETreeNodeRV pSDETreeNodeRV : list) {
                dstItem = (PSDETreeNodeRVDTO)PSModelServiceUtil.getInstance().getPSDETreeNodeRVService().toDTO(pSDETreeNodeRV);
                psdetreenodervs.add((PSDETreeNodeRVDTO)dstItem);
            }
            dto.setPsdetreenodervs(psdetreenodervs);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDETREENODE";
    }

    @Override
    public PSDETreeNode createDomain() {
        return new PSDETreeNode();
    }

    @Override
    public PSDETreeNodeDTO createDTO() {
        return new PSDETreeNodeDTO();
    }
}

