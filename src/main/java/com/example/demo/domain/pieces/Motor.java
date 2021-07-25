package com.example.demo.domain.pieces;

public class Motor {
	
	private Long id;
	private Boolean on = false;
	
	public Motor() {}

	public Motor(Long id) {

		this.id = id;
	}

	public Motor(Long id, Boolean on) {

		this.id = id;
		this.on = on;
	}
	
	public void start () {
		this.on = true;
	}

	public Long getId() {
		return id;
	}

	public Boolean getOn() {
		return on;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOn(Boolean on) {
		this.on = on;
	}

	@Override
	public String toString() {
		return "Motor [id=" + id + ", on=" + on + "]";
	}
	

}
