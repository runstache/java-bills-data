package com.lswebworld.bills.data.dataobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "related_files")
@JsonPropertyOrder(alphabetic = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RelatedFileInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @JsonProperty("id")
  private long id;

  @Column(name = "identifier")
  @JsonProperty("identifier")
  private String identifier;

  @Column(name = "file_data")
  @JsonProperty("fileData")
  private byte[] fileDate;

  @Column(name = "file_type")
  @JsonProperty("fileType")
  private String fileType;

  @Column(name = "created_on")
  @JsonProperty("createdOn")
  private ZonedDateTime createdOn;

  @Column(name = "updated_on")
  @JsonProperty("updatedOn")
  private ZonedDateTime updatedOn;

}
