package com.example.demo.model.serializer;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class EntitySerializerReferencer {

	private EntitySerializerReferencer() {
		this.itemChecker = new HashMap<Object, HashMap<Object, Integer>>();
	}

	private static EntitySerializerReferencer INSTANCE = null;

	public static synchronized EntitySerializerReferencer getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EntitySerializerReferencer();
		}
		return INSTANCE;
	}

	private Integer maxDeep = 1;

	public Integer getMaxDeep() {
		return maxDeep;
	}

	public void setMaxDeep(Integer maxDeep) {
		this.maxDeep = maxDeep;
	}

	/////////////////////////////////////////
	// Model deep reference ocurence check //
	/////////////////////////////////////////
	private HashMap<Object, HashMap<Object, Integer>> itemChecker;

	public HashMap<Object, HashMap<Object, Integer>> getItemChecker() {
		return itemChecker;
	}

	public void setItemChecker(HashMap<Object, HashMap<Object, Integer>> itemChecker) {
		this.itemChecker = itemChecker;
	}

	public void insertRootObject(final Object rootObject) {
		if (rootObject != null) {
			if (!itemChecker.containsKey(rootObject)) {
				itemChecker.put(rootObject, new HashMap<Object, Integer>());
			}}
	}
	
	public Boolean isDeepStop(final Object rootObject, final Object subObject) {
		Boolean result = false;

			if (subObject != null) {
				if (itemChecker.containsKey(rootObject)) {
					if (!itemChecker.get(rootObject).containsKey(subObject)) {
						itemChecker.get(rootObject).put(subObject, 0);
					}
				}

				for (Entry<Object, Integer> iterable_element : itemChecker.get(rootObject).entrySet()) {
					if (subObject.equals(iterable_element.getKey())) {

						if (iterable_element.getValue() >= maxDeep) {
							result = true;
							break;
						}

						iterable_element.setValue(iterable_element.getValue() + 1);
					}
				}
		}
		return result;
	}
}
