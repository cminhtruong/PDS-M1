//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.23 at 11:20:58 PM CEST 
//


package metier.webapp.presentation.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element ref="{}description" minOccurs="0"/>
 *         &lt;element ref="{}value" maxOccurs="unbounded"/>
 *         &lt;element ref="{}description" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="boolean"/>
 *             &lt;enumeration value="image"/>
 *             &lt;enumeration value="integer"/>
 *             &lt;enumeration value="text"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="category">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="about"/>
 *             &lt;enumeration value="browserCheck"/>
 *             &lt;enumeration value="chooseLanguage"/>
 *             &lt;enumeration value="default"/>
 *             &lt;enumeration value="delivery"/>
 *             &lt;enumeration value="end"/>
 *             &lt;enumeration value="error"/>
 *             &lt;enumeration value="feedback"/>
 *             &lt;enumeration value="language"/>
 *             &lt;enumeration value="launchQS"/>
 *             &lt;enumeration value="list"/>
 *             &lt;enumeration value="login"/>
 *             &lt;enumeration value="qm2Go"/>
 *             &lt;enumeration value="question"/>
 *             &lt;enumeration value="status"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="styletype">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="fontsize"/>
 *             &lt;enumeration value="contrast"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="translate">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "entry")
public class Entry {

    @XmlElementRefs({
        @XmlElementRef(name = "description", type = Description.class, required = false),
        @XmlElementRef(name = "value", type = Value.class, required = false)
    })
    protected List<Object> content;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "category")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String category;
    @XmlAttribute(name = "styletype")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String styletype;
    @XmlAttribute(name = "translate")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String translate;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Description" is used by two different parts of a schema. See: 
     * line 48 of file:/C:/Users/Davide/J2EE/metierWebAppIP/Schema/sujet.xsd
     * line 46 of file:/C:/Users/Davide/J2EE/metierWebAppIP/Schema/sujet.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Value }
     * {@link Description }
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the styletype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyletype() {
        return styletype;
    }

    /**
     * Sets the value of the styletype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyletype(String value) {
        this.styletype = value;
    }

    /**
     * Gets the value of the translate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranslate() {
        return translate;
    }

    /**
     * Sets the value of the translate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranslate(String value) {
        this.translate = value;
    }

}
