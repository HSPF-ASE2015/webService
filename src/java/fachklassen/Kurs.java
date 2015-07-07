package fachklassen;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
    @NamedQuery(name="getAllKurse", query="Select k from Kurs k")
 })
@XmlRootElement
public class Kurs implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long kursId;
    
    @Basic
    private int ects;
    @Basic
    private String name;
    @Basic
    private String sprache;

    public Kurs() {

    }
    
    public Kurs(int Ects, String Name, String Sprache){
        this.ects = Ects;
        this.name = Name;
        this.sprache = Sprache;
    }
   
    public int getEcts() {
        return this.ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }
   
    public Long getKursId() {
        return this.kursId;
    }

    public void setKursId(Long kursId) {
        this.kursId = kursId;
    }
   
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
    public String getSprache() {
        return this.sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }
}
