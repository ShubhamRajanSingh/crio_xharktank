package com.xharktank.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class Offer {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@NotNull
	@Column(name = "investor",nullable=false)
	private String investor;
	
	@NotNull
	@Column(name = "amount",nullable=false)
	private float amount;
	
	@NotNull
	@Column(name = "equity",nullable=false)
	private float equity;
	

	@Column(name = "comment")
	private String comment;
	
	@NotNull
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pitch_id",referencedColumnName="id")
	private Pitche pitchId;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInvestor() {
		return investor;
	}

	public void setInvestor(String investor) {
		this.investor = investor;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getEquity() {
		return equity;
	}

	public void setEquity(float equity) {
		this.equity = equity;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Pitche getPitchId() {
		return pitchId;
	}

	public void setPitchId(Pitche pitchId) {
		this.pitchId = pitchId;
	}
}

