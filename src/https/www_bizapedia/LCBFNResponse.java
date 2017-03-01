
package https.www_bizapedia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LCBFNResult" type="{https://www.bizapedia.com/}Company" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "lcbfnResult"
})
@XmlRootElement(name = "LCBFNResponse")
public class LCBFNResponse {

    @XmlElement(name = "LCBFNResult")
    protected Company lcbfnResult;

    /**
     * Gets the value of the lcbfnResult property.
     * 
     * @return
     *     possible object is
     *     {@link Company }
     *     
     */
    public Company getLCBFNResult() {
        return lcbfnResult;
    }

    /**
     * Sets the value of the lcbfnResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Company }
     *     
     */
    public void setLCBFNResult(Company value) {
        this.lcbfnResult = value;
    }

}
