package com.classifiedindia.formbean;

import com.classifiedindia.vo.ClassifiedIndiaVO;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

public class ClassifiedIndiaFormBean extends org.apache.struts.action.ActionForm {

    private String classifiedId;
    private String classifiedCategory;
    private String classifiedCategoryName;
    private String classifiedTitle;
    private String classifiedSubject;
    private String classifiedPrimaryContact;
    private String classifiedSecondaryContact;
    private String classifiedEmailId;
    private String classifiedWebUrl;
    private String classifiedContactPerson;
    private String classifiedActiveDeactiveStatus;
    private String classifiedBookingDuration;
    private String classifiedPostingDate;
    private String classifiedExpireDate;
    private String classifiedExpireWarrningDate;
    private String classifiedPaymentCategory;
    private String classifiedSubCategory;
    private String classifiedSubCategoryName;
    private String countryCode;
    private String locationId;
    private String countryName;
    private String locationName;
    private String classifiedOrganizationName;
    private double classifiedImageId;
    private String classifiedPhotoId;
    private List<Integer> classifiedsPhotoIds;
    private ArrayList<ClassifiedIndiaVO> mydashList;
    private String searchWord;
    private String tablename;

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }
    private ArrayList<ClassifiedIndiaVO> searchList;
    

    public ArrayList<ClassifiedIndiaVO> getSearchList() {
        return searchList;
    }

    public void setSearchList(ArrayList<ClassifiedIndiaVO> searchList) {
        this.searchList = searchList;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public ArrayList<ClassifiedIndiaVO> getMydashList() {
        return mydashList;
    }

    public void setMydashList(ArrayList<ClassifiedIndiaVO> mydashList) {
        this.mydashList = mydashList;
    }

    public String getClassifiedId() {
        return classifiedId;
    }

    public void setClassifiedId(String classifiedId) {
        this.classifiedId = classifiedId;
    }

    public String getClassifiedCategory() {
        return classifiedCategory;
    }

    public void setClassifiedCategory(String classifiedCategory) {
        this.classifiedCategory = classifiedCategory;
    }

    public String getClassifiedCategoryName() {
        return classifiedCategoryName;
    }

    public void setClassifiedCategoryName(String classifiedCategoryName) {
        this.classifiedCategoryName = classifiedCategoryName;
    }

    public String getClassifiedSubject() {
        return classifiedSubject;
    }

    public void setClassifiedSubject(String classifiedSubject) {
        this.classifiedSubject = classifiedSubject;
    }

    public String getClassifiedPrimaryContact() {
        return classifiedPrimaryContact;
    }

    public void setClassifiedPrimaryContact(String classifiedPrimaryContact) {
        this.classifiedPrimaryContact = classifiedPrimaryContact;
    }

    public String getClassifiedSecondaryContact() {
        return classifiedSecondaryContact;
    }

    public void setClassifiedSecondaryContact(String classifiedSecondaryContact) {
        this.classifiedSecondaryContact = classifiedSecondaryContact;
    }

    public String getClassifiedEmailId() {
        return classifiedEmailId;
    }

    public void setClassifiedEmailId(String classifiedEmailId) {
        this.classifiedEmailId = classifiedEmailId;
    }

    public String getClassifiedWebUrl() {
        return classifiedWebUrl;
    }

    public void setClassifiedWebUrl(String classifiedWebUrl) {
        this.classifiedWebUrl = classifiedWebUrl;
    }

    public String getClassifiedContactPerson() {
        return classifiedContactPerson;
    }

    public void setClassifiedContactPerson(String classifiedContactPerson) {
        this.classifiedContactPerson = classifiedContactPerson;
    }

    public String getClassifiedActiveDeactiveStatus() {
        return classifiedActiveDeactiveStatus;
    }

    public void setClassifiedActiveDeactiveStatus(String classifiedActiveDeactiveStatus) {
        this.classifiedActiveDeactiveStatus = classifiedActiveDeactiveStatus;
    }

    public String getClassifiedBookingDuration() {
        return classifiedBookingDuration;
    }

    public void setClassifiedBookingDuration(String classifiedBookingDuration) {
        this.classifiedBookingDuration = classifiedBookingDuration;
    }

    public String getClassifiedPostingDate() {
        return classifiedPostingDate;
    }

    public void setClassifiedPostingDate(String classifiedPostingDate) {
        this.classifiedPostingDate = classifiedPostingDate;
    }

    public String getClassifiedExpireDate() {
        return classifiedExpireDate;
    }

    public void setClassifiedExpireDate(String classifiedExpireDate) {
        this.classifiedExpireDate = classifiedExpireDate;
    }

    public String getClassifiedExpireWarrningDate() {
        return classifiedExpireWarrningDate;
    }

    public void setClassifiedExpireWarrningDate(String classifiedExpireWarrningDate) {
        this.classifiedExpireWarrningDate = classifiedExpireWarrningDate;
    }

    public String getClassifiedPaymentCategory() {
        return classifiedPaymentCategory;
    }

    public void setClassifiedPaymentCategory(String classifiedPaymentCategory) {
        this.classifiedPaymentCategory = classifiedPaymentCategory;
    }

    public String getClassifiedSubCategory() {
        return classifiedSubCategory;
    }

    public void setClassifiedSubCategory(String classifiedSubCategory) {
        this.classifiedSubCategory = classifiedSubCategory;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.classifiedCategory = null;
        this.classifiedContactPerson = null;
        this.classifiedEmailId = null;
        this.classifiedId = null;
        this.classifiedPaymentCategory = null;
        this.classifiedPrimaryContact = null;
        this.classifiedSubCategory = null;
        this.classifiedSubject = null;
        this.classifiedWebUrl = null;
    }

    /**
     * @return the classifiedTitle
     */
    public String getClassifiedTitle() {
        return classifiedTitle;
    }

    /**
     * @param classifiedTitle the classifiedTitle to set
     */
    public void setClassifiedTitle(String classifiedTitle) {
        this.classifiedTitle = classifiedTitle;
    }

    /**
     * @return the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return the locationId
     */
    public String getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    /**
     * @return the countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * @return the locationName
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * @param locationName the locationName to set
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * @return the classifiedSubCategoryName
     */
    public String getClassifiedSubCategoryName() {
        return classifiedSubCategoryName;
    }

    /**
     * @param classifiedSubCategoryName the classifiedSubCategoryName to set
     */
    public void setClassifiedSubCategoryName(String classifiedSubCategoryName) {
        this.classifiedSubCategoryName = classifiedSubCategoryName;
    }

    /**
     * @return the classifiedOrganizationName
     */
    public String getClassifiedOrganizationName() {
        return classifiedOrganizationName;
    }

    /**
     * @param classifiedOrganizationName the classifiedOrganizationName to set
     */
    public void setClassifiedOrganizationName(String classifiedOrganizationName) {
        this.classifiedOrganizationName = classifiedOrganizationName;
    }

    /**
     * @return the classifiedImage
     */
    public double getClassifiedImageId() {
        return classifiedImageId;
    }

    /**
     * @param classifiedImage the classifiedImage to set
     */
    public void setClassifiedImageId(double classifiedImageId) {
        this.classifiedImageId = classifiedImageId;
    }

    /**
     * @return the classifiedsPhotoIds
     */
    public List<Integer> getClassifiedsPhotoIds() {
        return classifiedsPhotoIds;
    }

    /**
     * @param classifiedsPhotoIds the classifiedsPhotoIds to set
     */
    public void setClassifiedsPhotoIds(List<Integer> classifiedsPhotoIds) {
        this.classifiedsPhotoIds = classifiedsPhotoIds;
    }

    /**
     * @return the classifiedPhotoId
     */
    public String getClassifiedPhotoId() {
        return classifiedPhotoId;
    }

    /**
     * @param classifiedPhotoId the classifiedPhotoId to set
     */
    public void setClassifiedPhotoId(String classifiedPhotoId) {
        this.classifiedPhotoId = classifiedPhotoId;
    }

}
