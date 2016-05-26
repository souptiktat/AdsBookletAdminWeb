package com.classifiedindia.action;

import com.classifiedindia.formbean.ClassifiedIndiaFormBean;
import com.classifiedindia.formbean.MobilePhonesFormBean;
import com.classifiedindia.model.ClassifiedModel;
import com.classifiedindia.model.MobileModel;
import com.classifiedindia.vo.ClassifiedIndiaVO;
import com.classifiedindia.vo.MobilePhoneVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

public class MobileAdsAction extends MappingDispatchAction {

    private static final String SELLERBUYERINFO = "sellerbuyerinfo";

    public ActionForward mobilepage(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobilePhonesFormBean mobilePhonesFormBean = (MobilePhonesFormBean) form;
        HttpSession session = request.getSession(false);
        String subcategory = (String) session.getAttribute("subcategory");
        //String classifiedEmailId = (String) session.getAttribute("username");
        double imageId = (Double) session.getAttribute("generatedFloat");
        MobileModel mobileModel = new MobileModel();
        MobilePhoneVO mobilePhoneVO = new MobilePhoneVO();

        String[] includesid = request.getParameterValues("includesid");
        mobilePhonesFormBean.setIncludesid(includesid);
        mobilePhoneVO.setIncludesid(mobilePhonesFormBean.getIncludesid());
        String[] bnm = mobilePhoneVO.getIncludesid();

        mobilePhonesFormBean.setImageId(imageId);
        mobilePhonesFormBean.setMobisubcatid(subcategory);
        System.out.println("gg" + mobilePhonesFormBean.getImageId());
        mobilePhonesFormBean.setTypeofAd(request.getParameter("typeofAd"));
        mobilePhonesFormBean.setMobileadTitle(request.getParameter("mobileadTitle"));
        mobilePhonesFormBean.setMobicondition(request.getParameter("mobicondition"));
        mobilePhonesFormBean.setMobiprice(request.getParameter("mobiprice"));
        mobilePhonesFormBean.setXpectmobiprice(request.getParameter("xpectmobiprice"));
        mobilePhonesFormBean.setMobibrand(request.getParameter("mobibrand"));
        mobilePhonesFormBean.setMobimodel(request.getParameter("mobimodel"));
        mobilePhonesFormBean.setMobiOS(request.getParameter("mobiOS"));
        mobilePhonesFormBean.setMobisimNo(request.getParameter("mobisimNo"));
        mobilePhonesFormBean.setMobidescription(request.getParameter("mobidescription"));

        mobilePhoneVO.setImageId(mobilePhonesFormBean.getImageId());
        mobilePhoneVO.setMobisubcatid(mobilePhonesFormBean.getMobisubcatid());
        mobilePhoneVO.setTypeofAd(mobilePhonesFormBean.getTypeofAd());
        mobilePhoneVO.setMobileadTitle(mobilePhonesFormBean.getMobileadTitle());
        mobilePhoneVO.setMobicondition(mobilePhonesFormBean.getMobicondition());
        mobilePhoneVO.setMobiprice(mobilePhonesFormBean.getMobiprice());
        mobilePhoneVO.setXpectmobiprice(mobilePhonesFormBean.getXpectmobiprice());
        mobilePhoneVO.setMobibrand(mobilePhonesFormBean.getMobibrand());
        mobilePhoneVO.setMobimodel(mobilePhonesFormBean.getMobimodel());
        mobilePhoneVO.setMobiOS(mobilePhonesFormBean.getMobiOS());
        mobilePhoneVO.setMobisimNo(mobilePhonesFormBean.getMobisimNo());
        mobilePhoneVO.setMobidescription(mobilePhonesFormBean.getMobidescription());
        System.out.println("kk" + mobilePhoneVO.getImageId());

        if (mobilePhoneVO == null) {
            System.out.println("nodata found");
        }
        boolean b = mobileModel.postMobilePhoneAdv(mobilePhoneVO);

        HttpSession session1 = request.getSession(true);
        mobilePhonesFormBean.setUnique(mobilePhoneVO.getUnique());
        mobilePhonesFormBean.setMobisubcatid(mobilePhoneVO.getMobisubcatid());
        mobilePhonesFormBean.setMobileadTitle(mobilePhoneVO.getMobileadTitle());
        mobilePhonesFormBean.setMobidescription(mobilePhoneVO.getMobidescription());
        mobilePhonesFormBean.setMobiprice(mobilePhoneVO.getMobiprice());
        mobilePhonesFormBean.setMobibrandName(mobilePhoneVO.getMobibrandName());
        mobilePhonesFormBean.setMobimodelName(mobilePhoneVO.getMobimodelName());
        mobilePhonesFormBean.setMobiOSName(mobilePhoneVO.getMobiOSName());
        mobilePhonesFormBean.setMobisimNoName(mobilePhoneVO.getMobisimNoName());
        mobilePhonesFormBean.setIncludesname(mobilePhoneVO.getIncludesname());
        mobilePhonesFormBean.setDate(mobilePhoneVO.getDate());
        //System.out.println("hb "+mobilePhonesFormBean.getIncludesname());

        session1.setAttribute("unique", mobilePhonesFormBean.getUnique());
        session1.setAttribute("subcatid", mobilePhonesFormBean.getMobisubcatid());
        session1.setAttribute("mobileadTitle", mobilePhonesFormBean.getMobileadTitle());
        session1.setAttribute("mobidescription", mobilePhonesFormBean.getMobidescription());
        session1.setAttribute("mobiprice", mobilePhonesFormBean.getMobiprice());
        session1.setAttribute("mobibrandname", mobilePhonesFormBean.getMobibrandName());
        session1.setAttribute("mobimodelname", mobilePhonesFormBean.getMobimodelName());
        session1.setAttribute("mobiosname", mobilePhonesFormBean.getMobiOSName());
        session1.setAttribute("mobisimname", mobilePhonesFormBean.getMobisimNoName());
        session1.setAttribute("mobiincludesname", mobilePhonesFormBean.getIncludesname());
        session1.setAttribute("postingdate", mobilePhonesFormBean.getDate());
        return mapping.findForward(SELLERBUYERINFO);
    }

    public ActionForward accessorypage(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobilePhonesFormBean mobilePhonesFormBean = (MobilePhonesFormBean) form;
        HttpSession session = request.getSession(false);
        String subcategory = (String) session.getAttribute("subcategory");
        //System.out.println("RITWIK"+subcategory);
        //String classifiedEmailId = (String) session.getAttribute("username");
        double imageId = (Double) session.getAttribute("generatedFloat");
        MobileModel mobileModel = new MobileModel();
        MobilePhoneVO mobilePhoneVO = new MobilePhoneVO();
        /*
         String[] includesid = request.getParameterValues("includesid");
         mobilePhonesFormBean.setIncludesid(includesid);
         mobilePhoneVO.setIncludesid(mobilePhonesFormBean.getIncludesid());
         String[] bnm = mobilePhoneVO.getIncludesid();
         System.out.println("new: "+bnm[0]+" "+bnm[1]);
         */
        mobilePhonesFormBean.setImageId(imageId);
        mobilePhonesFormBean.setSubcatid(subcategory);
        System.out.println("gg" + mobilePhonesFormBean.getImageId());
        mobilePhonesFormBean.setTypeofAd(request.getParameter("typeofAd"));
        mobilePhonesFormBean.setMobileadTitle(request.getParameter("mobileadTitle"));
        mobilePhonesFormBean.setMobicondition(request.getParameter("mobicondition"));
        mobilePhonesFormBean.setMobiprice(request.getParameter("mobiprice"));
        mobilePhonesFormBean.setXpectmobiprice(request.getParameter("xpectmobiprice"));
        mobilePhonesFormBean.setAccessoribrandId(request.getParameter("accessoribrandId"));
        mobilePhonesFormBean.setAccessorytypeId(request.getParameter("accessorytypeId"));
        mobilePhonesFormBean.setMobidescription(request.getParameter("mobidescription"));

        mobilePhoneVO.setImageId(mobilePhonesFormBean.getImageId());
        mobilePhoneVO.setSubcatid(mobilePhonesFormBean.getSubcatid());
        mobilePhoneVO.setTypeofAd(mobilePhonesFormBean.getTypeofAd());
        mobilePhoneVO.setMobileadTitle(mobilePhonesFormBean.getMobileadTitle());
        mobilePhoneVO.setMobicondition(mobilePhonesFormBean.getMobicondition());
        mobilePhoneVO.setMobiprice(mobilePhonesFormBean.getMobiprice());
        mobilePhoneVO.setXpectmobiprice(mobilePhonesFormBean.getXpectmobiprice());
        mobilePhoneVO.setAccessoribrandId(mobilePhonesFormBean.getAccessoribrandId());
        mobilePhoneVO.setAccessorytypeId(mobilePhonesFormBean.getAccessorytypeId());
        mobilePhoneVO.setMobidescription(mobilePhonesFormBean.getMobidescription());
        System.out.println("kk" + mobilePhoneVO.getImageId());

        if (mobilePhoneVO == null) {
            System.out.println("nodata found");
        }
        boolean b = mobileModel.postAccessoryAdv(mobilePhoneVO);
        HttpSession session1 = request.getSession(true);
        mobilePhonesFormBean.setUnique(mobilePhoneVO.getUnique());
        mobilePhonesFormBean.setSubcatid(mobilePhoneVO.getSubcatid());
        mobilePhonesFormBean.setMobiprice(mobilePhoneVO.getMobiprice());
        mobilePhonesFormBean.setMobileadTitle(mobilePhoneVO.getMobileadTitle());
        mobilePhonesFormBean.setMobidescription(mobilePhoneVO.getMobidescription());
        mobilePhonesFormBean.setAccessorytypeName(mobilePhoneVO.getAccessorytypeName());
        mobilePhonesFormBean.setAccessoribrandName(mobilePhoneVO.getAccessoribrandName());
        mobilePhonesFormBean.setDate(mobilePhoneVO.getDate());

        session1.setAttribute("unique", mobilePhonesFormBean.getUnique());
        session1.setAttribute("subcatid", mobilePhonesFormBean.getSubcatid());
        session1.setAttribute("mobiprice", mobilePhonesFormBean.getMobiprice());
        session1.setAttribute("mobileadTitle", mobilePhonesFormBean.getMobileadTitle());
        session1.setAttribute("mobidescription", mobilePhonesFormBean.getMobidescription());
        session1.setAttribute("accessorytypeName", mobilePhonesFormBean.getAccessorytypeName());
        session1.setAttribute("accessoribrandName", mobilePhonesFormBean.getAccessoribrandName());
        session1.setAttribute("postingdate", mobilePhonesFormBean.getDate());

        return mapping.findForward(SELLERBUYERINFO);
    }

    public ActionForward tabletpage(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobilePhonesFormBean mobilePhonesFormBean = (MobilePhonesFormBean) form;
        HttpSession session = request.getSession(false);
         String subcategory = (String) session.getAttribute("subcategory");
         //System.out.println("RITWIK"+subcategory);
         //String classifiedEmailId = (String) session.getAttribute("username");
         double imageId = (Double) session.getAttribute("generatedFloat");
         MobileModel mobileModel = new MobileModel();
         MobilePhoneVO mobilePhoneVO = new MobilePhoneVO();
        
         mobilePhonesFormBean.setImageId(imageId);
         mobilePhonesFormBean.setSubcatid(subcategory);
         System.out.println("gg" + mobilePhonesFormBean.getImageId());
         mobilePhonesFormBean.setTypeofAd(request.getParameter("typeofAd"));
         mobilePhonesFormBean.setMobileadTitle(request.getParameter("mobileadTitle"));
         mobilePhonesFormBean.setMobicondition(request.getParameter("mobicondition"));
         mobilePhonesFormBean.setMobiprice(request.getParameter("mobiprice"));
         mobilePhonesFormBean.setXpectmobiprice(request.getParameter("xpectmobiprice"));
         mobilePhonesFormBean.setTabletbrandId(request.getParameter("tabletbrandId"));
         mobilePhonesFormBean.setMobidescription(request.getParameter("mobidescription"));

         mobilePhoneVO.setImageId(mobilePhonesFormBean.getImageId());
         mobilePhoneVO.setSubcatid(mobilePhonesFormBean.getSubcatid());
         mobilePhoneVO.setTypeofAd(mobilePhonesFormBean.getTypeofAd());
         mobilePhoneVO.setMobileadTitle(mobilePhonesFormBean.getMobileadTitle());
         mobilePhoneVO.setMobicondition(mobilePhonesFormBean.getMobicondition());
         mobilePhoneVO.setMobiprice(mobilePhonesFormBean.getMobiprice());
         mobilePhoneVO.setXpectmobiprice(mobilePhonesFormBean.getXpectmobiprice());
         mobilePhoneVO.setTabletbrandId(mobilePhonesFormBean.getTabletbrandId());
         mobilePhoneVO.setMobidescription(mobilePhonesFormBean.getMobidescription());
         System.out.println("kk" + mobilePhoneVO.getImageId());

         if (mobilePhoneVO == null) {
         System.out.println("nodata found");
         }
         boolean b = mobileModel.postTabletAdv(mobilePhoneVO);
         HttpSession session1 = request.getSession(true);
         mobilePhonesFormBean.setUnique(mobilePhoneVO.getUnique());
         mobilePhonesFormBean.setSubcatid(mobilePhoneVO.getSubcatid());
         mobilePhonesFormBean.setMobiprice(mobilePhoneVO.getMobiprice());
         mobilePhonesFormBean.setMobileadTitle(mobilePhoneVO.getMobileadTitle());
         mobilePhonesFormBean.setMobidescription(mobilePhoneVO.getMobidescription());
         mobilePhonesFormBean.setTabletbrandName(mobilePhoneVO.getTabletbrandName());
         mobilePhonesFormBean.setDate(mobilePhoneVO.getDate());
        
         session1.setAttribute("unique", mobilePhonesFormBean.getUnique());
         session1.setAttribute("subcatid", mobilePhonesFormBean.getSubcatid());
         session1.setAttribute("mobiprice", mobilePhonesFormBean.getMobiprice());
         session1.setAttribute("mobileadTitle", mobilePhonesFormBean.getMobileadTitle());
         session1.setAttribute("mobidescription", mobilePhonesFormBean.getMobidescription());
         session1.setAttribute("tabletbrandName", mobilePhonesFormBean.getTabletbrandName());
         session1.setAttribute("postingdate", mobilePhonesFormBean.getDate());
         
        return mapping.findForward(SELLERBUYERINFO);
    }
}
