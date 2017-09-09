package org.sybez.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sybez.dao.entity.Maker;
import org.sybez.dao.repository.MakerRepository;
import org.sybez.service.editor.AllNamesEditor;

@Service
public class MakerService implements InterfaseForDbServices<Maker> {

	@Autowired
	private MakerRepository makerRepository;

	public List<Maker> getAll() {
		return makerRepository.findAll();
	}

	public Maker getById(int id) {
		return makerRepository.getOne(id);
	}

	public Maker addNew(Maker item) {
		Maker newMaker = makerRepository.save(item);
		return newMaker;
	}

	public void deleteById(int id) {
		makerRepository.delete(id);
	}

	public void updateItem(Maker t) {
		makerRepository.save(t);
	}

	public Maker saveMaker(String name) {
		Maker maker = makerRepository.findByName(name);
		if (maker == null) {
			maker = new Maker();
			maker.setMakerName(AllNamesEditor.toFirstCapitalLetter(name));
			
		}
		makerRepository.save(maker);
		return maker;
	}
}
