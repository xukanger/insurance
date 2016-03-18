package cn.annpeter.insurance.entities.configs;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;

@Component
@XmlRootElement(name="navigater")
public class Navigater {
	private String title;
	private String action;
	private String method;
	private String img;
	private String desc;
	private Navigaters navigaters;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Navigaters getNavigaters() {
		return navigaters;
	}
	public void setNavigaters(Navigaters navigaters) {
		this.navigaters = navigaters;
		if(navigaters == null){
			this.navigaters.parent = this;
		}
		this.navigaters.parent = this;
	}
	@Override
	public String toString() {
		return "Navigater [title=" + title + ", action=" + action + ", method=" + method + ", img=" + img + ", desc="
				+ desc + ", navigaters=" + navigaters + "]";
	}
	
}
