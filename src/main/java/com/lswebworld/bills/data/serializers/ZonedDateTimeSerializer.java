package com.lswebworld.bills.data.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeSerializer extends StdSerializer<ZonedDateTime> {

  private static final DateTimeFormatter DATE_TIME_FORMAT =
          DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss zzz");

  public ZonedDateTimeSerializer() {
    this(null);
  }

  public ZonedDateTimeSerializer(Class<ZonedDateTime> clazz) {
    super(clazz);
  }


  @Override
  public void serialize(ZonedDateTime zonedDateTime,
                        JsonGenerator jsonGenerator,
                        SerializerProvider serializerProvider) throws IOException {
    jsonGenerator.writeString(DATE_TIME_FORMAT.format(zonedDateTime));


  }
}
