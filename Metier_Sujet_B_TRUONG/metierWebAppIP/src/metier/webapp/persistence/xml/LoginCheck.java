//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.23 at 11:11:19 PM CEST 
//


package metier.webapp.persistence.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;/sequence>
 *       &lt;attribute name="pseudo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="password">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="8"/>
 *             &lt;maxLength value="16"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="ipLogin" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="idSession" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "LoginCheck", namespace = "http://www.pds2015.org/P2M")
public class LoginCheck {

    @XmlAttribute(name = "pseudo")
    protected String pseudo;
    @XmlAttribute(name = "password")
    protected String password;
    @XmlAttribute(name = "ipLogin")
    protected String ipLogin;
    @XmlAttribute(name = "idSession")
    protected String idSession;

    /**
     * Gets the value of the pseudo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Sets the value of the pseudo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPseudo(String value) {
        this.pseudo = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the ipLogin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpLogin() {
        return ipLogin;
    }

    /**
     * Sets the value of the ipLogin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpLogin(String value) {
        this.ipLogin = value;
    }

    /**
     * Gets the value of the idSession property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSession() {
        return idSession;
    }

    /**
     * Sets the value of the idSession property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSession(String value) {
        this.idSession = value;
    }

}
