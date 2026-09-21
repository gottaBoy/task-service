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
import net.ibizsys.modelapi.domain.PSDEGrid;
import net.ibizsys.modelapi.domain.PSDEGridCol;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEACModeDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFSFItemDTO;
import net.ibizsys.modelapi.dto.PSDEFUIModeDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDEGEIUpdateDTO;
import net.ibizsys.modelapi.dto.PSDEGridColDTO;
import net.ibizsys.modelapi.dto.PSDEGridDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDEUAGroupDTO;
import net.ibizsys.modelapi.dto.PSDEUIActionDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysDictCatDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysEditorStyleDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.service.IPSDEGridColService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEGridColServiceImpl
extends PSModelServiceImplBase<PSDEGridCol, PSDEGridColDTO>
implements IPSDEGridColService {
    private static final Log log = LogFactory.getLog(PSDEGridColServiceImpl.class);

    @Override
    public List<PSDEGridCol> listByPSDEGridCol(PSDEGridCol parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEGridCol get(PSDEGridCol parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEGridCol> list = this.listByPSDEGridCol(parent);
        if (list != null) {
            for (PSDEGridCol item : list) {
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
    public List<PSDEGridColDTO> listDTOByPSDEGridCol(String strParentKey) throws Exception {
        PSDEGridCol psdegridcol = (PSDEGridCol)PSModelServiceUtil.getInstance().getPSDEGridColService().get(strParentKey);
        List<PSDEGridCol> list = this.listByPSDEGridCol(psdegridcol);
        if (list != null) {
            ArrayList<PSDEGridColDTO> dtoList = new ArrayList<PSDEGridColDTO>();
            for (PSDEGridCol item : list) {
                PSDEGridColDTO dto = (PSDEGridColDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEGridCol> listByPSDEGrid(PSDEGrid parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEGridCol get(PSDEGrid parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEGridCol> list = this.listByPSDEGrid(parent);
        if (list != null) {
            for (PSDEGridCol item : list) {
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
    public List<PSDEGridColDTO> listDTOByPSDEGrid(String strParentKey) throws Exception {
        PSDEGrid psdegrid = (PSDEGrid)PSModelServiceUtil.getInstance().getPSDEGridService().get(strParentKey);
        List<PSDEGridCol> list = this.listByPSDEGrid(psdegrid);
        if (list != null) {
            ArrayList<PSDEGridColDTO> dtoList = new ArrayList<PSDEGridColDTO>();
            for (PSDEGridCol item : list) {
                PSDEGridColDTO dto = (PSDEGridColDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEGridCol> onListAll() throws Exception {
        ArrayList<PSDEGridCol> list = new ArrayList<PSDEGridCol>();
        List psdegrids = PSModelServiceUtil.getInstance().getPSDEGridService().listAll();
        if (psdegrids != null) {
            for (PSDEGrid parent : psdegrids) {
                List<PSDEGridCol> items = this.listByPSDEGrid(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSDEGridCol> alllist = new ArrayList<PSDEGridCol>();
        alllist.addAll(list);
        for (PSDEGridCol item : list) {
            List<PSDEGridCol> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEGridCol> listAllChild(PSDEGridCol parent) throws Exception {
        List<PSDEGridCol> list = this.listByPSDEGridCol(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDEGridCol> alllist = new ArrayList<PSDEGridCol>();
        alllist.addAll(list);
        for (PSDEGridCol item : list) {
            List<PSDEGridCol> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEGridCol> listAllByPSDEGrid(PSDEGrid parent) throws Exception {
        List<PSDEGridCol> list = this.listByPSDEGrid(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDEGridCol> alllist = new ArrayList<PSDEGridCol>();
        alllist.addAll(list);
        for (PSDEGridCol item : list) {
            List<PSDEGridCol> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEGridColDTO> listAllDTOByPSDEGrid(String strParentKey) throws Exception {
        PSDEGrid psdegrid = (PSDEGrid)PSModelServiceUtil.getInstance().getPSDEGridService().get(strParentKey);
        List<PSDEGridCol> list = this.listAllByPSDEGrid(psdegrid);
        if (list != null) {
            ArrayList<PSDEGridColDTO> dtoList = new ArrayList<PSDEGridColDTO>();
            for (PSDEGridCol item : list) {
                PSDEGridColDTO dto = (PSDEGridColDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSDEGridCol onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEGridCol item;
        PSDEGridCol item2;
        PSDEGridCol psdegridcol = (PSDEGridCol)PSModelServiceUtil.getInstance().getPSDEGridColService().get(strParentKey, true);
        if (psdegridcol != null && (item2 = this.get(psdegridcol, strCurKey, true)) != null) {
            return item2;
        }
        PSDEGrid psdegrid = (PSDEGrid)PSModelServiceUtil.getInstance().getPSDEGridService().get(strParentKey, true);
        if (psdegrid != null && (item = this.get(psdegrid, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEGridCol)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEGridColDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSDEGridColId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEGridColService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEGridId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEGridService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEGridCol et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEGridColName())) {
            return et.getPSDEGridColName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEGridColDTO dto, PSDEGridCol t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEGridColId(t.getId().replace("/", "."));
        }
        if (t.getAggField() != null || !bIgnoreNull) {
            dto.setAggField(t.getAggField());
        }
        if (t.getAggMode() != null || !bIgnoreNull) {
            dto.setAggMode(t.getAggMode());
        }
        if (t.getAggValueFormat() != null || !bIgnoreNull) {
            dto.setAggValueFormat(t.getAggValueFormat());
        }
        if (t.getAlign() != null || !bIgnoreNull) {
            dto.setAlign(t.getAlign());
        }
        if (t.getAllowEmpty() != null || !bIgnoreNull) {
            dto.setAllowEmpty(t.getAllowEmpty());
        }
        if (t.getCapPSLanResId() != null || !bIgnoreNull) {
            dto.setCapPSLanResId(t.getCapPSLanResId());
        }
        if (t.getCapPSLanResName() != null || !bIgnoreNull) {
            dto.setCapPSLanResName(t.getCapPSLanResName());
        }
        if (t.getCaption() != null || !bIgnoreNull) {
            dto.setCaption(t.getCaption());
        }
        if (t.getCellPSSysCssId() != null || !bIgnoreNull) {
            dto.setCellPSSysCssId(t.getCellPSSysCssId());
        }
        if (t.getCellPSSysCssName() != null || !bIgnoreNull) {
            dto.setCellPSSysCssName(t.getCellPSSysCssName());
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
        if (t.getDataItems() != null || !bIgnoreNull) {
            dto.setDataItems(t.getDataItems());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEditorParams() != null || !bIgnoreNull) {
            dto.setEditorParams(t.getEditorParams());
        }
        if (t.getEditorType() != null || !bIgnoreNull) {
            dto.setEditorType(t.getEditorType());
        }
        if (t.getEditorTypeName() != null || !bIgnoreNull) {
            dto.setEditorTypeName(t.getEditorTypeName());
        }
        if (t.getEnableCond() != null || !bIgnoreNull) {
            dto.setEnableCond(t.getEnableCond());
        }
        if (t.getEnableItemPriv() != null || !bIgnoreNull) {
            dto.setEnableItemPriv(t.getEnableItemPriv());
        }
        if (t.getEnableLink() != null || !bIgnoreNull) {
            dto.setEnableLink(t.getEnableLink());
        }
        if (t.getEnableRowEdit() != null || !bIgnoreNull) {
            dto.setEnableRowEdit(t.getEnableRowEdit());
        }
        if (t.getGCRPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setGCRPSSysPFPluginId(t.getGCRPSSysPFPluginId());
        }
        if (t.getGCRPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setGCRPSSysPFPluginName(t.getGCRPSSysPFPluginName());
        }
        if (t.getGridColStyle() != null || !bIgnoreNull) {
            dto.setGridColStyle(t.getGridColStyle());
        }
        if (t.getGridColType() != null || !bIgnoreNull) {
            dto.setGridColType(t.getGridColType());
        }
        if (t.getGroupItem() != null || !bIgnoreNull) {
            dto.setGroupItem(t.getGroupItem());
        }
        if (t.getHeaderPSSysCssId() != null || !bIgnoreNull) {
            dto.setHeaderPSSysCssId(t.getHeaderPSSysCssId());
        }
        if (t.getHeaderPSSysCssName() != null || !bIgnoreNull) {
            dto.setHeaderPSSysCssName(t.getHeaderPSSysCssName());
        }
        if (t.getHiddenDataItem() != null || !bIgnoreNull) {
            dto.setHiddenDataItem(t.getHiddenDataItem());
        }
        if (t.getHideDefault() != null || !bIgnoreNull) {
            dto.setHideDefault(t.getHideDefault());
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
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getModelState() != null || !bIgnoreNull) {
            dto.setModelState(t.getModelState());
        }
        if (t.getNeedCodeListConfig() != null || !bIgnoreNull) {
            dto.setNeedCodeListConfig(t.getNeedCodeListConfig());
        }
        if (t.getNoPrivDM() != null || !bIgnoreNull) {
            dto.setNoPrivDM(t.getNoPrivDM());
        }
        if (t.getNoSort() != null || !bIgnoreNull) {
            dto.setNoSort(t.getNoSort());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPHPSLanResId() != null || !bIgnoreNull) {
            dto.setPHPSLanResId(t.getPHPSLanResId());
        }
        if (t.getPHPSLanResName() != null || !bIgnoreNull) {
            dto.setPHPSLanResName(t.getPHPSLanResName());
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
        if (t.getPPSDEGridColId() != null || !bIgnoreNull) {
            dto.setPPSDEGridColId(t.getPPSDEGridColId());
        }
        if (t.getPPSDEGridColName() != null || !bIgnoreNull) {
            dto.setPPSDEGridColName(t.getPPSDEGridColName());
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
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDEFSFItemId() != null || !bIgnoreNull) {
            dto.setPSDEFSFItemId(t.getPSDEFSFItemId());
        }
        if (t.getPSDEFSFItemName() != null || !bIgnoreNull) {
            dto.setPSDEFSFItemName(t.getPSDEFSFItemName());
        }
        if (t.getPSDEFUIModeId() != null || !bIgnoreNull) {
            dto.setPSDEFUIModeId(t.getPSDEFUIModeId());
        }
        if (t.getPSDEFUIModeName() != null || !bIgnoreNull) {
            dto.setPSDEFUIModeName(t.getPSDEFUIModeName());
        }
        if (t.getPSDEGEIUpdateId() != null || !bIgnoreNull) {
            dto.setPSDEGEIUpdateId(t.getPSDEGEIUpdateId());
        }
        if (t.getPSDEGEIUpdateName() != null || !bIgnoreNull) {
            dto.setPSDEGEIUpdateName(t.getPSDEGEIUpdateName());
        }
        if (t.getPSDEGridColName() != null || !bIgnoreNull) {
            dto.setPSDEGridColName(t.getPSDEGridColName());
        }
        if (t.getPSDEGridId() != null || !bIgnoreNull) {
            dto.setPSDEGridId(t.getPSDEGridId());
        }
        if (t.getPSDEGridName() != null || !bIgnoreNull) {
            dto.setPSDEGridName(t.getPSDEGridName());
        }
        if (t.getPSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupId(t.getPSDEUAGroupId());
        }
        if (t.getPSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupName(t.getPSDEUAGroupName());
        }
        if (t.getPSDEUIActionId() != null || !bIgnoreNull) {
            dto.setPSDEUIActionId(t.getPSDEUIActionId());
        }
        if (t.getPSDEUIActionName() != null || !bIgnoreNull) {
            dto.setPSDEUIActionName(t.getPSDEUIActionName());
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
        if (t.getPSSysImageId() != null || !bIgnoreNull) {
            dto.setPSSysImageId(t.getPSSysImageId());
        }
        if (t.getPSSysImageName() != null || !bIgnoreNull) {
            dto.setPSSysImageName(t.getPSSysImageName());
        }
        if (t.getRawServiceMethod() != null || !bIgnoreNull) {
            dto.setRawServiceMethod(t.getRawServiceMethod());
        }
        if (t.getRawServiceUrl() != null || !bIgnoreNull) {
            dto.setRawServiceUrl(t.getRawServiceUrl());
        }
        if (t.getRefPSDEACModeId() != null || !bIgnoreNull) {
            dto.setRefPSDEACModeId(t.getRefPSDEACModeId());
        }
        if (t.getRefPSDEACModeName() != null || !bIgnoreNull) {
            dto.setRefPSDEACModeName(t.getRefPSDEACModeName());
        }
        if (t.getRefPSDEDataSetId() != null || !bIgnoreNull) {
            dto.setRefPSDEDataSetId(t.getRefPSDEDataSetId());
        }
        if (t.getRefPSDEDataSetName() != null || !bIgnoreNull) {
            dto.setRefPSDEDataSetName(t.getRefPSDEDataSetName());
        }
        if (t.getRefPSDEId() != null || !bIgnoreNull) {
            dto.setRefPSDEId(t.getRefPSDEId());
        }
        if (t.getRefPSDEName() != null || !bIgnoreNull) {
            dto.setRefPSDEName(t.getRefPSDEName());
        }
        if (t.getRefPSDERId() != null || !bIgnoreNull) {
            dto.setRefPSDERId(t.getRefPSDERId());
        }
        if (t.getRefPSDERName() != null || !bIgnoreNull) {
            dto.setRefPSDERName(t.getRefPSDERName());
        }
        if (t.getResetItemName() != null || !bIgnoreNull) {
            dto.setResetItemName(t.getResetItemName());
        }
        if (t.getTreeItem() != null || !bIgnoreNull) {
            dto.setTreeItem(t.getTreeItem());
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
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
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
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (t.getWidthUnit() != null || !bIgnoreNull) {
            dto.setWidthUnit(t.getWidthUnit());
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCellPSSysCssId())) {
            dto.setCellPSSysCssId(this.getRealPSModelId(t, dto.getCellPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGCRPSSysPFPluginId())) {
            dto.setGCRPSSysPFPluginId(this.getRealPSModelId(t, dto.getGCRPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getHeaderPSSysCssId())) {
            dto.setHeaderPSSysCssId(this.getRealPSModelId(t, dto.getHeaderPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLinkPSDEViewId())) {
            dto.setLinkPSDEViewId(this.getRealPSModelId(t, dto.getLinkPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPHPSLanResId())) {
            dto.setPHPSLanResId(this.getRealPSModelId(t, dto.getPHPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPickupPSDEViewId())) {
            dto.setPickupPSDEViewId(this.getRealPSModelId(t, dto.getPickupPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSDEGridColId())) {
            dto.setPPSDEGridColId(this.getRealPSModelId(t, dto.getPPSDEGridColId()).replace("/", "."));
        }
        if ("PSDEGRIDCOL".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSDEGridColId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFSFItemId())) {
            dto.setPSDEFSFItemId(this.getRealPSModelId(t, dto.getPSDEFSFItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFUIModeId())) {
            dto.setPSDEFUIModeId(this.getRealPSModelId(t, dto.getPSDEFUIModeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEGEIUpdateId())) {
            dto.setPSDEGEIUpdateId(this.getRealPSModelId(t, dto.getPSDEGEIUpdateId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEGridId())) {
            dto.setPSDEGridId(this.getRealPSModelId(t, dto.getPSDEGridId()).replace("/", "."));
        }
        if ("PSDEGRID".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEGridId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            dto.setPSDEUAGroupId(this.getRealPSModelId(t, dto.getPSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            dto.setPSDEUIActionId(this.getRealPSModelId(t, dto.getPSDEUIActionId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEACModeId())) {
            dto.setRefPSDEACModeId(this.getRealPSModelId(t, dto.getRefPSDEACModeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEDataSetId())) {
            dto.setRefPSDEDataSetId(this.getRealPSModelId(t, dto.getRefPSDEDataSetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEId())) {
            dto.setRefPSDEId(this.getRealPSModelId(t, dto.getRefPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDERId())) {
            dto.setRefPSDERId(this.getRealPSModelId(t, dto.getRefPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getCapPSLanResId());
            dto.setCapPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setCapPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getCellPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getCellPSSysCssId());
            dto.setCellPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setCellPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getGCRPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getGCRPSSysPFPluginId());
            dto.setGCRPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setGCRPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getHeaderPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getHeaderPSSysCssId());
            dto.setHeaderPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setHeaderPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getLinkPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getLinkPSDEViewId());
            dto.setLinkPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setLinkPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPHPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getPHPSLanResId());
            dto.setPHPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setPHPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPickupPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPickupPSDEViewId());
            dto.setPickupPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setPickupPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSDEGridColId())) {
            linkDTO = (PSDEGridColDTO)PSModelServiceUtil.getInstance().getPSDEGridColService().getDTO(dto.getPPSDEGridColId());
            dto.setPPSDEGridColName(((PSDEGridColDTO)linkDTO).getPSDEGridColName());
        } else {
            dto.setPPSDEGridColName(null);
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
        if (StringUtils.hasLength((String)dto.getPSDEFSFItemId())) {
            linkDTO = (PSDEFSFItemDTO)PSModelServiceUtil.getInstance().getPSDEFSFItemService().getDTO(dto.getPSDEFSFItemId());
            dto.setPSDEFSFItemName(((PSDEFSFItemDTO)linkDTO).getPSDEFSFItemName());
        } else {
            dto.setPSDEFSFItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFUIModeId())) {
            linkDTO = (PSDEFUIModeDTO)PSModelServiceUtil.getInstance().getPSDEFUIModeService().getDTO(dto.getPSDEFUIModeId());
            dto.setPSDEFUIModeName(((PSDEFUIModeDTO)linkDTO).getPSDEFUIModeName());
        } else {
            dto.setPSDEFUIModeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEGEIUpdateId())) {
            linkDTO = (PSDEGEIUpdateDTO)PSModelServiceUtil.getInstance().getPSDEGEIUpdateService().getDTO(dto.getPSDEGEIUpdateId());
            dto.setPSDEGEIUpdateName(((PSDEGEIUpdateDTO)linkDTO).getPSDEGEIUpdateName());
        } else {
            dto.setPSDEGEIUpdateName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEGridId())) {
            linkDTO = (PSDEGridDTO)PSModelServiceUtil.getInstance().getPSDEGridService().getDTO(dto.getPSDEGridId());
            dto.setPSDEGridName(((PSDEGridDTO)linkDTO).getPSDEGridName());
        } else {
            dto.setPSDEGridName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getPSDEUAGroupId());
            dto.setPSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setPSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            linkDTO = (PSDEUIActionDTO)PSModelServiceUtil.getInstance().getPSDEUIActionService().getDTO(dto.getPSDEUIActionId());
            dto.setPSDEUIActionName(((PSDEUIActionDTO)linkDTO).getPSDEUIActionName());
        } else {
            dto.setPSDEUIActionName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            linkDTO = (PSSysImageDTO)PSModelServiceUtil.getInstance().getPSSysImageService().getDTO(dto.getPSSysImageId());
            dto.setPSSysImageName(((PSSysImageDTO)linkDTO).getPSSysImageName());
        } else {
            dto.setPSSysImageName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEACModeId())) {
            linkDTO = (PSDEACModeDTO)PSModelServiceUtil.getInstance().getPSDEACModeService().getDTO(dto.getRefPSDEACModeId());
            dto.setRefPSDEACModeName(((PSDEACModeDTO)linkDTO).getPSDEACModeName());
        } else {
            dto.setRefPSDEACModeName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEDataSetId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getRefPSDEDataSetId());
            dto.setRefPSDEDataSetName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setRefPSDEDataSetName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getRefPSDEId());
            dto.setRefPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setRefPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getRefPSDERId());
            dto.setRefPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setRefPSDERName(null);
        }
        List<PSDEGridCol> list = PSModelServiceUtil.getInstance().getPSDEGridColService().listByPSDEGridCol(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEGridColDTO> psdegridcols = new ArrayList<PSDEGridColDTO>();
            for (PSDEGridCol item : list) {
                PSDEGridColDTO dstItem = (PSDEGridColDTO)PSModelServiceUtil.getInstance().getPSDEGridColService().toDTO(item);
                psdegridcols.add(dstItem);
            }
            dto.setPsdegridcols(psdegridcols);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEGRIDCOL";
    }

    @Override
    public PSDEGridCol createDomain() {
        return new PSDEGridCol();
    }

    @Override
    public PSDEGridColDTO createDTO() {
        return new PSDEGridColDTO();
    }
}

