package cn.annpeter.insurance.entities.configs;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@Component
@XmlRootElement(name="navigaters")
public class Navigaters {
	List<Navigater> navigater;
	Navigater parent = null;

	public List<Navigater> getNavigater() {
		if (navigater == null) {  
			navigater = new ArrayList<Navigater>();  
        } 
		return navigater;
	}

	public void setNavigater(List<Navigater> navigater) {
		this.navigater = navigater;
	}

	
	
	public Navigater getParent() {
		return parent;
	}

	public void setParent(Navigater parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "NavigaterList [navigater=" + navigater + "]";
	}

}
