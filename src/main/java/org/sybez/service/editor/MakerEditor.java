package org.sybez.service.editor;

import java.beans.PropertyEditorSupport;

import org.sybez.dao.entity.Maker;
import org.sybez.dao.service.MakerService;

public class MakerEditor extends PropertyEditorSupport{
	
	private final MakerService makerService;
	
	public MakerEditor(MakerService makerService){
		this.makerService = makerService;
	}

public void setAsText(String text) throws IllegalArgumentException{
	System.out.println("setAsTextMaker");
	Maker maker = makerService.getById(Integer.parseInt(text));
	setValue(maker);
}
	
}
