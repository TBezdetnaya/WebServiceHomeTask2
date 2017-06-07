
package convertSpeedService;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConvertSpeedResult" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "convertSpeedResult"
})
@XmlRootElement(name = "ConvertSpeedResponse")
public class ConvertSpeedResponse {

    @XmlElement(name = "ConvertSpeedResult")
    protected double convertSpeedResult;

    /**
     * Gets the value of the convertSpeedResult property.
     * 
     */
    public double getConvertSpeedResult() {
        return convertSpeedResult;
    }

    /**
     * Sets the value of the convertSpeedResult property.
     * 
     */
    public void setConvertSpeedResult(double value) {
        this.convertSpeedResult = value;
    }

}
