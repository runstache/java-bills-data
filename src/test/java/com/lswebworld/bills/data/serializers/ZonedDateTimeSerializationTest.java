package com.lswebworld.bills.data.serializers;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lswebworld.bills.data.dataobjects.BillInfo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import org.junit.jupiter.api.Test;

class ZonedDateTimeSerializationTest {
  private static final String JSON_FILE = "bill-info.json";
  private static final String OUTPUT_FILE = "bill-info-output.json";

  @Test
  void testSerilalizeZonedDateTime() throws IOException {
    var loader = getClass().getClassLoader();
    String json = Files.readString(
            Path.of(Objects.requireNonNull(loader.getResource(JSON_FILE)).getFile()));

    var bill = new ObjectMapper().readValue(json, BillInfo.class);
    assertThat(bill.getPubDate()).as("Pub Date should not be null").isNotNull();

    var zdt = ZonedDateTime.of(2022, 7, 1, 15, 40, 23, 0, ZoneId.of("GMT"));
    assertThat(bill.getPubDate()).as("7/1/2022 15:40:23 GMT").isEqualTo(zdt);

  }

  @Test
  void testDeserializeZonedDateTime() throws IOException {
    var loader = getClass().getClassLoader();
    String json = Files.readString(
            Path.of(Objects.requireNonNull(loader.getResource(OUTPUT_FILE)).getFile()));

    var bill = new BillInfo();
    bill.setDescription("Bill for Testing");
    bill.setCoSponsors("AUMENT, PHILLIPS-HILL");
    bill.setEnacted(true);
    bill.setIdentifier("20220HB1002");
    bill.setLastAction("Presented to the Governor, July 1, 2022");
    bill.setPassedHouse(true);
    bill.setPassedSenate(true);
    bill.setPrimeSponsors("REP SMITH");
    bill.setTitle("My Bill");
    //Fri, 01 Jul 2022 15:40:23 GMT
    bill.setPubDate(ZonedDateTime.of(2022, 7, 1, 15, 40, 23, 0, ZoneId.of("GMT")));
    bill.setUrl("http://www.example.com");

    var result = new ObjectMapper().writeValueAsString(bill);
    assertThat(result).contains("Fri, 01 Jul 2022 15:40:23 GMT");

  }
}
