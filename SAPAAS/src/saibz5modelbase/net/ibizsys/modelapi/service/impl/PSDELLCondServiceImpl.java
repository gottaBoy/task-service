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
import net.ibizsys.modelapi.domain.PSDELogicLink;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDELLCondDTO;
import net.ibizsys.modelapi.dto.PSDELogicLinkDTO;
import net.ibizsys.modelapi.dto.PSDELogicParamDTO;
import net.ibizsys.modelapi.service.IPSDELLCondService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDELLCondServiceImpl
extends PSModelServiceImplBase<PSDELLCond, PSDELLCondDTO>
implements IPSDELLCondService {
    private static final Log log = LogFactory.getLog(PSDELLCondServiceImpl.class);

    @Override
    public List<PSDELLCond> listByPSDELLCond(PSDELLCond parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDELLCond get(PSDELLCond parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDELLCond> list = this.listByPSDELLCond(parent);
        if (list != null) {
            for (PSDELLCond item : list) {
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
    public List<PSDELLCondDTO> listDTOByPSDELLCond(String strParentKey) throws Exception {
        PSDELLCond psdellcond = (PSDELLCond)PSModelServiceUtil.getInstance().getPSDELLCondService().get(strParentKey);
        List<PSDELLCond> list = this.listByPSDELLCond(psdellcond);
        if (list != null) {
            ArrayList<PSDELLCondDTO> dtoList = new ArrayList<PSDELLCondDTO>();
            for (PSDELLCond item : list) {
                PSDELLCondDTO dto = (PSDELLCondDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDELLCond> listByPSDELogicLink(PSDELogicLink parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDELLCond get(PSDELogicLink parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDELLCond> list = this.listByPSDELogicLink(parent);
        if (list != null) {
            for (PSDELLCond item : list) {
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
    public List<PSDELLCondDTO> listDTOByPSDELogicLink(String strParentKey) throws Exception {
        PSDELogicLink psdelogiclink = (PSDELogicLink)PSModelServiceUtil.getInstance().getPSDELogicLinkService().get(strParentKey);
        List<PSDELLCond> list = this.listByPSDELogicLink(psdelogiclink);
        if (list != null) {
            ArrayList<PSDELLCondDTO> dtoList = new ArrayList<PSDELLCondDTO>();
            for (PSDELLCond item : list) {
                PSDELLCondDTO dto = (PSDELLCondDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDELLCond> onListAll() throws Exception {
        ArrayList<PSDELLCond> list = new ArrayList<PSDELLCond>();
        List psdelogiclinks = PSModelServiceUtil.getInstance().getPSDELogicLinkService().listAll();
        if (psdelogiclinks != null) {
            for (PSDELogicLink parent : psdelogiclinks) {
                List<PSDELLCond> items = this.listByPSDELogicLink(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSDELLCond> alllist = new ArrayList<PSDELLCond>();
        alllist.addAll(list);
        for (PSDELLCond item : list) {
            List<PSDELLCond> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDELLCond> listAllChild(PSDELLCond parent) throws Exception {
        List<PSDELLCond> list = this.listByPSDELLCond(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDELLCond> alllist = new ArrayList<PSDELLCond>();
        alllist.addAll(list);
        for (PSDELLCond item : list) {
            List<PSDELLCond> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDELLCond> listAllByPSDELogicLink(PSDELogicLink parent) throws Exception {
        List<PSDELLCond> list = this.listByPSDELogicLink(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDELLCond> alllist = new ArrayList<PSDELLCond>();
        alllist.addAll(list);
        for (PSDELLCond item : list) {
            List<PSDELLCond> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDELLCondDTO> listAllDTOByPSDELogicLink(String strParentKey) throws Exception {
        PSDELogicLink psdelogiclink = (PSDELogicLink)PSModelServiceUtil.getInstance().getPSDELogicLinkService().get(strParentKey);
        List<PSDELLCond> list = this.listAllByPSDELogicLink(psdelogiclink);
        if (list != null) {
            ArrayList<PSDELLCondDTO> dtoList = new ArrayList<PSDELLCondDTO>();
            for (PSDELLCond item : list) {
                PSDELLCondDTO dto = (PSDELLCondDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSDELLCond onGet(String strParentKey, String strCurKey) throws Exception {
        PSDELLCond item;
        PSDELLCond item2;
        PSDELLCond psdellcond = (PSDELLCond)PSModelServiceUtil.getInstance().getPSDELLCondService().get(strParentKey, true);
        if (psdellcond != null && (item2 = this.get(psdellcond, strCurKey, true)) != null) {
            return item2;
        }
        PSDELogicLink psdelogiclink = (PSDELogicLink)PSModelServiceUtil.getInstance().getPSDELogicLinkService().get(strParentKey, true);
        if (psdelogiclink != null && (item = this.get(psdelogiclink, strCurKey, true)) != null) {
            return item;
        }
        return (PSDELLCond)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDELLCondDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSDELLCondId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDELLCondService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDELogicLinkId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDELogicLinkService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDELLCond et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDELLCondDTO dto, PSDELLCond t, boolean bIgnoreNull) throws Exception {
        List<PSDELLCond> list;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDELLCondId(t.getId().replace("/", "."));
        }
        if (t.getCondValue() != null || !bIgnoreNull) {
            dto.setCondValue(t.getCondValue());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomDSTParam() != null || !bIgnoreNull) {
            dto.setCustomDSTParam(t.getCustomDSTParam());
        }
        if (t.getDstParamPSDEId() != null || !bIgnoreNull) {
            dto.setDstParamPSDEId(t.getDstParamPSDEId());
        }
        if (t.getDstPSDEFId() != null || !bIgnoreNull) {
            dto.setDstPSDEFId(t.getDstPSDEFId());
        }
        if (t.getDstPSDEFName() != null || !bIgnoreNull) {
            dto.setDstPSDEFName(t.getDstPSDEFName());
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
        if (t.getGroupNotFlag() != null || !bIgnoreNull) {
            dto.setGroupNotFlag(t.getGroupNotFlag());
        }
        if (t.getGroupOP() != null || !bIgnoreNull) {
            dto.setGroupOP(t.getGroupOP());
        }
        if (t.getLogicType() != null || !bIgnoreNull) {
            dto.setLogicType(t.getLogicType());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getParamType() != null || !bIgnoreNull) {
            dto.setParamType(t.getParamType());
        }
        if (t.getPPSDELLCondId() != null || !bIgnoreNull) {
            dto.setPPSDELLCondId(t.getPPSDELLCondId());
        }
        if (t.getPPSDELLCondName() != null || !bIgnoreNull) {
            dto.setPPSDELLCondName(t.getPPSDELLCondName());
        }
        if (t.getPSDBValueOPId() != null || !bIgnoreNull) {
            dto.setPSDBValueOPId(t.getPSDBValueOPId());
        }
        if (t.getPSDBValueOPName() != null || !bIgnoreNull) {
            dto.setPSDBValueOPName(t.getPSDBValueOPName());
        }
        if (t.getPSDELLCondName() != null || !bIgnoreNull) {
            dto.setPSDELLCondName(t.getPSDELLCondName());
        }
        if (t.getPSDElogicId() != null || !bIgnoreNull) {
            dto.setPSDElogicId(t.getPSDElogicId());
        }
        if (t.getPSDELogicLinkId() != null || !bIgnoreNull) {
            dto.setPSDELogicLinkId(t.getPSDELogicLinkId());
        }
        if (t.getPSDELogicLinkName() != null || !bIgnoreNull) {
            dto.setPSDELogicLinkName(t.getPSDELogicLinkName());
        }
        if (t.getSrcPSDLParamId() != null || !bIgnoreNull) {
            dto.setSrcPSDLParamId(t.getSrcPSDLParamId());
        }
        if (t.getSrcPSDLParamName() != null || !bIgnoreNull) {
            dto.setSrcPSDLParamName(t.getSrcPSDLParamName());
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
        if (StringUtils.hasLength((String)dto.getDstPSDEFId())) {
            dto.setDstPSDEFId(this.getRealPSModelId(t, dto.getDstPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDLParamId())) {
            dto.setDstPSDLParamId(this.getRealPSModelId(t, dto.getDstPSDLParamId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSDELLCondId())) {
            dto.setPPSDELLCondId(this.getRealPSModelId(t, dto.getPPSDELLCondId()).replace("/", "."));
        }
        if ("PSDELLCOND".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSDELLCondId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicLinkId())) {
            dto.setPSDELogicLinkId(this.getRealPSModelId(t, dto.getPSDELogicLinkId()).replace("/", "."));
        }
        if ("PSDELOGICLINK".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDELogicLinkId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSrcPSDLParamId())) {
            dto.setSrcPSDLParamId(this.getRealPSModelId(t, dto.getSrcPSDLParamId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getDstPSDEFId());
            dto.setDstPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setDstPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDLParamId())) {
            linkDTO = (PSDELogicParamDTO)PSModelServiceUtil.getInstance().getPSDELogicParamService().getDTO(dto.getDstPSDLParamId(), true);
            if (linkDTO != null) {
                dto.setDstParamPSDEId(((PSDELogicParamDTO)linkDTO).getParamPSDEId());
                dto.setDstPSDLParamName(((PSDELogicParamDTO)linkDTO).getPSDELogicParamName());
            }
        } else {
            dto.setDstParamPSDEId(null);
            dto.setDstPSDLParamName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSDELLCondId())) {
            linkDTO = (PSDELLCondDTO)PSModelServiceUtil.getInstance().getPSDELLCondService().getDTO(dto.getPPSDELLCondId(), true);
            if (linkDTO != null) {
                dto.setPPSDELLCondName(((PSDELLCondDTO)linkDTO).getPSDELLCondName());
            }
        } else {
            dto.setPPSDELLCondName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicLinkId())) {
            linkDTO = (PSDELogicLinkDTO)PSModelServiceUtil.getInstance().getPSDELogicLinkService().getDTO(dto.getPSDELogicLinkId(), true);
            if (linkDTO != null) {
                dto.setPSDElogicId(((PSDELogicLinkDTO)linkDTO).getPSDELogicId());
                dto.setPSDELogicLinkName(((PSDELogicLinkDTO)linkDTO).getPSDELogicLinkName());
            }
        } else {
            dto.setPSDElogicId(null);
            dto.setPSDELogicLinkName(null);
        }
        if (StringUtils.hasLength((String)dto.getSrcPSDLParamId())) {
            linkDTO = (PSDELogicParamDTO)PSModelServiceUtil.getInstance().getPSDELogicParamService().getDTO(dto.getSrcPSDLParamId(), true);
            if (linkDTO != null) {
                dto.setSrcPSDLParamName(((PSDELogicParamDTO)linkDTO).getPSDELogicParamName());
            }
        } else {
            dto.setSrcPSDLParamName(null);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDELLCondService().listByPSDELLCond(t)) != null && list.size() > 0) {
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
        return "PSDELLCOND";
    }

    @Override
    public PSDELLCond createDomain() {
        return new PSDELLCond();
    }

    @Override
    public PSDELLCondDTO createDTO() {
        return new PSDELLCondDTO();
    }
}

