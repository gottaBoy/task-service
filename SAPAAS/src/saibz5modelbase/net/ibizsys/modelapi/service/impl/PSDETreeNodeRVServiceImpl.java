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
import net.ibizsys.modelapi.domain.PSDETreeNodeRV;
import net.ibizsys.modelapi.dto.PSDETreeNodeDTO;
import net.ibizsys.modelapi.dto.PSDETreeNodeRVDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.service.IPSDETreeNodeRVService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDETreeNodeRVServiceImpl
extends PSModelServiceImplBase<PSDETreeNodeRV, PSDETreeNodeRVDTO>
implements IPSDETreeNodeRVService {
    private static final Log log = LogFactory.getLog(PSDETreeNodeRVServiceImpl.class);

    @Override
    public List<PSDETreeNodeRV> listByPSDETreeNode(PSDETreeNode parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDETreeNodeRV get(PSDETreeNode parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDETreeNodeRV> list = this.listByPSDETreeNode(parent);
        if (list != null) {
            for (PSDETreeNodeRV item : list) {
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
    public List<PSDETreeNodeRVDTO> listDTOByPSDETreeNode(String strParentKey) throws Exception {
        PSDETreeNode psdetreenode = (PSDETreeNode)PSModelServiceUtil.getInstance().getPSDETreeNodeService().get(strParentKey);
        List<PSDETreeNodeRV> list = this.listByPSDETreeNode(psdetreenode);
        if (list != null) {
            ArrayList<PSDETreeNodeRVDTO> dtoList = new ArrayList<PSDETreeNodeRVDTO>();
            for (PSDETreeNodeRV item : list) {
                PSDETreeNodeRVDTO dto = (PSDETreeNodeRVDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDETreeNodeRV> onListAll() throws Exception {
        ArrayList<PSDETreeNodeRV> list = new ArrayList<PSDETreeNodeRV>();
        List psdetreenodes = PSModelServiceUtil.getInstance().getPSDETreeNodeService().listAll();
        if (psdetreenodes != null) {
            for (PSDETreeNode parent : psdetreenodes) {
                List<PSDETreeNodeRV> items = this.listByPSDETreeNode(parent);
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
    protected PSDETreeNodeRV onGet(String strParentKey, String strCurKey) throws Exception {
        PSDETreeNodeRV item;
        PSDETreeNode psdetreenode = (PSDETreeNode)PSModelServiceUtil.getInstance().getPSDETreeNodeService().get(strParentKey, true);
        if (psdetreenode != null && (item = this.get(psdetreenode, strCurKey, true)) != null) {
            return item;
        }
        return (PSDETreeNodeRV)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDETreeNodeRVDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDETreeNodeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDETreeNodeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDETreeNodeRV et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDETreeNodeRVName())) {
            return et.getPSDETreeNodeRVName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDETreeNodeRVDTO dto, PSDETreeNodeRV t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDETreeNodeRVId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDETreeNodeId() != null || !bIgnoreNull) {
            dto.setPSDETreeNodeId(t.getPSDETreeNodeId());
        }
        if (t.getPSDETreeNodeName() != null || !bIgnoreNull) {
            dto.setPSDETreeNodeName(t.getPSDETreeNodeName());
        }
        if (t.getPSDETreeNodeRVName() != null || !bIgnoreNull) {
            dto.setPSDETreeNodeRVName(t.getPSDETreeNodeRVName());
        }
        if (t.getPSDEViewBaseId() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseId(t.getPSDEViewBaseId());
        }
        if (t.getPSDEViewBaseName() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseName(t.getPSDEViewBaseName());
        }
        if (t.getRefMode() != null || !bIgnoreNull) {
            dto.setRefMode(t.getRefMode());
        }
        if (t.getRefModeText() != null || !bIgnoreNull) {
            dto.setRefModeText(t.getRefModeText());
        }
        if (t.getRefParam() != null || !bIgnoreNull) {
            dto.setRefParam(t.getRefParam());
        }
        if (t.getRefParamDesc() != null || !bIgnoreNull) {
            dto.setRefParamDesc(t.getRefParamDesc());
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
        if (t.getViewParams() != null || !bIgnoreNull) {
            dto.setViewParams(t.getViewParams());
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeNodeId())) {
            dto.setPSDETreeNodeId(this.getRealPSModelId(t, dto.getPSDETreeNodeId()).replace("/", "."));
        }
        if ("PSDETREENODE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDETreeNodeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            dto.setPSDEViewBaseId(this.getRealPSModelId(t, dto.getPSDEViewBaseId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeNodeId())) {
            linkDTO = (PSDETreeNodeDTO)PSModelServiceUtil.getInstance().getPSDETreeNodeService().getDTO(dto.getPSDETreeNodeId());
            dto.setPSDETreeNodeName(((PSDETreeNodeDTO)linkDTO).getPSDETreeNodeName());
        } else {
            dto.setPSDETreeNodeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPSDEViewBaseId());
            dto.setPSDEViewBaseName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setPSDEViewBaseName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDETREENODERV";
    }

    @Override
    public PSDETreeNodeRV createDomain() {
        return new PSDETreeNodeRV();
    }

    @Override
    public PSDETreeNodeRVDTO createDTO() {
        return new PSDETreeNodeRVDTO();
    }
}

