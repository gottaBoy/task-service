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
import net.ibizsys.modelapi.domain.PSSysCanvas;
import net.ibizsys.modelapi.domain.PSSysCanvasModel;
import net.ibizsys.modelapi.dto.PSSysCanvasDTO;
import net.ibizsys.modelapi.dto.PSSysCanvasModelDTO;
import net.ibizsys.modelapi.service.IPSSysCanvasModelService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysCanvasModelServiceImpl
extends PSModelServiceImplBase<PSSysCanvasModel, PSSysCanvasModelDTO>
implements IPSSysCanvasModelService {
    private static final Log log = LogFactory.getLog(PSSysCanvasModelServiceImpl.class);

    @Override
    public List<PSSysCanvasModel> listByPSSysCanvas(PSSysCanvas parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysCanvasModel get(PSSysCanvas parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysCanvasModel> list = this.listByPSSysCanvas(parent);
        if (list != null) {
            for (PSSysCanvasModel item : list) {
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
    public List<PSSysCanvasModelDTO> listDTOByPSSysCanvas(String strParentKey) throws Exception {
        PSSysCanvas pssyscanvas = (PSSysCanvas)PSModelServiceUtil.getInstance().getPSSysCanvasService().get(strParentKey);
        List<PSSysCanvasModel> list = this.listByPSSysCanvas(pssyscanvas);
        if (list != null) {
            ArrayList<PSSysCanvasModelDTO> dtoList = new ArrayList<PSSysCanvasModelDTO>();
            for (PSSysCanvasModel item : list) {
                PSSysCanvasModelDTO dto = (PSSysCanvasModelDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysCanvasModel> onListAll() throws Exception {
        ArrayList<PSSysCanvasModel> list = new ArrayList<PSSysCanvasModel>();
        List pssyscanvas = PSModelServiceUtil.getInstance().getPSSysCanvasService().listAll();
        if (pssyscanvas != null) {
            for (PSSysCanvas parent : pssyscanvas) {
                List<PSSysCanvasModel> items = this.listByPSSysCanvas(parent);
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
    protected PSSysCanvasModel onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysCanvasModel item;
        PSSysCanvas pssyscanvas = (PSSysCanvas)PSModelServiceUtil.getInstance().getPSSysCanvasService().get(strParentKey, true);
        if (pssyscanvas != null && (item = this.get(pssyscanvas, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysCanvasModel)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysCanvasModelDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysCanvasId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysCanvasService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysCanvasModel et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysCanvasModelDTO dto, PSSysCanvasModel t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysCanvasModelId(t.getId().replace("/", "."));
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
        if (t.getPSModelId() != null || !bIgnoreNull) {
            dto.setPSModelId(t.getPSModelId());
        }
        if (t.getPSModelName() != null || !bIgnoreNull) {
            dto.setPSModelName(t.getPSModelName());
        }
        if (t.getPSModelType() != null || !bIgnoreNull) {
            dto.setPSModelType(t.getPSModelType());
        }
        if (t.getPSSysCanvasId() != null || !bIgnoreNull) {
            dto.setPSSysCanvasId(t.getPSSysCanvasId());
        }
        if (t.getPSSysCanvasModelName() != null || !bIgnoreNull) {
            dto.setPSSysCanvasModelName(t.getPSSysCanvasModelName());
        }
        if (t.getPSSysCanvasName() != null || !bIgnoreNull) {
            dto.setPSSysCanvasName(t.getPSSysCanvasName());
        }
        if (t.getSymbolName() != null || !bIgnoreNull) {
            dto.setSymbolName(t.getSymbolName());
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
        if (StringUtils.hasLength((String)dto.getPSSysCanvasId())) {
            dto.setPSSysCanvasId(this.getRealPSModelId(t, dto.getPSSysCanvasId()).replace("/", "."));
        }
        if ("PSSYSCANVAS".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysCanvasId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCanvasId())) {
            PSSysCanvasDTO linkDTO = (PSSysCanvasDTO)PSModelServiceUtil.getInstance().getPSSysCanvasService().getDTO(dto.getPSSysCanvasId());
            dto.setPSSysCanvasName(linkDTO.getPSSysCanvasName());
        } else {
            dto.setPSSysCanvasName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSCANVASMODEL";
    }

    @Override
    public PSSysCanvasModel createDomain() {
        return new PSSysCanvasModel();
    }

    @Override
    public PSSysCanvasModelDTO createDTO() {
        return new PSSysCanvasModelDTO();
    }
}

