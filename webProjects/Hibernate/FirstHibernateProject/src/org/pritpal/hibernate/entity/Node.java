package org.pritpal.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Node {
	
@Column (name = "VALUE")
private String nodeValue;
@Column (name = "DESCRIPTION")
private String nodeDescription;

public String getNodeValue() {
	return nodeValue;
}
public void setNodeValue(String nodeValue) {
	this.nodeValue = nodeValue;
}
public String getNodeDescription() {
	return nodeDescription;
}
public void setNodeDescription(String nodeDescription) {
	this.nodeDescription = nodeDescription;
}


}
