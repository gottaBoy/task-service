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
import net.ibizsys.modelapi.domain.PSSysUCMap;
import net.ibizsys.modelapi.domain.PSSysUCMapNode;
import net.ibizsys.modelapi.dto.PSSysActorDTO;
import net.ibizsys.modelapi.dto.PSSysUCMapDTO;
import net.ibizsys.modelapi.dto.PSSysUCMapNodeDTO;
import net.ibizsys.modelapi.dto.PSSysUserCaseDTO;
import net.ibizsys.modelapi.service.IPSSysUCMapNodeService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysUCMapNodeServiceImpl
extends PSModelServiceImplBase<PSSysUCMapNode, PSSysUCMapNodeDTO>
implements IPSSysUCMapNodeService {
    private static final Log log = LogFactory.getLog(PSSysUCMapNodeServiceImpl.class);

    @Override
    public List<PSSysUCMapNode> listByPSSysUCMap(PSSysUCMap parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysUCMapNode get(PSSysUCMap parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysUCMapNode> list = this.listByPSSysUCMap(parent);
        if (list != null) {
            for (PSSysUCMapNode item : list) {
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
    public List<PSSysUCMapNodeDTO> listDTOByPSSysUCMap(String strParentKey) throws Exception {
        PSSysUCMap pssysucmap = (PSSysUCMap)PSModelServiceUtil.getInstance().getPSSysUCMapService().get(strParentKey);
        List<PSSysUCMapNode> list = this.listByPSSysUCMap(pssysucmap);
        if (list != null) {
            ArrayList<PSSysUCMapNodeDTO> dtoList = new ArrayList<PSSysUCMapNodeDTO>();
            for (PSSysUCMapNode item : list) {
                PSSysUCMapNodeDTO dto = (PSSysUCMapNodeDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysUCMapNode> onListAll() throws Exception {
        ArrayList<PSSysUCMapNode> list = new ArrayList<PSSysUCMapNode>();
        List<PSSysUCMap> pssysucmaps = PSModelServiceUtil.getInstance().getPSSysUCMapService().listAll();
        if (pssysucmaps != null) {
            for (PSSysUCMap parent : pssysucmaps) {
                List<PSSysUCMapNode> items = this.listByPSSysUCMap(parent);
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
    protected PSSysUCMapNode onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysUCMapNode item;
        PSSysUCMap pssysucmap = (PSSysUCMap)PSModelServiceUtil.getInstance().getPSSysUCMapService().get(strParentKey, true);
        if (pssysucmap != null && (item = this.get(pssysucmap, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysUCMapNode)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysUCMapNodeDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysUCMapId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysUCMapService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysUCMapNode et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysUCMapNodeDTO dto, PSSysUCMapNode t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysUCMapNodeId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getLeftPos() != null || !bIgnoreNull) {
            dto.setLeftPos(t.getLeftPos());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getNodeType() != null || !bIgnoreNull) {
            dto.setNodeType(t.getNodeType());
        }
        if (t.getPSSysActorId() != null || !bIgnoreNull) {
            dto.setPSSysActorId(t.getPSSysActorId());
        }
        if (t.getPSSysActorName() != null || !bIgnoreNull) {
            dto.setPSSysActorName(t.getPSSysActorName());
        }
        if (t.getPSSysUCMapId() != null || !bIgnoreNull) {
            dto.setPSSysUCMapId(t.getPSSysUCMapId());
        }
        if (t.getPSSysUCMapName() != null || !bIgnoreNull) {
            dto.setPSSysUCMapName(t.getPSSysUCMapName());
        }
        if (t.getPSSysUCMapNodeName() != null || !bIgnoreNull) {
            dto.setPSSysUCMapNodeName(t.getPSSysUCMapNodeName());
        }
        if (t.getPSSysUserCaseId() != null || !bIgnoreNull) {
            dto.setPSSysUserCaseId(t.getPSSysUserCaseId());
        }
        if (t.getPSSysUserCaseName() != null || !bIgnoreNull) {
            dto.setPSSysUserCaseName(t.getPSSysUserCaseName());
        }
        if (t.getTopPos() != null || !bIgnoreNull) {
            dto.setTopPos(t.getTopPos());
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
        if (StringUtils.hasLength((String)dto.getPSSysActorId())) {
            dto.setPSSysActorId(this.getRealPSModelId(t, dto.getPSSysActorId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUCMapId())) {
            dto.setPSSysUCMapId(this.getRealPSModelId(t, dto.getPSSysUCMapId()).replace("/", "."));
        }
        if ("PSSYSUCMAP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysUCMapId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUserCaseId())) {
            dto.setPSSysUserCaseId(this.getRealPSModelId(t, dto.getPSSysUserCaseId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysActorId())) {
            linkDTO = (PSSysActorDTO)PSModelServiceUtil.getInstance().getPSSysActorService().getDTO(dto.getPSSysActorId());
            dto.setPSSysActorName(((PSSysActorDTO)linkDTO).getPSSysActorName());
        } else {
            dto.setPSSysActorName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysUCMapId())) {
            linkDTO = (PSSysUCMapDTO)PSModelServiceUtil.getInstance().getPSSysUCMapService().getDTO(dto.getPSSysUCMapId());
            dto.setPSSysUCMapName(((PSSysUCMapDTO)linkDTO).getPSSysUCMapName());
        } else {
            dto.setPSSysUCMapName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysUserCaseId())) {
            linkDTO = (PSSysUserCaseDTO)PSModelServiceUtil.getInstance().getPSSysUserCaseService().getDTO(dto.getPSSysUserCaseId());
            dto.setPSSysUserCaseName(((PSSysUserCaseDTO)linkDTO).getPSSysUserCaseName());
        } else {
            dto.setPSSysUserCaseName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSUCMAPNODE";
    }

    @Override
    public PSSysUCMapNode createDomain() {
        return new PSSysUCMapNode();
    }

    @Override
    public PSSysUCMapNodeDTO createDTO() {
        return new PSSysUCMapNodeDTO();
    }
}

