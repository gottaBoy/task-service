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
import net.ibizsys.modelapi.domain.PSDETreeNodeRS;
import net.ibizsys.modelapi.domain.PSDETreeView;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDETreeNodeDTO;
import net.ibizsys.modelapi.dto.PSDETreeNodeRSDTO;
import net.ibizsys.modelapi.dto.PSDETreeViewDTO;
import net.ibizsys.modelapi.service.IPSDETreeNodeRSService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDETreeNodeRSServiceImpl
extends PSModelServiceImplBase<PSDETreeNodeRS, PSDETreeNodeRSDTO>
implements IPSDETreeNodeRSService {
    private static final Log log = LogFactory.getLog(PSDETreeNodeRSServiceImpl.class);

    @Override
    public List<PSDETreeNodeRS> listByPSDETreeView(PSDETreeView parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDETreeNodeRS get(PSDETreeView parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDETreeNodeRS> list = this.listByPSDETreeView(parent);
        if (list != null) {
            for (PSDETreeNodeRS item : list) {
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
    public List<PSDETreeNodeRSDTO> listDTOByPSDETreeView(String strParentKey) throws Exception {
        PSDETreeView psdetreeview = (PSDETreeView)PSModelServiceUtil.getInstance().getPSDETreeViewService().get(strParentKey);
        List<PSDETreeNodeRS> list = this.listByPSDETreeView(psdetreeview);
        if (list != null) {
            ArrayList<PSDETreeNodeRSDTO> dtoList = new ArrayList<PSDETreeNodeRSDTO>();
            for (PSDETreeNodeRS item : list) {
                PSDETreeNodeRSDTO dto = (PSDETreeNodeRSDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDETreeNodeRS> onListAll() throws Exception {
        ArrayList<PSDETreeNodeRS> list = new ArrayList<PSDETreeNodeRS>();
        List psdetreeviews = PSModelServiceUtil.getInstance().getPSDETreeViewService().listAll();
        if (psdetreeviews != null) {
            for (PSDETreeView parent : psdetreeviews) {
                List<PSDETreeNodeRS> items = this.listByPSDETreeView(parent);
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
    protected PSDETreeNodeRS onGet(String strParentKey, String strCurKey) throws Exception {
        PSDETreeNodeRS item;
        PSDETreeView psdetreeview = (PSDETreeView)PSModelServiceUtil.getInstance().getPSDETreeViewService().get(strParentKey, true);
        if (psdetreeview != null && (item = this.get(psdetreeview, strCurKey, true)) != null) {
            return item;
        }
        return (PSDETreeNodeRS)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDETreeNodeRSDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDETreeViewId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDETreeViewService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDETreeNodeRS et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDETreeNodeRSDTO dto, PSDETreeNodeRS t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDETreeNodeRSId(t.getId().replace("/", "."));
        }
        if (t.getChildFilter() != null || !bIgnoreNull) {
            dto.setChildFilter(t.getChildFilter());
        }
        if (t.getChildFilterDesc() != null || !bIgnoreNull) {
            dto.setChildFilterDesc(t.getChildFilterDesc());
        }
        if (t.getCMCreate() != null || !bIgnoreNull) {
            dto.setCMCreate(t.getCMCreate());
        }
        if (t.getCPSDETreeNodeId() != null || !bIgnoreNull) {
            dto.setCPSDETreeNodeId(t.getCPSDETreeNodeId());
        }
        if (t.getCPSDETreeNodeName() != null || !bIgnoreNull) {
            dto.setCPSDETreeNodeName(t.getCPSDETreeNodeName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
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
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPPSDETreeNodeId() != null || !bIgnoreNull) {
            dto.setPPSDETreeNodeId(t.getPPSDETreeNodeId());
        }
        if (t.getPPSDETreeNodeName() != null || !bIgnoreNull) {
            dto.setPPSDETreeNodeName(t.getPPSDETreeNodeName());
        }
        if (t.getProcessParam() != null || !bIgnoreNull) {
            dto.setProcessParam(t.getProcessParam());
        }
        if (t.getPSDEActionId() != null || !bIgnoreNull) {
            dto.setPSDEActionId(t.getPSDEActionId());
        }
        if (t.getPSDEActionName() != null || !bIgnoreNull) {
            dto.setPSDEActionName(t.getPSDEActionName());
        }
        if (t.getPSDERId() != null || !bIgnoreNull) {
            dto.setPSDERId(t.getPSDERId());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
        }
        if (t.getPSDETreeNodeRSName() != null || !bIgnoreNull) {
            dto.setPSDETreeNodeRSName(t.getPSDETreeNodeRSName());
        }
        if (t.getPSDETreeViewId() != null || !bIgnoreNull) {
            dto.setPSDETreeViewId(t.getPSDETreeViewId());
        }
        if (t.getPSDETreeViewName() != null || !bIgnoreNull) {
            dto.setPSDETreeViewName(t.getPSDETreeViewName());
        }
        if (t.getPValueLevel() != null || !bIgnoreNull) {
            dto.setPValueLevel(t.getPValueLevel());
        }
        if (t.getSearchMode() != null || !bIgnoreNull) {
            dto.setSearchMode(t.getSearchMode());
        }
        if (t.getTypeFilter() != null || !bIgnoreNull) {
            dto.setTypeFilter(t.getTypeFilter());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
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
        if (t.getUserTag3() != null || !bIgnoreNull) {
            dto.setUserTag3(t.getUserTag3());
        }
        if (t.getUserTag4() != null || !bIgnoreNull) {
            dto.setUserTag4(t.getUserTag4());
        }
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (StringUtils.hasLength((String)dto.getCPSDETreeNodeId())) {
            dto.setCPSDETreeNodeId(this.getRealPSModelId(t, dto.getCPSDETreeNodeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSDETreeNodeId())) {
            dto.setPPSDETreeNodeId(this.getRealPSModelId(t, dto.getPPSDETreeNodeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeViewId())) {
            dto.setPSDETreeViewId(this.getRealPSModelId(t, dto.getPSDETreeViewId()).replace("/", "."));
        }
        if ("PSDETREEVIEW".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDETreeViewId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCPSDETreeNodeId())) {
            linkDTO = (PSDETreeNodeDTO)PSModelServiceUtil.getInstance().getPSDETreeNodeService().getDTO(dto.getCPSDETreeNodeId());
            dto.setCPSDETreeNodeName(((PSDETreeNodeDTO)linkDTO).getPSDETreeNodeName());
        } else {
            dto.setCPSDETreeNodeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSDETreeNodeId())) {
            linkDTO = (PSDETreeNodeDTO)PSModelServiceUtil.getInstance().getPSDETreeNodeService().getDTO(dto.getPPSDETreeNodeId());
            dto.setPPSDETreeNodeName(((PSDETreeNodeDTO)linkDTO).getPSDETreeNodeName());
        } else {
            dto.setPPSDETreeNodeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPSDEActionId());
            dto.setPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeViewId())) {
            linkDTO = (PSDETreeViewDTO)PSModelServiceUtil.getInstance().getPSDETreeViewService().getDTO(dto.getPSDETreeViewId());
            dto.setPSDETreeViewName(((PSDETreeViewDTO)linkDTO).getPSDETreeViewName());
        } else {
            dto.setPSDETreeViewName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDETREENODERS";
    }

    @Override
    public PSDETreeNodeRS createDomain() {
        return new PSDETreeNodeRS();
    }

    @Override
    public PSDETreeNodeRSDTO createDTO() {
        return new PSDETreeNodeRSDTO();
    }
}

