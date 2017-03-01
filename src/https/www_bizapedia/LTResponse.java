
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
 *         &lt;element name="LTResult" type="{https://www.bizapedia.com/}TrademarkList" minOccurs="0"/&gt;
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
    "ltResult"
})
@XmlRootElement(name = "LTResponse")
public class LTResponse {

    @XmlElement(name = "LTResult")
    protected TrademarkList ltResult;

    /**
     * Gets the value of the ltResult property.
     * 
     * @return
     *     possible object is
     *     {@link TrademarkList }
     *     
     */
    public TrademarkList getLTResult() {
        return ltResult;
    }

    /**
     * Sets the value of the ltResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrademarkList }
     *     
     */
    public void setLTResult(TrademarkList value) {
        this.ltResult = value;
    }

}
