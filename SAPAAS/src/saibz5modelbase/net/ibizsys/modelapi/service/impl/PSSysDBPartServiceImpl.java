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
import net.ibizsys.modelapi.domain.PSSysDBPart;
import net.ibizsys.modelapi.domain.PSSysDashboard;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysDBPartDTO;
import net.ibizsys.modelapi.dto.PSSysDashboardDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysPortletDTO;
import net.ibizsys.modelapi.dto.PSSysResourceDTO;
import net.ibizsys.modelapi.dto.PSSysUniResDTO;
import net.ibizsys.modelapi.service.IPSSysDBPartService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysDBPartServiceImpl
extends PSModelServiceImplBase<PSSysDBPart, PSSysDBPartDTO>
implements IPSSysDBPartService {
    private static final Log log = LogFactory.getLog(PSSysDBPartServiceImpl.class);

    @Override
    public List<PSSysDBPart> listByPSSysDBPart(PSSysDBPart parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysDBPart get(PSSysDBPart parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysDBPart> list = this.listByPSSysDBPart(parent);
        if (list != null) {
            for (PSSysDBPart item : list) {
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
    public List<PSSysDBPartDTO> listDTOByPSSysDBPart(String strParentKey) throws Exception {
        PSSysDBPart pssysdbpart = (PSSysDBPart)PSModelServiceUtil.getInstance().getPSSysDBPartService().get(strParentKey);
        List<PSSysDBPart> list = this.listByPSSysDBPart(pssysdbpart);
        if (list != null) {
            ArrayList<PSSysDBPartDTO> dtoList = new ArrayList<PSSysDBPartDTO>();
            for (PSSysDBPart item : list) {
                PSSysDBPartDTO dto = (PSSysDBPartDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysDBPart> listByPSSysDashboard(PSSysDashboard parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysDBPart get(PSSysDashboard parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysDBPart> list = this.listByPSSysDashboard(parent);
        if (list != null) {
            for (PSSysDBPart item : list) {
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
    public List<PSSysDBPartDTO> listDTOByPSSysDashboard(String strParentKey) throws Exception {
        PSSysDashboard pssysdashboard = (PSSysDashboard)PSModelServiceUtil.getInstance().getPSSysDashboardService().get(strParentKey);
        List<PSSysDBPart> list = this.listByPSSysDashboard(pssysdashboard);
        if (list != null) {
            ArrayList<PSSysDBPartDTO> dtoList = new ArrayList<PSSysDBPartDTO>();
            for (PSSysDBPart item : list) {
                PSSysDBPartDTO dto = (PSSysDBPartDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysDBPart> onListAll() throws Exception {
        ArrayList<PSSysDBPart> list = new ArrayList<PSSysDBPart>();
        List pssysdashboards = PSModelServiceUtil.getInstance().getPSSysDashboardService().listAll();
        if (pssysdashboards != null) {
            for (PSSysDashboard parent : pssysdashboards) {
                List<PSSysDBPart> items = this.listByPSSysDashboard(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSSysDBPart> alllist = new ArrayList<PSSysDBPart>();
        alllist.addAll(list);
        for (PSSysDBPart item : list) {
            List<PSSysDBPart> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysDBPart> listAllChild(PSSysDBPart parent) throws Exception {
        List<PSSysDBPart> list = this.listByPSSysDBPart(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSSysDBPart> alllist = new ArrayList<PSSysDBPart>();
        alllist.addAll(list);
        for (PSSysDBPart item : list) {
            List<PSSysDBPart> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysDBPart> listAllByPSSysDashboard(PSSysDashboard parent) throws Exception {
        List<PSSysDBPart> list = this.listByPSSysDashboard(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSSysDBPart> alllist = new ArrayList<PSSysDBPart>();
        alllist.addAll(list);
        for (PSSysDBPart item : list) {
            List<PSSysDBPart> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysDBPartDTO> listAllDTOByPSSysDashboard(String strParentKey) throws Exception {
        PSSysDashboard pssysdashboard = (PSSysDashboard)PSModelServiceUtil.getInstance().getPSSysDashboardService().get(strParentKey);
        List<PSSysDBPart> list = this.listAllByPSSysDashboard(pssysdashboard);
        if (list != null) {
            ArrayList<PSSysDBPartDTO> dtoList = new ArrayList<PSSysDBPartDTO>();
            for (PSSysDBPart item : list) {
                PSSysDBPartDTO dto = (PSSysDBPartDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSSysDBPart onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysDBPart item;
        PSSysDBPart item2;
        PSSysDBPart pssysdbpart = (PSSysDBPart)PSModelServiceUtil.getInstance().getPSSysDBPartService().get(strParentKey, true);
        if (pssysdbpart != null && (item2 = this.get(pssysdbpart, strCurKey, true)) != null) {
            return item2;
        }
        PSSysDashboard pssysdashboard = (PSSysDashboard)PSModelServiceUtil.getInstance().getPSSysDashboardService().get(strParentKey, true);
        if (pssysdashboard != null && (item = this.get(pssysdashboard, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysDBPart)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysDBPartDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSSysDBPartId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysDBPartService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSysDashboardId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysDashboardService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysDBPart et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysDBPartName())) {
            return et.getPSSysDBPartName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysDBPartDTO dto, PSSysDBPart t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysDBPartId(t.getId().replace("/", "."));
        }
        if (t.getBL_Pos() != null || !bIgnoreNull) {
            dto.setBL_Pos(t.getBL_Pos());
        }
        if (t.getColId() != null || !bIgnoreNull) {
            dto.setColId(t.getColId());
        }
        if (t.getColSpan() != null || !bIgnoreNull) {
            dto.setColSpan(t.getColSpan());
        }
        if (t.getCol_LG() != null || !bIgnoreNull) {
            dto.setCol_LG(t.getCol_LG());
        }
        if (t.getCol_LG_OS() != null || !bIgnoreNull) {
            dto.setCol_LG_OS(t.getCol_LG_OS());
        }
        if (t.getCol_MD() != null || !bIgnoreNull) {
            dto.setCol_MD(t.getCol_MD());
        }
        if (t.getCol_MD_OS() != null || !bIgnoreNull) {
            dto.setCol_MD_OS(t.getCol_MD_OS());
        }
        if (t.getCol_SM() != null || !bIgnoreNull) {
            dto.setCol_SM(t.getCol_SM());
        }
        if (t.getCol_SM_OS() != null || !bIgnoreNull) {
            dto.setCol_SM_OS(t.getCol_SM_OS());
        }
        if (t.getCol_XS() != null || !bIgnoreNull) {
            dto.setCol_XS(t.getCol_XS());
        }
        if (t.getCol_XS_OS() != null || !bIgnoreNull) {
            dto.setCol_XS_OS(t.getCol_XS_OS());
        }
        if (t.getContentType() != null || !bIgnoreNull) {
            dto.setContentType(t.getContentType());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDBPartType() != null || !bIgnoreNull) {
            dto.setDBPartType(t.getDBPartType());
        }
        if (t.getDynaClass() != null || !bIgnoreNull) {
            dto.setDynaClass(t.getDynaClass());
        }
        if (t.getFlexAlign() != null || !bIgnoreNull) {
            dto.setFlexAlign(t.getFlexAlign());
        }
        if (t.getFlexDir() != null || !bIgnoreNull) {
            dto.setFlexDir(t.getFlexDir());
        }
        if (t.getFlexGrow() != null || !bIgnoreNull) {
            dto.setFlexGrow(t.getFlexGrow());
        }
        if (t.getFlexVAlign() != null || !bIgnoreNull) {
            dto.setFlexVAlign(t.getFlexVAlign());
        }
        if (t.getHeight() != null || !bIgnoreNull) {
            dto.setHeight(t.getHeight());
        }
        if (t.getHtmlContent() != null || !bIgnoreNull) {
            dto.setHtmlContent(t.getHtmlContent());
        }
        if (t.getLayoutMode() != null || !bIgnoreNull) {
            dto.setLayoutMode(t.getLayoutMode());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getNewRowMode() != null || !bIgnoreNull) {
            dto.setNewRowMode(t.getNewRowMode());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPartParams() != null || !bIgnoreNull) {
            dto.setPartParams(t.getPartParams());
        }
        if (t.getPartStyle() != null || !bIgnoreNull) {
            dto.setPartStyle(t.getPartStyle());
        }
        if (t.getPortletType() != null || !bIgnoreNull) {
            dto.setPortletType(t.getPortletType());
        }
        if (t.getPosInfo() != null || !bIgnoreNull) {
            dto.setPosInfo(t.getPosInfo());
        }
        if (t.getPPSSysDBPartId() != null || !bIgnoreNull) {
            dto.setPPSSysDBPartId(t.getPPSSysDBPartId());
        }
        if (t.getPPSSysDBPartName() != null || !bIgnoreNull) {
            dto.setPPSSysDBPartName(t.getPPSSysDBPartName());
        }
        if (t.getPSSysCssId() != null || !bIgnoreNull) {
            dto.setPSSysCssId(t.getPSSysCssId());
        }
        if (t.getPSSysCssName() != null || !bIgnoreNull) {
            dto.setPSSysCssName(t.getPSSysCssName());
        }
        if (t.getPSSysDashboardId() != null || !bIgnoreNull) {
            dto.setPSSysDashboardId(t.getPSSysDashboardId());
        }
        if (t.getPSSysDashboardName() != null || !bIgnoreNull) {
            dto.setPSSysDashboardName(t.getPSSysDashboardName());
        }
        if (t.getPSSysDBPartName() != null || !bIgnoreNull) {
            dto.setPSSysDBPartName(t.getPSSysDBPartName());
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
        if (t.getPSSysPortletId() != null || !bIgnoreNull) {
            dto.setPSSysPortletId(t.getPSSysPortletId());
        }
        if (t.getPSSysPortletName() != null || !bIgnoreNull) {
            dto.setPSSysPortletName(t.getPSSysPortletName());
        }
        if (t.getPSSysResourceId() != null || !bIgnoreNull) {
            dto.setPSSysResourceId(t.getPSSysResourceId());
        }
        if (t.getPSSysResourceName() != null || !bIgnoreNull) {
            dto.setPSSysResourceName(t.getPSSysResourceName());
        }
        if (t.getPSSysUniResId() != null || !bIgnoreNull) {
            dto.setPSSysUniResId(t.getPSSysUniResId());
        }
        if (t.getPSSysUniResName() != null || !bIgnoreNull) {
            dto.setPSSysUniResName(t.getPSSysUniResName());
        }
        if (t.getRawContent() != null || !bIgnoreNull) {
            dto.setRawContent(t.getRawContent());
        }
        if (t.getRawCssStyle() != null || !bIgnoreNull) {
            dto.setRawCssStyle(t.getRawCssStyle());
        }
        if (t.getShowTitleBar() != null || !bIgnoreNull) {
            dto.setShowTitleBar(t.getShowTitleBar());
        }
        if (t.getSwapMode() != null || !bIgnoreNull) {
            dto.setSwapMode(t.getSwapMode());
        }
        if (t.getTitle() != null || !bIgnoreNull) {
            dto.setTitle(t.getTitle());
        }
        if (t.getTitleBarCloseMode() != null || !bIgnoreNull) {
            dto.setTitleBarCloseMode(t.getTitleBarCloseMode());
        }
        if (t.getTitlePSLanResId() != null || !bIgnoreNull) {
            dto.setTitlePSLanResId(t.getTitlePSLanResId());
        }
        if (t.getTitlePSLanResName() != null || !bIgnoreNull) {
            dto.setTitlePSLanResName(t.getTitlePSLanResName());
        }
        if (t.getTooltipInfo() != null || !bIgnoreNull) {
            dto.setTooltipInfo(t.getTooltipInfo());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (StringUtils.hasLength((String)dto.getPPSSysDBPartId())) {
            dto.setPPSSysDBPartId(this.getRealPSModelId(t, dto.getPPSSysDBPartId()).replace("/", "."));
        }
        if ("PSSYSDBPART".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSSysDBPartId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDashboardId())) {
            dto.setPSSysDashboardId(this.getRealPSModelId(t, dto.getPSSysDashboardId()).replace("/", "."));
        }
        if ("PSSYSDASHBOARD".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysDashboardId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPortletId())) {
            dto.setPSSysPortletId(this.getRealPSModelId(t, dto.getPSSysPortletId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysResourceId())) {
            dto.setPSSysResourceId(this.getRealPSModelId(t, dto.getPSSysResourceId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUniResId())) {
            dto.setPSSysUniResId(this.getRealPSModelId(t, dto.getPSSysUniResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTitlePSLanResId())) {
            dto.setTitlePSLanResId(this.getRealPSModelId(t, dto.getTitlePSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSSysDBPartId())) {
            linkDTO = (PSSysDBPartDTO)PSModelServiceUtil.getInstance().getPSSysDBPartService().getDTO(dto.getPPSSysDBPartId());
            dto.setPPSSysDBPartName(((PSSysDBPartDTO)linkDTO).getPSSysDBPartName());
        } else {
            dto.setPPSSysDBPartName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getPSSysCssId());
            dto.setPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDashboardId())) {
            linkDTO = (PSSysDashboardDTO)PSModelServiceUtil.getInstance().getPSSysDashboardService().getDTO(dto.getPSSysDashboardId());
            dto.setPSSysDashboardName(((PSSysDashboardDTO)linkDTO).getPSSysDashboardName());
        } else {
            dto.setPSSysDashboardName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysPortletId())) {
            linkDTO = (PSSysPortletDTO)PSModelServiceUtil.getInstance().getPSSysPortletService().getDTO(dto.getPSSysPortletId());
            dto.setPortletType(((PSSysPortletDTO)linkDTO).getPortletType());
            dto.setPSSysPortletName(((PSSysPortletDTO)linkDTO).getPSSysPortletName());
        } else {
            dto.setPortletType(null);
            dto.setPSSysPortletName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysResourceId())) {
            linkDTO = (PSSysResourceDTO)PSModelServiceUtil.getInstance().getPSSysResourceService().getDTO(dto.getPSSysResourceId());
            dto.setPSSysResourceName(((PSSysResourceDTO)linkDTO).getPSSysResourceName());
        } else {
            dto.setPSSysResourceName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysUniResId())) {
            linkDTO = (PSSysUniResDTO)PSModelServiceUtil.getInstance().getPSSysUniResService().getDTO(dto.getPSSysUniResId());
            dto.setPSSysUniResName(((PSSysUniResDTO)linkDTO).getPSSysUniResName());
        } else {
            dto.setPSSysUniResName(null);
        }
        if (StringUtils.hasLength((String)dto.getTitlePSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getTitlePSLanResId());
            dto.setTitlePSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setTitlePSLanResName(null);
        }
        List<PSSysDBPart> list = PSModelServiceUtil.getInstance().getPSSysDBPartService().listByPSSysDBPart(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSSysDBPartDTO> pssysdbparts = new ArrayList<PSSysDBPartDTO>();
            for (PSSysDBPart item : list) {
                PSSysDBPartDTO dstItem = (PSSysDBPartDTO)PSModelServiceUtil.getInstance().getPSSysDBPartService().toDTO(item);
                pssysdbparts.add(dstItem);
            }
            dto.setPssysdbparts(pssysdbparts);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSDBPART";
    }

    @Override
    public PSSysDBPart createDomain() {
        return new PSSysDBPart();
    }

    @Override
    public PSSysDBPartDTO createDTO() {
        return new PSSysDBPartDTO();
    }
}

