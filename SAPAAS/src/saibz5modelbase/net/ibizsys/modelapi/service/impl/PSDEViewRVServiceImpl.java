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
import net.ibizsys.modelapi.domain.PSDEViewBase;
import net.ibizsys.modelapi.domain.PSDEViewRV;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDEViewRVDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.service.IPSDEViewRVService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEViewRVServiceImpl
extends PSModelServiceImplBase<PSDEViewRV, PSDEViewRVDTO>
implements IPSDEViewRVService {
    private static final Log log = LogFactory.getLog(PSDEViewRVServiceImpl.class);

    @Override
    public List<PSDEViewRV> listByPSDEViewBase(PSDEViewBase parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEViewRV get(PSDEViewBase parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEViewRV> list = this.listByPSDEViewBase(parent);
        if (list != null) {
            for (PSDEViewRV item : list) {
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
    public List<PSDEViewRVDTO> listDTOByPSDEViewBase(String strParentKey) throws Exception {
        PSDEViewBase psdeviewbase = (PSDEViewBase)PSModelServiceUtil.getInstance().getPSDEViewBaseService().get(strParentKey);
        List<PSDEViewRV> list = this.listByPSDEViewBase(psdeviewbase);
        if (list != null) {
            ArrayList<PSDEViewRVDTO> dtoList = new ArrayList<PSDEViewRVDTO>();
            for (PSDEViewRV item : list) {
                PSDEViewRVDTO dto = (PSDEViewRVDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEViewRV> onListAll() throws Exception {
        ArrayList<PSDEViewRV> list = new ArrayList<PSDEViewRV>();
        List psdeviewbases = PSModelServiceUtil.getInstance().getPSDEViewBaseService().listAll();
        if (psdeviewbases != null) {
            for (PSDEViewBase parent : psdeviewbases) {
                List<PSDEViewRV> items = this.listByPSDEViewBase(parent);
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
    protected PSDEViewRV onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEViewRV item;
        PSDEViewBase psdeviewbase = (PSDEViewBase)PSModelServiceUtil.getInstance().getPSDEViewBaseService().get(strParentKey, true);
        if (psdeviewbase != null && (item = this.get(psdeviewbase, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEViewRV)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEViewRVDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getMajorPSDEViewId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEViewBaseService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEViewRV et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEViewRVName())) {
            return et.getPSDEViewRVName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEViewRVDTO dto, PSDEViewRV t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEViewRVId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDefViewType() != null || !bIgnoreNull) {
            dto.setDefViewType(t.getDefViewType());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getHeight() != null || !bIgnoreNull) {
            dto.setHeight(t.getHeight());
        }
        if (t.getMajorPSDEViewId() != null || !bIgnoreNull) {
            dto.setMajorPSDEViewId(t.getMajorPSDEViewId());
        }
        if (t.getMajorPSDEViewName() != null || !bIgnoreNull) {
            dto.setMajorPSDEViewName(t.getMajorPSDEViewName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinorPSDEViewId() != null || !bIgnoreNull) {
            dto.setMinorPSDEViewId(t.getMinorPSDEViewId());
        }
        if (t.getMinorPSDEViewName() != null || !bIgnoreNull) {
            dto.setMinorPSDEViewName(t.getMinorPSDEViewName());
        }
        if (t.getOpenMode() != null || !bIgnoreNull) {
            dto.setOpenMode(t.getOpenMode());
        }
        if (t.getPSDEViewRVName() != null || !bIgnoreNull) {
            dto.setPSDEViewRVName(t.getPSDEViewRVName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
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
        if (t.getTitle() != null || !bIgnoreNull) {
            dto.setTitle(t.getTitle());
        }
        if (t.getTitlePSLanResId() != null || !bIgnoreNull) {
            dto.setTitlePSLanResId(t.getTitlePSLanResId());
        }
        if (t.getTitlePSLanResName() != null || !bIgnoreNull) {
            dto.setTitlePSLanResName(t.getTitlePSLanResName());
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
        if (t.getViewParams() != null || !bIgnoreNull) {
            dto.setViewParams(t.getViewParams());
        }
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDEViewId())) {
            dto.setMajorPSDEViewId(this.getRealPSModelId(t, dto.getMajorPSDEViewId()).replace("/", "."));
        }
        if ("PSDEVIEWBASE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setMajorPSDEViewId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDEViewId())) {
            dto.setMinorPSDEViewId(this.getRealPSModelId(t, dto.getMinorPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTitlePSLanResId())) {
            dto.setTitlePSLanResId(this.getRealPSModelId(t, dto.getTitlePSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getMajorPSDEViewId());
            dto.setMajorPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
            dto.setPSSystemId(((PSDEViewBaseDTO)linkDTO).getPSSystemId());
        } else {
            dto.setMajorPSDEViewName(null);
            dto.setPSSystemId(null);
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getMinorPSDEViewId());
            dto.setMinorPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setMinorPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getTitlePSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getTitlePSLanResId());
            dto.setTitlePSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setTitlePSLanResName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEVIEWRV";
    }

    @Override
    public PSDEViewRV createDomain() {
        return new PSDEViewRV();
    }

    @Override
    public PSDEViewRVDTO createDTO() {
        return new PSDEViewRVDTO();
    }
}

