
package https.www_bizapedia;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CompanyPrincipal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompanyPrincipal"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Principal" type="{https://www.bizapedia.com/}Principal" minOccurs="0"/&gt;
 *         &lt;element name="Company" type="{https://www.bizapedia.com/}Company" minOccurs="0"/&gt;
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
@XmlType(name = "CompanyPrincipal", propOrder = {
    "principal",
    "company",
    "relevanceScore"
})
public class CompanyPrincipal {

    @XmlElement(name = "Principal")
    protected Principal principal;
    @XmlElement(name = "Company")
    protected Company company;
    @XmlElement(name = "RelevanceScore", required = true)
    protected BigDecimal relevanceScore;

    /**
     * Gets the value of the principal property.
     * 
     * @return
     *     possible object is
     *     {@link Principal }
     *     
     */
    public Principal getPrincipal() {
        return principal;
    }

    /**
     * Sets the value of the principal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Principal }
     *     
     */
    public void setPrincipal(Principal value) {
        this.principal = value;
    }

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link Company }
     *     
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link Company }
     *     
     */
    public void setCompany(Company value) {
        this.company = value;
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
