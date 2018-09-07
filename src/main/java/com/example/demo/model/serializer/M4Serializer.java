package com.example.demo.model.serializer;

import java.io.IOException;

import com.example.demo.model.M3;
import com.example.demo.model.M4;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class M4Serializer extends StdSerializer<M4> {
   
    public M4Serializer() {
        super(M4.class);
    }

	@Override
	public void serialize(M4 value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeNumberField("id", value.getId());
		gen.writeStringField("attM4", value.getAttM4());
		
		if (!EntitySerializerReferencer.getInstance().isDeepStop(value.getM3s())) {
			gen.writeObjectField("m3s", value.getM3s());
		}
		if (!EntitySerializerReferencer.getInstance().isDeepStop(value.getM3ss())) {
			gen.writeObjectField("m3ss", value.getM3ss());
		}
		
		gen.writeEndObject();
	}
}
