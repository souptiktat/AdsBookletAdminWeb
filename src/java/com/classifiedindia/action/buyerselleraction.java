/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classifiedindia.action;

import com.classifiedindia.formbean.BuyerSellerInfoBean;
import com.classifiedindia.formbean.MobilePhonesFormBean;
import com.classifiedindia.model.SellerBuyerModel;
import com.classifiedindia.vo.MobilePhoneVO;
import com.classifiedindia.vo.SellerBuyerVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Sneha
 */
public class buyerselleraction extends org.apache.struts.actions.MappingDispatchAction {

    private static final String BUYERSELLERACTION = "buyerselleraction";

   
    public ActionForward buyersellerinfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        BuyerSellerInfoBean buyerSellerInfoBean = (BuyerSellerInfoBean) form;
        SellerBuyerVO sellerBuyerVO = new SellerBuyerVO();
        SellerBuyerModel sellerBuyerModel = new SellerBuyerModel();

        HttpSession session1 = request.getSession(false);
        int unique = (Integer) session1.getAttribute("unique");
        String subcatid = (String) session1.getAttribute("subcatid");

        buyerSellerInfoBean.setUnique(unique);
        buyerSellerInfoBean.setSubcatid(subcatid);
        buyerSellerInfoBean.setStatustype(request.getParameter("statustype"));
        buyerSellerInfoBean.setName(request.getParameter("name"));
        buyerSellerInfoBean.setEmail(request.getParameter("email"));
        buyerSellerInfoBean.setMobileno(request.getParameter("mobileno"));
        buyerSellerInfoBean.setAddress(request.getParameter("address"));
        buyerSellerInfoBean.setCity(request.getParameter("city"));
        buyerSellerInfoBean.setStateid(request.getParameter("stateid"));
        buyerSellerInfoBean.setDistrictid(request.getParameter("districtid"));
        buyerSellerInfoBean.setPincode(request.getParameter("pincode"));

        sellerBuyerVO.setUnique(buyerSellerInfoBean.getUnique());
        sellerBuyerVO.setSubcatid(buyerSellerInfoBean.getSubcatid());
        sellerBuyerVO.setStatustype(buyerSellerInfoBean.getStatustype());
        sellerBuyerVO.setName(buyerSellerInfoBean.getName());
        sellerBuyerVO.setEmail(buyerSellerInfoBean.getEmail());
        sellerBuyerVO.setAddress(buyerSellerInfoBean.getAddress());
        sellerBuyerVO.setCity(buyerSellerInfoBean.getCity());
        sellerBuyerVO.setStateid(buyerSellerInfoBean.getStateid());
        sellerBuyerVO.setDistrictid(buyerSellerInfoBean.getDistrictid());
        sellerBuyerVO.setMobileno(buyerSellerInfoBean.getMobileno());
        sellerBuyerVO.setPincode(buyerSellerInfoBean.getPincode());

        boolean b = sellerBuyerModel.insertSellerBuyerInfo(sellerBuyerVO);

        /*buyerSellerInfoBean.setName(sellerBuyerVO.getName());
        buyerSellerInfoBean.setEmail(sellerBuyerVO.getEmail());
        buyerSellerInfoBean.setAddress(sellerBuyerVO.getAddress());
        buyerSellerInfoBean.setCity(sellerBuyerVO.getCity());*/
        buyerSellerInfoBean.setDistrict(sellerBuyerVO.getDistrict());
        buyerSellerInfoBean.setState(sellerBuyerVO.getState());
        
        return mapping.findForward(BUYERSELLERACTION);
    }
}
