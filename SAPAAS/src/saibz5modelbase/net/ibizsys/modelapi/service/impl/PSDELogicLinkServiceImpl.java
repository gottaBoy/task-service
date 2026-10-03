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
import net.ibizsys.modelapi.domain.PSDELLCond;
import net.ibizsys.modelapi.domain.PSDELogic;
import net.ibizsys.modelapi.domain.PSDELogicLink;
import net.ibizsys.modelapi.dto.PSDELLCondDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDELogicLinkDTO;
import net.ibizsys.modelapi.dto.PSDELogicNodeDTO;
import net.ibizsys.modelapi.dto.PSDELogicParamDTO;
import net.ibizsys.modelapi.service.IPSDELogicLinkService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDELogicLinkServiceImpl
extends PSModelServiceImplBase<PSDELogicLink, PSDELogicLinkDTO>
implements IPSDELogicLinkService {
    private static final Log log = LogFactory.getLog(PSDELogicLinkServiceImpl.class);

    @Override
    public List<PSDELogicLink> listByPSDELogic(PSDELogic parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDELogicLink get(PSDELogic parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDELogicLink> list = this.listByPSDELogic(parent);
        if (list != null) {
            for (PSDELogicLink item : list) {
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
    public List<PSDELogicLinkDTO> listDTOByPSDELogic(String strParentKey) throws Exception {
        PSDELogic psdelogic = (PSDELogic)PSModelServiceUtil.getInstance().getPSDELogicService().get(strParentKey);
        List<PSDELogicLink> list = this.listByPSDELogic(psdelogic);
        if (list != null) {
            ArrayList<PSDELogicLinkDTO> dtoList = new ArrayList<PSDELogicLinkDTO>();
            for (PSDELogicLink item : list) {
                PSDELogicLinkDTO dto = (PSDELogicLinkDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDELogicLink> onListAll() throws Exception {
        ArrayList<PSDELogicLink> list = new ArrayList<PSDELogicLink>();
        List<PSDELogic> psdelogics = PSModelServiceUtil.getInstance().getPSDELogicService().listAll();
        if (psdelogics != null) {
            for (PSDELogic parent : psdelogics) {
                List<PSDELogicLink> items = this.listByPSDELogic(parent);
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
    protected PSDELogicLink onGet(String strParentKey, String strCurKey) throws Exception {
        PSDELogicLink item;
        PSDELogic psdelogic = (PSDELogic)PSModelServiceUtil.getInstance().getPSDELogicService().get(strParentKey, true);
        if (psdelogic != null && (item = this.get(psdelogic, strCurKey, true)) != null) {
            return item;
        }
        return (PSDELogicLink)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDELogicLinkDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDELogicId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDELogicService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDELogicLink et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDELogicLinkDTO dto, PSDELogicLink t, boolean bIgnoreNull) throws Exception {
        List<PSDELLCond> list;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDELogicLinkId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDebugMode() != null || !bIgnoreNull) {
            dto.setDebugMode(t.getDebugMode());
        }
        if (t.getDefaultLink() != null || !bIgnoreNull) {
            dto.setDefaultLink(t.getDefaultLink());
        }
        if (t.getDstEndPoint() != null || !bIgnoreNull) {
            dto.setDstEndPoint(t.getDstEndPoint());
        }
        if (t.getDstPSDELogicNodeId() != null || !bIgnoreNull) {
            dto.setDstPSDELogicNodeId(t.getDstPSDELogicNodeId());
        }
        if (t.getDstPSDELogicNodeName() != null || !bIgnoreNull) {
            dto.setDstPSDELogicNodeName(t.getDstPSDELogicNodeName());
        }
        if (t.getDstPSDLParamId() != null || !bIgnoreNull) {
            dto.setDstPSDLParamId(t.getDstPSDLParamId());
        }
        if (t.getDstPSDLParamName() != null || !bIgnoreNull) {
            dto.setDstPSDLParamName(t.getDstPSDLParamName());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getLinkCond() != null || !bIgnoreNull) {
            dto.setLinkCond(t.getLinkCond());
        }
        if (t.getLinkCond2() != null || !bIgnoreNull) {
            dto.setLinkCond2(t.getLinkCond2());
        }
        if (t.getLinkInfo() != null || !bIgnoreNull) {
            dto.setLinkInfo(t.getLinkInfo());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDELogicId() != null || !bIgnoreNull) {
            dto.setPSDELogicId(t.getPSDELogicId());
        }
        if (t.getPSDELogicLinkName() != null || !bIgnoreNull) {
            dto.setPSDELogicLinkName(t.getPSDELogicLinkName());
        }
        if (t.getPSDELogicName() != null || !bIgnoreNull) {
            dto.setPSDELogicName(t.getPSDELogicName());
        }
        if (t.getShapeParams() != null || !bIgnoreNull) {
            dto.setShapeParams(t.getShapeParams());
        }
        if (t.getSrcEndPoint() != null || !bIgnoreNull) {
            dto.setSrcEndPoint(t.getSrcEndPoint());
        }
        if (t.getSrcPSDELogicNodeId() != null || !bIgnoreNull) {
            dto.setSrcPSDELogicNodeId(t.getSrcPSDELogicNodeId());
        }
        if (t.getSrcPSDELogicNodeName() != null || !bIgnoreNull) {
            dto.setSrcPSDELogicNodeName(t.getSrcPSDELogicNodeName());
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
        if (StringUtils.hasLength((String)dto.getDstPSDELogicNodeId())) {
            dto.setDstPSDELogicNodeId(this.getRealPSModelId(t, dto.getDstPSDELogicNodeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDLParamId())) {
            dto.setDstPSDLParamId(this.getRealPSModelId(t, dto.getDstPSDLParamId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            dto.setPSDELogicId(this.getRealPSModelId(t, dto.getPSDELogicId()).replace("/", "."));
        }
        if ("PSDELOGIC".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDELogicId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSrcPSDELogicNodeId())) {
            dto.setSrcPSDELogicNodeId(this.getRealPSModelId(t, dto.getSrcPSDELogicNodeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDELogicNodeId())) {
            linkDTO = (PSDELogicNodeDTO)PSModelServiceUtil.getInstance().getPSDELogicNodeService().getDTO(dto.getDstPSDELogicNodeId(), true);
            if (linkDTO != null) {
                dto.setDstPSDELogicNodeName(((PSDELogicNodeDTO)linkDTO).getPSDELogicNodeName());
            }
        } else {
            dto.setDstPSDELogicNodeName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDLParamId())) {
            linkDTO = (PSDELogicParamDTO)PSModelServiceUtil.getInstance().getPSDELogicParamService().getDTO(dto.getDstPSDLParamId(), true);
            if (linkDTO != null) {
                dto.setDstPSDLParamName(((PSDELogicParamDTO)linkDTO).getPSDELogicParamName());
            }
        } else {
            dto.setDstPSDLParamName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getPSDELogicId(), true);
            if (linkDTO != null) {
                dto.setPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
            }
        } else {
            dto.setPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getSrcPSDELogicNodeId())) {
            linkDTO = (PSDELogicNodeDTO)PSModelServiceUtil.getInstance().getPSDELogicNodeService().getDTO(dto.getSrcPSDELogicNodeId(), true);
            if (linkDTO != null) {
                dto.setSrcPSDELogicNodeName(((PSDELogicNodeDTO)linkDTO).getPSDELogicNodeName());
            }
        } else {
            dto.setSrcPSDELogicNodeName(null);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDELLCondService().listByPSDELogicLink(t)) != null && list.size() > 0) {
            ArrayList<PSDELLCondDTO> psdellconds = new ArrayList<PSDELLCondDTO>();
            for (PSDELLCond item : list) {
                PSDELLCondDTO dstItem = (PSDELLCondDTO)PSModelServiceUtil.getInstance().getPSDELLCondService().toDTO(item);
                psdellconds.add(dstItem);
            }
            dto.setPsdellconds(psdellconds);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDELOGICLINK";
    }

    @Override
    public PSDELogicLink createDomain() {
        return new PSDELogicLink();
    }

    @Override
    public PSDELogicLinkDTO createDTO() {
        return new PSDELogicLinkDTO();
    }
}

