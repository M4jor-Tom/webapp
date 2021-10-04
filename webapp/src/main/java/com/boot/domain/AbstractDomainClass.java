package com.boot.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import javax.persistence.Id;

@MappedSuperclass
abstract public class AbstractDomainClass implements DomainObject {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private Date dateCreated;
    private Date lastUpdated;
    
    public AbstractDomainClass()
    {
    	super();
    }

    private AbstractDomainClass(Integer id, Integer version, Date dateCreated, Date lastUpdated) {
		super();
		setId(id);
		setVersion(version);
		setDateCreated(dateCreated);
		setLastUpdated(lastUpdated);
	}

	@Override
    public Integer getId() {
        return this.id;
    }

	@Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    private void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

    public Date getLastUpdated() {
        return lastUpdated;
    }

	private void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

    //Insures that the date is updated at each UPDATE command on database
    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        setLastUpdated(new Date());
        if (getDateCreated() == null) {
            setDateCreated(new Date());
        }
    }
}