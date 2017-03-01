
package https.www_bizapedia;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Trademark complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Trademark"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SerialNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="RegistrationNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="FilingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="RegistrationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="StatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StatusDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StatusDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="OwnerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OwnerNationalityState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OwnerNationalityStateName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OwnerNationalityCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OwnerAddressLine1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OwnerAddressLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OwnerAddressCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OwnerAddressState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OwnerAddressPostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OwnerPartyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OwnerPartyTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MarkIdentification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MarkDrawingCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MarkDrawingDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PublishedForOppositionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="AttorneyDocketNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AttorneyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LawOfficeAssignedLocationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LawOfficeAssignedLocationDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LocationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="EmployeeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AbandonmentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="CancellationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CancellationDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CancellationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="Republished12cDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="DomesticRepresentativeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RenewalDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="LastTransactionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="CaseFileHeaderFlagsXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CaseFileOwnersXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CaseFileStatementsXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CaseFileEventStatementsXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PriorRegistrationApplicationsXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ClassificationsXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CorrespondentXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MadridInternationalFilingRequestsXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ForeignApplicationsXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DesignSearchesXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InternationalRegistrationXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LastUpdateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="RelevanceScore" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Trademark", propOrder = {
    "serialNumber",
    "registrationNumber",
    "filingDate",
    "registrationDate",
    "statusCode",
    "statusDescription",
    "statusDate",
    "ownerName",
    "ownerNationalityState",
    "ownerNationalityStateName",
    "ownerNationalityCountry",
    "ownerAddressLine1",
    "ownerAddressLine2",
    "ownerAddressCity",
    "ownerAddressState",
    "ownerAddressPostalCode",
    "ownerPartyType",
    "ownerPartyTypeName",
    "markIdentification",
    "markDrawingCode",
    "markDrawingDescription",
    "publishedForOppositionDate",
    "attorneyDocketNumber",
    "attorneyName",
    "lawOfficeAssignedLocationCode",
    "lawOfficeAssignedLocationDescription",
    "currentLocation",
    "locationDate",
    "employeeName",
    "abandonmentDate",
    "cancellationCode",
    "cancellationDescription",
    "cancellationDate",
    "republished12CDate",
    "domesticRepresentativeName",
    "renewalDate",
    "lastTransactionDate",
    "caseFileHeaderFlagsXml",
    "caseFileOwnersXml",
    "caseFileStatementsXml",
    "caseFileEventStatementsXml",
    "priorRegistrationApplicationsXml",
    "classificationsXml",
    "correspondentXml",
    "madridInternationalFilingRequestsXml",
    "foreignApplicationsXml",
    "designSearchesXml",
    "internationalRegistrationXml",
    "lastUpdateDate",
    "relevanceScore"
})
public class Trademark {

    @XmlElement(name = "SerialNumber")
    protected int serialNumber;
    @XmlElement(name = "RegistrationNumber")
    protected int registrationNumber;
    @XmlElement(name = "FilingDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar filingDate;
    @XmlElement(name = "RegistrationDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar registrationDate;
    @XmlElement(name = "StatusCode")
    protected String statusCode;
    @XmlElement(name = "StatusDescription")
    protected String statusDescription;
    @XmlElement(name = "StatusDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar statusDate;
    @XmlElement(name = "OwnerName")
    protected String ownerName;
    @XmlElement(name = "OwnerNationalityState")
    protected String ownerNationalityState;
    @XmlElement(name = "OwnerNationalityStateName")
    protected String ownerNationalityStateName;
    @XmlElement(name = "OwnerNationalityCountry")
    protected String ownerNationalityCountry;
    @XmlElement(name = "OwnerAddressLine1")
    protected String ownerAddressLine1;
    @XmlElement(name = "OwnerAddressLine2")
    protected String ownerAddressLine2;
    @XmlElement(name = "OwnerAddressCity")
    protected String ownerAddressCity;
    @XmlElement(name = "OwnerAddressState")
    protected String ownerAddressState;
    @XmlElement(name = "OwnerAddressPostalCode")
    protected String ownerAddressPostalCode;
    @XmlElement(name = "OwnerPartyType")
    protected String ownerPartyType;
    @XmlElement(name = "OwnerPartyTypeName")
    protected String ownerPartyTypeName;
    @XmlElement(name = "MarkIdentification")
    protected String markIdentification;
    @XmlElement(name = "MarkDrawingCode")
    protected String markDrawingCode;
    @XmlElement(name = "MarkDrawingDescription")
    protected String markDrawingDescription;
    @XmlElement(name = "PublishedForOppositionDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar publishedForOppositionDate;
    @XmlElement(name = "AttorneyDocketNumber")
    protected String attorneyDocketNumber;
    @XmlElement(name = "AttorneyName")
    protected String attorneyName;
    @XmlElement(name = "LawOfficeAssignedLocationCode")
    protected String lawOfficeAssignedLocationCode;
    @XmlElement(name = "LawOfficeAssignedLocationDescription")
    protected String lawOfficeAssignedLocationDescription;
    @XmlElement(name = "CurrentLocation")
    protected String currentLocation;
    @XmlElement(name = "LocationDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar locationDate;
    @XmlElement(name = "EmployeeName")
    protected String employeeName;
    @XmlElement(name = "AbandonmentDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar abandonmentDate;
    @XmlElement(name = "CancellationCode")
    protected String cancellationCode;
    @XmlElement(name = "CancellationDescription")
    protected String cancellationDescription;
    @XmlElement(name = "CancellationDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar cancellationDate;
    @XmlElement(name = "Republished12cDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar republished12CDate;
    @XmlElement(name = "DomesticRepresentativeName")
    protected String domesticRepresentativeName;
    @XmlElement(name = "RenewalDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar renewalDate;
    @XmlElement(name = "LastTransactionDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastTransactionDate;
    @XmlElement(name = "CaseFileHeaderFlagsXml")
    protected String caseFileHeaderFlagsXml;
    @XmlElement(name = "CaseFileOwnersXml")
    protected String caseFileOwnersXml;
    @XmlElement(name = "CaseFileStatementsXml")
    protected String caseFileStatementsXml;
    @XmlElement(name = "CaseFileEventStatementsXml")
    protected String caseFileEventStatementsXml;
    @XmlElement(name = "PriorRegistrationApplicationsXml")
    protected String priorRegistrationApplicationsXml;
    @XmlElement(name = "ClassificationsXml")
    protected String classificationsXml;
    @XmlElement(name = "CorrespondentXml")
    protected String correspondentXml;
    @XmlElement(name = "MadridInternationalFilingRequestsXml")
    protected String madridInternationalFilingRequestsXml;
    @XmlElement(name = "ForeignApplicationsXml")
    protected String foreignApplicationsXml;
    @XmlElement(name = "DesignSearchesXml")
    protected String designSearchesXml;
    @XmlElement(name = "InternationalRegistrationXml")
    protected String internationalRegistrationXml;
    @XmlElement(name = "LastUpdateDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdateDate;
    @XmlElement(name = "RelevanceScore", required = true)
    protected BigDecimal relevanceScore;

    /**
     * Gets the value of the serialNumber property.
     * 
     */
    public int getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     * 
     */
    public void setSerialNumber(int value) {
        this.serialNumber = value;
    }

    /**
     * Gets the value of the registrationNumber property.
     * 
     */
    public int getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Sets the value of the registrationNumber property.
     * 
     */
    public void setRegistrationNumber(int value) {
        this.registrationNumber = value;
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
     * Gets the value of the registrationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets the value of the registrationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRegistrationDate(XMLGregorianCalendar value) {
        this.registrationDate = value;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCode(String value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the statusDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDescription() {
        return statusDescription;
    }

    /**
     * Sets the value of the statusDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDescription(String value) {
        this.statusDescription = value;
    }

    /**
     * Gets the value of the statusDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStatusDate() {
        return statusDate;
    }

    /**
     * Sets the value of the statusDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStatusDate(XMLGregorianCalendar value) {
        this.statusDate = value;
    }

    /**
     * Gets the value of the ownerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Sets the value of the ownerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerName(String value) {
        this.ownerName = value;
    }

    /**
     * Gets the value of the ownerNationalityState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerNationalityState() {
        return ownerNationalityState;
    }

    /**
     * Sets the value of the ownerNationalityState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerNationalityState(String value) {
        this.ownerNationalityState = value;
    }

    /**
     * Gets the value of the ownerNationalityStateName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerNationalityStateName() {
        return ownerNationalityStateName;
    }

    /**
     * Sets the value of the ownerNationalityStateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerNationalityStateName(String value) {
        this.ownerNationalityStateName = value;
    }

    /**
     * Gets the value of the ownerNationalityCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerNationalityCountry() {
        return ownerNationalityCountry;
    }

    /**
     * Sets the value of the ownerNationalityCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerNationalityCountry(String value) {
        this.ownerNationalityCountry = value;
    }

    /**
     * Gets the value of the ownerAddressLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerAddressLine1() {
        return ownerAddressLine1;
    }

    /**
     * Sets the value of the ownerAddressLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerAddressLine1(String value) {
        this.ownerAddressLine1 = value;
    }

    /**
     * Gets the value of the ownerAddressLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerAddressLine2() {
        return ownerAddressLine2;
    }

    /**
     * Sets the value of the ownerAddressLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerAddressLine2(String value) {
        this.ownerAddressLine2 = value;
    }

    /**
     * Gets the value of the ownerAddressCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerAddressCity() {
        return ownerAddressCity;
    }

    /**
     * Sets the value of the ownerAddressCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerAddressCity(String value) {
        this.ownerAddressCity = value;
    }

    /**
     * Gets the value of the ownerAddressState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerAddressState() {
        return ownerAddressState;
    }

    /**
     * Sets the value of the ownerAddressState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerAddressState(String value) {
        this.ownerAddressState = value;
    }

    /**
     * Gets the value of the ownerAddressPostalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerAddressPostalCode() {
        return ownerAddressPostalCode;
    }

    /**
     * Sets the value of the ownerAddressPostalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerAddressPostalCode(String value) {
        this.ownerAddressPostalCode = value;
    }

    /**
     * Gets the value of the ownerPartyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerPartyType() {
        return ownerPartyType;
    }

    /**
     * Sets the value of the ownerPartyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerPartyType(String value) {
        this.ownerPartyType = value;
    }

    /**
     * Gets the value of the ownerPartyTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerPartyTypeName() {
        return ownerPartyTypeName;
    }

    /**
     * Sets the value of the ownerPartyTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerPartyTypeName(String value) {
        this.ownerPartyTypeName = value;
    }

    /**
     * Gets the value of the markIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarkIdentification() {
        return markIdentification;
    }

    /**
     * Sets the value of the markIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarkIdentification(String value) {
        this.markIdentification = value;
    }

    /**
     * Gets the value of the markDrawingCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarkDrawingCode() {
        return markDrawingCode;
    }

    /**
     * Sets the value of the markDrawingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarkDrawingCode(String value) {
        this.markDrawingCode = value;
    }

    /**
     * Gets the value of the markDrawingDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarkDrawingDescription() {
        return markDrawingDescription;
    }

    /**
     * Sets the value of the markDrawingDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarkDrawingDescription(String value) {
        this.markDrawingDescription = value;
    }

    /**
     * Gets the value of the publishedForOppositionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPublishedForOppositionDate() {
        return publishedForOppositionDate;
    }

    /**
     * Sets the value of the publishedForOppositionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPublishedForOppositionDate(XMLGregorianCalendar value) {
        this.publishedForOppositionDate = value;
    }

    /**
     * Gets the value of the attorneyDocketNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttorneyDocketNumber() {
        return attorneyDocketNumber;
    }

    /**
     * Sets the value of the attorneyDocketNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttorneyDocketNumber(String value) {
        this.attorneyDocketNumber = value;
    }

    /**
     * Gets the value of the attorneyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttorneyName() {
        return attorneyName;
    }

    /**
     * Sets the value of the attorneyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttorneyName(String value) {
        this.attorneyName = value;
    }

    /**
     * Gets the value of the lawOfficeAssignedLocationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLawOfficeAssignedLocationCode() {
        return lawOfficeAssignedLocationCode;
    }

    /**
     * Sets the value of the lawOfficeAssignedLocationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLawOfficeAssignedLocationCode(String value) {
        this.lawOfficeAssignedLocationCode = value;
    }

    /**
     * Gets the value of the lawOfficeAssignedLocationDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLawOfficeAssignedLocationDescription() {
        return lawOfficeAssignedLocationDescription;
    }

    /**
     * Sets the value of the lawOfficeAssignedLocationDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLawOfficeAssignedLocationDescription(String value) {
        this.lawOfficeAssignedLocationDescription = value;
    }

    /**
     * Gets the value of the currentLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentLocation() {
        return currentLocation;
    }

    /**
     * Sets the value of the currentLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentLocation(String value) {
        this.currentLocation = value;
    }

    /**
     * Gets the value of the locationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLocationDate() {
        return locationDate;
    }

    /**
     * Sets the value of the locationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLocationDate(XMLGregorianCalendar value) {
        this.locationDate = value;
    }

    /**
     * Gets the value of the employeeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Sets the value of the employeeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeName(String value) {
        this.employeeName = value;
    }

    /**
     * Gets the value of the abandonmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAbandonmentDate() {
        return abandonmentDate;
    }

    /**
     * Sets the value of the abandonmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAbandonmentDate(XMLGregorianCalendar value) {
        this.abandonmentDate = value;
    }

    /**
     * Gets the value of the cancellationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancellationCode() {
        return cancellationCode;
    }

    /**
     * Sets the value of the cancellationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancellationCode(String value) {
        this.cancellationCode = value;
    }

    /**
     * Gets the value of the cancellationDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancellationDescription() {
        return cancellationDescription;
    }

    /**
     * Sets the value of the cancellationDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancellationDescription(String value) {
        this.cancellationDescription = value;
    }

    /**
     * Gets the value of the cancellationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCancellationDate() {
        return cancellationDate;
    }

    /**
     * Sets the value of the cancellationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCancellationDate(XMLGregorianCalendar value) {
        this.cancellationDate = value;
    }

    /**
     * Gets the value of the republished12CDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRepublished12CDate() {
        return republished12CDate;
    }

    /**
     * Sets the value of the republished12CDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRepublished12CDate(XMLGregorianCalendar value) {
        this.republished12CDate = value;
    }

    /**
     * Gets the value of the domesticRepresentativeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomesticRepresentativeName() {
        return domesticRepresentativeName;
    }

    /**
     * Sets the value of the domesticRepresentativeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomesticRepresentativeName(String value) {
        this.domesticRepresentativeName = value;
    }

    /**
     * Gets the value of the renewalDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRenewalDate() {
        return renewalDate;
    }

    /**
     * Sets the value of the renewalDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRenewalDate(XMLGregorianCalendar value) {
        this.renewalDate = value;
    }

    /**
     * Gets the value of the lastTransactionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastTransactionDate() {
        return lastTransactionDate;
    }

    /**
     * Sets the value of the lastTransactionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastTransactionDate(XMLGregorianCalendar value) {
        this.lastTransactionDate = value;
    }

    /**
     * Gets the value of the caseFileHeaderFlagsXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseFileHeaderFlagsXml() {
        return caseFileHeaderFlagsXml;
    }

    /**
     * Sets the value of the caseFileHeaderFlagsXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseFileHeaderFlagsXml(String value) {
        this.caseFileHeaderFlagsXml = value;
    }

    /**
     * Gets the value of the caseFileOwnersXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseFileOwnersXml() {
        return caseFileOwnersXml;
    }

    /**
     * Sets the value of the caseFileOwnersXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseFileOwnersXml(String value) {
        this.caseFileOwnersXml = value;
    }

    /**
     * Gets the value of the caseFileStatementsXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseFileStatementsXml() {
        return caseFileStatementsXml;
    }

    /**
     * Sets the value of the caseFileStatementsXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseFileStatementsXml(String value) {
        this.caseFileStatementsXml = value;
    }

    /**
     * Gets the value of the caseFileEventStatementsXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseFileEventStatementsXml() {
        return caseFileEventStatementsXml;
    }

    /**
     * Sets the value of the caseFileEventStatementsXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseFileEventStatementsXml(String value) {
        this.caseFileEventStatementsXml = value;
    }

    /**
     * Gets the value of the priorRegistrationApplicationsXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriorRegistrationApplicationsXml() {
        return priorRegistrationApplicationsXml;
    }

    /**
     * Sets the value of the priorRegistrationApplicationsXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriorRegistrationApplicationsXml(String value) {
        this.priorRegistrationApplicationsXml = value;
    }

    /**
     * Gets the value of the classificationsXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassificationsXml() {
        return classificationsXml;
    }

    /**
     * Sets the value of the classificationsXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassificationsXml(String value) {
        this.classificationsXml = value;
    }

    /**
     * Gets the value of the correspondentXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrespondentXml() {
        return correspondentXml;
    }

    /**
     * Sets the value of the correspondentXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrespondentXml(String value) {
        this.correspondentXml = value;
    }

    /**
     * Gets the value of the madridInternationalFilingRequestsXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMadridInternationalFilingRequestsXml() {
        return madridInternationalFilingRequestsXml;
    }

    /**
     * Sets the value of the madridInternationalFilingRequestsXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMadridInternationalFilingRequestsXml(String value) {
        this.madridInternationalFilingRequestsXml = value;
    }

    /**
     * Gets the value of the foreignApplicationsXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForeignApplicationsXml() {
        return foreignApplicationsXml;
    }

    /**
     * Sets the value of the foreignApplicationsXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForeignApplicationsXml(String value) {
        this.foreignApplicationsXml = value;
    }

    /**
     * Gets the value of the designSearchesXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesignSearchesXml() {
        return designSearchesXml;
    }

    /**
     * Sets the value of the designSearchesXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesignSearchesXml(String value) {
        this.designSearchesXml = value;
    }

    /**
     * Gets the value of the internationalRegistrationXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternationalRegistrationXml() {
        return internationalRegistrationXml;
    }

    /**
     * Sets the value of the internationalRegistrationXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternationalRegistrationXml(String value) {
        this.internationalRegistrationXml = value;
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

}
