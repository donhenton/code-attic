
package com.dhenton9000.football.generated;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AllMidFieldsResult" type="{http://footballpool.dataaccess.eu}ArrayOfString"/>
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
    "allMidFieldsResult"
})
@XmlRootElement(name = "AllMidFieldsResponse")
public class AllMidFieldsResponse {

    @XmlElement(name = "AllMidFieldsResult", required = true)
    protected ArrayOfString allMidFieldsResult;

    /**
     * Gets the value of the allMidFieldsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getAllMidFieldsResult() {
        return allMidFieldsResult;
    }

    /**
     * Sets the value of the allMidFieldsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setAllMidFieldsResult(ArrayOfString value) {
        this.allMidFieldsResult = value;
    }

}
