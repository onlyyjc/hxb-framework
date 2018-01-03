package com.hxb.core.common.mapper.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class BigDecimalSerializer  extends JsonSerializer<BigDecimal> {

	@Override
	public void serialize(BigDecimal decimal, JsonGenerator gen,
			SerializerProvider serializers) throws IOException,JsonProcessingException {
		if(decimal!=null){
			String value = decimal.toPlainString();
			gen.writeString(value);			
		}
	}

}
