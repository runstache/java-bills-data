package com.lswebworld.bills.data.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

public class BooleanSerializer extends StdSerializer<Boolean> {

  public BooleanSerializer() {
    this(null);
  }

  public BooleanSerializer(Class<Boolean> clazz) {
    super(clazz);
  }

  @Override
  public void serialize(Boolean value,
                        JsonGenerator jsonGenerator,
                        SerializerProvider serializerProvider) throws IOException {
    jsonGenerator.writeBoolean(value);
  }
}
