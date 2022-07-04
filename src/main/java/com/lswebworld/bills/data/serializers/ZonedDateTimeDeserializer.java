package com.lswebworld.bills.data.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.StringUtils;

public class ZonedDateTimeDeserializer extends StdDeserializer<ZonedDateTime> {

  public ZonedDateTimeDeserializer() {
    this(null);
  }

  public ZonedDateTimeDeserializer(Class<ZonedDateTime> clazz) {
    super(clazz);
  }

  private static final DateTimeFormatter DATE_TIME_FORMAT =
          DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss zzz");

  @Override
  public ZonedDateTime deserialize(JsonParser jsonParser,
                                   DeserializationContext deserializationContext)
          throws IOException {

    JsonNode node = jsonParser.getCodec().readTree(jsonParser);
    String zonedDateTimeString = node.textValue();
    if (StringUtils.isNotEmpty(zonedDateTimeString)) {
      return ZonedDateTime.parse(zonedDateTimeString, DATE_TIME_FORMAT);
    }
    return null;
  }
}
