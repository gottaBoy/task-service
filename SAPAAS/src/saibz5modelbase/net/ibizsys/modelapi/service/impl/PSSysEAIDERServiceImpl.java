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
import net.ibizsys.modelapi.domain.PSSysEAIDE;
import net.ibizsys.modelapi.domain.PSSysEAIDER;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSSysEAIDEDTO;
import net.ibizsys.modelapi.dto.PSSysEAIDERDTO;
import net.ibizsys.modelapi.dto.PSSysEAIElementREDTO;
import net.ibizsys.modelapi.service.IPSSysEAIDERService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysEAIDERServiceImpl
extends PSModelServiceImplBase<PSSysEAIDER, PSSysEAIDERDTO>
implements IPSSysEAIDERService {
    private static final Log log = LogFactory.getLog(PSSysEAIDERServiceImpl.class);

    @Override
    public List<PSSysEAIDER> listByPSSysEAIDE(PSSysEAIDE parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysEAIDER get(PSSysEAIDE parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysEAIDER> list = this.listByPSSysEAIDE(parent);
        if (list != null) {
            for (PSSysEAIDER item : list) {
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
    public List<PSSysEAIDERDTO> listDTOByPSSysEAIDE(String strParentKey) throws Exception {
        PSSysEAIDE pssyseaide = (PSSysEAIDE)PSModelServiceUtil.getInstance().getPSSysEAIDEService().get(strParentKey);
        List<PSSysEAIDER> list = this.listByPSSysEAIDE(pssyseaide);
        if (list != null) {
            ArrayList<PSSysEAIDERDTO> dtoList = new ArrayList<PSSysEAIDERDTO>();
            for (PSSysEAIDER item : list) {
                PSSysEAIDERDTO dto = (PSSysEAIDERDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysEAIDER> onListAll() throws Exception {
        ArrayList<PSSysEAIDER> list = new ArrayList<PSSysEAIDER>();
        List pssyseaides = PSModelServiceUtil.getInstance().getPSSysEAIDEService().listAll();
        if (pssyseaides != null) {
            for (PSSysEAIDE parent : pssyseaides) {
                List<PSSysEAIDER> items = this.listByPSSysEAIDE(parent);
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
    protected PSSysEAIDER onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysEAIDER item;
        PSSysEAIDE pssyseaide = (PSSysEAIDE)PSModelServiceUtil.getInstance().getPSSysEAIDEService().get(strParentKey, true);
        if (pssyseaide != null && (item = this.get(pssyseaide, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysEAIDER)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysEAIDERDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysEAIDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysEAIDEService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysEAIDER et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysEAIDERName())) {
            return et.getPSSysEAIDERName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysEAIDERDTO dto, PSSysEAIDER t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysEAIDERId(t.getId().replace("/", "."));
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getEAIDERTag() != null || !bIgnoreNull) {
            dto.setEAIDERTag(t.getEAIDERTag());
        }
        if (t.getEAIDERTag2() != null || !bIgnoreNull) {
            dto.setEAIDERTag2(t.getEAIDERTag2());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDERId() != null || !bIgnoreNull) {
            dto.setPSDERId(t.getPSDERId());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
        }
        if (t.getPSSysEAIDEId() != null || !bIgnoreNull) {
            dto.setPSSysEAIDEId(t.getPSSysEAIDEId());
        }
        if (t.getPSSysEAIDEName() != null || !bIgnoreNull) {
            dto.setPSSysEAIDEName(t.getPSSysEAIDEName());
        }
        if (t.getPSSysEAIDERName() != null || !bIgnoreNull) {
            dto.setPSSysEAIDERName(t.getPSSysEAIDERName());
        }
        if (t.getPSSysEAIElementId() != null || !bIgnoreNull) {
            dto.setPSSysEAIElementId(t.getPSSysEAIElementId());
        }
        if (t.getPSSysEAIElementREId() != null || !bIgnoreNull) {
            dto.setPSSysEAIElementREId(t.getPSSysEAIElementREId());
        }
        if (t.getPSSysEAIElementREName() != null || !bIgnoreNull) {
            dto.setPSSysEAIElementREName(t.getPSSysEAIElementREName());
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
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAIDEId())) {
            dto.setPSSysEAIDEId(this.getRealPSModelId(t, dto.getPSSysEAIDEId()).replace("/", "."));
        }
        if ("PSSYSEAIDE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysEAIDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAIElementREId())) {
            dto.setPSSysEAIElementREId(this.getRealPSModelId(t, dto.getPSSysEAIElementREId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAIDEId())) {
            linkDTO = (PSSysEAIDEDTO)PSModelServiceUtil.getInstance().getPSSysEAIDEService().getDTO(dto.getPSSysEAIDEId());
            dto.setPSDEId(((PSSysEAIDEDTO)linkDTO).getPSDEId());
            dto.setPSSysEAIDEName(((PSSysEAIDEDTO)linkDTO).getPSSysEAIDEName());
            dto.setPSSysEAIElementId(((PSSysEAIDEDTO)linkDTO).getPSSysEAIElementId());
        } else {
            dto.setPSDEId(null);
            dto.setPSSysEAIDEName(null);
            dto.setPSSysEAIElementId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAIElementREId())) {
            linkDTO = (PSSysEAIElementREDTO)PSModelServiceUtil.getInstance().getPSSysEAIElementREService().getDTO(dto.getPSSysEAIElementREId());
            dto.setPSSysEAIElementREName(((PSSysEAIElementREDTO)linkDTO).getPSSysEAIElementREName());
        } else {
            dto.setPSSysEAIElementREName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSEAIDER";
    }

    @Override
    public PSSysEAIDER createDomain() {
        return new PSSysEAIDER();
    }

    @Override
    public PSSysEAIDERDTO createDTO() {
        return new PSSysEAIDERDTO();
    }
}

