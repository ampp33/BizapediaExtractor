
package https.www_bizapedia;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Company complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Company"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Success" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EntityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FileNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FilingJurisdictionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FilingJurisdictionPostalAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DomesticJurisdictionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DomesticJurisdictionPostalAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FilingStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EntityType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FilingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="PrincipalAddressCountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PrincipalAddressLine1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PrincipalAddressLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PrincipalAddressCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PrincipalAddressState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PrincipalAddressPostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MailingAddressCountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MailingAddressLine1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MailingAddressLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MailingAddressCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MailingAddressState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MailingAddressPostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegisteredAgentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegisteredAgentAddressCountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegisteredAgentAddressLine1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegisteredAgentAddressLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegisteredAgentCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegisteredAgentState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegisteredAgentPostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegisteredAgentPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegisteredAgentFax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegisteredAgentEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LastUpdateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="RelevanceScore" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="Principals" type="{https://www.bizapedia.com/}ArrayOfPrincipal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Company", propOrder = {
    "success",
    "errorMessage",
    "entityName",
    "fileNumber",
    "filingJurisdictionName",
    "filingJurisdictionPostalAbbreviation",
    "domesticJurisdictionName",
    "domesticJurisdictionPostalAbbreviation",
    "filingStatus",
    "entityType",
    "filingDate",
    "principalAddressCountryCode",
    "principalAddressLine1",
    "principalAddressLine2",
    "principalAddressCity",
    "principalAddressState",
    "principalAddressPostalCode",
    "mailingAddressCountryCode",
    "mailingAddressLine1",
    "mailingAddressLine2",
    "mailingAddressCity",
    "mailingAddressState",
    "mailingAddressPostalCode",
    "registeredAgentName",
    "registeredAgentAddressCountryCode",
    "registeredAgentAddressLine1",
    "registeredAgentAddressLine2",
    "registeredAgentCity",
    "registeredAgentState",
    "registeredAgentPostalCode",
    "registeredAgentPhone",
    "registeredAgentFax",
    "registeredAgentEmail",
    "lastUpdateDate",
    "relevanceScore",
    "principals"
})
public class Company {

    @XmlElement(name = "Success")
    protected boolean success;
    @XmlElement(name = "ErrorMessage")
    protected String errorMessage;
    @XmlElement(name = "EntityName")
    protected String entityName;
    @XmlElement(name = "FileNumber")
    protected String fileNumber;
    @XmlElement(name = "FilingJurisdictionName")
    protected String filingJurisdictionName;
    @XmlElement(name = "FilingJurisdictionPostalAbbreviation")
    protected String filingJurisdictionPostalAbbreviation;
    @XmlElement(name = "DomesticJurisdictionName")
    protected String domesticJurisdictionName;
    @XmlElement(name = "DomesticJurisdictionPostalAbbreviation")
    protected String domesticJurisdictionPostalAbbreviation;
    @XmlElement(name = "FilingStatus")
    protected String filingStatus;
    @XmlElement(name = "EntityType")
    protected String entityType;
    @XmlElement(name = "FilingDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar filingDate;
    @XmlElement(name = "PrincipalAddressCountryCode")
    protected String principalAddressCountryCode;
    @XmlElement(name = "PrincipalAddressLine1")
    protected String principalAddressLine1;
    @XmlElement(name = "PrincipalAddressLine2")
    protected String principalAddressLine2;
    @XmlElement(name = "PrincipalAddressCity")
    protected String principalAddressCity;
    @XmlElement(name = "PrincipalAddressState")
    protected String principalAddressState;
    @XmlElement(name = "PrincipalAddressPostalCode")
    protected String principalAddressPostalCode;
    @XmlElement(name = "MailingAddressCountryCode")
    protected String mailingAddressCountryCode;
    @XmlElement(name = "MailingAddressLine1")
    protected String mailingAddressLine1;
    @XmlElement(name = "MailingAddressLine2")
    protected String mailingAddressLine2;
    @XmlElement(name = "MailingAddressCity")
    protected String mailingAddressCity;
    @XmlElement(name = "MailingAddressState")
    protected String mailingAddressState;
    @XmlElement(name = "MailingAddressPostalCode")
    protected String mailingAddressPostalCode;
    @XmlElement(name = "RegisteredAgentName")
    protected String registeredAgentName;
    @XmlElement(name = "RegisteredAgentAddressCountryCode")
    protected String registeredAgentAddressCountryCode;
    @XmlElement(name = "RegisteredAgentAddressLine1")
    protected String registeredAgentAddressLine1;
    @XmlElement(name = "RegisteredAgentAddressLine2")
    protected String registeredAgentAddressLine2;
    @XmlElement(name = "RegisteredAgentCity")
    protected String registeredAgentCity;
    @XmlElement(name = "RegisteredAgentState")
    protected String registeredAgentState;
    @XmlElement(name = "RegisteredAgentPostalCode")
    protected String registeredAgentPostalCode;
    @XmlElement(name = "RegisteredAgentPhone")
    protected String registeredAgentPhone;
    @XmlElement(name = "RegisteredAgentFax")
    protected String registeredAgentFax;
    @XmlElement(name = "RegisteredAgentEmail")
    protected String registeredAgentEmail;
    @XmlElement(name = "LastUpdateDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdateDate;
    @XmlElement(name = "RelevanceScore", required = true)
    protected BigDecimal relevanceScore;
    @XmlElement(name = "Principals")
    protected ArrayOfPrincipal principals;

    /**
     * Gets the value of the success property.
     * 
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets the value of the success property.
     * 
     */
    public void setSuccess(boolean value) {
        this.success = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the entityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * Sets the value of the entityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityName(String value) {
        this.entityName = value;
    }

    /**
     * Gets the value of the fileNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileNumber() {
        return fileNumber;
    }

    /**
     * Sets the value of the fileNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileNumber(String value) {
        this.fileNumber = value;
    }

    /**
     * Gets the value of the filingJurisdictionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilingJurisdictionName() {
        return filingJurisdictionName;
    }

    /**
     * Sets the value of the filingJurisdictionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilingJurisdictionName(String value) {
        this.filingJurisdictionName = value;
    }

    /**
     * Gets the value of the filingJurisdictionPostalAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilingJurisdictionPostalAbbreviation() {
        return filingJurisdictionPostalAbbreviation;
    }

    /**
     * Sets the value of the filingJurisdictionPostalAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilingJurisdictionPostalAbbreviation(String value) {
        this.filingJurisdictionPostalAbbreviation = value;
    }

    /**
     * Gets the value of the domesticJurisdictionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomesticJurisdictionName() {
        return domesticJurisdictionName;
    }

    /**
     * Sets the value of the domesticJurisdictionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomesticJurisdictionName(String value) {
        this.domesticJurisdictionName = value;
    }

    /**
     * Gets the value of the domesticJurisdictionPostalAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomesticJurisdictionPostalAbbreviation() {
        return domesticJurisdictionPostalAbbreviation;
    }

    /**
     * Sets the value of the domesticJurisdictionPostalAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomesticJurisdictionPostalAbbreviation(String value) {
        this.domesticJurisdictionPostalAbbreviation = value;
    }

    /**
     * Gets the value of the filingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilingStatus() {
        return filingStatus;
    }

    /**
     * Sets the value of the filingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilingStatus(String value) {
        this.filingStatus = value;
    }

    /**
     * Gets the value of the entityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityType() {
        return entityType;
    }

    /**
     * Sets the value of the entityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityType(String value) {
        this.entityType = value;
    }

    /**
     * Gets the value of the filingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFilingDate() {
        return filingDate;
    }

    /**
     * Sets the value of the filingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFilingDate(XMLGregorianCalendar value) {
        this.filingDate = value;
    }

    /**
     * Gets the value of the principalAddressCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrincipalAddressCountryCode() {
        return principalAddressCountryCode;
    }

    /**
     * Sets the value of the principalAddressCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrincipalAddressCountryCode(String value) {
        this.principalAddressCountryCode = value;
    }

    /**
     * Gets the value of the principalAddressLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrincipalAddressLine1() {
        return principalAddressLine1;
    }

    /**
     * Sets the value of the principalAddressLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrincipalAddressLine1(String value) {
        this.principalAddressLine1 = value;
    }

    /**
     * Gets the value of the principalAddressLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrincipalAddressLine2() {
        return principalAddressLine2;
    }

    /**
     * Sets the value of the principalAddressLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrincipalAddressLine2(String value) {
        this.principalAddressLine2 = value;
    }

    /**
     * Gets the value of the principalAddressCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrincipalAddressCity() {
        return principalAddressCity;
    }

    /**
     * Sets the value of the principalAddressCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrincipalAddressCity(String value) {
        this.principalAddressCity = value;
    }

    /**
     * Gets the value of the principalAddressState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrincipalAddressState() {
        return principalAddressState;
    }

    /**
     * Sets the value of the principalAddressState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrincipalAddressState(String value) {
        this.principalAddressState = value;
    }

    /**
     * Gets the value of the principalAddressPostalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrincipalAddressPostalCode() {
        return principalAddressPostalCode;
    }

    /**
     * Sets the value of the principalAddressPostalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrincipalAddressPostalCode(String value) {
        this.principalAddressPostalCode = value;
    }

    /**
     * Gets the value of the mailingAddressCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailingAddressCountryCode() {
        return mailingAddressCountryCode;
    }

    /**
     * Sets the value of the mailingAddressCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailingAddressCountryCode(String value) {
        this.mailingAddressCountryCode = value;
    }

    /**
     * Gets the value of the mailingAddressLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailingAddressLine1() {
        return mailingAddressLine1;
    }

    /**
     * Sets the value of the mailingAddressLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailingAddressLine1(String value) {
        this.mailingAddressLine1 = value;
    }

    /**
     * Gets the value of the mailingAddressLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailingAddressLine2() {
        return mailingAddressLine2;
    }

    /**
     * Sets the value of the mailingAddressLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailingAddressLine2(String value) {
        this.mailingAddressLine2 = value;
    }

    /**
     * Gets the value of the mailingAddressCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailingAddressCity() {
        return mailingAddressCity;
    }

    /**
     * Sets the value of the mailingAddressCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailingAddressCity(String value) {
        this.mailingAddressCity = value;
    }

    /**
     * Gets the value of the mailingAddressState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailingAddressState() {
        return mailingAddressState;
    }

    /**
     * Sets the value of the mailingAddressState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailingAddressState(String value) {
        this.mailingAddressState = value;
    }

    /**
     * Gets the value of the mailingAddressPostalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailingAddressPostalCode() {
        return mailingAddressPostalCode;
    }

    /**
     * Sets the value of the mailingAddressPostalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailingAddressPostalCode(String value) {
        this.mailingAddressPostalCode = value;
    }

    /**
     * Gets the value of the registeredAgentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisteredAgentName() {
        return registeredAgentName;
    }

    /**
     * Sets the value of the registeredAgentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisteredAgentName(String value) {
        this.registeredAgentName = value;
    }

    /**
     * Gets the value of the registeredAgentAddressCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisteredAgentAddressCountryCode() {
        return registeredAgentAddressCountryCode;
    }

    /**
     * Sets the value of the registeredAgentAddressCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisteredAgentAddressCountryCode(String value) {
        this.registeredAgentAddressCountryCode = value;
    }

    /**
     * Gets the value of the registeredAgentAddressLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisteredAgentAddressLine1() {
        return registeredAgentAddressLine1;
    }

    /**
     * Sets the value of the registeredAgentAddressLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisteredAgentAddressLine1(String value) {
        this.registeredAgentAddressLine1 = value;
    }

    /**
     * Gets the value of the registeredAgentAddressLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisteredAgentAddressLine2() {
        return registeredAgentAddressLine2;
    }

    /**
     * Sets the value of the registeredAgentAddressLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisteredAgentAddressLine2(String value) {
        this.registeredAgentAddressLine2 = value;
    }

    /**
     * Gets the value of the registeredAgentCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisteredAgentCity() {
        return registeredAgentCity;
    }

    /**
     * Sets the value of the registeredAgentCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisteredAgentCity(String value) {
        this.registeredAgentCity = value;
    }

    /**
     * Gets the value of the registeredAgentState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisteredAgentState() {
        return registeredAgentState;
    }

    /**
     * Sets the value of the registeredAgentState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisteredAgentState(String value) {
        this.registeredAgentState = value;
    }

    /**
     * Gets the value of the registeredAgentPostalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisteredAgentPostalCode() {
        return registeredAgentPostalCode;
    }

    /**
     * Sets the value of the registeredAgentPostalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisteredAgentPostalCode(String value) {
        this.registeredAgentPostalCode = value;
    }

    /**
     * Gets the value of the registeredAgentPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisteredAgentPhone() {
        return registeredAgentPhone;
    }

    /**
     * Sets the value of the registeredAgentPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisteredAgentPhone(String value) {
        this.registeredAgentPhone = value;
    }

    /**
     * Gets the value of the registeredAgentFax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisteredAgentFax() {
        return registeredAgentFax;
    }

    /**
     * Sets the value of the registeredAgentFax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisteredAgentFax(String value) {
        this.registeredAgentFax = value;
    }

    /**
     * Gets the value of the registeredAgentEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisteredAgentEmail() {
        return registeredAgentEmail;
    }

    /**
     * Sets the value of the registeredAgentEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisteredAgentEmail(String value) {
        this.registeredAgentEmail = value;
    }

    /**
     * Gets the value of the lastUpdateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * Sets the value of the lastUpdateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdateDate(XMLGregorianCalendar value) {
        this.lastUpdateDate = value;
    }

    /**
     * Gets the value of the relevanceScore property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRelevanceScore() {
        return relevanceScore;
    }

    /**
     * Sets the value of the relevanceScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRelevanceScore(BigDecimal value) {
        this.relevanceScore = value;
    }

    /**
     * Gets the value of the principals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPrincipal }
     *     
     */
    public ArrayOfPrincipal getPrincipals() {
        return principals;
    }

    /**
     * Sets the value of the principals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPrincipal }
     *     
     */
    public void setPrincipals(ArrayOfPrincipal value) {
        this.principals = value;
    }

}
