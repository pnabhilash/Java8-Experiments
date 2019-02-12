package app.datasets.beans;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ADRequestMetaData {

  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("processId")
  @Expose
  private String processId;
  @SerializedName("processName")
  @Expose
  private String processName;
  @SerializedName("cooksRequestObj")
  @Expose
  private String cooksRequestObj;
  @SerializedName("reqColumns")
  @Expose
  private List<ReqColumn> reqColumns = null;

  /**
   * No args constructor for use in serialization
   *
   */
  public ADRequestMetaData() {
  }

  /**
   *
   * @param id
   * @param processId
   * @param processName
   * @param cooksRequestObj
   * @param reqColumns
   */
  public ADRequestMetaData(Integer id, String processId, String processName,
      String cooksRequestObj, List<ReqColumn> reqColumns) {
    super();
    this.id = id;
    this.processId = processId;
    this.processName = processName;
    this.cooksRequestObj = cooksRequestObj;
    this.reqColumns = reqColumns;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProcessId() {
    return processId;
  }

  public void setProcessId(String processId) {
    this.processId = processId;
  }

  public String getProcessName() {
    return processName;
  }

  public void setProcessName(String processName) {
    this.processName = processName;
  }

  public String getCooksRequestObj() {
    return cooksRequestObj;
  }

  public void setCooksRequestObj(String cooksRequestObj) {
    this.cooksRequestObj = cooksRequestObj;
  }

  public List<ReqColumn> getReqColumns() {
    return reqColumns;
  }

  public void setReqColumns(List<ReqColumn> reqColumns) {
    this.reqColumns = reqColumns;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("id", id).append("processId", processId).append("processName", processName).append("cooksRequestObj", cooksRequestObj).append("reqColumns", reqColumns).toString();
  }

}
