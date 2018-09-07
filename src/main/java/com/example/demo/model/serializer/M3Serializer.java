package com.example.demo.model.serializer;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.example.demo.model.M3;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class M3Serializer extends StdSerializer<M3> {

	public M3Serializer() {
		super(M3.class);
	}

	@Override
	public void serialize(M3 value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		EntitySerializerReferencer.getInstance().insertRootObject(value);
		
		gen.writeStartObject();
		gen.writeNumberField("id", value.getId());
		gen.writeStringField("att1", value.getAtt1());

		if (value != null && !EntitySerializerReferencer.getInstance().isDeepStop(value, value.getM3())) {
			gen.writeObjectField("m3", value.getM3());
		}
		if (value != null && !EntitySerializerReferencer.getInstance().isDeepStop(value, value.getM3())) {
			gen.writeObjectField("m4", value.getM4());
		}
		if (value != null && !EntitySerializerReferencer.getInstance().isDeepStop(value, value.getM3())) {
			gen.writeObjectField("m4s", value.getM4s());
		}

		gen.writeEndObject();
	}
}
